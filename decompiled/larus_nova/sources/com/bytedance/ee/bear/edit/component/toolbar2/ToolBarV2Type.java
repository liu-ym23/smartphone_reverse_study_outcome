package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.network.http.ServiceType;

/* JADX INFO: loaded from: classes16.dex */
public final enum ToolBarV2Type extends Enum<ToolBarV2Type> {
    public static final ToolBarV2Type Doc = null;
    public static final ToolBarV2Type Down = null;
    public static final ToolBarV2Type EQUATION = null;
    public static final ToolBarV2Type OKR = null;
    public static final ToolBarV2Type SLIDES = null;
    public static final ToolBarV2Type Sheet = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBarV2Type[] f226108a = null;
    int value;

    public static String getName(int r100) {
        if (r100 != 2) goto L5;
        return "doc";
    L5:
        if (r100 != 3) goto L7;
        return DocumentType.SHEET_NAME;
    L7:
        if (r100 != 4) goto L9;
        return "equation";
    L9:
        if (r100 != 6) goto L11;
        return "okr";
    L11:
        if (r100 == 30) goto L14;
        return "unknown";
    L14:
        return "slides";
    }

    static {
        ToolBarV2Type r100 = new ToolBarV2Type("Down", 0, 0);
        Down = r100;
        ToolBarV2Type r101 = new ToolBarV2Type(ServiceType.DOC, 1, 2);
        Doc = r101;
        ToolBarV2Type r102 = new ToolBarV2Type("Sheet", 2, 3);
        Sheet = r102;
        ToolBarV2Type r103 = new ToolBarV2Type("EQUATION", 3, 4);
        EQUATION = r103;
        ToolBarV2Type r104 = new ToolBarV2Type("OKR", 4, 6);
        OKR = r104;
        ToolBarV2Type r110 = new ToolBarV2Type("SLIDES", 5, 30);
        SLIDES = r110;
        f226108a = new ToolBarV2Type[]{r100, r101, r102, r103, r104, r110};
    }

    public static ToolBarV2Type[] values() {
        return (ToolBarV2Type[]) f226108a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ToolBarV2Type valueOf(String r100) {
        return (ToolBarV2Type) r27.a.a(ToolBarV2Type.class, r100);
    }

    public ToolBarV2Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
