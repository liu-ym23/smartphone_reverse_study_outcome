package com.bytedance.ee.bear.bitable.load.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/cache/CacheType;", "", "<init>", "(Ljava/lang/String;I)V", "MEMORY", "DB", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CacheType extends Enum<CacheType> {
    public static final CacheType DB = null;
    public static final CacheType MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheType[] f214470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214471b = null;

    public static EnumEntries<CacheType> getEntries() {
        return f214471b;
    }

    static {
        CacheType r100 = new CacheType("MEMORY", 0);
        MEMORY = r100;
        CacheType r101 = new CacheType("DB", 1);
        DB = r101;
        CacheType[] r102 = {r100, r101};
        f214470a = r102;
        f214471b = EnumEntriesKt.enumEntries(r102);
    }

    public static CacheType[] values() {
        return (CacheType[]) f214470a.clone();
    }

    public static CacheType valueOf(String r100) {
        return (CacheType) r27.a.a(CacheType.class, r100);
    }

    public CacheType(String r100, int r101) {
        super(r100, r101);
    }
}
