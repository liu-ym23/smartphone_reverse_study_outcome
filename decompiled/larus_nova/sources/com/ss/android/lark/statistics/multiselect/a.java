package com.ss.android.lark.statistics.multiselect;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f440735a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.statistics.multiselect.a$a, reason: collision with other inner class name */
    public static final class C5293a {
        public static JSONObject a(boolean r100) {
            JSONObject r101 = new JSONObject();
            if (r100 == false) goto L5;
            String r102 = "true";
        L7:
            return r101.put("followingmessage", r102);
        L5:
            r102 = "false";
            goto L7
        }
    }

    static {
    }
}
