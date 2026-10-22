package com.vivo.push.restructure.request.a;

import com.vivo.push.util.t;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<a> f462484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f462487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f462488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f462489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f462490g;

    static {
        f462484a = new b();
    }

    public final int a() {
        return this.f462486c;
    }

    public final int b() {
        return this.f462489f;
    }

    public final int c() {
        return this.f462490g;
    }

    public a(com.vivo.push.restructure.request.a.a.a r100) {
        this.f462485b = r100.c();     // Catch: JSONException -> L5
        this.f462486c = r100.a();     // Catch: JSONException -> L5
        this.f462488e = r100.b();     // Catch: JSONException -> L5
        this.f462489f = r100.a();     // Catch: JSONException -> L5
        this.f462487d = r100.a();     // Catch: JSONException -> L5
        this.f462490g = r100.a();     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        t.a("CFToClientDS", e);
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a r100) {
        r100.a(this.f462485b);
        r100.a(this.f462486c);
        r100.a(this.f462488e);
        r100.a(this.f462489f);
        r100.a(this.f462487d);
        r100.a(this.f462490g);
    }
}
