package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f486652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f486655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f486656e;

    public l1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l1) == true) goto L8;
        return false;
    L8:
        l1 r101 = (l1) r100;
        if (Intrinsics.areEqual(this.f486652a, r101.f486652a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486653b, r101.f486653b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486654c, r101.f486654c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486655d, r101.f486655d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486656e, r101.f486656e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f486652a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f486653b.hashCode()) * 31) + this.f486654c.hashCode()) * 31;
        Integer r104 = this.f486655d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f486656e;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FrontierInfo(productId=" + this.f486652a + ", appKey=" + this.f486653b + ", domain=" + this.f486654c + ", messageServiceId=" + this.f486655d + ", imServiceId=" + this.f486656e + ')';
    }

    public /* synthetic */ l1(int r100) {
        this(null, "", "", null, null);
    }

    public l1(Integer r100, String r101, String r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r102, "domain");
        this.f486652a = r100;
        this.f486653b = r101;
        this.f486654c = r102;
        this.f486655d = r103;
        this.f486656e = r104;
    }
}
