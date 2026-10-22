package com.bytedance.kmp.image.options;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements k {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.bytedance.kmp.image.options.k
    public int getType() {
        return 3;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "AssetSource(uri=null)";
    }
}
