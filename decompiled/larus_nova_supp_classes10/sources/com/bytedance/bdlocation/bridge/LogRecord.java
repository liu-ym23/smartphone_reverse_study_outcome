package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LogRecord {
    public static final int LEVEL_DEBUG = 0;
    public static final int LEVEL_ERROR = 3;
    public static final int LEVEL_FATAL = 4;
    public static final int LEVEL_INFO = 1;
    public static final int LEVEL_WARN = 2;
    public final Map<String, String> fields;
    public final int level;
    public final String message;
    public final String sourceFile;
    public final String sourceFunction;
    public final int sourceLine;
    public final String tag;

    public LogRecord(int r1, String r2, String r3, Map<String, String> r4, String r5, String r6, int r7) {
        this.level = r1;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.tag = r2;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        this.message = r3;
        if (r4 != null) goto L11;
    L14:
        this.fields = Collections.emptyMap();
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        this.sourceFile = r5;
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        this.sourceFunction = r6;
        this.sourceLine = r7;
        return;
    L11:
        if (r4.isEmpty() == true) goto L14;
        this.fields = Collections.unmodifiableMap(new LinkedHashMap(r4));
        goto L15
    }
}
