package com.ss.android.lark.contact.base.statistics;

import com.alipay.sdk.m.p.e;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class InvHitPoint extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f418948a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareMethod {
        public static final String COPY_LINK = "copy_link";
        public static final String INVITE_EMAIL = "invite_email";
        public static final String INVITE_MESSAGE = "invite_message";
        public static final String SAVE_QR_CODE = "save_qr_code";
        public static final String SHARE_LINK = "share_link";
        public static final String SHARE_QR_CODE = "share_qr_code";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareType {
        public static final String LINK = "link";
        public static final String QR_CODE = "qr_code";
    }

    public static JSONObject a() {
        return b(f418948a);
    }

    public static JSONObject b(String r100) {
        f418948a = r100;     // Catch: JSONException -> L4
        return new JSONObject().put("source", r100);
    L4:
        e = move-exception;
        Log.e("InvHitPoint", e);
        return new JSONObject();
    }

    public static void d(boolean r100) {
        JSONObject r101 = a();     // Catch: JSONException -> L8
        if (r100 == false) goto L5;
        int r102 = 1;
    L6:
        Statistics.sendEvent("invite_people_external_search_invite_cancel", r101.put("change_to", r102));     // Catch: JSONException -> L8
        return;
    L5:
        r102 = 0;
    L8:
        e = move-exception;
        Log.e("InvHitPoint", e.getMessage());
    }

    public static void e(boolean r100) {
        JSONObject r101 = a();     // Catch: JSONException -> L8
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        Statistics.sendEvent("invite_people_external_search_invite_send", r101.put("result", r102));     // Catch: JSONException -> L8
        return;
    L5:
        r102 = "0";
    L8:
        e = move-exception;
        Log.e("InvHitPoint", e.getMessage());
    }

    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("type", "link");     // Catch: JSONException -> L5
        r102.put(e.f25671s, r100);     // Catch: JSONException -> L5
        r102.put(BdpAppEventConstant.PARAMS_UNIQUEID, r101);     // Catch: JSONException -> L5
        r102.put("platform", "android");     // Catch: JSONException -> L5
        Statistics.sendEvent("invite_people_h5_share", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InvHitPoint", "failed to invitePeopleH5Share, e:" + e);
    }
}
