package com.bytedance.ug.sdk.luckycat.impl.model;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements c96.b {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    public static FormUrlEncodedTypedOutput a(JSONObject r100) {
        FormUrlEncodedTypedOutput r101 = new FormUrlEncodedTypedOutput();
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L20
        if (r102 == null) goto L22;
    L5:
        if (r102.hasNext() == false) goto L22;
        String r103 = r102.next();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r103) == true) goto L5;
        Object r104 = r100.opt(r103);     // Catch: Throwable -> L20
        if (r104 == null) goto L12;
        if ((r104 instanceof Double) == true) goto L16;
    L18:
        r101.addField(r103, r104.toString());     // Catch: Throwable -> L20
        goto L5
    L16:
        if (Double.compare(((Number) r104).doubleValue(), (int) ((Number) r104).doubleValue()) != 0) goto L18;
        r104 = Integer.valueOf((int) ((Number) r104).doubleValue());     // Catch: Throwable -> L20
        goto L18
    L12:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.a("SettingsNetworkConfig", "key " + r103 + " value is null");     // Catch: Throwable -> L20
    L22:
        return r101;
    L20:
        th = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("SettingsNetworkConfig", th.getMessage());
        goto L22
    }
}
