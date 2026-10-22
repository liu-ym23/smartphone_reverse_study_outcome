package com.ss.ugc.effectplatform.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final String a(Effect r100) {
        if (Intrinsics.areEqual(r100.getFile_url().getUri(), "") == false) goto L7;
        return null;
    L7:
        return r100.getFile_url().getUri();
    }
}
