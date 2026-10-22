package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.core.EffectProperty;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qma.j;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f403323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f403324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f403325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f403326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f403327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f403328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f403329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f403330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j.b f403331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f403332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final qma.d f403333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qma.d f403334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final qma.d f403335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<EffectProperty, qma.d> f403336n;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f403323a, r101.f403323a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f403324b, r101.f403324b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f403325c, r101.f403325c) == true) goto L18;
        return false;
    L18:
        if (this.f403326d == r101.f403326d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.f403327e), Float.valueOf(r101.f403327e)) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Float.valueOf(this.f403328f), Float.valueOf(r101.f403328f)) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(Float.valueOf(this.f403329g), Float.valueOf(r101.f403329g)) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(Float.valueOf(this.f403330h), Float.valueOf(r101.f403330h)) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f403331i, r101.f403331i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(Float.valueOf(this.f403332j), Float.valueOf(r101.f403332j)) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f403333k, r101.f403333k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f403334l, r101.f403334l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f403335m, r101.f403335m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f403336n, r101.f403336n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f403323a.hashCode() * 31) + this.f403324b.hashCode()) * 31;
        String r101 = this.f403325c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f403326d;
        int r105 = (((((((((((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31) + Float.floatToIntBits(this.f403327e)) * 31) + Float.floatToIntBits(this.f403328f)) * 31) + Float.floatToIntBits(this.f403329g)) * 31) + Float.floatToIntBits(this.f403330h)) * 31;
        j.b r106 = this.f403331i;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (((r105 + r107) * 31) + Float.floatToIntBits(this.f403332j)) * 31;
        qma.d r109 = this.f403333k;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        qma.d r112 = this.f403334l;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        qma.d r115 = this.f403335m;
        if (r115 == null) goto L23;
        r102 = r115.hashCode();
    L23:
        return ((r114 + r102) * 31) + this.f403336n.hashCode();
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LayerFrame(stageId=" + this.f403323a + ", layerId=" + this.f403324b + ", bindingKey=" + this.f403325c + ", stagePlayTimeMs=" + this.f403326d + ", alpha=" + this.f403327e + ", gradientAlpha=" + this.f403328f + ", scanProgress=" + this.f403329g + ", tracking=" + this.f403330h + ", scanSelector=" + this.f403331i + ", visibility=" + this.f403332j + ", blurRadius=" + this.f403333k + ", translationX=" + this.f403334l + ", translationY=" + this.f403335m + ", properties=" + this.f403336n + ')';
    }

    public d(String r100, String r101, String r102, long r103, float r104, float r105, float r110, j.b r111, float r112, qma.d r113, qma.d r114, qma.d r115) {
        Map<EffectProperty, qma.d> r106 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "stageId");
        Intrinsics.checkNotNullParameter(r101, "layerId");
        Intrinsics.checkNotNullParameter(r106, "properties");
        this.f403323a = r100;
        this.f403324b = r101;
        this.f403325c = r102;
        this.f403326d = r103;
        this.f403327e = r104;
        this.f403328f = Float.NaN;
        this.f403329g = r105;
        this.f403330h = r110;
        this.f403331i = r111;
        this.f403332j = r112;
        this.f403333k = r113;
        this.f403334l = r114;
        this.f403335m = r115;
        this.f403336n = r106;
    }
}
