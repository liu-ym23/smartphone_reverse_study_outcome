package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f401546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f401547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f401548c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f401549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f401550b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f401549a), Float.valueOf(r101.f401549a)) == true) goto L12;
            return false;
        L12:
            if (this.f401550b == r101.f401550b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            int r100 = Float.floatToIntBits(this.f401549a) * 31;
            boolean r101 = this.f401550b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "SpringBackValue(value=" + this.f401549a + ", isFinished=" + this.f401550b + ')';
        }

        public a(float r100, boolean r101) {
            this.f401549a = r100;
            this.f401550b = r101;
        }
    }

    public d() {
    }

    public final a b(float r100) {
        float r101 = r100 / 1000.0f;
        float r102 = (this.f401546a + (this.f401547b * r101)) * ((float) Math.exp((-this.f401548c) * r101));
        float r103 = this.f401547b;
        float r104 = this.f401548c;
        float r105 = (r103 - ((this.f401546a + (r103 * r101)) * r104)) * ((float) Math.exp((-r104) * r101));
        if (Math.abs(r102) >= 0.1f) goto L8;
        if ((Math.abs(r105) / 1000.0f) >= 0.01f) goto L8;
        return new a(0.0f, true);
    L8:
        return new a(r102, false);
    }

    public final void a(float r100, float r101) {
        this.f401548c = 10.927279f;
        this.f401546a = r101;
        this.f401547b = (r100 * 1000.0f) + (10.927279f * r101);
    }
}
