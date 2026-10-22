package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
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

    public LogRecord(int r100, String r101, String r102, Map<String, String> r103, String r104, String r105, int r106) {
        this.level = r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.tag = r101;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.message = r102;
        if (r103 != null) goto L11;
    L14:
        this.fields = Collections.emptyMap();
    L15:
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        this.sourceFile = r104;
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        this.sourceFunction = r105;
        this.sourceLine = r106;
        return;
    L11:
        if (r103.isEmpty() == true) goto L14;
        this.fields = Collections.unmodifiableMap(new LinkedHashMap(r103));
        goto L15
    }
}
