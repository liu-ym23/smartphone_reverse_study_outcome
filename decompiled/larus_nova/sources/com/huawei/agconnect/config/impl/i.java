package com.huawei.agconnect.config.impl;

import androidx.camera.core.processing.util.GLUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.huawei.agconnect.config.ConfigReader;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class i implements ConfigReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f276736a;

    public i(InputStream r100, String r101) {
        this.f276736a = a(r100);
        a(r101);
    }

    private JSONObject a(InputStream r100) {
        if (r100 == null) goto L6;
        return new JSONObject(Utils.toString(r100, "UTF-8"));
    L6:
        return new JSONObject();
    }

    private void a(String r100) {
        JSONObject r101 = b(r100);     // Catch: JSONException -> L22
        if (r101 != null) goto L6;
        return;
    L6:
        String r102 = getString("/configuration_version", "");     // Catch: JSONException -> L22
        BigDecimal r103 = new BigDecimal(GLUtils.VERSION_UNKNOWN);     // Catch: JSONException -> L22
        r103 = BigDecimal.valueOf(CastDoubleProtector.parseDouble(r102));     // Catch: NumberFormatException -> L21 JSONException -> L22
    L9:
        if (r103.compareTo(new BigDecimal(EventConstant.Value.AUTH_VERSION_2)) != 0) goto L12;
        JSONObjectProtectorUtils.getJSONObject(this.f276736a, "client").put("app_id", JSONObjectProtectorUtils.getString(r101, "app_id"));     // Catch: JSONException -> L22
        return;
    L12:
        if (r103.compareTo(new BigDecimal("3.0")) < 0) goto L31;
        Iterator<String> r104 = r101.keys();     // Catch: JSONException -> L22
    L15:
        if (r104.hasNext() == false) goto L33;
        String r105 = r104.next();     // Catch: JSONException -> L22
        if ("package_name".equals(r105) == true) goto L15;
        a(r105, r101.get(r105), this.f276736a);     // Catch: JSONException -> L22
        goto L15
    L33:
        return;
    L31:
        return;
    }

    private void a(String r100, Object r101, JSONObject r102) throws JSONException {
        if (r100 == null) goto L15;
        if (r101 == null) goto L16;
        if (r102 != null) goto L7;
        return;
    L7:
        if ((r101 instanceof JSONObject) == false) goto L12;
        JSONObject r103 = (JSONObject) r101;
        Iterator<String> r104 = r103.keys();
    L10:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        a(r105, r103.get(r105), JSONObjectProtectorUtils.getJSONObject(r102, r100));
        goto L10
    L18:
        return;
    L12:
        r102.put(r100, r101);
        return;
    L16:
        return;
    }

    private JSONObject b(String r100) throws JSONException {
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(this.f276736a, "appInfos");
        int r102 = 0;
    L4:
        if (r102 >= r101.length()) goto L9;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);
        if (JSONObjectProtectorUtils.getString(r103, "package_name").equals(r100) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return r103;
    L9:
        return null;
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String r100, String r101) {
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L5;
        return r101;
    L5:
        String[] r102 = r100.split(HTTP.URL_DEFAULT);
        JSONObject r103 = this.f276736a;     // Catch: JSONException -> L15
        int r104 = 1;
    L8:
        if (r104 >= r102.length) goto L16;
        if (r104 == (r102.length - 1)) goto L11;
        r103 = JSONObjectProtectorUtils.getJSONObject(r103, r102[r104]);     // Catch: JSONException -> L15
        r104 = r104 + 1;
        goto L8
    L11:
        return r103.get(r102[r104]).toString();
    L16:
        return r101;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f276736a.toString().hashCode() + '}';
    }
}
