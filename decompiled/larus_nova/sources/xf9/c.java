package xf9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f563537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f563539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f563541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f563542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f563543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f563544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f563545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f563546j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f563537a == r101.f563537a) goto L12;
        return false;
    L12:
        if (this.f563538b == r101.f563538b) goto L15;
        return false;
    L15:
        if (this.f563539c == r101.f563539c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f563540d, r101.f563540d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f563541e, r101.f563541e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f563542f, r101.f563542f) == true) goto L27;
        return false;
    L27:
        if (this.f563543g == r101.f563543g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f563544h, r101.f563544h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f563545i, r101.f563545i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f563546j, r101.f563546j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((this.f563537a * 31) + this.f563538b) * 31) + this.f563539c) * 31) + this.f563540d.hashCode()) * 31) + this.f563541e.hashCode()) * 31) + this.f563542f.hashCode()) * 31) + this.f563543g) * 31) + this.f563544h.hashCode()) * 31) + this.f563545i.hashCode()) * 31) + this.f563546j.hashCode();
    }

    public final String toString() {
        return "FlowWsChannelOpenParams(channelId=" + this.f563537a + ", aid=" + this.f563538b + ", fpid=" + this.f563539c + ", deviceId=" + this.f563540d + ", installId=" + this.f563541e + ", appKey=" + this.f563542f + ", appVersion=" + this.f563543g + ", urls=" + this.f563544h + ", extras=" + this.f563545i + ", headers=" + this.f563546j + ')';
    }

    public c(int r100, int r101, int r102, String r103, String r104, String r105, int r106, List<String> r107, Map<String, String> r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r103, "deviceId");
        Intrinsics.checkNotNullParameter(r104, "installId");
        Intrinsics.checkNotNullParameter(r105, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r107, "urls");
        Intrinsics.checkNotNullParameter(r110, "extras");
        Intrinsics.checkNotNullParameter(r111, "headers");
        this.f563537a = r100;
        this.f563538b = r101;
        this.f563539c = r102;
        this.f563540d = r103;
        this.f563541e = r104;
        this.f563542f = r105;
        this.f563543g = r106;
        this.f563544h = r107;
        this.f563545i = r110;
        this.f563546j = r111;
    }
}
