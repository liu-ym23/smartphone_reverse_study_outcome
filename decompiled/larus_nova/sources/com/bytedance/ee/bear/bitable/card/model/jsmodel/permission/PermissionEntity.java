package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.ee.bear.sheet.fab.FabItem;
import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionEntity;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNDO_REDO", "TABLE", "RECORD", "FIELD", "VIEW", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "GROUP", "ROW_HEIGHT", "SORT", "TOOLBAR_FIELD", "TOOLBAR_FIND", "TOOLBAR_ADD_RECORD", "TABLE_MENU", "COMMENT", FabItem.FabSheetItem.CellType.CELL, "FORM", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionEntity extends Enum<PermissionEntity> {
    public static final PermissionEntity CELL = null;
    public static final PermissionEntity COMMENT = null;
    public static final PermissionEntity FIELD = null;
    public static final PermissionEntity FILTER = null;
    public static final PermissionEntity FORM = null;
    public static final PermissionEntity GROUP = null;
    public static final PermissionEntity RECORD = null;
    public static final PermissionEntity ROW_HEIGHT = null;
    public static final PermissionEntity SORT = null;
    public static final PermissionEntity TABLE = null;
    public static final PermissionEntity TABLE_MENU = null;
    public static final PermissionEntity TOOLBAR_ADD_RECORD = null;
    public static final PermissionEntity TOOLBAR_FIELD = null;
    public static final PermissionEntity TOOLBAR_FIND = null;
    public static final PermissionEntity UNDO_REDO = null;
    public static final PermissionEntity VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionEntity[] f207124a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207125b = null;
    private final String value;

    public static EnumEntries<PermissionEntity> getEntries() {
        return f207125b;
    }

    static {
        PermissionEntity r100 = new PermissionEntity("UNDO_REDO", 0, "UndoRedo");
        UNDO_REDO = r100;
        PermissionEntity r101 = new PermissionEntity("TABLE", 1, "Table");
        TABLE = r101;
        PermissionEntity r102 = new PermissionEntity("RECORD", 2, "Record");
        RECORD = r102;
        PermissionEntity r103 = new PermissionEntity("FIELD", 3, "Field");
        FIELD = r103;
        PermissionEntity r104 = new PermissionEntity("VIEW", 4, "View");
        VIEW = r104;
        PermissionEntity r105 = new PermissionEntity(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 5, EffectTypeConstants.TYPE_FILTER);
        FILTER = r105;
        PermissionEntity r110 = new PermissionEntity("GROUP", 6, "Group");
        GROUP = r110;
        PermissionEntity r111 = new PermissionEntity("ROW_HEIGHT", 7, "RowHeight");
        ROW_HEIGHT = r111;
        PermissionEntity r112 = new PermissionEntity("SORT", 8, "Sort");
        SORT = r112;
        PermissionEntity r113 = new PermissionEntity("TOOLBAR_FIELD", 9, "ToolbarField");
        TOOLBAR_FIELD = r113;
        PermissionEntity r114 = new PermissionEntity("TOOLBAR_FIND", 10, "ToolbarFind");
        TOOLBAR_FIND = r114;
        PermissionEntity r106 = new PermissionEntity("TOOLBAR_ADD_RECORD", 11, "ToolbarAddRecord");
        TOOLBAR_ADD_RECORD = r106;
        PermissionEntity r107 = new PermissionEntity("TABLE_MENU", 12, "TableMenu");
        TABLE_MENU = r107;
        PermissionEntity r108 = new PermissionEntity("COMMENT", 13, "Comment");
        COMMENT = r108;
        PermissionEntity r109 = new PermissionEntity(FabItem.FabSheetItem.CellType.CELL, 14, "Cell");
        CELL = r109;
        PermissionEntity r115 = new PermissionEntity("FORM", 15, "Form");
        FORM = r115;
        PermissionEntity[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
        f207124a = r116;
        f207125b = EnumEntriesKt.enumEntries(r116);
    }

    public static PermissionEntity[] values() {
        return (PermissionEntity[]) f207124a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static PermissionEntity valueOf(String r100) {
        return (PermissionEntity) a.a(PermissionEntity.class, r100);
    }

    public PermissionEntity(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
