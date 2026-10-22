package com.bytedance.ies.bullet.prefetchv2;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f247601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f247602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f247603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f247604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f247605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f247606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f247607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f247608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteArrayOutputStream f247609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f247610j;

    public final boolean a() {
        Long r100 = this.f247605e;
        Long r101 = this.f247606f;
        Long r102 = this.f247604d;
        if (r102 == null) goto L22;
        long r103 = r102.longValue();
        if (r100 == null) goto L7;
        long r104 = r100.longValue();
    L8:
        long r105 = System.currentTimeMillis();
        if (((r105 - r104) - r103) <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r101 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r106 == true) goto L23;
        if (r107 == true) goto L24;
        return false;
    L24:
        return true;
    L23:
        return true;
    L14:
        if (r105 <= r101.longValue()) goto L16;
        r107 = true;
        goto L17
    L11:
        r106 = false;
        goto L12
    L7:
        r104 = 30000;
        goto L8
    L22:
        return true;
    }

    public v() {
        this.f247608h = "unknown";
    }
}
