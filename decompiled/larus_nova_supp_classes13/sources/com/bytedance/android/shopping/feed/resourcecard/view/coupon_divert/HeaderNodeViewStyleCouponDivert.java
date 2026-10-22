package com.bytedance.android.shopping.feed.resourcecard.view.coupon_divert;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.CouponCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import yd3.f;
import yd3.g;
import yd3.s;
import yd3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/coupon_divert/HeaderNodeViewStyleCouponDivert;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroidx/lifecycle/LifecycleObserver;", "", "stopCountDown", "resumeCountDown", "pauseCountDown", "Lb53/a;", "event", "onCountDownStopEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyleCouponDivert extends HeaderNodeView implements l1.a, LifecycleObserver {
    public static final /* synthetic */ int f = 0;
    public final ECDraweeView c;
    public final TextView d;
    public final TextView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HeaderNodeViewStyleCouponDivert a;
        public final /* synthetic */ Context b;

        public a(HeaderNodeViewStyleCouponDivert r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            HeaderNodeViewStyleCouponDivert r1 = this.a;
            int r2 = HeaderNodeViewStyleCouponDivert.f;
            rd3.a r4 = r1.getAnchorInflowFeedItem();
            if (r4 == null) goto L5;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r4, BuyNowCloseMethod.OTHERS, null, null, null, null, null, 124);
        L5:
            String r3 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c870003.d993139", PageFinder.via(this.a), null, 4, null);
            f r5 = this.a.getHeaderNode();
            if (r5 == null) goto L11;
            g r6 = r5.c();
            if (r6 == null) goto L12;
            p r7 = p.a;
            Context r8 = this.b;
            int r9 = md3.a.a;
            r7.openSchema(r8, md3.a.a(r6.c(), r3));
            return;
        L12:
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ HeaderNodeViewStyleCouponDivert a;
        public final /* synthetic */ Context b;

        public b(HeaderNodeViewStyleCouponDivert r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LifecycleOwner r0 = this.b;     // Catch: Throwable -> L8
            if ((r0 instanceof LifecycleOwner) == false) goto L11;
            if (r0 == null) goto L7;
            r0.getLifecycle().addObserver(this.a);     // Catch: Throwable -> L8
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L8
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ HeaderNodeViewStyleCouponDivert a;

        public d(HeaderNodeViewStyleCouponDivert r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if ((this.a.getContext() instanceof LifecycleOwner) == false) goto L12;
            LifecycleOwner r0 = this.a.getContext();     // Catch: Throwable -> L9
            if (r0 == null) goto L8;
            r0.getLifecycle().removeObserver(this.a);     // Catch: Throwable -> L9
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
        }
    }

    static {
    }

    public HeaderNodeViewStyleCouponDivert(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeViewStyleCouponDivert(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onStart() {
    }

    public final void onFinish() {
        TextView r0 = this.e;
        int r1 = g1.a;
        r0.setText(g1.a.c(getContext(), 2131896509, new Object[0]));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pauseCountDown() {
        Lazy r0 = CouponCountDownTimer.c;
        l1 r1 = CouponCountDownTimer.a.a().b;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        dm.a.a("CouponCountDownTimer").a("pauseCountDown");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resumeCountDown() {
        Lazy r0 = CouponCountDownTimer.c;
        l1 r1 = CouponCountDownTimer.a.a().b;
        if (r1 == null) goto L5;
        r1.c();
    L5:
        dm.a.a("CouponCountDownTimer").a("resumeCountDown");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopCountDown() {
        Lazy r0 = CouponCountDownTimer.c;
        CouponCountDownTimer.a.a().b();
        post(new d(this));
        dm.a.a("CouponDivertHeaderView").a("stopCountDown");
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r13) {
        Intrinsics.checkNotNullParameter(r13, "anchorInflowFeedItem");
        super.a(r13);
        TextView r14 = this.d;
        f r0 = getHeaderNode();
        s r1 = null;
        if (r0 == null) goto L7;
        g r2 = r0.c();
        if (r2 == null) goto L7;
        String r3 = r2.d();
    L8:
        r14.setText(r3);
        ECDraweeView r4 = this.c;
        f r15 = getHeaderNode();
        if (r15 == null) goto L13;
        t r16 = r15.f();
        if (r16 == null) goto L13;
        ECUrlModel r5 = r16.b();
    L14:
        h0.d(r4, r5, null, null, null, null, null, 120);
        f r17 = getHeaderNode();
        if (r17 == null) goto L17;
        r1 = r17.e();
    L17:
        if (r1 == null) goto L33;
        f r18 = getHeaderNode();
        if (r18 == null) goto L33;
        s r19 = r18.e();
        if (r19 == null) goto L33;
        if (xd3.b.a(r19) != true) goto L33;
        this.e.setVisibility(0);
        long r6 = System.currentTimeMillis() / 1000;
        f r110 = getHeaderNode();
        if (r110 == null) goto L31;
        s r111 = r110.e();
        if (r111 == null) goto L31;
        Long r112 = r111.a();
        if (r112 == null) goto L31;
        long r7 = r112.longValue();
    L32:
        s0.c(this);
        Lazy r113 = CouponCountDownTimer.c;
        CouponCountDownTimer.a.a().a(r6, r7, this, TimeUnit.SECONDS.toMillis(1) / ((long) 10));
        dm.a.a("CouponDivertHeaderView").a("startCountDown");
        return;
    L31:
        r7 = 0;
    L33:
        this.e.setVisibility(4);
        return;
    L13:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Subscribe
    public final void onCountDownStopEvent(b53.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        stopCountDown();
        s0.e(this);
    }

    public final void onTick(long r5) {
        if (r5 <= 0) goto L6;
        int r0 = c2.h;
        c2 r6 = c2.a.a(getContext(), r5, false);
        TextView r7 = this.e;
        int r1 = g1.a;
        r7.setText(g1.a.c(getContext(), 2131896510, new Object[]{r6.c, r6.d, r6.e, r6.f}));
        return;
    }

    public HeaderNodeViewStyleCouponDivert(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560582, this, true);
        this.c = findViewById(2131374258);
        this.d = (TextView) findViewById(2131374264);
        LinearLayout r5 = (LinearLayout) findViewById(2131374263);
        this.e = (TextView) findViewById(2131374215);
        setOnClickListener(new a(this, r2));
        post(new b(this, r2));
    }

    public /* synthetic */ HeaderNodeViewStyleCouponDivert(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
