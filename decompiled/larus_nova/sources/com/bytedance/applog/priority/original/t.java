package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f192799c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f192800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONArray f192801b;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("version", this.f192800a);
        JSONArray r101 = this.f192801b;
        if (r101 == null) goto L5;
        r100.put("config_ids", r101);
    L5:
        return r100;
    }

    public final JSONObject b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JSONObject r101 = new JSONObject();
        r101.put("version", this.f192800a);
        r101.put("value", r100);
        JSONArray r102 = this.f192801b;
        if (r102 == null) goto L5;
        r101.put("config_ids", r102);
    L5:
        return r101;
    }

    public t(int r100, JSONArray r101) {
        this.f192800a = r100;
        this.f192801b = r101;
    }
}
