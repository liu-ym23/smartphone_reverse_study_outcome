package com.bytedance.android.shopping.card_list.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HalfPanelHelper {
    public int a;
    public float b;
    public View c;
    public CardListRootFrameLayoutContainer d;
    public LinearLayout e;
    public View f;
    public View g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final int l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final GestureDetector p;
    public final View q;
    public final CardListObjectContainer r;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ HalfPanelHelper a;

        public a(HalfPanelHelper r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            CardListRootFrameLayoutContainer r6 = this.a.d;
            if (r6 == null) goto L5;
            r6.setBorderRadius(0);
        L5:
            View r7 = this.a.f;
            if (r7 == null) goto L8;
            r7.setVisibility(4);
        L8:
            HalfPanelHelper.a(this.a, true);
            Map<String, ?> r8 = this.a.r.e.a();
            if (r8 == null) goto L11;
            Object r9 = r8.get("pull_full_screen_refresh");
        L13:
            if ((r9 instanceof Integer) == true) goto L15;
            r9 = null;
        L15:
            Integer r10 = (Integer) r9;
            if (r10 != null) goto L19;
            return;
        L19:
            if (r10.intValue() != 1) goto L24;
            CardListQueryFetchComponent r11 = (CardListQueryFetchComponent) this.a.o.getValue();
            if (r11 == null) goto L25;
            int r1 = CardListQueryFetchComponent.x;
            r11.i(false, "pull_to_full_screen", null);
            return;
        L25:
            return;
        L24:
            return;
        L11:
            r9 = null;
            goto L13
        }
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final int a;
        public final int b;
        public final /* synthetic */ HalfPanelHelper c;

        public b(HalfPanelHelper r1) {
            this.c = r1;
            this.a = 100;
            this.b = 1500;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            Intrinsics.checkNotNullParameter(r4, "e2");
            float r7 = 0.0f;
            if (r3 == null) goto L5;
            float r0 = r3.getRawY();
        L6:
            float r1 = r0 - r4.getRawY();
            if (r3 == null) goto L10;
            r7 = r3.getRawX();
        L10:
            if (Math.abs(r1) > Math.abs(r7 - r4.getRawX())) goto L12;
            return false;
        L12:
            if (Math.abs(r1) > this.a) goto L14;
            return false;
        L14:
            if (Math.abs(r6) > this.b) goto L16;
            return false;
        L16:
            if (r1 <= 0) goto L22;
            View r8 = this.c.f;
            if (r8 != null) goto L20;
        L23:
            return true;
        L20:
            if (r8.getVisibility() != 0) goto L23;
            this.c.b();
            goto L23
        L22:
            this.c.e();
            goto L23
        L5:
            r0 = 0.0f;
            goto L6
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ HalfPanelHelper a;

        public c(HalfPanelHelper r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            View r5 = this.a.g;
            if (r5 == null) goto L5;
            r5.setTranslationY(0.0f);
        L5:
            View r6 = this.a.g;
            if (r6 == null) goto L8;
            r6.setVisibility(4);
        L8:
            CardListRootFrameLayoutContainer r7 = this.a.d;
            if (r7 == null) goto L11;
            r7.setBorderRadius(com.bytedance.android.shopping.extensions.b.b(20));
        L11:
            HalfPanelHelper.a(this.a, false);
            Map<String, ?> r8 = this.a.r.e.a();
            if (r8 == null) goto L14;
            Object r9 = r8.get("pull_full_screen_refresh");
        L16:
            if ((r9 instanceof Integer) == true) goto L18;
            r9 = null;
        L18:
            Integer r10 = (Integer) r9;
            if (r10 != null) goto L22;
            return;
        L22:
            if (r10.intValue() != 1) goto L27;
            CardListQueryFetchComponent r11 = (CardListQueryFetchComponent) this.a.o.getValue();
            if (r11 == null) goto L28;
            int r2 = CardListQueryFetchComponent.x;
            r11.i(false, "drop_down_to_split_screen", null);
            return;
        L28:
            return;
        L27:
            return;
        L14:
            r9 = null;
            goto L16
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ HalfPanelHelper a;

        public d(HalfPanelHelper r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    public final float c() {
        return ((Number) this.k.getValue()).floatValue();
    }

    public final void b() {
        com.bytedance.android.shopping.card_list.components.k r0 = (com.bytedance.android.shopping.card_list.components.k) this.n.getValue();
        if (r0 != null) goto L5;
    L7:
        this.r.e.n = 100;
        d(true);
        AnimatorSet r1 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.d, "translationY", new float[]{((Number) this.h.getValue()).intValue() - ((Number) this.i.getValue()).intValue()});
        r2.setDuration(340);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f});
        r3.setDuration(100);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{1.0f});
        r4.setDuration(160);
        View r10 = this.g;
        if (r10 == null) goto L10;
        r10.setVisibility(0);
    L10:
        View r11 = this.g;
        if (r11 == null) goto L13;
        r11.setAlpha(0.0f);
    L13:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.0f});
        r6.setDuration(100);
        r6.addListener(new a(this));
        r1.playTogether(new Animator[]{r2, r3, r4, r6});
        r1.start();
        return;
    L5:
        if (r0.isLoading() != true) goto L7;
    }

    public final void e() {
        com.bytedance.android.shopping.card_list.components.k r0 = (com.bytedance.android.shopping.card_list.components.k) this.n.getValue();
        if (r0 != null) goto L5;
    L7:
        this.r.e.n = ((Number) this.j.getValue()).intValue();
        d(false);
        AnimatorSet r2 = new AnimatorSet();
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.d, "translationY", new float[]{c()});
        r3.setDuration(340);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{0.0f});
        r4.setDuration(100);
        r4.addListener(new c(this));
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.6f});
        r5.setDuration(100);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f});
        r6.setDuration(260);
        r6.setStartDelay(100);
        r6.addListener(new d(this));
        r2.playTogether(new Animator[]{r3, r5, r4, r6});
        r2.start();
        return;
    L5:
        if (r0.isLoading() != true) goto L7;
    }

    public final void d(boolean r12) {
        AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.r.e.c.invoke();
        List r2 = r0.n("body");
        com.bytedance.kmp.ec.yata.store.node.b r3 = null;
        if (r2 == null) goto L19;
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        com.bytedance.kmp.ec.yata.store.node.b r6 = ((com.bytedance.kmp.ec.yata.store.node.c) r5).getParent();
        if ((r6 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L10;
        r6 = null;
    L10:
        com.bytedance.kmp.ec.yata.store.node.c r7 = (com.bytedance.kmp.ec.yata.store.node.c) r6;
        if (r7 == null) goto L13;
        String r8 = r7.getNodeName();
    L15:
        if (Intrinsics.areEqual(r8, "cart_top_bar") == false) goto L6;
    L18:
        com.bytedance.kmp.ec.yata.store.node.c r9 = (com.bytedance.kmp.ec.yata.store.node.c) r5;
    L20:
        List r1 = r0.n("body");
        if (r1 == null) goto L36;
        Iterator r10 = r1.iterator();
    L24:
        if (r10.hasNext() == false) goto L34;
        Object r11 = r10.next();
        com.bytedance.kmp.ec.yata.store.node.c r13 = (com.bytedance.kmp.ec.yata.store.node.c) r11;
        if ((r13 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L28;
        r13 = null;
    L28:
        if (r13 == null) goto L30;
        String r14 = r13.getNodeName();
    L32:
        if (Intrinsics.areEqual(r14, "cart_tab") == false) goto L24;
    L35:
        com.bytedance.kmp.ec.yata.store.node.c r15 = (com.bytedance.kmp.ec.yata.store.node.c) r11;
    L37:
        if (r9 == null) goto L39;
        com.bytedance.kmp.ec.yata.store.node.b r16 = r9.getParent();
    L41:
        if ((r16 instanceof com.bytedance.kmp.ec.yata.store.node.c) == false) goto L45;
        r3 = r16;
    L45:
        if (((com.bytedance.kmp.ec.yata.store.node.c) r3) == null) goto L51;
        Map r17 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r12)));
        if (r12 == false) goto L49;
        String r18 = "show_cart_to_top";
    L50:
        r0.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r0, null, r9.getKey(), "controlChildTopBarVisibility", r17, r18));
        goto L51
    L49:
        r18 = "hide_cart_to_top";
    L51:
        if (r15 == null) goto L64;
        Map r19 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r12)));
        if (r12 == false) goto L55;
        String r110 = "show_cart_tab";
    L56:
        r0.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r0, null, r15.getKey(), "showCartTab", r19, r110));
        return;
    L55:
        r110 = "hide_cart_tab";
        goto L56
    L64:
        return;
    L39:
        r16 = null;
        goto L41
    L30:
        r14 = null;
        goto L32
    L34:
        r11 = null;
        goto L35
    L36:
        r15 = null;
        goto L37
    L13:
        r8 = null;
        goto L15
    L17:
        r5 = null;
        goto L18
    L19:
        r9 = null;
        goto L20
    }

    public HalfPanelHelper(View r2, CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.q = r2;
        this.r = r3;
        this.h = LazyKt.lazy(new HalfPanelHelper$headerViewHeight$2(this));
        this.i = LazyKt.lazy(new HalfPanelHelper$bodyTitleViewHeight$2(this));
        this.j = LazyKt.lazy(new HalfPanelHelper$heightPercent$2(this));
        this.k = LazyKt.lazy(new HalfPanelHelper$initialTransY$2(this));
        this.l = com.bytedance.android.shopping.extensions.b.b(5);
        this.m = LazyKt.lazy(new HalfPanelHelper$footerComponent$2(this));
        this.n = LazyKt.lazy(new HalfPanelHelper$loadingComponent$2(this));
        this.o = LazyKt.lazy(new HalfPanelHelper$queryFetchComponent$2(this));
        this.p = new GestureDetector(r3.getContext(), new b(this));
    }

    public static final void a(HalfPanelHelper r4, boolean r5) {
        View r0 = r4.q;
        DialogFragment r2 = null;
        if ((r0 instanceof FrameLayout) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L25;
        if (r5 == false) goto L19;
        DialogFragment r6 = r4.r.d;
        if ((r6 instanceof DialogFragment) == false) goto L12;
        r2 = r6;
    L12:
        DialogFragment r3 = r2;
        if (r3 == null) goto L26;
        int r7 = ECSdk.a;
        IAdapterService r8 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r8 == null) goto L27;
        com.bytedance.android.ec.adapter.api.j r9 = r8.getLiveWindowService();
        if (r9 == null) goto L28;
        com.bytedance.android.ec.adapter.api.a r10 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter("product_cart_page", "<set-?>");
        r10.a = "product_cart_page";
        Unit r11 = Unit.INSTANCE;
        r9.a(r3, r1, r10);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L19:
        int r12 = ECSdk.a;
        IAdapterService r13 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r13 == null) goto L30;
        com.bytedance.android.ec.adapter.api.j r14 = r13.getLiveWindowService();
        if (r14 == null) goto L31;
        r14.stopShowFloat();
        return;
    L31:
        return;
    L30:
        return;
    }
}
