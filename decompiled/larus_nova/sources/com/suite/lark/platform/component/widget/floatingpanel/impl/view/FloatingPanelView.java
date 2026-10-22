package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeTransform;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget.floatingpanel.impl.FloatPanelHitPoint;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import z5c.k;
import z5c.w3;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatingPanelView extends FrameLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f460751o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f460752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatingCardContainer f460753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FloatingPanelActionView f460754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FloatingPanelActionView f460755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FloatingBannerContainer f460756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FloatingPanelScrollView f460757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PathInterpolator f460758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f460759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f460760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f460761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f460762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f460763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f460764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f460765n;

    public static final class a implements FloatingCardContainer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelView f460766a;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC5529a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FloatingPanelView f460767a;

            public ViewOnClickListenerC5529a(FloatingPanelView r100) {
                this.f460767a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f460767a.c();
            }
        }

        public a(FloatingPanelView r100) {
            this.f460766a = r100;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingCardContainer.b
        public final void O9(boolean r100) {
            if (r100 == false) goto L5;
            this.f460766a.f460754c.setVisibility(0);
            this.f460766a.f460752a.c();
            FloatingPanelView r101 = this.f460766a;
            r101.setOnClickListener(new ViewOnClickListenerC5529a(r101));
            return;
        L5:
            this.f460766a.e();
            this.f460766a.f460752a.e();
            FloatingPanelView r102 = this.f460766a;
            r102.setOnClickListener(null);
            r102.setClickable(false);
        }
    }

    public static final class b implements com.suite.lark.platform.component.widget.floatingpanel.impl.view.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelView f460768a;

        public b(FloatingPanelView r100) {
            this.f460768a = r100;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.e
        public final void a(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "cardId");
            this.f460768a.f460752a.d(r101);
        }
    }

    public static final class c implements FloatingBannerContainer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelView f460769a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingBannerContainer.a
        public final void a() {
            FloatingBannerContainer r100 = this.f460769a.f460756e;
            int r101 = r100.getChildCount();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r100.getChildAt(r102).setVisibility(4);
            r102 = r102 + 1;
            goto L3
        L5:
            this.f460769a.f460752a.a();
        }

        public c(FloatingPanelView r100) {
            this.f460769a = r100;
        }
    }

    public static final class d implements com.suite.lark.platform.component.widget.floatingpanel.impl.view.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelView f460770a;

        public d(FloatingPanelView r100) {
            this.f460770a = r100;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.e
        public final void a(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "cardId");
            FloatingCardContainer r102 = this.f460770a.f460753b;
            if (r102.f460734g == false) goto L5;
        L12:
            this.f460770a.f460752a.d(r101);
            return;
        L5:
            if (r102.getChildCount() <= 1) goto L12;
            Long r103 = FloatPanelHitPoint.f460654a;
            int r104 = this.f460770a.f460753b.getChildCount();
            Statistics.sendEvent("im_floating_panel_expand_list_click", s5c.d.b.c(w3.f570397c.a(String.valueOf(r104))));
            final FloatingPanelView r105 = this.f460770a;
            FloatingCardContainer r106 = r105.f460753b;
            if (r106.f460734g == false) goto L9;
            return;
        L9:
            if (r106.getChildCount() <= 1) goto L16;
            TransitionManager.beginDelayedTransition(r105.f460757f, r105.d(true, new FloatingPanelView$expandCardList$1(r105)));
            r105.f460753b.f();
            return;
        }
    }

    public static final class e implements FloatingPanelActionView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f460771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatingCardContainer f460772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FloatingPanelActionView.d f460773c;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void a() {
            Long r100 = FloatPanelHitPoint.f460654a;
            FloatPanelHitPoint.a(this.f460772b.getChildCount(), this.f460771a);
            this.f460773c.a();
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void b() {
            Long r100 = FloatPanelHitPoint.f460654a;
            int r101 = this.f460772b.getChildCount();
            int r102 = this.f460771a;
            if (r102 != 2) goto L5;
            Log.e("FloatingPanelHitPoint", "sendClearListEvent. invalid button position value");
        L6:
            this.f460773c.b();
            return;
        L5:
            Statistics.sendEvent("im_floating_panel_one_key_clear_click", s5c.d.b.b(w3.f570397c.a(String.valueOf(r101)), k.f570230c.a(String.valueOf(r102))).toJson());
            goto L6
        }

        public e(int r100, FloatingCardContainer r101, h r102) {
            Intrinsics.checkNotNullParameter(r101, "cardContainer");
            Intrinsics.checkNotNullParameter(r102, "impl");
            this.f460771a = r100;
            this.f460772b = r101;
            this.f460773c = r102;
        }
    }

    public static final class f {
    }

    public interface g {
        void a();

        void b(String r100);

        void c();

        void d(String r100);

        void e();

        void f();
    }

    public static final class h implements FloatingPanelActionView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingPanelView f460775a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void a() {
            this.f460775a.c();
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void b() {
            this.f460775a.f460752a.f();
            this.f460775a.e();
        }

        public h(FloatingPanelView r100) {
            this.f460775a = r100;
        }
    }

    static {
    }

    private final TransitionSet getCardListTransition() {
        return (TransitionSet) this.f460759h.getValue();
    }

    private final TransitionSet getRemoveBannerTransition() {
        return (TransitionSet) this.f460760i.getValue();
    }

    private final TransitionSet getShowBannerCompanionTransition() {
        return (TransitionSet) this.f460762k.getValue();
    }

    private final TransitionSet getShowBannerTransition() {
        return (TransitionSet) this.f460761j.getValue();
    }

    private final TransitionSet getShowCardTransition() {
        return (TransitionSet) this.f460763l.getValue();
    }

    public final void c() {
        if (this.f460753b.f460734g == true) goto L5;
        return;
    L5:
        FloatingPanelScrollView r100 = this.f460757f;
        r100.f460750b = false;
        r100.smoothScrollTo(0, 0);
        TransitionManager.beginDelayedTransition(this.f460757f, d(false, new FloatingPanelView$collapseCardList$1(this)));
        this.f460753b.a();
    }

    public final void e() {
        this.f460754c.setVisibility(8);
        this.f460755d.setVisibility(8);
    }

    public final void f() {
        if (this.f460756e.getChildCount() != 0) goto L5;
        return;
    L5:
        FloatingBannerContainer r100 = this.f460756e;
        final View r101 = r100.getChildAt(r100.getChildCount() - 1);
        Iterator r102 = SequencesKt.filter(ViewGroupKt.getChildren(this.f460756e), new FloatingPanelView$onBannerAdded$1(r101)).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        this.f460756e.removeView((View) r102.next());
        goto L7
    }

    public final void h() {
        TransitionManager.beginDelayedTransition(this.f460757f, d(false, new FloatingPanelView$removeAllCards$1(this)));
        FloatingCardContainer r100 = this.f460753b;
        r100.i(null);
        r100.a();
    }

    public final boolean i() {
        if (this.f460756e.getChildCount() != 0) goto L6;
        return false;
    L6:
        TransitionManager.beginDelayedTransition(this.f460757f, getRemoveBannerTransition());
        this.f460756e.removeAllViews();
        return true;
    }

    public final void l() {
        Log.i("FloatingPanelView", BasicTestActionHandler.TEST_ACTION_RESET);
        TransitionManager.endTransitions(this.f460757f);
        TransitionManager.endTransitions(this.f460756e);
        this.f460756e.removeAllViews();
        FloatingCardContainer r100 = this.f460753b;
        r100.i(null);
        r100.a();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f460764m = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.f460764m == false) goto L6;
        this.f460764m = false;
        this.f460756e.requestLayout();
        return;
    }

    public final void g(List<? extends Pair<String, ? extends Function0<? extends View>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewItems");
        TransitionManager.beginDelayedTransition(this.f460757f, getShowCardTransition());
        this.f460753b.h(r100);
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        TransitionManager.beginDelayedTransition(this.f460757f, getCardListTransition());
        FloatingCardContainer r101 = this.f460753b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "id");
        int r102 = r101.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L9;
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r105 = (com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r104;
        if (Intrinsics.areEqual(r105.getCardId(), r100) == false) goto L9;
        r105.removeAllViews();
        r101.removeView(r104);
    L9:
        r103 = r103 + 1;
    L11:
        if (r101.getChildCount() != 0) goto L13;
        r101.a();
        return;
    L13:
        int r106 = r101.getChildCount();
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L21;
        View r108 = r101.getChildAt(r107);
        if ((r108 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L20;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r108).b() == true) goto L21;
    L20:
        r107 = r107 + 1;
    L21:
        r101.c(false);
    }

    public final void k(final List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        TransitionManager.beginDelayedTransition(this.f460757f, d(false, new FloatingPanelView$removeCards$1(this)));
        FloatingCardContainer r101 = this.f460753b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "ids");
        r101.i(new FloatingCardContainer$removeCards$1(r100));
        if (r101.getChildCount() != 0) goto L5;
        r101.a();
        return;
    L5:
        int r102 = r101.getChildCount();
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L16;
        View r105 = r101.getChildAt(r103);
        if ((r105 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L15;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r105).b() == false) goto L13;
        r104 = r104 + 1;
    L13:
        if (r104 > 15) goto L16;
    L15:
        r103 = r103 + 1;
    L16:
        r101.c(false);
    }

    public FloatingPanelView(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        super(r100, null, 0);
        this.f460752a = r101;
        this.f460758g = new PathInterpolator(0.4f, 0.8f, 0.73f, 1.0f);
        this.f460759h = LazyKt.lazy(new FloatingPanelView$cardListTransition$2(this));
        this.f460760i = LazyKt.lazy(new FloatingPanelView$removeBannerTransition$2(this));
        this.f460761j = LazyKt.lazy(new FloatingPanelView$showBannerTransition$2(this));
        this.f460762k = LazyKt.lazy(new FloatingPanelView$showBannerCompanionTransition$2(this));
        this.f460763l = LazyKt.lazy(new FloatingPanelView$showCardTransition$2(this));
        LayoutInflater.from(r100).inflate(R.layout.layout_floating_panel, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FloatingPanelScrollView r102 = (FloatingPanelScrollView) findViewById(R.id.floating_panel_scroll_view);
        this.f460757f = r102;
        FloatingBannerContainer r103 = (FloatingBannerContainer) findViewById(R.id.floating_panel_banner_container);
        this.f460756e = r103;
        FloatingCardContainer r104 = (FloatingCardContainer) findViewById(R.id.floating_panel_card_container);
        this.f460753b = r104;
        FloatingPanelActionView r105 = (FloatingPanelActionView) findViewById(R.id.floating_panel_card_action_top);
        this.f460754c = r105;
        FloatingPanelActionView r106 = (FloatingPanelActionView) findViewById(R.id.floating_panel_card_action_bottom);
        this.f460755d = r106;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "scrollView");
        r102.setOnScrollChangedListener(new com.suite.lark.platform.component.widget.floatingpanel.impl.view.c(r104));
        r104.setOnExpandStatusChangedListener(new a(this));
        r103.setOnBannerClickListener(new b(this));
        r103.setOnBannerMovedOutListener(new c(this));
        r104.setOnFloatingCardClickListener(new d(this));
        h r107 = new h(this);
        r105.setOnActionButtonClickedListener(new e(0, r104, r107));
        r106.setOnActionButtonClickedListener(new e(1, r104, r107));
        if (DevEnvUtil.isDevelopPackage(r100) == false) goto L5;
        findViewById(R.id.floating_panel_new_tag).setVisibility(0);
    L5:
        this.f460765n = UIUtils.dp2px(r100, 360.0f);
    }

    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        TransitionManager.beginDelayedTransition(this.f460757f, getShowBannerCompanionTransition());
        TransitionManager.beginDelayedTransition(this.f460756e, getShowBannerTransition());
        this.f460756e.a(r100, r101);
    }

    public final TransitionSet d(final boolean r100, final Function0<? extends List<Integer>> r101) {
        if (this.f460753b.g() == true) goto L6;
        return getCardListTransition();
    L6:
        return m("card_list_transition", new Transition[]{new Fade(3), new ChangeBounds(), new ChangeTransform()}, new AnonymousClass1(r101, r100, this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = j08.b.d(getContext(), r102);
        int r105 = j08.b.d(getContext(), r103);
        ViewGroup.LayoutParams r106 = this.f460757f.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        if (r105 >= 480) goto L6;
        r107.width = this.f460765n;
        r107.gravity = 1;
    L9:
        super.onMeasure(r100, r101);
        return;
    L6:
        if (r104 < 600) goto L8;
        r107.width = this.f460765n;
        r107.gravity = 5;
        goto L9
    L8:
        r107.width = -1;
        r107.gravity = 8388659;
        goto L9
    }

    public final void b(View r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cardView");
        Intrinsics.checkNotNullParameter(r112, "id");
        if (r110.getParent() == null) goto L6;
        return;
    L6:
        if (this.f460753b.f460734g == true) goto L12;
        FloatingPanelScrollView r100 = this.f460757f;
        final Function0<List<? extends Integer>> r101 = new FloatingPanelView$addCard$1(this);
        if (this.f460753b.g() == true) goto L10;
        TransitionSet r102 = getShowCardTransition();
    L11:
        TransitionManager.beginDelayedTransition(r100, r102);
    L13:
        FloatingCardContainer r103 = this.f460753b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "cardView");
        Intrinsics.checkNotNullParameter(r112, "id");
        int r104 = r103.getChildCount();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L21;
        View r106 = r103.getChildAt(r105);
        if ((r106 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L20;
        if (Intrinsics.areEqual(((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r106).getCardId(), r112) == false) goto L20;
        Log.e("FloatingCardContainer", "addCard: " + r112 + " is already added");
        return;
    L20:
        r105 = r105 + 1;
        goto L14
    L21:
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r113 = r103.b(r110, null, r111, r112);
        if (r113.isLaidOut() == true) goto L24;
    L26:
        r113.addOnLayoutChangeListener(new com.suite.lark.platform.component.widget.floatingpanel.impl.view.b(r103));
        return;
    L24:
        if (r113.isLayoutRequested() == true) goto L26;
        r103.c(false);
        return;
    L10:
        Slide r107 = new Slide(48);
        r107.setMode(1);
        Unit r108 = Unit.INSTANCE;
        r102 = m("show_card_transition", new Transition[]{r107, new Fade(2), new ChangeTransform(), new ChangeBounds()}, new FloatingPanelView$getAddCardTransition$2(r101));
        goto L11
    L12:
        TransitionManager.beginDelayedTransition(this.f460757f, getShowCardTransition());
        goto L13
    }

    public final TransitionSet m(final String r100, Transition[] r101, Function1<? super TransitionSet, Unit> r102) {
        TransitionSet r103 = new TransitionSet().setInterpolator(this.f460758g).setDuration(300).addListener(new FloatingPanelView$transitionSet$1(this, r100));
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.addTransition(r101[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        if (r102 == null) goto L7;
        r102.invoke(r103);
    L7:
        return r103;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f460753b.getHeight() <= this.f460757f.getHeight()) goto L5;
        this.f460755d.setVisibility(0);
        return;
    L5:
        this.f460755d.setVisibility(8);
    }
}
