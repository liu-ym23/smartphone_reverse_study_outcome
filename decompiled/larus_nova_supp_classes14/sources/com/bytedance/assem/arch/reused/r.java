package com.bytedance.assem.arch.reused;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.by.inflate_lib.AsyncInflater;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements Runnable {
    public final /* synthetic */ ReusedUISlotAssem a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    public static final class a implements Runnable {
        public final /* synthetic */ r a;
        public final /* synthetic */ View b;

        public a(r r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((ViewGroup) this.a.c).addView(this.b);     // Catch: Throwable -> L4
            this.a.a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r(ReusedUISlotAssem r1, int r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Context r0 = this.a.getContext();
        if (r0 == null) goto L7;
        View r1 = AsyncInflater.inflate((Activity) r0, this.b);
        ReusedUISlotAssem r2 = this.a;
        r2.h = this.c;
        r2.A = r1;
        r2.p(r1);
        ReusedUISlotAssem.x(this.a).post(new a(this, r1));
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
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
