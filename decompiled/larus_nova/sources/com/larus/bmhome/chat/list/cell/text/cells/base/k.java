package com.larus.bmhome.chat.list.cell.text.cells.base;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f306036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f306037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec8.b.a f306038c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f306036a, r101.f306036a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f306037b, r101.f306037b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f306038c, r101.f306038c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f306036a.hashCode() * 31) + this.f306037b.hashCode()) * 31) + this.f306038c.hashCode();
    }

    public final String toString() {
        return "DeepThinkContentNeedRefreshInfo(messageId=" + this.f306036a + ", indexList=" + this.f306037b + ", typingCacheInfo=" + this.f306038c + ')';
    }

    public k(String r100, List<Integer> r101, ec8.b.a r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "indexList");
        Intrinsics.checkNotNullParameter(r102, "typingCacheInfo");
        this.f306036a = r100;
        this.f306037b = r101;
        this.f306038c = r102;
    }
}
