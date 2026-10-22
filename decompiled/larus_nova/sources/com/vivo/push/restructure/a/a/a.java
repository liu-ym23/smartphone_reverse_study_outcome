package com.vivo.push.restructure.a.a;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.vivo.push.util.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f462444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f462446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f462447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f462448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f462449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f462450g;

    public abstract int a(T r100);

    public synchronized String b() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L11
        r100.put("name", this.f462445b);     // Catch: Exception -> L6 Throwable -> L11
        r100.put("code", this.f462447d);     // Catch: Exception -> L6 Throwable -> L11
        r100.put(ChameleonOpenTracker.ParamKey.COST, this.f462446c);     // Catch: Exception -> L6 Throwable -> L11
    L8:
        String r101 = r100.toString();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L6:
        e = move-exception;
        t.a("AbstractMessageNodeMoni", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (this.f462449f == false) goto L6;
        com.vivo.push.util.g.a().execute(new b(this));
        return;
    L6:
        d();
    }

    public final JSONArray c() {
        JSONArray r100 = new JSONArray();
        a<T> r101 = this;
    L3:
        if (r101 == null) goto L8;
        r100.put(r101.b());     // Catch: Exception -> L6
        r101 = r101.f462450g;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        t.a("AbstractMessageNodeMoni", e);
    L8:
        return r100;
    }

    private void d() {
        long r100 = System.currentTimeMillis();
        this.f462447d = a(this.f462444a);
        this.f462446c = System.currentTimeMillis() - r100;
        int r101 = this.f462447d;
        if (r101 == 0) goto L8;
        i r102 = this.f462448e;
        if (r102 == null) goto L16;
        r102.a(this, this.f462444a, r101);
        return;
    L16:
        return;
    L8:
        a r103 = this.f462450g;
        if (r103 == null) goto L12;
        r103.a();
        return;
    L12:
        i r104 = this.f462448e;
        if (r104 == null) goto L17;
        r104.a(this.f462444a);
        return;
    }

    public static /* synthetic */ void b(a r100) {
        r100.d();
    }

    public final void a(a r100) {
        if (this == r100) goto L5;
        this.f462450g = r100;
        return;
    }

    public final void a(long r100) {
        this.f462446c = r100;
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Lcom/vivo/push/restructure/a/a/i;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, com.vivo.push.restructure.a.a r101, j r102) {
        this.f462446c = -1;
        this.f462447d = -1;
        this.f462449f = false;
        this.f462445b = r100;
        this.f462444a = r101;
        this.f462448e = r102;
    }
}
