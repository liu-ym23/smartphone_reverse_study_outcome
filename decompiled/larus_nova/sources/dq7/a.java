package dq7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import aq7.c;
import bq7.b;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager f469679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BatteryManager f469680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f469681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f469682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f469683f;

    /* JADX INFO: renamed from: dq7.a$a, reason: collision with other inner class name */
    public class C5699a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f469684a;

        public C5699a(a r100) {
            this.f469684a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            this.f469684a.a(r101);
        }
    }

    public final void a(Intent r100) {
        if (r100 == null) goto L19;
        int r101 = r100.getIntExtra("status", -1);
        if (r101 != 2) goto L6;
    L16:
        boolean r102 = true;
    L17:
        this.f469681d = r102;
        this.f469682e = r100.getIntExtra("level", -1);
        this.f469682e = (int) ((this.f469682e / r100.getIntExtra("scale", -1)) * 100.0f);
        this.f469683f = r100.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
        return;
    L6:
        if (r101 == 5) goto L8;
    L15:
        r102 = false;
        goto L17
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        BatteryManager r103 = this.f469680c;
        if (r103 == null) goto L12;
        boolean r104 = r103.isCharging();
    L13:
        if (r104 == false) goto L15;
    L12:
        r104 = false;
        goto L13
    }

    public a(Context r100, c r110) {
        super(r100, r110);
        this.f469681d = false;
        this.f469682e = 0;
        this.f469683f = 0.0f;
        this.f469679b = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.f469680c = (BatteryManager) r100.getSystemService("batterymanager");
        C5699a r111 = new C5699a(this);
        IntentFilter r101 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L36:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        Intent r102 = ReceiverRegisterCrashOptimizer.registerReceiver(r111, r101);
    L33:
        a(r102);
        return;
    L35:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L20;
        ReceiverRegisterAnrOptimizer.ResultWrapper r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r101, 0, null, null, 2, r100);     // Catch: Exception -> L29
        int r104 = r103.result;     // Catch: Exception -> L29
        if (r104 != 1) goto L12;
        r102 = r100.registerReceiver(r111, r101);     // Catch: Exception -> L29
        goto L33
    L12:
        if (r104 != 2) goto L14;
        r102 = new Intent();     // Catch: Exception -> L29
        goto L33
    L14:
        if (r104 == 3) goto L16;
        r102 = r100.registerReceiver(r111, r101);     // Catch: Exception -> L29
        goto L33
    L16:
        r102 = r103.intent;     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r102 = r100.registerReceiver(r111, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L33
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r102 = r100.registerReceiver(r111, r101);     // Catch: Exception -> L29
        goto L33
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        r102 = ContextCompat.registerReceiver(r100, r111, r101, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L33
    }
}
