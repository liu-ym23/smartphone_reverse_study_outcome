package ew4;

import com.bytedance.ee.bear.config.CommonAlbumMediaMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public final String a;
    public final boolean b;
    public final Integer c;
    public final CommonAlbumMediaMode d;

    public j() {
        this(null, false, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.b == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        Integer r6 = this.c;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return ((r5 + r1) * 31) + this.d.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonAlbumRequest(srcObjToken=" + this.a + ", allowMultiple=" + this.b + ", maxSelectCount=" + this.c + ", mediaMode=" + this.d + ')';
    }

    public j(String r3, boolean r4, CommonAlbumMediaMode r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = CommonAlbumMediaMode.ALL;
    L11:
        Intrinsics.checkNotNullParameter(r5, "mediaMode");
        this.a = r3;
        this.b = r4;
        this.c = null;
        this.d = r5;
    }
}
