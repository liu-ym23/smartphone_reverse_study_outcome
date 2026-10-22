package com.larus.init.task;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.larus.bmhome.SideBarPage;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f351478a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public z0(y0 r100) {
        this.f351478a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        y0 r100 = this.f351478a;
        r100.getClass();
        boolean r101 = true;
        boolean r102 = false;
        if (r111 == null) goto L5;
        boolean r103 = true;
    L6:
        boolean r104 = r110 instanceof BaseFragmentActivity;
        HomeServiceV2 r105 = HomeServiceV2.f344096a;
        String r106 = r105.a();
        if (r111 != null) goto L9;
    L12:
        int r107 = 0;
    L13:
        SideBarPage.a r108 = SideBarPage.Companion;
        Integer r109 = Integer.valueOf(r107);
        r108.getClass();
        if (r109 != null) goto L17;
    L18:
        if (r109 != null) goto L21;
    L22:
        if (r109 != null) goto L25;
    L27:
        boolean r112 = false;
    L30:
        if (r103 == false) goto L50;
        if (r104 == true) goto L33;
        if (r112 == false) goto L50;
    L33:
        r100.f351475a.unregisterActivityLifecycleCallbacks(this);
        String r113 = r105.a();
        if (r113.length() != 0) goto L36;
        r102 = true;
    L36:
        if (r102 == false) goto L68;
        FLogger.f375446a.w("InitOfficeImSdkTask", "clear task to MainActivity failed, mainActivityClassName is empty");
        return;
    L68:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L43
        Intent r115 = new Intent();     // Catch: Throwable -> L43
        r115.setClassName(r100.f351475a.getPackageName(), r113);     // Catch: Throwable -> L43
        r115.addFlags(268468224);     // Catch: Throwable -> L43
        r115.putExtra("office_recreate_clear_task_to_main", true);     // Catch: Throwable -> L43
        r100.f351475a.startActivity(r115);     // Catch: Throwable -> L43
        if (r111 == null) goto L41;
        r111.clear();     // Catch: Throwable -> L43
    L41:
        r110.finish();     // Catch: Throwable -> L43
        FLogger.f375446a.i("InitOfficeImSdkTask", "clear task to MainActivity on recreate, activity=".concat(r110.getClass().getSimpleName()));     // Catch: Throwable -> L43
        Object r116 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L43
    L45:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L49;
        FLogger.f375446a.e("InitOfficeImSdkTask", "clear task to MainActivity failed", r117);
        r116 = Boolean.FALSE;
    L49:
        ((Boolean) r116).booleanValue();
        return;
    L43:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        if (r103 == false) goto L64;
        String r119 = r105.a();
        if (r119.length() <= 0) goto L54;
        boolean r120 = true;
    L55:
        if (r120 == true) goto L57;
    L59:
        boolean r121 = false;
    L60:
        if (r121 == true) goto L64;
        r101 = false;
        goto L64
    L57:
        if (Intrinsics.areEqual(r110.getClass().getName(), r119) == false) goto L59;
        r121 = true;
        goto L60
    L54:
        r120 = false;
    L64:
        if (r101 == false) goto L66;
        r100.f351475a.unregisterActivityLifecycleCallbacks(this);
        FLogger.f375446a.i("InitOfficeImSdkTask", "skip checkOfficeSdkInit, activity=" + r110.getClass().getSimpleName() + ", recreate=" + r103 + ", isLarkActivity=" + r104 + ", restoreSideBarPage=" + r107);
        return;
    L66:
        FLogger.f375446a.i("InitOfficeImSdkTask", "continue watching recreate stack, activity=" + r110.getClass().getSimpleName() + ", recreate=" + r103 + ", isLarkActivity=" + r104 + ", restoreSideBarPage=" + r107);
        return;
    L25:
        if (r109.intValue() != 19) goto L27;
    L28:
        r112 = true;
        goto L30
    L21:
        if (r109.intValue() == 18) goto L28;
    L17:
        if (r109.intValue() == 17) goto L28;
    L9:
        if (Intrinsics.areEqual(r110.getClass().getName(), r106) == false) goto L12;
        r107 = r111.getInt("key_restore_side_bar_page", 0);
        goto L13
    L5:
        r103 = false;
        goto L6
    }
}
