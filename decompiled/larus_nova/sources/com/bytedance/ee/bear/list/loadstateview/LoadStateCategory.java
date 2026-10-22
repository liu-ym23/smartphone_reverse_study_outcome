package com.bytedance.ee.bear.list.loadstateview;

/* JADX INFO: loaded from: classes18.dex */
public final enum LoadStateCategory extends Enum<LoadStateCategory> {
    public static final LoadStateCategory IDLE = null;
    public static final LoadStateCategory LOADED_FAIL = null;
    public static final LoadStateCategory LOADED_SUCCESS = null;
    public static final LoadStateCategory LOADED_SUCCESS_EMPTY = null;
    public static final LoadStateCategory LOADING = null;
    public static final LoadStateCategory STARTUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStateCategory[] f228620a = null;

    static {
        LoadStateCategory r100 = new LoadStateCategory("STARTUP", 0);
        STARTUP = r100;
        LoadStateCategory r101 = new LoadStateCategory("IDLE", 1);
        IDLE = r101;
        LoadStateCategory r102 = new LoadStateCategory("LOADING", 2);
        LOADING = r102;
        LoadStateCategory r103 = new LoadStateCategory("LOADED_SUCCESS", 3);
        LOADED_SUCCESS = r103;
        LoadStateCategory r104 = new LoadStateCategory("LOADED_SUCCESS_EMPTY", 4);
        LOADED_SUCCESS_EMPTY = r104;
        LoadStateCategory r105 = new LoadStateCategory("LOADED_FAIL", 5);
        LOADED_FAIL = r105;
        f228620a = new LoadStateCategory[]{r100, r101, r102, r103, r104, r105};
    }

    public static LoadStateCategory[] values() {
        return (LoadStateCategory[]) f228620a.clone();
    }

    public static LoadStateCategory valueOf(String r100) {
        return (LoadStateCategory) r27.a.a(LoadStateCategory.class, r100);
    }

    public LoadStateCategory(String r100, int r101) {
        super(r100, r101);
    }
}
