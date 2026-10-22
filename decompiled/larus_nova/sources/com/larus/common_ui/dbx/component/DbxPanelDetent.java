package com.larus.common_ui.dbx.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDetent;", "", "<init>", "(Ljava/lang/String;I)V", "MINIMUM", "MAXIMUM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxPanelDetent extends Enum<DbxPanelDetent> {
    public static final DbxPanelDetent MAXIMUM = null;
    public static final DbxPanelDetent MINIMUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DbxPanelDetent[] f326943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326944b = null;

    public static EnumEntries<DbxPanelDetent> getEntries() {
        return f326944b;
    }

    static {
        DbxPanelDetent r100 = new DbxPanelDetent("MINIMUM", 0);
        MINIMUM = r100;
        DbxPanelDetent r101 = new DbxPanelDetent("MAXIMUM", 1);
        MAXIMUM = r101;
        DbxPanelDetent[] r102 = {r100, r101};
        f326943a = r102;
        f326944b = EnumEntriesKt.enumEntries(r102);
    }

    public static DbxPanelDetent[] values() {
        return (DbxPanelDetent[]) f326943a.clone();
    }

    public static DbxPanelDetent valueOf(String r100) {
        return (DbxPanelDetent) r27.a.a(DbxPanelDetent.class, r100);
    }

    public DbxPanelDetent(String r100, int r101) {
        super(r100, r101);
    }
}
