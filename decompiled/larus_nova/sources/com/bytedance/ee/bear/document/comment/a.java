package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f219274a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f219274a == ((a) r100).f219274a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f219274a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "CardsShowCommentEvent(show=" + this.f219274a + ')';
    }

    public a(boolean r100) {
        this.f219274a = r100;
    }
}
