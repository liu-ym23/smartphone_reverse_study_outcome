package com.larus.common_ui.floatwindow.view;

import android.app.Application;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f327487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FullScreenFloatWindowHandler f327488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f327489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327490d;

    public static final class a {
    }

    static {
    }

    public c(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        m0 r101 = new m0(r100, new h());
        this.f327487a = r101;
        this.f327488b = new FullScreenFloatWindowHandler(r100);
        this.f327489c = r101;
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.d("FloatController", "removeView. view:" + r100);
        this.f327489c.removeView(r100);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        final v r101 = this.f327488b;
    L5:
        v r102 = this.f327489c;
        if (r102 != r101) goto L8;
        return;
    L8:
        r102.c();
        if (this.f327490d == false) goto L11;
        r102.a(new b(r101));
    L11:
        this.f327489c = r101;
        FLogger.f375446a.d("FloatController", "switchHandler. isFullScreenMode:" + r100);
        return;
    L4:
        r101 = this.f327487a;
        goto L5
    }

    public final void c(e19.h r100, SingleFloatWindowState r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        FLogger.f375446a.d("FloatController", "updateView. view:" + r100.getContentView());
        this.f327489c.h(r100, r101, r102);
    }
}
