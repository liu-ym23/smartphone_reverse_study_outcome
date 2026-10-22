package com.bytedance.ee.bear.more;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static boolean a(String r4) {
        String r0 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("more_new_items", "{}");
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return true;
    L10:
        return new JSONObject(r0).optBoolean(r4, true);
    L7:
        e = move-exception;
        tt5.a.e("MoreNewItemUtils", "getNewSwitch() error", e, false);
        return true;
    }

    public static boolean b(String r2) {
        return ((Boolean) new ml5.b("moreNewItems").a(r2, Boolean.FALSE)).booleanValue();
    }
}
