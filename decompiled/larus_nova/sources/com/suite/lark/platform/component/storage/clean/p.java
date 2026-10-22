package com.suite.lark.platform.component.storage.clean;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class p {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (new PolarisFileWrapper(r100).isDirectory() == false) goto L9;
        String r101 = File.separator;
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == false) goto L8;
        return r100;
    L8:
        return r100 + r101;
    L9:
        return r100;
    }
}
