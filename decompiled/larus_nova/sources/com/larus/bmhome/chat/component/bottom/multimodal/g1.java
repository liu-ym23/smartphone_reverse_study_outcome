package com.larus.bmhome.chat.component.bottom.multimodal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f299776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultimodalBizScene f299777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f299778c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (this.f299776a == r101.f299776a) goto L12;
        return false;
    L12:
        if (this.f299777b == r101.f299777b) goto L15;
        return false;
    L15:
        if (this.f299778c == r101.f299778c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f299776a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f299777b.hashCode()) * 31;
        if (this.f299778c == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultimodalProcessConfig(useAttachmentPanel=" + this.f299776a + ", bizScene=" + this.f299777b + ", notApplyNested=" + this.f299778c + ')';
    }

    public g1(boolean r100, MultimodalBizScene r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        this.f299776a = r100;
        this.f299777b = r101;
        this.f299778c = r102;
    }
}
