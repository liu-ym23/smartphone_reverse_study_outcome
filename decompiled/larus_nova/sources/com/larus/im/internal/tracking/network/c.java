package com.larus.im.internal.tracking.network;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f350343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f350344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f350345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f350346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f350347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f350348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f350349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f350350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f350351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f350352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f350353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f350354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f350355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f350356p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f350357q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f350341a, r101.f350341a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350342b, r101.f350342b) == true) goto L15;
        return false;
    L15:
        if (this.f350343c == r101.f350343c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350344d, r101.f350344d) == true) goto L21;
        return false;
    L21:
        if (this.f350345e == r101.f350345e) goto L24;
        return false;
    L24:
        if (this.f350346f == r101.f350346f) goto L27;
        return false;
    L27:
        if (this.f350347g == r101.f350347g) goto L30;
        return false;
    L30:
        if (this.f350348h == r101.f350348h) goto L33;
        return false;
    L33:
        if (this.f350349i == r101.f350349i) goto L36;
        return false;
    L36:
        if (this.f350350j == r101.f350350j) goto L39;
        return false;
    L39:
        if (this.f350351k == r101.f350351k) goto L42;
        return false;
    L42:
        if (this.f350352l == r101.f350352l) goto L45;
        return false;
    L45:
        if (this.f350353m == r101.f350353m) goto L48;
        return false;
    L48:
        if (this.f350354n == r101.f350354n) goto L51;
        return false;
    L51:
        if (this.f350355o == r101.f350355o) goto L54;
        return false;
    L54:
        if (this.f350356p == r101.f350356p) goto L57;
        return false;
    L57:
        if (this.f350357q == r101.f350357q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f350341a.hashCode() * 31) + this.f350342b.hashCode()) * 31;
        long r101 = this.f350343c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f350344d.hashCode()) * 31;
        long r103 = this.f350345e;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f350346f;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f350347g;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f350348h;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f350349i;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f350350j;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f350351k;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f350352l;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.f350353m;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f350354n;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.f350355o;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.f350356p;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        if (this.f350357q == false) goto L5;
        int r127 = 1231;
    L7:
        return r126 + r127;
    L5:
        r127 = 1237;
        goto L7
    }

    public final String toString() {
        return "NetworkPerformanceEvent(path=" + this.f350341a + ", transport=" + this.f350342b + ", netConnected=" + this.f350343c + ", logId=" + this.f350344d + ", statusCode=" + this.f350345e + ", errorCode=" + this.f350346f + ", netTotal=" + this.f350347g + ", reqTotal=" + this.f350348h + ", reqConnect=" + this.f350349i + ", reqDns=" + this.f350350j + ", reqSend=" + this.f350351k + ", reqWait=" + this.f350352l + ", reqReceive=" + this.f350353m + ", reqBodyBytes=" + this.f350354n + ", respBodyBytes=" + this.f350355o + ", coldStartOffsetMs=" + this.f350356p + ", isColdStartRequest=" + this.f350357q + ')';
    }

    public c(String r100, String r101, long r102, String r110, long r111, long r112, long r113, long r114, long r115, long r210, long r211, long r212, long r213, long r214, long r310, long r311, boolean r312) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_TRANSPORT);
        Intrinsics.checkNotNullParameter(r110, "logId");
        this.f350341a = r100;
        this.f350342b = r101;
        this.f350343c = r102;
        this.f350344d = r110;
        this.f350345e = r111;
        this.f350346f = r112;
        this.f350347g = r113;
        this.f350348h = r114;
        this.f350349i = r115;
        this.f350350j = r210;
        this.f350351k = r211;
        this.f350352l = r212;
        this.f350353m = r213;
        this.f350354n = r214;
        this.f350355o = r310;
        this.f350356p = r311;
        this.f350357q = r312;
    }
}
