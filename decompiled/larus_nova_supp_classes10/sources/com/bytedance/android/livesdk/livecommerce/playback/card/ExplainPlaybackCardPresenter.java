package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.api.model.PlaybackSmallCardViewState;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.playback.card.widget.ExplainProductCardWithBuyButtonView;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.utils.LiveBstReport;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackCardPresenter extends QFragmentPresenter {
    public static final /* synthetic */ int v = 0;
    public final Lazy f;
    public FrameLayout g;
    public FrameLayout h;
    public ExplainProductCardWithBuyButtonView i;
    public int j;
    public int k;
    public int l;
    public int m;
    public ECUIPromotion n;
    public boolean o;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.b p;
    public final Lazy q;
    public final Lazy r;
    public AnimatorSet s;
    public boolean t;
    public final bk2.b u;

    public static final class a {
    }

    static {
    }

    public final ExplainPlaybackViewModel h0() {
        return (ExplainPlaybackViewModel) this.f.getValue();
    }

    public final void c0() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r0 = this.p;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        AnimatorSet r1 = this.s;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.u.clearDisposable();
    }

    public ExplainPlaybackCardPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackCardPresenter$viewModel$2(this));
        this.q = LazyKt.lazy(ExplainPlaybackCardPresenter$btmInfo$2.INSTANCE);
        this.r = LazyKt.lazy(new ExplainPlaybackCardPresenter$absParams$2(this, r2));
        this.u = new bk2.b();
    }

    public final void b0(QModel r4) {
        this.g = (FrameLayout) Z().b(2131367545).f();
        this.h = (FrameLayout) Z().b(2131367544).f();
        com.bytedance.android.ec.core.arch.state.c.a(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), ExplainPlaybackCardPresenter$onBind$1.INSTANCE, new ExplainPlaybackCardPresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.k.class), new ExplainPlaybackCardPresenter$onBind$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.l.class), new ExplainPlaybackCardPresenter$onBind$4(this));
    }

    public static final void d0(final ExplainPlaybackCardPresenter r16, final boolean r17) {
        if (r16.o == true) goto L5;
        return;
    L5:
        if (r17 == false) goto L9;
        FrameLayout r3 = r16.h;
        if (r3 == null) goto L9;
        r3.setVisibility(0);
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r4 = r16.p;
        if (r4 == null) goto L35;
        View r5 = com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r4);
        View r11 = r4.F0(PromotionCardModuleName.ImageAreaModule);
        PlaybackSmallCardViewState r7 = new PlaybackSmallCardViewState(r16.j, r16.k, th.a.f(r16.Y().c()).getDimensionPixelSize(2131166400));
        AnimatorSet r6 = r16.s;
        if (r6 != null) goto L14;
    L16:
        int r8 = com.bytedance.android.livesdk.livecommerce.playback.utils.g.a;
        View r9 = com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r4);
        int r10 = r5.getWidth();
        int r12 = r5.getHeight();
        int r13 = UtilityKotlinExtentionsKt.d(Float.valueOf(96.0f));
        Function0<Unit> r14 = new ExplainPlaybackCardPresenter$showOrHideBigProductCard$$inlined$also$lambda$1(r16, r17);
        Intrinsics.checkNotNullParameter(r9, "rootView");
        Intrinsics.checkNotNullParameter(r11, "imageModuleView");
        Intrinsics.checkNotNullParameter(r7, "smallCardViewState");
        List r15 = com.bytedance.commerce.base.view.b.a(r9);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r15.iterator();
    L18:
        if (r19.hasNext() == false) goto L22;
        Object r20 = r19.next();
        if ((!Intrinsics.areEqual((View) r20, r11)) == false) goto L18;
        r18.add(r20);
        goto L18
    L22:
        AnimatorSet r21 = new AnimatorSet();
        if (r17 == false) goto L29;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r2 = r18.iterator();
    L26:
        if (r2.hasNext() == false) goto L28;
        r22.add(ObjectAnimator.ofFloat((View) r2.next(), "alpha", new float[]{0.0f, 1.0f}));
        goto L26
    L28:
        r21.playTogether(r22);
        r21.setDuration(200);
        r21.start();
        r9.getLayoutParams().height = -2;
        r9.getLayoutParams().width = -1;
        r11.getLayoutParams().height = r13;
        r11.getLayoutParams().width = UtilityKotlinExtentionsKt.d(20) + r13;
        r9.setVisibility(0);
    L34:
        r16.s = r21;
        goto L35
    L29:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r24 = r18.iterator();
    L31:
        if (r24.hasNext() == false) goto L33;
        r23.add(ObjectAnimator.ofFloat((View) r24.next(), "alpha", new float[]{1.0f, 0.0f}));
        goto L31
    L33:
        r21.playTogether(r23);
        r21.setDuration(200);
        r21.addListener(new com.bytedance.android.livesdk.livecommerce.playback.utils.b(r7, r9, r10, r12, r11, r13, r14));
        r21.start();
        goto L34
    L14:
        if (r6.isRunning() != true) goto L16;
    L35:
        if (r17 == false) goto L46;
        cj2.a.d("1", null, null, null, null);
        return;
    }

    public static final void e0(final ExplainPlaybackCardPresenter r5, boolean r6) {
        if (r5.o == false) goto L17;
        ExplainProductCardWithBuyButtonView r0 = null;
        if (r6 == false) goto L10;
        FrameLayout r1 = r5.g;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        cj2.a.d(PromotionCategory.CATEGORY_TYPE_SECOND, null, null, null, null);
        com.bytedance.android.bst.api.e r2 = new com.bytedance.android.bst.api.e(r5.Z().f());
        r2.a = "a1.b3390.c11834.d45925";
        r2.b = "livesdk_show_product";
        r2.d = "live_shopping";
        r2.c = r5.n;
        r2.f = new LiveBstReport(ExplainPlaybackCardPresenter$bindBst$1$1.INSTANCE, new ExplainPlaybackCardPresenter$bindBst$$inlined$apply$lambda$1(r5));
        com.bytedance.android.bst.api.f r3 = com.bytedance.android.bst.api.f.b;
        com.bytedance.android.bst.api.d r4 = BtmUtilsKt.h(r2);
        r3.getClass();
        com.bytedance.android.bst.api.f.a(r4);
    L10:
        ExplainProductCardWithBuyButtonView r7 = r5.i;
        if ((r7 instanceof com.bytedance.android.livesdk.livecommerce.playback.card.widget.f) == false) goto L14;
        r0 = r7;
    L14:
        if (r0 == null) goto L18;
        r0.a(r6, new dj2.d(r5.l, r5.m, UtilityKotlinExtentionsKt.d(96)), new ExplainPlaybackCardPresenter$showOrHideSmallCardView$1(r5));
        return;
    L18:
        return;
    }
}
