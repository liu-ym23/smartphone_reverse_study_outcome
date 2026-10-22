package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464822b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f464822b, ((e) r100).f464822b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f464822b.hashCode();
    }

    public final String toString() {
        return "ButtonRouterShowAction(widgetId=" + this.f464822b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464822b;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ButtonRouterShowAction");
        this.f464822b = r100;
    }
}
