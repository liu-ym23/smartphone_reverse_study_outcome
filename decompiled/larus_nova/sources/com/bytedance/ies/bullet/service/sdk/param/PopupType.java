package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/PopupType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "aliasValue", "getAliasValue", "CENTER", "BOTTOM", "RIGHT", "DRAGGABLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PopupType extends Enum<PopupType> {
    public static final PopupType BOTTOM = null;
    public static final PopupType CENTER = null;
    public static final PopupType DRAGGABLE = null;
    public static final PopupType RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupType[] f248144a = null;
    private final String aliasValue;
    private final String value;

    public static PopupType valueOf(String r100) {
        return (PopupType) r27.a.a(PopupType.class, r100);
    }

    public static PopupType[] values() {
        return (PopupType[]) f248144a.clone();
    }

    static {
        PopupType r100 = new PopupType("CENTER", 0, "center", "0");
        CENTER = r100;
        PopupType r101 = new PopupType("BOTTOM", 1, "bottom", "1");
        BOTTOM = r101;
        PopupType r102 = new PopupType("RIGHT", 2, "right", "2");
        RIGHT = r102;
        PopupType r103 = new PopupType("DRAGGABLE", 3, "draggable", "3");
        DRAGGABLE = r103;
        f248144a = new PopupType[]{r100, r101, r102, r103};
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }

    public PopupType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.aliasValue = r103;
    }
}
