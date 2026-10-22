package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f402800g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f402801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f402802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f402803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f402804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f402805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402806f;

    /* JADX INFO: renamed from: com.obric.oui.shadow.a$a, reason: collision with other inner class name */
    public static final class C4679a {
        @JvmStatic
        public static int[] b(a r100) {
            Intrinsics.checkNotNullParameter(r100, "shadowConfig");
            b r101 = r100.b();
            if (r101.f402812f != (-1)) goto L5;
            r101.f402812f = BlendMode.SRC_OVER.getPorterDuffMode();
        L5:
            int r102 = r101.f402812f;
            int[] r103 = {r101.f402810d, r102};
            r100.f402806f = r102;
            return r103;
        }

        @JvmStatic
        public static a a(TypedArray r100, int r110, int r111, int r112, int r113, int r114) {
            Intrinsics.checkNotNullParameter(r100, "typedArray");
            float r115 = r100.getDimension(r112, 0.0f);
            float r116 = r100.getDimension(r113, 0.0f);
            float r117 = r100.getDimension(r111, 0.0f);
            int r118 = r100.getColor(r110, 0);
            float r101 = r100.getDimension(r114, 0.0f);
            b r102 = new b(r115, r116, r117, r118, r101, -1);
            Intrinsics.checkNotNullParameter(r102, "<this>");
            return new a(r115, r116, r117, r118, r101, r102.f402812f);
        }
    }

    static {
    }

    @JvmStatic
    public static final a a(TypedArray r100, int r101, int r102, int r103, int r104, int r105) {
        return C4679a.a(r100, r101, r102, r103, r104, r105);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f402801a), Float.valueOf(r101.f402801a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f402802b), Float.valueOf(r101.f402802b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f402803c), Float.valueOf(r101.f402803c)) == true) goto L18;
        return false;
    L18:
        if (this.f402804d == r101.f402804d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.f402805e), Float.valueOf(r101.f402805e)) == true) goto L24;
        return false;
    L24:
        if (this.f402806f == r101.f402806f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.f402801a) * 31) + Float.floatToIntBits(this.f402802b)) * 31) + Float.floatToIntBits(this.f402803c)) * 31) + this.f402804d) * 31) + Float.floatToIntBits(this.f402805e)) * 31) + this.f402806f;
    }

    public final String toString() {
        return "ShadowConfig(x=" + this.f402801a + ", y=" + this.f402802b + ", blurRadius=" + this.f402803c + ", color=" + this.f402804d + ", spread=" + this.f402805e + ", blendMode=" + this.f402806f + ')';
    }

    public final b b() {
        return new b(this.f402801a, this.f402802b, this.f402803c, this.f402804d, this.f402805e, this.f402806f);
    }

    public a(float r100, float r101, float r102, int r103, float r104, int r105) {
        this.f402801a = r100;
        this.f402802b = r101;
        this.f402803c = r102;
        this.f402804d = r103;
        this.f402805e = r104;
        this.f402806f = r105;
    }
}
