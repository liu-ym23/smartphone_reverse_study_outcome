package qc3;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import dg4.b;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final int a = 0;

    /* JADX INFO: renamed from: qc3.a$a, reason: collision with other inner class name */
    public static final class C0228a extends ViewOutlineProvider {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r9, Outline r10) {
            Intrinsics.checkNotNullParameter(r9, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r10, "outline");
            float r7 = Math.min(Math.min(r9.getWidth(), r9.getHeight()) / 2, this.a);
            float r0 = this.b;
            float r2 = 0;
            if (r0 <= r2) goto L5;
        L8:
            int r3 = 0;
        L10:
            if (r0 <= r2) goto L12;
        L15:
            int r4 = 0;
        L17:
            if (this.d <= r2) goto L19;
        L22:
            int r1 = r9.getWidth();
        L23:
            int r5 = r1;
            if (this.c <= r2) goto L26;
        L29:
            int r11 = r9.getHeight();
        L30:
            r10.setRoundRect(r3, r4, r5, r11, r7);
            return;
        L26:
            if (this.e > r2) goto L29;
            r11 = r9.getHeight() + ((int) r7);
            goto L30
        L19:
            if (this.e > r2) goto L22;
            r1 = r9.getWidth() + ((int) r7);
            goto L23
        L12:
            if (this.d > r2) goto L15;
            r4 = -((int) r7);
            goto L17
        L5:
            if (this.c > r2) goto L8;
            r3 = -((int) r7);
            goto L10
        }

        public C0228a(float r1, float r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
        a = b.c();
    }

    public static final View a(View r5, Function1<? super View, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$findViewWithCondition");
        Intrinsics.checkNotNullParameter(r6, "condition");
        if (((Boolean) r6.invoke(r5)).booleanValue() == false) goto L5;
        View r0 = r5;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        if ((r5 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        ViewGroup r7 = (ViewGroup) r5;
        int r1 = r7.getChildCount();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L25;
        View r3 = r7.getChildAt(r2);
        if (((Boolean) r6.invoke(r3)).booleanValue() == false) goto L16;
        View r4 = r3;
    L17:
        if (r4 != null) goto L18;
        if ((r3 instanceof ViewGroup) == false) goto L24;
        View r8 = a(r3, r6);
        if (r8 == null) goto L24;
        return r8;
    L24:
        r2 = r2 + 1;
        goto L12
    L18:
        return r4;
    L16:
        r4 = null;
        goto L17
    L25:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    public static final View c(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getChildOrNullAt");
        if (r2.getChildCount() >= (r3 + 1)) goto L6;
        return null;
    L6:
        return r2.getChildAt(r3);
    }

    public static final int d(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getColorCompat");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return r2.getColor(r3);
    L6:
        return r2.getResources().getColor(r3);
    }

    public static final void e(View r1, Drawable r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setBackgroundCompat");
        r1.setBackground(r2);
    }

    public static final void f(GradientDrawable r1, int[] r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setColorsCompat");
        Intrinsics.checkNotNullParameter(r2, "colors");
        r1.setColors(r2);
    }

    public static final void g(GradientDrawable r1, GradientDrawable.Orientation r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setOrientationCompat");
        Intrinsics.checkNotNullParameter(r2, "orientation");
        r1.setOrientation(r2);
    }

    public static /* synthetic */ void i(View r6, float r7, float r8) {
        h(r6, r7, r8, 0.0f, 0.0f, true);
    }

    public static float[] b(float r2, float r3, float r4, float r5) {
        float r6 = q.a(Float.valueOf(r2));
        float r7 = q.a(Float.valueOf(r3));
        float r8 = q.a(Float.valueOf(r4));
        float r9 = q.a(Float.valueOf(r5));
        return new float[]{r6, r6, r7, r7, r8, r8, r9, r9};
    }

    public static final void h(View r6, float r7, float r8, float r9, float r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r6, "$this$setRadius");
        if (r11 == false) goto L5;
        r7 = q.a(Float.valueOf(r7));
    L5:
        float r2 = r7;
        if (r11 == false) goto L8;
        r8 = q.a(Float.valueOf(r8));
    L8:
        float r4 = r8;
        if (r11 == false) goto L11;
        r9 = q.a(Float.valueOf(r9));
    L11:
        float r5 = r9;
        if (r11 == false) goto L14;
        r10 = q.a(Float.valueOf(r10));
    L14:
        float r3 = r10;
        Float r12 = ArraysKt.maxOrNull(new float[]{r2, r4, r5, r3});
        if (r12 == null) goto L17;
        float r1 = r12.floatValue();
    L19:
        if (r1 <= 0) goto L21;
        r6.setClipToOutline(true);
        r6.setOutlineProvider(new C0228a(r1, r2, r3, r4, r5));
        return;
    L21:
        r6.setClipToOutline(false);
        r6.setOutlineProvider(null);
        return;
    L17:
        r1 = 0.0f;
        goto L19
    }
}
