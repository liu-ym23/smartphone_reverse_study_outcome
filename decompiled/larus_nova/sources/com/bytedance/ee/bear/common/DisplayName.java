package com.bytedance.ee.bear.common;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import hu5.a;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
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

        public void setEn_us(String r100) {
            this.en_us = r100;
        }

        public void setJa_jp(String r100) {
            this.ja_jp = r100;
        }

        public void setZh_cn(String r100) {
            this.zh_cn = r100;
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

    public static DisplayName parseDisplayName(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DisplayName r101 = new DisplayName();
        r101.setValue(r100.optString("value"));
        JSONObject r102 = r100.optJSONObject("i18n_value");
        if (r102 == null) goto L12;
        HashMap<String, String> r103 = new HashMap();
        Iterator<String> r104 = r102.keys();
    L9:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        r103.put(r105, r102.optString(r105));
        goto L9
    L11:
        r101.setI18n_value(r103);
    L12:
        return r101;
    }

    public void setI18n_value(HashMap<String, String> r100) {
        this.i18n_value = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }
}
