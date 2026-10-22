package qm7;

import android.content.Context;
import android.text.TextUtils;
import rm7.h;
import rm7.i;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f533898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f533899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f533900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f533901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f533902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f533903f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f533904a = null;

        static {
            f533904a = new c();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        um7.e.b("cleanData() on call; mIsInit = " + this.f533898a);     // Catch: Throwable -> L11
        if (this.f533898a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f533901d = "";     // Catch: Throwable -> L11
        this.f533902e = "";     // Catch: Throwable -> L11
        e.a().c("compat_act_base", this.f533901d);     // Catch: Throwable -> L11
        e.a().c("compat_act_data", this.f533902e);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final String b() {
        if (this.f533898a == true) goto L6;
        return "";
    L6:
        if (i.b.f538604a.f538598e == true) goto L9;
        um7.e.b("getActBase() 没有初始化，返回sp中的值");
        return this.f533901d;
    L9:
        d r100 = d.a.f533911a;
        if (r100.f533906b != null) goto L13;
        return "";
    L13:
        return r100.f533906b.actBase;
    }

    public final String c() {
        if (this.f533898a == true) goto L6;
        return "";
    L6:
        if (i.b.f538604a.f538598e == true) goto L9;
        um7.e.b("getActData() 没有初始化，返回sp中的值");
        return this.f533902e;
    L9:
        d r100 = d.a.f533911a;
        if (r100.f533906b != null) goto L13;
        return "";
    L13:
        return r100.f533906b.actData;
    }

    public final String d() {
        if (this.f533898a == true) goto L5;
        return "";
    L5:
        i r100 = i.b.f538604a;
        if (r100.f538598e == true) goto L10;
        um7.e.b("getActToken() 没有初始化，从sp中直接取");
        return this.f533900c;
    L10:
        if (r100.f538598e == true) goto L12;
        um7.e.a("getDeviceToken() on call; 没有初始化 return");
        return "";
    L12:
        String r101 = om7.e.b(r100.e());
        if (TextUtils.isEmpty(r101) == true) goto L15;
    L19:
        if (r101 != null) goto L22;
        return "";
    L22:
        return r101;
    L15:
        if (r100.f538596c == true) goto L19;
        if (r100.f538597d == false) goto L19;
        rm7.c.a.f538587a.b(new h(r100));
        goto L19
    }

    public c() {
        this.f533899b = "";
        this.f533900c = "";
        this.f533901d = "";
        this.f533902e = "";
    }

    public final synchronized void e(String r100) {
        monitor-enter(this);
        um7.e.b("updateActBase() on call; mIsInit = " + this.f533898a);     // Catch: Throwable -> L15
        if (this.f533898a == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L13:
        monitor-exit(this);
        return;
    L11:
        if (r100.equals(this.f533901d) == true) goto L13;
        um7.e.b("updateActBase() 执行更新； actBase = ".concat(r100));     // Catch: Throwable -> L15
        this.f533901d = r100;     // Catch: Throwable -> L15
        e.a().c("compat_act_base", this.f533901d);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(String r100) {
        monitor-enter(this);
        um7.e.b("updateActData() on call; mIsInit = " + this.f533898a);     // Catch: Throwable -> L15
        if (this.f533898a == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L13:
        monitor-exit(this);
        return;
    L11:
        if (r100.equals(this.f533902e) == true) goto L13;
        um7.e.b("updateActData() 执行更新； actData = ".concat(r100));     // Catch: Throwable -> L15
        this.f533902e = r100;     // Catch: Throwable -> L15
        e.a().c("compat_act_data", this.f533902e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(String r100) {
        monitor-enter(this);
        um7.e.b("updateActTokenKey() on call; mIsInit = " + this.f533898a);     // Catch: Throwable -> L15
        if (this.f533898a == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L13:
        monitor-exit(this);
        return;
    L11:
        if (r100.equals(this.f533899b) == true) goto L13;
        um7.e.b("updateActTokenKey() 执行更新； newKey = ".concat(r100));     // Catch: Throwable -> L15
        this.f533899b = r100;     // Catch: Throwable -> L15
        e.a().c("compat_act_token_key", this.f533899b);     // Catch: Throwable -> L15
        this.f533900c = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(this.f533903f).b(this.f533899b);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
