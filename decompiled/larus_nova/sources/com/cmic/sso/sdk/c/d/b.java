package com.cmic.sso.sdk.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f273458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, List<String>> f273459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273460c;

    public Map<String, List<String>> b() {
        Map<String, List<String>> r100 = this.f273459b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }

    public String c() {
        String r100 = this.f273460c;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean d() {
        int r100 = this.f273458a;
        if (r100 != 302) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 301) goto L8;
        return false;
    }

    public int a() {
        return this.f273458a;
    }

    public b(int r100, Map<String, List<String>> r101, String r102) {
        this.f273458a = r100;
        this.f273459b = r101;
        this.f273460c = r102;
    }
}
