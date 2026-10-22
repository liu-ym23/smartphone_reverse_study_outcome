package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECStoreAwemeFeedVideoZoomController;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreAwemeFeedVideoZoomController implements LifecycleObserver {
    public static final /* synthetic */ int i = 0;
    public ValueAnimator a;
    public boolean b;
    public final n83.m c;
    public ValueAnimator d;
    public int e;
    public ValueAnimator f;
    public final int g;
    public final boolean h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECStoreAwemeFeedVideoZoomController a;

        public b(ECStoreAwemeFeedVideoZoomController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreAwemeFeedVideoZoomController r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ECStoreAwemeFeedVideoZoomController.i;     // Catch: Throwable -> L4
            r0.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ECStoreAwemeFeedVideoZoomController a;

        public c(ECStoreAwemeFeedVideoZoomController r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            ECStoreAwemeFeedVideoZoomController r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            ECStoreAwemeFeedVideoZoomController.a(r0, ((Integer) r3).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        ValueAnimator r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{this.e, 0});
        r1.setDuration(150);
        r1.addUpdateListener(new x3(this));
        Unit r2 = Unit.INSTANCE;
        this.f = r1;
        r1.start();
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (this.b == true) goto L9;
        this.b = true;
        if (this.h == false) goto L7;
        new Handler().post(new b(this));
        return;
    L7:
        b();
        return;
    }

    public final void b() {
        ValueAnimator r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, this.g});
        r1.setDuration(150);
        r1.addUpdateListener(new c(this));
        Unit r2 = Unit.INSTANCE;
        this.a = r1;
        r1.start();
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    public ECStoreAwemeFeedVideoZoomController(int r1, int r2) {
        this.g = r1;
        this.h = false;
        this.c = (n83.m) kn.b.a.get(Integer.valueOf(r2));
    }

    public static final void a(ECStoreAwemeFeedVideoZoomController r1, int r2) {
        if (r2 > r1.g) goto L10;
        if (r2 < 0) goto L12;
        r1.e = r2;
        n83.m r3 = r1.c;
        if (r3 == null) goto L11;
        r3.a();
        return;
    L11:
        return;
    L12:
        return;
    }
}
