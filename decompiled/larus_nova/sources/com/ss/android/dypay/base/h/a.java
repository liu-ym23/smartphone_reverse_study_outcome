package com.ss.android.dypay.base.h;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f408448a;

    /* JADX INFO: renamed from: com.ss.android.dypay.base.h.a$a, reason: collision with other inner class name */
    public static final class RunnableC4735a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408449a;

        public RunnableC4735a(a r100) {
            this.f408449a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f408449a.f408448a.f408454a;     // Catch: Throwable -> L6
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

    public a(c.b r100) {
        this.f408448a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, android.graphics.drawable.Drawable] */
    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f408448a.f408454a;     // Catch: Throwable -> L4
        Ref.ObjectRef r101 = r100.f408450a;     // Catch: Throwable -> L4
        r101.element = tta.c.f547572c.b(r100.f408451b);     // Catch: Throwable -> L4
        new Handler(Looper.getMainLooper()).post(new RunnableC4735a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
