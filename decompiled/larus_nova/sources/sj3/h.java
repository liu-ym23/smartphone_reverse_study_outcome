package sj3;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f542279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Date f542283e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (this.f542279a == r101.f542279a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f542280b, r101.f542280b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f542281c, r101.f542281c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542282d, r101.f542282d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f542283e, r101.f542283e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f542279a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f542280b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f542281c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f542282d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Date r112 = this.f542283e;
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
        return "StoreSearchHistoryDTO(id=" + this.f542279a + ", userId=" + this.f542280b + ", storeId=" + this.f542281c + ", keyWord=" + this.f542282d + ", timestamp=" + this.f542283e + ")";
    }

    public h(long r100, String r101, String r102, String r103, Date r104) {
        this.f542279a = r100;
        this.f542280b = r101;
        this.f542281c = r102;
        this.f542282d = r103;
        this.f542283e = r104;
    }
}
