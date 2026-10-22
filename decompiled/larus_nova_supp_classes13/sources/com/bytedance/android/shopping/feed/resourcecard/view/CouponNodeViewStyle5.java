package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeViewStyle5;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeView;", "Landroidx/lifecycle/LifecycleObserver;", "", "stopCountDown", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponNodeViewStyle5 extends CouponNodeView implements LifecycleObserver {
    public static final /* synthetic */ int e = 0;
    public final ECDraweeView a;
    public final TextView b;
    public final CouponCountDownView c;
    public final TextView d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CouponNodeViewStyle5 a;

        public b(CouponNodeViewStyle5 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context r0 = this.a.getContext();     // Catch: Throwable -> L11
            if ((r0 instanceof LifecycleOwner) == true) goto L5;
            r0 = null;
        L5:
            LifecycleOwner r1 = (LifecycleOwner) r0;     // Catch: Throwable -> L11
            if (r1 == null) goto L14;
            Lifecycle r2 = r1.getLifecycle();     // Catch: Throwable -> L11
            if (r2 == null) goto L18;
            r2.removeObserver(this.a);     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public CouponNodeViewStyle5(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponNodeViewStyle5(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopCountDown() {
        CouponCountDownView r0 = this.c;
        if (r0 == null) goto L7;
        ActivityCountDownTimer r1 = r0.d;
        if (r1 == null) goto L7;
        r1.c();
    L7:
        post(new b(this));
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.CouponNodeView
    public final void a(rd3.a r12) {
        Intrinsics.checkNotNullParameter(r12, "anchorInflowFeedItem");
        yd3.p r13 = r12.i();
        if (r13 == null) goto L37;
        yd3.b r14 = r13.d();
        if (r14 == null) goto L40;
        TextView r0 = this.b;
        if (r0 == null) goto L10;
        r0.setText(com.bytedance.android.shopping.extensions.i.a(r14.i()) + getContext().getString(2131896664));
    L10:
        y.a(this.a, r14.c());
        CouponCountDownView r1 = this.c;
        LifecycleOwner r2 = null;
        if (r1 == null) goto L27;
        ActivityCountDownTimer r3 = new ActivityCountDownTimer();
        yd3.s r15 = r14.k();
        if (r15 == null) goto L17;
        Long r16 = r15.a();
        if (r16 == null) goto L17;
        Long r17 = Long.valueOf(r16.longValue() + (SystemClock.elapsedRealtime() / ((long) 1000)));
    L18:
        Function0<Unit> r4 = new CouponNodeViewStyle5$bind$1(this);
        Intrinsics.checkNotNullParameter(r3, "activityCountDownTimer");
        Intrinsics.checkNotNullParameter(r4, "finishCB");
        r1.f = r4;
        if (r17 == null) goto L27;
        r17.longValue();
        r1.d(r17.longValue());
        if (r1.d != null) goto L24;
        r1.d = r3;
    L24:
        ActivityCountDownTimer r5 = r1.d;
        if (r5 == null) goto L27;
        r5.a(SystemClock.elapsedRealtime() / 1000, r17.longValue(), r1.e, null);
    L17:
        r17 = null;
    L27:
        LifecycleOwner r18 = getContext();
        if ((r18 instanceof LifecycleOwner) == false) goto L31;
        r2 = r18;
    L31:
        LifecycleOwner r6 = r2;
        if (r6 == null) goto L38;
        Lifecycle r19 = r6.getLifecycle();
        if (r19 == null) goto L39;
        r19.addObserver(this);
        return;
    L39:
        return;
    L38:
        return;
    L40:
        return;
    }

    public CouponNodeViewStyle5(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560560, this, true);
        this.a = findViewById(2131368129);
        this.b = (TextView) findViewById(2131368126);
        this.c = (CouponCountDownView) findViewById(2131368046);
        this.d = (TextView) findViewById(2131368022);
    }

    public /* synthetic */ CouponNodeViewStyle5(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
