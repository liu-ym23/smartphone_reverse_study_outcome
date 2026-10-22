package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f401452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kma.a f401453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.color.a[] f401454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kma.c f401455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0 f401456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kma.a f401457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.obric.oui.blur.a f401458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f401459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.obric.oui.shadow.a[] f401460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.fluid.a f401461j;

    public c() {
        this(null, null, null, null, null, null, null, null, 1023);
    }

    public final String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.f401452a + ", blendConfigStateList=" + this.f401453b + ", blendConfig=" + Arrays.toString(this.f401454c) + ", strokeStateList=" + this.f401455d + ", stroke=" + this.f401456e + ", overlayBlendConfigStateList=" + this.f401457f + ", blurConfig=" + this.f401458g + ", blurRadius=" + this.f401459h + ", shadow=" + Arrays.toString(this.f401460i) + ", fluid=" + this.f401461j + ')';
    }

    public final c a() {
        ColorStateList r100 = this.f401452a;
        kma.a r101 = this.f401453b;
        if (r101 != null) goto L5;
        kma.b r102 = null;
    L6:
        com.obric.oui.color.a[] r103 = this.f401454c;
        if (r103 != null) goto L9;
        com.obric.oui.color.b[] r104 = null;
    L10:
        kma.c r105 = this.f401455d;
        if (r105 != null) goto L13;
        kma.d r106 = null;
    L14:
        i0 r107 = this.f401456e;
        if (r107 != null) goto L17;
        j0 r108 = null;
    L18:
        kma.a r109 = this.f401457f;
        if (r109 != null) goto L21;
        kma.b r110 = null;
    L22:
        com.obric.oui.blur.a r111 = this.f401458g;
        if (r111 != null) goto L25;
        com.obric.oui.blur.b r112 = null;
    L26:
        Float r113 = this.f401459h;
        com.obric.oui.shadow.a[] r114 = this.f401460i;
        String r115 = "<this>";
        if (r114 != null) goto L29;
        com.obric.oui.shadow.b[] r116 = null;
    L35:
        com.obric.oui.fluid.a r117 = this.f401461j;
        if (r117 != null) goto L38;
        com.obric.oui.fluid.b r118 = null;
    L40:
        if (r100 == null) goto L42;
        ColorStateList r119 = r100;
    L43:
        if (r102 == null) goto L45;
        kma.b r120 = r102.b();
    L46:
        com.obric.oui.color.b r121 = com.obric.oui.color.b.f399490c;
        if (r104 != null) goto L49;
        com.obric.oui.color.b[] r122 = null;
    L58:
        if (r106 == null) goto L76;
        int[][] r123 = new int[r106.f504122a.length][];
        int r124 = 0;
    L60:
        int[][] r125 = r106.f504122a;
        if (r124 >= r125.length) goto L63;
        int[] r126 = r125[r124];
        r123[r124] = Arrays.copyOf(r126, r126.length);
        r124 = r124 + 1;
        goto L60
    L63:
        j0[] r127 = new j0[r106.f504123b.length];
        int r128 = 0;
    L64:
        j0[] r129 = r106.f504123b;
        if (r128 >= r129.length) goto L71;
        j0 r130 = r129[r128];
        if (r130 != null) goto L69;
        j0 r131 = null;
    L70:
        r127[r128] = r131;
        r128 = r128 + 1;
        r115 = r115;
        goto L64
    L69:
        r131 = new j0(r130.f399496a, r130.f399497b, r130.f399498c);
        goto L70
    L71:
        String r210 = r115;
        j0 r132 = r106.f504124c;
        if (r132 != null) goto L74;
        j0 r133 = null;
    L75:
        kma.d r211 = new kma.d(r123, r127, r133);
    L77:
        if (r108 == null) goto L79;
        j0 r212 = new j0(r108.f399496a, r108.f399497b, r108.f399498c);
    L80:
        if (r110 == null) goto L82;
        kma.b r213 = r110.b();
    L83:
        if (r112 == null) goto L85;
        com.obric.oui.blur.b r214 = new com.obric.oui.blur.b(r112.f398871a, r112.f398872b, r112.f398873c, r112.f398874d, r112.f398875e);
    L86:
        if (r116 != null) goto L88;
        com.obric.oui.shadow.b[] r215 = null;
    L97:
        if (r118 == null) goto L103;
        float[] r134 = r118.f400849a;
        if (r134 == null) goto L101;
        float[] r135 = (float[]) r134.clone();
    L102:
        com.obric.oui.fluid.b r216 = new com.obric.oui.fluid.b(r135);
    L104:
        c r136 = f.a(new e(r119, r120, r122, r211, r212, r213, r214, r113, r215, r216));
        ColorStateList r137 = this.f401452a;
        if (r137 != null) goto L107;
        ColorStateList r138 = null;
    L110:
        r136.f401452a = r138;
        return r136;
    L107:
        Intrinsics.checkNotNullParameter(r137, r210);
        Parcel r139 = Parcel.obtain();
        r137.writeToParcel(r139, 0);     // Catch: Throwable -> L112
        r139.setDataPosition(0);     // Catch: Throwable -> L112
        ColorStateList r140 = (ColorStateList) ColorStateList.CREATOR.createFromParcel(r139);     // Catch: Throwable -> L112
        r139.recycle();
        r138 = r140;
    L112:
        th = move-exception;
        r139.recycle();
        throw th;
    L101:
        r135 = null;
        goto L102
    L103:
        r216 = null;
        goto L104
    L88:
        com.obric.oui.shadow.b[] r141 = new com.obric.oui.shadow.b[r116.length];
        int r142 = 0;
    L90:
        if (r142 >= r116.length) goto L96;
        com.obric.oui.shadow.b r143 = r116[r142];
        if (r143 != null) goto L94;
        com.obric.oui.shadow.b r144 = null;
    L95:
        r141[r142] = r144;
        r142 = r142 + 1;
        goto L90
    L94:
        r144 = new com.obric.oui.shadow.b(r143.f402807a, r143.f402808b, r143.f402809c, r143.f402810d, r143.f402811e, r143.f402812f);
        goto L95
    L96:
        r215 = r141;
        goto L97
    L85:
        r214 = null;
        goto L86
    L82:
        r213 = null;
        goto L83
    L79:
        r212 = null;
        goto L80
    L74:
        r133 = new j0(r132.f399496a, r132.f399497b, r132.f399498c);
        goto L75
    L76:
        r210 = "<this>";
        r211 = null;
        goto L77
    L49:
        com.obric.oui.color.b[] r145 = new com.obric.oui.color.b[r104.length];
        int r146 = 0;
    L51:
        if (r146 >= r104.length) goto L57;
        com.obric.oui.color.b r147 = r104[r146];
        if (r147 != null) goto L55;
        com.obric.oui.color.b r148 = null;
    L56:
        r145[r146] = r148;
        r146 = r146 + 1;
        goto L51
    L55:
        r148 = new com.obric.oui.color.b(r147.f399491a, r147.f399492b);
        goto L56
    L57:
        r122 = r145;
        goto L58
    L45:
        r120 = null;
        goto L46
    L42:
        r119 = null;
        goto L43
    L38:
        r118 = new com.obric.oui.fluid.b(r117.f400848a);
        goto L40
    L29:
        Intrinsics.checkNotNullParameter(r114, "<this>");
        ArrayList r149 = new ArrayList(r114.length);
        int r150 = r114.length;
        int r151 = 0;
    L30:
        if (r151 >= r150) goto L32;
        r149.add(r114[r151].b());
        r151 = r151 + 1;
        goto L30
    L32:
        Object[] r152 = r149.toArray(new com.obric.oui.shadow.b[0]);
        if (r152 == null) goto L116;
        r116 = (com.obric.oui.shadow.b[]) r152;
        goto L35
    L116:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L25:
        r112 = new com.obric.oui.blur.b(r111.f398866a, r111.f398867b, r111.f398868c, r111.f398869d, r111.f398870e);
        goto L26
    L21:
        r110 = r109.f504113a;
        goto L22
    L17:
        r108 = r107.a();
        goto L18
    L13:
        r106 = r105.f504120a;
        goto L14
    L9:
        r104 = com.obric.oui.color.c.b(r103);
        goto L10
    L5:
        r102 = r101.f504113a;
        goto L6
    }

    public final int hashCode() {
        Float r100 = this.f401459h;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ColorStateList r104 = this.f401452a;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        kma.a r107 = this.f401453b;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        com.obric.oui.color.a[] r110 = this.f401454c;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        kma.c r113 = this.f401455d;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        i0 r116 = this.f401456e;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        kma.a r119 = this.f401457f;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        com.obric.oui.blur.a r122 = this.f401458g;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        com.obric.oui.shadow.a[] r125 = this.f401460i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        com.obric.oui.fluid.a r128 = this.f401461j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = Arrays.hashCode(r125);
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = Arrays.hashCode(r110);
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        Class<?> r101 = null;
    L10:
        if (Intrinsics.areEqual(c.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L45;
        c r102 = (c) r100;
        if (Intrinsics.areEqual(this.f401459h, r102.f401459h) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.f401452a, r102.f401452a) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f401453b, r102.f401453b) == true) goto L23;
        return false;
    L23:
        if (Arrays.equals(this.f401454c, r102.f401454c) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f401455d, r102.f401455d) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.f401456e, r102.f401456e) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f401457f, r102.f401457f) == true) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.f401458g, r102.f401458g) == true) goto L38;
        return false;
    L38:
        if (Arrays.equals(this.f401460i, r102.f401460i) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.f401461j, r102.f401461j) == true) goto L43;
        return false;
    L43:
        return true;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
    L8:
        r101 = r100.getClass();
        goto L10
    }

    public /* synthetic */ c(ColorStateList r110, kma.a r111, com.obric.oui.color.a[] r112, i0 r113, com.obric.oui.blur.a r114, Float r210, com.obric.oui.shadow.a[] r211, com.obric.oui.fluid.a r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        ColorStateList r100 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        kma.a r101 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        com.obric.oui.color.a[] r102 = null;
    L15:
        if ((r213 & 16) == 0) goto L17;
        i0 r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        com.obric.oui.blur.a r115 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        Float r116 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        com.obric.oui.shadow.a[] r117 = null;
    L31:
        if ((r213 & 512) == 0) goto L33;
        com.obric.oui.fluid.a r118 = null;
    L34:
        this(r100, r101, r102, null, r103, null, r115, r116, r117, r118);
        return;
    L33:
        r118 = r212;
        goto L34
    L29:
        r117 = r211;
        goto L31
    L25:
        r116 = r210;
        goto L27
    L21:
        r115 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public c(ColorStateList r100, kma.a r101, com.obric.oui.color.a[] r102, kma.c r103, i0 r104, kma.a r105, com.obric.oui.blur.a r106, Float r107, com.obric.oui.shadow.a[] r108, com.obric.oui.fluid.a r110) {
        this.f401452a = r100;
        this.f401453b = r101;
        this.f401454c = r102;
        this.f401455d = r103;
        this.f401456e = r104;
        this.f401457f = r105;
        this.f401458g = r106;
        this.f401459h = r107;
        this.f401460i = r108;
        this.f401461j = r110;
    }
}
