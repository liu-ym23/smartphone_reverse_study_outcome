package com.ss.android.dypay.base.h;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import tta.e;
import tta.g;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f408450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f408451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f408452c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f408453a;

        public a(c r100) {
            this.f408453a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f408453a;     // Catch: Throwable -> L6
            Function1 r101 = r100.f408452c;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            Unit r102 = (Unit) r101.invoke((Drawable) r100.f408450a.element);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f408454a;

        public b(c r100) {
            this.f408454a = r100;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String r100) {
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            tta.c.f547573d.post(new com.ss.android.dypay.base.h.a(this));
        L9:
            return Unit.INSTANCE;
        L5:
            r101 = false;
            goto L6
        }
    }

    public c(Ref.ObjectRef r100, String r101, com.ss.android.dypay.views.c r102) {
        this.f408450a = r100;
        this.f408451b = r101;
        this.f408452c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.graphics.drawable.Drawable] */
    public final void a() {
        Ref.ObjectRef r100 = this.f408450a;
        r100.element = tta.c.f547572c.b(this.f408451b);
        if (((Drawable) this.f408450a.element) == null) goto L6;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    L6:
        e r101 = tta.c.f547570a;
        String r102 = this.f408451b;
        b r103 = new b(this);
        r101.getClass();
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L17;
        ThreadMethodProxy.start(new PthreadThreadV2(new uta.a(r102, new g(r103, r102)), "ypay/base/h/c"));
        return;
    L17:
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r104 = false;
        goto L13
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
}
