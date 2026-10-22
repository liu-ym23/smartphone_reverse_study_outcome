package com.bytedance.ee.bear.list.loadstateview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum LoadFailCategory extends Enum<LoadFailCategory> {
    public static final int DEFAULT_VALUE = -1;
    public static final LoadFailCategory FOLDER_NOT_FOUND = null;
    public static final LoadFailCategory NO_NETWORK = null;
    public static final LoadFailCategory OVERTIME = null;
    public static final LoadFailCategory TEMPLATE_FAIL = null;
    public static final LoadFailCategory UNKNOWN = null;
    public static final /* synthetic */ LoadFailCategory[] a = null;
    private final int descTextRes;
    private final int imageRes;
    private final int primaryTextRes;
    private final int secondaryTextRes;
    private final int titleTextRes;

    static {
        LoadFailCategory r0 = new LoadFailCategory("NO_NETWORK", 0, 2131232543, 2131887792);
        NO_NETWORK = r0;
        LoadFailCategory r1 = new LoadFailCategory("UNKNOWN", 1, 2131232542, 2131887767);
        UNKNOWN = r1;
        LoadFailCategory r2 = new LoadFailCategory("OVERTIME", 2, 2131232542, 2131887768);
        OVERTIME = r2;
        LoadFailCategory r5 = new LoadFailCategory("TEMPLATE_FAIL", 3, 2131232543, 2131888269);
        TEMPLATE_FAIL = r5;
        LoadFailCategory r4 = new LoadFailCategory("FOLDER_NOT_FOUND", 4, 2131232542, 2131887128);
        FOLDER_NOT_FOUND = r4;
        a = new LoadFailCategory[]{r0, r1, r2, r5, r4};
    }

    public static LoadFailCategory[] values() {
        return (LoadFailCategory[]) a.clone();
    }

    public int getDescTextRes() {
        return this.descTextRes;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public int getPrimaryTextRes() {
        return this.primaryTextRes;
    }

    public int getSecondaryTextRes() {
        return this.secondaryTextRes;
    }

    public int getTitleTextRes() {
        return this.titleTextRes;
    }

    public static LoadFailCategory valueOf(String r1) {
        return (LoadFailCategory) r27.a.a(LoadFailCategory.class, r1);
    }

    public LoadFailCategory(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.imageRes = r3;
        this.titleTextRes = -1;
        this.descTextRes = r4;
        this.primaryTextRes = -1;
        this.secondaryTextRes = -1;
    }
}
