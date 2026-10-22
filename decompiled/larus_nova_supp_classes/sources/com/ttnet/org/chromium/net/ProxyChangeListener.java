package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.build.BuildConfig;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("net")
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int GET_PROXY_CONFIG_DELAY_MILLIS = 1000;
    private static final String TAG = "ProxyChangeListener";
    private static boolean sEnabled;
    private Delegate mDelegate;
    private final Handler mHandler;
    private final Looper mLooper;
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;
    private BroadcastReceiver mRealProxyReceiver;

    public class ProxyReceiver extends BroadcastReceiver {
        final /* synthetic */ ProxyChangeListener this$0;

        public static /* synthetic */ void a(ProxyReceiver r0, Intent r1) {
            r0.lambda$onReceive$0(r1);
        }

        private ProxyReceiver(ProxyChangeListener r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r2) {
            ProxyChangeListener.access$200(this.this$0, ProxyChangeListener.access$100(r2));
        }

        public /* synthetic */ ProxyReceiver(ProxyChangeListener r1, 1 r2) {
            this(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r4, Intent r5) {
            if (r5.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.access$000(this.this$0).postDelayed(new c(this, r5), 1000);
            return;
        }
    }

    public static /* synthetic */ void a(ProxyChangeListener r0, Intent r1) {
        r0.lambda$updateProxyConfigFromConnectivityManager$0(r1);
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        sEnabled = true;
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }

    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return $assertionsDisabled;
    }

    private ProxyChangeListener() {
        Looper r0 = Looper.myLooper();
        this.mLooper = r0;
        this.mHandler = new Handler(r0);
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(this, null);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, r0);
        return;
    L5:
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mRealProxyReceiver, r0);
    }

    private void unregisterReceiver() {
        assertOnThread();
        INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver);
        if (this.mRealProxyReceiver == null) goto L5;
        INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ContextUtils.getApplicationContext(), this.mRealProxyReceiver);
    L5:
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_net_ProxyChangeListener_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static /* synthetic */ Handler access$000(ProxyChangeListener r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ ProxyConfig access$100(Intent r0) {
        return extractNewProxy(r0);
    }

    private static ProxyConfig extractNewProxy(Intent r1) {
        Bundle r2 = r1.getExtras();
        if (r2 != null) goto L7;
        return null;
    L7:
        return ProxyConfig.access$300((ProxyInfo) r2.get("android.intent.extra.PROXY_INFO"));
    }

    public static String getProperty(String r0) {
        return System.getProperty(r0);
    }

    private ProxyConfig getProxyConfig(Intent r4) {
        ProxyInfo r0 = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (r0 != null) goto L7;
        return ProxyConfig.DIRECT;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if ("localhost".equals(r0.getHost()) == false) goto L15;
        if (r0.getPort() != (-1)) goto L15;
        return extractNewProxy(r4);
    L15:
        return ProxyConfig.access$300(r0);
    }

    private /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0(Intent r1) {
        proxySettingsChanged(getProxyConfig(r1));
    }

    private void proxySettingsChanged(ProxyConfig r14) {
        assertOnThread();
        if (sEnabled == true) goto L5;
        return;
    L5:
        Delegate r0 = this.mDelegate;
        if (r0 == null) goto L9;
        r0.proxySettingsChanged();
    L9:
        if (this.mNativePtr != 0) goto L11;
        return;
    L11:
        if (r14 == null) goto L13;
        ProxyChangeListenerJni.get().proxySettingsChangedTo(this.mNativePtr, this, r14.mHost, r14.mPort, r14.mPacUrl, r14.mExclusionList);
        return;
    L13:
        ProxyChangeListenerJni.get().proxySettingsChanged(this.mNativePtr, this);
    }

    private void runOnThread(Runnable r2) {
        if (onThread() == false) goto L5;
        r2.run();
        return;
    L5:
        this.mHandler.post(r2);
    }

    public static void setEnabled(boolean r0) {
        sEnabled = r0;
    }

    public void setDelegateForTesting(Delegate r1) {
        this.mDelegate = r1;
    }

    public void start(long r2) {
        TraceEvent r0 = TraceEvent.scoped("ProxyChangeListener.start");
        assertOnThread();     // Catch: Throwable -> L7
        this.mNativePtr = r2;     // Catch: Throwable -> L7
        registerReceiver();     // Catch: Throwable -> L7
        if (r0 == null) goto L18;
        r0.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public void updateProxyConfigFromConnectivityManager(Intent r5) {
        this.mHandler.postDelayed(new b(this, r5), 1000);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, $assertionsDisabled);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$200(ProxyChangeListener r0, ProxyConfig r1) {
        r0.proxySettingsChanged(r1);
    }
}
