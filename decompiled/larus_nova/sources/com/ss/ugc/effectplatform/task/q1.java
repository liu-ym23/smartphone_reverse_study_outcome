package com.ss.ugc.effectplatform.task;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.logger.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z.b<String, e0.a> f457908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.b<String, e0.c> f457909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z.d<e0.c> f457910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z.d<e0.c> f457911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0.e f457912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0.b f457913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z.b<String, e0.c> f457914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f457915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final bytekn.foundation.concurrent.executor.a f457916i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bytekn.foundation.concurrent.executor.a f457917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f457918b;

        public final q1 a() {
            Logger.INSTANCE.d("JKL", "[初始化][TaskManager][最大并发任务数:" + this.f457918b + ']');
            int r100 = this.f457918b;
            bytekn.foundation.concurrent.executor.a r101 = this.f457917a;
            if (r101 != null) goto L7;
            r101 = new AsyncExecutor();
        L7:
            return new q1(r100, r101);
        }

        public a() {
            this.f457918b = 5;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q1 f457919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0.c f457920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f457921c;

        public final void a() {
            Logger r100 = Logger.INSTANCE;
            r100.d("JKL", "[TaskManager][旧接口][开始][" + this.f457920b.getId() + "][" + this.f457921c + ']');
            this.f457919a.f457909b.put(this.f457920b.getId(), this.f457920b);
            this.f457920b.run();
            this.f457919a.f457909b.remove(this.f457920b.getId());
            r100.d("JKL", "[TaskManager][旧接口][结束][" + this.f457920b.getId() + "][" + this.f457921c + ']');
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

        public c(q1 r100, e0.c r101, String r102) {
            this.f457919a = r100;
            this.f457920b = r101;
            this.f457921c = r102;
        }
    }

    static {
    }

    public final void a(e0.c r100) {
        Iterator<T> r101 = this.f457908a.values().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((e0.a) r101.next()).a() == false) goto L4;
        r102 = true;
        goto L4
    L9:
        if ((r100 instanceof BaseTask) == false) goto L11;
        ((BaseTask) r100).d();
    L11:
        String r103 = r100.getTag();
        if (r102 == true) goto L20;
        this.f457916i.execute(new c(this, r100, r103));
        return;
    }

    public q1(int r100, bytekn.foundation.concurrent.executor.a r101) {
        this.f457915h = r100;
        this.f457916i = r101;
        this.f457908a = new z.b(false);
        this.f457909b = new z.b(true);
        this.f457910c = new z.d();
        this.f457911d = new z.d();
        this.f457912e = new c0.e();
        this.f457913f = new c0.b(0);
        this.f457914g = new z.b(true);
    }

    public final void b(String r100, com.ss.ugc.effectplatform.task.b r101) {
        if (com.ss.ugc.effectplatform.util.r.b(r100) == false) goto L5;
        r100 = "null";
    L5:
        r101.f457531a = r100;
        a(r101);
    }
}
