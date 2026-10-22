package com.bytedance.timonbase.scene;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.timonbase.utils.TMThreadUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageDataManager f270884a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public c(PageDataManager r100) {
        this.f270884a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity r100) {
        final PageDataManager r101 = this.f270884a;
        final String r102 = "onResumed";
        final long r103 = System.currentTimeMillis();
        r101.getClass();
        TMThreadUtils r104 = TMThreadUtils.f270906d;
        Function0<Unit> r105 = new PageDataManager$recordPageInfo$1(r101, r100, r103, r102);
        r104.getClass();
        TMThreadUtils.a(r105);
        this.f270884a.getClass();
        r100.getClass();
        PageDataManager.f270859b = r100.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        this.f270884a.getClass();
        r100.getClass();
        PageDataManager.f270859b = r100.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = r100.hashCode();
        PageDataManager.a r102 = PageDataManager.f270861d;
        r102.getClass();
        if (r101 != PageDataManager.f270859b) goto L6;
        r102.getClass();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        this.f270884a.getClass();
        r100.getClass();
        PageDataManager.f270859b = r100.hashCode();
    }
}
