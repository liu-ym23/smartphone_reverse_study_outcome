package com.cmic.sso.sdk;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f273271a;

    public com.cmic.sso.sdk.d.a a() {
        com.cmic.sso.sdk.d.a r100 = (com.cmic.sso.sdk.d.a) this.f273271a.get("logBean");
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new com.cmic.sso.sdk.d.a();
    }

    public com.cmic.sso.sdk.a.a b() {
        com.cmic.sso.sdk.a.a r100 = (com.cmic.sso.sdk.a.a) this.f273271a.get("current_config");
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.cmic.sso.sdk.e.c.a("UmcConfigBean为空", "请核查");
        return new com.cmic.sso.sdk.a.a.C3819a().a();
    }

    public a(int r100) {
        this.f273271a = new ConcurrentHashMap(r100);
    }

    public byte[] a(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return (byte[]) this.f273271a.get(r100);
    }

    public String b(String r100) {
        return b(r100, "");
    }

    public int c(String r100) {
        return b(r100, 0);
    }

    public void a(com.cmic.sso.sdk.a.a r100) {
        if (r100 == null) goto L5;
        this.f273271a.put("current_config", r100);
        return;
    }

    public void a(com.cmic.sso.sdk.d.a r100) {
        if (r100 == null) goto L5;
        this.f273271a.put("logBean", r100);
        return;
    }

    public void a(String r100, int r101) {
        if (r100 == null) goto L5;
        this.f273271a.put(r100, Integer.valueOf(r101));
        return;
    }

    public int b(String r100, int r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273271a.containsKey(r100) == false) goto L7;
        return ((Integer) this.f273271a.get(r100)).intValue();
    }

    public void a(String r100, long r101) {
        if (r100 == null) goto L5;
        this.f273271a.put(r100, Long.valueOf(r101));
        return;
    }

    public long b(String r100, long r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273271a.containsKey(r100) == false) goto L7;
        return ((Long) this.f273271a.get(r100)).longValue();
    }

    public void a(String r100, boolean r101) {
        if (r100 == null) goto L5;
        this.f273271a.put(r100, Boolean.valueOf(r101));
        return;
    }

    public boolean b(String r100, boolean r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273271a.containsKey(r100) == false) goto L7;
        return ((Boolean) this.f273271a.get(r100)).booleanValue();
    }

    public void a(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.f273271a.put(r100, r101);
        return;
    L7:
        return;
    }

    public String b(String r100, String r101) {
        if (r100 != null) goto L4;
    L7:
        return r101;
    L4:
        if (this.f273271a.containsKey(r100) == false) goto L7;
        return (String) this.f273271a.get(r100);
    }

    public void a(String r100, byte[] r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.f273271a.put(r100, r101);
        return;
    L7:
        return;
    }
}
