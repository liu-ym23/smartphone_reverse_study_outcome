package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class p {
    public static final String a(String r100) {
        String r101 = FileManager.f21782a;
        String r102 = FileManager.f21782a;
        if (StringsKt.endsWith$default(r100, r102, false, 2, null) == false) goto L6;
        return r100;
    L6:
        return r100 + r102;
    }
}
