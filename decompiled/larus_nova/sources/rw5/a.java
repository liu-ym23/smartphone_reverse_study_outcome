package rw5;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f539711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f539713c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f539711a == r101.f539711a) goto L12;
        return false;
    L12:
        if (this.f539712b == r101.f539712b) goto L15;
        return false;
    L15:
        if (this.f539713c == r101.f539713c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f539711a * 31) + this.f539712b) * 31) + this.f539713c;
    }

    public final String toString() {
        return "AudioPlayerConfig(sampleRate=" + this.f539711a + ", channel=" + this.f539712b + ", format=" + this.f539713c + ')';
    }

    public a() {
        this.f539711a = 24000;
        this.f539712b = 4;
        this.f539713c = 2;
    }

    @Override // rw5.f
    public final int getChannel() {
        return this.f539712b;
    }

    @Override // rw5.f
    public final int getFormat() {
        return this.f539713c;
    }

    @Override // rw5.f
    public final int getSampleRate() {
        return this.f539711a;
    }
}
