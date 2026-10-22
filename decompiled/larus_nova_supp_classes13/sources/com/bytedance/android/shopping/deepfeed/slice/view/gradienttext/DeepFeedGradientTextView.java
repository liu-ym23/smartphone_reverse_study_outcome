package com.bytedance.android.shopping.deepfeed.slice.view.gradienttext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/gradienttext/DeepFeedGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedGradientTextView extends AppCompatTextView {
    public b a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView$a$a, reason: collision with other inner class name */
        public static final class C0055a extends a {
            public final float a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0055a) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.a, ((C0055a) r2).a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.a);
            }

            public final String toString() {
                return "Percent(value=" + this.a + ")";
            }

            public C0055a(float r1) {
                this.a = r1;
            }
        }

        public static final class b extends a {
            public final float a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof b) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.a, ((b) r2).a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.a);
            }

            public final String toString() {
                return "Px(value=" + this.a + ")";
            }

            public b(float r1) {
                this.a = r1;
            }
        }

        public a() {
        }

        public final float a(float r2) {
            if ((this instanceof b) == false) goto L6;
            return ((b) this).a;
        L6:
            if ((this instanceof C0055a) == false) goto L10;
            return r2 * ((C0055a) this).a;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final int[] a;
            public final float[] b;
            public final float c;

            public final int hashCode() {
                int[] r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Arrays.hashCode(r0);
            L6:
                int r3 = r2 * 31;
                float[] r4 = this.b;
                if (r4 == null) goto L10;
                r1 = Arrays.hashCode(r4);
            L10:
                return ((r3 + r1) * 31) + Float.floatToIntBits(this.c);
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Linear(colors=" + Arrays.toString(this.a) + ", stops=" + Arrays.toString(this.b) + ", angle=" + this.c + ")";
            }

            @Override // com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView.b
            public final int[] a() {
                return this.a;
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof a) == false) goto L12;
                a r4 = (a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
                return false;
            L10:
                if (Float.compare(this.c, r4.c) == 0) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public a(int[] r2, float[] r3, float r4) {
                Intrinsics.checkNotNullParameter(r2, "colors");
                super(r2);
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView$b$b, reason: collision with other inner class name */
        public static final class C0056b extends b {
            public final int[] a;
            public final float[] b;
            public final a c;
            public final a d;
            public final a e;
            public final a f;

            public final int hashCode() {
                int[] r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Arrays.hashCode(r0);
            L6:
                int r3 = r2 * 31;
                float[] r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = Arrays.hashCode(r4);
            L10:
                int r6 = (r3 + r5) * 31;
                a r7 = this.c;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                a r10 = this.d;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                a r13 = this.e;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                a r16 = this.f;
                if (r16 == null) goto L26;
                r1 = r16.hashCode();
            L26:
                return r15 + r1;
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
                return "Radial(colors=" + Arrays.toString(this.a) + ", stops=" + Arrays.toString(this.b) + ", centerX=" + this.c + ", centerY=" + this.d + ", radiusX=" + this.e + ", radiusY=" + this.f + ")";
            }

            @Override // com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView.b
            public final int[] a() {
                return this.a;
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0056b) == false) goto L18;
                C0056b r4 = (C0056b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public C0056b(int[] r2, float[] r3, a r4, a r5, a r6, a r7) {
                Intrinsics.checkNotNullParameter(r2, "colors");
                Intrinsics.checkNotNullParameter(r4, "centerX");
                Intrinsics.checkNotNullParameter(r5, "centerY");
                Intrinsics.checkNotNullParameter(r6, "radiusX");
                Intrinsics.checkNotNullParameter(r7, "radiusY");
                super(r2);
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }
        }

        public abstract int[] a();

        public b(int[] r1) {
        }
    }

    public DeepFeedGradientTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedGradientTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static Integer x(Object r2) {
        if ((r2 instanceof Number) == true) goto L20;
        Object r1 = null;
        if ((r2 instanceof String) == false) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Integer.valueOf(Color.parseColor((String) r2)));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == true) goto L21;
        r1 = r3;
    L21:
        return (Integer) r1;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return Integer.valueOf(((Number) r2).intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        TextPaint r0 = getPaint();
        float r2 = getWidth();
        float r3 = getHeight();
        b r5 = this.a;
        if (r5 != null) goto L6;
    L4:
        Shader r6 = null;
    L24:
        r0.setShader(r6);
        super/*android.widget.TextView*/.onDraw(r22);
        getPaint().setShader(null);
        return;
    L6:
        if (r2 <= 0.0f) goto L4;
        if (r3 <= 0.0f) goto L4;
        if (r5.a().length < 2) goto L4;
        if ((r5 instanceof b.a) == false) goto L16;
        b.a r7 = (b.a) r5;
        double r8 = Math.toRadians(r7.c);
        float r10 = r2 / 2.0f;
        float r11 = r3 / 2.0f;
        float r9 = (((float) Math.cos(r8)) * r2) / 2.0f;
        float r12 = (((float) Math.sin(r8)) * r3) / 2.0f;
        Shader r20 = new LinearGradient(r10 - r9, r11 - r12, r10 + r9, r11 + r12, r7.a, r7.b, Shader.TileMode.CLAMP);
    L21:
        r6 = r20;
        goto L24
    L16:
        if ((r5 instanceof b.C0056b) == false) goto L23;
        b.C0056b r13 = (b.C0056b) r5;
        float r14 = r13.c.a(r2);
        float r15 = r13.d.a(r3);
        float r4 = Math.max(r13.e.a(r2), 1.0f);
        float r16 = Math.max(r13.f.a(r3), 1.0f);
        float r17 = Math.max(r4, r16);
        RadialGradient r18 = new RadialGradient(r14, r15, r17, r13.a, r13.b, Shader.TileMode.CLAMP);
        if (r4 == r16) goto L20;
        Matrix r19 = new Matrix();
        r19.setScale(r4 / r17, r16 / r17, r14, r15);
        r18.setLocalMatrix(r19);
    L20:
        r20 = r18;
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public static a A(Object r4, a.C0055a r5) {
        if ((r4 instanceof Number) == false) goto L6;
        return new a.b(((Number) r4).floatValue());
    L6:
        if ((r4 instanceof String) == false) goto L19;
        String r6 = (String) r4;
        if (StringsKt.endsWith$default(r6, "%", false, 2, null) == false) goto L13;
        Float r7 = StringsKt.toFloatOrNull(StringsKt.removeSuffix(r6, "%"));
        if (r7 == null) goto L12;
        a r0 = new a.C0055a(r7.floatValue() / 100.0f);
    L17:
        return r0;
    L12:
        return r5;
    L13:
        Float r8 = StringsKt.toFloatOrNull(r6);
        if (r8 == null) goto L20;
        r0 = new a.b(r8.floatValue());
        goto L17
    L20:
        return r5;
    L19:
        return r5;
    }

    public final Float y(Map<String, ? extends Object> r1, String r2) {
        Object r3 = r1.get(r2);
        if ((r3 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r3).floatValue());
    L6:
        if ((r3 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull((String) r3);
    }

    public final Integer z(Map<String, ? extends Object> r1, String r2) {
        Object r3 = r1.get(r2);
        if ((r3 instanceof Number) == false) goto L6;
        return Integer.valueOf(((Number) r3).intValue());
    L6:
        if ((r3 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toIntOrNull((String) r3);
    }

    public DeepFeedGradientTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DeepFeedGradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        invalidate();
    }
}
