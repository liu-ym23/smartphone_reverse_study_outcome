package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class SingleViewExposureHelper implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f251859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f251860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f251861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f251862e;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(null);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(null);
    }

    public final void a(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L7;
        int r101 = ha6.h.f484393a;
        if (ha6.h.a(this.f251859b, this.f251860c) == false) goto L7;
        boolean r102 = true;
    L9:
        if (Intrinsics.areEqual(this.f251862e, Boolean.valueOf(r102)) == false) goto L11;
        return;
    L11:
        this.f251862e = Boolean.valueOf(r102);
        String r103 = YaTaLog.f251436a;
        YaTaLog.c("SingleViewExposureHelper", new SingleViewExposureHelper$checkVisible$1(this));
        this.f251861d.invoke(Boolean.valueOf(r102));
        return;
    L7:
        r102 = false;
        goto L9
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        a(Boolean.TRUE);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        a(Boolean.FALSE);
    }

    public SingleViewExposureHelper(View r100, boolean r101, Function1 r102) {
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "exposureAction");
        this.f251858a = "";
        this.f251859b = r100;
        this.f251860c = r101;
        this.f251861d = r102;
        this.f251862e = Boolean.FALSE;
        r100.getViewTreeObserver().addOnScrollChangedListener(this);
        r100.getViewTreeObserver().addOnGlobalLayoutListener(this);
        r100.addOnAttachStateChangeListener(this);
    }
}
