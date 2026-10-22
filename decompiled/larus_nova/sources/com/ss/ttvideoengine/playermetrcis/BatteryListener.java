package com.ss.ttvideoengine.playermetrcis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class BatteryListener {
    private BatteryStateListener mBatteryStateListener;
    private Context mContext;
    private boolean mInitialState;
    private BatteryBroadcastReceiver receiver;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.playermetrcis.BatteryListener$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BatteryBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ BatteryListener this$0;

        private BatteryBroadcastReceiver(BatteryListener r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ BatteryBroadcastReceiver(BatteryListener r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L15;
            String r102 = r101.getAction();
            r102.getClass();
            if (r102.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == true) goto L12;
            if (r102.equals("android.intent.action.ACTION_POWER_CONNECTED") == true) goto L9;
            return;
        L9:
            if (BatteryListener.access$100(this.this$0) == null) goto L16;
            BatteryListener.access$100(this.this$0).onStatePowerConnected();
            return;
        L16:
            return;
        L12:
            if (BatteryListener.access$100(this.this$0) == null) goto L18;
            BatteryListener.access$100(this.this$0).onStatePowerDisconnected();
            return;
        L18:
            return;
        }
    }

    public interface BatteryStateListener {
        void onStatePowerConnected();

        void onStatePowerDisconnected();
    }

    public void unregister() {
        BatteryBroadcastReceiver r100 = this.receiver;
        if (r100 == null) goto L6;
        INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, r100);
        return;
    }

    public boolean getInitialCharging() {
        return this.mInitialState;
    }

    public BatteryListener(Context r100) {
        this.mContext = r100;
        this.receiver = new BatteryBroadcastReceiver(this, null);
    }

    public static /* synthetic */ BatteryStateListener access$100(BatteryListener r100) {
        return r100.mBatteryStateListener;
    }

    public void register(BatteryStateListener r100) {
        this.mBatteryStateListener = r100;
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.receiver == null) goto L15;
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r101.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        Intent r102 = INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.receiver, r101);
        if (r102 == null) goto L16;
        int r103 = r102.getIntExtra("plugged", -1);
        TTVideoEngineLog.i("BatteryListener", "BatteryListener state: " + r103);
        if (r103 != 2) goto L11;
        boolean r104 = true;
    L12:
        this.mInitialState = r104;
        return;
    L11:
        r104 = false;
        goto L12
    L16:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
