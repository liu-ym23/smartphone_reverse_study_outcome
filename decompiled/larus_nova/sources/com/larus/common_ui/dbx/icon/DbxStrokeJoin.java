package com.larus.common_ui.dbx.icon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/dbx/icon/DbxStrokeJoin;", "", "<init>", "(Ljava/lang/String;I)V", "MITER", "ROUND", "BEVEL", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxStrokeJoin extends Enum<DbxStrokeJoin> {
    public static final DbxStrokeJoin BEVEL = null;
    public static final DbxStrokeJoin MITER = null;
    public static final DbxStrokeJoin ROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DbxStrokeJoin[] f327079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327080b = null;

    public static EnumEntries<DbxStrokeJoin> getEntries() {
        return f327080b;
    }

    static {
        DbxStrokeJoin r100 = new DbxStrokeJoin("MITER", 0);
        MITER = r100;
        DbxStrokeJoin r101 = new DbxStrokeJoin("ROUND", 1);
        ROUND = r101;
        DbxStrokeJoin r102 = new DbxStrokeJoin("BEVEL", 2);
        BEVEL = r102;
        DbxStrokeJoin[] r103 = {r100, r101, r102};
        f327079a = r103;
        f327080b = EnumEntriesKt.enumEntries(r103);
    }

    public static DbxStrokeJoin[] values() {
        return (DbxStrokeJoin[]) f327079a.clone();
    }

    public static DbxStrokeJoin valueOf(String r100) {
        return (DbxStrokeJoin) a.a(DbxStrokeJoin.class, r100);
    }

    public DbxStrokeJoin(String r100, int r101) {
        super(r100, r101);
    }
}
