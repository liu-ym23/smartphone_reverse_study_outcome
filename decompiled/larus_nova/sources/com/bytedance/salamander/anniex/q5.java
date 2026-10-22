package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f268323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f268324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f268325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f268326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f268327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f268328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f268329h;

    public q5(String r100, Integer r101, String r102, String r103, String r104, JSONObject r105, JSONObject r106, JSONObject r107) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f268322a = "";
        this.f268324c = r102;
        this.f268322a = r100;
        this.f268325d = r103;
        this.f268326e = r104;
        this.f268327f = r105;
        this.f268328g = r106;
        this.f268329h = r107;
        if (r101 == null) goto L5;
        int r108 = r101.intValue();
    L6:
        this.f268323b = r108;
        return;
    L5:
        r108 = 2;
        goto L6
    }
}
