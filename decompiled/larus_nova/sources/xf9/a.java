package xf9;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f563528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f563530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f563531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f563532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f563533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f563534g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f563528a == r101.f563528a) goto L12;
        return false;
    L12:
        if (this.f563529b == r101.f563529b) goto L15;
        return false;
    L15:
        if (this.f563530c == r101.f563530c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f563531d, r101.f563531d) == true) goto L21;
        return false;
    L21:
        if (this.f563532e == r101.f563532e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f563533f, r101.f563533f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f563534g, r101.f563534g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f563528a * 31) + this.f563529b) * 31) + this.f563530c) * 31) + Arrays.hashCode(this.f563531d)) * 31;
        long r101 = this.f563532e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f563533f;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return ((r102 + r104) * 31) + this.f563534g.hashCode();
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowWsChannelMsg(channelId=" + this.f563528a + ", service=" + this.f563529b + ", method=" + this.f563530c + ", payload=" + Arrays.toString(this.f563531d) + ", seqId=" + this.f563532e + ", uuid=" + this.f563533f + ", msgHeaders=" + this.f563534g + ')';
    }

    public a(int r100, int r101, int r102, byte[] r103, long r104, String r105, List<b> r106) {
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r106, "msgHeaders");
        this.f563528a = r100;
        this.f563529b = r101;
        this.f563530c = r102;
        this.f563531d = r103;
        this.f563532e = r104;
        this.f563533f = r105;
        this.f563534g = r106;
    }
}
