package com.bytedance.ee.bear.debug.fgpreview;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FGPreviewAdapter.MultiViewHolder a;

    public static final class a implements Runnable {
        public final /* synthetic */ FGPreviewAdapter.MultiViewHolder a;

        public a(FGPreviewAdapter.MultiViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.setVisibility(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.debug.fgpreview.b$b, reason: collision with other inner class name */
    public static final class RunnableC0041b implements Runnable {
        public final /* synthetic */ FGPreviewAdapter.MultiViewHolder a;

        public RunnableC0041b(FGPreviewAdapter.MultiViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(FGPreviewAdapter.MultiViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.c.getVisibility() != 8) goto L5;
        this.a.b.animate().rotationBy(180.0f).setDuration(200).withEndAction(new a(this.a)).start();
        return;
    L5:
        this.a.b.animate().rotationBy(-180.0f).setDuration(200).withEndAction(new RunnableC0041b(this.a)).start();
    }
}
