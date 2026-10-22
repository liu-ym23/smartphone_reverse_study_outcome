package com.obric.memorydata.sdk.screencapture.rule;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NO_CACHE", "CACHE_WITH_ROOT_NODE", "CACHE_WITH_UNIQUE_NODE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CacheStrategy extends Enum<CacheStrategy> {
    public static final CacheStrategy CACHE_WITH_ROOT_NODE = null;
    public static final CacheStrategy CACHE_WITH_UNIQUE_NODE = null;
    public static final CacheStrategy NO_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStrategy[] f397264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397265b = null;

    public static EnumEntries<CacheStrategy> getEntries() {
        return f397265b;
    }

    static {
        CacheStrategy r100 = new CacheStrategy("NO_CACHE", 0);
        NO_CACHE = r100;
        CacheStrategy r101 = new CacheStrategy("CACHE_WITH_ROOT_NODE", 1);
        CACHE_WITH_ROOT_NODE = r101;
        CacheStrategy r102 = new CacheStrategy("CACHE_WITH_UNIQUE_NODE", 2);
        CACHE_WITH_UNIQUE_NODE = r102;
        CacheStrategy[] r103 = {r100, r101, r102};
        f397264a = r103;
        f397265b = EnumEntriesKt.enumEntries(r103);
    }

    public static CacheStrategy[] values() {
        return (CacheStrategy[]) f397264a.clone();
    }

    public static CacheStrategy valueOf(String r100) {
        return (CacheStrategy) a.a(CacheStrategy.class, r100);
    }

    public CacheStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
