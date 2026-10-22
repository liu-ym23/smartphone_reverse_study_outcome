package com.bytedance.ee.bear.widgets.tagview;

import com.bytedance.ee.util.io.NonProguard;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class DisplayTagInfoV1 implements NonProguard {
    public String tag_value;

    public DisplayTagInfoV1() {
    }

    public static DisplayTagInfoV1 parseDisplayTagInfoV1(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DisplayTagInfoV1 r101 = new DisplayTagInfoV1();
        r101.tag_value = r100.optString("tag_value");
        return r101;
    }
}
