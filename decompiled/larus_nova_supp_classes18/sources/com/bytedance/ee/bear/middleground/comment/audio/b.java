package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.MotionEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b implements d {
    public boolean a;
    public boolean b;
    public Disposable c;
    public long d;

    public final void c() {
        this.b = false;
        Disposable r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.c.dispose();
        return;
    }

    public b() {
        this.a = true;
        this.b = false;
    }

    public final void d(MotionEvent r7) {
        int r8 = r7.getAction();
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L6;
    L8:
        this.b = false;
        if (this.a == false) goto L14;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.d) <= 210) goto L13;
        this.d = r0;
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
        if (r8 == 3) goto L8;
        return;
    L16:
        this.c = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new a(this)).subscribe();
        this.a = true;
        this.b = false;
    }
}
