package org.apache.commons.compress.archivers.dump;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DumpArchiveConstants$SEGMENT_TYPE extends Enum<DumpArchiveConstants$SEGMENT_TYPE> {
    private static final /* synthetic */ DumpArchiveConstants$SEGMENT_TYPE[] $VALUES = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE ADDR = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE BITS = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE CLRI = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE END = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE INODE = null;
    public static final DumpArchiveConstants$SEGMENT_TYPE TAPE = null;
    int code;

    static {
        DumpArchiveConstants$SEGMENT_TYPE r100 = new DumpArchiveConstants$SEGMENT_TYPE("TAPE", 0, 1);
        TAPE = r100;
        DumpArchiveConstants$SEGMENT_TYPE r101 = new DumpArchiveConstants$SEGMENT_TYPE("INODE", 1, 2);
        INODE = r101;
        DumpArchiveConstants$SEGMENT_TYPE r102 = new DumpArchiveConstants$SEGMENT_TYPE("BITS", 2, 3);
        BITS = r102;
        DumpArchiveConstants$SEGMENT_TYPE r103 = new DumpArchiveConstants$SEGMENT_TYPE("ADDR", 3, 4);
        ADDR = r103;
        DumpArchiveConstants$SEGMENT_TYPE r104 = new DumpArchiveConstants$SEGMENT_TYPE(GXAnimation.STATE_END, 4, 5);
        END = r104;
        DumpArchiveConstants$SEGMENT_TYPE r110 = new DumpArchiveConstants$SEGMENT_TYPE("CLRI", 5, 6);
        CLRI = r110;
        $VALUES = new DumpArchiveConstants$SEGMENT_TYPE[]{r100, r101, r102, r103, r104, r110};
    }

    public static DumpArchiveConstants$SEGMENT_TYPE[] values() {
        return (DumpArchiveConstants$SEGMENT_TYPE[]) $VALUES.clone();
    }

    public static DumpArchiveConstants$SEGMENT_TYPE find(int r100) {
        DumpArchiveConstants$SEGMENT_TYPE[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DumpArchiveConstants$SEGMENT_TYPE r104 = r101[r103];
        if (r104.code == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DumpArchiveConstants$SEGMENT_TYPE valueOf(String r100) {
        return (DumpArchiveConstants$SEGMENT_TYPE) a.a(DumpArchiveConstants$SEGMENT_TYPE.class, r100);
    }

    private DumpArchiveConstants$SEGMENT_TYPE(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
