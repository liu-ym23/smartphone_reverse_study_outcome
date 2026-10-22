package com.ss.ttvideoengine.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class HeadsetStateMonitor {
    private static final int MASK_WIRED = 1;
    private static final int MASK_WIRELESS = 2;
    private static final int STATE_NOTHING_CONNECTED = 0;
    private static final int STATE_UNINITIALIZED = 65280;
    private static final String TAG = "HeadsetStateMonitor";
    private static HeadsetStateMonitor sInstance;
    private final List<HeadsetStateChangedListener> mChangeListener;
    private final Context mContext;
    private final Handler mHandler;
    private HeadsetReceiver mHeadsetReceiver;
    private volatile int mHeadsetState;
    private volatile boolean mIsStarted;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.log.HeadsetStateMonitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class HeadsetReceiver extends BroadcastReceiver {
        final /* synthetic */ HeadsetStateMonitor this$0;

        public static /* synthetic */ void a(HeadsetReceiver r100) {
            r100.lambda$onReceive$3();
        }

        public static /* synthetic */ void b(HeadsetReceiver r100) {
            r100.lambda$onReceive$0();
        }

        public static /* synthetic */ void c(HeadsetReceiver r100) {
            r100.lambda$onReceive$2();
        }

        public static /* synthetic */ void d(HeadsetReceiver r100) {
            r100.lambda$onReceive$1();
        }

        private /* synthetic */ void lambda$onReceive$0() {
            HeadsetStateMonitor.access$400(this.this$0, 1);
        }

        private /* synthetic */ void lambda$onReceive$1() {
            HeadsetStateMonitor.access$300(this.this$0, 1);
        }

        private /* synthetic */ void lambda$onReceive$2() {
            HeadsetStateMonitor.access$400(this.this$0, 2);
        }

        private /* synthetic */ void lambda$onReceive$3() {
            HeadsetStateMonitor.access$300(this.this$0, 2);
        }

        private HeadsetReceiver(HeadsetStateMonitor r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ HeadsetReceiver(HeadsetStateMonitor r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (TextUtils.isEmpty(r101.getAction()) == true) goto L28;
            TTVideoEngineLog.d(HeadsetStateMonitor.TAG, "onReceive: " + r101.getAction());
            String r102 = r101.getAction();
            r102.getClass();
            if (r102.equals("android.intent.action.HEADSET_PLUG") == false) goto L9;
            int r103 = r101.getIntExtra("state", -1);
            if (r103 != 1) goto L19;
            HeadsetStateMonitor.access$200(HeadsetStateMonitor.access$100(this.this$0), new g(this));
            return;
        L19:
            if (r103 != 0) goto L27;
            HeadsetStateMonitor.access$200(HeadsetStateMonitor.access$100(this.this$0), new h(this));
            return;
        L27:
            return;
        L9:
            if (r102.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L29;
            int r104 = r101.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            if (r104 != 2) goto L14;
            HeadsetStateMonitor.access$200(HeadsetStateMonitor.access$100(this.this$0), new i(this));
            return;
        L14:
            if (r104 != 0) goto L24;
            HeadsetStateMonitor.access$200(HeadsetStateMonitor.access$100(this.this$0), new j(this));
            return;
        L24:
            return;
        L29:
            return;
        }
    }

    public interface HeadsetStateChangedListener {
        void onHeadsetStateChanged(boolean r100, boolean r101);
    }

    public static /* synthetic */ void a(HeadsetStateMonitor r100) {
        r100.lambda$start$0();
    }

    public static /* synthetic */ void b(HeadsetStateMonitor r100, HeadsetStateChangedListener r101) {
        r100.lambda$addStateChangedListener$1(r101);
    }

    public static /* synthetic */ void c(HeadsetStateMonitor r100, HeadsetStateChangedListener r101) {
        r100.lambda$removeStateChangedListener$2(r101);
    }

    private /* synthetic */ void lambda$start$0() {
        this.mHeadsetState = getHeadsetState(this.mContext);
    }

    public boolean isWiredConnected() {
        if (this.mHeadsetState != 65280) goto L6;
        this.mHeadsetState = getHeadsetState(this.mContext);
    L6:
        if ((this.mHeadsetState & 1) != 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isWirelessConnected() {
        if (this.mHeadsetState != 65280) goto L6;
        this.mHeadsetState = getHeadsetState(this.mContext);
    L6:
        if ((this.mHeadsetState & 2) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        this.mIsStarted = true;
        EngineThreadPool.addExecuteTask(new e(this));
        if (this.mHeadsetReceiver != null) goto L9;
        registerBroadcastReceiver(this.mContext);
        return;
    }

    public void stop() {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        this.mIsStarted = false;
        unregisterBroadcastReceiver(this.mContext);
    }

    private HeadsetStateMonitor(Context r100) {
        this.mChangeListener = new ArrayList();
        this.mHeadsetState = 65280;
        this.mContext = r100.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$100(HeadsetStateMonitor r100) {
        return r100.mHandler;
    }

    private void addListenerInternal(HeadsetStateChangedListener r100) {
        if (r100 != null) goto L4;
    L6:
        TTVideoEngineLog.d(TAG, "listener: " + this.mChangeListener.size());
        return;
    L4:
        if (this.mChangeListener.contains(r100) == true) goto L6;
        this.mChangeListener.add(r100);
        goto L6
    }

    private int getHeadsetState(Context r100) {
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 4) == false) goto L41;
        if (this.mIsStarted == true) goto L41;
        return 1;
    L41:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");     // Catch: Throwable -> L38
        if (r101 != null) goto L14;
        TTVideoEngineLog.e(TAG, "AudioManager is null");     // Catch: Throwable -> L38
        return 65280;
    L14:
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L38
        if (r102 >= 23) goto L17;
    L32:
        boolean r103 = r101.isWiredHeadsetOn();     // Catch: Throwable -> L38
        if (r101.isBluetoothScoOn() == true) goto L37;
        if (r101.isBluetoothA2dpOn() == true) goto L37;
        return r103 ? 1 : 0;
    L37:
        return (r103 ? 1 : 0) | 2;
    L17:
        if (r102 == 25) goto L32;
        AudioDeviceInfo[] r104 = r101.getDevices(2);     // Catch: Throwable -> L38
        int r105 = r104.length;     // Catch: Throwable -> L38
        int r106 = 0;
        int r107 = 0;
    L20:
        if (r106 >= r105) goto L46;
        AudioDeviceInfo r108 = r104[r106];     // Catch: Throwable -> L38
        if (r108.getType() != 3) goto L24;
    L25:
        r107 = r107 | 1;     // Catch: Throwable -> L38
        TTVideoEngineLog.d(TAG, "wired device: " + r108.getProductName());     // Catch: Throwable -> L38
    L27:
        if (r108.getType() != 8) goto L29;
    L30:
        r107 = r107 | 2;     // Catch: Throwable -> L38
        TTVideoEngineLog.d(TAG, "bluetooth device: " + r108.getProductName());     // Catch: Throwable -> L38
    L31:
        r106 = r106 + 1;     // Catch: Throwable -> L38
        goto L20
    L29:
        if (r108.getType() != 7) goto L31;
    L24:
        if (r108.getType() != 4) goto L27;
    L46:
        return r107;
    L38:
        th = move-exception;
        th.printStackTrace();
        return 65280;
    }

    public static HeadsetStateMonitor getInstance(Context r100) {
        if (sInstance != null) goto L15;
        monitor-enter(HeadsetStateMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HeadsetStateMonitor(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(HeadsetStateMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private /* synthetic */ void lambda$addStateChangedListener$1(HeadsetStateChangedListener r100) {
        addListenerInternal(r100);
    }

    private /* synthetic */ void lambda$removeStateChangedListener$2(HeadsetStateChangedListener r100) {
        removeListenerInternal(r100);
    }

    private void notifyStateChanged(boolean r100) {
        if (this.mChangeListener.isEmpty() == false) goto L5;
        return;
    L5:
        int r101 = 0;
    L22:
        if (r101 >= this.mChangeListener.size()) goto L27;
        HeadsetStateChangedListener r102 = (HeadsetStateChangedListener) ListProtector.get(this.mChangeListener, r101);     // Catch: Exception -> L19
        if (r102 == null) goto L18;
        if (isWiredConnected() == false) goto L13;
    L16:
        boolean r103 = true;
    L17:
        r102.onHeadsetStateChanged(r103, r100);     // Catch: Exception -> L19
        goto L18
    L13:
        if (isWirelessConnected() == true) goto L16;
        r103 = false;
    L18:
        r101 = r101 + 1;
        goto L22
    L27:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    private void onConnected(int r100) {
        TTVideoEngineLog.d(TAG, "onConnected, " + r100);
        if (this.mHeadsetState != 65280) goto L5;
        this.mHeadsetState = getHeadsetState(this.mContext);
    L5:
        int r101 = this.mHeadsetState | r100;
        if (r101 != this.mHeadsetState) goto L8;
        return;
    L8:
        this.mHeadsetState = r101;
        if (r100 != 2) goto L11;
        boolean r102 = true;
    L12:
        notifyStateChanged(r102);
        return;
    L11:
        r102 = false;
        goto L12
    }

    private void onDisconnected(int r100) {
        TTVideoEngineLog.d(TAG, "onDisconnected");
        if (this.mHeadsetState != 65280) goto L5;
        this.mHeadsetState = getHeadsetState(this.mContext);
    L5:
        int r101 = this.mHeadsetState;
        int r102 = (~r100) & r101;
        if (r102 != this.mHeadsetState) goto L8;
        return;
    L8:
        this.mHeadsetState = r102;
        notifyStateChanged(isWirelessConnected());
    }

    private void registerBroadcastReceiver(Context r100) {
        IntentFilter r101 = new IntentFilter("android.intent.action.HEADSET_PLUG");
        r101.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        HeadsetReceiver r102 = new HeadsetReceiver(this, null);
        this.mHeadsetReceiver = r102;
        INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r102, r101);
    }

    private void removeListenerInternal(HeadsetStateChangedListener r100) {
        if (r100 == null) goto L4;
        this.mChangeListener.remove(r100);
    L4:
        TTVideoEngineLog.d(TAG, "listener: " + this.mChangeListener.size());
    }

    private void unregisterBroadcastReceiver(Context r100) {
        HeadsetReceiver r101 = this.mHeadsetReceiver;
        if (r101 == null) goto L12;
        INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Exception -> L6
    L8:
        this.mHeadsetReceiver = null;
        return;
    L6:
        e = move-exception;
        TTVideoEngineLog.w(TAG, e.getMessage());
        goto L8
    }

    public void addStateChangedListener(final HeadsetStateChangedListener r100) {
        runOnThread(this.mHandler, new f(this, r100));
    }

    public void removeStateChangedListener(final HeadsetStateChangedListener r100) {
        runOnThread(this.mHandler, new d(this, r100));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$200(Handler r100, Runnable r101) {
        runOnThread(r100, r101);
    }

    public static /* synthetic */ void access$300(HeadsetStateMonitor r100, int r101) {
        r100.onDisconnected(r101);
    }

    public static /* synthetic */ void access$400(HeadsetStateMonitor r100, int r101) {
        r100.onConnected(r101);
    }

    private static void runOnThread(Handler r100, Runnable r101) {
        if (Looper.myLooper() != r100.getLooper()) goto L5;
        r101.run();
        return;
    L5:
        r100.post(r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
