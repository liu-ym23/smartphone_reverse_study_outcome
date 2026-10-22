package io.noties.markwon.html.jsoup.parser;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f492608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492609b;

    public final String toString() {
        return this.f492608a + ": " + this.f492609b;
    }

    public b(int r100) {
        this.f492608a = r100;
        this.f492609b = "Attributes incorrectly present on end tag";
    }

    public b(int r100, String r101, Object... r102) {
        this.f492609b = String.format(r101, r102);
        this.f492608a = r100;
    }
}
