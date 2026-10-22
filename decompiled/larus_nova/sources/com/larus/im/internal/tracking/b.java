package com.larus.im.internal.tracking;

import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f350306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f350307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f350308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f350309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f350310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f350311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f350312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.im.internal.network.e<FetchChunkMessageDownlinkBody> f350313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MessageEntity f350314i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f350306a == r101.f350306a) goto L12;
        return false;
    L12:
        if (this.f350307b == r101.f350307b) goto L15;
        return false;
    L15:
        if (this.f350308c == r101.f350308c) goto L18;
        return false;
    L18:
        if (this.f350309d == r101.f350309d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350310e, r101.f350310e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f350311f, r101.f350311f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f350312g, r101.f350312g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f350313h, r101.f350313h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f350314i, r101.f350314i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f350306a;
        return (((((((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f350307b) * 31) + this.f350308c) * 31) + this.f350309d) * 31) + this.f350310e.hashCode()) * 31) + this.f350311f.hashCode()) * 31) + this.f350312g.hashCode()) * 31) + this.f350313h.hashCode()) * 31) + this.f350314i.hashCode();
    }

    public final String toString() {
        return "ChunkReportInfo(duration=" + this.f350306a + ", totalSize=" + this.f350307b + ", count=" + this.f350308c + ", retryTimes=" + this.f350309d + ", logId=" + this.f350310e + ", token=" + this.f350311f + ", acceptBinaryType=" + this.f350312g + ", result=" + this.f350313h + ", message=" + this.f350314i + ')';
    }

    public /* synthetic */ b(long r110, int r111, String r112, String r113, String r114, com.larus.im.internal.network.e r115, MessageEntity r116) {
        this(r110, 0, r111, 0, r112, r113, r114, r115, r116);
    }

    public b(long r100, int r101, int r102, int r103, String r104, String r105, String r106, com.larus.im.internal.network.e<FetchChunkMessageDownlinkBody> r110, MessageEntity r111) {
        Intrinsics.checkNotNullParameter(r104, "logId");
        Intrinsics.checkNotNullParameter(r105, "token");
        Intrinsics.checkNotNullParameter(r106, "acceptBinaryType");
        Intrinsics.checkNotNullParameter(r110, "result");
        Intrinsics.checkNotNullParameter(r111, "message");
        this.f350306a = r100;
        this.f350307b = r101;
        this.f350308c = r102;
        this.f350309d = r103;
        this.f350310e = r104;
        this.f350311f = r105;
        this.f350312g = r106;
        this.f350313h = r110;
        this.f350314i = r111;
    }

    public static b a(b r110, long r111, int r112, String r113, String r210, String r211, com.larus.im.internal.network.e r212, MessageEntity r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.f350306a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.f350307b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.f350308c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = r110.f350309d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r114 = r110.f350310e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r115 = r110.f350311f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r116 = r110.f350312g;
    L31:
        if ((r214 & 128) == 0) goto L33;
        com.larus.im.internal.network.e r117 = r110.f350313h;
    L35:
        if ((r214 & 256) == 0) goto L37;
        MessageEntity r118 = r110.f350314i;
    L38:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r114, "logId");
        Intrinsics.checkNotNullParameter(r115, "token");
        Intrinsics.checkNotNullParameter(r116, "acceptBinaryType");
        Intrinsics.checkNotNullParameter(r117, "result");
        Intrinsics.checkNotNullParameter(r118, "message");
        return new b(r100, r101, r102, r103, r114, r115, r116, r117, r118);
    L37:
        r118 = r213;
        goto L38
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r115 = r210;
        goto L27
    L21:
        r114 = r113;
        goto L23
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
