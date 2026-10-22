package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum SubBlockType extends Enum<SubBlockType> {
    public static final SubBlockType ALL_DATA_COMPLETE = null;
    public static final SubBlockType COMMENTS_DATA = null;
    public static final SubBlockType IMAGE_DATA = null;
    public static final SubBlockType INNER_SHEET = null;
    public static final SubBlockType POLL_DATA = null;
    public static final SubBlockType SHEETS_DATA = null;
    public static final /* synthetic */ SubBlockType[] a = null;
    private String type;

    static {
        SubBlockType r0 = new SubBlockType("COMMENTS_DATA", 0, "COMMENTS_DATA");
        COMMENTS_DATA = r0;
        SubBlockType r1 = new SubBlockType("POLL_DATA", 1, "POLL_DATA");
        POLL_DATA = r1;
        SubBlockType r3 = new SubBlockType("IMAGE_DATA", 2, "IMAGE_DATA");
        IMAGE_DATA = r3;
        SubBlockType r5 = new SubBlockType("INNER_SHEET", 3, "INNER_SHEET");
        INNER_SHEET = r5;
        SubBlockType r7 = new SubBlockType("SHEETS_DATA", 4, "SHEETS_DATA");
        SHEETS_DATA = r7;
        SubBlockType r9 = new SubBlockType("ALL_DATA_COMPLETE", 5, "ALL_DATA_COMPLETE");
        ALL_DATA_COMPLETE = r9;
        a = new SubBlockType[]{r0, r1, r3, r5, r7, r9};
    }

    public static SubBlockType[] values() {
        return (SubBlockType[]) a.clone();
    }

    public String getSubBlockType() {
        return this.type;
    }

    public static SubBlockType valueOf(String r1) {
        return (SubBlockType) a.a(SubBlockType.class, r1);
    }

    public SubBlockType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
