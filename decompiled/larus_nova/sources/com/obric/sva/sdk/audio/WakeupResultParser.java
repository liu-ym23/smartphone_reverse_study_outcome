package com.obric.sva.sdk.audio;

import androidx.camera.video.AudioStats;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.sva.sdk.nonstream.KWSScore;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupResultParser;", "", "<init>", "()V", "TAG", "", "parse", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "Lcom/obric/sva/sdk/nonstream/KWSScore;", "result", "parseInternal", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupResultParser {
    public static final WakeupResultParser INSTANCE = null;
    private static final String TAG = "WakeupResultParser";

    static {
        INSTANCE = new WakeupResultParser();
    }

    private WakeupResultParser() {
    }

    @JvmStatic
    public static final void parse(KWSScore r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L18;
        LogUtils.w(TAG, "parse skipped: empty result", new Object[0]);
        return;
    L18:
        INSTANCE.parseInternal(r100, r101);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        LogUtils.w(TAG, "parse failed resultLen=" + r101.length() + " error=" + e.getClass().getSimpleName(), new Object[0]);
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L10
    }

    private final void parseInternal(KWSScore r110, String r111) {
        JSONObject r100 = new JSONObject(r111);
        JSONObject r112 = r100.optJSONObject("lp_kws");
        JSONObject r101 = r100.optJSONObject(WsConstants.KEY_SESSION_ID);
        if (r112 == null) goto L9;
        r110.setKws_result(r112.optBoolean("result", false));
        JSONArray r102 = r112.optJSONArray("scores");
        if (r102 == null) goto L7;
        r110.setKwsScoreStr(r102.toString());
    L8:
        r110.setFrames(r112.optInt("frames", -1));
        r110.setName(r112.optString("keywords", r112.optString("name", "NA")));
        r110.setKws_threshold((float) r112.optDouble("threshold", AudioStats.AUDIO_AMPLITUDE_NONE));
        goto L9
    L7:
        r110.setKwsScoreStr(r112.optString(com.bytedance.android.ec.core.event.a.KEY_SCORE, ""));
    L9:
        if (r101 == null) goto L11;
        r110.setSid_result(r101.optBoolean("result", !r101.optBoolean("enable_sid_verify", true)));
        r110.setSid_score(r101.optDouble(com.bytedance.android.ec.core.event.a.KEY_SCORE, -1.0d));
        r110.setSid_threshold((float) r101.optDouble("threshold", AudioStats.AUDIO_AMPLITUDE_NONE));
        r110.setSid_error_msg(r101.optString("error_msg", ""));
        r110.set_continue_wakeup(r101.optBoolean("is_continue_wakeup", false));
        r110.setEnv_status(r101.optInt("env_status", 0));
    L11:
        LogUtils.i(TAG, "parse new schema score=" + r110, new Object[0]);
    }
}
