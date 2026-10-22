package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class w0 implements g84.b, v0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f199807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k74.c f199808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f199809c;

    @Override // g84.b
    public final void a(u r100) {
    }

    @Override // g84.b
    public final void b(Account r100) {
    }

    @Override // g84.b
    public final void c(Map r100) {
    }

    @Override // g84.b
    public final boolean d(JSONObject r100) {
        return false;
    }

    @Override // g84.b
    public final boolean e() {
        return false;
    }

    @Override // g84.b
    public final u f() {
        return null;
    }

    @Override // g84.b
    public final void h(Context r100, Map r101, boolean r102) {
    }

    @Override // g84.b
    public final void i(u r100) {
    }

    @Override // g84.b
    public final void j(u r100, long r101, t0 r102) {
    }

    @Override // g84.b
    public final boolean k() {
        return false;
    }

    @Override // g84.b
    public final void start() {
    }

    @Override // g84.b
    public final n0 g() {
        n0 r100 = this.f199807a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // g84.b
    public final String getDid() {
        n0 r100 = this.f199807a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f199720a;
    }

    public w0(k r100) {
        this.f199809c = r100;
        t.a("OTHER PROCESS IMPL");
    }

    @Override // g84.b
    public final void l(n0 r100) {
        this.f199807a = r100;
    }

    @Override // g84.b
    public final void m(o0 r100, u r101) {
        r100.getContext();
        a1.a(r100.getContext()).b(r100.a(), "install_info", new u0(this));
        n.b(r100);
        g84.e.b(r.class, new o(r100), String.valueOf(r100.f199728a));
    }
}
