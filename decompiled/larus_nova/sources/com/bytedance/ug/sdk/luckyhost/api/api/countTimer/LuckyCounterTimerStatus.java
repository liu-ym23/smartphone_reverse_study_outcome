package com.bytedance.ug.sdk.luckyhost.api.api.countTimer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ug/sdk/luckyhost/api/api/countTimer/LuckyCounterTimerStatus;", "", "TIMER_START", "TIMER_STOP", "TIMER_DONE", "TIMER_SUPPLEMENT", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCounterTimerStatus extends Enum<LuckyCounterTimerStatus> {
    public static final LuckyCounterTimerStatus TIMER_DONE = null;
    public static final LuckyCounterTimerStatus TIMER_START = null;
    public static final LuckyCounterTimerStatus TIMER_STOP = null;
    public static final LuckyCounterTimerStatus TIMER_SUPPLEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCounterTimerStatus[] f272301a = null;

    static {
        LuckyCounterTimerStatus r100 = new LuckyCounterTimerStatus("TIMER_START", 0);
        TIMER_START = r100;
        LuckyCounterTimerStatus r101 = new LuckyCounterTimerStatus("TIMER_STOP", 1);
        TIMER_STOP = r101;
        LuckyCounterTimerStatus r102 = new LuckyCounterTimerStatus("TIMER_DONE", 2);
        TIMER_DONE = r102;
        LuckyCounterTimerStatus r103 = new LuckyCounterTimerStatus("TIMER_SUPPLEMENT", 3);
        TIMER_SUPPLEMENT = r103;
        f272301a = new LuckyCounterTimerStatus[]{r100, r101, r102, r103};
    }

    public static LuckyCounterTimerStatus valueOf(String r100) {
        return (LuckyCounterTimerStatus) a.a(LuckyCounterTimerStatus.class, r100);
    }

    public static LuckyCounterTimerStatus[] values() {
        return (LuckyCounterTimerStatus[]) f272301a.clone();
    }

    public LuckyCounterTimerStatus(String r100, int r101) {
        super(r100, r101);
    }
}
