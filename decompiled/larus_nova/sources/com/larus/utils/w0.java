package com.larus.utils;

import android.R;
import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.graphics.ColorUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375484a = 0;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f375485a;

        public a(int r100) {
            this.f375485a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f375485a);
        }
    }

    static {
    }

    public w0() {
    }

    public static int c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Point r101 = new Point();
        r100.getWindowManager().getDefaultDisplay().getRealSize(r101);
        return r101.y;
    }

    public static boolean d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Rect r101 = new Rect();
        if (r100.getGlobalVisibleRect(r101) == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.getWidth() != r101.width()) goto L9;
        if (r100.getHeight() != r101.height()) goto L9;
        return true;
    }

    @JvmStatic
    public static final void e(View r100, int r101) {
        if (r100 == null) goto L5;
        r100.setOutlineProvider(new a(r101));
        r100.setClipToOutline(true);
        return;
    }

    public static StateListDrawable a(Integer r100, Integer r101, Float r102, Integer r103) {
        if (r100 == null) goto L5;
        int r104 = r100.intValue();
    L6:
        GradientDrawable r105 = new GradientDrawable();
        r105.setColor(r104);
        if (r102 == null) goto L9;
        r105.setCornerRadius(r102.floatValue());
    L9:
        GradientDrawable r106 = new GradientDrawable();
        if (r101 == null) goto L12;
        r106.setColor(r101.intValue());
    L12:
        if (r102 == null) goto L14;
        r106.setCornerRadius(r102.floatValue());
    L14:
        StateListDrawable r107 = new StateListDrawable();
        r107.addState(new int[]{R.attr.state_pressed}, r106);
        if (r103 == null) goto L20;
        int[] r108 = {-16842910};
        GradientDrawable r109 = new GradientDrawable();
        r109.setColor(r103.intValue());
        if (r102 == null) goto L19;
        r109.setCornerRadius(r102.floatValue());
    L19:
        Unit r110 = Unit.INSTANCE;
        r107.addState(r108, r109);
    L20:
        r107.addState(new int[0], r105);
        return r107;
    L5:
        r104 = 0;
        goto L6
    }

    public static StateListDrawable b(Integer r100, Float r101, float r102, Integer r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r102 = 0.1f;
    L5:
        Object r105 = null;
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        if (r100 == null) goto L10;
        int r106 = r100.intValue();
    L21:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L13
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(ColorUtils.blendARGB(r106, -16777216, r102)));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == true) goto L20;
        r105 = r108;
    L20:
        return a(Integer.valueOf(r106), (Integer) r105, r101, r103);
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L10:
        r106 = 0;
        goto L21
    }
}
