package org.jsoup.parser;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526019b;

    public final String toString() {
        return "<" + this.f526018a + ">: " + this.f526019b;
    }

    public c(a r100, String r101) {
        r100.getClass();
        this.f526018a = r100.m();
        this.f526019b = r101;
    }

    public c(a r100, String r101, Object... r102) {
        r100.getClass();
        this.f526018a = r100.m();
        this.f526019b = String.format(r101, r102);
    }
}
