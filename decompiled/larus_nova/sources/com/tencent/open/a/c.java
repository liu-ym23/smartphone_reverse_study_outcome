package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes29.dex */
class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f461683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f461684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f461685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f461686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f461687f;

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f461682a + "]\nresponseSize = " + this.f461683b + "\nrequestSize = " + this.f461684c + "\nresultCode = " + this.f461685d + "\nerrorMsg = " + this.f461686e;
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.f461682a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f461683b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f461684c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f461685d;
    }

    public c(HttpURLConnection r100, String r101, int r102, int r103, int r104, String r105) {
        this.f461682a = r101;
        this.f461683b = r102;
        this.f461684c = r103;
        this.f461685d = r104;
        this.f461686e = r105;
        this.f461687f = new HashMap();
        if (r100 == null) goto L8;
        Map<String, List<String>> r106 = r100.getHeaderFields();
        if (r106 == null) goto L9;
        this.f461687f.putAll(r106);
        return;
    L9:
        return;
    }
}
