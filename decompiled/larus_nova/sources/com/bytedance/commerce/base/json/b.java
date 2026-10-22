package com.bytedance.commerce.base.json;

import com.bytedance.android.ec.slice.SliceInitService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final JSONObject a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = SliceInitService.DEFAULT_SWITCH;
    L9:
        return new JSONObject(r100);
    L5:
        r101 = false;
        goto L6
    }
}
