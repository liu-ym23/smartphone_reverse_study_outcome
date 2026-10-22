package com.bytedance.ee.bear.sheet.panel.oppanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum OperationEnum extends Enum<OperationEnum> {
    public static final /* synthetic */ OperationEnum[] a = null;
    public static final OperationEnum addReminder = null;
    public static final OperationEnum backColor = null;
    public static final OperationEnum borderLine = null;
    public static final OperationEnum checkbox = null;
    public static final OperationEnum deleteCol = null;
    public static final OperationEnum deleteRow = null;
    public static final OperationEnum filter = null;
    public static final OperationEnum fontSize = null;
    public static final OperationEnum foreColor = null;
    public static final OperationEnum freezeSheet = null;
    public static final OperationEnum hideCol = null;
    public static final OperationEnum insertComment = null;
    public static final OperationEnum merge = null;
    public static final OperationEnum myAiDataInsight = null;
    public static final OperationEnum shareImage = null;
    public static final OperationEnum sort = null;
    public static final OperationEnum uploadImage = null;
    boolean hasNext;
    int iconResId;

    public OperationEnum() {
        throw null;
    }

    static {
        OperationEnum r0 = new OperationEnum("deleteRow", 0, 2131247786, false);
        deleteRow = r0;
        OperationEnum r1 = new OperationEnum("deleteCol", 1, 2131247786, false);
        deleteCol = r1;
        OperationEnum r3 = new OperationEnum("merge", 2, 2131247794, false);
        merge = r3;
        OperationEnum r4 = new OperationEnum("insertComment", 3, 2131253538, false);
        insertComment = r4;
        OperationEnum r7 = new OperationEnum("filter", 4, 2131255022, true);
        filter = r7;
        OperationEnum r9 = new OperationEnum("sort", 5, 2131247800, true);
        sort = r9;
        OperationEnum r10 = new OperationEnum("freezeSheet", 6, 2131247790, true);
        freezeSheet = r10;
        OperationEnum r12 = new OperationEnum("uploadImage", 7, 2131254899, false);
        uploadImage = r12;
        OperationEnum r13 = new OperationEnum("addReminder", 8, 2131253615, false);
        addReminder = r13;
        OperationEnum r11 = new OperationEnum("shareImage", 9, 2131255051, false);
        shareImage = r11;
        OperationEnum r8 = new OperationEnum("checkbox", 10, 2131256017, false);
        checkbox = r8;
        OperationEnum r6 = new OperationEnum("borderLine", 11, -1, true);
        borderLine = r6;
        OperationEnum r14 = new OperationEnum("foreColor", 12, -1, true);
        foreColor = r14;
        OperationEnum r15 = new OperationEnum("backColor", 13, -1, true);
        backColor = r15;
        OperationEnum r16 = new OperationEnum("fontSize", 14, -1, false);
        fontSize = r16;
        OperationEnum r2 = new OperationEnum("myAiDataInsight", 15, 2131255192, false);
        myAiDataInsight = r2;
        OperationEnum r17 = new OperationEnum("hideCol", 16, 2131247804, false);
        hideCol = r17;
        a = new OperationEnum[]{r0, r1, r3, r4, r7, r9, r10, r12, r13, r11, r8, r6, r14, r15, r16, r2, r17};
    }

    public static OperationEnum[] values() {
        return (OperationEnum[]) a.clone();
    }

    public static OperationEnum valueOf(String r1) {
        return (OperationEnum) r27.a.a(OperationEnum.class, r1);
    }

    public OperationEnum(String r1, int r2, int r3, boolean r4) {
        super(r1, r2);
        this.iconResId = r3;
        this.hasNext = r4;
    }
}
