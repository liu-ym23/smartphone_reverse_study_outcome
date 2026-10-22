package com.bytedance.ee.bear.list.loadstateview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum EmptyCategory extends Enum<EmptyCategory> {
    public static final EmptyCategory AI_MEETING_NOTE = null;
    public static final EmptyCategory AI_MONTHLY = null;
    public static final EmptyCategory AI_RECORD_NOTE = null;
    public static final EmptyCategory AI_WEEKLY = null;
    public static final EmptyCategory BITABLE_RECENT_NORMAL = null;
    public static final EmptyCategory BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT = null;
    public static final EmptyCategory BUSINESS_TEMPLATE = null;
    public static final EmptyCategory CUSTOM_TEMPLATE = null;
    public static final EmptyCategory CUSTOM_TEMPLATE_V2 = null;
    public static final int DEFAULT_VALUE = -1;
    public static final EmptyCategory FAVORITE_FILTER = null;
    public static final EmptyCategory FAVORITE_NORMAL = null;
    public static final EmptyCategory FOLDER_NORMAL = null;
    public static final EmptyCategory FOLDER_READONLY = null;
    public static final EmptyCategory FOLDER_SELECT = null;
    public static final EmptyCategory MY_SPACE_FILTER = null;
    public static final EmptyCategory MY_SPACE_NORMAL = null;
    public static final EmptyCategory OFFLINE = null;
    public static final EmptyCategory PIN = null;
    public static final EmptyCategory RECENT_FILTER = null;
    public static final EmptyCategory RECENT_NORMAL = null;
    public static final EmptyCategory SEARCH_TEMPLATE = null;
    public static final EmptyCategory SEARCH_TEMPLATE_FOR_SYSTEM = null;
    public static final EmptyCategory SHARE = null;
    public static final EmptyCategory SHARE_FOLDER = null;
    public static final EmptyCategory SINGLE_CATEGORY_TEMPLATE = null;
    public static final EmptyCategory SUBORDINATE_RECENT = null;
    public static final EmptyCategory SYSTEM_TEMPLATE = null;
    public static final EmptyCategory TEMPLATE = null;
    public static final EmptyCategory UNKNOWN = null;
    public static final EmptyCategory WIKI = null;
    public static final EmptyCategory WIKI_SPACE = null;
    public static final EmptyCategory WIKI_SPACE_MGMT = null;
    public static final /* synthetic */ EmptyCategory[] a = null;
    private final int descTextRes;
    private final int imageRes;
    private final int lintBtnTextRes;
    private final int primaryBtnTextRes;
    private final int secondaryBtnTextRes;
    private final int titleTextRes;

    static {
        EmptyCategory r8 = new EmptyCategory("PIN", 0, 2131232549, -1, 2131887954, -1, -1);
        PIN = r8;
        EmptyCategory r0 = new EmptyCategory("RECENT_NORMAL", 1, 2131232561, -1, 2131887751, 2131887730, -1);
        RECENT_NORMAL = r0;
        EmptyCategory r4 = new EmptyCategory("SUBORDINATE_RECENT", 2, 2131232561, -1, 2131888783, -1, -1);
        SUBORDINATE_RECENT = r4;
        EmptyCategory r6 = new EmptyCategory("BITABLE_RECENT_NORMAL", 3, 2131232561, -1, 2131886326, 2131887432, -1);
        BITABLE_RECENT_NORMAL = r6;
        EmptyCategory r7 = new EmptyCategory("BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT", 4, 2131232561, -1, 2131886901, -1, -1);
        BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT = r7;
        EmptyCategory r37 = new EmptyCategory("RECENT_FILTER", 5, 2131232561, -1, 2131887756, 2131887730, -1);
        RECENT_FILTER = r37;
        EmptyCategory r24 = new EmptyCategory("MY_SPACE_NORMAL", 6, 2131232561, -1, 2131887751, 2131887730, -1);
        MY_SPACE_NORMAL = r24;
        EmptyCategory r9 = new EmptyCategory("MY_SPACE_FILTER", 7, 2131232561, -1, 2131887756, 2131887730, -1);
        MY_SPACE_FILTER = r9;
        EmptyCategory r1 = new EmptyCategory("SHARE", 8, 2131232549, -1, 2131887753, -1, -1);
        SHARE = r1;
        EmptyCategory r25 = new EmptyCategory("SHARE_FOLDER", 9, 2131232549, -1, 2131887938, -1, -1);
        SHARE_FOLDER = r25;
        EmptyCategory r2 = new EmptyCategory("FAVORITE_NORMAL", 10, 2131232549, -1, 2131887786, -1, -1);
        FAVORITE_NORMAL = r2;
        EmptyCategory r3 = new EmptyCategory("FAVORITE_FILTER", 11, 2131232549, -1, 2131887756, -1, -1);
        FAVORITE_FILTER = r3;
        EmptyCategory r5 = new EmptyCategory("OFFLINE", 12, 2131232549, 2131887793, 2131887790, -1, -1);
        OFFLINE = r5;
        EmptyCategory r18 = new EmptyCategory("FOLDER_NORMAL", 13, 2131232561, -1, 2131887751, 2131887730, -1);
        FOLDER_NORMAL = r18;
        EmptyCategory r19 = new EmptyCategory("FOLDER_READONLY", 14, 2131232561, -1, 2131887901, -1, -1);
        FOLDER_READONLY = r19;
        EmptyCategory r20 = new EmptyCategory("WIKI", 15, 2131232557, -1, 2131888327, -1, -1);
        WIKI = r20;
        EmptyCategory r21 = new EmptyCategory("WIKI_SPACE", 16, 2131232557, -1, 2131889797, -1, -1);
        WIKI_SPACE = r21;
        EmptyCategory r22 = new EmptyCategory("WIKI_SPACE_MGMT", 17, 2131232557, -1, 2131889793, -1, -1);
        WIKI_SPACE_MGMT = r22;
        EmptyCategory r23 = new EmptyCategory("FOLDER_SELECT", 18, 2131232549, -1, 2131887902, -1, -1);
        FOLDER_SELECT = r23;
        EmptyCategory r38 = new EmptyCategory("UNKNOWN", 19, 2131232549, -1, 2131887751, 2131887730, -1);
        UNKNOWN = r38;
        EmptyCategory r26 = new EmptyCategory("TEMPLATE", 20, 2131232549, -1, -1, -1, -1);
        TEMPLATE = r26;
        EmptyCategory r27 = new EmptyCategory("SYSTEM_TEMPLATE", 21, 2131232549, 2131887903, -1, -1, -1);
        SYSTEM_TEMPLATE = r27;
        EmptyCategory r36 = new EmptyCategory("SEARCH_TEMPLATE", 22, 2131232557, -1, 2131887436, -1, -1);
        SEARCH_TEMPLATE = r36;
        EmptyCategory r10 = new EmptyCategory("SEARCH_TEMPLATE_FOR_SYSTEM", 23, 2131232557, -1, 2131887436, -1, -1);
        SEARCH_TEMPLATE_FOR_SYSTEM = r10;
        EmptyCategory r11 = new EmptyCategory("SINGLE_CATEGORY_TEMPLATE", 24, 2131232547, -1, 2131887903, -1, -1);
        SINGLE_CATEGORY_TEMPLATE = r11;
        EmptyCategory r12 = new EmptyCategory("CUSTOM_TEMPLATE", 25, 2131232547, 2131887890, 2131887889, -1, 2131887352);
        CUSTOM_TEMPLATE = r12;
        EmptyCategory r13 = new EmptyCategory("CUSTOM_TEMPLATE_V2", 26, 2131232549, 2131887890, 2131887889, -1, 2131887352);
        CUSTOM_TEMPLATE_V2 = r13;
        EmptyCategory r15 = new EmptyCategory("BUSINESS_TEMPLATE", 27, 2131232549, 2131887906, 2131887905, -1, -1);
        BUSINESS_TEMPLATE = r15;
        EmptyCategory r53 = new EmptyCategory("AI_MONTHLY", 28, 2131232549, -1, 2131888705, -1, -1);
        AI_MONTHLY = r53;
        EmptyCategory r28 = new EmptyCategory("AI_WEEKLY", 29, 2131232549, -1, 2131888706, -1, -1);
        AI_WEEKLY = r28;
        EmptyCategory r30 = new EmptyCategory("AI_MEETING_NOTE", 30, 2131232549, -1, 2131888704, 2131888703, -1);
        AI_MEETING_NOTE = r30;
        EmptyCategory r14 = new EmptyCategory("AI_RECORD_NOTE", 31, 2131232549, -1, 2131889715, 2131889716, -1);
        AI_RECORD_NOTE = r14;
        a = new EmptyCategory[]{r8, r0, r4, r6, r7, r37, r24, r9, r1, r25, r2, r3, r5, r18, r19, r20, r21, r22, r23, r38, r26, r27, r36, r10, r11, r12, r13, r15, r53, r28, r30, r14};
    }

    public static EmptyCategory[] values() {
        return (EmptyCategory[]) a.clone();
    }

    public int getDescTextRes() {
        return this.descTextRes;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public int getLintBtnTextRes() {
        return this.lintBtnTextRes;
    }

    public int getPrimaryBtnTextRes() {
        return this.primaryBtnTextRes;
    }

    public int getSecondaryBtnTextRes() {
        return this.secondaryBtnTextRes;
    }

    public int getTitleTextRes() {
        return this.titleTextRes;
    }

    public static EmptyCategory valueOf(String r1) {
        return (EmptyCategory) r27.a.a(EmptyCategory.class, r1);
    }

    public EmptyCategory(String r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        super(r1, r2);
        this.imageRes = r3;
        this.titleTextRes = r4;
        this.descTextRes = r5;
        this.primaryBtnTextRes = r6;
        this.secondaryBtnTextRes = -1;
        this.lintBtnTextRes = r7;
    }
}
