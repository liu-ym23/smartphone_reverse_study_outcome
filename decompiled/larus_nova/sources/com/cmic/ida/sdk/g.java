package com.cmic.ida.sdk;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f273120a;

    public s a() {
        s r100 = (s) this.f273120a.get("logBean");
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new s();
    }

    public g(int r100) {
        this.f273120a = new ConcurrentHashMap(r100);
    }

    public void a(s r100) {
        if (r100 == null) goto L5;
        this.f273120a.put("logBean", r100);
        return;
    }

    public String b(String r100) {
        return a(r100, "");
    }

    public int a(String r100) {
        return a(r100, 0);
    }

    public int a(String r100, int r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273120a.containsKey(r100) == false) goto L7;
        return ((Integer) this.f273120a.get(r100)).intValue();
    }

    public void b(String r100, int r101) {
        if (r100 == null) goto L5;
        this.f273120a.put(r100, Integer.valueOf(r101));
        return;
    }

    public long a(String r100, long r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273120a.containsKey(r100) == false) goto L7;
        return ((Long) this.f273120a.get(r100)).longValue();
    }

    public void b(String r100, long r101) {
        if (r100 == null) goto L5;
        this.f273120a.put(r100, Long.valueOf(r101));
        return;
    }

    public boolean a(String r100, boolean r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273120a.containsKey(r100) == false) goto L7;
        return ((Boolean) this.f273120a.get(r100)).booleanValue();
    }

    public void b(String r100, boolean r101) {
        if (r100 == null) goto L5;
        this.f273120a.put(r100, Boolean.valueOf(r101));
        return;
    }

    public String a(String r100, String r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273120a.containsKey(r100) == false) goto L7;
        return (String) this.f273120a.get(r100);
    }

    public void b(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.f273120a.put(r100, r101);
        return;
    L7:
        return;
    }
}
