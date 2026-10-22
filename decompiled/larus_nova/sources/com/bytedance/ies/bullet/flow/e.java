package com.bytedance.ies.bullet.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends u26.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u26.b f246677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f246678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f246679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f246680d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f246683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f246684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f246685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f246686f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ float f246687g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Transformer f246688h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Function2<Object, Throwable, Unit> f246689i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(e r100, com.bytedance.ies.bullet.service.base.o r101, Context r102, String r103, String r104, float r105, float r106, Transformer r107, Function2<Object, ? super Throwable, Unit> r108) {
            this.f246681a = r100;
            this.f246682b = r101;
            this.f246683c = r102;
            this.f246684d = r103;
            this.f246685e = r104;
            this.f246686f = r105;
            this.f246687g = r106;
            this.f246688h = r107;
            this.f246689i = r108;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246681a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f246682b, this.f246683c, this.f246684d, this.f246685e, this.f246686f, this.f246687g, this.f246688h, this.f246689i);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246691b;

        public b(e r100, com.bytedance.ies.bullet.service.base.o r101) {
            this.f246690a = r100;
            this.f246691b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246690a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.j(this.f246691b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f246694c;

        public c(e r100, com.bytedance.ies.bullet.service.base.o r101, JSONObject r102) {
            this.f246692a = r100;
            this.f246693b = r101;
            this.f246694c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246692a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.e(this.f246693b, this.f246694c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246696b;

        public d(e r100, com.bytedance.ies.bullet.service.base.o r101) {
            this.f246695a = r100;
            this.f246696b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246695a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(this.f246696b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.flow.e$e, reason: collision with other inner class name */
    public static final class RunnableC3526e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f246699c;

        public RunnableC3526e(e r100, com.bytedance.ies.bullet.service.base.o r101, String r102) {
            this.f246697a = r100;
            this.f246698b = r101;
            this.f246699c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246697a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.g(this.f246698b, this.f246699c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246701b;

        public f(e r100, com.bytedance.ies.bullet.service.base.o r101) {
            this.f246700a = r100;
            this.f246701b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246700a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.d(this.f246701b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f246704c;

        public g(e r100, com.bytedance.ies.bullet.service.base.o r101, String r102) {
            this.f246702a = r100;
            this.f246703b = r101;
            this.f246704c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246702a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.f(this.f246703b, this.f246704c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246706b;

        public h(e r100, com.bytedance.ies.bullet.service.base.o r101) {
            this.f246705a = r100;
            this.f246706b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246705a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.c(this.f246706b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f246709c;

        public i(e r100, com.bytedance.ies.bullet.service.base.o r101, String r102) {
            this.f246707a = r100;
            this.f246708b = r101;
            this.f246709c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246707a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.n(this.f246708b, this.f246709c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u26.e f246712c;

        public j(e r100, com.bytedance.ies.bullet.service.base.o r101, u26.e r102) {
            this.f246710a = r100;
            this.f246711b = r101;
            this.f246712c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246710a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.l(this.f246711b, this.f246712c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246714b;

        public k(e r100, com.bytedance.ies.bullet.service.base.o r101) {
            this.f246713a = r100;
            this.f246714b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246713a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.h(this.f246714b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d36.e f246716b;

        public l(e r100, d36.e r101) {
            this.f246715a = r100;
            this.f246716b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246715a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.k(this.f246716b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d36.e f246718b;

        public m(e r100, d36.e r101) {
            this.f246717a = r100;
            this.f246718b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246717a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.m(this.f246718b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f246720b;

        public n(e r100, Map<String, Object> r101) {
            this.f246719a = r100;
            this.f246720b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246719a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onTimingSetup(this.f246720b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f246722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, Long> f246723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f246724d;

        public o(e r100, Map<String, Object> r101, Map<String, Long> r102, String r103) {
            this.f246721a = r100;
            this.f246722b = r101;
            this.f246723c = r102;
            this.f246724d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246721a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onTimingUpdate(this.f246722b, this.f246723c, this.f246724d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f246725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f246727c;

        public p(e r100, com.bytedance.ies.bullet.service.base.o r101, JSONObject r102) {
            this.f246725a = r100;
            this.f246726b = r101;
            this.f246727c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u26.b r100 = this.f246725a.f246677a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.i(this.f246726b, this.f246727c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public e() {
        this.f246679c = new ConcurrentLinkedQueue();
        Looper r100 = Looper.myLooper();
        if (r100 != null) goto L5;
        r100 = Looper.getMainLooper();
    L5:
        this.f246680d = new Handler(r100);
    }

    @Override // u26.b.a, u26.b
    public final void b(com.bytedance.ies.bullet.service.base.o r100) {
        p(new d(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void c(com.bytedance.ies.bullet.service.base.o r100) {
        p(new h(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void d(com.bytedance.ies.bullet.service.base.o r100) {
        p(new f(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void h(com.bytedance.ies.bullet.service.base.o r100) {
        p(new k(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void j(com.bytedance.ies.bullet.service.base.o r100) {
        p(new b(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void k(d36.e r100) {
        p(new l(this, r100));
    }

    @Override // u26.b.a, u26.b
    public final void m(d36.e r100) {
        p(new m(this, r100));
    }

    public final void o(u26.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f246677a = r100;
        monitor-enter(this);
        this.f246678b = true;     // Catch: Throwable -> L15
        Iterator<Runnable> r101 = this.f246679c.iterator();     // Catch: Throwable -> L15
    L7:
        if (r101.hasNext() == false) goto L12;
        Runnable r102 = r101.next();     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(this.f246680d.getLooper(), Looper.myLooper()) == true) goto L10;
        this.f246680d.post(r102);     // Catch: Throwable -> L15
        goto L7
    L10:
        r102.run();     // Catch: Throwable -> L15
        goto L7
    L12:
        this.f246679c.clear();     // Catch: Throwable -> L15
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // u26.b.a, u26.b
    public final void onTimingSetup(Map<String, Object> r100) {
        p(new n(this, r100));
    }

    public final void p(Runnable r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f246678b == false) goto L8;
        r100.run();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        this.f246679c.add(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // u26.b.a, u26.b
    public final String shouldRedirectImageUrl(String r100) {
        monitor-enter(this);
        String r101 = null;
        if (this.f246678b == false) goto L10;
        u26.b r102 = this.f246677a;     // Catch: Throwable -> L12
        if (r102 == null) goto L8;
        r101 = r102.shouldRedirectImageUrl(r100);     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return r101;
    L10:
        monitor-exit(this);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // u26.b.a, u26.b
    public final void e(com.bytedance.ies.bullet.service.base.o r100, JSONObject r101) {
        p(new c(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void f(com.bytedance.ies.bullet.service.base.o r100, String r101) {
        p(new g(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void g(com.bytedance.ies.bullet.service.base.o r100, String r101) {
        p(new RunnableC3526e(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void i(com.bytedance.ies.bullet.service.base.o r100, JSONObject r101) {
        p(new p(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void l(com.bytedance.ies.bullet.service.base.o r100, u26.e r101) {
        p(new j(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void n(com.bytedance.ies.bullet.service.base.o r100, String r101) {
        p(new i(this, r100, r101));
    }

    @Override // u26.b.a, u26.b
    public final void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        p(new o(this, r100, r101, r102));
    }

    @Override // u26.b.a, u26.b
    public final void a(com.bytedance.ies.bullet.service.base.o r110, Context r111, String r112, String r113, float r114, float r115, Transformer r116, Function2<Object, ? super Throwable, Unit> r117) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r117, "handler");
        p(new a(this, r110, r111, r112, r113, r114, r115, r116, r117));
    }
}
