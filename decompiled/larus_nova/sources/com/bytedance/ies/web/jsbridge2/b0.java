package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f249312a;

    public final String b() {
        JSONObject r100 = new JSONObject();
        Iterator r101 = ((ConcurrentHashMap) this.f249312a).entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: JSONException -> L9
        r100.put((String) r102.getKey(), r102.getValue());     // Catch: JSONException -> L9
        goto L5
    L7:
        return r100.toString();
    L9:
        return "";
    }

    public b0() {
        this.f249312a = new ConcurrentHashMap();
    }

    public final void a(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) this.f249312a).put(r100, r101);
        return;
    L9:
        return;
    }
}
