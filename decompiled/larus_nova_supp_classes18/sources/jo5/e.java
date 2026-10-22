package jo5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final ThumbGlideUrl a;
    public final Response b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ThumbGlideUrl r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Response r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((((((((r3 + r1) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        if (this.g == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetPlaceHolderParam(glideUrl=" + this.a + ", response=" + this.b + ", paddingX=" + this.c + ", paddingY=" + this.d + ", offsetX=" + this.e + ", offsetY=" + this.f + ", isUrlEncrypt=" + this.g + ')';
    }

    public e(ThumbGlideUrl r1, Response r2, int r3, int r4, int r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = 0;
        this.f = r5;
        this.g = r6;
    }
}
