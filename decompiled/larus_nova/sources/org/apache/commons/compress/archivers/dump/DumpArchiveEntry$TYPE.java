package org.apache.commons.compress.archivers.dump;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DumpArchiveEntry$TYPE extends Enum<DumpArchiveEntry$TYPE> {
    private static final /* synthetic */ DumpArchiveEntry$TYPE[] $VALUES = null;
    public static final DumpArchiveEntry$TYPE BLKDEV = null;
    public static final DumpArchiveEntry$TYPE CHRDEV = null;
    public static final DumpArchiveEntry$TYPE DIRECTORY = null;
    public static final DumpArchiveEntry$TYPE FIFO = null;
    public static final DumpArchiveEntry$TYPE FILE = null;
    public static final DumpArchiveEntry$TYPE LINK = null;
    public static final DumpArchiveEntry$TYPE SOCKET = null;
    public static final DumpArchiveEntry$TYPE UNKNOWN = null;
    public static final DumpArchiveEntry$TYPE WHITEOUT = null;
    private int code;

    static {
        DumpArchiveEntry$TYPE r100 = new DumpArchiveEntry$TYPE("WHITEOUT", 0, 14);
        WHITEOUT = r100;
        DumpArchiveEntry$TYPE r101 = new DumpArchiveEntry$TYPE("SOCKET", 1, 12);
        SOCKET = r101;
        DumpArchiveEntry$TYPE r102 = new DumpArchiveEntry$TYPE("LINK", 2, 10);
        LINK = r102;
        DumpArchiveEntry$TYPE r103 = new DumpArchiveEntry$TYPE("FILE", 3, 8);
        FILE = r103;
        DumpArchiveEntry$TYPE r104 = new DumpArchiveEntry$TYPE("BLKDEV", 4, 6);
        BLKDEV = r104;
        DumpArchiveEntry$TYPE r110 = new DumpArchiveEntry$TYPE("DIRECTORY", 5, 4);
        DIRECTORY = r110;
        DumpArchiveEntry$TYPE r111 = new DumpArchiveEntry$TYPE("CHRDEV", 6, 2);
        CHRDEV = r111;
        DumpArchiveEntry$TYPE r112 = new DumpArchiveEntry$TYPE("FIFO", 7, 1);
        FIFO = r112;
        DumpArchiveEntry$TYPE r113 = new DumpArchiveEntry$TYPE("UNKNOWN", 8, 15);
        UNKNOWN = r113;
        $VALUES = new DumpArchiveEntry$TYPE[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
    }

    public static DumpArchiveEntry$TYPE[] values() {
        return (DumpArchiveEntry$TYPE[]) $VALUES.clone();
    }

    public static DumpArchiveEntry$TYPE find(int r100) {
        DumpArchiveEntry$TYPE r101 = UNKNOWN;
        DumpArchiveEntry$TYPE[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DumpArchiveEntry$TYPE r105 = r102[r104];
        if (r100 != r105.code) goto L7;
        r101 = r105;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public static DumpArchiveEntry$TYPE valueOf(String r100) {
        return (DumpArchiveEntry$TYPE) a.a(DumpArchiveEntry$TYPE.class, r100);
    }

    private DumpArchiveEntry$TYPE(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
