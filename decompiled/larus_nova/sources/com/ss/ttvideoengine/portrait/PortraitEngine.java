package com.ss.ttvideoengine.portrait;

import android.text.TextUtils;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PortraitEngine {
    public static final String LABEL_DEVICE_SCORE = "device_score";
    public static final String LABEL_FF = "ff_label";
    public static final String LABEL_FIRST_FRAME = "first_frame";
    public static final String LABEL_NET_QUALITY_SPEED = "clinet_quality_speed";
    public static final String LABEL_NET_QUALITY_STABILITY = "clinet_quality_stability";
    public static final String LABEL_REBUF = "rebuf_label";
    public static final String LABEL_REBUFFERING = "rebuffering";
    public static final String LABEL_SCENE_COUNT_PER_100VV = "scene_count_per_100vv";
    public static final String LABEL_SEEK = "seek_label";
    public static final String LABEL_USER_ENGER_FULL_SCREEN = "user_enter_full_screen";
    public static final String LABEL_USER_QUALITY_SENSITIVITY = "user_quality_sensitivity";
    public static final String LABEL_WATCH_DURATION = "watch_duration";
    public static final String PORTRAIT_ENGINE_KEY = "portrait_engine";
    private static final String TAG = "PortraitEngine";
    public static final String VOD_KEY = "vod";
    private final ConcurrentHashMap<String, Object> mLabelMap;
    private final CopyOnWriteArrayList<PortraitChangeListener> mListeners;
    private final IPortrait mPortraitNetwork;

    public static class Holder {
        private static final PortraitEngine Instance = null;

        private Holder() {
        }

        static {
            Instance = new PortraitEngine();
        }

        public static /* synthetic */ PortraitEngine access$000() {
            return Instance;
        }
    }

    public Map<String, Object> getAllLabels() {
        return new HashMap(this.mLabelMap);
    }

    public PortraitEngine() {
        this.mLabelMap = new ConcurrentHashMap();
        this.mListeners = new CopyOnWriteArrayList();
        this.mPortraitNetwork = PortraitNetworkScore.getInstance();
    }

    public static PortraitEngine getInstance() {
        return Holder.access$000();
    }

    public void addPortraitListener(PortraitChangeListener r100) {
        this.mListeners.add(r100);
    }

    public Object getLabel(String r100) {
        return this.mLabelMap.get(r100);
    }

    public IPortrait getPortrait(int r100) {
        if (r100 != 1) goto L7;
        return this.mPortraitNetwork;
    L7:
        return IPortrait.EMPTY;
    }

    public void removePortraitListener(PortraitChangeListener r100) {
        this.mListeners.remove(r100);
    }

    private void notifyPortraitChange(String r100, Object r101) {
        Iterator<PortraitChangeListener> r102 = this.mListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onPortraitChange(r100, r101);
        goto L4
    }

    public void setLabel(String r100, Object r101) {
        if (this.mLabelMap.containsKey(r100) == false) goto L10;
        if (this.mLabelMap.get(r100) == null) goto L10;
        if (this.mLabelMap.get(r100).equals(r101) == true) goto L10;
        notifyPortraitChange(r100, r101);
    L13:
        this.mLabelMap.put(r100, r101);
        return;
    L10:
        if (this.mLabelMap.containsKey(r100) == true) goto L12;
        notifyPortraitChange(r100, r101);
        goto L13
    L12:
        TTVideoEngineLog.d(TAG, "same label");
        goto L13
    }

    public void updateLabelBySettings(String r110, String r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        if (r110.equals("vod") == false) goto L52;
        TTVideoEngineLog.d(TAG, "updateLabelBySettings key: " + r110 + "value: " + r111);
        if (TextUtils.isEmpty(r111) == true) goto L53;
        JSONObject r100 = new JSONObject(r111);     // Catch: JSONException -> L46
        if (r100.has(PORTRAIT_ENGINE_KEY) == false) goto L54;
        JSONObject r101 = r100.optJSONObject(PORTRAIT_ENGINE_KEY);     // Catch: JSONException -> L46
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.has(LABEL_NET_QUALITY_SPEED) == false) goto L16;
        setLabel(LABEL_NET_QUALITY_SPEED, Integer.valueOf(r101.optInt(LABEL_NET_QUALITY_SPEED)));     // Catch: JSONException -> L46
    L16:
        if (r101.has(LABEL_NET_QUALITY_STABILITY) == false) goto L19;
        setLabel(LABEL_NET_QUALITY_STABILITY, Integer.valueOf(r101.optInt(LABEL_NET_QUALITY_STABILITY)));     // Catch: JSONException -> L46
    L19:
        if (r101.has(LABEL_REBUF) == false) goto L22;
        setLabel(LABEL_REBUF, Integer.valueOf(r101.optInt(LABEL_REBUF)));     // Catch: JSONException -> L46
    L22:
        if (r101.has(LABEL_FF) == false) goto L25;
        setLabel(LABEL_FF, Integer.valueOf(r101.optInt(LABEL_FF)));     // Catch: JSONException -> L46
    L25:
        if (r101.has(LABEL_SEEK) == false) goto L28;
        setLabel(LABEL_SEEK, Integer.valueOf(r101.optInt(LABEL_SEEK)));     // Catch: JSONException -> L46
    L28:
        if (r101.has(LABEL_WATCH_DURATION) == false) goto L31;
        setLabel(LABEL_WATCH_DURATION, Integer.valueOf(r101.optInt(LABEL_WATCH_DURATION)));     // Catch: JSONException -> L46
    L31:
        if (r101.has(LABEL_FIRST_FRAME) == false) goto L34;
        setLabel(LABEL_FIRST_FRAME, Integer.valueOf(r101.optInt(LABEL_FIRST_FRAME)));     // Catch: JSONException -> L46
    L34:
        if (r101.has(LABEL_REBUFFERING) == false) goto L37;
        setLabel(LABEL_REBUFFERING, Integer.valueOf(r101.optInt(LABEL_REBUFFERING)));     // Catch: JSONException -> L46
    L37:
        if (r101.has(LABEL_USER_ENGER_FULL_SCREEN) == false) goto L40;
        setLabel(LABEL_USER_ENGER_FULL_SCREEN, Integer.valueOf(r101.optInt(LABEL_USER_ENGER_FULL_SCREEN)));     // Catch: JSONException -> L46
    L40:
        if (r101.has(LABEL_SCENE_COUNT_PER_100VV) == false) goto L43;
        setLabel(LABEL_SCENE_COUNT_PER_100VV, Double.valueOf(r101.optDouble(LABEL_SCENE_COUNT_PER_100VV)));     // Catch: JSONException -> L46
    L43:
        if (r101.has(LABEL_USER_QUALITY_SENSITIVITY) == false) goto L56;
        setLabel(LABEL_USER_QUALITY_SENSITIVITY, Double.valueOf(r101.optDouble(LABEL_USER_QUALITY_SENSITIVITY)));     // Catch: JSONException -> L46
        return;
    L56:
        return;
    L54:
        return;
    L46:
        e = move-exception;
        e.printStackTrace();
        return;
    L53:
        return;
    }
}
