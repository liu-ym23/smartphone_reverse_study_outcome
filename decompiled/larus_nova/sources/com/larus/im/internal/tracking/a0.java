package com.larus.im.internal.tracking;

import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UplinkMessage f350298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.im.internal.network.e<DownlinkBody> f350299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f350300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f350301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f350302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f350303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f350304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f350305h;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f350298a, r101.f350298a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350299b, r101.f350299b) == true) goto L15;
        return false;
    L15:
        if (this.f350300c == r101.f350300c) goto L18;
        return false;
    L18:
        if (this.f350301d == r101.f350301d) goto L21;
        return false;
    L21:
        if (this.f350302e == r101.f350302e) goto L24;
        return false;
    L24:
        if (this.f350303f == r101.f350303f) goto L27;
        return false;
    L27:
        if (this.f350304g == r101.f350304g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f350305h, r101.f350305h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f350298a.hashCode() * 31;
        com.larus.im.internal.network.e<DownlinkBody> r101 = this.f350299b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f350300c;
        return ((((((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f350301d) * 31) + this.f350302e) * 31) + this.f350303f) * 31) + this.f350304g) * 31) + this.f350305h.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UplinkMessageSendInfo(uplink=" + this.f350298a + ", result=" + this.f350299b + ", duration=" + this.f350300c + ", from=" + this.f350301d + ", retryTimes=" + this.f350302e + ", wsStatus=" + this.f350303f + ", networkStatus=" + this.f350304g + ", logId=" + this.f350305h + ')';
    }

    public /* synthetic */ a0(UplinkMessage r110, int r111, int r112, int r113) {
        this(r110, null, 0, r111, 0, r112, r113, "");
    }

    public a0(UplinkMessage r100, com.larus.im.internal.network.e<DownlinkBody> r101, long r102, int r103, int r104, int r105, int r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "uplink");
        Intrinsics.checkNotNullParameter(r110, "logId");
        this.f350298a = r100;
        this.f350299b = r101;
        this.f350300c = r102;
        this.f350301d = r103;
        this.f350302e = r104;
        this.f350303f = r105;
        this.f350304g = r106;
        this.f350305h = r110;
    }
}
