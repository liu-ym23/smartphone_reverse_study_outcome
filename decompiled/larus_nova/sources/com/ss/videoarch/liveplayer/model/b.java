package com.ss.videoarch.liveplayer.model;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f459551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f459552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveStreamInfo f459553c;

    public String getDefaultQualityKey() {
        return this.f459552b;
    }

    public String getDefaultQualityName() {
        return this.f459551a;
    }

    public LiveStreamInfo getLiveStreamInfo() {
        return this.f459553c;
    }

    public b(JSONObject r100) {
        if (r100 != null) goto L10;
        return;
    L10:
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r100, "options"), "default_quality");     // Catch: Exception -> L7
        this.f459551a = JSONObjectProtectorUtils.getString(r101, "name");     // Catch: Exception -> L7
        this.f459552b = JSONObjectProtectorUtils.getString(r101, "sdk_key");     // Catch: Exception -> L7
        this.f459553c = new LiveStreamInfo(new JSONObject(JSONObjectProtectorUtils.getString(r100, MiniAppConstants.KEY_MINI_APP_STREAM_DATA)));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
