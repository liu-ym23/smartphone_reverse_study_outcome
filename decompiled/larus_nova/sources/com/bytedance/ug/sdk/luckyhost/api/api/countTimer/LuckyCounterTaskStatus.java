package com.bytedance.ug.sdk.luckyhost.api.api.countTimer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ug/sdk/luckyhost/api/api/countTimer/LuckyCounterTaskStatus;", "", "TASK_STATUS_PROCESSING", "TASK_STATUS_COMPLETE", "TASK_STATUS_EXPIRED", "TASK_STATUS_FAILED", "TASK_STATUS_ACK_FAILED", "TASK_STATUS_REMOVED", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCounterTaskStatus extends Enum<LuckyCounterTaskStatus> {
    public static final LuckyCounterTaskStatus TASK_STATUS_ACK_FAILED = null;
    public static final LuckyCounterTaskStatus TASK_STATUS_COMPLETE = null;
    public static final LuckyCounterTaskStatus TASK_STATUS_EXPIRED = null;
    public static final LuckyCounterTaskStatus TASK_STATUS_FAILED = null;
    public static final LuckyCounterTaskStatus TASK_STATUS_PROCESSING = null;
    public static final LuckyCounterTaskStatus TASK_STATUS_REMOVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCounterTaskStatus[] f272300a = null;

    static {
        LuckyCounterTaskStatus r100 = new LuckyCounterTaskStatus("TASK_STATUS_PROCESSING", 0);
        TASK_STATUS_PROCESSING = r100;
        LuckyCounterTaskStatus r101 = new LuckyCounterTaskStatus("TASK_STATUS_COMPLETE", 1);
        TASK_STATUS_COMPLETE = r101;
        LuckyCounterTaskStatus r102 = new LuckyCounterTaskStatus("TASK_STATUS_EXPIRED", 2);
        TASK_STATUS_EXPIRED = r102;
        LuckyCounterTaskStatus r103 = new LuckyCounterTaskStatus("TASK_STATUS_FAILED", 3);
        TASK_STATUS_FAILED = r103;
        LuckyCounterTaskStatus r104 = new LuckyCounterTaskStatus("TASK_STATUS_ACK_FAILED", 4);
        TASK_STATUS_ACK_FAILED = r104;
        LuckyCounterTaskStatus r105 = new LuckyCounterTaskStatus("TASK_STATUS_REMOVED", 5);
        TASK_STATUS_REMOVED = r105;
        f272300a = new LuckyCounterTaskStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static LuckyCounterTaskStatus valueOf(String r100) {
        return (LuckyCounterTaskStatus) a.a(LuckyCounterTaskStatus.class, r100);
    }

    public static LuckyCounterTaskStatus[] values() {
        return (LuckyCounterTaskStatus[]) f272300a.clone();
    }

    public LuckyCounterTaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
