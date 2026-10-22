package com.bytedance.ee.bear.drive.loader.download;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum DownLoadState extends Enum<DownLoadState> {
    private static final /* synthetic */ DownLoadState[] $VALUES = null;
    public static final DownLoadState LoadFail = null;
    public static final DownLoadState LoadSuccess = null;
    public static final DownLoadState Loading = null;

    static {
        DownLoadState r0 = new DownLoadState("Loading", 0);
        Loading = r0;
        DownLoadState r1 = new DownLoadState("LoadSuccess", 1);
        LoadSuccess = r1;
        DownLoadState r3 = new DownLoadState("LoadFail", 2);
        LoadFail = r3;
        $VALUES = new DownLoadState[]{r0, r1, r3};
    }

    public static DownLoadState[] values() {
        return (DownLoadState[]) $VALUES.clone();
    }

    public static DownLoadState valueOf(String r1) {
        return (DownLoadState) r27.a.a(DownLoadState.class, r1);
    }

    private DownLoadState(String r1, int r2) {
        super(r1, r2);
    }
}
