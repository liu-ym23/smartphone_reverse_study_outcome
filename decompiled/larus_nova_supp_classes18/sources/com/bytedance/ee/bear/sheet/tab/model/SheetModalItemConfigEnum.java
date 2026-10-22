package com.bytedance.ee.bear.sheet.tab.model;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SheetModalItemConfigEnum extends Enum<SheetModalItemConfigEnum> {
    public static final SheetModalItemConfigEnum COPY = null;
    public static final SheetModalItemConfigEnum CREATE_BITABLE = null;
    public static final SheetModalItemConfigEnum CREATE_GRID = null;
    public static final SheetModalItemConfigEnum CREATE_KANBAN = null;
    public static final SheetModalItemConfigEnum CREATE_SHEET = null;
    public static final SheetModalItemConfigEnum DELETE = null;
    public static final SheetModalItemConfigEnum RENAME = null;
    public static final Map<String, SheetModalItemConfigEnum> a = null;
    public static final /* synthetic */ SheetModalItemConfigEnum[] b = null;
    public String itemId;
    public int leftIconRes;

    static {
        int r4 = 0;
        SheetModalItemConfigEnum r0 = new SheetModalItemConfigEnum("CREATE_SHEET", 0, "create_sheet", 2131247799);
        CREATE_SHEET = r0;
        SheetModalItemConfigEnum r1 = new SheetModalItemConfigEnum("CREATE_GRID", 1, "create_grid", 2131253853);
        CREATE_GRID = r1;
        SheetModalItemConfigEnum r2 = new SheetModalItemConfigEnum("CREATE_KANBAN", 2, "create_kanban", 2131253854);
        CREATE_KANBAN = r2;
        SheetModalItemConfigEnum r3 = new SheetModalItemConfigEnum("CREATE_BITABLE", 3, "create_bitable", 2131254401);
        CREATE_BITABLE = r3;
        SheetModalItemConfigEnum r5 = new SheetModalItemConfigEnum("DELETE", 4, "delete", 2131247786);
        DELETE = r5;
        SheetModalItemConfigEnum r7 = new SheetModalItemConfigEnum("RENAME", 5, "rename", 2131247797);
        RENAME = r7;
        SheetModalItemConfigEnum r9 = new SheetModalItemConfigEnum("COPY", 6, "copy", 2131247785);
        COPY = r9;
        b = new SheetModalItemConfigEnum[]{r0, r1, r2, r3, r5, r7, r9};
        a = new HashMap();
        SheetModalItemConfigEnum[] r6 = values();
        int r8 = r6.length;
    L3:
        if (r4 >= r8) goto L5;
        SheetModalItemConfigEnum r10 = r6[r4];
        a.put(r10.itemId, r10);
        r4 = r4 + 1;
        goto L3
    }

    public static SheetModalItemConfigEnum[] values() {
        return (SheetModalItemConfigEnum[]) b.clone();
    }

    public static SheetModalItemConfigEnum getModalItem(String r1) {
        return (SheetModalItemConfigEnum) ((HashMap) a).get(r1);
    }

    public static SheetModalItemConfigEnum valueOf(String r1) {
        return (SheetModalItemConfigEnum) a.a(SheetModalItemConfigEnum.class, r1);
    }

    public SheetModalItemConfigEnum(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.itemId = r3;
        this.leftIconRes = r4;
    }
}
