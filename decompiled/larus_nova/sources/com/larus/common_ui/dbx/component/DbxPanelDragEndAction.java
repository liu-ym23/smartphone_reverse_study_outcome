package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDragEndAction;", "", "<init>", "(Ljava/lang/String;I)V", "RESTORE", "MINIMUM", "MAXIMUM", "DISMISS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDragEndAction extends Enum<DbxPanelDragEndAction> {
    public static final DbxPanelDragEndAction DISMISS = null;
    public static final DbxPanelDragEndAction MAXIMUM = null;
    public static final DbxPanelDragEndAction MINIMUM = null;
    public static final DbxPanelDragEndAction RESTORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DbxPanelDragEndAction[] f326949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326950b = null;

    public static EnumEntries<DbxPanelDragEndAction> getEntries() {
        return f326950b;
    }

    static {
        DbxPanelDragEndAction r100 = new DbxPanelDragEndAction("RESTORE", 0);
        RESTORE = r100;
        DbxPanelDragEndAction r101 = new DbxPanelDragEndAction("MINIMUM", 1);
        MINIMUM = r101;
        DbxPanelDragEndAction r102 = new DbxPanelDragEndAction("MAXIMUM", 2);
        MAXIMUM = r102;
        DbxPanelDragEndAction r103 = new DbxPanelDragEndAction("DISMISS", 3);
        DISMISS = r103;
        DbxPanelDragEndAction[] r104 = {r100, r101, r102, r103};
        f326949a = r104;
        f326950b = EnumEntriesKt.enumEntries(r104);
    }

    public static DbxPanelDragEndAction[] values() {
        return (DbxPanelDragEndAction[]) f326949a.clone();
    }

    public static DbxPanelDragEndAction valueOf(String r100) {
        return (DbxPanelDragEndAction) r27.a.a(DbxPanelDragEndAction.class, r100);
    }

    public DbxPanelDragEndAction(String r100, int r101) {
        super(r100, r101);
    }
}
