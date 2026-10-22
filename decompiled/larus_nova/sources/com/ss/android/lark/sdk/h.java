package com.ss.android.lark.sdk;

import com.bytedance.lark.pb.basic.v1.RequestPacket;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f439876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f439877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f439878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RequestPacket.TrafficType f439879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f439880e;

    public h() {
    }

    public final Map<String, String> a(Boolean r100) {
        if (r100 != null) goto L6;
        return this.f439880e;
    L6:
        if (this.f439880e != null) goto L8;
        HashMap r101 = new HashMap();
    L10:
        if (r100.booleanValue() == false) goto L12;
        String r102 = "1";
    L13:
        r101.put("t", r102);
        return r101;
    L12:
        r102 = "0";
        goto L13
    L8:
        r101 = new HashMap(this.f439880e);
        goto L10
    }
}
