package yt;

import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f569007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f569009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f569010d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f569011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f569012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f569013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f569014d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f569011a == r101.f569011a) goto L8;
            return false;
        L8:
            if (this.f569012b == r101.f569012b) goto L10;
            return false;
        L10:
            if (this.f569013c == r101.f569013c) goto L12;
            return false;
        L12:
            if (this.f569014d == r101.f569014d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f569011a * 31) + this.f569012b) * 31) + this.f569013c) * 31) + this.f569014d;
        }

        public final String toString() {
            return "RGBA(r=" + this.f569011a + ", g=" + this.f569012b + ", b=" + this.f569013c + ", a=" + this.f569014d + ")";
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f569011a = r100;
            this.f569012b = r101;
            this.f569013c = r102;
            this.f569014d = r103;
        }
    }

    public final int a(float r100) {
        if (Intrinsics.areEqual(this.f569009c, this.f569010d) == false) goto L7;
        return this.f569007a;
    L7:
        if (r100 > 0) goto L11;
        return this.f569007a;
    L11:
        if (r100 >= 1) goto L13;
        a r101 = this.f569009c;
        int r102 = r101.f569014d;
        a r103 = this.f569010d;
        int r104 = (int) (r102 + ((r103.f569014d - r102) * r100));
        int r105 = r101.f569011a;
        int r106 = (int) (r105 + ((r103.f569011a - r105) * r100));
        int r107 = r101.f569012b;
        int r108 = (int) (r107 + ((r103.f569012b - r107) * r100));
        int r109 = r101.f569013c;
        return Color.argb(r104, r106, r108, (int) (r109 + ((r103.f569013c - r109) * r100)));
    L13:
        return this.f569008b;
    }

    public h(int r100, int r101) {
        this.f569007a = r100;
        this.f569008b = r101;
        this.f569009c = new a((r100 >> 16) & 255, (r100 >> 8) & 255, r100 & 255, (r100 >> 24) & 255);
        this.f569010d = new a((r101 >> 16) & 255, (r101 >> 8) & 255, r101 & 255, (r101 >> 24) & 255);
    }
}
