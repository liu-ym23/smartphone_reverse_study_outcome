package com.larus.dora.impl.util;

import android.app.Application;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements g49.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f338127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f338128b;

    @Override // g49.e.a
    public final boolean a() {
        IFlowCompanionDeviceManager r100 = (IFlowCompanionDeviceManager) this.f338127a.getValue();
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        DoraDevice r102 = (DoraDevice) this.f338128b.getValue();
        if (r102 != null) goto L8;
        return false;
    L8:
        String r103 = r102.f204389mac;
        String r104 = r102.f204390sn;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L71;
        if (r104 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L71;
        return false;
    L18:
        if (r104.length() == 0) goto L21;
        r106 = false;
    L71:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L64
        if (r103 != null) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == false) goto L33;
    L35:
        boolean r109 = false;
    L36:
        if (r104 != null) goto L38;
    L41:
        boolean r110 = true;
    L42:
        if (r110 == false) goto L44;
    L46:
        boolean r111 = false;
    L47:
        if (r103 != null) goto L49;
    L52:
        boolean r112 = true;
    L53:
        if (r112 == false) goto L55;
    L57:
        boolean r113 = false;
    L58:
        if (r109 == true) goto L60;
        if (r111 == true) goto L60;
    L62:
        Object r114 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L64
    L66:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r114) == false) goto L70;
        r114 = r115;
    L70:
        return ((Boolean) r114).booleanValue();
    L60:
        if (r113 == false) goto L62;
        r101 = true;
        goto L62
    L55:
        if (r100.m(r103) == false) goto L57;
        r113 = true;
        goto L58
    L49:
        if (r103.length() == 0) goto L52;
        r112 = false;
        goto L53
    L44:
        if (r100.c(r104) == false) goto L46;
        r111 = true;
        goto L47
    L38:
        if (r104.length() == 0) goto L41;
        r110 = false;
        goto L42
    L33:
        if (r100.b(r103) == false) goto L35;
        r109 = true;
        goto L36
    L27:
        if (r103.length() == 0) goto L30;
        r108 = false;
    L64:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
        goto L15
    }

    @Override // g49.e.a
    public final boolean b() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT < 23) goto L28;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Application r102 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L18
        if (r102 == null) goto L27;
        Object r103 = r102.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L18
        if ((r103 instanceof PowerManager) == false) goto L11;
        PowerManager r104 = (PowerManager) r103;     // Catch: Throwable -> L18
    L12:
        if (r104 != null) goto L14;
    L16:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r100));     // Catch: Throwable -> L18
    L20:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L24;
        r105 = r106;
    L24:
        return ((Boolean) r105).booleanValue();
    L14:
        if (r104.isIgnoringBatteryOptimizations(r102.getPackageName()) != true) goto L16;
        r100 = true;
        goto L16
    L11:
        r104 = null;
        goto L12
    L27:
        return false;
    L18:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L28:
        return false;
    }

    @Override // g49.e.a
    public final boolean c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        b0.f338123a.getClass();     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(b0.j().getBoolean("dora_enable_ongoing_notification", true)));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public e() {
        this.f338127a = LazyKt.lazy(new c());
        this.f338128b = LazyKt.lazy(new d());
    }
}
