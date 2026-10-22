package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VERenderCallbackSettings$ReqFrameStage extends Enum<VERenderCallbackSettings$ReqFrameStage> {
    public static final VERenderCallbackSettings$ReqFrameStage REQUEST_FRAME_STAGE_CAMERA_INPUT = null;
    public static final VERenderCallbackSettings$ReqFrameStage REQUEST_FRAME_STAGE_RENDERED = null;
    public static final VERenderCallbackSettings$ReqFrameStage REQUEST_FRAME_STAGE_SOURCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VERenderCallbackSettings$ReqFrameStage[] f455708a = null;

    static {
        VERenderCallbackSettings$ReqFrameStage r100 = new VERenderCallbackSettings$ReqFrameStage("REQUEST_FRAME_STAGE_SOURCE", 0);
        REQUEST_FRAME_STAGE_SOURCE = r100;
        VERenderCallbackSettings$ReqFrameStage r101 = new VERenderCallbackSettings$ReqFrameStage("REQUEST_FRAME_STAGE_RENDERED", 1);
        REQUEST_FRAME_STAGE_RENDERED = r101;
        VERenderCallbackSettings$ReqFrameStage r102 = new VERenderCallbackSettings$ReqFrameStage("REQUEST_FRAME_STAGE_CAMERA_INPUT", 2);
        REQUEST_FRAME_STAGE_CAMERA_INPUT = r102;
        f455708a = new VERenderCallbackSettings$ReqFrameStage[]{r100, r101, r102};
    }

    public static VERenderCallbackSettings$ReqFrameStage[] values() {
        return (VERenderCallbackSettings$ReqFrameStage[]) f455708a.clone();
    }

    public static VERenderCallbackSettings$ReqFrameStage valueOf(String r100) {
        return (VERenderCallbackSettings$ReqFrameStage) r27.a.a(VERenderCallbackSettings$ReqFrameStage.class, r100);
    }

    public VERenderCallbackSettings$ReqFrameStage(String r100, int r101) {
        super(r100, r101);
    }
}
