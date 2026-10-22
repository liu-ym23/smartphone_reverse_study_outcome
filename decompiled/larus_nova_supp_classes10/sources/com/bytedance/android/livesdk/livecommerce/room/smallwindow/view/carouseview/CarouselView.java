package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u000b\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView$c;", "listener", "", "setCarouseViewListener", "", "height", "setViewHeight", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "getCountDownHandler", "()Landroid/os/Handler;", "countDownHandler", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "h", "getValueAnimator", "()Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarouselView extends FrameLayout {
    public final Lazy a;
    public boolean b;
    public final d c;
    public final long d;
    public float e;
    public b f;
    public boolean g;
    public final Lazy h;

    public static final class a {
    }

    public interface b {
        Long getRollingInterval();
    }

    public interface c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CarouselView a;

        public d(CarouselView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CarouselView r0 = this.a;     // Catch: Throwable -> L6
            if (r0.b == false) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public CarouselView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CarouselView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Handler getCountDownHandler() {
        return (Handler) this.a.getValue();
    }

    private final ValueAnimator getValueAnimator() {
        return (ValueAnimator) this.h.getValue();
    }

    public void setCarouseViewListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void b() {
        b r0 = this.f;
        if (r0 == null) goto L7;
        Long r1 = r0.getRollingInterval();
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
    L9:
        if (r2 < 0) goto L11;
        getCountDownHandler().postDelayed(this.c, r2);
        return;
    L11:
        c();
        return;
    L7:
        r2 = this.d;
        goto L9
    }

    public final void c() {
        if (this.b == true) goto L5;
        return;
    L5:
        this.b = false;
        getCountDownHandler().removeCallbacks(this.c);
    }

    public final void a() {
        getValueAnimator().start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        getValueAnimator().cancel();     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        c();
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public void setViewHeight(float r1) {
        this.e = r1;
    }

    public CarouselView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(CarouselView$countDownHandler$2.INSTANCE);
        this.c = new d(this);
        this.d = 1;
        this.e = UtilityKotlinExtentionsKt.c(12);
        this.g = true;
        this.h = LazyKt.lazy(new CarouselView$valueAnimator$2(this));
    }

    public /* synthetic */ CarouselView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
