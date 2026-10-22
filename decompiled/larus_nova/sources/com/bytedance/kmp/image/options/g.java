package com.bytedance.kmp.image.options;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f252138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f252139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f252140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f252141d;

        public a() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f252138a == r101.f252138a) goto L12;
            return false;
        L12:
            if (this.f252139b == r101.f252139b) goto L15;
            return false;
        L15:
            if (this.f252140c == r101.f252140c) goto L18;
            return false;
        L18:
            if (this.f252141d == r101.f252141d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f252138a * 31) + this.f252139b) * 31) + this.f252140c) * 31) + this.f252141d;
        }

        public final String toString() {
            return "Rect(left=" + this.f252138a + ", top=" + this.f252139b + ", right=" + this.f252140c + ", bottom=" + this.f252141d + ')';
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f252138a = r100;
            this.f252139b = r101;
            this.f252140c = r102;
            this.f252141d = r103;
        }
    }

    public static final class b {
        public b(a r100) {
            Intrinsics.checkNotNullParameter(r100, "cropRect");
        }
    }

    void onFail(Throwable r100);

    void onLoadStart();

    void onSuccess(b r100);
}
