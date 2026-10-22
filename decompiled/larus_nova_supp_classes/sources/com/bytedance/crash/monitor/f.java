package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.m0;
import com.bytedance.keva.KevaPreloadHolder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fh4.h;
import fh4.i;
import fh4.j;
import java.util.Map;
import org.json.JSONObject;
import wh4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class f {
    public i a;
    public fh4.f b;
    public final m0 c;
    public volatile String d;
    public volatile long e;
    public volatile String f;
    public volatile String g;
    public volatile String h;
    public volatile long i;
    public volatile long j;
    public volatile long k;
    public yh4.a l;

    public Map<String, Object> c() {
        return null;
    }

    public fh4.f e() {
        if (this.b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.b != null) goto L8;
        this.b = new fh4.f(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.b;
    }

    public c h() {
        return new c(this.i, this.k, 0, this.h);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.g;
    }

    public long f() {
        return this.k;
    }

    public long g() {
        return this.e;
    }

    public long i() {
        return this.i;
    }

    public String j() {
        return this.h;
    }

    public f(m0 r1) {
        this.c = r1;
    }

    public String d(String r2) {
        if (TextUtils.isEmpty(this.f) == false) goto L6;
        return r2;
    L6:
        return this.f;
    }

    public f(String r9, String r10, long r11, long r13) {
        this(new m0(), r9, r10, r11, r13);
    }

    public final void k(String r11, int r12, JSONObject r13, JSONObject r14) {
        if (this.a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.a != null) goto L8;
        this.a = new i(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        i r0 = this.a;
        r0.getClass();
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return;
    L17:
        if (r0.a == null) goto L19;
    L21:
        h r1 = r0.a;
        if (r1 != null) goto L24;
    L26:
        j r2 = new j(ThreadMethodProxy.currentThread().getName(), System.currentTimeMillis(), r11, r12, r13, r14);
        if (r0.a != null) goto L29;
        r0.c.add(r2);
        i.h.addAndGet(1);
    L31:
        if (i.i == true) goto L39;
        i.a r15 = i.a.b;
        if (r15.a == true) goto L43;
        r15.a = true;
        i.i = true;
        b.f(r15);
        b.postDelayed(r15, KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME);
        return;
    L43:
        return;
    L39:
        return;
    L29:
        r0.b.add(r2);
        i.g.addAndGet(1);
        goto L31
    L24:
        if (r1.a(r11) == true) goto L26;
        return;
    L19:
        if (i.h.get() <= 100) goto L21;
    }

    public f(m0 r1, String r2, String r3, long r4, long r6) {
        this.d = r2;
        this.h = r3;
        this.i = r4;
        this.j = 0;
        this.k = r6;
        this.c = r1;
    }
}
