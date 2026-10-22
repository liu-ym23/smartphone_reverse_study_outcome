package com.bytedance.ee.bear.sheet.tab.model;

import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum SheetModalItemConfigEnum extends Enum<SheetModalItemConfigEnum> {
    public static final SheetModalItemConfigEnum COPY = null;
    public static final SheetModalItemConfigEnum CREATE_BITABLE = null;
    public static final SheetModalItemConfigEnum CREATE_GRID = null;
    public static final SheetModalItemConfigEnum CREATE_KANBAN = null;
    public static final SheetModalItemConfigEnum CREATE_SHEET = null;
    public static final SheetModalItemConfigEnum DELETE = null;
    public static final SheetModalItemConfigEnum RENAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, SheetModalItemConfigEnum> f238380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ SheetModalItemConfigEnum[] f238381b = null;
    public String itemId;
    public int leftIconRes;

    static {
        int r100 = 0;
        SheetModalItemConfigEnum r101 = new SheetModalItemConfigEnum("CREATE_SHEET", 0, "create_sheet", R.drawable.sheet_icon_sheet_table_outlined);
        CREATE_SHEET = r101;
        SheetModalItemConfigEnum r102 = new SheetModalItemConfigEnum("CREATE_GRID", 1, "create_grid", R.drawable.ud_icon_bitablegrid_outlined);
        CREATE_GRID = r102;
        SheetModalItemConfigEnum r103 = new SheetModalItemConfigEnum("CREATE_KANBAN", 2, "create_kanban", R.drawable.ud_icon_bitablekanban_outlined);
        CREATE_KANBAN = r103;
        SheetModalItemConfigEnum r104 = new SheetModalItemConfigEnum("CREATE_BITABLE", 3, "create_bitable", R.drawable.ud_icon_file_bitable_outlined);
        CREATE_BITABLE = r104;
        SheetModalItemConfigEnum r105 = new SheetModalItemConfigEnum("DELETE", 4, "delete", R.drawable.sheet_icon_delete_trash_outlined);
        DELETE = r105;
        SheetModalItemConfigEnum r106 = new SheetModalItemConfigEnum("RENAME", 5, "rename", R.drawable.sheet_icon_rename_outlined);
        RENAME = r106;
        SheetModalItemConfigEnum r107 = new SheetModalItemConfigEnum("COPY", 6, "copy", R.drawable.sheet_icon_copy_outlined);
        COPY = r107;
        f238381b = new SheetModalItemConfigEnum[]{r101, r102, r103, r104, r105, r106, r107};
        f238380a = new HashMap();
        SheetModalItemConfigEnum[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r100 >= r109) goto L5;
        SheetModalItemConfigEnum r110 = r108[r100];
        f238380a.put(r110.itemId, r110);
        r100 = r100 + 1;
        goto L3
    }

    public static SheetModalItemConfigEnum[] values() {
        return (SheetModalItemConfigEnum[]) f238381b.clone();
    }

    public static SheetModalItemConfigEnum getModalItem(String r100) {
        return (SheetModalItemConfigEnum) ((HashMap) f238380a).get(r100);
    }

    public static SheetModalItemConfigEnum valueOf(String r100) {
        return (SheetModalItemConfigEnum) a.a(SheetModalItemConfigEnum.class, r100);
    }

    public SheetModalItemConfigEnum(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.itemId = r102;
        this.leftIconRes = r103;
    }
}
