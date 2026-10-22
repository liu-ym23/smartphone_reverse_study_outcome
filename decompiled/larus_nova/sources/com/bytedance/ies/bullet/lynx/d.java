package com.bytedance.ies.bullet.lynx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.r1;
import com.lynx.tasm.v0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f247183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<a> f247184c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f247185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f247186b;

        public a(Handler r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            Intrinsics.checkNotNullParameter(r101, "runnable");
            this.f247185a = r100;
            this.f247186b = r101;
        }
    }

    public static final class a0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247187a;

        public a0(d r100) {
            this.f247187a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.B(this.f247187a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f247189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f247190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f247191d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f247192e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f247193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Transformer f247194g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.behavior.m.a f247195h;

        public b(d r100, Context r101, String r102, String r103, float r104, float r105, Transformer r106, com.lynx.tasm.behavior.m.a r107) {
            this.f247188a = r100;
            this.f247189b = r101;
            this.f247190c = r102;
            this.f247191d = r103;
            this.f247192e = r104;
            this.f247193f = r105;
            this.f247194g = r106;
            this.f247195h = r107;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b(this.f247188a, this.f247189b, this.f247190c, this.f247191d, this.f247192e, this.f247193f, this.f247194g, this.f247195h);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q1.b f247197b;

        public b0(d r100, q1.b r101) {
            this.f247196a = r100;
            this.f247197b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.C(this.f247196a, this.f247197b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f247199b;

        public c(d r100, Map<String, ? extends Object> r101) {
            this.f247198a = r100;
            this.f247199b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c(this.f247198a, this.f247199b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q1.b f247201b;

        public c0(d r100, q1.b r101) {
            this.f247200a = r100;
            this.f247201b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.D(this.f247200a, this.f247201b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.lynx.d$d, reason: collision with other inner class name */
    public static final class RunnableC3533d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247202a;

        public RunnableC3533d(d r100) {
            this.f247202a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.d(this.f247202a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247203a;

        public d0(d r100) {
            this.f247203a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.E(this.f247203a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247204a;

        public e(d r100) {
            this.f247204a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.f(this.f247204a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateBundle f247206b;

        public e0(d r100, TemplateBundle r101) {
            this.f247205a = r100;
            this.f247206b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.F(this.f247205a, this.f247206b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap<String, Object> f247208b;

        public f(d r100, HashMap<String, Object> r101) {
            this.f247207a = r100;
            this.f247208b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.g(this.f247207a, this.f247208b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f247210b;

        public f0(d r100, Map<String, Object> r101) {
            this.f247209a = r100;
            this.f247210b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.G(this.f247209a, this.f247210b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247211a;

        public g(d r100, v0 r101) {
            this.f247211a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f247211a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f247213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, Long> f247214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f247215d;

        public g0(d r100, Map<String, Object> r101, Map<String, Long> r102, String r103) {
            this.f247212a = r100;
            this.f247213b = r101;
            this.f247214c = r102;
            this.f247215d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.H(this.f247212a, this.f247213b, this.f247214c, this.f247215d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247216a;

        public h(d r100) {
            this.f247216a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.h(this.f247216a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247217a;

        public h0(d r100) {
            this.f247217a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.I(this.f247217a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q1.b f247219b;

        public i(d r100, q1.b r101) {
            this.f247218a = r100;
            this.f247219b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.i(this.f247218a, this.f247219b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247220a;

        public i0(d r100, v0 r101) {
            this.f247220a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f247220a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247221a;

        public j(d r100) {
            this.f247221a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.j(this.f247221a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f247223b;

        public k(d r100, Map<String, ? extends Object> r101) {
            this.f247222a = r100;
            this.f247223b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.k(this.f247222a, this.f247223b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KeyEvent f247225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f247226c;

        public l(d r100, KeyEvent r101, boolean r102) {
            this.f247224a = r100;
            this.f247225b = r101;
            this.f247226c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.m(this.f247224a, this.f247225b, this.f247226c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247228b;

        public m(d r100, String r101) {
            this.f247227a = r100;
            this.f247228b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.n(this.f247227a, this.f247228b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247229a;

        public n(d r100) {
            this.f247229a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.o(this.f247229a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxEventDetail f247231b;

        public o(d r100, LynxEventDetail r101) {
            this.f247230a = r100;
            this.f247231b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.p(this.f247230a, this.f247231b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247232a;

        public p(d r100) {
            this.f247232a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.q(this.f247232a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f247235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f247236d;

        public q(d r100, String r101, String r102, int r103) {
            this.f247233a = r100;
            this.f247234b = r101;
            this.f247235c = r102;
            this.f247236d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.r(this.f247233a, this.f247234b, this.f247235c, this.f247236d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247238b;

        public r(d r100, String r101) {
            this.f247237a = r100;
            this.f247238b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.s(this.f247237a, this.f247238b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247239a;

        public s(d r100) {
            this.f247239a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.t(this.f247239a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f247241b;

        public t(d r100, Map<String, ? extends Object> r101) {
            this.f247240a = r100;
            this.f247241b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.u(this.f247240a, this.f247241b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247243b;

        public u(d r100, String r101) {
            this.f247242a = r100;
            this.f247243b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.w(this.f247242a, this.f247243b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxError f247245b;

        public v(d r100, LynxError r101) {
            this.f247244a = r100;
            this.f247245b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.v(this.f247244a, this.f247245b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxError f247247b;

        public w(d r100, LynxError r101) {
            this.f247246a = r100;
            this.f247247b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.x(this.f247246a, this.f247247b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxError f247249b;

        public x(d r100, LynxError r101) {
            this.f247248a = r100;
            this.f247249b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.y(this.f247248a, this.f247249b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxError f247251b;

        public y(d r100, LynxError r101) {
            this.f247250a = r100;
            this.f247251b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.z(this.f247250a, this.f247251b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f247252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set<String> f247253b;

        public z(d r100, Set<String> r101) {
            this.f247252a = r100;
            this.f247253b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.A(this.f247252a, this.f247253b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onDataUpdated() {
        J(new RunnableC3533d(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onDestroy() {
        J(new e(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onFirstScreen() {
        J(new h(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onLoadSuccess() {
        J(new n(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onLynxViewAndJSRuntimeDestroy() {
        J(new p(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onPageUpdate() {
        J(new s(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onRuntimeReady() {
        J(new a0(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onTASMFinishedByNative() {
        J(new d0(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onUpdateDataWithoutChange() {
        J(new h0(this));
    }

    public d() {
        this.f247183b = true;
        this.f247184c = new ConcurrentLinkedQueue();
    }

    public static final /* synthetic */ void B(d r100) {
        super.onRuntimeReady();
    }

    public static final /* synthetic */ void E(d r100) {
        super.onTASMFinishedByNative();
    }

    public static final /* synthetic */ void I(d r100) {
        super.onUpdateDataWithoutChange();
    }

    public static final /* synthetic */ void d(d r100) {
        super.onDataUpdated();
    }

    public static final /* synthetic */ void f(d r100) {
        super.onDestroy();
    }

    public static final /* synthetic */ void h(d r100) {
        super.onFirstScreen();
    }

    public static final /* synthetic */ void j(d r100) {
        super.onFlushFinish(null);
    }

    public static final /* synthetic */ void o(d r100) {
        super.onLoadSuccess();
    }

    public static final /* synthetic */ void q(d r100) {
        super.onLynxViewAndJSRuntimeDestroy();
    }

    public static final /* synthetic */ void t(d r100) {
        super.onPageUpdate();
    }

    public final void J(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (this.f247183b == false) goto L19;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f247183b == false) goto L13;
        Looper r101 = Looper.myLooper();     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        r101 = Looper.getMainLooper();     // Catch: Throwable -> L16
    L10:
        Handler r102 = new Handler(r101);     // Catch: Throwable -> L16
        Queue<a> r103 = this.f247184c;     // Catch: Throwable -> L16
        ConcurrentLinkedQueue r104 = (ConcurrentLinkedQueue) r103;     // Catch: Throwable -> L16
        r104.add(new a(r102, r100));     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
    L19:
        r100.run();
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onCallJSBFinished(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbTiming");
        J(new c(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onDynamicComponentPerfReady(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.TAG_PERF);
        J(new f(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onFirstLoadPerfReady(v0 r100) {
        J(new g(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onFling(q1.b r100) {
        J(new i(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onFlushFinish(q1.a r100) {
        J(new j(this));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onJSBInvoked(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbInfo");
        J(new k(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onLoadFailed(String r100) {
        J(new m(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onLynxEvent(LynxEventDetail r100) {
        J(new o(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onPageStart(String r100) {
        J(new r(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onPiperInvoked(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        J(new t(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onReceivedError(LynxError r100) {
        J(new v(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onReceivedJSError(LynxError r100) {
        Intrinsics.checkNotNullParameter(r100, "jsError");
        J(new w(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onReceivedJavaError(LynxError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        J(new x(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onReceivedNativeError(LynxError r100) {
        Intrinsics.checkNotNullParameter(r100, "nativeError");
        J(new y(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onReportComponentInfo(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "mComponentSet");
        J(new z(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onScrollStart(q1.b r100) {
        J(new b0(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onScrollStop(q1.b r100) {
        J(new c0(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onTemplateBundleReady(TemplateBundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        J(new e0(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onTimingSetup(Map<String, Object> r100) {
        J(new f0(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onUpdatePerfReady(v0 r100) {
        J(new i0(this, r100));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onReceivedError(String r100) {
        J(new u(this, r100));
    }

    public static final /* synthetic */ void A(d r100, Set r101) {
        super.onReportComponentInfo(r101);
    }

    public static final /* synthetic */ void C(d r100, q1.b r101) {
        super.onScrollStart(r101);
    }

    public static final /* synthetic */ void D(d r100, q1.b r101) {
        super.onScrollStop(r101);
    }

    public static final /* synthetic */ void F(d r100, TemplateBundle r101) {
        super.onTemplateBundleReady(r101);
    }

    public static final /* synthetic */ void G(d r100, Map r101) {
        super.onTimingSetup(r101);
    }

    public static final /* synthetic */ void c(d r100, Map r101) {
        super.onCallJSBFinished(r101);
    }

    public static final /* synthetic */ void g(d r100, HashMap r101) {
        super.onDynamicComponentPerfReady(r101);
    }

    public static final /* synthetic */ void i(d r100, q1.b r101) {
        super.onFling(r101);
    }

    public static final /* synthetic */ void k(d r100, Map r101) {
        super.onJSBInvoked(r101);
    }

    public static final /* synthetic */ void n(d r100, String r101) {
        super.onLoadFailed(r101);
    }

    public static final /* synthetic */ void p(d r100, LynxEventDetail r101) {
        super.onLynxEvent(r101);
    }

    public static final /* synthetic */ void s(d r100, String r101) {
        super.onPageStart(r101);
    }

    public static final /* synthetic */ void u(d r100, Map r101) {
        super.onPiperInvoked(r101);
    }

    public static final /* synthetic */ void v(d r100, LynxError r101) {
        super.onReceivedError(r101);
    }

    public static final /* synthetic */ void w(d r100, String r101) {
        super.onReceivedError(r101);
    }

    public static final /* synthetic */ void x(d r100, LynxError r101) {
        super.onReceivedJSError(r101);
    }

    public static final /* synthetic */ void y(d r100, LynxError r101) {
        super.onReceivedJavaError(r101);
    }

    public static final /* synthetic */ void z(d r100, LynxError r101) {
        super.onReceivedNativeError(r101);
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onKeyEvent(KeyEvent r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        J(new l(this, r100, r101));
    }

    public static final /* synthetic */ void m(d r100, KeyEvent r101, boolean r102) {
        super.onKeyEvent(r101, r102);
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onModuleMethodInvoked(String r100, String r101, int r102) {
        J(new q(this, r100, r101, r102));
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1
    public final void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        J(new g0(this, r100, r101, r102));
    }

    public static final /* synthetic */ void H(d r100, Map r101, Map r102, String r103) {
        super.onTimingUpdate(r101, r102, r103);
    }

    public static final /* synthetic */ void r(d r100, String r101, String r102, int r103) {
        super.onModuleMethodInvoked(r101, r102, r103);
    }

    @Override // com.lynx.tasm.r1, com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public final void loadImage(Context r110, String r111, String r112, float r113, float r114, Transformer r115, com.lynx.tasm.behavior.m.a r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "handler");
        J(new b(this, r110, r111, r112, r113, r114, r115, r116));
    }

    public static final /* synthetic */ void b(d r100, Context r101, String r102, String r103, float r104, float r105, Transformer r106, com.lynx.tasm.behavior.m.a r107) {
        super.loadImage(r101, r102, r103, r104, r105, r106, r107);
    }
}
