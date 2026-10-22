package iec;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f489516b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f489515a == r101.f489515a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489516b, r101.f489516b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f489515a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        f r102 = this.f489516b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "EmojiDigestParams(isShowEmojiDigest=" + this.f489515a + ", emojiIconParams=" + this.f489516b + ')';
    }

    public e(int r100) {
        this.f489515a = false;
        this.f489516b = null;
    }
}
