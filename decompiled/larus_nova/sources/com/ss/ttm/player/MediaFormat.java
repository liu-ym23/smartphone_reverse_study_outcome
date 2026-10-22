package com.ss.ttm.player;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class MediaFormat {
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_BIT_RATE = "bitrate";
    public static final String KEY_CHANNEL_COUNT = "channel-count";
    public static final String KEY_CODEC_NAME = "codec-name";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_FRAME_RATE = "frame-rate";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_ROTATION = "rotation";
    public static final String KEY_SAMPLE_RATE = "sample-rate";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TRACK_ID = "track-id";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_WIDTH = "width";
    private Map<String, Object> mMap;

    public String toString() {
        return this.mMap.toString();
    }

    public MediaFormat() {
        this.mMap = new HashMap();
    }

    public Map<String, Object> getValues() {
        return this.mMap;
    }

    public MediaFormat(Map<String, Object> r100) {
        this.mMap = r100;
    }

    public static final MediaFormat createAudioFormat(android.media.MediaFormat r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createAudioFormat(r100.getInteger(KEY_TRACK_ID), r100.getInteger(KEY_SAMPLE_RATE), r100.getInteger(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createSubtitleFormat(android.media.MediaFormat r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createSubtitleFormat(r100.getInteger(KEY_TRACK_ID), r100.getString("language"));
    }

    public static final MediaFormat createVideoFormat(android.media.MediaFormat r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createVideoFormat(r100.getInteger(KEY_TRACK_ID), r100.getInteger("width"), r100.getInteger("height"), r100.getInteger("bitrate"));
    }

    public final float getFloat(String r100) {
        Object r101 = this.mMap.get(r100);
        if (r101 != null) goto L5;
        return 0.0f;
    L5:
        return ((Float) r101).floatValue();
    }

    public final int getInteger(String r100) {
        Object r101 = this.mMap.get(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        return ((Integer) r101).intValue();
    }

    public final long getLong(String r100) {
        Object r101 = this.mMap.get(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        return ((Long) r101).longValue();
    }

    public final String getString(String r100) {
        return (String) this.mMap.get(r100);
    }

    public static final MediaFormat createAudioFormat(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createAudioFormat(r100.optInt(KEY_TRACK_ID), r100.optInt(KEY_SAMPLE_RATE), r100.optInt(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createSubtitleFormat(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createSubtitleFormat(r100.optInt(KEY_TRACK_ID), r100.optString("language"));
    }

    public static final MediaFormat createVideoFormat(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return createVideoFormat(r100.optInt(KEY_TRACK_ID), r100.optInt("width"), r100.optInt("height"), r100.optInt("bitrate"));
    }

    public static final MediaFormat createSubtitleFormat(int r100, String r101) {
        MediaFormat r102 = new MediaFormat();
        r102.setInteger(KEY_TRACK_ID, r100);
        r102.setString("language", r101);
        return r102;
    }

    public final void setFloat(String r100, float r101) {
        this.mMap.put(r100, Float.valueOf(r101));
    }

    public final void setInteger(String r100, int r101) {
        this.mMap.put(r100, Integer.valueOf(r101));
    }

    public final void setLong(String r100, long r101) {
        this.mMap.put(r100, Long.valueOf(r101));
    }

    public final void setString(String r100, String r101) {
        this.mMap.put(r100, r101);
    }

    public static final MediaFormat createAudioFormat(int r100, int r101, int r102) {
        MediaFormat r103 = new MediaFormat();
        r103.setInteger(KEY_TRACK_ID, r100);
        r103.setInteger(KEY_SAMPLE_RATE, r101);
        r103.setInteger(KEY_CHANNEL_COUNT, r102);
        return r103;
    }

    public static final MediaFormat createVideoFormat(int r100, int r101, int r102, int r103) {
        MediaFormat r104 = new MediaFormat();
        r104.setInteger(KEY_TRACK_ID, r100);
        r104.setInteger("width", r101);
        r104.setInteger("height", r102);
        r104.setInteger("bitrate", r103);
        return r104;
    }
}
