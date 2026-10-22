package com.bytedance.push.utils;

import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.push.PushBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    public static String b(String r100) {
        return new PushBody(new JSONObject(r100)).f266727p;
    L4:
        e = move-exception;
        f.e("OpenUrlUtils", e.getMessage());
        return "";
    }

    public static String a(PushNotificationButtonInfo r100, String r101) {
        if (r100 != null) goto L7;
        f.b("OpenUrlUtils", "buttonInfo is null");
        return b(r101);
    L7:
        if (r100.mButtonOpenUrl.isEmpty() == true) goto L11;
        f.b("OpenUrlUtils", "buttonInfo.open_url is not empty");
        return r100.mButtonOpenUrl;
    L11:
        if (r100.mButtonAction.equals("open_app") == false) goto L14;
        f.b("OpenUrlUtils", "buttonInfo.action is open_app");
        return b(r101);
    L14:
        f.b("OpenUrlUtils", "buttonInfo.open_url is empty, so open_url is empty");
        return r100.mButtonOpenUrl;
    }
}
