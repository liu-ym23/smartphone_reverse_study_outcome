package rpc;

import com.lark.kmp.pb.basic.v1.Packet;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f538899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f538900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f538901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f538902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f538903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f538904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Packet.StreamStatus f538905g;

    public final String toString() {
        return "AsyncCallbackData(taskId=" + this.f538899a + ", isError=" + this.f538900b + ", data=" + Arrays.toString(this.f538901c) + ", userId=" + this.f538902d + ", needVerifyUser=" + this.f538903e + ", outerHandled=" + this.f538904f + ", steamStatus=" + this.f538905g + ')';
    }

    public final int hashCode() {
        long r100 = this.f538899a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f538900b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        byte[] r105 = this.f538901c;
        if (r105 == null) goto L9;
        int r106 = Arrays.hashCode(r105);
    L10:
        int r107 = (((r104 + r106) * 31) + this.f538902d.hashCode()) * 31;
        if (this.f538903e == true) goto L15;
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
        if (r100 != null) goto L8;
    L40:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L40;
        a r101 = (a) r100;
        if (this.f538899a == r101.f538899a) goto L14;
        return false;
    L14:
        if (this.f538900b == r101.f538900b) goto L16;
        return false;
    L16:
        byte[] r102 = this.f538901c;
        if (r102 == null) goto L25;
        byte[] r103 = r101.f538901c;
        if (r103 != null) goto L22;
        return false;
    L22:
        if (Arrays.equals(r102, r103) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f538902d, r101.f538902d) == true) goto L31;
        return false;
    L31:
        if (this.f538903e == r101.f538903e) goto L34;
        return false;
    L34:
        if (this.f538904f == r101.f538904f) goto L37;
        return false;
    L37:
        if (this.f538905g == r101.f538905g) goto L39;
        return false;
    L39:
        return true;
    L25:
        if (r101.f538901c == null) goto L28;
        return false;
    }

    public a(long r100, boolean r101, byte[] r102, String r103, boolean r104, Packet.StreamStatus r105, int r106) {
        if ((r106 & 64) == 0) goto L5;
        r105 = Packet.StreamStatus.FINAL_WITH_PAYLOAD;
    L5:
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r105, "steamStatus");
        this.f538899a = r100;
        this.f538900b = r101;
        this.f538901c = r102;
        this.f538902d = r103;
        this.f538903e = r104;
        this.f538904f = false;
        this.f538905g = r105;
    }
}
