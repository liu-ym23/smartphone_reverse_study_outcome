package com.bytedance.locallife.dito.core.page;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/dito/core/page/PageStage;", "", "CREATE", "REQUEST", "PARSE", "RENDER", "STABLE", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum PageStage extends Enum<PageStage> {
    public static final PageStage CREATE = null;
    public static final PageStage PARSE = null;
    public static final PageStage RENDER = null;
    public static final PageStage REQUEST = null;
    public static final PageStage STABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStage[] f257969a = null;

    public static PageStage valueOf(String r100) {
        return (PageStage) a.a(PageStage.class, r100);
    }

    public static PageStage[] values() {
        return (PageStage[]) f257969a.clone();
    }

    static {
        PageStage r100 = new PageStage("CREATE", 0);
        CREATE = r100;
        PageStage r101 = new PageStage("REQUEST", 1);
        REQUEST = r101;
        PageStage r102 = new PageStage("PARSE", 2);
        PARSE = r102;
        PageStage r103 = new PageStage("RENDER", 3);
        RENDER = r103;
        PageStage r104 = new PageStage("STABLE", 4);
        STABLE = r104;
        f257969a = new PageStage[]{r100, r101, r102, r103, r104};
    }

    public PageStage(String r100, int r101) {
        super(r100, r101);
    }
}
