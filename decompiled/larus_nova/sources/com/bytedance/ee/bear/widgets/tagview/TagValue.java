package com.bytedance.ee.bear.widgets.tagview;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class TagValue implements NonProguard {
    public Map<String, String> i18nValue;
    public String value;

    public TagValue() {
    }

    public static TagValue parseTagValue(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TagValue r101 = new TagValue();
        r101.value = r100.optString("value");
        JSONObject r102 = r100.optJSONObject("i18n_value");
        if (r102 == null) goto L12;
        Iterator<String> r103 = r102.keys();
        HashMap r104 = new HashMap();
    L9:
        if (r103.hasNext() == false) goto L11;
        String r105 = r103.next();
        r104.put(r105, r102.optString(r105));
        goto L9
    L11:
        r101.i18nValue = r104;
    L12:
        return r101;
    }

    public String getI18TagValue(Locale r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = null;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = this.value;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return "";
    L15:
        return r101;
    L4:
        if (this.i18nValue == null) goto L6;
        r101 = this.i18nValue.get(r100.getLanguage() + "_" + r100.getCountry().toLowerCase());
        goto L8
    }
}
