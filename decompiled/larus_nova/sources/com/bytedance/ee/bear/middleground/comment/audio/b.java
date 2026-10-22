package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.MotionEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f230331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f230332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f230333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f230334d;

    public final void c() {
        this.f230332b = false;
        Disposable r100 = this.f230333c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        this.f230333c.dispose();
        return;
    }

    public b() {
        this.f230331a = true;
        this.f230332b = false;
    }

    public final void d(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L16;
        if (r101 != 1) goto L6;
    L8:
        this.f230332b = false;
        if (this.f230331a == false) goto L14;
        long r102 = System.currentTimeMillis();
        if ((r102 - this.f230334d) <= 210) goto L13;
        this.f230334d = r102;
        onClick();
    L15:
        c();
        return;
    L13:
        tt5.a.k("Comment#AbsMotionCallbackListener", "So fast click , ignored !");
        goto L15
    L14:
        b();
        goto L15
    L6:
        if (r101 == 3) goto L8;
        return;
    L16:
        this.f230333c = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new a(this)).subscribe();
        this.f230331a = true;
        this.f230332b = false;
    }
}
