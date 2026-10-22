package com.lynx.component.svg;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.serval.svg.SVGRender;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import x6a.i;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f380980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f380981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile String f380982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile String f380983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f380984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f380985o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f380986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile Drawable f380987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile SVGRender f380988r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d f380989s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f380990t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f380991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f380992v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f380993w;

    /* JADX INFO: renamed from: com.lynx.component.svg.a$a, reason: collision with other inner class name */
    public class RunnableC4553a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f380994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f380995b;

        public final void a() {
            if (this.f380995b.f380992v == false) goto L6;
            this.f380995b.f380986p = false;
            return;
        L6:
            a r100 = this.f380995b;
            String r101 = this.f380994a;
            r100.getClass();
            String r102 = new String(Base64.decode(r101.substring(26).getBytes(StandardCharsets.UTF_8), 0), StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(r102) == false) goto L9;
            UIThreadUtils.runOnUiThread(new x5a.a(r100));
            return;
        L9:
            r100.f380982l = r102;
            r100.l();
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

        public RunnableC4553a(a r100, String r101) {
            this.f380995b = r100;
            this.f380994a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f380996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f380997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f380998c;

        /* JADX INFO: renamed from: com.lynx.component.svg.a$b$a, reason: collision with other inner class name */
        public class RunnableC4554a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j6a.a f380999a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f381000b;

            public final void a() {
                if (this.f381000b.f380998c.f380992v == false) goto L6;
                this.f381000b.f380998c.f380986p = false;
                return;
            L6:
                a r100 = this.f381000b.f380998c;
                r100.f380987q = this.f380999a;
                this.f381000b.f380998c.e(0);
                a.k(this.f381000b.f380998c);
                this.f381000b.f380998c.f380986p = false;
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

            public RunnableC4554a(b r100, j6a.a r101) {
                this.f381000b = r100;
                this.f380999a = r101;
            }
        }

        /* JADX INFO: renamed from: com.lynx.component.svg.a$b$b, reason: collision with other inner class name */
        public class RunnableC4555b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f381001a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f381001a.f380998c.f380986p = false;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC4555b(b r100) {
                this.f381001a = r100;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f381002a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f381002a.f380998c.f380986p = false;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(b r100) {
                this.f381002a = r100;
            }
        }

        public final void a() {
        L7:
            e = move-exception;
            LLog.e("lynx_SVGRenderer", "renderServalSVG failed: " + e.getMessage());
            UIThreadUtils.runOnUiThread(new c(this));
            return;
        L3:
            if (this.f380998c.f380988r == null) goto L5;
            this.f380998c.f380988r.setColor(this.f380998c.f380983m);     // Catch: Exception -> L7
            UIThreadUtils.runOnUiThread(new RunnableC4554a(this, new j6a.a(this.f380998c.f380988r.renderPicture(this.f380998c.f380982l, new Rect(0, 0, this.f380996a, this.f380997b)))));     // Catch: Exception -> L7
        L10:
            return;
        L5:
            UIThreadUtils.runOnUiThread(new RunnableC4555b(this));     // Catch: Exception -> L7
            goto L10
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

        public b(a r100, int r101, int r102) {
            this.f380998c = r100;
            this.f380996a = r101;
            this.f380997b = r102;
        }
    }

    public static class c implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f381003a;

        /* JADX INFO: renamed from: com.lynx.component.svg.a$c$a, reason: collision with other inner class name */
        public class RunnableC4556a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f381004a;

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f381004a.f381003a.get();     // Catch: Throwable -> L9
                if (r100 != null) goto L5;
                return;
            L5:
                if (r100.f380992v == true) goto L16;
                r100.e(0);     // Catch: Throwable -> L9
                r100.f380986p = false;     // Catch: Throwable -> L9
                return;
            L16:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            }

            public RunnableC4556a(c r100) {
                this.f381004a = r100;
            }
        }

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onStart() {
        }

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onSuccess() {
        }

        public c(a r100) {
            this.f381003a = new WeakReference(r100);
        }

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onError(String r100) {
            a r101 = this.f381003a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.f380992v == true) goto L10;
            LLog.e("lynx_SVGRenderer", "requestSrc error! the src is " + r101.f380981k + " error message is " + r100);
            r101.f380987q = null;
            UIThreadUtils.runOnUiThread(new RunnableC4556a(this));
            return;
        }

        @Override // com.lynx.component.svg.d.c
        public final void a(String r100, SVG r101) {
            a r102 = this.f381003a.get();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.f380992v == false) goto L8;
            return;
        L8:
            if (r102.f380984n == false) goto L10;
            r102.f380982l = r100;
            r102.m();
            return;
        L10:
            if (r101 != null) goto L12;
            r102.f380986p = false;
            return;
        L12:
            int r103 = r102.f380990t;
            int r104 = r102.f380991u;
            LynxThreadPool.e().execute(new x5a.b(r102, r103, r104, r101));
        }
    }

    @Override // x6a.i
    public final void f() {
        this.f380992v = true;
        this.f380988r = null;
        this.f380989s.a();
    }

    public final void l() {
        if (this.f380984n == false) goto L6;
        m();
        return;
    L6:
        if (TextUtils.isEmpty(this.f380982l) == false) goto L8;
        this.f380986p = false;
        return;
    L8:
        LynxThreadPool.e().execute(new x5a.c(this));
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f380982l) == false) goto L6;
        this.f380986p = false;
        return;
    L6:
        int r100 = this.f380990t;
        int r101 = this.f380991u;
        LynxThreadPool.e().execute(new b(this, r100, r101));
    }

    public final void n() {
        if (this.f380986p == false) goto L5;
        return;
    L5:
        Rect r100 = this.f562740a;
        int r101 = r100.width();
        int r102 = r100.height();
        if (r101 <= 0) goto L26;
        if (r102 <= 0) goto L30;
        this.f380990t = r101;
        this.f380991u = r102;
        this.f380985o = false;
        if (TextUtils.isEmpty(this.f380982l) == true) goto L12;
    L15:
        this.f380986p = true;
        if (TextUtils.isEmpty(this.f380981k) == true) goto L22;
        if (this.f380981k.startsWith("data:image/svg+xml;base64") == false) goto L20;
        String r103 = this.f380981k;
        LynxThreadPool.e().execute(new RunnableC4553a(this, r103));
        return;
    L20:
        this.f380989s.c(this.f380981k, new c(this));
        return;
    L22:
        if (TextUtils.isEmpty(this.f380982l) == true) goto L24;
        l();
        return;
    L24:
        this.f380986p = false;
        return;
    L12:
        if (TextUtils.isEmpty(this.f380981k) == false) goto L15;
        this.f380987q = null;
        e(0);
        return;
    L30:
        return;
    }

    public static void k(a r100) {
        LynxContext r101 = r100.f562743d.f382179d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getEventEmitter() != null) goto L7;
        return;
    L7:
        if (r100.f380993w != true) goto L12;
        m7a.a r102 = new m7a.a(r100.f380980j, "load");
        r102.a("height", Integer.valueOf(r100.f380991u));
        r102.a("width", Integer.valueOf(r100.f380990t));
        r101.getEventEmitter().sendCustomEvent(r102);
        return;
    }

    @Override // x6a.i
    public final void g(Canvas r100) {
        super.g(r100);
        Rect r101 = this.f562740a;
        int r102 = r101.width();
        int r103 = r101.height();
        if (r102 <= 0) goto L13;
        if (r103 <= 0) goto L13;
        if (r102 == this.f380990t) goto L8;
    L11:
        this.f380985o = true;
        n();
        goto L13
    L8:
        if (r103 != this.f380991u) goto L11;
        if (this.f380985o == true) goto L11;
    L13:
        if (this.f380987q == null) goto L16;
        this.f380987q.draw(r100);
        return;
    }

    @Override // x6a.i
    public final void j(PropBundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = null;
        if (r100.contains("src") == false) goto L12;
        String r102 = r100.f382364a.getString("src");
        if (o(r102, this.f380981k) == false) goto L12;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = null;
    L11:
        this.f380981k = r102;
        boolean r103 = true;
    L14:
        if (r100.contains("content") == false) goto L22;
        String r104 = r100.f382364a.getString("content");
        if (o(r104, this.f380982l) == false) goto L22;
        if (TextUtils.isEmpty(r104) == false) goto L20;
        r104 = null;
    L20:
        this.f380982l = r104;
        r103 = true;
    L22:
        if (r100.contains("current-color") == false) goto L31;
        String r105 = r100.f382364a.getString("current-color");
        if (TextUtils.isEmpty(r105) == true) goto L28;
        r101 = r105.trim();
    L28:
        if (o(r101, this.f380983m) == false) goto L31;
        this.f380983m = r101;
        r103 = true;
    L31:
        if (r100.getProps().hasKey("enable-serval-svg") == false) goto L41;
        boolean r106 = r100.getProps().getBoolean("enable-serval-svg", false);
        if (r106 == this.f380984n) goto L41;
        this.f380984n = r106;
        if (this.f380984n == true) goto L37;
    L39:
        r103 = true;
        goto L41
    L37:
        if (this.f380988r != null) goto L39;
        LynxThreadPool.e().execute(new com.lynx.component.svg.c(this));
    L41:
        if (r100.getEventHandlers() != null) goto L43;
    L45:
        if (r103 == false) goto L48;
        this.f380985o = true;
        n();
        return;
    L48:
        return;
    L43:
        if (EventsListener.convertEventListeners(r100.getEventHandlers()).containsKey("load") == false) goto L45;
        this.f380993w = true;
    L12:
        r103 = false;
        goto L14
    }

    public a(PlatformRendererContext r100, int r101) {
        super(r100, r101);
        this.f380984n = false;
        this.f380985o = false;
        this.f380986p = false;
        this.f380990t = -1;
        this.f380991u = -1;
        this.f380992v = false;
        this.f380993w = false;
        this.f380980j = r101;
        this.f380989s = new d(this.f562743d.f382179d);
    }

    public static boolean o(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L13;
        if (r101 == null) goto L14;
        return true;
    L14:
        return false;
    L13:
        return !r100.equals(r101);
    }
}
