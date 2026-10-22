package com.ss.android.videoshop.kits.autopause;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class VideoScreenStateController extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f455974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyguardManager f455975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager f455976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<a> f455977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f455978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f455979f;

    public interface a {
        void onScreenOff();

        void onScreenOn();

        void onScreenUserPresent(boolean r100);
    }

    public final void b() {
    L6:
        this.f455979f = false;
        return;
    L3:
        if (this.f455979f == true) goto L10;
        this.f455979f = true;     // Catch: Exception -> L6
        IntentFilter r100 = new IntentFilter();     // Catch: Exception -> L6
        r100.addAction("android.intent.action.SCREEN_ON");     // Catch: Exception -> L6
        r100.addAction("android.intent.action.SCREEN_OFF");     // Catch: Exception -> L6
        r100.addAction("android.intent.action.USER_PRESENT");     // Catch: Exception -> L6
        a(this.f455974a, this, r100);     // Catch: Exception -> L6
        return;
    }

    public VideoScreenStateController(Context r100, a r101) {
        this.f455978e = false;
        this.f455979f = false;
        this.f455974a = r100.getApplicationContext();
        this.f455976c = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.f455975b = (KeyguardManager) r100.getSystemService("keyguard");
        this.f455977d = new WeakReference(r101);
        b();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        a r102 = this.f455977d.get();
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r101.getAction();
        boolean r104 = false;
        if ("android.intent.action.SCREEN_OFF".equals(r103) == false) goto L9;
        this.f455978e = false;
        r102.onScreenOff();
        return;
    L9:
        if ("android.intent.action.SCREEN_ON".equals(r103) == false) goto L22;
        r102.onScreenOn();
        if (this.f455978e == true) goto L30;
        KeyguardManager r105 = this.f455975b;     // Catch: Throwable -> L17
        if (r105 == null) goto L19;
        if (r105.isKeyguardLocked() == false) goto L19;
    L16:
        r104 = true;
    L19:
        if (r104 == true) goto L31;
        this.f455978e = true;
        r102.onScreenUserPresent(true);
        return;
    L31:
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L30:
        return;
    L22:
        if ("android.intent.action.USER_PRESENT".equals(r103) == true) goto L24;
        return;
    L24:
        if (this.f455978e == true) goto L34;
        this.f455978e = true;
        r102.onScreenUserPresent(false);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
