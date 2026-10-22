package com.bytedance.applog.priority;

import com.bytedance.applog.priority.original.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class NativeLazyString {
    private final z<JSONObject> loader;

    public String getValue() {
        return ((JSONObject) this.loader.load()).toString();
    }

    public NativeLazyString(z<JSONObject> r1) {
        this.loader = r1;
    }
}
