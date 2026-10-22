package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PoolResult;", "", "SUCCESS", "FAIL_EXISTS", "FAIL_LOAD_ERROR", "FAIL_INVALID", "FAIL_EXCEPTION", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PoolResult extends Enum<PoolResult> {
    public static final PoolResult FAIL_EXCEPTION = null;
    public static final PoolResult FAIL_EXISTS = null;
    public static final PoolResult FAIL_INVALID = null;
    public static final PoolResult FAIL_LOAD_ERROR = null;
    public static final PoolResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoolResult[] f247774a = null;

    public static PoolResult valueOf(String r100) {
        return (PoolResult) r27.a.a(PoolResult.class, r100);
    }

    public static PoolResult[] values() {
        return (PoolResult[]) f247774a.clone();
    }

    static {
        PoolResult r100 = new PoolResult("SUCCESS", 0);
        SUCCESS = r100;
        PoolResult r101 = new PoolResult("FAIL_EXISTS", 1);
        FAIL_EXISTS = r101;
        PoolResult r102 = new PoolResult("FAIL_LOAD_ERROR", 2);
        FAIL_LOAD_ERROR = r102;
        PoolResult r103 = new PoolResult("FAIL_INVALID", 3);
        FAIL_INVALID = r103;
        PoolResult r104 = new PoolResult("FAIL_EXCEPTION", 4);
        FAIL_EXCEPTION = r104;
        f247774a = new PoolResult[]{r100, r101, r102, r103, r104};
    }

    public PoolResult(String r100, int r101) {
        super(r100, r101);
    }
}
