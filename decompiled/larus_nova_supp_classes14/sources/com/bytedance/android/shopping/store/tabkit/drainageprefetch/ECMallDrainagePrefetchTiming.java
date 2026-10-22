package com.bytedance.android.shopping.store.tabkit.drainageprefetch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/drainageprefetch/ECMallDrainagePrefetchTiming;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NA_PREFETCH_STRATEGY", "REQUEST_FROM", "PREFETCH_REQUEST_STATE", "TASK_START_TIME", "REDIRECT_URL_START", "REDIRECT_URL_END", "PRELOAD_GECKO_START", "PRELOAD_GECKO_END", "PREFETCH_API_START", "PREFETCH_API_END", "TASK_END_TIME", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallDrainagePrefetchTiming extends Enum<ECMallDrainagePrefetchTiming> {
    private static final /* synthetic */ ECMallDrainagePrefetchTiming[] $VALUES = null;
    public static final ECMallDrainagePrefetchTiming NA_PREFETCH_STRATEGY = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_API_END = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_API_START = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_REQUEST_STATE = null;
    public static final ECMallDrainagePrefetchTiming PRELOAD_GECKO_END = null;
    public static final ECMallDrainagePrefetchTiming PRELOAD_GECKO_START = null;
    public static final ECMallDrainagePrefetchTiming REDIRECT_URL_END = null;
    public static final ECMallDrainagePrefetchTiming REDIRECT_URL_START = null;
    public static final ECMallDrainagePrefetchTiming REQUEST_FROM = null;
    public static final ECMallDrainagePrefetchTiming TASK_END_TIME = null;
    public static final ECMallDrainagePrefetchTiming TASK_START_TIME = null;
    private final String value;

    public static ECMallDrainagePrefetchTiming valueOf(String r1) {
        return (ECMallDrainagePrefetchTiming) r27.a.a(ECMallDrainagePrefetchTiming.class, r1);
    }

    public static ECMallDrainagePrefetchTiming[] values() {
        return (ECMallDrainagePrefetchTiming[]) $VALUES.clone();
    }

    static {
        ECMallDrainagePrefetchTiming r1 = new ECMallDrainagePrefetchTiming("NA_PREFETCH_STRATEGY", 0, "na_prefetch_strategy");
        NA_PREFETCH_STRATEGY = r1;
        ECMallDrainagePrefetchTiming r2 = new ECMallDrainagePrefetchTiming("REQUEST_FROM", 1, "request_from");
        REQUEST_FROM = r2;
        ECMallDrainagePrefetchTiming r3 = new ECMallDrainagePrefetchTiming("PREFETCH_REQUEST_STATE", 2, "prefetch_request_state");
        PREFETCH_REQUEST_STATE = r3;
        ECMallDrainagePrefetchTiming r4 = new ECMallDrainagePrefetchTiming("TASK_START_TIME", 3, "task_start_time");
        TASK_START_TIME = r4;
        ECMallDrainagePrefetchTiming r5 = new ECMallDrainagePrefetchTiming("REDIRECT_URL_START", 4, "redirect_url_start");
        REDIRECT_URL_START = r5;
        ECMallDrainagePrefetchTiming r6 = new ECMallDrainagePrefetchTiming("REDIRECT_URL_END", 5, "redirect_url_end");
        REDIRECT_URL_END = r6;
        ECMallDrainagePrefetchTiming r7 = new ECMallDrainagePrefetchTiming("PRELOAD_GECKO_START", 6, "preload_gecko_start");
        PRELOAD_GECKO_START = r7;
        ECMallDrainagePrefetchTiming r8 = new ECMallDrainagePrefetchTiming("PRELOAD_GECKO_END", 7, "preload_gecko_end");
        PRELOAD_GECKO_END = r8;
        ECMallDrainagePrefetchTiming r9 = new ECMallDrainagePrefetchTiming("PREFETCH_API_START", 8, "prefetch_api_start");
        PREFETCH_API_START = r9;
        ECMallDrainagePrefetchTiming r10 = new ECMallDrainagePrefetchTiming("PREFETCH_API_END", 9, "prefetch_api_end");
        PREFETCH_API_END = r10;
        ECMallDrainagePrefetchTiming r11 = new ECMallDrainagePrefetchTiming("TASK_END_TIME", 10, "task_end_time");
        TASK_END_TIME = r11;
        $VALUES = new ECMallDrainagePrefetchTiming[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getValue() {
        return this.value;
    }

    private ECMallDrainagePrefetchTiming(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
