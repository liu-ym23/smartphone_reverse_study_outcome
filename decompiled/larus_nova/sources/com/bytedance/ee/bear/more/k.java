package com.bytedance.ee.bear.more;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k {
    public static boolean a(String r100) {
        String r101 = (String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("more_new_items", SliceInitService.DEFAULT_SWITCH);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return true;
    L10:
        return new JSONObject(r101).optBoolean(r100, true);
    L7:
        e = move-exception;
        tt5.a.e("MoreNewItemUtils", "getNewSwitch() error", e, false);
        return true;
    }

    public static boolean b(String r100) {
        return ((Boolean) new ml5.b("moreNewItems").a(r100, Boolean.FALSE)).booleanValue();
    }
}
