package i12;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f487941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f487944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f487945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f487946f;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f487941a == r101.f487941a) goto L8;
        return false;
    L8:
        if (this.f487942b == r101.f487942b) goto L10;
        return false;
    L10:
        if (this.f487943c == r101.f487943c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487944d, r101.f487944d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f487945e, r101.f487945e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f487946f, r101.f487946f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f487941a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f487942b) * 31) + this.f487943c) * 31;
        Map<String, String> r102 = this.f487944d;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f487945e;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f487946f;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftLocationInfo(giftId=" + this.f487941a + ", pageType=" + this.f487942b + ", buffLevel=" + this.f487943c + ", logExtra=" + this.f487944d + ", giftSendExtra=" + this.f487945e + ", args=" + this.f487946f + ")";
    }

    public c(Object r100) {
        this.f487941a = -1;
        this.f487942b = 0;
        this.f487943c = 0;
        this.f487944d = null;
        this.f487945e = null;
        this.f487946f = null;
    }
}
