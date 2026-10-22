package com.bytedance.apm.internal;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorManager;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements DoctorManager.ApmListener {
    public f() {
    }

    public final void onEvent(String r3, String r4) {
        a("onEvent key=" + r3, r4, false);
    }

    public static void a(String r9, String r10, boolean r11) {
        int r0 = (4000 - r9.length()) - 5;
        if (r10.length() > r0) goto L8;
        if (r11 == false) goto L6;
        b.a(new String[]{r9, " ".concat(r10)});
        return;
    L6:
        b.a(new String[]{r9, " ".concat(r10)});
        return;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= r10.length()) goto L19;
        int r6 = r1 + r0;
        if (r6 >= r10.length()) goto L14;
        String r2 = r10.substring(r1, r6);
    L15:
        if (r11 == false) goto L17;
        b.a(new String[]{r9, " " + r2});
    L18:
        r1 = r6;
        goto L10
    L17:
        b.a(new String[]{r9, " " + r2});
        goto L18
    L14:
        r2 = r10.substring(r1);
        goto L15
    }

    public final void onDataEvent(int r5, String r6, JSONObject r7) {
        if (TextUtils.equals(r6, "DATA_CACHE") == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r6, "DATA_SEND_END") == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r6, "DATA_SEND_RESPONSE") == false) goto L10;
        return;
    L10:
        if (TextUtils.equals(r6, "DATA_RECEIVE") == true) goto L12;
    L14:
        a("onDataEvent[" + r5 + "] " + r6 + " [service:" + r7.optString("service") + "|logType:" + r7.optString("log_type") + "] = ", r7.toString(), r6.contains("ERROR"));
        return;
    L12:
        if (r7.optJSONObject("DATA_DOCTOR").optBoolean("DATA_SAMPLE") == true) goto L14;
        r6 = "DATA_NOT_SAMPLED";
        goto L14
    }
}
