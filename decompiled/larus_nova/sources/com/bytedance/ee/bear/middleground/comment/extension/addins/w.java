package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ af5.a f231558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f231559b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f231560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f231561b;

        public a(View r100, w r101) {
            this.f231560a = r100;
            this.f231561b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f231560a.getViewTreeObserver().removeOnDrawListener(this.f231561b);     // Catch: Throwable -> L4
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
        this.f231558a.a();
        com.bytedance.ee.util.ui.j.c(new a(this.f231559b, this));
    }

    public w(af5.a r100, View r101) {
        this.f231558a = r100;
        this.f231559b = r101;
    }
}
