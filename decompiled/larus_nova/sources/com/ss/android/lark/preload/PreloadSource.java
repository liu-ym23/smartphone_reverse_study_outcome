package com.ss.android.lark.preload;

/* JADX INFO: loaded from: classes37.dex */
public final enum PreloadSource extends Enum<PreloadSource> {
    public static final PreloadSource BOT_CHAT = null;
    public static final PreloadSource DOC_FEED = null;
    public static final PreloadSource DOC_TAB = null;
    public static final PreloadSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadSource[] f438799a = null;

    static {
        PreloadSource r100 = new PreloadSource("UNKNOWN", 0);
        UNKNOWN = r100;
        PreloadSource r101 = new PreloadSource("DOC_FEED", 1);
        DOC_FEED = r101;
        PreloadSource r102 = new PreloadSource("DOC_TAB", 2);
        DOC_TAB = r102;
        PreloadSource r103 = new PreloadSource("BOT_CHAT", 3);
        BOT_CHAT = r103;
        f438799a = new PreloadSource[]{r100, r101, r102, r103};
    }

    public static PreloadSource[] values() {
        return (PreloadSource[]) f438799a.clone();
    }

    public static PreloadSource valueOf(String r100) {
        return (PreloadSource) r27.a.a(PreloadSource.class, r100);
    }

    public PreloadSource(String r100, int r101) {
        super(r100, r101);
    }
}
