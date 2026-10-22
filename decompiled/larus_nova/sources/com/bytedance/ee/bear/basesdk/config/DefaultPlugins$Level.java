package com.bytedance.ee.bear.basesdk.config;

/* JADX INFO: loaded from: classes15.dex */
final enum DefaultPlugins$Level extends Enum<DefaultPlugins$Level> {
    public static final DefaultPlugins$Level At = null;
    public static final DefaultPlugins$Level Comment = null;
    public static final DefaultPlugins$Level ImgViewer = null;
    public static final DefaultPlugins$Level Reminder = null;
    public static final DefaultPlugins$Level Search = null;
    public static final DefaultPlugins$Level SheetToolbar = null;
    public static final DefaultPlugins$Level SmallLoading = null;
    public static final DefaultPlugins$Level Snapshot = null;
    public static final DefaultPlugins$Level Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultPlugins$Level[] f206592a = null;

    static {
        DefaultPlugins$Level r100 = new DefaultPlugins$Level("Toolbar", 0);
        Toolbar = r100;
        DefaultPlugins$Level r101 = new DefaultPlugins$Level("SheetToolbar", 1);
        SheetToolbar = r101;
        DefaultPlugins$Level r102 = new DefaultPlugins$Level("SmallLoading", 2);
        SmallLoading = r102;
        DefaultPlugins$Level r103 = new DefaultPlugins$Level("At", 3);
        At = r103;
        DefaultPlugins$Level r104 = new DefaultPlugins$Level("ImgViewer", 4);
        ImgViewer = r104;
        DefaultPlugins$Level r105 = new DefaultPlugins$Level("Comment", 5);
        Comment = r105;
        DefaultPlugins$Level r110 = new DefaultPlugins$Level("Search", 6);
        Search = r110;
        DefaultPlugins$Level r111 = new DefaultPlugins$Level("Reminder", 7);
        Reminder = r111;
        DefaultPlugins$Level r112 = new DefaultPlugins$Level("Snapshot", 8);
        Snapshot = r112;
        f206592a = new DefaultPlugins$Level[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static DefaultPlugins$Level[] values() {
        return (DefaultPlugins$Level[]) f206592a.clone();
    }

    public static DefaultPlugins$Level valueOf(String r100) {
        return (DefaultPlugins$Level) r27.a.a(DefaultPlugins$Level.class, r100);
    }

    public DefaultPlugins$Level(String r100, int r101) {
        super(r100, r101);
    }
}
