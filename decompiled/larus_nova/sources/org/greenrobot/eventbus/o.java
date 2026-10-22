package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes42.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f525823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f525824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f525825c;

    public final int hashCode() {
        return this.f525823a.hashCode() + this.f525824b.f525822f.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (this.f525823a == r101.f525823a) goto L7;
        return false;
    L7:
        if (this.f525824b.equals(r101.f525824b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public o(Object r100, n r101) {
        this.f525823a = r100;
        this.f525824b = r101;
        this.f525825c = true;
    }
}
