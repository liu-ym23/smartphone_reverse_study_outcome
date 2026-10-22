package com.ss.android.lark.movable.selection;

import android.view.View;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f432807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f432808b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f432809a;

        public a(o r100) {
            this.f432809a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f432809a.f432814c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public l(LinearLayout r100, o r101) {
        this.f432807a = r100;
        this.f432808b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f432807a.post(new a(this.f432808b));
    }
}
