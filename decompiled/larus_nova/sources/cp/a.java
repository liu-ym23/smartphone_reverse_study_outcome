package cp;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f464591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f464594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Date f464595e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f464591a == r101.f464591a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f464592b, r101.f464592b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f464593c, r101.f464593c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464594d, r101.f464594d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f464595e, r101.f464595e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f464591a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f464592b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f464593c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f464594d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Date r112 = this.f464595e;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowSearchHistoryDTO(id=" + this.f464591a + ", userId=" + this.f464592b + ", storeId=" + this.f464593c + ", keyWord=" + this.f464594d + ", timestamp=" + this.f464595e + ")";
    }

    public a(long r100, String r101, String r102, String r103, Date r104) {
        this.f464591a = r100;
        this.f464592b = r101;
        this.f464593c = r102;
        this.f464594d = r103;
        this.f464595e = r104;
    }
}
