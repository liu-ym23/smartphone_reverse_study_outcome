package com.bytedance.unitm.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.unitm.core.BaseThermalStatusGenerator;
import com.bytedance.unitm.util.TLog;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class CommonThermalStatusAdapter extends BaseThermalStatusGenerator {
    private float debugTemp;
    private MyBroadcastReceiver receiver;

    public class MyBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ CommonThermalStatusAdapter this$0;

        public MyBroadcastReceiver(CommonThermalStatusAdapter r100) {
            this.this$0 = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            boolean r102 = false;
            float r103 = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
            TLog.i("onReceive battery temp:" + r103 + " lastTemp:" + CommonThermalStatusAdapter.access$000(this.this$0) + " debugTemp:" + CommonThermalStatusAdapter.access$100(this.this$0));
            if (CommonThermalStatusAdapter.access$100(this.this$0) <= 0.0f) goto L8;
            r103 = CommonThermalStatusAdapter.access$100(this.this$0);
        L8:
            if (r103 != CommonThermalStatusAdapter.access$200(this.this$0)) goto L10;
            return;
        L10:
            float r104 = Math.abs(CommonThermalStatusAdapter.access$300(this.this$0) - r103);
            if (r104 >= 0.5f) goto L14;
            TLog.d("not handle temp changed, delta " + r104);
            return;
        L14:
            CommonThermalStatusAdapter r105 = this.this$0;
            if (r103 <= CommonThermalStatusAdapter.access$500(r105)) goto L17;
            r102 = true;
        L17:
            CommonThermalStatusAdapter.access$402(r105, CommonThermalStatusAdapter.access$600(r105, r103, r102));
            CommonThermalStatusAdapter.access$702(this.this$0, r103);
            if (CommonThermalStatusAdapter.access$800(this.this$0) == null) goto L21;
            CommonThermalStatusAdapter.access$1100(this.this$0).onStatusGenerate(CommonThermalStatusAdapter.access$900(this.this$0), CommonThermalStatusAdapter.access$1000(this.this$0));
            return;
        }
    }

    private float getCurrentTempFromIntent() {
        Intent r100 = INVOKEVIRTUAL_com_bytedance_unitm_adapter_CommonThermalStatusAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
    }

    private void initThermalStatusList() {
        this.thermalThresholdList.add(new Pair(Float.valueOf(35.0f), Float.valueOf(34.0f)));
        this.thermalThresholdList.add(new Pair(Float.valueOf(38.0f), Float.valueOf(37.0f)));
        this.thermalThresholdList.add(new Pair(Float.valueOf(41.0f), Float.valueOf(40.0f)));
        this.thermalThresholdList.add(new Pair(Float.valueOf(45.0f), Float.valueOf(43.0f)));
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public boolean addStatusListener() {
        if (this.receiver == null) goto L12;
    L11:
        return true;
    L12:
        MyBroadcastReceiver r100 = new MyBroadcastReceiver(this);     // Catch: Exception -> L9
        this.receiver = r100;     // Catch: Exception -> L9
        Intent r101 = INVOKEVIRTUAL_com_bytedance_unitm_adapter_CommonThermalStatusAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r100, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L9
        if (r101 != null) goto L7;
        return false;
    L7:
        float r102 = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;     // Catch: Exception -> L9
        this.mTemp = r102;     // Catch: Exception -> L9
        this.mStatus = getThermalStatusFromTemp(r102, true);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        TLog.w(Log.getStackTraceString(e));
        goto L11
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public float getCurrentTemp() {
        if (this.mListener != null) goto L7;
        return getCurrentTempFromIntent();
    L7:
        return this.mTemp;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public int getCurrentThermalStatus() {
        if (this.mListener != null) goto L7;
        return getThermalStatusFromTemp(getCurrentTempFromIntent(), true);
    L7:
        return this.mStatus;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public void removeStatusListener() {
        MyBroadcastReceiver r100 = this.receiver;
        if (r100 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_unitm_adapter_CommonThermalStatusAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, r100);
        this.receiver = null;
        return;
    }

    public static /* synthetic */ float access$000(CommonThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$100(CommonThermalStatusAdapter r100) {
        return r100.debugTemp;
    }

    public static /* synthetic */ float access$1000(CommonThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$1100(CommonThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ float access$200(CommonThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$300(CommonThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$500(CommonThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$800(CommonThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ int access$900(CommonThermalStatusAdapter r100) {
        return r100.mStatus;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public void setDebugTemp(float r100) {
        this.debugTemp = r100;
    }

    public CommonThermalStatusAdapter(Context r100, Looper r101) {
        super(r100, r101);
        this.debugTemp = -1.0f;
        initThermalStatusList();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_unitm_adapter_CommonThermalStatusAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    public static /* synthetic */ int access$402(CommonThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(CommonThermalStatusAdapter r100, float r101) {
        r100.mTemp = r101;
        return r101;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_unitm_adapter_CommonThermalStatusAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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

    public static /* synthetic */ int access$600(CommonThermalStatusAdapter r100, float r101, boolean r102) {
        return r100.getThermalStatusFromTemp(r101, r102);
    }
}
