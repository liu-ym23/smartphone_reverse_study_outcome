package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f464955c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f464954b, r101.f464954b) == true) goto L12;
        return false;
    L12:
        if (this.f464955c == r101.f464955c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464954b.hashCode() * 31;
        long r101 = this.f464955c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "TabSwitchAction(widgetId=" + this.f464954b + ", tabOptionId=" + this.f464955c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464954b;
    }

    public s0(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("TabSwitchAction");
        this.f464954b = r100;
        this.f464955c = r101;
    }
}
