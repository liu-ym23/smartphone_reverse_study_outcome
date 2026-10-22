package g78;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements u58.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f480258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f480260c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f480258a == r101.f480258a) goto L12;
        return false;
    L12:
        if (this.f480259b == r101.f480259b) goto L15;
        return false;
    L15:
        if (this.f480260c == r101.f480260c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f480258a * 31) + this.f480259b) * 31) + this.f480260c;
    }

    public final String toString() {
        return "AudioPlayerConfig(sampleRate=" + this.f480258a + ", channel=" + this.f480259b + ", format=" + this.f480260c + ')';
    }

    @Override // u58.a
    public final int getChannel() {
        return this.f480259b;
    }

    @Override // u58.a
    public final int getFormat() {
        return this.f480260c;
    }

    @Override // u58.a
    public final int getSampleRate() {
        return this.f480258a;
    }

    public a(int r100, int r101, int r102) {
        this.f480258a = r100;
        this.f480259b = r101;
        this.f480260c = r102;
    }
}
