package com.ss.android.lark.appcontext.applifecycle2.impl;

import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements jva.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f408895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jva.a f408896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f408897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<jva.d.a> f408898d;

    @Override // jva.d
    public final boolean isForeground() {
        if (this.f408897c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jva.d
    public final jva.a a() {
        return this.f408896b;
    }

    @Override // jva.d
    public final String b() {
        return this.f408895a;
    }

    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LinkedList<jva.d.a> r101 = this.f408898d;
        monitor-enter(r101);
        this.f408898d.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public g(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "processName");
        Intrinsics.checkNotNullParameter(r101, "activityLifecycle");
        this.f408895a = r100;
        this.f408896b = r101;
        this.f408898d = new LinkedList();
        r101.b(new f(this));
    }

    public static final void c(g r100, jva.d.b r101) {
        r100.getClass();
        StringBuilder r102 = new StringBuilder("process: ");
        r102.append(r100.f408895a);
        r102.append(", changed to ");
        if (r101.f500587b == false) goto L5;
        String r103 = "foreground";
    L6:
        r102.append(r103);
        Log.i("AppLifecycle2", r102.toString());
        Iterator<T> r104 = r100.f408898d.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        jva.d.a r105 = (jva.d.a) r104.next();
        if (r101.f500587b == true) goto L11;
        r105.a(r101);
        goto L8
    L11:
        r105.b(r101);
        goto L8
    L13:
        return;
    L5:
        r103 = "background";
        goto L6
    }
}
