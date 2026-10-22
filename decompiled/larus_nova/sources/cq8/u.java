package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464960b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f464960b, ((u) r100).f464960b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f464960b.hashCode();
    }

    public final String toString() {
        return "ImageStyleListResetAction(widgetId=" + this.f464960b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464960b;
    }

    public u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ImageStyleListResetAction");
        this.f464960b = r100;
    }
}
