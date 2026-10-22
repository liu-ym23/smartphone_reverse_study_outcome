package com.bytedance.push.third;

import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements gfc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f267049b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<gfc.a> f267050a;

    @Override // gfc.a
    public final void c() {
    }

    public static g g() {
        if (f267049b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267049b != null) goto L9;
        f267049b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f267049b;
    }

    @Override // gfc.b
    public final void b() {
        List<gfc.a> r100 = this.f267050a;
        if (r100 == null) goto L12;
        Iterator<gfc.a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        r101.next().b();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // gfc.a
    public final void onStart() {
        List<gfc.a> r100 = this.f267050a;
        if (r100 == null) goto L12;
        Iterator<gfc.a> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        r101.next().onStart();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    public g() {
        this.f267050a = Collections.emptyList();
    }

    @Override // gfc.b
    public final void d(Intent r100) {
        List<gfc.a> r101 = this.f267050a;
        if (r101 == null) goto L12;
        Iterator<gfc.a> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        r102.next().d(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // gfc.b
    public final void f(Context r100) {
        List<gfc.a> r101 = this.f267050a;
        if (r101 == null) goto L12;
        Iterator<gfc.a> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        r102.next().f(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // gfc.a
    public final void initOnApplication(Context r100) {
        w67.a r101 = w67.a.C8076a.f558434a;
        new f();
        List<gfc.a> r102 = this.f267050a;
        if (r102 == null) goto L12;
        Iterator<gfc.a> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        gfc.a r104 = r103.next();
        r104.c();     // Catch: Throwable -> L10
        r104.initOnApplication(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // gfc.a
    public final void a(Context r100, Map<String, String> r101) {
        List<gfc.a> r102 = this.f267050a;
        if (r102 == null) goto L12;
        Iterator<gfc.a> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        r103.next().a(r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }

    @Override // gfc.a
    public final void e(Context r100, JSONObject r101) {
        List<gfc.a> r102 = this.f267050a;
        if (r102 == null) goto L12;
        Iterator<gfc.a> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        r103.next().e(r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L19:
        return;
    }
}
