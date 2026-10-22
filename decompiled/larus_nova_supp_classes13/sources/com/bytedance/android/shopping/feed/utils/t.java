package com.bytedance.android.shopping.feed.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public static boolean a;
    public static int b;

    static {
    }

    public static s a(String r7) {
        if (r7 != null) goto L22;
        return null;
    L22:
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r7), "membership");     // Catch: Exception -> L21
        if (r8 == null) goto L20;
        int r1 = r8.optInt("membership_status");     // Catch: Exception -> L21
        String r2 = r8.optString("button_text");     // Catch: Exception -> L21
        String r3 = r8.optString("join_member_url");     // Catch: Exception -> L21
        String r9 = JSONObjectProtectorUtils.getString(r8, "default_text");     // Catch: Exception -> L21
        if (r1 <= 0) goto L20;
        boolean r5 = false;
        if (r2.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L20;
        if (r3.length() <= 0) goto L17;
        r5 = true;
    L17:
        if (r5 == false) goto L20;
        return new s(r1, r2, r3, r9);
    L12:
        r4 = false;
    L20:
        return null;
    }
}
