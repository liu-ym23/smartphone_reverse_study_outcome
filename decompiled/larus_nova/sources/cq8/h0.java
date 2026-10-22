package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f464846c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f464845b, r101.f464845b) == true) goto L12;
        return false;
    L12:
        if (this.f464846c == r101.f464846c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464845b.hashCode() * 31;
        long r101 = this.f464846c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "MenuTabSwitchAction(widgetId=" + this.f464845b + ", tabId=" + this.f464846c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464845b;
    }

    public h0(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("MenuTabSwitchAction");
        this.f464845b = r100;
        this.f464846c = r101;
    }
}
