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
import dg4.b;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f532459a = 0;

    /* JADX INFO: renamed from: qc3.a$a, reason: collision with other inner class name */
    public static final class C7310a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f532460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f532461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f532462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f532463d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f532464e;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r110) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r110, "outline");
            float r101 = Math.min(Math.min(r100.getWidth(), r100.getHeight()) / 2, this.f532460a);
            float r102 = this.f532461b;
            float r103 = 0;
            if (r102 <= r103) goto L5;
        L8:
            int r104 = 0;
        L10:
            if (r102 <= r103) goto L12;
        L15:
            int r105 = 0;
        L17:
            if (this.f532463d <= r103) goto L19;
        L22:
            int r106 = r100.getWidth();
        L23:
            int r107 = r106;
            if (this.f532462c <= r103) goto L26;
        L29:
            int r108 = r100.getHeight();
        L30:
            r110.setRoundRect(r104, r105, r107, r108, r101);
            return;
        L26:
            if (this.f532464e > r103) goto L29;
            r108 = r100.getHeight() + ((int) r101);
            goto L30
        L19:
            if (this.f532464e > r103) goto L22;
            r106 = r100.getWidth() + ((int) r101);
            goto L23
        L12:
            if (this.f532463d > r103) goto L15;
            r105 = -((int) r101);
            goto L17
        L5:
            if (this.f532462c > r103) goto L8;
            r104 = -((int) r101);
            goto L10
        }

        public C7310a(float r100, float r101, float r102, float r103, float r104) {
            this.f532460a = r100;
            this.f532461b = r101;
            this.f532462c = r102;
            this.f532463d = r103;
            this.f532464e = r104;
        }
    }

    static {
        f532459a = b.c();
    }

    public static final View a(View r100, Function1<? super View, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$findViewWithCondition");
        Intrinsics.checkNotNullParameter(r101, "condition");
        if (r101.invoke(r100).booleanValue() == false) goto L5;
        View r102 = r100;
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        if ((r100 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L25;
        View r106 = r103.getChildAt(r105);
        if (r101.invoke(r106).booleanValue() == false) goto L16;
        View r107 = r106;
    L17:
        if (r107 != null) goto L18;
        if ((r106 instanceof ViewGroup) == false) goto L24;
        View r108 = a(r106, r101);
        if (r108 == null) goto L24;
        return r108;
    L24:
        r105 = r105 + 1;
        goto L12
    L18:
        return r107;
    L16:
        r107 = null;
        goto L17
    L25:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static final View c(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getChildOrNullAt");
        if (r100.getChildCount() >= (r101 + 1)) goto L6;
        return null;
    L6:
        return r100.getChildAt(r101);
    }

    public static final int d(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getColorCompat");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return r100.getColor(r101);
    L6:
        return r100.getResources().getColor(r101);
    }

    public static final void e(View r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setBackgroundCompat");
        r100.setBackground(r101);
    }

    public static final void f(GradientDrawable r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setColorsCompat");
        Intrinsics.checkNotNullParameter(r101, "colors");
        r100.setColors(r101);
    }

    public static final void g(GradientDrawable r100, GradientDrawable.Orientation r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setOrientationCompat");
        Intrinsics.checkNotNullParameter(r101, "orientation");
        r100.setOrientation(r101);
    }

    public static /* synthetic */ void i(View r100, float r101, float r102) {
        h(r100, r101, r102, 0.0f, 0.0f, true);
    }

    public static float[] b(float r100, float r101, float r102, float r103) {
        float r104 = q.a(Float.valueOf(r100));
        float r105 = q.a(Float.valueOf(r101));
        float r106 = q.a(Float.valueOf(r102));
        float r107 = q.a(Float.valueOf(r103));
        return new float[]{r104, r104, r105, r105, r106, r106, r107, r107};
    }

    public static final void h(View r100, float r101, float r102, float r103, float r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRadius");
        if (r111 == false) goto L5;
        r101 = q.a(Float.valueOf(r101));
    L5:
        float r104 = r101;
        if (r111 == false) goto L8;
        r102 = q.a(Float.valueOf(r102));
    L8:
        float r105 = r102;
        if (r111 == false) goto L11;
        r103 = q.a(Float.valueOf(r103));
    L11:
        float r106 = r103;
        if (r111 == false) goto L14;
        r110 = q.a(Float.valueOf(r110));
    L14:
        float r107 = r110;
        Float r108 = ArraysKt.maxOrNull(new float[]{r104, r105, r106, r107});
        if (r108 == null) goto L17;
        float r109 = r108.floatValue();
    L19:
        if (r109 <= 0) goto L21;
        r100.setClipToOutline(true);
        r100.setOutlineProvider(new C7310a(r109, r104, r107, r105, r106));
        return;
    L21:
        r100.setClipToOutline(false);
        r100.setOutlineProvider(null);
        return;
    L17:
        r109 = 0.0f;
        goto L19
    }
}
