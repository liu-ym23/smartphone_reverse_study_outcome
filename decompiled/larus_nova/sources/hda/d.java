package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f484647c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f484645a, r101.f484645a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484646b, r101.f484646b) == true) goto L15;
        return false;
    L15:
        if (this.f484647c == r101.f484647c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f484645a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f484646b.hashCode()) * 31;
        if (this.f484647c == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewChatBubble(speaker=" + this.f484645a + ", text=" + this.f484646b + ", self=" + this.f484647c + ')';
    }

    public d(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f484645a = r100;
        this.f484646b = r101;
        this.f484647c = r102;
    }
}
