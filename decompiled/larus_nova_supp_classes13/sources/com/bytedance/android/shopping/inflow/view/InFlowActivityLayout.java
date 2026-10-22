package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2Slogan;
import com.bytedance.android.ec.model.response.anchorv3.CountDown;
import com.bytedance.android.shopping.feed.utils.h;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InFlowActivityLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "getLayout", "Lkotlin/Function1;", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;", "", "onActivityChangeListener", "setOnActivityChangeListener", "resumeCountDown", "pauseCountDown", "stopCountDown", "Lb53/a;", "event", "onActivityCountDownStopEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowActivityLayout extends FrameLayout implements l1.a, LifecycleObserver, com.bytedance.android.shopping.feed.view.c {
    public Map<Integer, View> a;
    public CommonGirdleStructV2 b;
    public Function1<? super CommonGirdleStructV2, Unit> c;
    public long d;
    public long e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CommonGirdleStructV2 a;
        public final /* synthetic */ InFlowActivityLayout b;

        public b(CommonGirdleStructV2 r1, InFlowActivityLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super CommonGirdleStructV2, Unit> r0 = this.b.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InFlowActivityLayout a;

        public c(InFlowActivityLayout r1) {
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

    public InFlowActivityLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowActivityLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public final void onStart() {
    }

    public final void onFinish() {
        Lazy r0 = ActivityCountDownTimer.c;
        boolean r2 = true;
        ActivityCountDownTimer.a.a().a--;
        ActivityCountDownTimer r1 = ActivityCountDownTimer.a.a();
        if (r1.a == 0) goto L6;
        r2 = false;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L14;
        CommonGirdleStructV2 r3 = this.b;
        if (r3 == null) goto L15;
        postDelayed(new b(r3, this), 1000);
        return;
    L15:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pauseCountDown() {
        Lazy r0 = ActivityCountDownTimer.c;
        l1 r1 = ActivityCountDownTimer.a.a().b;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resumeCountDown() {
        Lazy r0 = ActivityCountDownTimer.c;
        l1 r1 = ActivityCountDownTimer.a.a().b;
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopCountDown() {
        Lazy r0 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().c();
        post(new c(this));
    }

    private final int getLayout() {
        if (ld3.c.h() == false) goto L5;
        return 2131560727;
    L5:
        return 2131560726;
    }

    public final int hashCode() {
        return super.hashCode();
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

    public final void c(CommonGirdleStructV2 r12) {
        GenericDraweeView r1 = findViewById(2131367561);
        GenericDraweeView r0 = findViewById(2131367560);
        GenericDraweeView r10 = findViewById(2131367562);
        this.b = r12;
        if (r12 == null) goto L10;
        ECUrlModel r2 = r12.getNamePic();
        if (r2 == null) goto L10;
        ViewGroup.LayoutParams r13 = r1.getLayoutParams();
        if (r13 == null) goto L9;
        r13.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2.getWidth()));
        r13.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2.getHeight()));
    L9:
        int r14 = h.a;
        h0.d(r1, r2, h.a.a(), null, null, null, null, 120);
    L10:
        CommonGirdleStructV2 r15 = this.b;
        if (r15 == null) goto L15;
        ECUrlModel r3 = r15.getBgPic();
        if (r3 == null) goto L15;
        int r16 = h.a;
        h0.d(r0, r3, h.a.a(), null, null, null, null, 120);
    L15:
        CommonGirdleStructV2 r17 = this.b;
        String r4 = null;
        if (r17 == null) goto L18;
        CountDown r18 = r17.getCountdown();
    L20:
        if (r18 == null) goto L31;
        CommonGirdleStructV2 r19 = this.b;
        if (r19 == null) goto L62;
        CountDown r110 = r19.getCountdown();
        if (r110 != null) goto L26;
        return;
    L26:
        if (r110.getServerTime() >= r110.getEndTime()) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L64;
        findViewById(2131378849).setVisibility(0);
        long r6 = System.currentTimeMillis() / 1000;
        long r7 = r110.getEndTime();
        s0.c(this);
        this.d = r6;
        this.e = r7;
        Lazy r111 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().a(this.d, this.e, this, null);
        return;
    L64:
        return;
    L28:
        r5 = false;
        goto L29
    L62:
        return;
    L31:
        CommonGirdleStructV2 r112 = this.b;
        if (r112 == null) goto L36;
        CommonGirdleStructV2Slogan r113 = r112.getSlogan();
        if (r113 == null) goto L36;
        ECUrlModel r114 = r113.getPic();
    L37:
        if (r114 == null) goto L48;
        CommonGirdleStructV2 r115 = this.b;
        if (r115 == null) goto L66;
        CommonGirdleStructV2Slogan r116 = r115.getSlogan();
        if (r116 == null) goto L67;
        ECUrlModel r8 = r116.getPic();
        if (r8 == null) goto L68;
        r10.setVisibility(0);
        ViewGroup.LayoutParams r117 = r10.getLayoutParams();
        if (r117 == null) goto L47;
        r117.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getWidth()));
        r117.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getHeight()));
    L47:
        int r118 = h.a;
        h0.d(r10, r8, h.a.a(), null, null, null, null, 120);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L48:
        CommonGirdleStructV2 r119 = this.b;
        if (r119 == null) goto L53;
        CommonGirdleStructV2Slogan r120 = r119.getSlogan();
        if (r120 == null) goto L53;
        r4 = r120.getText();
    L53:
        if (r4 == null) goto L70;
        CommonGirdleStructV2 r121 = this.b;
        if (r121 == null) goto L71;
        CommonGirdleStructV2Slogan r122 = r121.getSlogan();
        if (r122 == null) goto L72;
        String r123 = r122.getText();
        if (r123 == null) goto L73;
        TextView r9 = (TextView) findViewById(2131367563);
        r9.setVisibility(0);
        r9.setText(r123);
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L36:
        r114 = null;
        goto L37
    L18:
        r18 = null;
        goto L20
    }

    @Subscribe
    public final void onActivityCountDownStopEvent(b53.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        stopCountDown();
        s0.e(this);
    }

    public final void onTick(long r3) {
        int r0 = c2.h;
        c2 r4 = c2.a.a(getContext(), r3, false);
        if (r4.a <= 0) goto L5;
        ((LinearLayout) b(2131368565)).setVisibility(0);
        ((TextView) b(2131390474)).setText(r4.b);
    L5:
        ((TextView) b(2131390757)).setText(r4.c);
        ((TextView) b(2131390954)).setText(r4.d);
        ((TextView) b(2131391365)).setText(r4.e);
        ((LinearLayout) b(2131378849)).setVisibility(0);
    }

    public final void setOnActivityChangeListener(Function1<? super CommonGirdleStructV2, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onActivityChangeListener");
        this.c = r2;
    }

    public InFlowActivityLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(getContext()).aU(getLayout(), this, true);
    L6:
        post(new com.bytedance.android.shopping.inflow.view.a(this));
        return;
    L5:
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r7 = getContext();
        r6.getClass();
        ShoppingAsyncInflater.a.a(r7).aU(getLayout(), this, true);
        goto L6
    }

    public /* synthetic */ InFlowActivityLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
