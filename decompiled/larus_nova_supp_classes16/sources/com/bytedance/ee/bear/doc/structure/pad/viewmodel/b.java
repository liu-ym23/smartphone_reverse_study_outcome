package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final boolean a(CatalogMode r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != CatalogMode.EMBED) goto L5;
        return true;
    L5:
        return false;
    }
}
