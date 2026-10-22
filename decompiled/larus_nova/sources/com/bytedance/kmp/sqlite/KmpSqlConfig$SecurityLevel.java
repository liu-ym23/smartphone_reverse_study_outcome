package com.bytedance.kmp.sqlite;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/kmp/sqlite/KmpSqlConfig$SecurityLevel", "", "Lcom/bytedance/kmp/sqlite/KmpSqlConfig$SecurityLevel;", "S1", "S2", "S3", "S4", "sqlite_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpSqlConfig$SecurityLevel extends Enum<KmpSqlConfig$SecurityLevel> {
    public static final KmpSqlConfig$SecurityLevel S1 = null;
    public static final KmpSqlConfig$SecurityLevel S2 = null;
    public static final KmpSqlConfig$SecurityLevel S3 = null;
    public static final KmpSqlConfig$SecurityLevel S4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpSqlConfig$SecurityLevel[] f252866a = null;

    public static KmpSqlConfig$SecurityLevel valueOf(String r100) {
        return (KmpSqlConfig$SecurityLevel) a.a(KmpSqlConfig$SecurityLevel.class, r100);
    }

    public static KmpSqlConfig$SecurityLevel[] values() {
        return (KmpSqlConfig$SecurityLevel[]) f252866a.clone();
    }

    static {
        KmpSqlConfig$SecurityLevel r100 = new KmpSqlConfig$SecurityLevel("S1", 0);
        S1 = r100;
        KmpSqlConfig$SecurityLevel r101 = new KmpSqlConfig$SecurityLevel("S2", 1);
        S2 = r101;
        KmpSqlConfig$SecurityLevel r102 = new KmpSqlConfig$SecurityLevel("S3", 2);
        S3 = r102;
        KmpSqlConfig$SecurityLevel r103 = new KmpSqlConfig$SecurityLevel("S4", 3);
        S4 = r103;
        f252866a = new KmpSqlConfig$SecurityLevel[]{r100, r101, r102, r103};
    }

    public KmpSqlConfig$SecurityLevel(String r100, int r101) {
        super(r100, r101);
    }
}
