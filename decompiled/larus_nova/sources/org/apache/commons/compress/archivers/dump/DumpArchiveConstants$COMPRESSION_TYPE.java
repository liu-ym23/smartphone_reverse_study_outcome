package org.apache.commons.compress.archivers.dump;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DumpArchiveConstants$COMPRESSION_TYPE extends Enum<DumpArchiveConstants$COMPRESSION_TYPE> {
    private static final /* synthetic */ DumpArchiveConstants$COMPRESSION_TYPE[] $VALUES = null;
    public static final DumpArchiveConstants$COMPRESSION_TYPE BZLIB = null;
    public static final DumpArchiveConstants$COMPRESSION_TYPE LZO = null;
    public static final DumpArchiveConstants$COMPRESSION_TYPE ZLIB = null;
    int code;

    static {
        DumpArchiveConstants$COMPRESSION_TYPE r100 = new DumpArchiveConstants$COMPRESSION_TYPE("ZLIB", 0, 0);
        ZLIB = r100;
        DumpArchiveConstants$COMPRESSION_TYPE r101 = new DumpArchiveConstants$COMPRESSION_TYPE("BZLIB", 1, 1);
        BZLIB = r101;
        DumpArchiveConstants$COMPRESSION_TYPE r102 = new DumpArchiveConstants$COMPRESSION_TYPE("LZO", 2, 2);
        LZO = r102;
        $VALUES = new DumpArchiveConstants$COMPRESSION_TYPE[]{r100, r101, r102};
    }

    public static DumpArchiveConstants$COMPRESSION_TYPE[] values() {
        return (DumpArchiveConstants$COMPRESSION_TYPE[]) $VALUES.clone();
    }

    public static DumpArchiveConstants$COMPRESSION_TYPE find(int r100) {
        DumpArchiveConstants$COMPRESSION_TYPE[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DumpArchiveConstants$COMPRESSION_TYPE r104 = r101[r103];
        if (r104.code == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DumpArchiveConstants$COMPRESSION_TYPE valueOf(String r100) {
        return (DumpArchiveConstants$COMPRESSION_TYPE) a.a(DumpArchiveConstants$COMPRESSION_TYPE.class, r100);
    }

    private DumpArchiveConstants$COMPRESSION_TYPE(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
