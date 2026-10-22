package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "", "LOADING", "SUCCESS", "FAILED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum CacheItemStatus extends Enum<CacheItemStatus> {
    public static final CacheItemStatus FAILED = null;
    public static final CacheItemStatus LOADING = null;
    public static final CacheItemStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheItemStatus[] f247770a = null;

    public static CacheItemStatus valueOf(String r100) {
        return (CacheItemStatus) r27.a.a(CacheItemStatus.class, r100);
    }

    public static CacheItemStatus[] values() {
        return (CacheItemStatus[]) f247770a.clone();
    }

    static {
        CacheItemStatus r100 = new CacheItemStatus("LOADING", 0);
        LOADING = r100;
        CacheItemStatus r101 = new CacheItemStatus("SUCCESS", 1);
        SUCCESS = r101;
        CacheItemStatus r102 = new CacheItemStatus("FAILED", 2);
        FAILED = r102;
        f247770a = new CacheItemStatus[]{r100, r101, r102};
    }

    public CacheItemStatus(String r100, int r101) {
        super(r100, r101);
    }
}
