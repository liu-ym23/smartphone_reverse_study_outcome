package t42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f544567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544568b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f544567a, r101.f544567a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f544568b, r101.f544568b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f544567a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f544568b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiteInteractionMessageData(messageId=" + this.f544567a + ", messageMethod=" + this.f544568b + ')';
    }

    public b(Long r100, String r101) {
        this.f544567a = r100;
        this.f544568b = r101;
    }
}
