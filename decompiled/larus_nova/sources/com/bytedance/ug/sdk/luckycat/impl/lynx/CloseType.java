package com.bytedance.ug.sdk.luckycat.impl.lynx;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/lynx/CloseType;", "", "", "value", "I", "getValue", "()I", "CLOSE_BY_USER", "CLOSE_BY_OPEN_NEW_PAGE", "CLOSE_BY_CLOSE_JSB", "CLOSE_BY_CONTAINER_ID", "CLOSE_BY_ERROR", "CLOSE_BY_BACK", "CLOSE_BY_NEW_PAGE_LAUNCH_MODE", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final enum CloseType extends Enum<CloseType> {
    public static final CloseType CLOSE_BY_BACK = null;
    public static final CloseType CLOSE_BY_CLOSE_JSB = null;
    public static final CloseType CLOSE_BY_CONTAINER_ID = null;
    public static final CloseType CLOSE_BY_ERROR = null;
    public static final CloseType CLOSE_BY_NEW_PAGE_LAUNCH_MODE = null;
    public static final CloseType CLOSE_BY_OPEN_NEW_PAGE = null;
    public static final CloseType CLOSE_BY_USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseType[] f271150a = null;
    private final int value;

    static {
        CloseType r100 = new CloseType("CLOSE_BY_USER", 0, 0);
        CLOSE_BY_USER = r100;
        CloseType r101 = new CloseType("CLOSE_BY_OPEN_NEW_PAGE", 1, 1);
        CLOSE_BY_OPEN_NEW_PAGE = r101;
        CloseType r102 = new CloseType("CLOSE_BY_CLOSE_JSB", 2, 2);
        CLOSE_BY_CLOSE_JSB = r102;
        CloseType r103 = new CloseType("CLOSE_BY_CONTAINER_ID", 3, 3);
        CLOSE_BY_CONTAINER_ID = r103;
        CloseType r104 = new CloseType("CLOSE_BY_ERROR", 4, 4);
        CLOSE_BY_ERROR = r104;
        CloseType r105 = new CloseType("CLOSE_BY_BACK", 5, 5);
        CLOSE_BY_BACK = r105;
        CloseType r106 = new CloseType("CLOSE_BY_NEW_PAGE_LAUNCH_MODE", 6, 6);
        CLOSE_BY_NEW_PAGE_LAUNCH_MODE = r106;
        f271150a = new CloseType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static CloseType valueOf(String r100) {
        return (CloseType) r27.a.a(CloseType.class, r100);
    }

    public static CloseType[] values() {
        return (CloseType[]) f271150a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CloseType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
