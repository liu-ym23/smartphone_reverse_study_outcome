package com.bytedance.ug.sdk.luckydog.api.window;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/bytedance/ug/sdk/luckydog/api/window/LuckyDialogConstants$PopupStatus", "", "Lcom/bytedance/ug/sdk/luckydog/api/window/LuckyDialogConstants$PopupStatus;", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "RECEIVE", "ENQUEUE", "DEQUEUE", "SHOW", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyDialogConstants$PopupStatus extends Enum<LuckyDialogConstants$PopupStatus> {
    public static final LuckyDialogConstants$PopupStatus DEQUEUE = null;
    public static final LuckyDialogConstants$PopupStatus ENQUEUE = null;
    public static final LuckyDialogConstants$PopupStatus RECEIVE = null;
    public static final LuckyDialogConstants$PopupStatus SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyDialogConstants$PopupStatus[] f271719a = null;
    private String status;

    static {
        LuckyDialogConstants$PopupStatus r100 = new LuckyDialogConstants$PopupStatus("RECEIVE", 0, "receive");
        RECEIVE = r100;
        LuckyDialogConstants$PopupStatus r101 = new LuckyDialogConstants$PopupStatus("ENQUEUE", 1, "enqueue");
        ENQUEUE = r101;
        LuckyDialogConstants$PopupStatus r102 = new LuckyDialogConstants$PopupStatus("DEQUEUE", 2, "dequeue");
        DEQUEUE = r102;
        LuckyDialogConstants$PopupStatus r103 = new LuckyDialogConstants$PopupStatus("SHOW", 3, "show");
        SHOW = r103;
        f271719a = new LuckyDialogConstants$PopupStatus[]{r100, r101, r102, r103};
    }

    public static LuckyDialogConstants$PopupStatus valueOf(String r100) {
        return (LuckyDialogConstants$PopupStatus) a.a(LuckyDialogConstants$PopupStatus.class, r100);
    }

    public static LuckyDialogConstants$PopupStatus[] values() {
        return (LuckyDialogConstants$PopupStatus[]) f271719a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public LuckyDialogConstants$PopupStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
