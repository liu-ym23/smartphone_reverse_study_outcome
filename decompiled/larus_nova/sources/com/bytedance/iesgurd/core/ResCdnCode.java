package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/core/ResCdnCode;", "", "", "type", "I", "getType", "()I", "SKIP_CDN", "NO_PREPARE_META", "ULTRA_RESOURCE_IS_NULL", "ULTRA_RESOURCE_ERROR", "CDN_UNKNOWN_ERROR", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResCdnCode extends Enum<ResCdnCode> {
    public static final ResCdnCode CDN_UNKNOWN_ERROR = null;
    public static final ResCdnCode NO_PREPARE_META = null;
    public static final ResCdnCode SKIP_CDN = null;
    public static final ResCdnCode ULTRA_RESOURCE_ERROR = null;
    public static final ResCdnCode ULTRA_RESOURCE_IS_NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResCdnCode[] f250643a = null;
    private final int type;

    static {
        ResCdnCode r100 = new ResCdnCode("SKIP_CDN", 0, 1);
        SKIP_CDN = r100;
        ResCdnCode r101 = new ResCdnCode("NO_PREPARE_META", 1, 2);
        NO_PREPARE_META = r101;
        ResCdnCode r102 = new ResCdnCode("ULTRA_RESOURCE_IS_NULL", 2, 3);
        ULTRA_RESOURCE_IS_NULL = r102;
        ResCdnCode r103 = new ResCdnCode("ULTRA_RESOURCE_ERROR", 3, 4);
        ULTRA_RESOURCE_ERROR = r103;
        ResCdnCode r104 = new ResCdnCode("CDN_UNKNOWN_ERROR", 4, 99);
        CDN_UNKNOWN_ERROR = r104;
        f250643a = new ResCdnCode[]{r100, r101, r102, r103, r104};
    }

    public static ResCdnCode valueOf(String r100) {
        return (ResCdnCode) r27.a.a(ResCdnCode.class, r100);
    }

    public static ResCdnCode[] values() {
        return (ResCdnCode[]) f250643a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ResCdnCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
