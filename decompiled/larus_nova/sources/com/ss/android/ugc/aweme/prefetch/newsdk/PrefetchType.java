package com.ss.android.ugc.aweme.prefetch.newsdk;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/prefetch/newsdk/PrefetchType;", "", "INTERCEPTOR_PREFETCH", "PRE_PAGE_PREFETCH", "ANCHOR_PRESS_PREFETCH", "TIME_OUT_PREFETCH", "HAS_USE_DATA", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchType extends Enum<PrefetchType> {
    public static final PrefetchType ANCHOR_PRESS_PREFETCH = null;
    public static final PrefetchType HAS_USE_DATA = null;
    public static final PrefetchType INTERCEPTOR_PREFETCH = null;
    public static final PrefetchType PRE_PAGE_PREFETCH = null;
    public static final PrefetchType TIME_OUT_PREFETCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchType[] f451369a = null;

    public static PrefetchType valueOf(String r100) {
        return (PrefetchType) a.a(PrefetchType.class, r100);
    }

    public static PrefetchType[] values() {
        return (PrefetchType[]) f451369a.clone();
    }

    static {
        PrefetchType r100 = new PrefetchType("INTERCEPTOR_PREFETCH", 0);
        INTERCEPTOR_PREFETCH = r100;
        PrefetchType r101 = new PrefetchType("PRE_PAGE_PREFETCH", 1);
        PRE_PAGE_PREFETCH = r101;
        PrefetchType r102 = new PrefetchType("ANCHOR_PRESS_PREFETCH", 2);
        ANCHOR_PRESS_PREFETCH = r102;
        PrefetchType r103 = new PrefetchType("TIME_OUT_PREFETCH", 3);
        TIME_OUT_PREFETCH = r103;
        PrefetchType r104 = new PrefetchType("HAS_USE_DATA", 4);
        HAS_USE_DATA = r104;
        f451369a = new PrefetchType[]{r100, r101, r102, r103, r104};
    }

    public PrefetchType(String r100, int r101) {
        super(r100, r101);
    }
}
