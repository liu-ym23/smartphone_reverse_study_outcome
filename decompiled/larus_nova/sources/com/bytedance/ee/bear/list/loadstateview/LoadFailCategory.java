package com.bytedance.ee.bear.list.loadstateview;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum LoadFailCategory extends Enum<LoadFailCategory> {
    public static final int DEFAULT_VALUE = -1;
    public static final LoadFailCategory FOLDER_NOT_FOUND = null;
    public static final LoadFailCategory NO_NETWORK = null;
    public static final LoadFailCategory OVERTIME = null;
    public static final LoadFailCategory TEMPLATE_FAIL = null;
    public static final LoadFailCategory UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadFailCategory[] f228619a = null;
    private final int descTextRes;
    private final int imageRes;
    private final int primaryTextRes;
    private final int secondaryTextRes;
    private final int titleTextRes;

    static {
        LoadFailCategory r100 = new LoadFailCategory("NO_NETWORK", 0, R.drawable.ccm_empty_negative_no_wifi, R.string.Doc_Facade_OfflineDocListInvisitable);
        NO_NETWORK = r100;
        LoadFailCategory r101 = new LoadFailCategory("UNKNOWN", 1, R.drawable.ccm_empty_negative_load_failed, R.string.Doc_Facade_LoadFailed);
        UNKNOWN = r101;
        LoadFailCategory r102 = new LoadFailCategory("OVERTIME", 2, R.drawable.ccm_empty_negative_load_failed, R.string.Doc_Facade_LoadOverTime);
        OVERTIME = r102;
        LoadFailCategory r103 = new LoadFailCategory("TEMPLATE_FAIL", 3, R.drawable.ccm_empty_negative_no_wifi, R.string.Doc_Space_EmptyPageNoNetDefaultTip);
        TEMPLATE_FAIL = r103;
        LoadFailCategory r104 = new LoadFailCategory("FOLDER_NOT_FOUND", 4, R.drawable.ccm_empty_negative_load_failed, R.string.CreationMobile_Common_Error_FolderNotExist);
        FOLDER_NOT_FOUND = r104;
        f228619a = new LoadFailCategory[]{r100, r101, r102, r103, r104};
    }

    public static LoadFailCategory[] values() {
        return (LoadFailCategory[]) f228619a.clone();
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

    public static LoadFailCategory valueOf(String r100) {
        return (LoadFailCategory) r27.a.a(LoadFailCategory.class, r100);
    }

    public LoadFailCategory(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.imageRes = r102;
        this.titleTextRes = -1;
        this.descTextRes = r103;
        this.primaryTextRes = -1;
        this.secondaryTextRes = -1;
    }
}
