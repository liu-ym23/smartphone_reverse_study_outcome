package cxa;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.batterymonitor.screen.ScreenBroadcastReceiver;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends wwa.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f465743f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f465744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Display f465745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f465746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f465747e;

    /* JADX INFO: renamed from: cxa.a$a, reason: collision with other inner class name */
    public static class C5604a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465748a = null;

        static {
            f465748a = new a();
        }
    }

    public final int e() {
        monitor-enter(this);
        Display r100 = this.f465745c;     // Catch: Throwable -> L16
        int r101 = 0;
        boolean r102 = true;
        if (r100 != null) goto L7;
    L9:
        if (r102 == false) goto L18;
        int r103 = this.f465746d;     // Catch: Throwable -> L16
        if (r103 != 0) goto L13;
        r101 = r103;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r101;
    L13:
        this.f465747e = 0;     // Catch: Throwable -> L16
        this.f465746d = 0;     // Catch: Throwable -> L16
        goto L14
    L18:
        int r104 = d(false);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r104;
    L7:
        if (r100.getState() != 1) goto L9;
        r102 = false;
    L16:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f465744b = 180000;
        this.f465746d = 0;
        this.f465747e = 0;
    }

    @Override // wwa.a
    public final void b() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        ScreenBroadcastReceiver r101 = ScreenBroadcastReceiver.f409786a;
        Log.e("BatteryMonitor", "failed to register ScreenBroadcast, because context is null");
    L38:
        this.f465745c = ((WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        return;
    L6:
        if (ScreenBroadcastReceiver.f409786a != null) goto L8;
        ScreenBroadcastReceiver.f409786a = new ScreenBroadcastReceiver();
    L8:
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.intent.action.SCREEN_ON");
        r102.addAction("android.intent.action.SCREEN_OFF");
        ScreenBroadcastReceiver r103 = ScreenBroadcastReceiver.f409786a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r102);
        goto L38
    L40:
        throw e;
    L12:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L25;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r102, 0, null, null, 2, r100).result;     // Catch: Exception -> L34
        if (r104 != 1) goto L18;
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L34
    L41:
        goto L38
    L18:
        if (r104 != 2) goto L20;
        new Intent();     // Catch: Exception -> L34
        goto L41
    L20:
        if (r104 == 3) goto L41;
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L34
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r103, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        goto L41
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L30;
    L32:
        r100.registerReceiver(r103, r102);     // Catch: Exception -> L34
        goto L41
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r103, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
        goto L41
    }

    public final int d(boolean r100) {
        int r101 = this.f465746d;
        if (r101 != 2) goto L5;
        return r101;
    L5:
        if (r101 != 0) goto L11;
        long r102 = SystemClock.elapsedRealtime();
        this.f465747e = r102;
        if (r100 == true) goto L9;
        this.f465747e = r102 - 30000;
    L9:
        this.f465746d = 1;
        return 1;
    L11:
        long r103 = SystemClock.elapsedRealtime();
        if ((r103 - this.f465747e) < this.f465744b) goto L15;
        Log.d("BatteryMonitor", "screen off time is " + (r103 - this.f465747e) + " ,so set mCurrentState is ConditionState.ScreenState.SCREEN_OFF_3_MINUTE");
        this.f465746d = 2;
    L15:
        return this.f465746d;
    }

    public final void f(int r100) {
        monitor-enter(this);
        Log.i("BatteryMonitor", a.class.getSimpleName() + " onStateChange called. state:" + r100);     // Catch: Throwable -> L32
        if (r100 != 1) goto L17;
        int r101 = this.f465746d;     // Catch: Throwable -> L32
        if (r101 != 1) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L17;
        Log.i("BatteryMonitor", a.class.getSimpleName().concat(" onStateChange called. current screen state is light off and receive screen_off broadcast."));     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L9:
        if (r101 == 2) goto L12;
        r102 = false;
    L17:
        if (r100 == 0) goto L19;
    L23:
        if (r100 != 1) goto L26;
        d(true);     // Catch: Throwable -> L32
    L29:
        monitor-exit(this);     // Catch: Throwable -> L32
        setChanged();
        notifyObservers();
        return;
    L26:
        if (this.f465746d == 0) goto L29;
        this.f465747e = 0;     // Catch: Throwable -> L32
        this.f465746d = 0;     // Catch: Throwable -> L32
        goto L29
    L19:
        if (this.f465746d != 0) goto L23;
        Log.i("BatteryMonitor", a.class.getSimpleName().concat(" onStateChange called. current screen state is light on and receive screen_on broadcast."));     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }
}
