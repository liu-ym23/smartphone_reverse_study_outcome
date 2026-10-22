package com.ss.android.ugc.aweme.search.filter.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/model/ECSearchRequestTrigger;", "", "PULL_REFRESH", "CLICK_CORRECT_WORD", "CLICK_GUIDE_SEARCH_WORD", "AFTER_LOCATE_REFETCH", "STATUS_VIEW_RETRY", "POI_ADDRESS_CHANGE", "LOGIN_STATUS_CHANGE", "LOGIN_SUCCESS", "EXP_FILTER_CHANGE", "SET_SEARCH_KEYWORD", "SET_USER_VISIBLE_HINT", "FRAGMENT_ONCREATE", "LOAD_MORE", "INNER_REFRESH", "INNER_LOAD_MORE", "PREFETCH", "PREDICT_DOWNGRADE_RETRY", "GENERAL_REQUEST_LOCATION_REFETCH", "POI_REQUEST_LOCATION_REFETCH", "AI_REFRESH", "RIGHT_AI_REFRESH", "AI_RECOMMEND", "AI_ENTITY", "AI_ENTITY_V2", "MIX_POP_REQUEST_LOCATION_REFETCH", "POI_DATE_EDIT_BOARD_RESUME", "FILTER_BOARD_SEARCH", "FILTER_BOARD_SEARCH_WITH_CUSTOMIZE_SORT_PARAM", "VISUAL_INTERMEDIATE_RELOAD", "SWITCH_COLUMN_TYPE", "EXPAND_LOAD_MORE", "RAW_REQUEST", "AI_SEARCH_ORIGINAL", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECSearchRequestTrigger extends Enum<ECSearchRequestTrigger> {
    public static final ECSearchRequestTrigger AFTER_LOCATE_REFETCH = null;
    public static final ECSearchRequestTrigger AI_ENTITY = null;
    public static final ECSearchRequestTrigger AI_ENTITY_V2 = null;
    public static final ECSearchRequestTrigger AI_RECOMMEND = null;
    public static final ECSearchRequestTrigger AI_REFRESH = null;
    public static final ECSearchRequestTrigger AI_SEARCH_ORIGINAL = null;
    public static final ECSearchRequestTrigger CLICK_CORRECT_WORD = null;
    public static final ECSearchRequestTrigger CLICK_GUIDE_SEARCH_WORD = null;
    public static final ECSearchRequestTrigger EXPAND_LOAD_MORE = null;
    public static final ECSearchRequestTrigger EXP_FILTER_CHANGE = null;
    public static final ECSearchRequestTrigger FILTER_BOARD_SEARCH = null;
    public static final ECSearchRequestTrigger FILTER_BOARD_SEARCH_WITH_CUSTOMIZE_SORT_PARAM = null;
    public static final ECSearchRequestTrigger FRAGMENT_ONCREATE = null;
    public static final ECSearchRequestTrigger GENERAL_REQUEST_LOCATION_REFETCH = null;
    public static final ECSearchRequestTrigger INNER_LOAD_MORE = null;
    public static final ECSearchRequestTrigger INNER_REFRESH = null;
    public static final ECSearchRequestTrigger LOAD_MORE = null;
    public static final ECSearchRequestTrigger LOGIN_STATUS_CHANGE = null;
    public static final ECSearchRequestTrigger LOGIN_SUCCESS = null;
    public static final ECSearchRequestTrigger MIX_POP_REQUEST_LOCATION_REFETCH = null;
    public static final ECSearchRequestTrigger POI_ADDRESS_CHANGE = null;
    public static final ECSearchRequestTrigger POI_DATE_EDIT_BOARD_RESUME = null;
    public static final ECSearchRequestTrigger POI_REQUEST_LOCATION_REFETCH = null;
    public static final ECSearchRequestTrigger PREDICT_DOWNGRADE_RETRY = null;
    public static final ECSearchRequestTrigger PREFETCH = null;
    public static final ECSearchRequestTrigger PULL_REFRESH = null;
    public static final ECSearchRequestTrigger RAW_REQUEST = null;
    public static final ECSearchRequestTrigger RIGHT_AI_REFRESH = null;
    public static final ECSearchRequestTrigger SET_SEARCH_KEYWORD = null;
    public static final ECSearchRequestTrigger SET_USER_VISIBLE_HINT = null;
    public static final ECSearchRequestTrigger STATUS_VIEW_RETRY = null;
    public static final ECSearchRequestTrigger SWITCH_COLUMN_TYPE = null;
    public static final ECSearchRequestTrigger VISUAL_INTERMEDIATE_RELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECSearchRequestTrigger[] f452963a = null;

    static {
        ECSearchRequestTrigger r100 = new ECSearchRequestTrigger("PULL_REFRESH", 0);
        PULL_REFRESH = r100;
        ECSearchRequestTrigger r101 = new ECSearchRequestTrigger("CLICK_CORRECT_WORD", 1);
        CLICK_CORRECT_WORD = r101;
        ECSearchRequestTrigger r102 = new ECSearchRequestTrigger("CLICK_GUIDE_SEARCH_WORD", 2);
        CLICK_GUIDE_SEARCH_WORD = r102;
        ECSearchRequestTrigger r103 = new ECSearchRequestTrigger("AFTER_LOCATE_REFETCH", 3);
        AFTER_LOCATE_REFETCH = r103;
        ECSearchRequestTrigger r104 = new ECSearchRequestTrigger("STATUS_VIEW_RETRY", 4);
        STATUS_VIEW_RETRY = r104;
        ECSearchRequestTrigger r105 = new ECSearchRequestTrigger("POI_ADDRESS_CHANGE", 5);
        POI_ADDRESS_CHANGE = r105;
        ECSearchRequestTrigger r106 = new ECSearchRequestTrigger("LOGIN_STATUS_CHANGE", 6);
        LOGIN_STATUS_CHANGE = r106;
        ECSearchRequestTrigger r107 = new ECSearchRequestTrigger("LOGIN_SUCCESS", 7);
        LOGIN_SUCCESS = r107;
        ECSearchRequestTrigger r108 = new ECSearchRequestTrigger("EXP_FILTER_CHANGE", 8);
        EXP_FILTER_CHANGE = r108;
        ECSearchRequestTrigger r109 = new ECSearchRequestTrigger("SET_SEARCH_KEYWORD", 9);
        SET_SEARCH_KEYWORD = r109;
        ECSearchRequestTrigger r110 = new ECSearchRequestTrigger("SET_USER_VISIBLE_HINT", 10);
        SET_USER_VISIBLE_HINT = r110;
        ECSearchRequestTrigger r111 = new ECSearchRequestTrigger("FRAGMENT_ONCREATE", 11);
        FRAGMENT_ONCREATE = r111;
        ECSearchRequestTrigger r112 = new ECSearchRequestTrigger("LOAD_MORE", 12);
        LOAD_MORE = r112;
        ECSearchRequestTrigger r113 = new ECSearchRequestTrigger("INNER_REFRESH", 13);
        INNER_REFRESH = r113;
        ECSearchRequestTrigger r114 = new ECSearchRequestTrigger("INNER_LOAD_MORE", 14);
        INNER_LOAD_MORE = r114;
        ECSearchRequestTrigger r115 = new ECSearchRequestTrigger("PREFETCH", 15);
        PREFETCH = r115;
        ECSearchRequestTrigger r116 = new ECSearchRequestTrigger("PREDICT_DOWNGRADE_RETRY", 16);
        PREDICT_DOWNGRADE_RETRY = r116;
        ECSearchRequestTrigger r117 = new ECSearchRequestTrigger("GENERAL_REQUEST_LOCATION_REFETCH", 17);
        GENERAL_REQUEST_LOCATION_REFETCH = r117;
        ECSearchRequestTrigger r118 = new ECSearchRequestTrigger("POI_REQUEST_LOCATION_REFETCH", 18);
        POI_REQUEST_LOCATION_REFETCH = r118;
        ECSearchRequestTrigger r119 = new ECSearchRequestTrigger("AI_REFRESH", 19);
        AI_REFRESH = r119;
        ECSearchRequestTrigger r120 = new ECSearchRequestTrigger("RIGHT_AI_REFRESH", 20);
        RIGHT_AI_REFRESH = r120;
        ECSearchRequestTrigger r121 = new ECSearchRequestTrigger("AI_RECOMMEND", 21);
        AI_RECOMMEND = r121;
        ECSearchRequestTrigger r122 = new ECSearchRequestTrigger("AI_ENTITY", 22);
        AI_ENTITY = r122;
        ECSearchRequestTrigger r123 = new ECSearchRequestTrigger("AI_ENTITY_V2", 23);
        AI_ENTITY_V2 = r123;
        ECSearchRequestTrigger r124 = new ECSearchRequestTrigger("MIX_POP_REQUEST_LOCATION_REFETCH", 24);
        MIX_POP_REQUEST_LOCATION_REFETCH = r124;
        ECSearchRequestTrigger r125 = new ECSearchRequestTrigger("POI_DATE_EDIT_BOARD_RESUME", 25);
        POI_DATE_EDIT_BOARD_RESUME = r125;
        ECSearchRequestTrigger r126 = new ECSearchRequestTrigger("FILTER_BOARD_SEARCH", 26);
        FILTER_BOARD_SEARCH = r126;
        ECSearchRequestTrigger r127 = new ECSearchRequestTrigger("FILTER_BOARD_SEARCH_WITH_CUSTOMIZE_SORT_PARAM", 27);
        FILTER_BOARD_SEARCH_WITH_CUSTOMIZE_SORT_PARAM = r127;
        ECSearchRequestTrigger r128 = new ECSearchRequestTrigger("VISUAL_INTERMEDIATE_RELOAD", 28);
        VISUAL_INTERMEDIATE_RELOAD = r128;
        ECSearchRequestTrigger r129 = new ECSearchRequestTrigger("SWITCH_COLUMN_TYPE", 29);
        SWITCH_COLUMN_TYPE = r129;
        ECSearchRequestTrigger r130 = new ECSearchRequestTrigger("EXPAND_LOAD_MORE", 30);
        EXPAND_LOAD_MORE = r130;
        ECSearchRequestTrigger r131 = new ECSearchRequestTrigger("RAW_REQUEST", 31);
        RAW_REQUEST = r131;
        ECSearchRequestTrigger r132 = new ECSearchRequestTrigger("AI_SEARCH_ORIGINAL", 32);
        AI_SEARCH_ORIGINAL = r132;
        f452963a = new ECSearchRequestTrigger[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132};
    }

    public static ECSearchRequestTrigger valueOf(String r100) {
        return (ECSearchRequestTrigger) a.a(ECSearchRequestTrigger.class, r100);
    }

    public static ECSearchRequestTrigger[] values() {
        return (ECSearchRequestTrigger[]) f452963a.clone();
    }

    public ECSearchRequestTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
