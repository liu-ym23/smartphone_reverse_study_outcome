package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListViewPagerAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.ToggleElement;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabLayout;
import com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/Toggle;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LivePromotionListRootPresenter$init$2 extends FunctionReferenceImpl implements Function1<Toggle, Unit> {
    public LivePromotionListRootPresenter$init$2(LivePromotionListRootPresenter r8) {
        super(1, r8, LivePromotionListRootPresenter.class, "initLinkMicStyle", "initLinkMicStyle(Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/Toggle;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabView] */
    /* JADX WARN: Type inference failed for: r1v27, types: [androidx.viewpager.widget.ViewPager$OnPageChangeListener] */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListRootPresenter$getOnPageChangeListener$1] */
    /* JADX WARN: Type inference failed for: r1v32, types: [android.widget.HorizontalScrollView, com.bytedance.android.livesdk.livecommerce.promotionlist.widget.LivePromotionListTopTabLayout, com.bytedance.android.ui.base.widget.tablayout.ECTabLayout, com.bytedance.android.ui.base.widget.tablayout.ECTabLayout$BaseOnTabSelectedListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    public final void invoke(Toggle r15) {
        final LivePromotionListRootPresenter r0 = (LivePromotionListRootPresenter) ((CallableReference) this).receiver;
        int r1 = LivePromotionListRootPresenter.t;
        if (r0.d0().getShowAuthorConnect() != 1) goto L79;
        if (r15 == null) goto L79;
        List<ToggleElement> r2 = r15.getElements();
        if (r2 == null) goto L8;
        int r3 = r2.size();
    L10:
        if (r3 < 2) goto L79;
        if (r0.m == true) goto L123;
        r0.m = true;
        r0.s = r15;
        View r4 = r0.Z().b(2131372612).f();
        ViewParent r7 = r4.getParent();
        if ((r7 instanceof ViewGroup) == true) goto L17;
        r7 = null;
    L17:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L20;
        r8.removeView(r4);
    L20:
        Unit r9 = Unit.INSTANCE;
        r0.l = r4;
        ViewPager r5 = r0.j;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L23:
        r5.setPageMargin(UtilityKotlinExtentionsKt.d(Float.valueOf(3.0f)));
        ViewPager r6 = r0.j;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L26:
        r6.setAdapter(new LivePromotionListViewPagerAdapter(r15, new LivePromotionListRootPresenter$initLinkMicStyle$2(r0)));
        Toggle r16 = r0.s;
        if (r16 == null) goto L60;
        List<ToggleElement> r17 = r16.getElements();
        if (r17 == null) goto L60;
        ?? r10 = r0.k;
        if (r10 != 0) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L33:
        gi2.a r11 = r0.d0().getPromotionListParams();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r17, "elements");
        Intrinsics.checkNotNullParameter(r11, "promotionListParams");
        r10.a = r11;
        Iterator r18 = r17.iterator();
        int r12 = 0;
    L35:
        if (r18.hasNext() == false) goto L59;
        Object r13 = r18.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        ToggleElement r19 = (ToggleElement) r13;
        ECTabLayout.Tab r110 = r10.getTabAt(r12);
        if (r110 == null) goto L42;
        Object r111 = r110.getCustomView();
    L44:
        if ((r111 instanceof LivePromotionListTopTabView) == true) goto L46;
        r111 = null;
    L46:
        LivePromotionListTopTabView r112 = (LivePromotionListTopTabView) r111;
        if (r112 == null) goto L53;
        r112.R5(r19);
        if (r12 != 0) goto L51;
        boolean r20 = true;
    L52:
        r112.S5(r20);
    L58:
        r12 = r14;
        goto L35
    L51:
        r20 = false;
        goto L52
    L53:
        ?? r113 = new LivePromotionListTopTabView(r10.getContext(), null, 6, 0);
        r113.R5(r19);
        if (r12 != 0) goto L56;
        boolean r21 = true;
    L57:
        r113.S5(r21);
        r10.addTab(r10.newTab().setCustomView(r113));
        goto L58
    L56:
        r21 = false;
        goto L57
    L42:
        r111 = null;
        goto L44
    L59:
        r10.addOnTabSelectedListener(r10);
        oh.a.c("livesdk_list_switch_show", new xj2.a(r11));
    L60:
        LivePromotionListTopTabLayout r114 = r0.k;
        if (r114 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L63:
        ViewPager r22 = r0.j;
        if (r22 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L66:
        r114.setupWithViewPager(r22);
        r0.d0().setGetCurrentTab(new LivePromotionListRootPresenter$initLinkMicStyle$4(r0));
        ViewPager r115 = r0.j;
        if (r115 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L69:
        LivePromotionListRootPresenter$getOnPageChangeListener$1 r23 = r0.r;
        ?? r24 = r23;
        if (r23 != null) goto L72;
        ?? r25 = new LivePromotionListRootPresenter$getOnPageChangeListener$1(r0);
        r0.r = r25;
        r24 = r25;
    L72:
        r115.addOnPageChangeListener(r24);
        com.bytedance.android.ec.core.arch.event.c.d(r0.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.p(false));
        r0.i0(false);
        ECTabLayout.BaseOnTabSelectedListener r116 = r0.k;
        if (r116 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L75:
        r116.setVisibility(0);
        ViewPager r117 = r0.j;
        if (r117 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L78:
        r117.setVisibility(0);
        com.bytedance.android.ec.core.arch.event.c.c(r0.d0(), ECQuickUtilKt.a(r0.Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.y.class), new LivePromotionListRootPresenter$initLinkMicStyle$5(r0));
    L113:
        if (r0.d0().isInSplitScreen() == true) goto L115;
    L117:
        r0.Z().b(2131376691).c();
        return;
    L115:
        if (r0.Z().b(2131388934).d() == false) goto L117;
        Query r118 = r0.Z().b(2131376691);
        r118.g(0);
        com.bytedance.android.ec.core.widget.f.a(r118, new LivePromotionListRootPresenter$initLinkMicStyle$7(r0));
        return;
    L123:
        return;
    L8:
        r3 = 0;
    L79:
        r0.d0().setGetCurrentTab(null);
        LivePromotionListViewModel r119 = r0.o;
        if (r119 == null) goto L82;
        r119.setGetCurrentTab(null);
    L82:
        r0.h0();
        View r120 = r0.l;
        if (r120 == null) goto L96;
        ViewParent r26 = r120.getParent();
        if ((r26 instanceof ViewGroup) == true) goto L87;
        r26 = null;
    L87:
        ViewGroup r27 = (ViewGroup) r26;
        if (r27 == null) goto L90;
        r27.removeView(r120);
    L90:
        View r28 = r0.a0();
        if ((r28 instanceof ViewGroup) == true) goto L93;
        r28 = null;
    L93:
        ViewGroup r29 = (ViewGroup) r28;
        if (r29 == null) goto L96;
        r29.addView(r120, 0);
    L96:
        com.bytedance.android.ec.core.arch.event.c.d(r0.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.p(true));
        r0.i0(true);
        ECTabLayout.BaseOnTabSelectedListener r121 = r0.k;
        if (r121 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L99:
        r121.setVisibility(8);
        ViewPager r122 = r0.j;
        if (r122 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L102:
        r122.setVisibility(8);
        LivePromotionListTopTabLayout r123 = r0.k;
        if (r123 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L105:
        r123.removeOnTabSelectedListener(r123);
        r123.removeAllTabs();
        LivePromotionListTopTabLayout r124 = r0.k;
        if (r124 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L108:
        r124.setupWithViewPager(null);
        ViewPager r125 = r0.j;
        if (r125 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L111:
        r125.setAdapter(null);
        goto L113
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Toggle) r1);
        return Unit.INSTANCE;
    }
}
