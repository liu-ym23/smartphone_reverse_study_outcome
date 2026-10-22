package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDVideoUploaderListener {
    public static final int EndTimeUploadStage1 = 1001;
    public static final int EndTimeUploadStage2 = 1002;
    public static final int EndTimeUploadStage3 = 1003;
    public static final int EndTimeUploadStage4 = 1004;
    public static final int EndTimeUploadStage5 = 1005;

    String getStringFromExtern(int r100);

    void onLog(int r100, int r101, String r102);

    void onNotify(int r100, long r101, BDVideoInfo r102);

    void onUploadVideoStage(int r100, long r101);

    int videoUploadCheckNetState(int r100, int r101);
}
