package com.bytedance.awemeopen.appserviceimpl.user;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f198152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k34.a f198153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f198154c;

    static {
        f198152a = new a();
    }

    public a() {
    }

    public final Map<String, String> b() {
        k34.a r100 = f198153b;
        if (r100 == null) goto L6;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("host_enter_from", r100.f501714a);
        r101.put("enter_from", r100.f501715b);
        r101.put("video_id", r100.f501716c);
        r101.put("req_id", r100.f501717d);
        r101.put("source", f198154c);
        return r101;
    L6:
        return null;
    }

    public final void a(String r100) {
        if (r100 == null) goto L11;
        k34.a r101 = f198153b;
        if (r101 == null) goto L6;
        String r102 = r101.f501716c;
    L8:
        if (Intrinsics.areEqual(r100, r102) == false) goto L12;
        f198153b = null;
        f198154c = null;
        return;
    L12:
        return;
    L6:
        r102 = null;
        goto L8
    }

    public final void c(k34.a r100) {
        f198153b = r100;
        f198154c = null;
    }
}
