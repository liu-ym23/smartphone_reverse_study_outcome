package com.bytedance.ee.bear.list.loadstateview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum LoadingCategory extends Enum<LoadingCategory> {
    public static final LoadingCategory CATEGORY_LIST = null;
    public static final LoadingCategory CATEGORY_TEMPLATE = null;
    public static final /* synthetic */ LoadingCategory[] a = null;
    private final int resId;

    static {
        LoadingCategory r0 = new LoadingCategory("CATEGORY_LIST", 0);
        CATEGORY_LIST = r0;
        LoadingCategory r1 = new LoadingCategory("CATEGORY_TEMPLATE", 1);
        CATEGORY_TEMPLATE = r1;
        a = new LoadingCategory[]{r0, r1};
    }

    public static LoadingCategory[] values() {
        return (LoadingCategory[]) a.clone();
    }

    public int getResId() {
        return this.resId;
    }

    public static LoadingCategory valueOf(String r1) {
        return (LoadingCategory) r27.a.a(LoadingCategory.class, r1);
    }

    public LoadingCategory(String r1, int r2) {
        super(r1, r2);
        this.resId = 2131820626;
    }
}
