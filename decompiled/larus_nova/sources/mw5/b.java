package mw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f515942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f515943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f515945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f515946e;

    public b() {
        this(null, 0, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f515942a, r101.f515942a) == true) goto L12;
        return false;
    L12:
        if (this.f515943b == r101.f515943b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515944c, r101.f515944c) == true) goto L18;
        return false;
    L18:
        if (this.f515945d == r101.f515945d) goto L21;
        return false;
    L21:
        if (this.f515946e == r101.f515946e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        d r100 = this.f515942a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f515943b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f515944c;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return ((((r105 + r101) * 31) + this.f515945d) * 31) + this.f515946e;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAudioTtsConfig(speaker=" + this.f515942a + ", enableCompression=" + this.f515943b + ", audioFormat=" + this.f515944c + ", audioSampleRate=" + this.f515945d + ", bitRate=" + this.f515946e + ')';
    }

    public b(d r100, int r101, int r102, int r103) {
        String r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        boolean r105 = true;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r104 = "pcm";
    L13:
        if ((r103 & 8) == 0) goto L16;
        r101 = 24000;
    L16:
        if ((r103 & 16) == 0) goto L18;
        r102 = 32000;
    L18:
        this.f515942a = r100;
        this.f515943b = r105;
        this.f515944c = r104;
        this.f515945d = r101;
        this.f515946e = r102;
        return;
    L8:
        r105 = false;
        goto L10
    }
}
