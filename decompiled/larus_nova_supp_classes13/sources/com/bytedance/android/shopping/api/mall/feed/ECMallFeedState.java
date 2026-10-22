package com.bytedance.android.shopping.api.mall.feed;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedState;", "", "PREPARING", "PREPARE_SUCCESS", "PREPARE_FAILED", "INITIALIZING", "INIT_WITH_CACHE_SUCCESS", "INIT_DATA_PREPARED", "FIRST_SCREEN_LYNX_END", "INIT_SUCCESS", "INIT_FAILED", "REFRESHING", "REFRESH_DATA_PREPARED", "REFRESH_SUCCESS", "REFRESH_FAILED", "LOADING_MORE", "LOAD_MORE_SUCCESS", "LOAD_MORE_FAILED", "NO_MORE", "LOAD_BY_USER_BEHAVIOR", "LOAD_BY_USER_BEHAVIOR_SUCCESS", "LOAD_BY_USER_BEHAVIOR_FAILED", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallFeedState extends Enum<ECMallFeedState> {
    public static final ECMallFeedState FIRST_SCREEN_LYNX_END = null;
    public static final ECMallFeedState INITIALIZING = null;
    public static final ECMallFeedState INIT_DATA_PREPARED = null;
    public static final ECMallFeedState INIT_FAILED = null;
    public static final ECMallFeedState INIT_SUCCESS = null;
    public static final ECMallFeedState INIT_WITH_CACHE_SUCCESS = null;
    public static final ECMallFeedState LOADING_MORE = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR_FAILED = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR_SUCCESS = null;
    public static final ECMallFeedState LOAD_MORE_FAILED = null;
    public static final ECMallFeedState LOAD_MORE_SUCCESS = null;
    public static final ECMallFeedState NO_MORE = null;
    public static final ECMallFeedState PREPARE_FAILED = null;
    public static final ECMallFeedState PREPARE_SUCCESS = null;
    public static final ECMallFeedState PREPARING = null;
    public static final ECMallFeedState REFRESHING = null;
    public static final ECMallFeedState REFRESH_DATA_PREPARED = null;
    public static final ECMallFeedState REFRESH_FAILED = null;
    public static final ECMallFeedState REFRESH_SUCCESS = null;
    public static final /* synthetic */ ECMallFeedState[] a = null;

    static {
        ECMallFeedState r1 = new ECMallFeedState("PREPARING", 0);
        PREPARING = r1;
        ECMallFeedState r2 = new ECMallFeedState("PREPARE_SUCCESS", 1);
        PREPARE_SUCCESS = r2;
        ECMallFeedState r3 = new ECMallFeedState("PREPARE_FAILED", 2);
        PREPARE_FAILED = r3;
        ECMallFeedState r4 = new ECMallFeedState("INITIALIZING", 3);
        INITIALIZING = r4;
        ECMallFeedState r5 = new ECMallFeedState("INIT_WITH_CACHE_SUCCESS", 4);
        INIT_WITH_CACHE_SUCCESS = r5;
        ECMallFeedState r6 = new ECMallFeedState("INIT_DATA_PREPARED", 5);
        INIT_DATA_PREPARED = r6;
        ECMallFeedState r7 = new ECMallFeedState("FIRST_SCREEN_LYNX_END", 6);
        FIRST_SCREEN_LYNX_END = r7;
        ECMallFeedState r8 = new ECMallFeedState("INIT_SUCCESS", 7);
        INIT_SUCCESS = r8;
        ECMallFeedState r9 = new ECMallFeedState("INIT_FAILED", 8);
        INIT_FAILED = r9;
        ECMallFeedState r10 = new ECMallFeedState("REFRESHING", 9);
        REFRESHING = r10;
        ECMallFeedState r11 = new ECMallFeedState("REFRESH_DATA_PREPARED", 10);
        REFRESH_DATA_PREPARED = r11;
        ECMallFeedState r12 = new ECMallFeedState("REFRESH_SUCCESS", 11);
        REFRESH_SUCCESS = r12;
        ECMallFeedState r13 = new ECMallFeedState("REFRESH_FAILED", 12);
        REFRESH_FAILED = r13;
        ECMallFeedState r14 = new ECMallFeedState("LOADING_MORE", 13);
        LOADING_MORE = r14;
        ECMallFeedState r15 = new ECMallFeedState("LOAD_MORE_SUCCESS", 14);
        LOAD_MORE_SUCCESS = r15;
        ECMallFeedState r16 = new ECMallFeedState("LOAD_MORE_FAILED", 15);
        LOAD_MORE_FAILED = r16;
        ECMallFeedState r17 = new ECMallFeedState("NO_MORE", 16);
        NO_MORE = r17;
        ECMallFeedState r18 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR", 17);
        LOAD_BY_USER_BEHAVIOR = r18;
        ECMallFeedState r19 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR_SUCCESS", 18);
        LOAD_BY_USER_BEHAVIOR_SUCCESS = r19;
        ECMallFeedState r20 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR_FAILED", 19);
        LOAD_BY_USER_BEHAVIOR_FAILED = r20;
        a = new ECMallFeedState[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20};
    }

    public static ECMallFeedState valueOf(String r1) {
        return (ECMallFeedState) r27.a.a(ECMallFeedState.class, r1);
    }

    public static ECMallFeedState[] values() {
        return (ECMallFeedState[]) a.clone();
    }

    public ECMallFeedState(String r1, int r2) {
        super(r1, r2);
    }
}
