package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreLoadResult;", "", "SUCCESS", "ERR_NOT_SCHEMA_SERVICE", "ERR_NOT_INIT", "ERR_MISS_PAGE_ID", "ERR_MISS_CONFIG", "ERR_GET_CONFIG_FAILED", "ERR_CONFIG_EMPTY", "ERR_URL_EMPTY", "ERR_NOT_ENABLED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PreLoadResult extends Enum<PreLoadResult> {
    public static final PreLoadResult ERR_CONFIG_EMPTY = null;
    public static final PreLoadResult ERR_GET_CONFIG_FAILED = null;
    public static final PreLoadResult ERR_MISS_CONFIG = null;
    public static final PreLoadResult ERR_MISS_PAGE_ID = null;
    public static final PreLoadResult ERR_NOT_ENABLED = null;
    public static final PreLoadResult ERR_NOT_INIT = null;
    public static final PreLoadResult ERR_NOT_SCHEMA_SERVICE = null;
    public static final PreLoadResult ERR_URL_EMPTY = null;
    public static final PreLoadResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreLoadResult[] f247775a = null;

    public static PreLoadResult valueOf(String r100) {
        return (PreLoadResult) r27.a.a(PreLoadResult.class, r100);
    }

    public static PreLoadResult[] values() {
        return (PreLoadResult[]) f247775a.clone();
    }

    static {
        PreLoadResult r100 = new PreLoadResult("SUCCESS", 0);
        SUCCESS = r100;
        PreLoadResult r101 = new PreLoadResult("ERR_NOT_SCHEMA_SERVICE", 1);
        ERR_NOT_SCHEMA_SERVICE = r101;
        PreLoadResult r102 = new PreLoadResult("ERR_NOT_INIT", 2);
        ERR_NOT_INIT = r102;
        PreLoadResult r103 = new PreLoadResult("ERR_MISS_PAGE_ID", 3);
        ERR_MISS_PAGE_ID = r103;
        PreLoadResult r104 = new PreLoadResult("ERR_MISS_CONFIG", 4);
        ERR_MISS_CONFIG = r104;
        PreLoadResult r105 = new PreLoadResult("ERR_GET_CONFIG_FAILED", 5);
        ERR_GET_CONFIG_FAILED = r105;
        PreLoadResult r110 = new PreLoadResult("ERR_CONFIG_EMPTY", 6);
        ERR_CONFIG_EMPTY = r110;
        PreLoadResult r111 = new PreLoadResult("ERR_URL_EMPTY", 7);
        ERR_URL_EMPTY = r111;
        PreLoadResult r112 = new PreLoadResult("ERR_NOT_ENABLED", 8);
        ERR_NOT_ENABLED = r112;
        f247775a = new PreLoadResult[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public PreLoadResult(String r100, int r101) {
        super(r100, r101);
    }
}
