package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoAdRef {
    public static final int TYPE_PATCH_BEGIN = 1;
    public static final int TYPE_PATCH_END = 2;
    public static final int TYPE_PATCH_MAIN = 3;
    public List<String> action_track_url_list;
    public int duration;
    public String external_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public long f457116id;
    public String log_extra;
    public VideoInfo mVideo1;
    public VideoInfo mVideo2;
    public VideoInfo mVideo3;
    public int patch_position;
    public List<String> play_track_url_list;
    public List<String> playover_track_url_list;
    public int skip_time;

    public VideoAdRef() {
    }

    public void extractFields(JSONObject r100) {
        this.f457116id = r100.optLong("id");
        this.log_extra = r100.optString("log_extra");
        this.skip_time = r100.optInt("skip_time");
        this.patch_position = r100.optInt("patch_position");
        this.duration = r100.optInt("duration");
        this.external_url = r100.optString("external_url");
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "play_track_url_list");     // Catch: JSONException -> L13
        if (r101 == null) goto L20;
        this.play_track_url_list = parseTrackUrl(r101, new String[1]);     // Catch: JSONException -> L13
    L20:
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r100, "playover_track_url_list");     // Catch: JSONException -> L14
        if (r102 == null) goto L18;
        this.playover_track_url_list = parseTrackUrl(r102, new String[1]);     // Catch: JSONException -> L14
    L18:
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r100, "action_track_url_list");     // Catch: JSONException -> L15
        if (r103 == null) goto L22;
        this.action_track_url_list = parseTrackUrl(r103, new String[1]);     // Catch: JSONException -> L15
        return;
    L22:
        return;
    }

    public static List<String> parseTrackUrl(Object r100, String[] r101) {
        if (r101 != null) goto L5;
    L7:
        if (r100 != null) goto L38;
        return null;
    L38:
        if ((r100 instanceof String) == false) goto L18;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L37
        String r103 = (String) r100;     // Catch: Exception -> L37
        r102.add(r103);     // Catch: Exception -> L37
        if (r101 != null) goto L14;
    L16:
        return r102;
    L14:
        if (r101.length <= 0) goto L16;
        r101[0] = r103;     // Catch: Exception -> L37
        goto L16
    L18:
        if ((r100 instanceof JSONArray) == false) goto L36;
        JSONArray r104 = (JSONArray) r100;     // Catch: Exception -> L37
        int r105 = r104.length();     // Catch: Exception -> L37
        if (r105 != 0) goto L22;
        return null;
    L22:
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L37
        int r107 = 0;
    L23:
        if (r107 >= r105) goto L29;
        String r108 = JSONArrayProtectorUtils.getString(r104, r107);     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r108) == true) goto L27;
        r106.add(r108);     // Catch: Exception -> L37
    L27:
        r107 = r107 + 1;     // Catch: Exception -> L37
        goto L23
    L29:
        if (r106.isEmpty() == false) goto L31;
        return null;
    L31:
        if (r101 != null) goto L33;
    L35:
        return r106;
    L33:
        if (r101.length <= 0) goto L35;
        r101[0] = r104.toString();     // Catch: Exception -> L37
    L36:
        return null;
    L5:
        if (r101.length <= 0) goto L7;
        r101[0] = null;
        goto L7
    }
}
