package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "FINISH", "HIDE", "KEEP", "RESUME", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PopupTriggerType extends Enum<PopupTriggerType> {
    public static final PopupTriggerType FINISH = null;
    public static final PopupTriggerType HIDE = null;
    public static final PopupTriggerType KEEP = null;
    public static final PopupTriggerType RESUME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupTriggerType[] f248143a = null;
    private final String value;

    public static PopupTriggerType valueOf(String r100) {
        return (PopupTriggerType) r27.a.a(PopupTriggerType.class, r100);
    }

    public static PopupTriggerType[] values() {
        return (PopupTriggerType[]) f248143a.clone();
    }

    static {
        PopupTriggerType r100 = new PopupTriggerType("FINISH", 0, "0");
        FINISH = r100;
        PopupTriggerType r101 = new PopupTriggerType("HIDE", 1, "1");
        HIDE = r101;
        PopupTriggerType r102 = new PopupTriggerType("KEEP", 2, "2");
        KEEP = r102;
        PopupTriggerType r103 = new PopupTriggerType("RESUME", 3, "3");
        RESUME = r103;
        f248143a = new PopupTriggerType[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public PopupTriggerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
