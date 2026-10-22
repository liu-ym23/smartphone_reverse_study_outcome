package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
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

    public PlatformLogRecord(int r100, String r101, String r102, PlatformLogField[] r103, String r104, String r105, int r106) {
        this.level = r100;
        this.tag = r101;
        this.message = r102;
        if (r103 != null) goto L5;
        r103 = new PlatformLogField[0];
    L5:
        this.fields = r103;
        this.sourceFile = r104;
        this.sourceFunction = r105;
        this.sourceLine = r106;
    }
}
