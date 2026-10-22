package com.bytedance.awemeopen.domain.feed.preload;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/domain/feed/preload/AosPreloadCacheStrategy;", "", "", "value", "I", "getValue", "()I", "DEFAULT_STRATEGY", "ONLY_NEED_SPECIFIED_AIDS", "ONLY_NEED_SPECIFIED_AIDS_IN_CACHE", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final enum AosPreloadCacheStrategy extends Enum<AosPreloadCacheStrategy> {
    public static final AosPreloadCacheStrategy DEFAULT_STRATEGY = null;
    public static final AosPreloadCacheStrategy ONLY_NEED_SPECIFIED_AIDS = null;
    public static final AosPreloadCacheStrategy ONLY_NEED_SPECIFIED_AIDS_IN_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosPreloadCacheStrategy[] f198323a = null;
    private final int value;

    public static AosPreloadCacheStrategy valueOf(String r100) {
        return (AosPreloadCacheStrategy) r27.a.a(AosPreloadCacheStrategy.class, r100);
    }

    public static AosPreloadCacheStrategy[] values() {
        return (AosPreloadCacheStrategy[]) f198323a.clone();
    }

    static {
        AosPreloadCacheStrategy r100 = new AosPreloadCacheStrategy("DEFAULT_STRATEGY", 0, 1);
        DEFAULT_STRATEGY = r100;
        AosPreloadCacheStrategy r101 = new AosPreloadCacheStrategy("ONLY_NEED_SPECIFIED_AIDS", 1, 2);
        ONLY_NEED_SPECIFIED_AIDS = r101;
        AosPreloadCacheStrategy r102 = new AosPreloadCacheStrategy("ONLY_NEED_SPECIFIED_AIDS_IN_CACHE", 2, 2);
        ONLY_NEED_SPECIFIED_AIDS_IN_CACHE = r102;
        f198323a = new AosPreloadCacheStrategy[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AosPreloadCacheStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
