package yc9;

import com.larus.im.bean.message.ImageDisplaySize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageDisplaySize f567277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f567278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f567279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f567280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f567281e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f567277a == r101.f567277a) goto L12;
        return false;
    L12:
        if (this.f567278b == r101.f567278b) goto L15;
        return false;
    L15:
        if (this.f567279c == r101.f567279c) goto L18;
        return false;
    L18:
        if (this.f567280d == r101.f567280d) goto L21;
        return false;
    L21:
        if (this.f567281e == r101.f567281e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f567277a.hashCode() * 31;
        int r101 = 1231;
        if (this.f567278b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f567279c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f567280d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f567281e == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageDisplaySetting(size=" + this.f567277a + ", roundTopLeft=" + this.f567278b + ", roundTopRight=" + this.f567279c + ", roundBottomLeft=" + this.f567280d + ", roundBottomRight=" + this.f567281e + ')';
    }

    public s(ImageDisplaySize r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "size");
        this.f567277a = r100;
        this.f567278b = r101;
        this.f567279c = r102;
        this.f567280d = r103;
        this.f567281e = r104;
    }
}
