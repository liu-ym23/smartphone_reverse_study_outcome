package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class y5 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f398339a;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y5 f398340a;

        public a(y5 r100) {
            this.f398340a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 == null) goto L7;
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f398340a.f398339a.f398332d);
            return;
        }
    }

    public final GradientDrawable a(int r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setCornerRadius(this.f398339a.f398332d);
        r101.setColor(r100);
        return r101;
    }

    public y5(Context r100, x5 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appearance");
        super(r100);
        this.f398339a = r101;
        setClipChildren(false);
        setClipToPadding(false);
        boolean r102 = true;
        setClipToOutline(true);
        setOutlineProvider(new a(this));
        GradientDrawable r103 = a(r101.f398329a);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        Context r105 = getContext();     // Catch: Throwable -> L12
        if (OMaterialHelper.k() == true) goto L7;
    L9:
        r102 = false;
    L10:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L12
    L14:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = r107;
    L18:
        if (((Boolean) r106).booleanValue() == false) goto L28;
        setBackground(a(0));
        com.obric.oui.material.c r108 = this.f398339a.f398333e;     // Catch: Throwable -> L22
        Integer r109 = OMaterialHelper.f401446a;     // Catch: Throwable -> L22
        Resources r110 = Resources.getSystem();     // Catch: Throwable -> L22
        OMaterialHelper.v(this, 3, r108, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density);     // Catch: Throwable -> L22
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r111) == null) goto L27;
        setBackground(r103);
    L27:
        Result.m9448boximpl(r111);
    L30:
        if (this.f398339a.f398331c <= 0) goto L32;
        GradientDrawable r112 = a(0);
        x5 r113 = this.f398339a;
        r112.setStroke(r113.f398331c, r113.f398330b);
    L33:
        setForeground(r112);
        return;
    L32:
        r112 = null;
    L22:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L28:
        setBackground(r103);
        goto L30
    L7:
        if (OMaterialHelper.g(r105) <= 0) goto L9;
    L12:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        boolean r101 = false;
        View r102 = getChildAt(0);
        if (r102 != null) goto L5;
    L29:
        setMeasuredDimension(0, 0);
        return;
    L5:
        if (r102.getVisibility() == 8) goto L29;
        Integer r103 = Integer.valueOf(r102.getMeasuredWidth());
        if (r103.intValue() <= 0) goto L10;
        boolean r104 = true;
    L11:
        Integer r105 = null;
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L18;
        int r106 = View.MeasureSpec.makeMeasureSpec(r103.intValue(), 1073741824);
    L19:
        Integer r107 = Integer.valueOf(r102.getMeasuredHeight());
        if (r107.intValue() <= 0) goto L22;
        r101 = true;
    L22:
        if (r101 == false) goto L24;
        r105 = r107;
    L24:
        if (r105 == null) goto L26;
        int r108 = View.MeasureSpec.makeMeasureSpec(r105.intValue(), 1073741824);
    L27:
        r102.measure(r106, r108);
        setMeasuredDimension(View.resolveSize(r102.getMeasuredWidth(), r100), View.resolveSize(r102.getMeasuredHeight(), r110));
        return;
    L26:
        r108 = r110;
        goto L27
    L18:
        r106 = r100;
        goto L19
    L10:
        r104 = false;
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (r105 != null) goto L5;
        return;
    L5:
        r105.layout(0, 0, r103 - r101, r104 - r102);
    }
}
