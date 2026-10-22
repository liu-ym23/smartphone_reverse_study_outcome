package com.bytedance.locallife.dito.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/core/LoadingOrderStrategy;", "", "BODYLAST", "FOOTERBODYFIRST", "BODYFIRST", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadingOrderStrategy extends Enum<LoadingOrderStrategy> {
    public static final LoadingOrderStrategy BODYFIRST = null;
    public static final LoadingOrderStrategy BODYLAST = null;
    public static final LoadingOrderStrategy FOOTERBODYFIRST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingOrderStrategy[] f257870a = null;

    public static LoadingOrderStrategy valueOf(String r100) {
        return (LoadingOrderStrategy) r27.a.a(LoadingOrderStrategy.class, r100);
    }

    public static LoadingOrderStrategy[] values() {
        return (LoadingOrderStrategy[]) f257870a.clone();
    }

    static {
        LoadingOrderStrategy r100 = new LoadingOrderStrategy("BODYLAST", 0);
        BODYLAST = r100;
        LoadingOrderStrategy r101 = new LoadingOrderStrategy("FOOTERBODYFIRST", 1);
        FOOTERBODYFIRST = r101;
        LoadingOrderStrategy r102 = new LoadingOrderStrategy("BODYFIRST", 2);
        BODYFIRST = r102;
        f257870a = new LoadingOrderStrategy[]{r100, r101, r102};
    }

    public LoadingOrderStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
