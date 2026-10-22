package com.ss.bytertc.engine.video;

import android.util.SparseArray;
import com.ss.bytertc.engine.VideoStreamDescription;
import com.ss.bytertc.engine.data.RTCData;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes40.dex */
public class VideoProfile {
    private static SparseArray<VideoPreset> sVideoProfileMap;

    public VideoProfile() {
    }

    static {
        SparseArray<VideoPreset> r100 = new SparseArray();
        sVideoProfileMap = r100;
        r100.put(0, new VideoPreset(160, 120, 15, 65));
        sVideoProfileMap.put(2, new VideoPreset(120, 120, 15, 50));
        sVideoProfileMap.put(10, new VideoPreset(320, 180, 15, 140));
        sVideoProfileMap.put(12, new VideoPreset(180, 180, 15, 100));
        sVideoProfileMap.put(13, new VideoPreset(240, 180, 15, 120));
        sVideoProfileMap.put(14, new VideoPreset(240, 180, 15, 240));
        sVideoProfileMap.put(20, new VideoPreset(320, 240, 15, 200));
        sVideoProfileMap.put(21, new VideoPreset(320, 240, 15, 360));
        sVideoProfileMap.put(22, new VideoPreset(240, 240, 15, 140));
        sVideoProfileMap.put(23, new VideoPreset(424, 240, 15, 220));
        sVideoProfileMap.put(30, new VideoPreset(640, 360, 15, 600));
        sVideoProfileMap.put(32, new VideoPreset(360, 360, 15, 260));
        sVideoProfileMap.put(33, new VideoPreset(640, 360, 30, 600));
        sVideoProfileMap.put(34, new VideoPreset(640, 360, 15, 800));
        sVideoProfileMap.put(35, new VideoPreset(360, 360, 30, 400));
        sVideoProfileMap.put(36, new VideoPreset(480, 360, 15, 320));
        sVideoProfileMap.put(37, new VideoPreset(480, 360, 30, TTVideoEngineInterface.PLAYER_OPTION_FRC_LEVEL));
        sVideoProfileMap.put(40, new VideoPreset(640, 480, 15, 500));
        sVideoProfileMap.put(42, new VideoPreset(480, 480, 15, 400));
        sVideoProfileMap.put(43, new VideoPreset(640, 480, 30, 750));
        sVideoProfileMap.put(45, new VideoPreset(480, 480, 30, 600));
        sVideoProfileMap.put(46, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 15, 1200));
        sVideoProfileMap.put(47, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 30, 800));
        sVideoProfileMap.put(48, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 30, 930));
        sVideoProfileMap.put(50, new VideoPreset(1280, 720, 15, 1130));
        sVideoProfileMap.put(52, new VideoPreset(1280, 720, 30, 1710));
        sVideoProfileMap.put(54, new VideoPreset(960, 720, 15, 910));
        sVideoProfileMap.put(55, new VideoPreset(960, 720, 30, 1380));
    }

    public static VideoPreset getVideoVideoPreset() {
        VideoStreamDescription[] r100 = RTCData.instance().getVideoStreamDescriptions();
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r102 >= r101) goto L18;
        VideoStreamDescription r107 = r100[r102];
        if (((Integer) r107.videoSize.first).intValue() <= r103) goto L8;
        r103 = ((Integer) r107.videoSize.first).intValue();
    L8:
        if (((Integer) r107.videoSize.second).intValue() <= r104) goto L10;
        r104 = ((Integer) r107.videoSize.second).intValue();
    L10:
        int r108 = r107.frameRate;
        if (r108 <= r105) goto L13;
        r105 = r108;
    L13:
        int r109 = r107.maxKbps;
        if (r109 <= r106) goto L16;
        r106 = r109;
    L16:
        r102 = r102 + 1;
        goto L3
    L18:
        return new VideoPreset(r103, r104, r105, r106);
    }

    public static SparseArray<VideoPreset> getsVideoProfileMap() {
        return sVideoProfileMap;
    }

    public static VideoPreset getVideoVideoPresetById(int r100) {
        VideoPreset r101 = sVideoProfileMap.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return sVideoProfileMap.get(33);
    }

    public static void addVideoVideoPreset(int r100, VideoPreset r101) {
        sVideoProfileMap.put(r100, r101);
    }
}
