package com.ss.android.bytedcert.face;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FaceDetectFlow f407339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f407340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f407341c;

    public final void a(JSONObject r100) {
        JSONArray r101 = this.f407341c.optJSONArray("steps");     // Catch: JSONException -> L9
        if (r101 != null) goto L6;
        r101 = new JSONArray();     // Catch: JSONException -> L9
    L6:
        r101.put(r100);     // Catch: JSONException -> L9
        this.f407341c.put("steps", r101);     // Catch: JSONException -> L9
        this.f407341c.put("last_event_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L9
    L7:
        this.f407340b.edit().putString("face_flow_steps", this.f407341c.toString()).apply();
    }

    public a(Activity r100, FaceDetectFlow r110) {
        this.f407339a = r110;
        SharedPreferences r101 = r100.getSharedPreferences("face_detect_pref", 0);
        this.f407340b = r101;
        String r102 = r101.getString("face_flow_steps", null);
        if (r102 != null) goto L26;
    L8:
        JSONObject r103 = new JSONObject();
        this.f407341c = r103;
        osa.b r111 = this.f407339a.getCertInfo();     // Catch: JSONException -> L22
        r103.put("scene", r111.f526567a);     // Catch: JSONException -> L22
        r103.put("ticket", r111.f526568b);     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r111.f526570d) == true) goto L12;
        r103.put(BytedCertConstant.CertKey.FLOW, r111.f526570d);     // Catch: JSONException -> L22
    L12:
        a(b("page", "enter", null));
        Object r104 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.ENABLE_FACE_DETECTION_STEPS);
        if (r104 != null) goto L15;
    L18:
        JSONObject r105 = new JSONObject();
        r105.put(EventConstant.Value.RETRY, 0);     // Catch: JSONException -> L23
    L20:
        a(b(faceverify.w.BLOB_ELEM_TYPE_FACE, "start", r105));
        return;
    L15:
        if ((r104 instanceof Boolean) == true) goto L17;
        return;
    L17:
        if (((Boolean) r104).booleanValue() == true) goto L18;
        return;
    L26:
        JSONObject r106 = new JSONObject(r102);     // Catch: JSONException -> L6
        r106.put("finish_type", "abort");     // Catch: JSONException -> L6
        r110.onEvent("face_detection_page_finish", r106, true);     // Catch: JSONException -> L6
        CertLog.d("FaceDetectFlow", "on event: face_detection_page_finish, params: " + r106);     // Catch: JSONException -> L6
    L7:
        this.f407340b.edit().remove("face_flow_steps").apply();
    L6:
        CertLog.e("FaceDetectFlow", "face flow steps '" + r102 + "' is not a valid json string");
        goto L7
    }

    public static JSONObject b(String r100, String r101, JSONObject r102) {
        JSONObject r103 = new JSONObject();
        r103.put("biz", r100);     // Catch: JSONException -> L7
        r103.put("evt", r101);     // Catch: JSONException -> L7
        if (r102 == null) goto L6;
        r103.put("p", r102);     // Catch: JSONException -> L7
    L6:
        return r103;
    }
}
