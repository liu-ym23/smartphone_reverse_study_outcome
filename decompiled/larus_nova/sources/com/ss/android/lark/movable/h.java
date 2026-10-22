package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MovableDocumentInfo f432666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f432667b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f432666a, r101.f432666a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432667b, r101.f432667b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f432666a.hashCode() * 31) + this.f432667b.hashCode();
    }

    public final String toString() {
        return "ParsedMovableDocument(documentInfo=" + this.f432666a + ", releaseHandle=" + this.f432667b + ')';
    }

    public h(MovableDocumentInfo r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "documentInfo");
        Intrinsics.checkNotNullParameter(r101, "releaseHandle");
        this.f432666a = r100;
        this.f432667b = r101;
    }
}
