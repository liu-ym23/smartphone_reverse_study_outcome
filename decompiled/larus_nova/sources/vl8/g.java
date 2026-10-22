package vl8;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f555701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f555702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f555703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f555704d;

    public g() {
        this(false, false, false, 0.0f, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f555701a == r101.f555701a) goto L12;
        return false;
    L12:
        if (this.f555702b == r101.f555702b) goto L15;
        return false;
    L15:
        if (this.f555703c == r101.f555703c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f555704d, r101.f555704d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f555701a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f555702b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f555703c == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + Float.floatToIntBits(this.f555704d);
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocalFilePlaybackState(isPlaying=" + this.f555701a + ", isLoading=" + this.f555702b + ", isPaused=" + this.f555703c + ", progress=" + this.f555704d + ')';
    }

    public g(boolean r100, boolean r101, boolean r102, float r103) {
        this.f555701a = r100;
        this.f555702b = r101;
        this.f555703c = r102;
        this.f555704d = r103;
    }

    public /* synthetic */ g(boolean r100, boolean r101, boolean r102, float r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
