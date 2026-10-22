package com.bytedance.ee.bear.contract;

/* JADX INFO: loaded from: classes16.dex */
public final enum AnalyticConstant$OpenType extends Enum<AnalyticConstant$OpenType> {
    public static final AnalyticConstant$OpenType FAVORITES = null;
    public static final AnalyticConstant$OpenType HOME_CREATE_BLANK = null;
    public static final AnalyticConstant$OpenType HOME_CREATE_PIN = null;
    public static final AnalyticConstant$OpenType HOME_CREATE_RECENT = null;
    public static final AnalyticConstant$OpenType HOME_CREATE_TEMPLATE = null;
    public static final AnalyticConstant$OpenType OFFLINE = null;
    public static final AnalyticConstant$OpenType PERSONAL_CREATE_BLANK = null;
    public static final AnalyticConstant$OpenType PERSONAL_CREATE_TEMPLATE = null;
    public static final AnalyticConstant$OpenType PERSONAL_FOLDER = null;
    public static final AnalyticConstant$OpenType PERSONAL_OWN = null;
    public static final AnalyticConstant$OpenType PERSONAL_SEARCH = null;
    public static final AnalyticConstant$OpenType SHARED_CREATE_BLANK = null;
    public static final AnalyticConstant$OpenType SHARED_CREATE_TEMPLATE = null;
    public static final AnalyticConstant$OpenType SHARED_SHARED_FOLDER = null;
    public static final AnalyticConstant$OpenType SHARED_SHARE_TOME = null;
    public static final AnalyticConstant$OpenType SPACE_AI_NOTES = null;
    public static final AnalyticConstant$OpenType SPACE_TEMPLATE = null;
    public static final AnalyticConstant$OpenType WIKI_ALL = null;
    public static final AnalyticConstant$OpenType WIKI_CREATE_NEW = null;
    public static final AnalyticConstant$OpenType WIKI_RECENT = null;
    public static final AnalyticConstant$OpenType WIKI_SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnalyticConstant$OpenType[] f216894a = null;
    String openType;

    static {
        AnalyticConstant$OpenType r100 = new AnalyticConstant$OpenType("HOME_CREATE_BLANK", 0, "lark_docs_home_CreateBlank");
        HOME_CREATE_BLANK = r100;
        AnalyticConstant$OpenType r101 = new AnalyticConstant$OpenType("HOME_CREATE_TEMPLATE", 1, "lark_docs_home_CreateTemplate");
        HOME_CREATE_TEMPLATE = r101;
        AnalyticConstant$OpenType r102 = new AnalyticConstant$OpenType("HOME_CREATE_PIN", 2, "lark_docs_home_Pin");
        HOME_CREATE_PIN = r102;
        AnalyticConstant$OpenType r103 = new AnalyticConstant$OpenType("HOME_CREATE_RECENT", 3, "lark_docs_home_Recent");
        HOME_CREATE_RECENT = r103;
        AnalyticConstant$OpenType r104 = new AnalyticConstant$OpenType("PERSONAL_CREATE_BLANK", 4, "lark_docs_personal_CreateBlank");
        PERSONAL_CREATE_BLANK = r104;
        AnalyticConstant$OpenType r105 = new AnalyticConstant$OpenType("PERSONAL_CREATE_TEMPLATE", 5, "lark_docs_personal_CreateTemplate");
        PERSONAL_CREATE_TEMPLATE = r105;
        AnalyticConstant$OpenType r110 = new AnalyticConstant$OpenType("PERSONAL_FOLDER", 6, "lark_docs_personal_Folder");
        PERSONAL_FOLDER = r110;
        AnalyticConstant$OpenType r111 = new AnalyticConstant$OpenType("PERSONAL_OWN", 7, "lark_docs_personal_Own");
        PERSONAL_OWN = r111;
        AnalyticConstant$OpenType r112 = new AnalyticConstant$OpenType("PERSONAL_SEARCH", 8, "lark_docs_personal_Search");
        PERSONAL_SEARCH = r112;
        AnalyticConstant$OpenType r113 = new AnalyticConstant$OpenType("SHARED_CREATE_BLANK", 9, "lark_docs_shared_CreateBlank");
        SHARED_CREATE_BLANK = r113;
        AnalyticConstant$OpenType r114 = new AnalyticConstant$OpenType("SHARED_CREATE_TEMPLATE", 10, "lark_docs_shared_CreateTemplate");
        SHARED_CREATE_TEMPLATE = r114;
        AnalyticConstant$OpenType r106 = new AnalyticConstant$OpenType("SHARED_SHARED_FOLDER", 11, "lark_docs_shared_SharedFolder");
        SHARED_SHARED_FOLDER = r106;
        AnalyticConstant$OpenType r107 = new AnalyticConstant$OpenType("SHARED_SHARE_TOME", 12, "lark_docs_shared_ShareToMe");
        SHARED_SHARE_TOME = r107;
        AnalyticConstant$OpenType r108 = new AnalyticConstant$OpenType("WIKI_CREATE_NEW", 13, "lark_docs_wiki_CreateNew");
        WIKI_CREATE_NEW = r108;
        AnalyticConstant$OpenType r109 = new AnalyticConstant$OpenType("WIKI_RECENT", 14, "lark_docs_wiki_Recent");
        WIKI_RECENT = r109;
        AnalyticConstant$OpenType r115 = new AnalyticConstant$OpenType("WIKI_ALL", 15, "lark_docs_wiki_All");
        WIKI_ALL = r115;
        AnalyticConstant$OpenType r116 = new AnalyticConstant$OpenType("WIKI_SEARCH", 16, "space_search");
        WIKI_SEARCH = r116;
        AnalyticConstant$OpenType r117 = new AnalyticConstant$OpenType("FAVORITES", 17, "lark_docs_favorites");
        FAVORITES = r117;
        AnalyticConstant$OpenType r118 = new AnalyticConstant$OpenType("OFFLINE", 18, "lark_docs_offline");
        OFFLINE = r118;
        AnalyticConstant$OpenType r119 = new AnalyticConstant$OpenType("SPACE_TEMPLATE", 19, "lark_docs_spaceTemplate");
        SPACE_TEMPLATE = r119;
        AnalyticConstant$OpenType r120 = new AnalyticConstant$OpenType("SPACE_AI_NOTES", 20, "lark_docs_space_ai_notes");
        SPACE_AI_NOTES = r120;
        f216894a = new AnalyticConstant$OpenType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120};
    }

    public static AnalyticConstant$OpenType[] values() {
        return (AnalyticConstant$OpenType[]) f216894a.clone();
    }

    public String getType() {
        return this.openType;
    }

    public static AnalyticConstant$OpenType valueOf(String r100) {
        return (AnalyticConstant$OpenType) r27.a.a(AnalyticConstant$OpenType.class, r100);
    }

    public AnalyticConstant$OpenType(String r100, int r101, String r102) {
        super(r100, r101);
        this.openType = r102;
    }
}
