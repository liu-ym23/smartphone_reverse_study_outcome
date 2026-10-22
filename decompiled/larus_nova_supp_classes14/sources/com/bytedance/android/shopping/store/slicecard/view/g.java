package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public final String a;
    public final String b;
    public final ECUrlModel c;
    public final Float d;
    public final Float e;
    public final Float f;
    public final Integer g;
    public final String h;
    public final List<Integer> i;
    public final List<Float> j;
    public final Float k;
    public final String l;
    public final ECUrlModel m;
    public final List<Integer> n;
    public final List<Float> o;
    public final Float p;
    public final List<Float> q;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L40;
        g r4 = (g) r3;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Float r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<Integer> r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<Float> r28 = this.j;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Float r31 = this.k;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        ECUrlModel r37 = this.m;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        List<Integer> r40 = this.n;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        List<Float> r43 = this.o;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Float r46 = this.p;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        List<Float> r49 = this.q;
        if (r49 == null) goto L70;
        r1 = r49.hashCode();
    L70:
        return r48 + r1;
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
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
        return "RichTextItem(text=" + this.a + ", textColor=" + this.b + ", image=" + this.c + ", imageWidthPx=" + this.d + ", imageHeightPx=" + this.e + ", fontSizePx=" + this.f + ", fontWeight=" + this.g + ", fontFamily=" + this.h + ", textColors=" + this.i + ", textPositions=" + this.j + ", textOrientation=" + this.k + ", immersiveTextColor=" + this.l + ", immersiveImage=" + this.m + ", immersiveTextColors=" + this.n + ", immersiveTextPositions=" + this.o + ", immersiveTextOrientation=" + this.p + ", imageMarginPx=" + this.q + ")";
    }

    public final boolean b() {
        if ((!StringsKt.isBlank(this.a)) == false) goto L5;
        return true;
    L5:
        if (this.c == null) goto L7;
        return true;
    L7:
        if (this.m != null) goto L13;
        return false;
    L13:
        return true;
    }

    public static d a(d r4, int r5, float r6) {
        int r0 = r4.a.length;
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = ColorUtils.blendARGB(r4.a[r2], r5, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        float[] r7 = r4.b;
        float r8 = r4.c;
        Intrinsics.checkNotNullParameter(r1, "colors");
        return new d(r1, r7, r8);
    }

    public static d c(List r6, List r7, Float r8) {
        boolean r1 = false;
        if (r6.size() < 2) goto L5;
        boolean r0 = true;
    L6:
        float[] r2 = null;
        if (r0 == false) goto L9;
        List r3 = r6;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        if (r7.size() != r6.size()) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L19;
        r7 = null;
    L19:
        if (r8 == null) goto L21;
        float r10 = r8.floatValue();
    L22:
        f r4 = b.a;
        int[] r5 = CollectionsKt.toIntArray(r3);
        if (r7 == null) goto L37;
        if (r7.size() != r3.size()) goto L27;
        r1 = true;
    L27:
        if (r1 == true) goto L30;
        r7 = null;
    L30:
        if (r7 == null) goto L37;
        List r11 = r7;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        r12.add(Float.valueOf(RangesKt.coerceIn(((Number) r13.next()).floatValue(), 0.0f, 1.0f)));
        goto L33
    L35:
        r2 = CollectionsKt.toFloatArray(r12);
    L37:
        return new d(r5, r2, r10);
    L21:
        r10 = 0.0f;
        goto L22
    L14:
        r9 = false;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ g(String r22, String r23, ECUrlModel r24, int r25) {
        List r2 = null;
        if ((r25 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r25 & 4) == 0) goto L9;
        ECUrlModel r6 = null;
    L11:
        if ((r25 & 256) == 0) goto L13;
        List r12 = CollectionsKt.emptyList();
    L15:
        if ((r25 & 512) == 0) goto L17;
        List r13 = CollectionsKt.emptyList();
    L19:
        if ((r25 & 8192) == 0) goto L21;
        List r17 = CollectionsKt.emptyList();
    L23:
        if ((r25 & 16384) == 0) goto L25;
        List r18 = CollectionsKt.emptyList();
    L27:
        if ((r25 & 65536) == 0) goto L29;
        r2 = CollectionsKt.emptyList();
    L29:
        this(r22, r5, r6, null, null, null, null, null, r12, r13, null, null, null, r17, r18, null, r2);
        return;
    L25:
        r18 = null;
        goto L27
    L21:
        r17 = null;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r12 = null;
        goto L15
    L9:
        r6 = r24;
        goto L11
    L5:
        r5 = r23;
        goto L7
    }

    public final e d(float r20, int r21, float r22, PropertyReference0Impl r23) {
        float r3 = RangesKt.coerceIn(1.0f - r20, 0.0f, 1.0f);
        d r5 = c(this.i, this.j, this.k);
        d r6 = c(this.n, this.o, this.p);
        String r7 = this.b;
        float[] r8 = null;
        if (r7 != null) goto L5;
    L10:
        int r9 = r21;
    L11:
        String r10 = this.l;
        if (r10 != null) goto L14;
    L19:
        Integer r11 = null;
    L21:
        if (r5 == null) goto L52;
        if (r6 == null) goto L52;
        int r2 = Math.min(r5.a.length, r6.a.length);
        int[] r12 = new int[r2];
        int r13 = 0;
    L24:
        if (r13 >= r2) goto L26;
        r12[r13] = ColorUtils.blendARGB(r5.a[r13], r6.a[r13], r3);
        r13 = r13 + 1;
        goto L24
    L26:
        float[] r14 = r5.b;
        if (r14 == null) goto L37;
        float[] r15 = r6.b;
        if (r15 == null) goto L37;
        if (r14.length < r2) goto L37;
        if (r15.length < r2) goto L37;
        float[] r16 = new float[r2];
        int r17 = 0;
    L35:
        if (r17 >= r2) goto L48;
        float r18 = r5.b[r17];
        r16[r17] = r18 + ((r6.b[r17] - r18) * r3);
        r17 = r17 + 1;
    L48:
        if (r3 < 0.5f) goto L50;
        float r4 = r6.c;
    L51:
        r5 = new d(r12, r16, r4);
    L60:
        if (r5 == null) goto L62;
        Integer r19 = null;
    L67:
        if (Intrinsics.areEqual(this.h, "DouyinSans") == false) goto L71;
        Typeface r1 = (Typeface) r23.invoke();
        if (r1 != null) goto L81;
        r1 = Typeface.DEFAULT;
    L81:
        Integer r24 = this.g;
        if (r24 != null) goto L84;
    L86:
        Typeface r110 = r1;
        if (r5 == null) goto L89;
        int[] r111 = r5.a;
    L90:
        if (r5 == null) goto L92;
        r8 = r5.b;
    L92:
        float[] r112 = r8;
        Float r25 = this.f;
        if (r25 == null) goto L95;
        float r113 = r25.floatValue();
    L96:
        if (r5 == null) goto L98;
        Float r26 = Float.valueOf(r5.c);
    L99:
        if (r26 == null) goto L101;
        float r114 = r26.floatValue();
    L103:
        return new e(r19, r111, r112, r113, r110, r114);
    L101:
        r114 = 0.0f;
        goto L103
    L98:
        r26 = this.k;
        goto L99
    L95:
        r113 = r22;
        goto L96
    L89:
        r111 = null;
        goto L90
    L84:
        if (r24.intValue() < 600) goto L86;
        r1 = Typeface.create(r1, 1);
        goto L86
    L71:
        String r27 = this.h;
        if (r27 != null) goto L74;
    L77:
        boolean r28 = true;
    L78:
        if (r28 == true) goto L80;
        r1 = Typeface.create(this.h, 0);
        goto L81
    L80:
        r1 = null;
        goto L81
    L74:
        if (StringsKt.isBlank(r27) == true) goto L77;
        r28 = false;
        goto L78
    L62:
        if (r11 == null) goto L64;
        Integer r29 = Integer.valueOf(ColorUtils.blendARGB(r9, r11.intValue(), r3));
    L65:
        r19 = r29;
        goto L67
    L64:
        r29 = Integer.valueOf(r21);
        goto L65
    L50:
        r4 = r5.c;
    L37:
        float[] r30 = r6.b;
        if (r30 != null) goto L40;
    L42:
        if (r14 != null) goto L44;
    L46:
        r16 = null;
        goto L48
    L44:
        if (r14.length < r2) goto L46;
        r16 = Arrays.copyOf(r14, r2);
        goto L48
    L40:
        if (r30.length < r2) goto L42;
        r16 = Arrays.copyOf(r30, r2);
    L52:
        if (r5 == null) goto L55;
        if (r11 == null) goto L55;
        r5 = a(r5, r11.intValue(), r3);
    L55:
        if (r6 == null) goto L57;
        r5 = a(r6, r9, 1.0f - r3);
        goto L60
    L57:
        if (r5 != null) goto L60;
        r5 = null;
        goto L60
    L14:
        if ((!StringsKt.isBlank(r10)) == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L19;
        r11 = Integer.valueOf(s.a(r10, r21));
        goto L21
    L5:
        if ((!StringsKt.isBlank(r7)) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L10;
        r9 = s.a(r7, r21);
        goto L11
    }

    public g(String r9, String r10, ECUrlModel r11, Float r12, Float r13, Float r14, Integer r15, String r16, List<Integer> r17, List<Float> r18, Float r19, String r20, ECUrlModel r21, List<Integer> r22, List<Float> r23, Float r24, List<Float> r25) {
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r17, "textColors");
        Intrinsics.checkNotNullParameter(r18, "textPositions");
        Intrinsics.checkNotNullParameter(r22, "immersiveTextColors");
        Intrinsics.checkNotNullParameter(r23, "immersiveTextPositions");
        Intrinsics.checkNotNullParameter(r25, "imageMarginPx");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.q = r25;
    }
}
