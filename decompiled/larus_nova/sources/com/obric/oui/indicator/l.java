package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f401268a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f401269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f401270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401271c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f401269a == r101.f401269a) goto L12;
            return false;
        L12:
            if (this.f401270b == r101.f401270b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f401271c), Float.valueOf(r101.f401271c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f401269a * 31) + this.f401270b) * 31) + Float.floatToIntBits(this.f401271c);
        }

        public final String toString() {
            return "ScrollState(selectedPosition=" + this.f401269a + ", nextPosition=" + this.f401270b + ", positionOffset=" + this.f401271c + ')';
        }

        public a(int r100, int r101, float r102) {
            this.f401269a = r100;
            this.f401270b = r101;
            this.f401271c = r102;
        }
    }

    public abstract int a();

    public abstract void c(int r100, int r101, float r102);

    public l() {
        this.f401268a = "OnPageChangeHelper";
    }

    public final void b(int r100, float r101) {
        int r102 = a();
        if (r102 > 0) goto L5;
        int r103 = pla.b.f529795a;
        pla.b.b(this.f401268a, Intrinsics.stringPlus("Ignore onPageScrolled because pageCount=", Integer.valueOf(r102)));
    L15:
        a r104 = null;
    L23:
        if (r104 != null) goto L33;
        return;
    L33:
        c(r104.f401269a, r104.f401270b, r104.f401271c);     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L31;
        int r105 = pla.b.f529795a;
        pla.b.b(this.f401268a, Intrinsics.stringPlus("OIndicator: ", e.getMessage()));
        return;
    L31:
        int r106 = pla.b.f529795a;
        Intrinsics.checkNotNullParameter(this.f401268a, "tag");
        Intrinsics.checkNotNullParameter("抓住了一个Exception并ignore", "msg");
        return;
    L5:
        boolean r107 = true;
        if (r102 != 1) goto L8;
        r104 = new a(0, 0, 0.0f);
        goto L23
    L8:
        int r108 = r102 - 1;
        if (r100 < 0) goto L12;
        if (r100 > r108) goto L12;
    L13:
        if (r107 == true) goto L16;
        int r109 = pla.b.f529795a;
        pla.b.b(this.f401268a, "Ignore onPageScrolled because position=" + r100 + ", pageCount=" + r102);
        goto L15
    L16:
        if (r100 == r108) goto L18;
    L20:
        if (r100 != r108) goto L22;
        r104 = new a(r108, r108, 0.0f);
        goto L23
    L22:
        r104 = new a(r100, r100 + 1, r101);
        goto L23
    L18:
        if (r101 <= 0.0f) goto L20;
        r104 = new a(r108, 0, r101);
    L12:
        r107 = false;
        goto L13
    }
}
