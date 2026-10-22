package com.bytedance.ee.bear.list.loadstateview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum LoadStateCategory extends Enum<LoadStateCategory> {
    public static final LoadStateCategory IDLE = null;
    public static final LoadStateCategory LOADED_FAIL = null;
    public static final LoadStateCategory LOADED_SUCCESS = null;
    public static final LoadStateCategory LOADED_SUCCESS_EMPTY = null;
    public static final LoadStateCategory LOADING = null;
    public static final LoadStateCategory STARTUP = null;
    public static final /* synthetic */ LoadStateCategory[] a = null;

    static {
        LoadStateCategory r0 = new LoadStateCategory("STARTUP", 0);
        STARTUP = r0;
        LoadStateCategory r1 = new LoadStateCategory("IDLE", 1);
        IDLE = r1;
        LoadStateCategory r3 = new LoadStateCategory("LOADING", 2);
        LOADING = r3;
        LoadStateCategory r5 = new LoadStateCategory("LOADED_SUCCESS", 3);
        LOADED_SUCCESS = r5;
        LoadStateCategory r7 = new LoadStateCategory("LOADED_SUCCESS_EMPTY", 4);
        LOADED_SUCCESS_EMPTY = r7;
        LoadStateCategory r9 = new LoadStateCategory("LOADED_FAIL", 5);
        LOADED_FAIL = r9;
        a = new LoadStateCategory[]{r0, r1, r3, r5, r7, r9};
    }

    public static LoadStateCategory[] values() {
        return (LoadStateCategory[]) a.clone();
    }

    public static LoadStateCategory valueOf(String r1) {
        return (LoadStateCategory) r27.a.a(LoadStateCategory.class, r1);
    }

    public LoadStateCategory(String r1, int r2) {
        super(r1, r2);
    }
}
