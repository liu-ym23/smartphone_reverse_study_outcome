package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f277493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277494b;

    public ag() {
    }

    public Integer a() {
        return this.f277493a;
    }

    public String b() {
        return this.f277494b;
    }

    public static ag b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L15
        String r102 = null;
        if (r101.has("errorCode") == false) goto L9;
        Integer r103 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r101, "errorCode"));     // Catch: JSONException -> L15
    L11:
        if (r101.has("errorMsg") == false) goto L13;
        r102 = JSONObjectProtectorUtils.getString(r101, "errorMsg");     // Catch: JSONException -> L15
    L13:
        ag r104 = new ag();     // Catch: JSONException -> L15
        r104.a(r103);     // Catch: JSONException -> L15
        r104.a(r102);     // Catch: JSONException -> L15
        return r104;
    L9:
        r103 = null;
    L15:
        as.d("ReadSmsOutputBean", "ReadSmsOutputBean json parse falied", true);
        return new ag();
    L5:
        return new ag();
    }

    public void a(Integer r100) {
        this.f277493a = r100;
    }

    public void a(String r100) {
        this.f277494b = r100;
    }
}
