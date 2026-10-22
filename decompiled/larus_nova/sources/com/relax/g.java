package com.relax;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f404637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f404638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f404639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f404640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f404641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f404642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f404643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f404644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f404645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakHashMap<Object, ViewTreeObserver.OnGlobalLayoutListener> f404646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHashMap<Object, c> f404647k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f404648a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f404648a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r100) {
            this.f404648a = r100;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f404649a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            g r100 = this.f404649a;
            r100.getClass();
            Context r101 = r100.f404637a;     // Catch: Exception -> L40
            if ((r101 instanceof Activity) == false) goto L39;
            Activity r102 = (Activity) r101;     // Catch: Exception -> L40
            r100.f404642f.d().getWindowVisibleDisplayFrame(r100.f404641e);     // Catch: Exception -> L40
            int r103 = r100.f404642f.e();     // Catch: Exception -> L40
            Rect r104 = r100.f404641e;     // Catch: Exception -> L40
            r100.f404644h = r103 - r104.top;     // Catch: Exception -> L40
            int r105 = r104.height();     // Catch: Exception -> L40
            if (r105 > 0) goto L9;
            r105 = r100.f404642f.d().getHeight();     // Catch: Exception -> L40
        L9:
            int r106 = r102.getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L40
            int r107 = r100.f404644h;     // Catch: Exception -> L40
            double r108 = ((double) r105) / ((double) r107);     // Catch: Exception -> L40
            if (r106 == 0) goto L14;
            if (r106 == 2) goto L14;
        L16:
            int r109 = 0;
            if (r108 >= 0.9d) goto L19;
            boolean r110 = true;
        L20:
            if (r110 == false) goto L23;
            r109 = (int) ((r107 - r105) / r100.f404638b);     // Catch: Exception -> L40
        L23:
            if (r109 == r100.f404643g) goto L32;
            Iterator<Map.Entry<Object, c>> r111 = r100.f404647k.entrySet().iterator();     // Catch: Exception -> L40
        L26:
            if (r111.hasNext() == false) goto L31;
            c r112 = r111.next().getValue();     // Catch: Exception -> L40
            if (r110 == true) goto L29;
            r112.f();     // Catch: Exception -> L40
            goto L26
        L29:
            r112.g(r109);     // Catch: Exception -> L40
            goto L26
        L31:
            r100.f404643g = r109;     // Catch: Exception -> L40
        L32:
            Iterator<Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener>> r113 = r100.f404646j.entrySet().iterator();     // Catch: Exception -> L40
        L34:
            if (r113.hasNext() == false) goto L55;
            ViewTreeObserver.OnGlobalLayoutListener r114 = r113.next().getValue();     // Catch: Exception -> L40
            if (r114 == null) goto L34;
            r114.onGlobalLayout();     // Catch: Exception -> L40
            goto L34
        L55:
            return;
        L19:
            r110 = false;
        L14:
            if (r108 >= 0.4d) goto L16;
            r100.f404645i.post(new h(r100));     // Catch: Exception -> L40
            return;
        L39:
            return;
        }

        public b(g r100) {
            this.f404649a = r100;
        }
    }

    public interface c {
        void f();

        void g(int r100);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f404639c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L10;
        this.f404645i.post(new a(this));     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        b();     // Catch: Throwable -> L13
        goto L11
    }

    public final void b() {
        if (this.f404639c == false) goto L5;
        return;
    L5:
        Context r100 = this.f404637a;
        if ((r100 instanceof Activity) == true) goto L8;
        return;
    L8:
        Activity r101 = (Activity) r100;
        if (this.f404642f != null) goto L11;
        this.f404642f = new j(r101);
    L11:
        b r102 = new b(this);
        this.f404640d = r102;
        j.a(this.f404642f.getWindow()).getViewTreeObserver().addOnGlobalLayoutListener(r102);
        this.f404642f.f();
        this.f404639c = true;
    }

    public final void c() {
        if (this.f404639c == true) goto L13;
        return;
    L13:
        b r100 = this.f404640d;     // Catch: Exception -> L12
        if (r100 == null) goto L10;
        j r101 = this.f404642f;     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        j.a(r101.getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(r100);     // Catch: Exception -> L12
        this.f404642f.g();     // Catch: Exception -> L12
    L10:
        this.f404639c = false;
    }

    public g(Context r100) {
        this.f404639c = false;
        this.f404640d = null;
        this.f404643g = 0;
        this.f404644h = 0;
        this.f404646j = new WeakHashMap();
        this.f404647k = new WeakHashMap();
        this.f404637a = r100;
        this.f404645i = new Handler(Looper.getMainLooper());
        Resources r101 = r100.getResources();
        this.f404638b = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        this.f404641e = new Rect();
    }
}
