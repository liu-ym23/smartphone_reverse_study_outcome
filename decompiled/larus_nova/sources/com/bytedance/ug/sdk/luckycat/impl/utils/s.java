package com.bytedance.ug.sdk.luckycat.impl.utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class s {
    public static boolean a(JSONObject r100) {
        if (r100.optInt("err_no", -1) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
