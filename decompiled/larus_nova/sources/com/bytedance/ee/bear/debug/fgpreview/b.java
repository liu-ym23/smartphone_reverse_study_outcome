package com.bytedance.ee.bear.debug.fgpreview;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FGPreviewAdapter.MultiViewHolder f217397a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FGPreviewAdapter.MultiViewHolder f217398a;

        public a(FGPreviewAdapter.MultiViewHolder r100) {
            this.f217398a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f217398a.f217390c.setVisibility(0);     // Catch: Throwable -> L4
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
    public static final class RunnableC3097b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FGPreviewAdapter.MultiViewHolder f217399a;

        public RunnableC3097b(FGPreviewAdapter.MultiViewHolder r100) {
            this.f217399a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f217399a.f217390c.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(FGPreviewAdapter.MultiViewHolder r100) {
        this.f217397a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f217397a.f217390c.getVisibility() != 8) goto L5;
        this.f217397a.f217389b.animate().rotationBy(180.0f).setDuration(200).withEndAction(new a(this.f217397a)).start();
        return;
    L5:
        this.f217397a.f217389b.animate().rotationBy(-180.0f).setDuration(200).withEndAction(new RunnableC3097b(this.f217397a)).start();
    }
}
