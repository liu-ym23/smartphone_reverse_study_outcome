package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464844b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f464844b, ((h) r100).f464844b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f464844b.hashCode();
    }

    public final String toString() {
        return "CommandClickAction(widgetId=" + this.f464844b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464844b;
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("CommandClickAction");
        this.f464844b = r100;
    }
}
