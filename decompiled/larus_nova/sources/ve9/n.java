package ve9;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f554485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f554486d;

    public n() {
        this(false, 0, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f554483a == r101.f554483a) goto L12;
        return false;
    L12:
        if (this.f554484b == r101.f554484b) goto L15;
        return false;
    L15:
        if (this.f554485c == r101.f554485c) goto L18;
        return false;
    L18:
        if (this.f554486d == r101.f554486d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f554483a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f554484b) * 31;
        if (this.f554485c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f554486d == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SceneModeConfig(enableNoInputHangUp=" + this.f554483a + ", noInputHangUpTimeSecond=" + this.f554484b + ", enableSceneMode=" + this.f554485c + ", enableSceneModeGuide=" + this.f554486d + ')';
    }

    public n(boolean r100, int r101, boolean r102, boolean r103) {
        this.f554483a = r100;
        this.f554484b = r101;
        this.f554485c = r102;
        this.f554486d = r103;
    }
}
