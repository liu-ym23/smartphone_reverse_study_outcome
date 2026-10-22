package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum CustomScene extends Enum<CustomScene> {
    private static final /* synthetic */ CustomScene[] $VALUES = null;
    private static final int CLASS_BASE = 100000;
    public static final CustomScene COMMON_APP_START = null;
    public static final CustomScene COMMON_CAMERA_START = null;
    private static final int COMMON_CLASS = 1;
    public static final CustomScene COMMON_TAB_SWITCH = null;
    public static final CustomScene COMMON_WINDOW_SWITCH = null;
    private static final int DC_CLASS = 5;
    public static final CustomScene DC_SCROLL_HOME = null;
    public static final CustomScene DC_SCROLL_MOMENTS = null;
    public static final CustomScene DC_TAB_SWITCH = null;
    public static final CustomScene DC_VIDEO_FIRST_DRAW = null;
    public static final CustomScene DY_15S_CAPTURE_START = null;
    private static final int DY_CLASS = 2;
    public static final CustomScene DY_COMMENT_LOAD = null;
    public static final CustomScene DY_CONCURRENT_UPLOAD_COMPILE = null;
    public static final CustomScene DY_FEED_SCROLL = null;
    public static final CustomScene DY_GO_DUET = null;
    public static final CustomScene DY_GO_REACTION = null;
    public static final CustomScene DY_LIVING_ENTER_GIFT_PANEL = null;
    public static final CustomScene DY_LIVING_ENTER_GOODS_LIST = null;
    public static final CustomScene DY_LIVING_SCROLL = null;
    public static final CustomScene DY_TAB_FAMILIAR_LOAD = null;
    public static final CustomScene DY_TAB_FOLLOW_LOAD = null;
    public static final CustomScene DY_TAB_HOME_LOAD = null;
    public static final CustomScene DY_TAB_LIVING_LOAD = null;
    public static final CustomScene DY_TAB_MUSIC = null;
    public static final CustomScene DY_TAB_NEARBY_LOAD = null;
    public static final CustomScene DY_TAB_NOTIFICATION_LOAD = null;
    public static final CustomScene DY_TAB_PUBLISH_LOAD = null;
    public static final CustomScene DY_TAB_SEARCH_LOAD = null;
    public static final CustomScene DY_TAB_USER_LOAD = null;
    private static final int LAST_COMMON_SCENE_ID = 0;
    private static final int LAST_DC_SCENE_ID = 0;
    private static final int LAST_DY_SCENE_ID = 0;
    private static final int LAST_SCENE_ID = 0;
    private static final int LAST_TL_SCENE_ID = 0;
    private static final int LAST_TO_SCENE_ID = 0;
    private static final int LAST_TT_SCENE_ID = 0;
    public static final int MAX_CLASS = 0;
    private static final int TL_CLASS = 4;
    public static final CustomScene TL_CLICK_NEWS = null;
    public static final CustomScene TL_FIRST_FRAME_DRAW = null;
    public static final CustomScene TL_SCROLL_NEWS = null;
    public static final CustomScene TL_TAB_SWITCH = null;
    private static final int TO_CLASS = 3;
    public static final CustomScene TO_CLICK_NEWS = null;
    public static final CustomScene TO_FIRST_FRAME_DRAW = null;
    public static final CustomScene TO_SCROLL_NEWS = null;
    public static final CustomScene TO_TAB_SWITCH = null;
    public static final CustomScene TO_VIDEO_FIRST_FRAME = null;
    public static final CustomScene TT_15S_CAPTURE_START = null;
    private static final int TT_CLASS = 6;
    public static final CustomScene TT_COMMENT_LOAD = null;
    public static final CustomScene TT_CONCURRENT_UPLOAD_COMPILE = null;
    public static final CustomScene TT_FEED_SCROLL = null;
    public static final CustomScene TT_GO_DUET = null;
    public static final CustomScene TT_GO_REACTION = null;
    public static final CustomScene TT_LIVING_ENTER_GIFT_PANEL = null;
    public static final CustomScene TT_LIVING_ENTER_GOODS_LIST = null;
    public static final CustomScene TT_LIVING_SCROLL = null;
    public static final CustomScene TT_TAB_FAMILIAR_LOAD = null;
    public static final CustomScene TT_TAB_FOLLOW_LOAD = null;
    public static final CustomScene TT_TAB_HOME_LOAD = null;
    public static final CustomScene TT_TAB_LIVING_LOAD = null;
    public static final CustomScene TT_TAB_MUSIC = null;
    public static final CustomScene TT_TAB_NEARBY_LOAD = null;
    public static final CustomScene TT_TAB_NOTIFICATION_LOAD = null;
    public static final CustomScene TT_TAB_PUBLISH_LOAD = null;
    public static final CustomScene TT_TAB_SEARCH_LOAD = null;
    public static final CustomScene TT_TAB_USER_LOAD = null;
    private String desc;
    private int id;

    static {
        CustomScene r0 = new CustomScene("COMMON_APP_START", 0, 100001, "common_app_start");
        COMMON_APP_START = r0;
        CustomScene r1 = new CustomScene("COMMON_CAMERA_START", 1, 100002, "common_camera_start");
        COMMON_CAMERA_START = r1;
        CustomScene r2 = new CustomScene("COMMON_WINDOW_SWITCH", 2, 100003, "common_window_switch");
        COMMON_WINDOW_SWITCH = r2;
        CustomScene r3 = new CustomScene("COMMON_TAB_SWITCH", 3, 100004, "common_tab_switch");
        COMMON_TAB_SWITCH = r3;
        CustomScene r5 = new CustomScene("DY_GO_DUET", 4, 200001, "dy_go_duet");
        DY_GO_DUET = r5;
        CustomScene r7 = new CustomScene("DY_GO_REACTION", 5, 200002, "dy_go_reaction");
        DY_GO_REACTION = r7;
        CustomScene r9 = new CustomScene("DY_TAB_LIVING_LOAD", 6, 200003, "dy_tab_living_load");
        DY_TAB_LIVING_LOAD = r9;
        CustomScene r11 = new CustomScene("DY_TAB_NEARBY_LOAD", 7, 200004, "dy_tab_nearby_load");
        DY_TAB_NEARBY_LOAD = r11;
        CustomScene r13 = new CustomScene("DY_TAB_FOLLOW_LOAD", 8, 200005, "dy_tab_follow_load");
        DY_TAB_FOLLOW_LOAD = r13;
        CustomScene r12 = new CustomScene("DY_TAB_SEARCH_LOAD", 9, 200006, "dy_tab_search_load");
        DY_TAB_SEARCH_LOAD = r12;
        CustomScene r10 = new CustomScene("DY_TAB_HOME_LOAD", 10, 200007, "dy_tab_home_load");
        DY_TAB_HOME_LOAD = r10;
        CustomScene r8 = new CustomScene("DY_TAB_FAMILIAR_LOAD", 11, 200008, "dy_tab_familiar_load");
        DY_TAB_FAMILIAR_LOAD = r8;
        CustomScene r6 = new CustomScene("DY_TAB_PUBLISH_LOAD", 12, 200009, "dy_tab_publish_load");
        DY_TAB_PUBLISH_LOAD = r6;
        CustomScene r4 = new CustomScene("DY_TAB_NOTIFICATION_LOAD", 13, 200010, "dy_tab_notification_load");
        DY_TAB_NOTIFICATION_LOAD = r4;
        CustomScene r14 = new CustomScene("DY_TAB_USER_LOAD", 14, 200011, "dy_tab_user_load");
        DY_TAB_USER_LOAD = r14;
        CustomScene r15 = new CustomScene("DY_CONCURRENT_UPLOAD_COMPILE", 15, 200012, "dy_concurrent_upload_compile");
        DY_CONCURRENT_UPLOAD_COMPILE = r15;
        CustomScene r16 = new CustomScene("DY_FEED_SCROLL", 16, 200013, "dy_feed_scroll");
        DY_FEED_SCROLL = r16;
        CustomScene r17 = new CustomScene("DY_COMMENT_LOAD", 17, 200014, "dy_comment_load");
        DY_COMMENT_LOAD = r17;
        CustomScene r18 = new CustomScene("DY_TAB_MUSIC", 18, 200015, "dy_tab_music");
        DY_TAB_MUSIC = r18;
        CustomScene r19 = new CustomScene("DY_15S_CAPTURE_START", 19, 200016, "dy_15s_capture_start");
        DY_15S_CAPTURE_START = r19;
        CustomScene r20 = new CustomScene("DY_LIVING_SCROLL", 20, 200017, "dy_living_scroll");
        DY_LIVING_SCROLL = r20;
        CustomScene r21 = new CustomScene("DY_LIVING_ENTER_GIFT_PANEL", 21, 200018, "dy_living_enter_gift_panel");
        DY_LIVING_ENTER_GIFT_PANEL = r21;
        CustomScene r22 = new CustomScene("DY_LIVING_ENTER_GOODS_LIST", 22, 200019, "dy_living_enter_goods_list");
        DY_LIVING_ENTER_GOODS_LIST = r22;
        CustomScene r23 = new CustomScene("TO_FIRST_FRAME_DRAW", 23, 300001, "to_first_frame_draw");
        TO_FIRST_FRAME_DRAW = r23;
        CustomScene r24 = new CustomScene("TO_TAB_SWITCH", 24, 300002, "to_tab_switch");
        TO_TAB_SWITCH = r24;
        CustomScene r25 = new CustomScene("TO_CLICK_NEWS", 25, 300003, "to_click_news");
        TO_CLICK_NEWS = r25;
        CustomScene r26 = new CustomScene("TO_SCROLL_NEWS", 26, 300004, "to_scroll_news");
        TO_SCROLL_NEWS = r26;
        CustomScene r27 = new CustomScene("TO_VIDEO_FIRST_FRAME", 27, 300005, "to_video_first_frame");
        TO_VIDEO_FIRST_FRAME = r27;
        CustomScene r28 = new CustomScene("TL_FIRST_FRAME_DRAW", 28, 400001, "tl_first_frame_draw");
        TL_FIRST_FRAME_DRAW = r28;
        CustomScene r29 = new CustomScene("TL_TAB_SWITCH", 29, 400002, "tl_tab_switch");
        TL_TAB_SWITCH = r29;
        CustomScene r30 = new CustomScene("TL_CLICK_NEWS", 30, 400003, "tl_click_news");
        TL_CLICK_NEWS = r30;
        CustomScene r31 = new CustomScene("TL_SCROLL_NEWS", 31, 400004, "tl_scroll_news");
        TL_SCROLL_NEWS = r31;
        CustomScene r32 = new CustomScene("DC_SCROLL_HOME", 32, 500001, "dc_scroll_home");
        DC_SCROLL_HOME = r32;
        CustomScene r33 = new CustomScene("DC_TAB_SWITCH", 33, 500002, "dc_tab_switch");
        DC_TAB_SWITCH = r33;
        CustomScene r34 = new CustomScene("DC_SCROLL_MOMENTS", 34, 500003, "dc_scroll_moments");
        DC_SCROLL_MOMENTS = r34;
        CustomScene r35 = new CustomScene("DC_VIDEO_FIRST_DRAW", 35, 500004, "dc_video_first_draw");
        DC_VIDEO_FIRST_DRAW = r35;
        CustomScene r36 = new CustomScene("TT_GO_DUET", 36, 600001, "tt_go_duet");
        TT_GO_DUET = r36;
        CustomScene r37 = new CustomScene("TT_GO_REACTION", 37, 600002, "tt_go_reaction");
        TT_GO_REACTION = r37;
        CustomScene r38 = new CustomScene("TT_TAB_LIVING_LOAD", 38, 600003, "tt_tab_living_load");
        TT_TAB_LIVING_LOAD = r38;
        CustomScene r39 = new CustomScene("TT_TAB_NEARBY_LOAD", 39, 600004, "tt_tab_nearby_load");
        TT_TAB_NEARBY_LOAD = r39;
        CustomScene r40 = new CustomScene("TT_TAB_FOLLOW_LOAD", 40, 600005, "tt_tab_follow_load");
        TT_TAB_FOLLOW_LOAD = r40;
        CustomScene r41 = new CustomScene("TT_TAB_SEARCH_LOAD", 41, 600006, "tt_tab_search_load");
        TT_TAB_SEARCH_LOAD = r41;
        CustomScene r42 = new CustomScene("TT_TAB_HOME_LOAD", 42, 600007, "tt_tab_home_load");
        TT_TAB_HOME_LOAD = r42;
        CustomScene r43 = new CustomScene("TT_TAB_FAMILIAR_LOAD", 43, 600008, "tt_tab_familiar_load");
        TT_TAB_FAMILIAR_LOAD = r43;
        CustomScene r44 = new CustomScene("TT_TAB_PUBLISH_LOAD", 44, 600009, "tt_tab_publish_load");
        TT_TAB_PUBLISH_LOAD = r44;
        CustomScene r45 = new CustomScene("TT_TAB_NOTIFICATION_LOAD", 45, 600010, "tt_tab_notification_load");
        TT_TAB_NOTIFICATION_LOAD = r45;
        CustomScene r46 = new CustomScene("TT_TAB_USER_LOAD", 46, 600011, "tt_tab_user_load");
        TT_TAB_USER_LOAD = r46;
        CustomScene r47 = new CustomScene("TT_CONCURRENT_UPLOAD_COMPILE", 47, 600012, "tt_concurrent_upload_compile");
        TT_CONCURRENT_UPLOAD_COMPILE = r47;
        CustomScene r48 = new CustomScene("TT_FEED_SCROLL", 48, 600013, "tt_feed_scroll");
        TT_FEED_SCROLL = r48;
        CustomScene r49 = new CustomScene("TT_COMMENT_LOAD", 49, 600014, "tt_comment_load");
        TT_COMMENT_LOAD = r49;
        CustomScene r50 = new CustomScene("TT_TAB_MUSIC", 50, 600015, "tt_tab_music");
        TT_TAB_MUSIC = r50;
        CustomScene r51 = new CustomScene("TT_15S_CAPTURE_START", 51, 600016, "tt_15s_capture_start");
        TT_15S_CAPTURE_START = r51;
        CustomScene r52 = new CustomScene("TT_LIVING_SCROLL", 52, 600017, "tt_living_scroll");
        TT_LIVING_SCROLL = r52;
        CustomScene r53 = new CustomScene("TT_LIVING_ENTER_GIFT_PANEL", 53, 600018, "tt_living_enter_gift_panel");
        TT_LIVING_ENTER_GIFT_PANEL = r53;
        CustomScene r54 = new CustomScene("TT_LIVING_ENTER_GOODS_LIST", 54, 600019, "tt_living_enter_goods_list");
        TT_LIVING_ENTER_GOODS_LIST = r54;
        $VALUES = new CustomScene[]{r0, r1, r2, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54};
        LAST_COMMON_SCENE_ID = r3.id;
        LAST_DY_SCENE_ID = r22.id;
        LAST_TO_SCENE_ID = r27.id;
        LAST_TL_SCENE_ID = r31.id;
        LAST_DC_SCENE_ID = r35.id;
        int r55 = r54.id;
        LAST_TT_SCENE_ID = r55;
        LAST_SCENE_ID = r55;
        MAX_CLASS = r55 / CLASS_BASE;
    }

    private CustomScene(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.id = r3;
        this.desc = r4;
    }

    private static int getSceneClass(int r1) {
        return r1 / CLASS_BASE;
    }

    private static int getSceneNum(int r1) {
        return r1 % CLASS_BASE;
    }

    private static boolean isValidClass(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > MAX_CLASS) goto L6;
        return true;
    }

    public static boolean isValidId(int r2) {
        int r0 = getSceneClass(r2);
        int r3 = getSceneNum(r2);
        if (isValidClass(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidNum(r0, r3) == false) goto L7;
        return true;
    }

    private static boolean isValidNum(int r3, int r4) {
        switch(r3) {
            case 1: goto L35;
            case 2: goto L29;
            case 3: goto L23;
            case 4: goto L17;
            case 5: goto L11;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        if (r4 > 0) goto L7;
    L9:
        return false;
    L7:
        if (r4 > (LAST_TT_SCENE_ID % CLASS_BASE)) goto L9;
        return true;
    L11:
        if (r4 > 0) goto L13;
    L15:
        return false;
    L13:
        if (r4 > (LAST_DC_SCENE_ID % CLASS_BASE)) goto L15;
        return true;
    L17:
        if (r4 > 0) goto L19;
    L21:
        return false;
    L19:
        if (r4 > (LAST_TL_SCENE_ID % CLASS_BASE)) goto L21;
        return true;
    L23:
        if (r4 > 0) goto L25;
    L27:
        return false;
    L25:
        if (r4 > (LAST_TO_SCENE_ID % CLASS_BASE)) goto L27;
        return true;
    L29:
        if (r4 > 0) goto L31;
    L33:
        return false;
    L31:
        if (r4 > (LAST_DY_SCENE_ID % CLASS_BASE)) goto L33;
        return true;
    L35:
        if (r4 > 0) goto L37;
    L39:
        return false;
    L37:
        if (r4 > (LAST_COMMON_SCENE_ID % CLASS_BASE)) goto L39;
        return true;
    }

    public static CustomScene valueOf(String r1) {
        return (CustomScene) r27.a.a(CustomScene.class, r1);
    }

    public static CustomScene[] values() {
        return (CustomScene[]) $VALUES.clone();
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.id;
    }
}
