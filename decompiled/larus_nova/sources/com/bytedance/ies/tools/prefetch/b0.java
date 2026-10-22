package com.bytedance.ies.tools.prefetch;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c0> f248792a;

    public b0(JSONObject r100) throws JSONException {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, new c0(r103, JSONObjectProtectorUtils.getJSONObject(r100, r103)));
        goto L4
    L6:
        this.f248792a = r101;
    }
}
