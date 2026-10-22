package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f401541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f401542b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f401543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f401544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f401545c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f401543a), Float.valueOf(r101.f401543a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f401544b), Float.valueOf(r101.f401544b)) == true) goto L15;
            return false;
        L15:
            if (this.f401545c == r101.f401545c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r100 = ((Float.floatToIntBits(this.f401543a) * 31) + Float.floatToIntBits(this.f401544b)) * 31;
            boolean r101 = this.f401545c;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "ScrollValue(value=" + this.f401543a + ", velocity=" + this.f401544b + ", isFinished=" + this.f401545c + ')';
        }

        public b(float r100, float r101, boolean r102) {
            this.f401543a = r100;
            this.f401544b = r101;
            this.f401545c = r102;
        }
    }

    static {
    }

    public c() {
        this(0);
    }

    public final float a() {
        float r100 = Math.abs(0.0f);
        float r101 = this.f401542b;
        if (r100 >= r101) goto L6;
        return 0.0f;
    L6:
        return b(((float) Math.log(r101 / Math.abs(0.0f))) / ((float) Math.log(this.f401541a)));
    }

    public c(int r100) {
        this.f401541a = 0.998f;
        this.f401542b = 0.099999994f;
    }

    public final float b(float r100) {
        return 0.0f + ((((1.0f / ((float) Math.log(this.f401541a))) * 0.0f) * (((float) Math.pow(this.f401541a, r100)) - 1.0f)) * 1.1111112f);
    }

    public final b c(float r100) {
        float r101 = 0.0f * ((float) Math.pow(this.f401541a, r100));
        float r102 = b(r100);
        if (Math.abs(r101) >= this.f401542b) goto L5;
        boolean r103 = true;
    L7:
        return new b(r102, r101, r103);
    L5:
        r103 = false;
        goto L7
    }
}
