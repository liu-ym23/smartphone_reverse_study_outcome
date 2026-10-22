package com.bytedance.ies.web.jsbridge2;

import com.bytedance.android.ec.slice.SliceInitService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f249386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249387b;

    public l(q r100) {
        this.f249386a = r100;
    }

    public static void a(String r100) {
        if (r100.startsWith("{") == true) goto L5;
    L6:
        IllegalArgumentException r101 = new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(r100));
        if (m.f249390a == false) goto L10;
        throw r101;
    L10:
        return;
    L5:
        if (r100.endsWith(com.alipay.sdk.m.u.i.f25855d) == false) goto L6;
    }

    public final <T> String b(T r100) {
        if (r100 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L8;
    L11:
        String r101 = r100.toString();
    L12:
        a(r101);
        return r101;
    L8:
        if ((r100 instanceof JSONArray) == true) goto L11;
        r101 = this.f249386a.a(r100);
        goto L12
    }
}
