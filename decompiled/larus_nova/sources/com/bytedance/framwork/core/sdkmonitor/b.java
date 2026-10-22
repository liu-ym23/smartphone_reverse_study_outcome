package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<f> f244903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<c> f244904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<com.bytedance.framwork.core.sdkmonitor.a> f244905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f244906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f244907e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f244909b;

        public final void a() {
            LinkedList<f> r100 = this.f244909b.f244903a;     // Catch: Throwable -> L45
            monitor-enter(r100);     // Catch: Throwable -> L45
            LinkedList r101 = new LinkedList(this.f244909b.f244903a);     // Catch: Throwable -> L41
            this.f244909b.f244903a.clear();     // Catch: Throwable -> L41
            monitor-exit(r100);     // Catch: Throwable -> L41
            Iterator r102 = r101.iterator();     // Catch: Throwable -> L45
        L8:
            if (r102.hasNext() == false) goto L15;
            f r103 = (f) r102.next();     // Catch: Throwable -> L45
            b r104 = this.f244909b;     // Catch: Throwable -> L45
            SDKMonitor r105 = this.f244908a;     // Catch: Throwable -> L45
            r104.getClass();     // Catch: Throwable -> L45
            if (r103 == null) goto L8;
            if (TextUtils.isEmpty(r103.f244914a) == true) goto L8;
            r105.monitorService(r103.f244914a, r103.f244915b, r103.f244916c, r103.f244917d, r103.f244918e, r103.f244919f, r103.f244920g);     // Catch: Throwable -> L45
            goto L8
        L15:
            LinkedList<c> r106 = this.f244909b.f244904b;     // Catch: Throwable -> L45
            monitor-enter(r106);     // Catch: Throwable -> L45
            LinkedList r107 = new LinkedList(this.f244909b.f244904b);     // Catch: Throwable -> L38
            this.f244909b.f244904b.clear();     // Catch: Throwable -> L38
            monitor-exit(r106);     // Catch: Throwable -> L38
            Iterator r108 = r107.iterator();     // Catch: Throwable -> L45
        L21:
            if (r108.hasNext() == false) goto L26;
            c r109 = (c) r108.next();     // Catch: Throwable -> L45
            b r110 = this.f244909b;     // Catch: Throwable -> L45
            SDKMonitor r111 = this.f244908a;     // Catch: Throwable -> L45
            r110.getClass();     // Catch: Throwable -> L45
            if (r109 == null) goto L21;
            r111.monitorCommonLogInternal(r109.f244910a, r109.f244911b, r109.f244912c);     // Catch: Throwable -> L45
            goto L21
        L26:
            LinkedList<com.bytedance.framwork.core.sdkmonitor.a> r112 = this.f244909b.f244905c;     // Catch: Throwable -> L45
            monitor-enter(r112);     // Catch: Throwable -> L45
            LinkedList r113 = new LinkedList(this.f244909b.f244905c);     // Catch: Throwable -> L35
            this.f244909b.f244905c.clear();     // Catch: Throwable -> L35
            monitor-exit(r112);     // Catch: Throwable -> L35
            Iterator r114 = r113.iterator();     // Catch: Throwable -> L45
        L32:
            if (r114.hasNext() == false) goto L68;
            com.bytedance.framwork.core.sdkmonitor.a r115 = (com.bytedance.framwork.core.sdkmonitor.a) r114.next();     // Catch: Throwable -> L45
            b.a(this.f244909b, this.f244908a, r115);     // Catch: Throwable -> L45
            goto L32
        L68:
            return;
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L45
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, SDKMonitor r101) {
            this.f244909b = r100;
            this.f244908a = r101;
        }
    }

    public b() {
        this.f244903a = new LinkedList();
        this.f244904b = new LinkedList();
        this.f244905c = new LinkedList();
        this.f244906d = 200;
    }

    public final void b(SDKMonitor r100) {
        if (this.f244907e == false) goto L5;
        return;
    L5:
        this.f244907e = true;
        gy5.a.b.f483331a.b(new a(this, r100));
    }

    public final void c(com.bytedance.framwork.core.sdkmonitor.a r100) {
        LinkedList<com.bytedance.framwork.core.sdkmonitor.a> r101 = this.f244905c;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f244905c.size() <= this.f244906d) goto L7;
        this.f244905c.poll();     // Catch: Throwable -> L10
    L7:
        this.f244905c.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    public final void d(f r100) {
        LinkedList<f> r101 = this.f244903a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f244903a.size() <= this.f244906d) goto L7;
        this.f244903a.poll();     // Catch: Throwable -> L10
    L7:
        this.f244903a.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    public static void a(b r110, SDKMonitor r111, com.bytedance.framwork.core.sdkmonitor.a r112) {
        r110.getClass();
        if (r112 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r112.f244895a) == false) goto L8;
        return;
    L8:
        if (r112.f244895a.equals(UploadTypeInf.API_ERROR) == false) goto L11;
        r111.monitorApiError(r112.f244896b, r112.f244897c, r112.f244898d, r112.f244899e, r112.f244900f, r112.f244901g, r112.f244902h);
        return;
    L11:
        if (r112.f244895a.equals(UploadTypeInf.API_ALL) == false) goto L16;
        r111.monitorSLA(r112.f244896b, r112.f244897c, r112.f244898d, r112.f244899e, r112.f244900f, r112.f244901g, r112.f244902h);
        return;
    }
}
