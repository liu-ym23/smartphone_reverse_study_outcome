package com.ss.bytertc.engine.data;

import android.util.Pair;
import com.ss.bytertc.engine.VideoStreamDescription;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.VideoEncoderConfiguration;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class RTCData {
    private static final String TAG = "RTCData";
    private VideoEncoderConfiguration.OrientationMode mOrientationMode;
    private VideoStreamDescription[] videoStreamDescriptions;

    public static class SingletonHelper {
        private static final RTCData INSTANCE = null;

        private SingletonHelper() {
        }

        static {
            INSTANCE = new RTCData();
        }

        public static /* synthetic */ RTCData access$000() {
            return INSTANCE;
        }
    }

    public RTCData() {
        this.videoStreamDescriptions = new VideoStreamDescription[1];
        VideoStreamDescription r100 = new VideoStreamDescription();
        r100.videoSize = new Pair(640, 360);
        r100.frameRate = 20;
        r100.maxKbps = 600;
        this.videoStreamDescriptions[0] = r100;
        this.mOrientationMode = VideoEncoderConfiguration.OrientationMode.ORIENTATION_MODE_ADAPTIVE;
    }

    public static RTCData instance() {
        return SingletonHelper.access$000();
    }

    public VideoEncoderConfiguration.OrientationMode getOrientationMode() {
        return this.mOrientationMode;
    }

    public VideoStreamDescription[] getVideoStreamDescriptions() {
        return this.videoStreamDescriptions;
    }

    public void setOrientationMode(VideoEncoderConfiguration.OrientationMode r100) {
        this.mOrientationMode = r100;
    }

    public void setVideoStreamDescriptions(VideoStreamDescription[] r100) {
        LogUtil.i(TAG, "setVideoStreamDescriptions: " + Arrays.toString(r100));
        this.videoStreamDescriptions = r100;
    }
}
