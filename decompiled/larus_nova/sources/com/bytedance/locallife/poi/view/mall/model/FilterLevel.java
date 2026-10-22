package com.bytedance.locallife.poi.view.mall.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/FilterLevel;", "", "FIRST_LEVEL", "SECOND_LEVEL", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum FilterLevel extends Enum<FilterLevel> {
    public static final FilterLevel FIRST_LEVEL = null;
    public static final FilterLevel SECOND_LEVEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterLevel[] f264265a = null;

    public static FilterLevel valueOf(String r100) {
        return (FilterLevel) a.a(FilterLevel.class, r100);
    }

    public static FilterLevel[] values() {
        return (FilterLevel[]) f264265a.clone();
    }

    static {
        FilterLevel r100 = new FilterLevel("FIRST_LEVEL", 0);
        FIRST_LEVEL = r100;
        FilterLevel r101 = new FilterLevel("SECOND_LEVEL", 1);
        SECOND_LEVEL = r101;
        f264265a = new FilterLevel[]{r100, r101};
    }

    public FilterLevel(String r100, int r101) {
        super(r100, r101);
    }
}
