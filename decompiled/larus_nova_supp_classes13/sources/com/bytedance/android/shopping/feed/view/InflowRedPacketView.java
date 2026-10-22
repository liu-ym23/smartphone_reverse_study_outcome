package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.event.y0;
import com.bytedance.android.shopping.feed.utils.InflowRedPacketTimer;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u000e\u0014\u0019\u001dB\u001d\b\u0007\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d¢\u0006\u0004\bf\u0010gR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\bR\u0017\u0010)\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u0017\u0010,\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u0017\u0010/\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001b\u00105\u001a\u000600R\u00020\u00008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u0010;\u001a\u000606R\u00020\u00008\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010A\u001a\u00060<R\u00020\u00008\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010U\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR\"\u0010Y\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bV\u0010L\u001a\u0004\bW\u0010N\"\u0004\bX\u0010PR\"\u0010a\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006h"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "getRedPacketNormal", "()Landroid/view/View;", "redPacketNormal", "b", "getRedPacketCollapsed", "redPacketCollapsed", "Lcom/bytedance/android/ec/core/widget/PriceView;", "c", "Lcom/bytedance/android/ec/core/widget/PriceView;", "getRedPacketAmount", "()Lcom/bytedance/android/ec/core/widget/PriceView;", "redPacketAmount", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getRedPacketCountDown", "()Landroid/widget/TextView;", "redPacketCountDown", "e", "getRedPacketCloseButton", "redPacketCloseButton", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "f", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "getCurrentState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "setCurrentState", "(Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;)V", "currentState", "g", "getBottomViewBig", "bottomViewBig", "h", "getBottomTextViewBig", "bottomTextViewBig", "i", "getBottomTextViewSmall", "bottomTextViewSmall", "j", "getBottomCountDown", "bottomCountDown", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", "k", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", "getStartState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", "startState", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "l", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "getNormalState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "normalState", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "m", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "getCollapsedState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "collapsedState", "", "n", "Z", "getScrollStoped", "()Z", "setScrollStoped", "(Z)V", "scrollStoped", "", "o", "Ljava/lang/String;", "getAwemeid", "()Ljava/lang/String;", "setAwemeid", "(Ljava/lang/String;)V", "awemeid", "p", "getAmount", "setAmount", "amount", "q", "getExpired_minute", "setExpired_minute", "expired_minute", "", "r", "I", "getScrollStoppedTime", "()I", "setScrollStoppedTime", "(I)V", "scrollStoppedTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowRedPacketView extends FrameLayout implements l1.a {
    public static final /* synthetic */ int s = 0;
    public final View a;
    public final View b;
    public final PriceView c;
    public final TextView d;
    public final View e;
    public f f;
    public final View g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final e k;
    public final d l;
    public final c m;
    public boolean n;
    public String o;
    public String p;
    public String q;
    public int r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InflowRedPacketView a;
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.view.InflowRedPacketView$a$a, reason: collision with other inner class name */
        public static final class CallableC0065a<V> implements Callable {
            public final /* synthetic */ Integer a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ List c;
            public final /* synthetic */ a d;

            public CallableC0065a(Integer r1, Context r2, a r3) {
                this.a = r1;
                this.b = r2;
                this.c = null;
                this.d = r3;
            }

            @Override // java.util.concurrent.Callable
            public final com.bytedance.android.ec.core.event.a call() {
                y0 r0 = new y0("inflow_redpacket_close");
                r0.a = this.d.a.getAwemeid();
                r0.b = this.d.a.getAmount();
                r0.c = this.d.a.getExpired_minute();
                Integer r1 = this.a;
                if (r1 != null) goto L6;
            L8:
                if (r1 != null) goto L11;
            L13:
                r0.buildLogParams();
                com.bytedance.android.ec.core.event.a.b.a.getClass();
                r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
                return r0;
            L11:
                if (r1.intValue() != 0) goto L13;
                com.bytedance.android.shopping.feed.event.g.b(r0, this.b);
                goto L13
            L6:
                if (r1.intValue() != 2) goto L8;
                com.bytedance.android.shopping.feed.event.g.a(r0, this.b, this.c);
                goto L13
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            FeedProductEventTracker r4 = FeedProductEventTracker.a;
            Single.fromCallable(new CallableC0065a(2, this.b, this)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
            InflowRedPacketView r5 = this.a;
            int r0 = InflowRedPacketView.s;
            r5.getClass();
            ExtensionsKt.gone(r5);
        }

        public a(InflowRedPacketView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ InflowRedPacketView a;

        @Override // java.lang.Runnable
        public final void run() {
            InflowRedPacketView r0 = this.a;     // Catch: Throwable -> L4
            r0.a(r0.getNormalState());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(InflowRedPacketView r1) {
            this.a = r1;
        }
    }

    public final class c implements f {
        public final int a;
        public final /* synthetic */ InflowRedPacketView b;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if ((this.a.b.getCurrentState() instanceof d) == false) goto L9;
                ExtensionsKt.gone(this.a.b.getRedPacketCollapsed());     // Catch: Throwable -> L6
                return;
            }

            public a(c r1) {
                this.a = r1;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r2) {
            Intrinsics.checkNotNullParameter(r2, "uiCountDown");
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r0 = new TranslateAnimation(0.0f, -this.a, 0.0f, 0.0f);
            r0.setDuration(500);
            r0.setFillAfter(true);
            r0.setFillEnabled(true);
            this.b.getRedPacketCollapsed().clearAnimation();
            this.b.getRedPacketCloseButton().clearAnimation();
            this.b.getRedPacketCollapsed().startAnimation(r0);
            this.b.getRedPacketCloseButton().startAnimation(r0);
            new Handler().postDelayed(new a(this), 500);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            ExtensionsKt.visible(this.b.getRedPacketCollapsed());
            wg.a.f(this.b.getRedPacketCloseButton(), com.bytedance.android.shopping.extensions.b.b(3) + this.a, 0, 0, 0);
            TranslateAnimation r0 = new TranslateAnimation(-this.a, 0.0f, 0.0f, 0.0f);
            r0.setDuration(500);
            this.b.getRedPacketCollapsed().clearAnimation();
            this.b.getRedPacketCloseButton().clearAnimation();
            this.b.getRedPacketCollapsed().startAnimation(r0);
            this.b.getRedPacketCloseButton().startAnimation(r0);
        }

        public c(InflowRedPacketView r1) {
            this.b = r1;
            this.a = com.bytedance.android.shopping.extensions.b.b(28);
        }
    }

    public final class d implements f {
        public int a;
        public final int b;
        public final /* synthetic */ InflowRedPacketView c;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if ((this.a.c.getCurrentState() instanceof c) == false) goto L9;
                ExtensionsKt.gone(this.a.c.getRedPacketNormal());     // Catch: Throwable -> L6
                return;
            }

            public a(d r1) {
                this.a = r1;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r0 = new TranslateAnimation(0.0f, -this.a, 0.0f, 0.0f);
            r0.setDuration(500);
            r0.setFillAfter(true);
            r0.setFillEnabled(true);
            this.c.getRedPacketNormal().clearAnimation();
            this.c.getRedPacketCloseButton().clearAnimation();
            this.c.getRedPacketNormal().startAnimation(r0);
            this.c.getRedPacketCloseButton().startAnimation(r0);
            new Handler().postDelayed(new a(this), 500);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            if ((this.c.getCurrentState() instanceof c) == false) goto L5;
            ExtensionsKt.visible(this.c.getRedPacketNormal());
            wg.a.f(this.c.getRedPacketCloseButton(), com.bytedance.android.shopping.extensions.b.b(3) + this.a, 0, 0, 0);
            TranslateAnimation r0 = new TranslateAnimation(-this.a, 0.0f, 0.0f, 0.0f);
            r0.setDuration(500);
            this.c.getRedPacketNormal().clearAnimation();
            this.c.getRedPacketCloseButton().clearAnimation();
            this.c.getRedPacketNormal().startAnimation(r0);
            this.c.getRedPacketCloseButton().startAnimation(r0);
            return;
        L5:
            this.a = this.c.getRedPacketNormal().getMeasuredWidth() + this.b;
        }

        public d(InflowRedPacketView r1) {
            this.c = r1;
            this.b = com.bytedance.android.shopping.extensions.b.b(10);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r5) {
            Intrinsics.checkNotNullParameter(r5, "uiCountDown");
            this.c.getBottomCountDown().setText(r5.c + ':' + r5.d + ':' + r5.e);
        }
    }

    public final class e implements f {
        public final /* synthetic */ InflowRedPacketView a;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;

            @Override // java.lang.Runnable
            public final void run() {
                ExtensionsKt.gone(this.a.a.getRedPacketCountDown());     // Catch: Throwable -> L4
                ExtensionsKt.gone(this.a.a.getBottomTextViewSmall());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r1) {
                this.a = r1;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r1 = new TranslateAnimation(0.0f, -20.0f, 0.0f, 0.0f);
            AlphaAnimation r2 = new AlphaAnimation(1.0f, 0.0f);
            r1.setDuration(500);
            r2.setDuration(500);
            AnimationSet r7 = new AnimationSet(true);
            r7.addAnimation(r1);
            r7.addAnimation(r2);
            r7.setFillAfter(true);
            r7.setFillEnabled(true);
            this.a.getRedPacketCountDown().clearAnimation();
            this.a.getRedPacketCountDown().startAnimation(r7);
            new Handler().postDelayed(new a(this), 500);
            ExtensionsKt.visible(this.a.getBottomViewBig());
            AlphaAnimation r3 = new AlphaAnimation(0.0f, 1.0f);
            r3.setDuration(500);
            ScaleAnimation r4 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            r4.setDuration(500);
            AnimationSet r5 = new AnimationSet(true);
            r5.addAnimation(r3);
            r5.addAnimation(r4);
            this.a.getBottomViewBig().clearAnimation();
            this.a.getBottomViewBig().startAnimation(r5);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            Animation r0 = AnimationUtils.loadAnimation(this.a.getContext(), 2130772616);     // Catch: Exception -> L4
            this.a.getRedPacketNormal().clearAnimation();     // Catch: Exception -> L4
            this.a.getRedPacketNormal().startAnimation(r0);     // Catch: Exception -> L4
            TranslateAnimation r1 = new TranslateAnimation(-20.0f, 0.0f, 0.0f, 0.0f);     // Catch: Exception -> L4
            AlphaAnimation r2 = new AlphaAnimation(0.0f, 1.0f);     // Catch: Exception -> L4
            r1.setDuration(500);     // Catch: Exception -> L4
            r2.setDuration(500);     // Catch: Exception -> L4
            AnimationSet r3 = new AnimationSet(true);     // Catch: Exception -> L4
            r3.addAnimation(r1);     // Catch: Exception -> L4
            r3.addAnimation(r2);     // Catch: Exception -> L4
            this.a.getRedPacketCountDown().clearAnimation();     // Catch: Exception -> L4
            this.a.getRedPacketCountDown().startAnimation(r3);     // Catch: Exception -> L4
            return;
        }

        public e(InflowRedPacketView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r5) {
            Intrinsics.checkNotNullParameter(r5, "uiCountDown");
            this.a.getRedPacketCountDown().setText("仅剩 " + r5.c + ':' + r5.d + ':' + r5.e);
        }
    }

    public interface f {
        void a(c2 r1);

        void b();

        void c();
    }

    public final void onStart() {
    }

    public final String getAmount() {
        String r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("amount");
    L5:
        return r0;
    }

    public final String getAwemeid() {
        String r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("awemeid");
    L5:
        return r0;
    }

    public final String getExpired_minute() {
        String r0 = this.q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("expired_minute");
    L5:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = cf.e.a;
        ULong.box-impl(0);
        ULong.box-impl(0);
        InflowRedPacketTimer r1 = (InflowRedPacketTimer) InflowRedPacketTimer.b.getValue();
        l1 r2 = r1.a;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        r1.a = null;
    }

    public final TextView getBottomCountDown() {
        return this.j;
    }

    public final TextView getBottomTextViewBig() {
        return this.h;
    }

    public final TextView getBottomTextViewSmall() {
        return this.i;
    }

    public final View getBottomViewBig() {
        return this.g;
    }

    public final c getCollapsedState() {
        return this.m;
    }

    public final f getCurrentState() {
        return this.f;
    }

    public final d getNormalState() {
        return this.l;
    }

    public final PriceView getRedPacketAmount() {
        return this.c;
    }

    public final View getRedPacketCloseButton() {
        return this.e;
    }

    public final View getRedPacketCollapsed() {
        return this.b;
    }

    public final TextView getRedPacketCountDown() {
        return this.d;
    }

    public final View getRedPacketNormal() {
        return this.a;
    }

    public final boolean getScrollStoped() {
        return this.n;
    }

    public final int getScrollStoppedTime() {
        return this.r;
    }

    public final e getStartState() {
        return this.k;
    }

    public final void onFinish() {
        ExtensionsKt.gone(this);
    }

    public InflowRedPacketView(Context r2) {
        this(r2, null);
    }

    public final void a(f r2) {
        if (Intrinsics.areEqual(r2, this.f) == false) goto L5;
        return;
    L5:
        f r0 = this.f;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        if (r2 == null) goto L10;
        r2.c();
    L10:
        this.f = r2;
    }

    public final void onTick(long r3) {
        int r0 = c2.h;
        c2 r4 = c2.a.a(getContext(), r3, false);
        f r5 = this.f;
        if (r5 == null) goto L6;
        r5.a(r4);
    L6:
        if (this.n == true) goto L8;
        this.r = 0;
        return;
    L8:
        if (this.r >= 1) goto L10;
    L12:
        this.r++;
        return;
    L10:
        if ((this.f instanceof c) == false) goto L12;
        a(this.l);
        this.r = -1;
        goto L12
    }

    public final void setAmount(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void setAwemeid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    public final void setCurrentState(f r1) {
        this.f = r1;
    }

    public final void setExpired_minute(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    public final void setScrollStoped(boolean r1) {
        this.n = r1;
    }

    public final void setScrollStoppedTime(int r1) {
        this.r = r1;
    }

    public InflowRedPacketView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        e r8 = new e(this);
        this.k = r8;
        this.l = new d(this);
        this.m = new c(this);
        this.n = true;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r6).aU(2131560649, this, true);
        PriceView r0 = (PriceView) findViewById(2131384085);
        this.c = r0;
        this.d = (TextView) findViewById(2131384093);
        this.a = findViewById(2131384094);
        this.b = findViewById(2131384092);
        View r1 = findViewById(2131384091);
        this.e = r1;
        this.g = findViewById(2131384090);
        TextView r2 = (TextView) findViewById(2131384088);
        this.h = r2;
        TextView r3 = (TextView) findViewById(2131384089);
        this.i = r3;
        this.j = (TextView) findViewById(2131384087);
        Typeface r4 = IECHostService.a.a(com.bytedance.android.ec.sdk.helper.d.b, r6);
        if (r4 != null) goto L5;
        r4 = Typeface.DEFAULT;
    L5:
        r3.setTypeface(r4);
        r2.setTypeface(r4);
        r1.setOnClickListener(new a(this, r6));
        r0.C(AnonymousClass3.INSTANCE);
        a(r8);
        new Handler().postDelayed(new b(this), 2000);
    }
}
