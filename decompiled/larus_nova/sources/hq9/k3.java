package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f486643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f486645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f486647e;

    public k3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k3) == true) goto L8;
        return false;
    L8:
        k3 r101 = (k3) r100;
        if (this.f486643a == r101.f486643a) goto L12;
        return false;
    L12:
        if (this.f486644b == r101.f486644b) goto L15;
        return false;
    L15:
        if (this.f486645c == r101.f486645c) goto L18;
        return false;
    L18:
        if (this.f486646d == r101.f486646d) goto L21;
        return false;
    L21:
        if (this.f486647e == r101.f486647e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f486643a * 31) + this.f486644b) * 31) + this.f486645c) * 31) + this.f486646d) * 31) + this.f486647e;
    }

    public final String toString() {
        return "MusicCreateConfig(musicLyricsCustomWordMax=" + this.f486643a + ", musicLyricsCustomWordMin=" + this.f486644b + ", musicLyricsPromptWordMax=" + this.f486645c + ", musicLyricsPromptWordMin=" + this.f486646d + ", saveVideoBlackListStrategy=" + this.f486647e + ')';
    }

    public /* synthetic */ k3(int r100) {
        this(200, 5, 200, 3, 0);
    }

    public k3(int r100, int r101, int r102, int r103, int r104) {
        this.f486643a = r100;
        this.f486644b = r101;
        this.f486645c = r102;
        this.f486646d = r103;
        this.f486647e = r104;
    }
}
