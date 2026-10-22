package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.downloadlib.constants.MimeType;
import java.io.File;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r101, "image/jpeg") == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(r101, "image/png") == true) goto L16;
        if (Intrinsics.areEqual(r101, "image/jpg") == true) goto L16;
        if (Intrinsics.areEqual(r101, "image/heif") == true) goto L16;
        if (Intrinsics.areEqual(r101, "image/heic") == true) goto L16;
        if (Intrinsics.areEqual(r101, MimeType.WEBP) == true) goto L16;
        return false;
    }

    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        File r101 = new PolarisFileWrapper(r100).getParentFile();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.exists() == true) goto L9;
        r101.mkdirs();
        return;
    }
}
