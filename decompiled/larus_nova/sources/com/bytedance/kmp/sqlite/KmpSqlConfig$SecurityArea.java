package com.bytedance.kmp.sqlite;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/kmp/sqlite/KmpSqlConfig$SecurityArea", "", "Lcom/bytedance/kmp/sqlite/KmpSqlConfig$SecurityArea;", "EL1", "EL2", "EL3", "EL4", "EL5", "sqlite_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpSqlConfig$SecurityArea extends Enum<KmpSqlConfig$SecurityArea> {
    public static final KmpSqlConfig$SecurityArea EL1 = null;
    public static final KmpSqlConfig$SecurityArea EL2 = null;
    public static final KmpSqlConfig$SecurityArea EL3 = null;
    public static final KmpSqlConfig$SecurityArea EL4 = null;
    public static final KmpSqlConfig$SecurityArea EL5 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpSqlConfig$SecurityArea[] f252865a = null;

    public static KmpSqlConfig$SecurityArea valueOf(String r100) {
        return (KmpSqlConfig$SecurityArea) a.a(KmpSqlConfig$SecurityArea.class, r100);
    }

    public static KmpSqlConfig$SecurityArea[] values() {
        return (KmpSqlConfig$SecurityArea[]) f252865a.clone();
    }

    static {
        KmpSqlConfig$SecurityArea r100 = new KmpSqlConfig$SecurityArea("EL1", 0);
        EL1 = r100;
        KmpSqlConfig$SecurityArea r101 = new KmpSqlConfig$SecurityArea("EL2", 1);
        EL2 = r101;
        KmpSqlConfig$SecurityArea r102 = new KmpSqlConfig$SecurityArea("EL3", 2);
        EL3 = r102;
        KmpSqlConfig$SecurityArea r103 = new KmpSqlConfig$SecurityArea("EL4", 3);
        EL4 = r103;
        KmpSqlConfig$SecurityArea r104 = new KmpSqlConfig$SecurityArea("EL5", 4);
        EL5 = r104;
        f252865a = new KmpSqlConfig$SecurityArea[]{r100, r101, r102, r103, r104};
    }

    public KmpSqlConfig$SecurityArea(String r100, int r101) {
        super(r100, r101);
    }
}
