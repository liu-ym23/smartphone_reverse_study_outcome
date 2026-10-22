package com.larus.common_ui.dbx.icon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/dbx/icon/DbxStrokeCap;", "", "<init>", "(Ljava/lang/String;I)V", "BUTT", "ROUND", "SQUARE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DbxStrokeCap extends Enum<DbxStrokeCap> {
    public static final DbxStrokeCap BUTT = null;
    public static final DbxStrokeCap ROUND = null;
    public static final DbxStrokeCap SQUARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DbxStrokeCap[] f327077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327078b = null;

    public static EnumEntries<DbxStrokeCap> getEntries() {
        return f327078b;
    }

    static {
        DbxStrokeCap r100 = new DbxStrokeCap("BUTT", 0);
        BUTT = r100;
        DbxStrokeCap r101 = new DbxStrokeCap("ROUND", 1);
        ROUND = r101;
        DbxStrokeCap r102 = new DbxStrokeCap("SQUARE", 2);
        SQUARE = r102;
        DbxStrokeCap[] r103 = {r100, r101, r102};
        f327077a = r103;
        f327078b = EnumEntriesKt.enumEntries(r103);
    }

    public static DbxStrokeCap[] values() {
        return (DbxStrokeCap[]) f327077a.clone();
    }

    public static DbxStrokeCap valueOf(String r100) {
        return (DbxStrokeCap) a.a(DbxStrokeCap.class, r100);
    }

    public DbxStrokeCap(String r100, int r101) {
        super(r100, r101);
    }
}
