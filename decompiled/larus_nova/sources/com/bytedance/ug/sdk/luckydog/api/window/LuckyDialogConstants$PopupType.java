package com.bytedance.ug.sdk.luckydog.api.window;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"com/bytedance/ug/sdk/luckydog/api/window/LuckyDialogConstants$PopupType", "", "Lcom/bytedance/ug/sdk/luckydog/api/window/LuckyDialogConstants$PopupType;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "CLOD_POP", "DYNAMIC_POP", "POLLING_POP", "LOW_POPS", "RETRY_POP", "FEEDBACK_POP", "RESOURCE_POP", "REMOVE_POP", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyDialogConstants$PopupType extends Enum<LuckyDialogConstants$PopupType> {
    public static final LuckyDialogConstants$PopupType CLOD_POP = null;
    public static final LuckyDialogConstants$PopupType DYNAMIC_POP = null;
    public static final LuckyDialogConstants$PopupType FEEDBACK_POP = null;
    public static final LuckyDialogConstants$PopupType LOW_POPS = null;
    public static final LuckyDialogConstants$PopupType POLLING_POP = null;
    public static final LuckyDialogConstants$PopupType REMOVE_POP = null;
    public static final LuckyDialogConstants$PopupType RESOURCE_POP = null;
    public static final LuckyDialogConstants$PopupType RETRY_POP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyDialogConstants$PopupType[] f271720a = null;
    private String type;

    public static LuckyDialogConstants$PopupType valueOf(String r100) {
        return (LuckyDialogConstants$PopupType) a.a(LuckyDialogConstants$PopupType.class, r100);
    }

    public static LuckyDialogConstants$PopupType[] values() {
        return (LuckyDialogConstants$PopupType[]) f271720a.clone();
    }

    static {
        LuckyDialogConstants$PopupType r100 = new LuckyDialogConstants$PopupType("CLOD_POP", 0, "冷启动弹窗");
        CLOD_POP = r100;
        LuckyDialogConstants$PopupType r101 = new LuckyDialogConstants$PopupType("DYNAMIC_POP", 1, "机动弹窗");
        DYNAMIC_POP = r101;
        LuckyDialogConstants$PopupType r102 = new LuckyDialogConstants$PopupType("POLLING_POP", 2, "全局弹窗");
        POLLING_POP = r102;
        LuckyDialogConstants$PopupType r103 = new LuckyDialogConstants$PopupType("LOW_POPS", 3, "低版本升级弹窗");
        LOW_POPS = r103;
        LuckyDialogConstants$PopupType r104 = new LuckyDialogConstants$PopupType("RETRY_POP", 4, "lynx弹窗展示失败重试");
        RETRY_POP = r104;
        LuckyDialogConstants$PopupType r105 = new LuckyDialogConstants$PopupType("FEEDBACK_POP", 5, "任务完成反馈弹窗");
        FEEDBACK_POP = r105;
        LuckyDialogConstants$PopupType r106 = new LuckyDialogConstants$PopupType("RESOURCE_POP", 6, "承接弹窗");
        RESOURCE_POP = r106;
        LuckyDialogConstants$PopupType r107 = new LuckyDialogConstants$PopupType("REMOVE_POP", 7, "阻断弹窗");
        REMOVE_POP = r107;
        f271720a = new LuckyDialogConstants$PopupType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public LuckyDialogConstants$PopupType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
