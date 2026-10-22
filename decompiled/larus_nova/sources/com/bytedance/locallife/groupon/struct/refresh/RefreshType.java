package com.bytedance.locallife.groupon.struct.refresh;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/RefreshType;", "", "", "isJsbRefreshFeed", "scroll2Top", "dependLifecycle", "hideGuideUp", "hideBackFloat", "setLiveWindowConsumed", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "pageType", "notRefreshCheck", ErrorCode.INIT, "INIT_SEARCH", "PULL_DOWN", "REFRESH_FULL_AND_DUAL", "LOAD_MORE", "RETRY", "CLICK_BOTTOM_NAV", "UNDERTAKE_AUTO_REFRESH", "COLLECT", "POI_ARRIVE", "CLICK_POI_BUBBLE", "SCROLL_X_ITEM", "CLICK_ITEM", "ENTER_NEARBY", "ORDER_MSG", "COUPON_GET_SUCCESS", "CROSS_ENTRANCE_REFRESH_FULLY", "CROSS_ENTRANCE_REFRESH_PARTLY", "CLICK_FEED_TAB", "TRIGGER_RESOURCE", "TRIGGER_SEARCH_V1", "FEED_CACHE_AFTER", "JSB_TRIGGER_FEED", "JSB_TRIGGER_RESOURCE", "JSB_TRIGGER_SETTING", "JSB_TRIGGER_FEED_RESOURCE", "JSB_TRIGGER_FEED_SETTING", "JSB_TRIGGER_RESOURCE_SETTING", "JSB_TRIGGER_FEED_RESOURCE_SETTING", "DIAMOND_UPDATE", "PERSONAL_RECOMMEND_CHANGE", "GROUPON_PASSIVE_REFRESH_FULLY_1", "GROUPON_PASSIVE_REFRESH_FULLY_2", "GROUPON_PASSIVE_REFRESH_PARTLY", "GROUPON_PASSIVE_REFRESH_PARTLY_2", "GROUPON_MOTIVATIONAL_TASK_REFRESH", "PREFETCH_TAB_FEED", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum RefreshType extends Enum<RefreshType> {
    public static final RefreshType CLICK_BOTTOM_NAV = null;
    public static final RefreshType CLICK_FEED_TAB = null;
    public static final RefreshType CLICK_ITEM = null;
    public static final RefreshType CLICK_POI_BUBBLE = null;
    public static final RefreshType COLLECT = null;
    public static final RefreshType COUPON_GET_SUCCESS = null;
    public static final RefreshType CROSS_ENTRANCE_REFRESH_FULLY = null;
    public static final RefreshType CROSS_ENTRANCE_REFRESH_PARTLY = null;
    public static final RefreshType DIAMOND_UPDATE = null;
    public static final RefreshType ENTER_NEARBY = null;
    public static final RefreshType FEED_CACHE_AFTER = null;
    public static final RefreshType GROUPON_MOTIVATIONAL_TASK_REFRESH = null;
    public static final RefreshType GROUPON_PASSIVE_REFRESH_FULLY_1 = null;
    public static final RefreshType GROUPON_PASSIVE_REFRESH_FULLY_2 = null;
    public static final RefreshType GROUPON_PASSIVE_REFRESH_PARTLY = null;
    public static final RefreshType GROUPON_PASSIVE_REFRESH_PARTLY_2 = null;
    public static final RefreshType INIT = null;
    public static final RefreshType INIT_SEARCH = null;
    public static final RefreshType JSB_TRIGGER_FEED = null;
    public static final RefreshType JSB_TRIGGER_FEED_RESOURCE = null;
    public static final RefreshType JSB_TRIGGER_FEED_RESOURCE_SETTING = null;
    public static final RefreshType JSB_TRIGGER_FEED_SETTING = null;
    public static final RefreshType JSB_TRIGGER_RESOURCE = null;
    public static final RefreshType JSB_TRIGGER_RESOURCE_SETTING = null;
    public static final RefreshType JSB_TRIGGER_SETTING = null;
    public static final RefreshType LOAD_MORE = null;
    public static final RefreshType ORDER_MSG = null;
    public static final RefreshType PERSONAL_RECOMMEND_CHANGE = null;
    public static final RefreshType POI_ARRIVE = null;
    public static final RefreshType PREFETCH_TAB_FEED = null;
    public static final RefreshType PULL_DOWN = null;
    public static final RefreshType REFRESH_FULL_AND_DUAL = null;
    public static final RefreshType RETRY = null;
    public static final RefreshType SCROLL_X_ITEM = null;
    public static final RefreshType TRIGGER_RESOURCE = null;
    public static final RefreshType TRIGGER_SEARCH_V1 = null;
    public static final RefreshType UNDERTAKE_AUTO_REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshType[] f258850a = null;

    public static RefreshType valueOf(String r100) {
        return (RefreshType) a.a(RefreshType.class, r100);
    }

    public static RefreshType[] values() {
        return (RefreshType[]) f258850a.clone();
    }

    static {
        RefreshType r100 = new RefreshType(ErrorCode.INIT, 0);
        INIT = r100;
        RefreshType r101 = new RefreshType("INIT_SEARCH", 1);
        INIT_SEARCH = r101;
        RefreshType r102 = new RefreshType("PULL_DOWN", 2);
        PULL_DOWN = r102;
        RefreshType r103 = new RefreshType("REFRESH_FULL_AND_DUAL", 3);
        REFRESH_FULL_AND_DUAL = r103;
        RefreshType r104 = new RefreshType("LOAD_MORE", 4);
        LOAD_MORE = r104;
        RefreshType r105 = new RefreshType("RETRY", 5);
        RETRY = r105;
        RefreshType r110 = new RefreshType("CLICK_BOTTOM_NAV", 6);
        CLICK_BOTTOM_NAV = r110;
        RefreshType r111 = new RefreshType("UNDERTAKE_AUTO_REFRESH", 7);
        UNDERTAKE_AUTO_REFRESH = r111;
        RefreshType r112 = new RefreshType("COLLECT", 8);
        COLLECT = r112;
        RefreshType r113 = new RefreshType("POI_ARRIVE", 9);
        POI_ARRIVE = r113;
        RefreshType r114 = new RefreshType("CLICK_POI_BUBBLE", 10);
        CLICK_POI_BUBBLE = r114;
        RefreshType r115 = new RefreshType("SCROLL_X_ITEM", 11);
        SCROLL_X_ITEM = r115;
        RefreshType r106 = new RefreshType("CLICK_ITEM", 12);
        CLICK_ITEM = r106;
        RefreshType r107 = new RefreshType("ENTER_NEARBY", 13);
        ENTER_NEARBY = r107;
        RefreshType r108 = new RefreshType("ORDER_MSG", 14);
        ORDER_MSG = r108;
        RefreshType r109 = new RefreshType("COUPON_GET_SUCCESS", 15);
        COUPON_GET_SUCCESS = r109;
        RefreshType r116 = new RefreshType("CROSS_ENTRANCE_REFRESH_FULLY", 16);
        CROSS_ENTRANCE_REFRESH_FULLY = r116;
        RefreshType r117 = new RefreshType("CROSS_ENTRANCE_REFRESH_PARTLY", 17);
        CROSS_ENTRANCE_REFRESH_PARTLY = r117;
        RefreshType r118 = new RefreshType("CLICK_FEED_TAB", 18);
        CLICK_FEED_TAB = r118;
        RefreshType r119 = new RefreshType("TRIGGER_RESOURCE", 19);
        TRIGGER_RESOURCE = r119;
        RefreshType r120 = new RefreshType("TRIGGER_SEARCH_V1", 20);
        TRIGGER_SEARCH_V1 = r120;
        RefreshType r121 = new RefreshType("FEED_CACHE_AFTER", 21);
        FEED_CACHE_AFTER = r121;
        RefreshType r122 = new RefreshType("JSB_TRIGGER_FEED", 22);
        JSB_TRIGGER_FEED = r122;
        RefreshType r123 = new RefreshType("JSB_TRIGGER_RESOURCE", 23);
        JSB_TRIGGER_RESOURCE = r123;
        RefreshType r124 = new RefreshType("JSB_TRIGGER_SETTING", 24);
        JSB_TRIGGER_SETTING = r124;
        RefreshType r125 = new RefreshType("JSB_TRIGGER_FEED_RESOURCE", 25);
        JSB_TRIGGER_FEED_RESOURCE = r125;
        RefreshType r126 = new RefreshType("JSB_TRIGGER_FEED_SETTING", 26);
        JSB_TRIGGER_FEED_SETTING = r126;
        RefreshType r127 = new RefreshType("JSB_TRIGGER_RESOURCE_SETTING", 27);
        JSB_TRIGGER_RESOURCE_SETTING = r127;
        RefreshType r128 = new RefreshType("JSB_TRIGGER_FEED_RESOURCE_SETTING", 28);
        JSB_TRIGGER_FEED_RESOURCE_SETTING = r128;
        RefreshType r129 = new RefreshType("DIAMOND_UPDATE", 29);
        DIAMOND_UPDATE = r129;
        RefreshType r130 = new RefreshType("PERSONAL_RECOMMEND_CHANGE", 30);
        PERSONAL_RECOMMEND_CHANGE = r130;
        RefreshType r131 = new RefreshType("GROUPON_PASSIVE_REFRESH_FULLY_1", 31);
        GROUPON_PASSIVE_REFRESH_FULLY_1 = r131;
        RefreshType r132 = new RefreshType("GROUPON_PASSIVE_REFRESH_FULLY_2", 32);
        GROUPON_PASSIVE_REFRESH_FULLY_2 = r132;
        RefreshType r133 = new RefreshType("GROUPON_PASSIVE_REFRESH_PARTLY", 33);
        GROUPON_PASSIVE_REFRESH_PARTLY = r133;
        RefreshType r134 = new RefreshType("GROUPON_PASSIVE_REFRESH_PARTLY_2", 34);
        GROUPON_PASSIVE_REFRESH_PARTLY_2 = r134;
        RefreshType r135 = new RefreshType("GROUPON_MOTIVATIONAL_TASK_REFRESH", 35);
        GROUPON_MOTIVATIONAL_TASK_REFRESH = r135;
        RefreshType r136 = new RefreshType("PREFETCH_TAB_FEED", 36);
        PREFETCH_TAB_FEED = r136;
        f258850a = new RefreshType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136};
    }

    public final boolean dependLifecycle() {
        if (this != REFRESH_FULL_AND_DUAL) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hideBackFloat() {
        boolean r100 = cs6.a.f465186a;
        if (cs6.a.f465186a == true) goto L5;
    L15:
        return false;
    L5:
        if (this != REFRESH_FULL_AND_DUAL) goto L7;
    L14:
        return true;
    L7:
        if (this == PULL_DOWN) goto L14;
        if (this == CLICK_BOTTOM_NAV) goto L14;
        if (this == UNDERTAKE_AUTO_REFRESH) goto L14;
        if (this != CROSS_ENTRANCE_REFRESH_FULLY) goto L15;
        goto L14
    }

    public final boolean hideGuideUp() {
        if (this != CLICK_BOTTOM_NAV) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isJsbRefreshFeed() {
        if (this != JSB_TRIGGER_FEED) goto L5;
    L12:
        return true;
    L5:
        if (this == JSB_TRIGGER_FEED_RESOURCE) goto L12;
        if (this == JSB_TRIGGER_FEED_SETTING) goto L12;
        if (this == JSB_TRIGGER_FEED_RESOURCE_SETTING) goto L12;
        return false;
    }

    public final boolean scroll2Top() {
        if (this != PULL_DOWN) goto L5;
    L16:
        return true;
    L5:
        if (this == REFRESH_FULL_AND_DUAL) goto L16;
        if (this == RETRY) goto L16;
        if (this == CLICK_BOTTOM_NAV) goto L16;
        if (this == UNDERTAKE_AUTO_REFRESH) goto L16;
        if (this == GROUPON_PASSIVE_REFRESH_FULLY_1) goto L16;
        return false;
    }

    public final boolean setLiveWindowConsumed() {
        if (this != PULL_DOWN) goto L5;
    L8:
        return true;
    L5:
        if (this == CLICK_BOTTOM_NAV) goto L8;
        return false;
    }

    public final boolean notRefreshCheck(NearbyPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        if (this != CLICK_FEED_TAB) goto L5;
    L22:
        return true;
    L5:
        if (this == PULL_DOWN) goto L22;
        if (this == CLICK_BOTTOM_NAV) goto L22;
        if (this == LOAD_MORE) goto L22;
        if (this == FEED_CACHE_AFTER) goto L22;
        if (this == GROUPON_MOTIVATIONAL_TASK_REFRESH) goto L22;
        if (this == GROUPON_PASSIVE_REFRESH_PARTLY) goto L22;
        if (this == GROUPON_PASSIVE_REFRESH_PARTLY_2) goto L22;
        if (this == PREFETCH_TAB_FEED) goto L22;
        return false;
    }

    public RefreshType(String r100, int r101) {
        super(r100, r101);
    }
}
