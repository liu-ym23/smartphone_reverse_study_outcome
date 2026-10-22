package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class h {

    public static final class a extends h {
        public final ECUrlModel a;
        public final ECUrlModel b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final float g;

        public a() {
            this(null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L20;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r4.c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.d, r4.d) == 0) goto L14;
            return false;
        L14:
            if (Float.compare(this.e, r4.e) == 0) goto L16;
            return false;
        L16:
            if (Float.compare(this.f, r4.f) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.g, r4.g) == 0) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ECUrlModel r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((((((((((r3 + r1) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g);
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Icon(image=" + this.a + ", immersiveImage=" + this.b + ", widthPx=" + this.c + ", heightPx=" + this.d + ", marginLeftPx=" + this.e + ", marginRightPx=" + this.f + ", drawWidth=" + this.g + ")";
        }

        public a(ECUrlModel r1, ECUrlModel r2, float r3, float r4, float r5, float r6, float r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class b extends h {
        public final String a;
        public final boolean b;
        public final Integer c;
        public final int[] d;
        public final float[] e;
        public final Float f;
        public final Typeface g;
        public final float h;
        public final float i;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L24;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
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
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Float.compare(this.h, r4.h) == 0) goto L22;
            return false;
        L22:
            if (Float.compare(this.i, r4.i) == 0) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 == null) goto L12;
            int r8 = r7.hashCode();
        L13:
            int r9 = (r6 + r8) * 31;
            int[] r10 = this.d;
            if (r10 == null) goto L16;
            int r11 = Arrays.hashCode(r10);
        L17:
            int r12 = (r9 + r11) * 31;
            float[] r13 = this.e;
            if (r13 == null) goto L20;
            int r14 = Arrays.hashCode(r13);
        L21:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L24;
            int r17 = r16.hashCode();
        L25:
            int r18 = (r15 + r17) * 31;
            Typeface r19 = this.g;
            if (r19 == null) goto L29;
            r1 = r19.hashCode();
        L29:
            return ((((r18 + r1) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i);
        L24:
            r17 = 0;
            goto L25
        L20:
            r14 = 0;
            goto L21
        L16:
            r11 = 0;
            goto L17
        L12:
            r8 = 0;
            goto L13
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Text(text=" + this.a + ", gradient=" + this.b + ", color=" + this.c + ", gradientColors=" + Arrays.toString(this.d) + ", gradientPositions=" + Arrays.toString(this.e) + ", textSizePx=" + this.f + ", typeface=" + this.g + ", gradientOrientation=" + this.h + ", drawWidth=" + this.i + ")";
        }

        public /* synthetic */ b(String r11, boolean r12, Integer r13, int[] r14, float[] r15, Float r16, Typeface r17, float r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, 0.0f);
        }

        public b(String r2, boolean r3, Integer r4, int[] r5, float[] r6, Float r7, Typeface r8, float r9, float r10) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public h() {
    }
}
