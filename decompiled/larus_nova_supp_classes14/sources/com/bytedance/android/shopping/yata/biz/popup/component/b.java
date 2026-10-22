package com.bytedance.android.shopping.yata.biz.popup.component;

import android.view.View;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SheetBaseBehavior<?> r0 = this.a.a.g;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            r0.setState(3);     // Catch: Throwable -> L8
            if (r0.c == true) goto L15;
            r0.setState(4);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public b(c r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.shopping.yata.biz.popup.a r0 = this.a.a;
        if (r0 == null) goto L11;
        hl3.e r1 = r0.b;
        if (r1 == null) goto L7;
        r1.f(r0);
    L7:
        Iterator<hl3.b> r2 = r0.c.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().f(r0);
    L11:
        SheetBaseBehavior<?> r3 = this.a.g;
        if (r3 == null) goto L14;
        r3.setState(5);
    L14:
        this.a.e(true);
        View r4 = this.a.e;
        if (r4 == null) goto L19;
        r4.post(new a(this));
        return;
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
