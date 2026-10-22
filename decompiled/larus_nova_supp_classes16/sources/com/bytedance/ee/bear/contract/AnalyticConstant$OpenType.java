package com.bytedance.ee.bear.contract;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ AnalyticConstant$OpenType[] a = null;
    String openType;

    static {
        AnalyticConstant$OpenType r0 = new AnalyticConstant$OpenType("HOME_CREATE_BLANK", 0, "lark_docs_home_CreateBlank");
        HOME_CREATE_BLANK = r0;
        AnalyticConstant$OpenType r1 = new AnalyticConstant$OpenType("HOME_CREATE_TEMPLATE", 1, "lark_docs_home_CreateTemplate");
        HOME_CREATE_TEMPLATE = r1;
        AnalyticConstant$OpenType r2 = new AnalyticConstant$OpenType("HOME_CREATE_PIN", 2, "lark_docs_home_Pin");
        HOME_CREATE_PIN = r2;
        AnalyticConstant$OpenType r4 = new AnalyticConstant$OpenType("HOME_CREATE_RECENT", 3, "lark_docs_home_Recent");
        HOME_CREATE_RECENT = r4;
        AnalyticConstant$OpenType r6 = new AnalyticConstant$OpenType("PERSONAL_CREATE_BLANK", 4, "lark_docs_personal_CreateBlank");
        PERSONAL_CREATE_BLANK = r6;
        AnalyticConstant$OpenType r8 = new AnalyticConstant$OpenType("PERSONAL_CREATE_TEMPLATE", 5, "lark_docs_personal_CreateTemplate");
        PERSONAL_CREATE_TEMPLATE = r8;
        AnalyticConstant$OpenType r10 = new AnalyticConstant$OpenType("PERSONAL_FOLDER", 6, "lark_docs_personal_Folder");
        PERSONAL_FOLDER = r10;
        AnalyticConstant$OpenType r12 = new AnalyticConstant$OpenType("PERSONAL_OWN", 7, "lark_docs_personal_Own");
        PERSONAL_OWN = r12;
        AnalyticConstant$OpenType r14 = new AnalyticConstant$OpenType("PERSONAL_SEARCH", 8, "lark_docs_personal_Search");
        PERSONAL_SEARCH = r14;
        AnalyticConstant$OpenType r13 = new AnalyticConstant$OpenType("SHARED_CREATE_BLANK", 9, "lark_docs_shared_CreateBlank");
        SHARED_CREATE_BLANK = r13;
        AnalyticConstant$OpenType r11 = new AnalyticConstant$OpenType("SHARED_CREATE_TEMPLATE", 10, "lark_docs_shared_CreateTemplate");
        SHARED_CREATE_TEMPLATE = r11;
        AnalyticConstant$OpenType r9 = new AnalyticConstant$OpenType("SHARED_SHARED_FOLDER", 11, "lark_docs_shared_SharedFolder");
        SHARED_SHARED_FOLDER = r9;
        AnalyticConstant$OpenType r7 = new AnalyticConstant$OpenType("SHARED_SHARE_TOME", 12, "lark_docs_shared_ShareToMe");
        SHARED_SHARE_TOME = r7;
        AnalyticConstant$OpenType r5 = new AnalyticConstant$OpenType("WIKI_CREATE_NEW", 13, "lark_docs_wiki_CreateNew");
        WIKI_CREATE_NEW = r5;
        AnalyticConstant$OpenType r3 = new AnalyticConstant$OpenType("WIKI_RECENT", 14, "lark_docs_wiki_Recent");
        WIKI_RECENT = r3;
        AnalyticConstant$OpenType r16 = new AnalyticConstant$OpenType("WIKI_ALL", 15, "lark_docs_wiki_All");
        WIKI_ALL = r16;
        AnalyticConstant$OpenType r17 = new AnalyticConstant$OpenType("WIKI_SEARCH", 16, "space_search");
        WIKI_SEARCH = r17;
        AnalyticConstant$OpenType r18 = new AnalyticConstant$OpenType("FAVORITES", 17, "lark_docs_favorites");
        FAVORITES = r18;
        AnalyticConstant$OpenType r19 = new AnalyticConstant$OpenType("OFFLINE", 18, "lark_docs_offline");
        OFFLINE = r19;
        AnalyticConstant$OpenType r20 = new AnalyticConstant$OpenType("SPACE_TEMPLATE", 19, "lark_docs_spaceTemplate");
        SPACE_TEMPLATE = r20;
        AnalyticConstant$OpenType r21 = new AnalyticConstant$OpenType("SPACE_AI_NOTES", 20, "lark_docs_space_ai_notes");
        SPACE_AI_NOTES = r21;
        a = new AnalyticConstant$OpenType[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r16, r17, r18, r19, r20, r21};
    }

    public static AnalyticConstant$OpenType[] values() {
        return (AnalyticConstant$OpenType[]) a.clone();
    }

    public String getType() {
        return this.openType;
    }

    public static AnalyticConstant$OpenType valueOf(String r1) {
        return (AnalyticConstant$OpenType) r27.a.a(AnalyticConstant$OpenType.class, r1);
    }

    public AnalyticConstant$OpenType(String r1, int r2, String r3) {
        super(r1, r2);
        this.openType = r3;
    }
}
