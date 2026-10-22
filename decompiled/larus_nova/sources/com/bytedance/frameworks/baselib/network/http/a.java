package com.bytedance.frameworks.baselib.network.http;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BaseRequestContext.c> f244673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C3501a> f244674b;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes19.dex */
    public static class C3501a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f244675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f244677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f244678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f244679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f244680f;

        public C3501a(String r100, String r101, int r102, long r103, long r104, boolean r105) {
            this.f244675a = r100;
            this.f244676b = r101;
            this.f244677c = r102;
            this.f244678d = r103;
            this.f244679e = r104;
            this.f244680f = r105;
        }
    }

    public final JSONObject a() {
        if (((CopyOnWriteArrayList) this.f244674b).isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r100 = new JSONObject();
        Iterator r101 = ((CopyOnWriteArrayList) this.f244674b).iterator();     // Catch: JSONException -> L13
    L9:
        if (r101.hasNext() == false) goto L12;
        C3501a r102 = (C3501a) r101.next();     // Catch: JSONException -> L13
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L13
        r103.put("callback_duration", r102.f244678d);     // Catch: JSONException -> L13
        r103.put(ComplianceResult.JsonKey.REQUEST_DURATION, r102.f244679e);     // Catch: JSONException -> L13
        r103.put("code", r102.f244677c);     // Catch: JSONException -> L13
        r100.put(r102.f244675a + r102.f244676b, r103);     // Catch: JSONException -> L13
    L12:
        return r100;
    }

    public a(List<BaseRequestContext.c> r100) {
        ArrayList r101 = new ArrayList();
        this.f244673a = r101;
        this.f244674b = new CopyOnWriteArrayList();
        if (r100.isEmpty() == true) goto L7;
        r101.addAll(r100);
        return;
    }
}
