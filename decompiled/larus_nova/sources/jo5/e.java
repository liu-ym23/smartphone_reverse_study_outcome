package jo5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThumbGlideUrl f499897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Response f499898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f499899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f499900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f499901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f499902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f499903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f499904h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f499897a, r101.f499897a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499898b, r101.f499898b) == true) goto L15;
        return false;
    L15:
        if (this.f499899c == r101.f499899c) goto L18;
        return false;
    L18:
        if (this.f499900d == r101.f499900d) goto L21;
        return false;
    L21:
        if (this.f499901e == r101.f499901e) goto L24;
        return false;
    L24:
        if (this.f499902f == r101.f499902f) goto L27;
        return false;
    L27:
        if (this.f499903g == r101.f499903g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ThumbGlideUrl r100 = this.f499897a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Response r104 = this.f499898b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((((((r103 + r101) * 31) + this.f499899c) * 31) + this.f499900d) * 31) + this.f499901e) * 31) + this.f499902f) * 31;
        if (this.f499903g == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetPlaceHolderParam(glideUrl=" + this.f499897a + ", response=" + this.f499898b + ", paddingX=" + this.f499899c + ", paddingY=" + this.f499900d + ", offsetX=" + this.f499901e + ", offsetY=" + this.f499902f + ", isUrlEncrypt=" + this.f499903g + ')';
    }

    public e(ThumbGlideUrl r100, Response r101, int r102, int r103, int r104, boolean r105) {
        this.f499897a = r100;
        this.f499898b = r101;
        this.f499899c = r102;
        this.f499900d = r103;
        this.f499901e = 0;
        this.f499902f = r104;
        this.f499903g = r105;
    }
}
