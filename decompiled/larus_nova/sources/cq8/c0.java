package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f464813c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f464812b, r101.f464812b) == true) goto L12;
        return false;
    L12:
        if (this.f464813c == r101.f464813c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464812b.hashCode() * 31;
        if (this.f464813c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MediaSelectorOpenAlbumAction(widgetId=" + this.f464812b + ", isReplace=" + this.f464813c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464812b;
    }

    public c0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("MediaSelectorOpenAlbumAction");
        this.f464812b = r100;
        this.f464813c = false;
    }
}
