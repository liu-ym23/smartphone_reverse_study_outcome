package com.larus.platform.model.chat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f365578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f365579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f365580c;

    public h0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f365578a, r101.f365578a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365579b, r101.f365579b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365580c, r101.f365580c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f365578a.hashCode() * 31) + this.f365579b.hashCode()) * 31) + this.f365580c.hashCode();
    }

    public final String toString() {
        return "NewPreviewTotalConfig(sendImageConfig=" + this.f365578a + ", creationImageConfig=" + this.f365579b + ", previewPageConfig=" + this.f365580c + ')';
    }

    public /* synthetic */ h0(int r100) {
        this(new l(0), new m(false, 0), new k0(true));
    }

    public h0(l r100, m r101, k0 r102) {
        Intrinsics.checkNotNullParameter(r100, "sendImageConfig");
        Intrinsics.checkNotNullParameter(r101, "creationImageConfig");
        Intrinsics.checkNotNullParameter(r102, "previewPageConfig");
        this.f365578a = r100;
        this.f365579b = r101;
        this.f365580c = r102;
    }
}
