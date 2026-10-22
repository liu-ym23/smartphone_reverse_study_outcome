package com.huawei.hms.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class b {
    public static List<SubscribedItem> a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ArrayList r101 = new ArrayList();     // Catch: JSONException -> L12
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L12
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L12
    L8:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();     // Catch: JSONException -> L12
        int r105 = JSONObjectProtectorUtils.getInt(r102, r104);     // Catch: JSONException -> L12
        SubscribedItem r106 = new SubscribedItem();     // Catch: JSONException -> L12
        r106.setEntityId(r104);     // Catch: JSONException -> L12
        r106.setResultCode(r105);     // Catch: JSONException -> L12
        r101.add(r106);     // Catch: JSONException -> L12
        goto L8
    L11:
        return r101;
    L12:
        HMSLog.e("PushBaseUtils", "trans subscribedItem list occurs exception");
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }
}
