package com.bytedance.ee.bear.widgets.tagview;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TagValue implements NonProguard {
    public Map<String, String> i18nValue;
    public String value;

    public TagValue() {
    }

    public static TagValue parseTagValue(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        TagValue r0 = new TagValue();
        r0.value = r5.optString("value");
        JSONObject r6 = r5.optJSONObject("i18n_value");
        if (r6 == null) goto L12;
        Iterator<String> r1 = r6.keys();
        HashMap r2 = new HashMap();
    L9:
        if (r1.hasNext() == false) goto L11;
        String r3 = r1.next();
        r2.put(r3, r6.optString(r3));
        goto L9
    L11:
        r0.i18nValue = r2;
    L12:
        return r0;
    }

    public String getI18TagValue(Locale r3) {
        if (r3 != null) goto L4;
    L6:
        String r4 = null;
    L8:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        r4 = this.value;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return "";
    L15:
        return r4;
    L4:
        if (this.i18nValue == null) goto L6;
        r4 = this.i18nValue.get(r3.getLanguage() + "_" + r3.getCountry().toLowerCase());
        goto L8
    }
}
