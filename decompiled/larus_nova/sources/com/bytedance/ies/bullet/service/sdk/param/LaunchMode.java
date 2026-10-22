package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MODE_UNSPECIFIED", "REMOVE_SAME_PAGE", "CLEAR_TOP", "CLEAR_TOP_FLAG", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LaunchMode extends Enum<LaunchMode> {
    public static final LaunchMode CLEAR_TOP = null;
    public static final LaunchMode CLEAR_TOP_FLAG = null;
    public static final LaunchMode MODE_UNSPECIFIED = null;
    public static final LaunchMode REMOVE_SAME_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchMode[] f248140a = null;
    private final String value;

    public static LaunchMode valueOf(String r100) {
        return (LaunchMode) r27.a.a(LaunchMode.class, r100);
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) f248140a.clone();
    }

    static {
        LaunchMode r100 = new LaunchMode("MODE_UNSPECIFIED", 0, "mode_unspecified");
        MODE_UNSPECIFIED = r100;
        LaunchMode r101 = new LaunchMode("REMOVE_SAME_PAGE", 1, "remove_same_page");
        REMOVE_SAME_PAGE = r101;
        LaunchMode r102 = new LaunchMode("CLEAR_TOP", 2, "clear_top");
        CLEAR_TOP = r102;
        LaunchMode r103 = new LaunchMode("CLEAR_TOP_FLAG", 3, "clear_top_flag");
        CLEAR_TOP_FLAG = r103;
        f248140a = new LaunchMode[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public LaunchMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
