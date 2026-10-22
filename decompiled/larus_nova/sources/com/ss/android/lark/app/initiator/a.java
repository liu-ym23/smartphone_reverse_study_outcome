package com.ss.android.lark.app.initiator;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f408744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppLaunchLifecycle f408745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f408746c;

    @Override // com.ss.android.lark.app.initiator.b
    public final void a(final Context r100) {
        AppLaunchLifecycle r101 = this.f408745b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.a(new AppLaunchLifecycle$afterOnCreateStart$1(r100));
        this.f408746c.a();
        AppLaunchLifecycle r102 = this.f408745b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102.a(new AppLaunchLifecycle$afterOnCreateEnd$1(r100));
    }

    @Override // com.ss.android.lark.app.initiator.b
    public final void attachBaseContext(final Context r100) {
        AppLaunchLifecycle r101 = this.f408745b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.a(new AppLaunchLifecycle$attachBaseContextStart$1(r100));
        d r102 = this.f408744a.a(r100);
        this.f408746c = r102;
        r102.attachBaseContext(r100);
        AppLaunchLifecycle r103 = this.f408745b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.a(new AppLaunchLifecycle$attachBaseContextEnd$1(r100));
    }

    @Override // com.ss.android.lark.app.initiator.b
    public final void b(final Context r100) {
        AppLaunchLifecycle r101 = this.f408745b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.a(new AppLaunchLifecycle$beforeOnCreateStart$1(r100));
        this.f408746c.b();
        AppLaunchLifecycle r102 = this.f408745b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102.a(new AppLaunchLifecycle$beforeOnCreateEnd$1(r100));
    }

    @Inject
    public a(c r100, AppLaunchLifecycle r101) {
        this.f408745b = r101;
        this.f408744a = r100;
    }
}
