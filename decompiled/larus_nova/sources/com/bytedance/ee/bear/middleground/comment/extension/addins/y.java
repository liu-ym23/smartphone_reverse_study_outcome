package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class y implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f231572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f231573b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f231574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f231575b;

        public a(View r100, y r101) {
            this.f231574a = r100;
            this.f231575b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f231574a.getViewTreeObserver().removeOnDrawListener(this.f231575b);     // Catch: Throwable -> L4
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
        tt5.a.h("Comment#PerfRecordAddin", "inputComment finish onDraw");
        x r100 = this.f231572a;
        r100.f231562b = true;
        x.c(r100);
        com.bytedance.ee.util.ui.j.c(new a(this.f231573b, this));
    }

    public y(x r100, View r101) {
        this.f231572a = r100;
        this.f231573b = r101;
    }
}
