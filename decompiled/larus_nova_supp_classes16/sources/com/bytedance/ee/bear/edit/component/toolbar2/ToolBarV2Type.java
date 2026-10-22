package com.bytedance.ee.bear.edit.component.toolbar2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ToolBarV2Type extends Enum<ToolBarV2Type> {
    public static final ToolBarV2Type Doc = null;
    public static final ToolBarV2Type Down = null;
    public static final ToolBarV2Type EQUATION = null;
    public static final ToolBarV2Type OKR = null;
    public static final ToolBarV2Type SLIDES = null;
    public static final ToolBarV2Type Sheet = null;
    public static final /* synthetic */ ToolBarV2Type[] a = null;
    int value;

    public static String getName(int r1) {
        if (r1 != 2) goto L5;
        return "doc";
    L5:
        if (r1 != 3) goto L7;
        return "sheet";
    L7:
        if (r1 != 4) goto L9;
        return "equation";
    L9:
        if (r1 != 6) goto L11;
        return "okr";
    L11:
        if (r1 == 30) goto L14;
        return "unknown";
    L14:
        return "slides";
    }

    static {
        ToolBarV2Type r0 = new ToolBarV2Type("Down", 0, 0);
        Down = r0;
        ToolBarV2Type r1 = new ToolBarV2Type("Doc", 1, 2);
        Doc = r1;
        ToolBarV2Type r3 = new ToolBarV2Type("Sheet", 2, 3);
        Sheet = r3;
        ToolBarV2Type r6 = new ToolBarV2Type("EQUATION", 3, 4);
        EQUATION = r6;
        ToolBarV2Type r8 = new ToolBarV2Type("OKR", 4, 6);
        OKR = r8;
        ToolBarV2Type r10 = new ToolBarV2Type("SLIDES", 5, 30);
        SLIDES = r10;
        a = new ToolBarV2Type[]{r0, r1, r3, r6, r8, r10};
    }

    public static ToolBarV2Type[] values() {
        return (ToolBarV2Type[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ToolBarV2Type valueOf(String r1) {
        return (ToolBarV2Type) r27.a.a(ToolBarV2Type.class, r1);
    }

    public ToolBarV2Type(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
