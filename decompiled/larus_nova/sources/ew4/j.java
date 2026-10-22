package ew4;

import com.bytedance.ee.bear.config.CommonAlbumMediaMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f474563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f474564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonAlbumMediaMode f474565d;

    public j() {
        this(null, false, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f474562a, r101.f474562a) == true) goto L12;
        return false;
    L12:
        if (this.f474563b == r101.f474563b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474564c, r101.f474564c) == true) goto L18;
        return false;
    L18:
        if (this.f474565d == r101.f474565d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474562a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f474563b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        Integer r106 = this.f474564c;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return ((r105 + r101) * 31) + this.f474565d.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonAlbumRequest(srcObjToken=" + this.f474562a + ", allowMultiple=" + this.f474563b + ", maxSelectCount=" + this.f474564c + ", mediaMode=" + this.f474565d + ')';
    }

    public j(String r100, boolean r101, CommonAlbumMediaMode r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = CommonAlbumMediaMode.ALL;
    L11:
        Intrinsics.checkNotNullParameter(r102, "mediaMode");
        this.f474562a = r100;
        this.f474563b = r101;
        this.f474564c = null;
        this.f474565d = r102;
    }
}
