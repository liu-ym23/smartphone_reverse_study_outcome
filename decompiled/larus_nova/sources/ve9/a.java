package ve9;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f554423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f554424e;

    public a() {
        this(null, null, null, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f554420a, r101.f554420a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554421b, r101.f554421b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554422c, r101.f554422c) == true) goto L18;
        return false;
    L18:
        if (this.f554423d == r101.f554423d) goto L21;
        return false;
    L21:
        if (this.f554424e == r101.f554424e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f554420a.hashCode() * 31) + this.f554421b.hashCode()) * 31) + this.f554422c.hashCode()) * 31) + this.f554423d) * 31) + this.f554424e;
    }

    public final String toString() {
        return "AsrConfig(format=" + this.f554420a + ", language=" + this.f554421b + ", extra=" + this.f554422c + ", sampleRate=" + this.f554423d + ", channel=" + this.f554424e + ')';
    }

    public a(String r100, String r101, String r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "pcm";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        int r105 = 16000;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = 1;
    L18:
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "language");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f554420a = r100;
        this.f554421b = r101;
        this.f554422c = r102;
        this.f554423d = r105;
        this.f554424e = r103;
        return;
    L14:
        r105 = 0;
        goto L16
    }
}
