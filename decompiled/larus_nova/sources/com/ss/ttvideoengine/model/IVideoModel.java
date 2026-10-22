package com.ss.ttvideoengine.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.ttvideoengine.Resolution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public interface IVideoModel {
    public static final int MARK_FLAG_DEFAULT = 0;
    public static final int MARK_FLAG_OPTIONAL_ENHANCE_TYPE_UPDATE = 2;
    public static final int MARK_FLAG_OPTIONAL_GEAR_UPDATE = 1;
    public static final int MARK_FLAG_OPTIONAL_MEDIA_EXTRA_INFO = 8;

    public static final enum Format extends Enum<Format> {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final Format DASH = null;
        public static final Format HLS = null;
        public static final Format MP3 = null;
        public static final Format MP4 = null;
        public static final Format NONE = null;

        static {
            Format r100 = new Format(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Format r101 = new Format("MP4", 1);
            MP4 = r101;
            Format r102 = new Format("DASH", 2);
            DASH = r102;
            Format r103 = new Format("HLS", 3);
            HLS = r103;
            Format r104 = new Format("MP3", 4);
            MP3 = r104;
            $VALUES = new Format[]{r100, r101, r102, r103, r104};
        }

        public static Format[] values() {
            return (Format[]) $VALUES.clone();
        }

        public static Format valueOf(String r100) {
            return (Format) a.a(Format.class, r100);
        }

        private Format(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source BARE = null;
        public static final Source LIVE = null;
        public static final Source None = null;
        public static final Source VOD = null;

        static {
            Source r100 = new Source("None", 0);
            None = r100;
            Source r101 = new Source("LIVE", 1);
            LIVE = r101;
            Source r102 = new Source("VOD", 2);
            VOD = r102;
            Source r103 = new Source("BARE", 3);
            BARE = r103;
            $VALUES = new Source[]{r100, r101, r102, r103};
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    String[] allVideoURLs(Resolution r100);

    String[] allVideoURLs(Resolution r100, Map<Integer, String> r101);

    int fromMediaInfoJsonObject(JSONObject r100);

    int fromMediaInfoJsonString(String r100);

    String[] getCodecs();

    JSONObject getDnsInfo();

    String getDynamicType();

    Set<Format> getFormats();

    JSONObject getMediaInfo();

    List<Integer> getOriginalAudioInfo();

    Source getSource();

    String getSpadea();

    List<SubInfo> getSubInfoList();

    List<Integer> getSupportInfoId(int r100);

    String[] getSupportQualityInfos();

    Resolution[] getSupportResolutions();

    int[] getSupportSubtitleLangs();

    List<Integer> getSupportedTTSAudioInfo();

    String getVType();

    VideoInfo getVideoInfo(Resolution r100);

    VideoInfo getVideoInfo(Resolution r100, int r101, Map<Integer, String> r102);

    VideoInfo getVideoInfo(Resolution r100, int r101, Map<Integer, String> r102, boolean r103);

    VideoInfo getVideoInfo(Resolution r100, int r101, boolean r102);

    VideoInfo getVideoInfo(Resolution r100, Map<Integer, String> r101);

    VideoInfo getVideoInfo(Resolution r100, Map<Integer, String> r101, boolean r102);

    VideoInfo getVideoInfo(Resolution r100, boolean r101);

    VideoInfo getVideoInfo(Map<Integer, String> r100);

    VideoInfo getVideoInfoByInfoId(int r100);

    List<VideoInfo> getVideoInfoList();

    boolean getVideoRefBool(int r100);

    float getVideoRefFloat(int r100);

    int getVideoRefInt(int r100);

    long getVideoRefLong(int r100);

    String getVideoRefStr(int r100);

    VideoStyle getVideoStyle();

    boolean hasData();

    boolean hasFormat(Format r100);

    boolean isSupportBash();

    boolean isSupportHLSSeamlessSwitch();

    String resolutionToString(Resolution r100);

    void setUpResolution(HashMap<String, Resolution> r100);

    String toMediaInfoJsonString();
}
