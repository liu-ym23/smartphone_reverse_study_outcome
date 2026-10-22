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

/* JADX INFO: loaded from: classes16.dex */
public final class b<V, D, E> implements p95.b, k95.a<D, E>, Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n95.a f224923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<V, D> f224924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f224925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f224926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k95.b<V, D, E> f224927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m95.b<D, E> f224928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f224929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Request.Status f224930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a.C3234a f224931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o95.c<D> f224932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o95.c<E> f224933k;

    public final void a() {
        this.f224930h = Request.Status.WAITING_FOR_SIZE;
        int r100 = this.f224925c;
        int r101 = this.f224926d;
        int r102 = f.f532111a;
        boolean r103 = false;
        if (r100 > 0) goto L7;
        if (r100 == Integer.MIN_VALUE) goto L7;
        boolean r104 = false;
    L8:
        if (r104 == false) goto L16;
        if (r101 > 0) goto L13;
        if (r101 == Integer.MIN_VALUE) goto L13;
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        r103 = true;
    L13:
        r105 = true;
    L16:
        if (r103 == false) goto L18;
        onSizeReady(r100, r101);
        return;
    L18:
        e r106 = ((p95.a) this.f224924b).f528304b;
        int r107 = r106.c();
        int r108 = r106.b();
        if (e.d(r107) == false) goto L24;
        if (e.d(r108) == false) goto L24;
        onSizeReady(r107, r108);
        return;
    L24:
        if (((ArrayList) r106.f532107b).contains(this) == true) goto L27;
        ((ArrayList) r106.f532107b).add(this);
    L27:
        if (r106.f532108c != null) goto L32;
        ViewTreeObserver r109 = r106.f532106a.getViewTreeObserver();
        e.a r110 = new e.a(r106);
        r106.f532108c = r110;
        r109.addOnPreDrawListener(r110);
        return;
    L32:
        return;
    L7:
        r104 = true;
        goto L8
    }

    public final void b() {
        if (this.f224932j == null) goto L6;
        p95.a r100 = (p95.a) this.f224924b;
        r100.getClass();
        tt5.a.h("ProgressiveImageLoader", "target clear resource...");
        r100.f528303a.setImageBitmap(null);
        this.f224932j.recycle();
        this.f224932j = null;
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request
    public final void cancel() {
        Request.Status r100 = this.f224930h;
        Request.Status r101 = Request.Status.CANCELLED;
        if (r100 != r101) goto L5;
        return;
    L5:
        a.C3234a r102 = this.f224931i;
        if (r102 == null) goto L8;
        h r103 = r102.f224922a;
        r103.f502148a.f518405d = true;
        r103.f502153f.dispose();
        r102.f224922a.f502150c = null;
        this.f224931i = null;
    L8:
        b();
        o95.c<E> r104 = this.f224933k;
        if (r104 == null) goto L11;
        r104.recycle();
        this.f224933k = null;
    L11:
        this.f224924b = null;
        this.f224930h = r101;
    }

    @Override // p95.b
    public final void onSizeReady(int r100, int r110) {
        tt5.a.h("ProgressiveImageLoader", String.format("on size ready, width = %d, height = %d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r110)}));
        if (this.f224930h == Request.Status.WAITING_FOR_SIZE) goto L5;
        return;
    L5:
        this.f224930h = Request.Status.RUNNING;
        n95.f r101 = new n95.f(this.f224923a);
        a r102 = this.f224929g;
        m95.b<D, E> r103 = this.f224928f;
        r102.getClass();
        tt5.a.h("ProgressiveImageLoader", "start loader job...");
        h r104 = new h(r101, r103, this, r100, r110);
        r104.f502153f.add(Flowable.create(new g(r104), BackpressureStrategy.BUFFER).subscribeOn(d.f()).observeOn(d.d()).subscribe(new k95.c(r104), new k95.d(r104), new k95.e(r104)));
        this.f224931i = new a.C3234a(r104);
    }

    public b(n95.a r100, p95.a r101, ProgressivePhotoView.a r102, m95.e r103, a r104) {
        Request.Status r105 = Request.Status.PENDING;
        this.f224923a = r100;
        this.f224924b = r101;
        this.f224925c = -1;
        this.f224926d = -1;
        this.f224927e = r102;
        this.f224928f = r103;
        this.f224929g = r104;
        this.f224930h = r105;
    }
}
