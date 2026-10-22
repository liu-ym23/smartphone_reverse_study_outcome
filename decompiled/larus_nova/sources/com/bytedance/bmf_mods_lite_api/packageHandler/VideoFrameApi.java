package com.bytedance.bmf_mods_lite_api.packageHandler;

/* JADX INFO: loaded from: classes45.dex */
public interface VideoFrameApi {

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_lite_api.packageHandler.VideoFrameApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$clearData(VideoFrameApi r100) {
            return -1;
        }

        public static long $default$getNativePtr(VideoFrameApi r100) {
            return 0;
        }

        public static int $default$getVideoFrameFormat(VideoFrameApi r100) {
            return -1;
        }

        public static int $default$getVideoFrameHeight(VideoFrameApi r100) {
            return -1;
        }

        public static int $default$getVideoFrameTexture(VideoFrameApi r100) {
            return -1;
        }

        public static int $default$getVideoFrameWidth(VideoFrameApi r100) {
            return -1;
        }

        public static void $default$release(VideoFrameApi r100) {
        }

        public static int $default$setVideoFrame(VideoFrameApi r100, int r101, int r102, int r103, int r104, int r105) {
            return -1;
        }
    }

    int clearData();

    long getNativePtr();

    int getVideoFrameFormat();

    int getVideoFrameHeight();

    int getVideoFrameTexture();

    int getVideoFrameWidth();

    void release();

    int setVideoFrame(int r100, int r101, int r102, int r103, int r104);
}
