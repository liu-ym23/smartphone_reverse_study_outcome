package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements ViewTreeObserver.OnDrawListener {
    public final /* synthetic */ af5.a a;
    public final /* synthetic */ View b;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ w b;

        public a(View r1, w r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getViewTreeObserver().removeOnDrawListener(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        this.a.a();
        com.bytedance.ee.util.ui.j.c(new a(this.b, this));
    }

    public w(af5.a r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
