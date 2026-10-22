package com.bytedance.ee.bear.drive.loader.download;

/* JADX INFO: loaded from: classes16.dex */
public final enum DownLoadState extends Enum<DownLoadState> {
    private static final /* synthetic */ DownLoadState[] $VALUES = null;
    public static final DownLoadState LoadFail = null;
    public static final DownLoadState LoadSuccess = null;
    public static final DownLoadState Loading = null;

    static {
        DownLoadState r100 = new DownLoadState("Loading", 0);
        Loading = r100;
        DownLoadState r101 = new DownLoadState("LoadSuccess", 1);
        LoadSuccess = r101;
        DownLoadState r102 = new DownLoadState("LoadFail", 2);
        LoadFail = r102;
        $VALUES = new DownLoadState[]{r100, r101, r102};
    }

    public static DownLoadState[] values() {
        return (DownLoadState[]) $VALUES.clone();
    }

    public static DownLoadState valueOf(String r100) {
        return (DownLoadState) r27.a.a(DownLoadState.class, r100);
    }

    private DownLoadState(String r100, int r101) {
        super(r100, r101);
    }
}
