package com.bytedance.ee.bear.document.persistence;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class JsPreference implements BaseJSModel {
    private String key;
    private String value;

    public JsPreference() {
    }

    public String toString() {
        return "JsPreference{key='" + this.key + "', value='" + this.value + "'}";
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }
}
