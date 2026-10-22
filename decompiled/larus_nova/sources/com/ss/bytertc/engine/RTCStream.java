package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.StreamIndex;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class RTCStream {
    public boolean hasAudio;
    public boolean hasVideo;
    public boolean isScreen;
    public StreamIndex streamIndex;
    public String userId;
    public List<VideoStreamDescription> videoStreamDescriptions;

    public String toString() {
        return "RTCStream{ userId='" + this.userId + "', isScreen=" + this.isScreen + ", hasVideo=" + this.hasVideo + ", hasAudio=" + this.hasAudio + ", videoStreamDescriptions=" + this.videoStreamDescriptions + '}';
    }

    public RTCStream() {
    }

    private static RTCStream create(String r100, StreamIndex r101, boolean r110, boolean r111, boolean r112) {
        return new RTCStream(r100, r101, r110, r111, r112, null);
    }

    public RTCStream(String r100, StreamIndex r101, boolean r102, boolean r103, boolean r104, List<VideoStreamDescription> r105) {
        this.userId = r100;
        this.streamIndex = r101;
        this.isScreen = r102;
        this.hasVideo = r103;
        this.hasAudio = r104;
        this.videoStreamDescriptions = r105;
    }

    private static RTCStream createWithStreamDescriptions(String r100, StreamIndex r101, boolean r110, boolean r111, boolean r112, VideoStreamDescription[] r113) {
        return new RTCStream(r100, r101, r110, r111, r112, Arrays.asList(r113));
    }
}
