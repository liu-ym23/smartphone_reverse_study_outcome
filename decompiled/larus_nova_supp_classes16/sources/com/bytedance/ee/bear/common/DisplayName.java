package com.bytedance.ee.bear.common;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import hu5.a;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DisplayName implements NonProguard {
    private HashMap<String, String> i18n_value;
    private String value;

    public static class I18n implements NonProguard {
        private String en_us;
        private String ja_jp;
        private String zh_cn;

        public I18n() {
        }

        public String toString() {
            return "I18n{zh_cn is Empty:" + TextUtils.isEmpty(this.zh_cn) + ", ja_jp is Empty:" + TextUtils.isEmpty(this.ja_jp) + ", en_us is Empty:" + TextUtils.isEmpty(this.en_us) + '}';
        }

        public String getEn_us() {
            return this.en_us;
        }

        public String getJa_jp() {
            return this.ja_jp;
        }

        public String getZh_cn() {
            return this.zh_cn;
        }

        public void setEn_us(String r1) {
            this.en_us = r1;
        }

        public void setJa_jp(String r1) {
            this.ja_jp = r1;
        }

        public void setZh_cn(String r1) {
            this.zh_cn = r1;
        }
    }

    public DisplayName() {
    }

    public String toString() {
        return "DisplayName{value is Empty:" + TextUtils.isEmpty(this.value) + ", i18n_value_isEmpty=" + a.e(this.i18n_value) + '}';
    }

    public HashMap<String, String> getI18n_value() {
        return this.i18n_value;
    }

    public String getValue() {
        return this.value;
    }

    public static DisplayName parseDisplayName(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        DisplayName r0 = new DisplayName();
        r0.setValue(r5.optString("value"));
        JSONObject r6 = r5.optJSONObject("i18n_value");
        if (r6 == null) goto L12;
        HashMap<String, String> r1 = new HashMap();
        Iterator<String> r2 = r6.keys();
    L9:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        r1.put(r3, r6.optString(r3));
        goto L9
    L11:
        r0.setI18n_value(r1);
    L12:
        return r0;
    }

    public void setI18n_value(HashMap<String, String> r1) {
        this.i18n_value = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }
}
