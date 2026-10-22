package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum SubBlockType extends Enum<SubBlockType> {
    public static final SubBlockType ALL_DATA_COMPLETE = null;
    public static final SubBlockType COMMENTS_DATA = null;
    public static final SubBlockType IMAGE_DATA = null;
    public static final SubBlockType INNER_SHEET = null;
    public static final SubBlockType POLL_DATA = null;
    public static final SubBlockType SHEETS_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubBlockType[] f220659a = null;
    private String type;

    static {
        SubBlockType r100 = new SubBlockType("COMMENTS_DATA", 0, "COMMENTS_DATA");
        COMMENTS_DATA = r100;
        SubBlockType r101 = new SubBlockType("POLL_DATA", 1, "POLL_DATA");
        POLL_DATA = r101;
        SubBlockType r102 = new SubBlockType("IMAGE_DATA", 2, "IMAGE_DATA");
        IMAGE_DATA = r102;
        SubBlockType r103 = new SubBlockType("INNER_SHEET", 3, "INNER_SHEET");
        INNER_SHEET = r103;
        SubBlockType r104 = new SubBlockType("SHEETS_DATA", 4, "SHEETS_DATA");
        SHEETS_DATA = r104;
        SubBlockType r105 = new SubBlockType("ALL_DATA_COMPLETE", 5, "ALL_DATA_COMPLETE");
        ALL_DATA_COMPLETE = r105;
        f220659a = new SubBlockType[]{r100, r101, r102, r103, r104, r105};
    }

    public static SubBlockType[] values() {
        return (SubBlockType[]) f220659a.clone();
    }

    public String getSubBlockType() {
        return this.type;
    }

    public static SubBlockType valueOf(String r100) {
        return (SubBlockType) a.a(SubBlockType.class, r100);
    }

    public SubBlockType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
