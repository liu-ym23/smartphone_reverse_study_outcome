package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.basic.v1.Packet;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f254244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f254245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f254246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f254247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f254248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f254249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Packet.StreamStatus f254250g;

    public final String toString() {
        return "AsyncCallbackData(taskId=" + this.f254244a + ", isError=" + this.f254245b + ", data=" + Arrays.toString(this.f254246c) + ", userId=" + this.f254247d + ", needVerifyUser=" + this.f254248e + ", outerHandled=" + this.f254249f + ", steamStatus=" + this.f254250g + ')';
    }

    public final int hashCode() {
        long r100 = this.f254244a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f254245b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        byte[] r105 = this.f254246c;
        if (r105 == null) goto L9;
        int r106 = Arrays.hashCode(r105);
    L10:
        int r107 = (((r104 + r106) * 31) + this.f254247d.hashCode()) * 31;
        if (this.f254248e == true) goto L15;
        r102 = 1237;
    L15:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.lark.sdk.refactor.AsyncCallbackData");
        b r102 = (b) r100;
        if (this.f254244a == r102.f254244a) goto L16;
        return false;
    L16:
        if (this.f254245b == r102.f254245b) goto L18;
        return false;
    L18:
        byte[] r103 = this.f254246c;
        if (r103 == null) goto L27;
        byte[] r104 = r102.f254246c;
        if (r104 != null) goto L24;
        return false;
    L24:
        if (Arrays.equals(r103, r104) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f254247d, r102.f254247d) == true) goto L33;
        return false;
    L33:
        if (this.f254248e == r102.f254248e) goto L35;
        return false;
    L35:
        return true;
    L27:
        if (r102.f254246c == null) goto L30;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public b(long r100, boolean r101, byte[] r102, String r103, boolean r104, boolean r105, Packet.StreamStatus r106, int r110) {
        if ((r110 & 32) == 0) goto L6;
        r105 = false;
    L6:
        if ((r110 & 64) == 0) goto L8;
        r106 = Packet.StreamStatus.FINAL_WITH_PAYLOAD;
    L8:
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r106, "steamStatus");
        this.f254244a = r100;
        this.f254245b = r101;
        this.f254246c = r102;
        this.f254247d = r103;
        this.f254248e = r104;
        this.f254249f = r105;
        this.f254250g = r106;
    }
}
