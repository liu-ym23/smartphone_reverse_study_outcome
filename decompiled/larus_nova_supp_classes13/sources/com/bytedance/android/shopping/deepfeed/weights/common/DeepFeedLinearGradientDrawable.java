package com.bytedance.android.shopping.deepfeed.weights.common;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedLinearGradientDrawable extends ShapeDrawable {
    public static final /* synthetic */ int d = 0;
    public final int[] a;
    public final float[] b;
    public final Orientation c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedLinearGradientDrawable$Orientation;", "", "LEFT_TO_RIGHT", "TOP_TO_BOTTOM", "RIGHT_TO_LEFT", "BOTTOM_TO_TOP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Orientation extends Enum<Orientation> {
        public static final Orientation BOTTOM_TO_TOP = null;
        public static final Orientation LEFT_TO_RIGHT = null;
        public static final Orientation RIGHT_TO_LEFT = null;
        public static final Orientation TOP_TO_BOTTOM = null;
        public static final /* synthetic */ Orientation[] a = null;

        static {
            Orientation r1 = new Orientation("LEFT_TO_RIGHT", 0);
            LEFT_TO_RIGHT = r1;
            Orientation r2 = new Orientation("TOP_TO_BOTTOM", 1);
            TOP_TO_BOTTOM = r2;
            Orientation r3 = new Orientation("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            Orientation r4 = new Orientation("BOTTOM_TO_TOP", 3);
            BOTTOM_TO_TOP = r4;
            a = new Orientation[]{r1, r2, r3, r4};
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public static Orientation[] values() {
            return (Orientation[]) a.clone();
        }

        public Orientation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static DeepFeedLinearGradientDrawable a(float r5) {
            int[] r1 = {ColorProtector.parseColor("#FFFFFF"), ColorProtector.parseColor("#FFE6F3"), ColorProtector.parseColor("#FFF1F4"), ColorProtector.parseColor("#FFF5C4")};
            float[] r0 = {0.0f, 0.15f, 0.65f, 1.0f};
            if (r5 <= 0) goto L6;
            return new DeepFeedLinearGradientDrawable(r1, r0, r5);
        L6:
            return new DeepFeedLinearGradientDrawable(r1, r0);
        }
    }

    public static final class b<A, B, C, D> {
        public final A a;
        public final B b;
        public final C c;
        public final D d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            A r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            B r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            C r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            D r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Quad(first=" + this.a + ", second=" + this.b + ", third=" + this.c + ", fourth=" + this.d + ")";
        }

        public b(A r1, B r2, C r3, D r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "bounds");
        super.onBoundsChange(r10);
        float r0 = r10.width();
        float r11 = r10.height();
        int r1 = com.bytedance.android.shopping.deepfeed.weights.common.a.a[this.c.ordinal()];
        if (r1 != 1) goto L5;
        b r12 = new b(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(r0), Float.valueOf(0.0f));
    L16:
        b r2 = r12;
    L17:
        getPaint().setShader(new LinearGradient(((Number) r2.a).floatValue(), ((Number) r2.b).floatValue(), ((Number) r2.c).floatValue(), ((Number) r2.d).floatValue(), this.a, this.b, Shader.TileMode.CLAMP));
        return;
    L5:
        if (r1 != 2) goto L7;
        r2 = new b(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(r11));
        goto L17
    L7:
        if (r1 != 3) goto L9;
        r12 = new b(Float.valueOf(r0), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L16
    L9:
        if (r1 != 4) goto L12;
        r2 = new b(Float.valueOf(0.0f), Float.valueOf(r11), Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public DeepFeedLinearGradientDrawable(int[] r4, float[] r5) {
        Intrinsics.checkNotNullParameter(r4, "colors");
        Intrinsics.checkNotNullParameter(r5, "positions");
        super(new RectShape());
        this.c = Orientation.LEFT_TO_RIGHT;
        if (r4.length != r5.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.a = r4;
        this.b = r5;
        getPaint().setAntiAlias(true);
        getPaint().setStyle(Paint.Style.FILL);
        return;
    L10:
        throw new IllegalArgumentException("颜色数组和位置数组长度必须一致".toString());
    L5:
        r0 = false;
        goto L6
    }

    public DeepFeedLinearGradientDrawable(int[] r6, float[] r7, float r8) {
        Intrinsics.checkNotNullParameter(r6, "colors");
        Intrinsics.checkNotNullParameter(r7, "positions");
        boolean r2 = false;
        super(new RoundRectShape(new float[]{r8, r8, r8, r8, r8, r8, r8, r8}, null, null));
        this.c = Orientation.LEFT_TO_RIGHT;
        if (r6.length != r7.length) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L9;
        this.a = r6;
        this.b = r7;
        getPaint().setAntiAlias(true);
        getPaint().setStyle(Paint.Style.FILL);
        return;
    L9:
        throw new IllegalArgumentException("颜色数组和位置数组长度必须一致".toString());
    }
}
