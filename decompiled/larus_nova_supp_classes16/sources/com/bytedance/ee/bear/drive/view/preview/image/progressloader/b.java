package com.bytedance.ee.bear.drive.view.preview.image.progressloader;

import android.view.ViewTreeObserver;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.ProgressivePhotoView;
import fo5.d;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import k95.g;
import k95.h;
import p95.c;
import q95.e;
import q95.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<V, D, E> implements p95.b, k95.a<D, E>, Request {
    public final n95.a a;
    public c<V, D> b;
    public final int c;
    public final int d;
    public final k95.b<V, D, E> e;
    public final m95.b<D, E> f;
    public final a g;
    public Request.Status h;
    public a.C0178a i;
    public o95.c<D> j;
    public o95.c<E> k;

    public final void a() {
        this.h = Request.Status.WAITING_FOR_SIZE;
        int r0 = this.c;
        int r1 = this.d;
        int r2 = f.a;
        boolean r3 = false;
        if (r0 > 0) goto L7;
        if (r0 == Integer.MIN_VALUE) goto L7;
        boolean r5 = false;
    L8:
        if (r5 == false) goto L16;
        if (r1 > 0) goto L13;
        if (r1 == Integer.MIN_VALUE) goto L13;
        boolean r4 = false;
    L14:
        if (r4 == false) goto L16;
        r3 = true;
    L13:
        r4 = true;
    L16:
        if (r3 == false) goto L18;
        onSizeReady(r0, r1);
        return;
    L18:
        e r6 = ((p95.a) this.b).b;
        int r7 = r6.c();
        int r8 = r6.b();
        if (e.d(r7) == false) goto L24;
        if (e.d(r8) == false) goto L24;
        onSizeReady(r7, r8);
        return;
    L24:
        if (((ArrayList) r6.b).contains(this) == true) goto L27;
        ((ArrayList) r6.b).add(this);
    L27:
        if (r6.c != null) goto L32;
        ViewTreeObserver r9 = r6.a.getViewTreeObserver();
        e.a r10 = new e.a(r6);
        r6.c = r10;
        r9.addOnPreDrawListener(r10);
        return;
    L32:
        return;
    L7:
        r5 = true;
        goto L8
    }

    public final void b() {
        if (this.j == null) goto L6;
        p95.a r0 = (p95.a) this.b;
        r0.getClass();
        tt5.a.h("ProgressiveImageLoader", "target clear resource...");
        r0.a.setImageBitmap(null);
        this.j.recycle();
        this.j = null;
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request
    public final void cancel() {
        Request.Status r0 = this.h;
        Request.Status r1 = Request.Status.CANCELLED;
        if (r0 != r1) goto L5;
        return;
    L5:
        a.C0178a r2 = this.i;
        if (r2 == null) goto L8;
        h r3 = r2.a;
        r3.a.d = true;
        r3.f.dispose();
        r2.a.c = null;
        this.i = null;
    L8:
        b();
        o95.c<E> r4 = this.k;
        if (r4 == null) goto L11;
        r4.recycle();
        this.k = null;
    L11:
        this.b = null;
        this.h = r1;
    }

    @Override // p95.b
    public final void onSizeReady(int r9, int r10) {
        tt5.a.h("ProgressiveImageLoader", String.format("on size ready, width = %d, height = %d", new Object[]{Integer.valueOf(r9), Integer.valueOf(r10)}));
        if (this.h == Request.Status.WAITING_FOR_SIZE) goto L5;
        return;
    L5:
        this.h = Request.Status.RUNNING;
        n95.f r3 = new n95.f(this.a);
        a r0 = this.g;
        m95.b<D, E> r4 = this.f;
        r0.getClass();
        tt5.a.h("ProgressiveImageLoader", "start loader job...");
        h r1 = new h(r3, r4, this, r9, r10);
        r1.f.add(Flowable.create(new g(r1), BackpressureStrategy.BUFFER).subscribeOn(d.f()).observeOn(d.d()).subscribe(new k95.c(r1), new k95.d(r1), new k95.e(r1)));
        this.i = new a.C0178a(r1);
    }

    public b(n95.a r2, p95.a r3, ProgressivePhotoView.a r4, m95.e r5, a r6) {
        Request.Status r0 = Request.Status.PENDING;
        this.a = r2;
        this.b = r3;
        this.c = -1;
        this.d = -1;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r0;
    }
}
