package com.bytedance.ee.bear.middleground.comment.input;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements bb5.h {
    public final /* synthetic */ AsideInputComment a;

    public static final class a implements Runnable {
        public final /* synthetic */ AsideInputComment a;

        public a(AsideInputComment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseInputComment.y(this.a);     // Catch: Throwable -> L6
            if (this.a.q.isSelected() == true) goto L9;
            this.a.e().requestFocus();     // Catch: Throwable -> L6
            BaseInputComment.x0(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onDismiss() {
        com.bytedance.ee.util.ui.j.d(new a(this.a), 100);
    }

    public c(AsideInputComment r1) {
        this.a = r1;
    }
}
