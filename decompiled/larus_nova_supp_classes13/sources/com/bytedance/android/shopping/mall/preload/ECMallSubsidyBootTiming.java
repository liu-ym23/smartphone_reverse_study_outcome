package com.bytedance.android.shopping.mall.preload;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/preload/ECMallSubsidyBootTiming;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LINK_TYPE", "SHORT_LINK", "BOOT_TYPE", "BOOT_TIME", "TASK_START_TIME", "GET_TABKIT_URL_START", "GET_TABKIT_URL_END", "PRELOAD_GECKO_START", "PRELOAD_GECKO_END", "PREFETCH_API_START", "PREFETCH_API_END", "TASK_END_TIME", "PRELOAD_SHORT_GECKO_START", "PRELOAD_SHORT_GECKO_END", "REQUEST_FROM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallSubsidyBootTiming extends Enum<ECMallSubsidyBootTiming> {
    private static final /* synthetic */ ECMallSubsidyBootTiming[] $VALUES = null;
    public static final ECMallSubsidyBootTiming BOOT_TIME = null;
    public static final ECMallSubsidyBootTiming BOOT_TYPE = null;
    public static final ECMallSubsidyBootTiming GET_TABKIT_URL_END = null;
    public static final ECMallSubsidyBootTiming GET_TABKIT_URL_START = null;
    public static final ECMallSubsidyBootTiming LINK_TYPE = null;
    public static final ECMallSubsidyBootTiming PREFETCH_API_END = null;
    public static final ECMallSubsidyBootTiming PREFETCH_API_START = null;
    public static final ECMallSubsidyBootTiming PRELOAD_GECKO_END = null;
    public static final ECMallSubsidyBootTiming PRELOAD_GECKO_START = null;
    public static final ECMallSubsidyBootTiming PRELOAD_SHORT_GECKO_END = null;
    public static final ECMallSubsidyBootTiming PRELOAD_SHORT_GECKO_START = null;
    public static final ECMallSubsidyBootTiming REQUEST_FROM = null;
    public static final ECMallSubsidyBootTiming SHORT_LINK = null;
    public static final ECMallSubsidyBootTiming TASK_END_TIME = null;
    public static final ECMallSubsidyBootTiming TASK_START_TIME = null;
    private final String value;

    public static ECMallSubsidyBootTiming valueOf(String r1) {
        return (ECMallSubsidyBootTiming) r27.a.a(ECMallSubsidyBootTiming.class, r1);
    }

    public static ECMallSubsidyBootTiming[] values() {
        return (ECMallSubsidyBootTiming[]) $VALUES.clone();
    }

    static {
        ECMallSubsidyBootTiming r1 = new ECMallSubsidyBootTiming("LINK_TYPE", 0, "link_type");
        LINK_TYPE = r1;
        ECMallSubsidyBootTiming r2 = new ECMallSubsidyBootTiming("SHORT_LINK", 1, "ec_mall_cf_short_link");
        SHORT_LINK = r2;
        ECMallSubsidyBootTiming r3 = new ECMallSubsidyBootTiming("BOOT_TYPE", 2, "boot_type");
        BOOT_TYPE = r3;
        ECMallSubsidyBootTiming r4 = new ECMallSubsidyBootTiming("BOOT_TIME", 3, "boot_time");
        BOOT_TIME = r4;
        ECMallSubsidyBootTiming r5 = new ECMallSubsidyBootTiming("TASK_START_TIME", 4, "task_start_time");
        TASK_START_TIME = r5;
        ECMallSubsidyBootTiming r6 = new ECMallSubsidyBootTiming("GET_TABKIT_URL_START", 5, "get_tabkit_url_start");
        GET_TABKIT_URL_START = r6;
        ECMallSubsidyBootTiming r7 = new ECMallSubsidyBootTiming("GET_TABKIT_URL_END", 6, "get_tabkit_url_end");
        GET_TABKIT_URL_END = r7;
        ECMallSubsidyBootTiming r8 = new ECMallSubsidyBootTiming("PRELOAD_GECKO_START", 7, "preload_gecko_start");
        PRELOAD_GECKO_START = r8;
        ECMallSubsidyBootTiming r9 = new ECMallSubsidyBootTiming("PRELOAD_GECKO_END", 8, "preload_gecko_end");
        PRELOAD_GECKO_END = r9;
        ECMallSubsidyBootTiming r10 = new ECMallSubsidyBootTiming("PREFETCH_API_START", 9, "prefetch_api_start");
        PREFETCH_API_START = r10;
        ECMallSubsidyBootTiming r11 = new ECMallSubsidyBootTiming("PREFETCH_API_END", 10, "prefetch_api_end");
        PREFETCH_API_END = r11;
        ECMallSubsidyBootTiming r12 = new ECMallSubsidyBootTiming("TASK_END_TIME", 11, "task_end_time");
        TASK_END_TIME = r12;
        ECMallSubsidyBootTiming r13 = new ECMallSubsidyBootTiming("PRELOAD_SHORT_GECKO_START", 12, "preload_short_gecko_start");
        PRELOAD_SHORT_GECKO_START = r13;
        ECMallSubsidyBootTiming r14 = new ECMallSubsidyBootTiming("PRELOAD_SHORT_GECKO_END", 13, "preload_short_gecko_end");
        PRELOAD_SHORT_GECKO_END = r14;
        ECMallSubsidyBootTiming r15 = new ECMallSubsidyBootTiming("REQUEST_FROM", 14, "request_from");
        REQUEST_FROM = r15;
        $VALUES = new ECMallSubsidyBootTiming[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15};
    }

    public final String getValue() {
        return this.value;
    }

    private ECMallSubsidyBootTiming(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
