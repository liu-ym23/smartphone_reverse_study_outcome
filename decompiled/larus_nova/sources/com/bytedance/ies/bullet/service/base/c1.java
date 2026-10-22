package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f247792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f247793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f247794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f247795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f247796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f247797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f247798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f247799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f247800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a36.c f247801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f247802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f247803m;

    public static final class a {
    }

    static {
    }

    public c1(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 32) == 0) goto L14;
        Boolean r106 = Boolean.FALSE;
    L16:
        if ((r105 & 128) == 0) goto L18;
        r104 = null;
    L18:
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f247791a = r100;
        this.f247792b = r101;
        this.f247793c = null;
        this.f247794d = r102;
        this.f247795e = r103;
        this.f247796f = r106;
        this.f247797g = null;
        this.f247798h = r104;
        return;
    L14:
        r106 = null;
        goto L16
    }
}
