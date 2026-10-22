package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f464821d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f464819b, r101.f464819b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464820c, r101.f464820c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464821d, r101.f464821d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464819b.hashCode() * 31;
        String r101 = this.f464820c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464821d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaSelectorPreviewAction(widgetId=" + this.f464819b + ", url=" + this.f464820c + ", localPath=" + this.f464821d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464819b;
    }

    public d0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("MediaSelectorPreviewAction");
        this.f464819b = r100;
        this.f464820c = r101;
        this.f464821d = r102;
    }
}
