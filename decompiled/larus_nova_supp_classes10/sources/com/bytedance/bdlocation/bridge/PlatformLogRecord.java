package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class PlatformLogRecord {
    static final int LEVEL_DEBUG = 0;
    static final int LEVEL_ERROR = 3;
    static final int LEVEL_FATAL = 4;
    static final int LEVEL_INFO = 1;
    static final int LEVEL_WARN = 2;
    final PlatformLogField[] fields;
    final int level;
    final String message;
    final String sourceFile;
    final String sourceFunction;
    final int sourceLine;
    final String tag;

    public PlatformLogRecord(int r1, String r2, String r3, PlatformLogField[] r4, String r5, String r6, int r7) {
        this.level = r1;
        this.tag = r2;
        this.message = r3;
        if (r4 != null) goto L5;
        r4 = new PlatformLogField[0];
    L5:
        this.fields = r4;
        this.sourceFile = r5;
        this.sourceFunction = r6;
        this.sourceLine = r7;
    }
}
