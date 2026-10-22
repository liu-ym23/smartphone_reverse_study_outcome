package com.bytedance.locallife.dito.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/data/LayoutTypology;", "", "BODY_AS_POPUP", "FULL_PAGE_AS_POPUP", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LayoutTypology extends Enum<LayoutTypology> {
    public static final LayoutTypology BODY_AS_POPUP = null;
    public static final LayoutTypology FULL_PAGE_AS_POPUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutTypology[] f258192a = null;

    public static LayoutTypology valueOf(String r100) {
        return (LayoutTypology) r27.a.a(LayoutTypology.class, r100);
    }

    public static LayoutTypology[] values() {
        return (LayoutTypology[]) f258192a.clone();
    }

    static {
        LayoutTypology r100 = new LayoutTypology("BODY_AS_POPUP", 0);
        BODY_AS_POPUP = r100;
        LayoutTypology r101 = new LayoutTypology("FULL_PAGE_AS_POPUP", 1);
        FULL_PAGE_AS_POPUP = r101;
        f258192a = new LayoutTypology[]{r100, r101};
    }

    public LayoutTypology(String r100, int r101) {
        super(r100, r101);
    }
}
