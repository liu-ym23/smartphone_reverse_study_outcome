package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import com.bytedance.android.livesdk.livecommerce.utils.t0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements yk2.a {
    public final CompositeDisposable a;
    public Function2<? super yk2.a, ? super Boolean, Unit> b;
    public final boolean c;
    public final long d;
    public final long e;
    public final yk2.b f;

    @Override // yk2.a
    public final void release() {
        this.b = null;
        this.a.clear();
    }

    @Override // yk2.a
    public final void start() {
        if (this.a.size() != 0) goto L14;
        long r0 = this.d;
        long r2 = this.e;
        yk2.b r4 = this.f;
        if ((r4 instanceof WebpAnimatedWidget) == true) goto L7;
        r4 = null;
    L7:
        WebpAnimatedWidget r5 = (WebpAnimatedWidget) r4;
        if (r5 != null) goto L10;
    L12:
        int r6 = t0.a;
        Disposable r1 = t0.a(r0, r2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullParameter(r1, "$this$disposeOnClear");
        this.a.add(r1);
        System.currentTimeMillis();
        return;
    L10:
        if (r5.h != true) goto L12;
        r0 = r2;
        goto L12
    }

    @Override // yk2.a
    public final void stop() {
        this.a.clear();
    }

    public b(WebpAnimatedWidget r3) {
        Intrinsics.checkNotNullParameter(r3, "target");
        this.d = 0;
        this.e = 10;
        this.f = r3;
        this.a = new CompositeDisposable();
        this.c = true;
    }
}
