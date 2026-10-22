package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464802b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f464802b, ((b) r100).f464802b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f464802b.hashCode();
    }

    public final String toString() {
        return "ButtonRouterClickAction(widgetId=" + this.f464802b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464802b;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ButtonRouterClickAction");
        this.f464802b = r100;
    }
}
