package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final boolean a(CatalogMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != CatalogMode.EMBED) goto L5;
        return true;
    L5:
        return false;
    }
}
