package p63;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f527881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f527885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f527886f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f527881a, r101.f527881a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527882b, r101.f527882b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527883c, r101.f527883c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527884d, r101.f527884d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f527885e, r101.f527885e) == true) goto L16;
        return false;
    L16:
        if (this.f527886f == r101.f527886f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.f527881a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527882b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f527883c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f527884d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f527885e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.f527886f;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GuideTagVO(icon=" + this.f527881a + ", title=" + this.f527882b + ", subTitle=" + this.f527883c + ", schema=" + this.f527884d + ", productId=" + this.f527885e + ", orientation=" + this.f527886f + ")";
    }

    public c(ECUrlModel r100, String r101, String r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subTitle");
        Intrinsics.checkNotNullParameter(r103, "schema");
        this.f527881a = r100;
        this.f527882b = r101;
        this.f527883c = r102;
        this.f527884d = r103;
        this.f527885e = r104;
        this.f527886f = r105;
    }
}
