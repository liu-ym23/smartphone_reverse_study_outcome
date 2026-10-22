package com.bytedance.kmp.sqlite;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/sqlite/CombinationOperator;", "", "", "opName", "Ljava/lang/String;", "getOpName", "()Ljava/lang/String;", "AND", "OR", "sqlite_service_release"}, k = 1, mv = {1, 7, 0})
public final enum CombinationOperator extends Enum<CombinationOperator> {
    public static final CombinationOperator AND = null;
    public static final CombinationOperator OR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CombinationOperator[] f252864a = null;
    private final String opName;

    public static CombinationOperator valueOf(String r100) {
        return (CombinationOperator) a.a(CombinationOperator.class, r100);
    }

    public static CombinationOperator[] values() {
        return (CombinationOperator[]) f252864a.clone();
    }

    static {
        CombinationOperator r100 = new CombinationOperator("AND", 0, "AND");
        AND = r100;
        CombinationOperator r101 = new CombinationOperator("OR", 1, "OR");
        OR = r101;
        f252864a = new CombinationOperator[]{r100, r101};
    }

    public final String getOpName() {
        return this.opName;
    }

    public CombinationOperator(String r100, int r101, String r102) {
        super(r100, r101);
        this.opName = r102;
    }
}
