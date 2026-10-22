package com.ss.android.ad.applinksdk.interceptor.url;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f406376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f406377b;

    public c(String r100) {
        this.f406376a = CollectionsKt.emptyList();
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        if ((true ^ Intrinsics.areEqual("null", r100)) == false) goto L28;
        JSONObject r103 = new JSONObject(r100);
        JSONArray r104 = r103.optJSONArray("interceptor_blocklist");     // Catch: Exception -> L21
        if (r104 == null) goto L19;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L21
        int r106 = r104.length();     // Catch: Exception -> L21
    L16:
        if (r101 >= r106) goto L18;
        r105.add(JSONArrayProtectorUtils.getString(r104, r101));     // Catch: Exception -> L21
        r101 = r101 + 1;     // Catch: Exception -> L21
        goto L16
    L18:
        this.f406376a = CollectionsKt.toList(r105);     // Catch: Exception -> L21
    L19:
        this.f406377b = r103.optBoolean("auto_jump_intercept");     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        MonitorUtils.b(e, "InterceptStrategyModel fromJson");
        return;
    L28:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
