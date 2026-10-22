package com.facebook.soloader;

import android.os.Trace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
class Api18TraceUtils {
    private static final int MAX_SECTION_NAME_LENGTH = 127;

    public Api18TraceUtils() {
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static void beginTraceSection(String r100, @Nullable String r101, String r102) {
        String r103 = r100 + r101 + r102;
        if (r103.length() <= 127) goto L6;
        if (r101 == null) goto L6;
        r103 = r100 + r101.substring(0, (127 - r100.length()) - r102.length()) + r102;
    L6:
        Trace.beginSection(r103);
    }
}
