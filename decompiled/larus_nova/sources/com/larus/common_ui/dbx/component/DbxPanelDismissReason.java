package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE_BUTTON", "BACKDROP", "DRAG_DOWN", "PROGRAMMATIC", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDismissReason extends Enum<DbxPanelDismissReason> {
    public static final DbxPanelDismissReason BACKDROP = null;
    public static final DbxPanelDismissReason CLOSE_BUTTON = null;
    public static final DbxPanelDismissReason DRAG_DOWN = null;
    public static final DbxPanelDismissReason PROGRAMMATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DbxPanelDismissReason[] f326947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326948b = null;

    public static EnumEntries<DbxPanelDismissReason> getEntries() {
        return f326948b;
    }

    static {
        DbxPanelDismissReason r100 = new DbxPanelDismissReason("CLOSE_BUTTON", 0);
        CLOSE_BUTTON = r100;
        DbxPanelDismissReason r101 = new DbxPanelDismissReason("BACKDROP", 1);
        BACKDROP = r101;
        DbxPanelDismissReason r102 = new DbxPanelDismissReason("DRAG_DOWN", 2);
        DRAG_DOWN = r102;
        DbxPanelDismissReason r103 = new DbxPanelDismissReason("PROGRAMMATIC", 3);
        PROGRAMMATIC = r103;
        DbxPanelDismissReason[] r104 = {r100, r101, r102, r103};
        f326947a = r104;
        f326948b = EnumEntriesKt.enumEntries(r104);
    }

    public static DbxPanelDismissReason[] values() {
        return (DbxPanelDismissReason[]) f326947a.clone();
    }

    public static DbxPanelDismissReason valueOf(String r100) {
        return (DbxPanelDismissReason) r27.a.a(DbxPanelDismissReason.class, r100);
    }

    public DbxPanelDismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
