package com.bytedance.ee.bear.basesdk.config;

/* JADX INFO: loaded from: classes15.dex */
final enum MindnotePlugins$Level extends Enum<MindnotePlugins$Level> {
    public static final MindnotePlugins$Level At = null;
    public static final MindnotePlugins$Level Comment = null;
    public static final MindnotePlugins$Level CommentImageViewer = null;
    public static final MindnotePlugins$Level CustomHeader = null;
    public static final MindnotePlugins$Level DiyIcon = null;
    public static final MindnotePlugins$Level FollowTransCover = null;
    public static final MindnotePlugins$Level ImgViewer = null;
    public static final MindnotePlugins$Level Snapshot = null;
    public static final MindnotePlugins$Level Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MindnotePlugins$Level[] f206593a = null;

    static {
        MindnotePlugins$Level r100 = new MindnotePlugins$Level("FollowTransCover", 0);
        FollowTransCover = r100;
        MindnotePlugins$Level r101 = new MindnotePlugins$Level("Toolbar", 1);
        Toolbar = r101;
        MindnotePlugins$Level r102 = new MindnotePlugins$Level("At", 2);
        At = r102;
        MindnotePlugins$Level r103 = new MindnotePlugins$Level("ImgViewer", 3);
        ImgViewer = r103;
        MindnotePlugins$Level r104 = new MindnotePlugins$Level("DiyIcon", 4);
        DiyIcon = r104;
        MindnotePlugins$Level r105 = new MindnotePlugins$Level("CustomHeader", 5);
        CustomHeader = r105;
        MindnotePlugins$Level r110 = new MindnotePlugins$Level("Comment", 6);
        Comment = r110;
        MindnotePlugins$Level r111 = new MindnotePlugins$Level("CommentImageViewer", 7);
        CommentImageViewer = r111;
        MindnotePlugins$Level r112 = new MindnotePlugins$Level("Snapshot", 8);
        Snapshot = r112;
        f206593a = new MindnotePlugins$Level[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static MindnotePlugins$Level[] values() {
        return (MindnotePlugins$Level[]) f206593a.clone();
    }

    public static MindnotePlugins$Level valueOf(String r100) {
        return (MindnotePlugins$Level) r27.a.a(MindnotePlugins$Level.class, r100);
    }

    public MindnotePlugins$Level(String r100, int r101) {
        super(r100, r101);
    }
}
