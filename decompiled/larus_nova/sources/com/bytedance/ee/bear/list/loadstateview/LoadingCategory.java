package com.bytedance.ee.bear.list.loadstateview;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum LoadingCategory extends Enum<LoadingCategory> {
    public static final LoadingCategory CATEGORY_LIST = null;
    public static final LoadingCategory CATEGORY_TEMPLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingCategory[] f228637a = null;
    private final int resId;

    static {
        LoadingCategory r100 = new LoadingCategory("CATEGORY_LIST", 0);
        CATEGORY_LIST = r100;
        LoadingCategory r101 = new LoadingCategory("CATEGORY_TEMPLATE", 1);
        CATEGORY_TEMPLATE = r101;
        f228637a = new LoadingCategory[]{r100, r101};
    }

    public static LoadingCategory[] values() {
        return (LoadingCategory[]) f228637a.clone();
    }

    public int getResId() {
        return this.resId;
    }

    public static LoadingCategory valueOf(String r100) {
        return (LoadingCategory) r27.a.a(LoadingCategory.class, r100);
    }

    public LoadingCategory(String r100, int r101) {
        super(r100, r101);
        this.resId = R.raw.loading_anim;
    }
}
