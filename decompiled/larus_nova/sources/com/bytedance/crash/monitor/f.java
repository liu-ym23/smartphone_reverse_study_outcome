package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.m0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fh4.i f203289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fh4.f f203290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f203291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f203292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f203293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f203294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f203295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f203296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f203297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f203298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f203299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public yh4.a f203300l;

    public Map<String, Object> c() {
        return null;
    }

    public fh4.f e() {
        if (this.f203290b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f203290b != null) goto L8;
        this.f203290b = new fh4.f(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f203290b;
    }

    public c h() {
        return new c(this.f203297i, this.f203299k, 0, this.f203296h);
    }

    public String a() {
        return this.f203292d;
    }

    public String b() {
        return this.f203295g;
    }

    public long f() {
        return this.f203299k;
    }

    public long g() {
        return this.f203293e;
    }

    public long i() {
        return this.f203297i;
    }

    public String j() {
        return this.f203296h;
    }

    public f(m0 r100) {
        this.f203291c = r100;
    }

    public String d(String r100) {
        if (TextUtils.isEmpty(this.f203294f) == false) goto L6;
        return r100;
    L6:
        return this.f203294f;
    }

    public f(String r100, String r110, long r111, long r112) {
        this(new m0(), r100, r110, r111, r112);
    }

    public final void k(String r110, int r111, JSONObject r112, JSONObject r113) {
        if (this.f203289a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f203289a != null) goto L8;
        this.f203289a = new fh4.i(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        fh4.i r100 = this.f203289a;
        r100.getClass();
        if (TextUtils.isEmpty(r110) == false) goto L17;
        return;
    L17:
        if (r100.f477047a == null) goto L19;
    L21:
        fh4.h r101 = r100.f477047a;
        if (r101 != null) goto L24;
    L26:
        fh4.j r102 = new fh4.j(ThreadMethodProxy.currentThread().getName(), System.currentTimeMillis(), r110, r111, r112, r113);
        if (r100.f477047a != null) goto L29;
        r100.f477049c.add(r102);
        fh4.i.f477045h.addAndGet(1);
    L31:
        if (fh4.i.f477046i == true) goto L39;
        fh4.i.a r114 = fh4.i.a.f477050b;
        if (r114.f477051a == true) goto L43;
        r114.f477051a = true;
        fh4.i.f477046i = true;
        wh4.b.f(r114);
        wh4.b.postDelayed(r114, 30000);
        return;
    L43:
        return;
    L39:
        return;
    L29:
        r100.f477048b.add(r102);
        fh4.i.f477044g.addAndGet(1);
        goto L31
    L24:
        if (r101.a(r110) == true) goto L26;
        return;
    L19:
        if (fh4.i.f477045h.get() <= 100) goto L21;
    }

    public f(m0 r100, String r101, String r102, long r103, long r104) {
        this.f203292d = r101;
        this.f203296h = r102;
        this.f203297i = r103;
        this.f203298j = 0;
        this.f203299k = r104;
        this.f203291c = r100;
    }
}
