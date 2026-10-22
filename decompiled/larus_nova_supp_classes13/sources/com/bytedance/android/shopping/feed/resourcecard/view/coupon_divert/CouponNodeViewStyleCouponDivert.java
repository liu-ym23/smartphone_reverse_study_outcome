package com.bytedance.android.shopping.feed.resourcecard.view.coupon_divert;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.CouponCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feed.resourcecard.view.CouponNodeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import yd3.m;
import yd3.p;
import yd3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/coupon_divert/CouponNodeViewStyleCouponDivert;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeView;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroidx/lifecycle/LifecycleObserver;", "", "stopCountDown", "resumeCountDown", "pauseCountDown", "Lb53/a;", "event", "onCountDownStopEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponNodeViewStyleCouponDivert extends CouponNodeView implements l1.a, LifecycleObserver {
    public static final /* synthetic */ int d = 0;
    public Map<Integer, View> a;
    public volatile boolean b;
    public rd3.a c;

    public static final class a implements Runnable {
        public final /* synthetic */ CouponNodeViewStyleCouponDivert a;
        public final /* synthetic */ Context b;

        public a(CouponNodeViewStyleCouponDivert r1, Context r2) {
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

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CouponNodeViewStyleCouponDivert a;

        public c(CouponNodeViewStyleCouponDivert r1) {
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

    public CouponNodeViewStyleCouponDivert(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponNodeViewStyleCouponDivert(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onStart() {
    }

    public final void c() {
        if (this.b == true) goto L15;
        rd3.a r0 = this.c;
        if (r0 == null) goto L13;
        p r1 = r0.i();
        if (r1 == null) goto L13;
        yd3.b r2 = r1.d();
        if (r2 == null) goto L13;
        ECUrlModel r3 = r2.g();
        if (r3 == null) goto L13;
        y.a(b(2131370421), r3);
    L13:
        ((LinearLayout) b(2131378833)).setVisibility(8);
        TextView r4 = (TextView) b(2131391148);
        int r5 = g1.a;
        r4.setTextColor(g1.a.a(getContext(), 2131101763));
        ((TextView) b(2131391161)).setTextColor(g1.a.a(getContext(), 2131101763));
        ((TextView) b(2131391639)).setTextColor(g1.a.a(getContext(), 2131101763));
        ((TextView) b(2131391149)).setTextColor(g1.a.a(getContext(), 2131101763));
        ((TextView) b(2131390587)).setVisibility(0);
        this.b = true;
        return;
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
        post(new c(this));
        dm.a.a("CouponDivertCouponView").a("stopCountDown");
    }

    public final void onFinish() {
        c();
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.CouponNodeView
    public final void a(rd3.a r16) {
        Intrinsics.checkNotNullParameter(r16, "anchorInflowFeedItem");
        Intrinsics.checkNotNullParameter(r16, "anchorInflowFeedItem");
        p r0 = r16.i();
        if (r0 == null) goto L75;
        yd3.b r1 = r0.d();
        if (r1 == null) goto L77;
        this.c = r16;
        p r2 = r16.i();
        ConstraintLayout.LayoutParams r3 = null;
        if (r2 == null) goto L10;
        m r10 = r2.l();
    L12:
        if (r1.b() != 8) goto L76;
        s r4 = r1.k();
        long r5 = 0;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNullParameter(r4, "$this$isExpire");
        Long r6 = r4.a();
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 != true) goto L23;
        c();
    L24:
        Long r8 = r1.i();
        if (r8 == null) goto L29;
        long r9 = r8.longValue();
        TextView r11 = (TextView) b(2131391148);
        if (r11 == null) goto L29;
        r11.setText(String.valueOf(r9 / ((long) 100)));
    L29:
        String r12 = r1.f();
        if (r12 == null) goto L32;
        ((TextView) b(2131391639)).setText(r12);
    L32:
        String r13 = r1.j();
        if (r13 == null) goto L35;
        ((TextView) b(2131391149)).setText(r13);
    L35:
        float r14 = (k1.m(getContext()) - (vf4.a.b(12) * 2)) - (vf4.a.b(10) * 2);
        float r15 = 331;
        float r17 = ((25.0f * r14) / r15) + vf4.a.b(10);
        float r18 = ((86.0f * r14) / r15) + vf4.a.b(10);
        float r19 = ((12.0f * r14) / r15) + vf4.a.b(10);
        float r20 = ((r14 * 20.0f) / r15) + vf4.a.b(10);
        ViewGroup.LayoutParams r21 = ((LinearLayout) b(2131378732)).getLayoutParams();
        if ((r21 instanceof ConstraintLayout.LayoutParams) == true) goto L38;
        r21 = null;
    L38:
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
        if (r22 == null) goto L41;
        ((ViewGroup.MarginLayoutParams) r22).leftMargin = (int) r17;
    L41:
        ViewGroup.LayoutParams r23 = ((LinearLayout) b(2131378634)).getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == true) goto L44;
        r23 = null;
    L44:
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        if (r24 == null) goto L47;
        ((ViewGroup.MarginLayoutParams) r24).leftMargin = (int) r18;
    L47:
        ViewGroup.LayoutParams r25 = ((LinearLayout) b(2131378833)).getLayoutParams();
        if ((r25 instanceof ConstraintLayout.LayoutParams) == true) goto L50;
        r25 = null;
    L50:
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
        if (r26 == null) goto L53;
        ((ViewGroup.MarginLayoutParams) r26).rightMargin = (int) r19;
    L53:
        ConstraintLayout.LayoutParams r27 = ((TextView) b(2131390587)).getLayoutParams();
        if ((r27 instanceof ConstraintLayout.LayoutParams) == false) goto L57;
        r3 = r27;
    L57:
        ConstraintLayout.LayoutParams r28 = r3;
        if (r28 == null) goto L61;
        ((ViewGroup.MarginLayoutParams) r28).rightMargin = (int) r20;
    L61:
        if (r1.k() != null) goto L63;
    L68:
        ExtensionsKt.gone(b(2131378833));
    L70:
        if (r10 == null) goto L72;
        setBackgroundResource(2131233411);
        setPadding(0, vf4.a.b(8), 0, 0);
    L73:
        setOnClickListener(new zd3.a(this, r16));
        return;
    L72:
        setPadding(0, 0, 0, vf4.a.b(8));
        goto L73
    L63:
        if (xd3.b.a(r1.k()) == false) goto L68;
        long r29 = System.currentTimeMillis() / 1000;
        Long r30 = r1.k().a();
        if (r30 == null) goto L67;
        r5 = r30.longValue();
    L67:
        s0.c(this);
        Lazy r31 = CouponCountDownTimer.c;
        CouponCountDownTimer.a.a().a(r29, r5, this, TimeUnit.SECONDS.toMillis(1) / ((long) 10));
        dm.a.a("CouponDivertCouponView").a("startCountDown");
        ExtensionsKt.visible(b(2131378833));
        goto L70
    L18:
        if ((r6.longValue() - (System.currentTimeMillis() / ((long) 1000))) > 0) goto L20;
        r7 = true;
    L23:
        y.a(b(2131370421), r1.c());
        goto L24
    L76:
        return;
    L10:
        r10 = null;
        goto L12
    L77:
        return;
    }

    public final View b(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
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
        ((TextView) b(2131390757)).setText(r6.c);
        ((TextView) b(2131390954)).setText(r6.d);
        TextView r7 = (TextView) b(2131391365);
        int r1 = g1.a;
        r7.setText(g1.a.c(getContext(), 2131896511, new Object[]{r6.e, r6.f}));
        return;
    }

    public CouponNodeViewStyleCouponDivert(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560562, this, true);
        post(new a(this, r2));
    }

    public /* synthetic */ CouponNodeViewStyleCouponDivert(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
