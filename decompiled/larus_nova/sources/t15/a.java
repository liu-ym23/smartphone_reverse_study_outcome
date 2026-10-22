package t15;

import com.alibaba.gaiax.template.GXMode;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Float> f544149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f544150f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f544145a, r101.f544145a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544146b, r101.f544146b) == true) goto L15;
        return false;
    L15:
        if (this.f544147c == r101.f544147c) goto L18;
        return false;
    L18:
        if (this.f544148d == r101.f544148d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f544149e, r101.f544149e) == true) goto L24;
        return false;
    L24:
        if (this.f544150f == r101.f544150f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f544145a.hashCode() * 31) + this.f544146b.hashCode()) * 31) + this.f544147c) * 31) + this.f544148d) * 31) + this.f544149e.hashCode()) * 31) + this.f544150f;
    }

    public final String toString() {
        return "EditResult(uuid=" + this.f544145a + ", path=" + this.f544146b + ", width=" + this.f544147c + ", height=" + this.f544148d + ", crop=" + this.f544149e + ", angle=" + this.f544150f + ')';
    }

    public a(String r100, String r101, int r102, int r103, List<Float> r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r104, GXMode.MODE_TYPE_CROP);
        this.f544145a = r100;
        this.f544146b = r101;
        this.f544147c = r102;
        this.f544148d = r103;
        this.f544149e = r104;
        this.f544150f = r105;
    }
}
