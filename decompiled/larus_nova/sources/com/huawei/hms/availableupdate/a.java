package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f276987c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f276988d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f276989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Activity> f276990b;

    static {
        f276987c = new a();
        f276988d = new Object();
    }

    public a() {
        this.f276989a = new AtomicBoolean(false);
        this.f276990b = new ArrayList(1);
    }

    public AtomicBoolean a() {
        return this.f276989a;
    }

    public void a(Activity r100) {
        Object r101 = f276988d;
        monitor-enter(r101);
        Iterator<Activity> r102 = this.f276990b.iterator();     // Catch: Throwable -> L16
    L6:
        if (r102.hasNext() == false) goto L13;
        Activity r103 = r102.next();     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        if (r103 == r100) goto L6;
        if (r103.isFinishing() == true) goto L6;
        r103.finish();     // Catch: Throwable -> L16
        goto L6
    L13:
        this.f276990b.add(r100);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void b(Activity r100) {
        Object r101 = f276988d;
        monitor-enter(r101);
        this.f276990b.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(boolean r100) {
        this.f276989a.set(r100);
    }
}
