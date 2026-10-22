package com.bytedance.android.shopping.store.tabkit;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.event.BaseEventContext;
import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.store.brandmall.events.EcomPageCrossSlideEvent;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.view.TabRootView;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.tabkit.events.ClickTopEvent;
import com.bytedance.android.shopping.store.tabkit.events.EcomStayTimeEvent;
import com.bytedance.android.shopping.store.tabkit.events.PageViewEvent;
import com.bytedance.android.shopping.store.tabkit.events.ShowTopTabEvent;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventContext;
import com.bytedance.android.shopping.store.tabkit.model.a0;
import com.bytedance.android.shopping.store.tabkit.model.b0;
import com.bytedance.android.shopping.store.tabkit.model.m;
import com.bytedance.android.shopping.store.tabkit.model.q;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.t;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.ECTabKitView;
import com.bytedance.android.shopping.store.tabkit.view.FloatDebugLynxView;
import com.bytedance.android.shopping.store.tabkit.view.HybridTabLayout;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.android.shopping.store.tabkit.view.RightItemView;
import com.bytedance.android.shopping.store.tabkit.view.ScrollableViewPager;
import com.bytedance.android.shopping.store.tabkit.view.TabKitDialogView;
import com.bytedance.android.shopping.store.tabkit.view.TabKitMainContainerView;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundFrameLayout;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/b;", "Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView$a;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPause", "onResume", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TabKitPresenter extends QFragmentPresenter implements com.bytedance.android.shopping.store.tabkit.bridge.b, TabKitMainContainerView.a, LifecycleObserver {
    public boolean A;
    public final h B;
    public final LinkedList<View> C;
    public final com.bytedance.android.shopping.store.tabkit.f D;
    public ScrollableViewPager f;
    public ECTabLayout g;
    public MixTabLayout h;
    public MixTabLayout i;
    public RightItemView j;
    public View k;
    public ECDraweeView l;
    public View m;
    public StatusView n;
    public View o;
    public View p;
    public FloatDebugLynxView q;
    public ConstraintLayout r;
    public ECDraweeView s;
    public TabKitMainContainerView t;
    public FrameLayout u;
    public final Lazy v;
    public final Lazy w;
    public final a x;
    public final Handler y;
    public final c z;

    public static final class a implements ECTabLayout.OnTabSelectedListener {
        public final /* synthetic */ TabKitPresenter a;

        public a(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(ECTabLayout.Tab r7) {
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitViewModel r8 = this.a.k0();
            if (r8 == null) goto L9;
            MutableLiveData<y> r9 = r8.getCurrentTab();
            if (r9 == null) goto L9;
            y r10 = (y) r9.getValue();
            if (r10 == null) goto L9;
            com.bytedance.android.shopping.store.tabkit.model.k r11 = r10.a;
        L10:
            if (r11 == null) goto L37;
            com.bytedance.android.shopping.store.tabkit.model.c r1 = r11.a();
            if (r1 == null) goto L45;
            a0 r2 = r1.a();
            if (r2 == null) goto L46;
            List<b0> r3 = r2.a();
            if (r3 == null) goto L47;
            Iterator<T> r4 = r3.iterator();
        L19:
            if (r4.hasNext() == false) goto L48;
            ExtensionsKt$toBaseMetricEvent2$3 r5 = com.bytedance.android.shopping.store.tabkit.e.r(this.a.h0((b0) r4.next(), r11), r11);
            if (r5 == null) goto L19;
            TabKitViewModel r6 = this.a.k0();
            if (r6 == null) goto L29;
            com.bytedance.android.shopping.store.tabkit.model.k r12 = r6.getLastTab();
            if (r12 == null) goto L29;
            Map<String, String> r13 = r12.h();
            if (r13 == null) goto L29;
            String r14 = r13.get("main_tab");
        L30:
            r5.appendParam("main_tab", r14);
            BaseEventContext[] r15 = new BaseEventContext[1];
            TabKitViewModel r16 = this.a.k0();
            if (r16 == null) goto L33;
            TabKitEventContext r17 = r16.getEventContext();
        L34:
            r15[0] = r17;
            BaseMetricsEvent2 r18 = r5.with(r15);
            if (r18 == null) goto L19;
            r18.post(null, null);
            goto L19
        L33:
            r17 = null;
        L29:
            r14 = null;
            goto L30
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        L37:
            return;
        L9:
            r11 = null;
            goto L10
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r2) {
            TabKitPresenter.e0(this.a, r2);
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(ECTabLayout.Tab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
            this.a.getClass();
            View r3 = r2.getCustomView();
            if ((r3 instanceof BottomTabItemView) == true) goto L5;
            r3 = null;
        L5:
            BottomTabItemView r4 = (BottomTabItemView) r3;
            if (r4 == null) goto L9;
            r4.setSelected(false);
            return;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "tab");
            TabKitPresenter r1 = this.a;
            r1.getClass();
            if (r11 == false) goto L62;
            View r12 = r10.getCustomView();
            if ((r12 instanceof BottomTabItemView) == true) goto L7;
            r12 = null;
        L7:
            BottomTabItemView r13 = (BottomTabItemView) r12;
            if (r13 == null) goto L67;
            r13.b(true, true);
            int r14 = r10.getPosition();
            TabKitViewModel r15 = r1.k0();
            if (r15 == null) goto L63;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r16 = r15.getHomeTabs();
            if (r16 == null) goto L64;
            com.bytedance.android.shopping.store.tabkit.model.k r17 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r16, r14);
            if (r17 != null) goto L18;
            return;
        L18:
            if (r17.g() == false) goto L20;
            com.bytedance.android.shopping.store.tabkit.model.k r18 = r17.d();
        L21:
            if (r18 == null) goto L69;
            r1.p0(r18, "bottom_tab_click");
            com.bytedance.android.shopping.store.tabkit.model.c r4 = r17.a();
            if (r4 == null) goto L49;
            a0 r5 = r4.a();
            if (r5 == null) goto L49;
            List<b0> r6 = r5.a();
            if (r6 == null) goto L49;
            Iterator<T> r7 = r6.iterator();
        L31:
            if (r7.hasNext() == false) goto L49;
            ExtensionsKt$toBaseMetricEvent2$3 r8 = com.bytedance.android.shopping.store.tabkit.e.r(r1.h0((b0) r7.next(), r18), r18);
            if (r8 == null) goto L31;
            TabKitViewModel r9 = r1.k0();
            if (r9 == null) goto L41;
            com.bytedance.android.shopping.store.tabkit.model.k r19 = r9.getLastTab();
            if (r19 == null) goto L41;
            Map<String, String> r20 = r19.h();
            if (r20 == null) goto L41;
            String r21 = r20.get("main_tab");
        L42:
            r8.appendParam("main_tab", r21);
            BaseEventContext[] r22 = new BaseEventContext[1];
            TabKitViewModel r23 = r1.k0();
            if (r23 == null) goto L45;
            TabKitEventContext r24 = r23.getEventContext();
        L46:
            r22[0] = r24;
            BaseMetricsEvent2 r25 = r8.with(r22);
            if (r25 == null) goto L31;
            r25.post(null, null);
            goto L31
        L45:
            r24 = null;
        L41:
            r21 = null;
        L49:
            TabKitViewModel r110 = r1.k0();
            if (r110 == null) goto L65;
            com.bytedance.android.shopping.store.tabkit.bridge.c r111 = r110.getJsEventStub();
            if (r111 == null) goto L66;
            Intrinsics.checkNotNullParameter(r17, "tab");
            JSONObject r0 = new JSONObject();
            r0.put("tab_id", r17.n());
            r0.put("tab_item", r17.d);
            Unit r112 = Unit.INSTANCE;
            r111.a("ecTabKit.bottomTabItemDidClick", r0);
            return;
        L66:
            return;
        L65:
            return;
        L69:
            return;
        L20:
            r18 = r17;
            goto L21
        L64:
            return;
        L63:
            return;
        L67:
            return;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == true) goto L6;
            this.b.setVisibility(8);
            this.b.setAlpha(1.0f);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == false) goto L6;
            this.b.setAlpha(0.0f);
            this.b.setVisibility(0);
            return;
        }

        public b(boolean r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TabKitPresenter a;

        public c(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.D.finish();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.shopping.store.tabkit.model.k a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TabKitPresenter c;

        public d(com.bytedance.android.shopping.store.tabkit.model.k r1, String r2, TabKitPresenter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            TabKitViewModel r0 = this.c.k0();
            if (r0 == null) goto L10;
            ArrayList<com.bytedance.android.shopping.store.tabkit.g> r1 = r0.getTabKitLifeListeners();
            if (r1 == null) goto L10;
            Iterator<T> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((com.bytedance.android.shopping.store.tabkit.g) r2.next()).o(this.a);
        L10:
            p.a.openSchema(r4.getContext(), this.b);
        }
    }

    public static final class e implements IECLynxCardLifeCycle {
        public final /* synthetic */ TabKitPresenter a;
        public final /* synthetic */ MixTabLayout b;
        public final /* synthetic */ boolean c;

        public final void createViewDuration(long r1) {
        }

        public final void onCreateKitViewEnd(long r1) {
        }

        public final void onDestroy() {
        }

        public final void onFirstScreen() {
        }

        public final void onLoadStart() {
        }

        public final void onLoadSuccess() {
        }

        public final void onPreCreateView(boolean r1) {
        }

        public final void onRealSuccess() {
        }

        public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
        }

        public final void onRuntimeReady() {
        }

        public final void onTimingSetup(Map<String, ? extends Object> r1) {
        }

        public final void onTimingSetupPref(com.bytedance.android.ec.hybrid.card.util.k r1) {
        }

        public final void onTimingUpdatePref(com.bytedance.android.ec.hybrid.card.util.k r1) {
        }

        public final void onTransDataTime(long r1, long r3) {
        }

        public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
            Intrinsics.checkNotNullParameter(r2, "cache");
            Intrinsics.checkNotNullParameter(r2, "cache");
        }

        public e(TabKitPresenter r1, MixTabLayout r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            MixTabLayout r4 = this.b;
            r4.getClass();
            ExtensionsKt.visible(r4);
            ExtensionsKt.visible(r4.a);
            HybridTabLayout r5 = r4.b;
            if (r5 == null) goto L6;
            ExtensionsKt.gone(r5);
        L6:
            if (this.c == false) goto L30;
            TabKitViewModel r6 = this.a.k0();
            if (r6 == null) goto L12;
            MutableLiveData<Boolean> r7 = r6.isUseNativeTopBar();
            if (r7 == null) goto L12;
            r7.setValue(Boolean.TRUE);
        L12:
            TabKitViewModel r8 = this.a.k0();
            if (r8 == null) goto L29;
            MutableLiveData<z> r9 = r8.getTabResponse();
            if (r9 == null) goto L29;
            z r10 = (z) r9.getValue();
            if (r10 == null) goto L29;
            this.a.n0(r10);
            TabKitPresenter r11 = this.a;
            TabKitViewModel r12 = r11.k0();
            if (r12 == null) goto L27;
            MutableLiveData<y> r13 = r12.getCurrentTab();
            if (r13 == null) goto L27;
            y r14 = (y) r13.getValue();
            if (r14 == null) goto L27;
            com.bytedance.android.shopping.store.tabkit.model.k r15 = r14.a;
            if (r15 == null) goto L27;
            com.bytedance.android.shopping.store.tabkit.model.e r16 = r15.i();
        L28:
            r11.r0(r16);
            this.a.v0();
        L27:
            r16 = null;
        L29:
            this.a.w0();
        L42:
            cl.d.a.getClass();
            cl.d r17 = cl.d.a.b();
            if (r17 == null) goto L46;
            r17.n();
            return;
        L46:
            return;
        L30:
            TabKitViewModel r18 = this.a.k0();
            if (r18 == null) goto L35;
            MutableLiveData<Boolean> r19 = r18.isUseNativeBottomBar();
            if (r19 == null) goto L35;
            r19.setValue(Boolean.TRUE);
        L35:
            TabKitViewModel r20 = this.a.k0();
            if (r20 == null) goto L42;
            MutableLiveData<z> r21 = r20.getTabResponse();
            if (r21 == null) goto L42;
            z r22 = (z) r21.getValue();
            if (r22 == null) goto L42;
            this.a.l0(r22);
            goto L42
        }
    }

    public static final class f implements View.OnAttachStateChangeListener {
        public final /* synthetic */ TabKitPresenter a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public f(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            TabKitViewModel r4 = this.a.k0();
            if (r4 == null) goto L7;
            MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r5 = r4.getCurrentHomeTab();
            if (r5 == null) goto L7;
            com.bytedance.android.shopping.store.tabkit.model.k r6 = (com.bytedance.android.shopping.store.tabkit.model.k) r5.getValue();
        L8:
            if (r6 == null) goto L19;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r7 = r6.m();
            if (r7 == null) goto L27;
            Iterator<T> r8 = r7.iterator();
        L13:
            if (r8.hasNext() == false) goto L28;
            com.bytedance.android.shopping.store.tabkit.model.k r0 = (com.bytedance.android.shopping.store.tabkit.model.k) r8.next();
            TabKitViewModel r1 = this.a.k0();
            if (r1 == null) goto L13;
            com.bytedance.android.shopping.store.tabkit.bridge.c r2 = r1.getJsEventStub();
            if (r2 == null) goto L13;
            r2.b(r0);
            goto L13
        L28:
            return;
        L27:
            return;
        L19:
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ TabKitPresenter a;

        public g(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.W(1);
            TabKitViewModel r4 = this.a.k0();
            if (r4 == null) goto L6;
            r4.setClickCloseBtn(true);
            return;
        }
    }

    public static final class h implements ECTabLayout.OnTabSelectedListener {
        public final /* synthetic */ TabKitPresenter a;

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(ECTabLayout.Tab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(ECTabLayout.Tab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        public h(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r2) {
            TabKitPresenter.e0(this.a, r2);
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r7, boolean r8) {
            if (r8 == false) goto L50;
            TabKitViewModel r9 = this.a.k0();
            if (r9 == null) goto L51;
            MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r10 = r9.getCurrentHomeTab();
            if (r10 == null) goto L52;
            com.bytedance.android.shopping.store.tabkit.model.k r11 = (com.bytedance.android.shopping.store.tabkit.model.k) r10.getValue();
            if (r11 == null) goto L53;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r12 = r11.m();
            if (r12 != null) goto L12;
            return;
        L12:
            if (r7 == null) goto L14;
            int r1 = r7.getPosition();
        L15:
            com.bytedance.android.shopping.store.tabkit.model.k r13 = (com.bytedance.android.shopping.store.tabkit.model.k) ListProtector.get(r12, r1);
            if (r13 == null) goto L57;
            ClickTopEvent r2 = new ClickTopEvent();
            Map<String, String> r3 = r13.h();
            if (r3 == null) goto L21;
            r2.appendParam(r3);
        L21:
            TabKitViewModel r4 = this.a.k0();
            View r5 = null;
            if (r4 == null) goto L28;
            com.bytedance.android.shopping.store.tabkit.model.k r6 = r4.getLastTab();
            if (r6 == null) goto L28;
            Map<String, String> r14 = r6.h();
            if (r14 == null) goto L28;
            String r15 = r14.get("main_tab");
        L29:
            r2.setMainTab(r15);
            BaseEventContext[] r16 = new BaseEventContext[1];
            TabKitViewModel r17 = this.a.k0();
            if (r17 == null) goto L32;
            TabKitEventContext r18 = r17.getEventContext();
        L33:
            r16[0] = r18;
            r2.with(r16).post(null, null);
            this.a.p0(r13, "top_tab_click");
            if (r7 == null) goto L36;
            View r19 = r7.getCustomView();
        L38:
            if ((r19 instanceof ABSTabItemView) == false) goto L41;
            r5 = r19;
        L41:
            ABSTabItemView r20 = (ABSTabItemView) r5;
            if (r20 == null) goto L44;
            r20.b(true, true);
        L44:
            TabKitViewModel r21 = this.a.k0();
            if (r21 == null) goto L55;
            com.bytedance.android.shopping.store.tabkit.bridge.c r22 = r21.getJsEventStub();
            if (r22 == null) goto L56;
            Intrinsics.checkNotNullParameter(r13, "tab");
            JSONObject r0 = new JSONObject();
            r0.put("tab_id", r13.n());
            r0.put("tab_item", r13.d);
            Unit r23 = Unit.INSTANCE;
            r22.a("ecTabKit.topTabItemDidClick", r0);
            return;
        L56:
            return;
        L55:
            return;
        L36:
            r19 = null;
            goto L38
        L32:
            r18 = null;
        L28:
            r15 = null;
            goto L29
        L57:
            return;
        L14:
            r1 = 0;
            goto L15
        L53:
            return;
        L52:
            return;
        L51:
            return;
        }
    }

    public static final class i implements RightItemView.a {
        public final /* synthetic */ TabKitPresenter a;

        public i(TabKitPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.view.RightItemView.a
        public final void a(View r6, com.bytedance.android.shopping.store.tabkit.model.f r7) {
            Intrinsics.checkNotNullParameter(r6, "view");
            Intrinsics.checkNotNullParameter(r7, "navItem");
            TabKitViewModel r1 = this.a.k0();
            if (r1 == null) goto L9;
            MutableLiveData<y> r2 = r1.getCurrentTab();
            if (r2 == null) goto L9;
            y r3 = (y) r2.getValue();
            if (r3 == null) goto L9;
            com.bytedance.android.shopping.store.tabkit.model.k r4 = r3.a;
        L10:
            p.a.openSchema(r6.getContext(), r7.b());
            TabKitViewModel r8 = this.a.k0();
            if (r8 == null) goto L15;
            com.bytedance.android.shopping.store.tabkit.bridge.c r9 = r8.getJsEventStub();
            if (r9 == null) goto L15;
            Intrinsics.checkNotNullParameter(r7, "navItem");
            JSONObject r0 = new JSONObject();
            r0.put("item_name", r7.d());
            r0.put("nav_item", r7.a);
            Unit r5 = Unit.INSTANCE;
            r9.a("ecTabKit.navItemDidClick", r0);
        L15:
            com.bytedance.android.shopping.store.tabkit.model.c r10 = r7.a();
            if (r10 == null) goto L18;
            a0 r11 = r10.a();
        L19:
            if (r11 == null) goto L28;
            List<b0> r12 = r11.a();
            if (r12 == null) goto L34;
            Iterator<T> r13 = r12.iterator();
        L24:
            if (r13.hasNext() == false) goto L35;
            ExtensionsKt$toBaseMetricEvent2$1 r14 = com.bytedance.android.shopping.store.tabkit.e.q(this.a.h0((b0) r13.next(), r4), r4, r11);
            if (r14 == null) goto L24;
            r14.post(null, null);
            goto L24
        L35:
            return;
        L34:
            return;
        L28:
            return;
        L18:
            r11 = null;
        L9:
            r4 = null;
            goto L10
        }
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.TabKitMainContainerView.a
    public final void T(ScrollableViewPager r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void I() {
        this.y.removeCallbacks(this.z);
        this.A = false;
    }

    public final ECTabLayout j0() {
        MixTabLayout r0 = this.h;
        if (r0 == null) goto L7;
        ECTabLayout r1 = r0.getNativeTabLayout();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.g;
    }

    public final TabKitViewModel k0() {
        return this.D.getTabKitViewModel();
    }

    public final void c0() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L5;
        r0.getJsBridge();
    L5:
        this.y.removeCallbacks(this.z);
        this.A = false;
        o0();
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L9;
        r1.removeMonitor();
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final int getScreenState() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L9;
        MutableLiveData<Integer> r1 = r0.getScreenState();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public final void o0() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L26;
        Long r1 = r0.getLastTimeStamp();
        if (r1 == null) goto L27;
        long r2 = r1.longValue();
        EcomStayTimeEvent r3 = new EcomStayTimeEvent();
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L13;
        TabKitViewModel r4 = k0();
        if (r4 == null) goto L11;
        com.bytedance.android.shopping.store.tabkit.model.k r5 = r4.getLastTab();
    L12:
        r3.appendParam(i0(r5));
        goto L13
    L11:
        r5 = null;
    L13:
        r3.setDuration(String.valueOf(System.currentTimeMillis() - r2));
        TabKitViewModel r6 = k0();
        if (r6 == null) goto L20;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = r6.getLastTab();
        if (r7 == null) goto L20;
        Map<String, String> r8 = r7.h();
        if (r8 == null) goto L20;
        r3.appendParam(r8);
    L20:
        BaseEventContext[] r9 = new BaseEventContext[1];
        TabKitViewModel r10 = k0();
        if (r10 == null) goto L23;
        TabKitEventContext r11 = r10.getEventContext();
    L24:
        r9[0] = r11;
        r3.with(r9).post(null, null);
        return;
    L23:
        r11 = null;
        goto L24
    L27:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L10;
        ArrayList<ECLynxCard> r1 = r0.getLynxCards();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ECLynxCard r3 = (ECLynxCard) r2.next();
        r3.o("H5_visibilityChange", new JSONObject().put("visible", false));
        r3.o("pageVisibilityChange", new JSONObject().put("visible", false));
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L10;
        ArrayList<ECLynxCard> r1 = r0.getLynxCards();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ECLynxCard r3 = (ECLynxCard) r2.next();
        r3.o("H5_visibilityChange", new JSONObject().put("visible", true));
        r3.o("pageVisibilityChange", new JSONObject().put("visible", true));
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void q0() {
        TabKitViewModel r0 = k0();
        boolean r1 = true;
        Integer r2 = null;
        if (r0 != null) goto L5;
    L13:
        TabKitViewModel r3 = k0();
        if (r3 == null) goto L18;
        MutableLiveData<Boolean> r4 = r3.isLandingFinished();
        if (r4 == null) goto L18;
        Boolean r5 = (Boolean) r4.getValue();
    L19:
        boolean r6 = Intrinsics.areEqual(r5, Boolean.FALSE);
    L21:
        if (hk3.e.a() > 1) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L27;
        if (r6 == false) goto L27;
        return;
    L27:
        TabKitViewModel r7 = k0();
        if (r7 == null) goto L32;
        MutableLiveData<Boolean> r8 = r7.isUseNativeBottomBar();
        if (r8 == null) goto L32;
        Boolean r9 = (Boolean) r8.getValue();
    L34:
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L36;
        return;
    L36:
        TabKitViewModel r10 = k0();
        if (r10 == null) goto L43;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r11 = r10.getCurrentHomeTab();
        if (r11 == null) goto L43;
        com.bytedance.android.shopping.store.tabkit.model.k r12 = (com.bytedance.android.shopping.store.tabkit.model.k) r11.getValue();
        if (r12 == null) goto L43;
        q r13 = r12.c();
    L44:
        if (r13 == null) goto L46;
        com.bytedance.android.shopping.store.tabkit.model.p r14 = com.bytedance.android.shopping.store.tabkit.e.o(r13, k0());
    L47:
        MixTabLayout r15 = this.i;
        if (r15 == null) goto L55;
        ECTabLayout r16 = r15.getNativeTabLayout();
        if (r16 == null) goto L55;
        if (r13 == null) goto L53;
        com.bytedance.android.shopping.store.tabkit.model.p r17 = com.bytedance.android.shopping.store.tabkit.e.o(r13, k0());
    L54:
        com.bytedance.android.shopping.store.tabkit.e.u(r16, r17, false, this.i, this.k, this.j);
        goto L55
    L53:
        r17 = null;
    L55:
        MixTabLayout r18 = this.i;
        if (r18 == null) goto L61;
        if (r14 == null) goto L59;
        r2 = r14.c();
    L59:
        com.bytedance.android.shopping.store.tabkit.e.p(r18, r2);
        return;
    L61:
        return;
    L46:
        r14 = null;
    L43:
        r13 = null;
    L32:
        r9 = null;
    L18:
        r5 = null;
        goto L19
    L5:
        if (r0.getLandingFinishedOpt() != true) goto L13;
        TabKitViewModel r19 = k0();
        if (r19 == null) goto L11;
        MutableLiveData<Boolean> r20 = r19.getPageLandingFinished();
        if (r20 == null) goto L11;
        Boolean r21 = (Boolean) r20.getValue();
    L12:
        r6 = Intrinsics.areEqual(r21, Boolean.FALSE);
    L11:
        r21 = null;
        goto L12
    }

    public final void s0() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L43;
        MutableLiveData<y> r1 = r0.getCurrentTab();
        if (r1 == null) goto L44;
        y r2 = (y) r1.getValue();
        if (r2 == null) goto L45;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = r2.a;
        if (r3 == null) goto L49;
        TabKitViewModel r4 = k0();
        boolean r5 = true;
        if (r4 == null) goto L35;
        Boolean r6 = (Boolean) r4.isUseNativeTopBar().getValue();
        Boolean r7 = Boolean.FALSE;
        if (Intrinsics.areEqual(r6, r7) == true) goto L34;
        com.bytedance.android.shopping.store.tabkit.model.e r8 = r3.i();
        if (r8 == null) goto L20;
        Boolean r9 = r8.a();
    L22:
        if (Intrinsics.areEqual(r9, r7) == false) goto L34;
        Boolean r10 = r4.getNavBarVisibilityMap().get(r3);
        if (r10 == null) goto L26;
        boolean r11 = r10.booleanValue();
    L27:
        if (r11 == false) goto L34;
        Integer r12 = (Integer) r4.getScreenState().getValue();
        if (r12 == null) goto L34;
        if (r12.intValue() != 0) goto L34;
    L26:
        r11 = true;
        goto L27
    L20:
        r9 = null;
    L34:
        r5 = false;
    L35:
        if (r5 == false) goto L39;
        View r13 = this.m;
        if (r13 == null) goto L46;
        r13.setVisibility(0);
        return;
    L46:
        return;
    L39:
        View r14 = this.m;
        if (r14 == null) goto L48;
        r14.setVisibility(8);
        return;
    L48:
        return;
    L49:
        return;
    L45:
        return;
    L44:
        return;
    }

    public final void t0() {
        TabKitViewModel r0 = k0();
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.shopping.store.tabkit.f r1 = this.D;
        Integer r3 = null;
        if ((r1 instanceof TabKitFragment) == true) goto L10;
        r1 = null;
    L10:
        TabKitFragment r2 = (TabKitFragment) r1;
        if (r2 == null) goto L52;
        Window r4 = r2.e;
        if (r4 == null) goto L53;
        View r5 = d0(r4);
        if (r5 == null) goto L56;
        TabKitViewModel r6 = k0();
        if (r6 == null) goto L20;
        TabKitRouterParams r7 = r6.getRouterParams();
    L21:
        TabKitViewModel r8 = k0();
        if (r8 == null) goto L26;
        MutableLiveData<Integer> r9 = r8.getScreenState();
        if (r9 == null) goto L26;
        r3 = (Integer) r9.getValue();
    L26:
        if (r3 != null) goto L29;
    L30:
        TabKitViewModel r10 = k0();
        float r11 = 0.0f;
        if (r10 == null) goto L36;
        MutableLiveData<Float> r12 = r10.getScreenOffsetFactor();
        if (r12 == null) goto L36;
        Float r13 = (Float) r12.getValue();
        if (r13 == null) goto L36;
    L38:
        if (Float.compare(r13.floatValue(), 1.0f) >= 0) goto L45;
    L39:
        if (r7 == null) goto L43;
        Integer r14 = r7.getSplitRadius();
        if (r14 == null) goto L43;
        int r15 = r14.intValue();
    L44:
        r11 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r15));
    L43:
        r15 = 12;
    L45:
        RoundFrameLayout r16 = (RoundFrameLayout) r5.findViewById(2131371216);
        if (r16 == null) goto L54;
        Drawable r17 = r16.getBackground();
        if (r17 == null) goto L51;
        BackgroundDrawable r18 = (BackgroundDrawable) r17;
        r18.setCornerRadiusTL(r11);
        r18.setCornerRadiusTR(r11);
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    L54:
        return;
    L36:
        r13 = Float.valueOf(0.0f);
        goto L38
    L29:
        if (r3.intValue() == 1) goto L39;
    L20:
        r7 = null;
        goto L21
    L56:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        if (r0.getNoRadius() != true) goto L7;
    }

    public final void u0() {
        ECTabLayout r0 = j0();
        if (r0 != null) goto L5;
        return;
    L5:
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L36;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r2 = r1.getCurrentHomeTab();
        if (r2 == null) goto L37;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = (com.bytedance.android.shopping.store.tabkit.model.k) r2.getValue();
        if (r3 == null) goto L39;
        ScrollableViewPager r4 = this.f;
        if (r4 != null) goto L21;
        TabKitMainContainerView r5 = this.t;
        if (r5 == null) goto L20;
        ViewPager r6 = r5.getChildAt(((Number) r3.b.getFirst()).intValue());
        if ((r6 instanceof ScrollableViewPager) == true) goto L19;
        r6 = null;
    L19:
        r4 = (ScrollableViewPager) r6;
        goto L21
    L20:
        r4 = null;
    L21:
        if (r4 != null) goto L23;
        return;
    L23:
        TabKitViewModel r7 = k0();
        if (r7 == null) goto L28;
        MutableLiveData<Integer> r8 = r7.getTabSwitchMode();
        if (r8 == null) goto L28;
        Integer r9 = (Integer) r8.getValue();
    L29:
        if (r9 != null) goto L32;
    L34:
        r0.setupWithViewPager(r4);
        return;
    L32:
        if (r9.intValue() != 1) goto L34;
        r0.setupWithViewPager(null);
        return;
    L28:
        r9 = null;
        goto L29
    L39:
        return;
    L37:
        return;
    }

    public final void v0() {
        TabKitViewModel r0 = k0();
        ViewPager r1 = null;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r2 = r0.isUseNativeTopBar();
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.getValue();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L11;
        return;
    L11:
        ECTabLayout r4 = j0();
        if (r4 != null) goto L14;
        return;
    L14:
        TabKitViewModel r5 = k0();
        if (r5 == null) goto L96;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r6 = r5.getCurrentHomeTab();
        if (r6 == null) goto L97;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = (com.bytedance.android.shopping.store.tabkit.model.k) r6.getValue();
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.g() == false) goto L71;
        r4.setVisibility(0);
        LinkedList<View> r8 = this.C;
        List<ECTabLayout.Tab> r9 = com.bytedance.android.shopping.store.tabkit.e.k(r4);
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((ArrayList) r9).iterator();
    L25:
        if (r11.hasNext() == false) goto L29;
        View r12 = ((ECTabLayout.Tab) r11.next()).getCustomView();
        if (r12 == null) goto L25;
        r10.add(r12);
        goto L25
    L29:
        r8.addAll(r10);
        r4.removeAllTabs();
        List<com.bytedance.android.shopping.store.tabkit.model.k> r13 = r7.m();
        if (r13 == null) goto L72;
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L33:
        if (r14.hasNext() == false) goto L72;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();
    L37:
        com.bytedance.android.shopping.store.tabkit.model.k r18 = (com.bytedance.android.shopping.store.tabkit.model.k) r16;
        Integer r19 = r7.c;
        boolean r20 = true;
        if (r19 != null) goto L41;
    L43:
        boolean r21 = false;
    L44:
        ECTabLayout.Tab r22 = r4.newTab();
        View r110 = this.C.poll();
        if (r110 != null) goto L52;
        TabKitViewModel r111 = k0();
        if (r111 == null) goto L51;
        ITabKitComponentFactory r112 = r111.getTabKitComponentFactory();
        if (r112 == null) goto L51;
        r110 = r112.createTopTabItemView(r4.getContext());
    L51:
        r110 = null;
    L52:
        r22.setCustomView(r110);
        View r113 = r22.getCustomView();
        if (r113 == null) goto L70;
        TopTabItemView r114 = (TopTabItemView) r113;
        r114.setTab(r18);
        r114.setSelected(r21);
        TabKitViewModel r115 = r114.getViewModel();
        if (r115 != null) goto L57;
    L59:
        r20 = false;
    L60:
        r114.setFullScreenState(r20);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        TabKitViewModel r23 = k0();
        if (r23 == null) goto L68;
        ArrayList<com.bytedance.android.shopping.store.tabkit.g> r24 = r23.getTabKitLifeListeners();
        if (r24 == null) goto L68;
        Iterator<T> r25 = r24.iterator();
    L66:
        if (r25.hasNext() == false) goto L68;
        ((com.bytedance.android.shopping.store.tabkit.g) r25.next()).l(r18);
    L68:
        r4.addTab(r22, r21);
        r15 = r17;
        goto L33
    L57:
        if (r115.isFullScreen() != true) goto L59;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.view.TopTabItemView");
    L41:
        if (r15 != r19.intValue()) goto L43;
        r21 = true;
    L72:
        ScrollableViewPager r26 = this.f;
        if (r26 != null) goto L81;
        TabKitMainContainerView r27 = this.t;
        if (r27 == null) goto L82;
        ViewPager r28 = r27.getChildAt(((Number) r7.b.getFirst()).intValue());
        if ((r28 instanceof ScrollableViewPager) == false) goto L80;
        r1 = r28;
    L80:
        r1 = (ScrollableViewPager) r1;
    L82:
        if (r1 == null) goto L84;
        r4.setupWithViewPager(r1);
    L84:
        u0();
        return;
    L81:
        r1 = r26;
        goto L82
    L71:
        r4.setVisibility(8);
        goto L72
    L97:
        return;
    L96:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void w0() {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.isUseNativeTopBar();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L8:
        Boolean r3 = Boolean.FALSE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L11;
        return;
    L11:
        TabKitViewModel r4 = k0();
        if (r4 == null) goto L122;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r5 = r4.getCurrentHomeTab();
        if (r5 == null) goto L127;
        com.bytedance.android.shopping.store.tabkit.model.k r6 = (com.bytedance.android.shopping.store.tabkit.model.k) r5.getValue();
        if (r6 == null) goto L130;
        ECTabLayout r9 = j0();
        if (r9 != null) goto L22;
        return;
    L22:
        if (r6.g() == false) goto L114;
        com.bytedance.android.shopping.store.tabkit.model.k r10 = r6.d();
        if (r10 == null) goto L28;
        q r7 = r10.p();
        if (r7 == null) goto L28;
        com.bytedance.android.shopping.store.tabkit.model.p r11 = com.bytedance.android.shopping.store.tabkit.e.o(r7, k0());
    L29:
        if (r10 == null) goto L33;
        q r8 = r10.p();
        if (r8 == null) goto L33;
        com.bytedance.android.shopping.store.tabkit.model.p r12 = com.bytedance.android.shopping.store.tabkit.e.o(r8, k0());
    L34:
        com.bytedance.android.shopping.store.tabkit.e.u(r9, r12, true, this.h, this.k, this.j);
        Integer r13 = r6.c;
        if (r13 == null) goto L37;
        r9.selectTab(r13.intValue());
    L37:
        MixTabLayout r14 = this.h;
        if (r14 == null) goto L43;
        if (r11 == null) goto L41;
        Integer r15 = r11.c();
    L42:
        com.bytedance.android.shopping.store.tabkit.e.p(r14, r15);
        goto L43
    L41:
        r15 = null;
    L43:
        TabKitViewModel r16 = k0();
        if (r16 == null) goto L48;
        HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> r17 = r16.getTopTabBarVisibilityMap();
        if (r17 == null) goto L48;
        com.bytedance.android.shopping.store.tabkit.model.d r18 = r17.get(r10);
    L49:
        TabKitViewModel r19 = k0();
        if (r19 == null) goto L54;
        MutableLiveData<Integer> r20 = r19.getScreenState();
        if (r20 == null) goto L54;
        Integer r21 = (Integer) r20.getValue();
    L56:
        if (r21 != null) goto L59;
    L62:
        if (r18 == null) goto L64;
        Boolean r22 = r18.b;
    L65:
        Boolean r23 = Boolean.TRUE;
        if (Intrinsics.areEqual(r22, r23) == false) goto L71;
        MixTabLayout r24 = this.h;
        if (r24 == null) goto L75;
        r24.setVisibility(0);
    L75:
        ECTabLayout r25 = j0();
        if (r25 == null) goto L114;
        String r26 = "ecTabKit.topTabItemDidShow_" + r6.n();
        if (r25.getVisibility() != 0) goto L81;
        boolean r27 = true;
    L82:
        if (r27 == false) goto L114;
        TabKitViewModel r28 = k0();
        if (r28 == null) goto L88;
        HashMap<String, Boolean> r29 = r28.getRecordedEventsMap();
        if (r29 == null) goto L88;
        Boolean r30 = r29.get(r26);
    L90:
        if ((!Intrinsics.areEqual(r30, r23)) == false) goto L114;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r31 = r6.m();
        if (r31 == null) goto L109;
        Iterator<T> r32 = r31.iterator();
    L95:
        if (r32.hasNext() == false) goto L109;
        com.bytedance.android.shopping.store.tabkit.model.k r33 = (com.bytedance.android.shopping.store.tabkit.model.k) r32.next();
        TabKitViewModel r34 = k0();
        if (r34 == null) goto L101;
        com.bytedance.android.shopping.store.tabkit.bridge.c r35 = r34.getJsEventStub();
        if (r35 == null) goto L101;
        Intrinsics.checkNotNullParameter(r33, "tab");
        JSONObject r36 = new JSONObject();
        r36.put("tab_id", r33.n());
        r36.put("tab_item", r33.d);
        Unit r37 = Unit.INSTANCE;
        r35.a("ecTabKit.topTabItemDidShow", r36);
    L101:
        ShowTopTabEvent r38 = new ShowTopTabEvent();
        Map<String, String> r39 = r33.h();
        if (r39 == null) goto L104;
        r38.appendParam(r39);
    L104:
        BaseEventContext[] r40 = new BaseEventContext[1];
        TabKitViewModel r41 = k0();
        if (r41 == null) goto L107;
        TabKitEventContext r42 = r41.getEventContext();
    L108:
        r40[0] = r42;
        r38.with(r40).post(null, null);
        goto L95
    L107:
        r42 = null;
    L109:
        TabKitViewModel r43 = k0();
        if (r43 == null) goto L114;
        HashMap<String, Boolean> r44 = r43.getRecordedEventsMap();
        if (r44 == null) goto L114;
        r44.put(r26, Boolean.TRUE);
    L88:
        r30 = null;
        goto L90
    L81:
        r27 = false;
        goto L82
    L71:
        if (Intrinsics.areEqual(r22, r3) == false) goto L75;
        MixTabLayout r45 = this.h;
        if (r45 == null) goto L75;
        r45.setVisibility(8);
    L64:
        r22 = null;
        goto L65
    L59:
        if (r21.intValue() != 1) goto L62;
        if (r18 == null) goto L64;
        r22 = r18.a;
    L54:
        r21 = null;
    L48:
        r18 = null;
    L33:
        r12 = null;
    L28:
        r11 = null;
    L114:
        TabKitViewModel r46 = k0();
        if (r46 == null) goto L128;
        ArrayList<com.bytedance.android.shopping.store.tabkit.g> r47 = r46.getTabKitLifeListeners();
        if (r47 == null) goto L129;
        Iterator<T> r48 = r47.iterator();
    L120:
        if (r48.hasNext() == false) goto L131;
        ((com.bytedance.android.shopping.store.tabkit.g) r48.next()).f(r9);
        goto L120
    L131:
        return;
    L129:
        return;
    L128:
        return;
    L130:
        return;
    L127:
        return;
    L122:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public TabKitPresenter(com.bytedance.android.shopping.store.tabkit.f r2) {
        Intrinsics.checkNotNullParameter(r2, "tabKitFragment");
        super((Fragment) r2);
        this.D = r2;
        this.v = LazyKt.lazy(TabKitPresenter$btmSwitch$2.INSTANCE);
        this.w = LazyKt.lazy(TabKitPresenter$disablePageViewSwitch$2.INSTANCE);
        this.x = new a(this);
        this.y = new Handler();
        this.z = new c(this);
        this.B = new h(this);
        this.C = new LinkedList();
        com.bytedance.android.ec.sdk.helper.d.b.getIECContactService();
    }

    public static View d0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void C(com.bytedance.android.shopping.store.tabkit.model.i r11) {
        Intrinsics.checkNotNullParameter(r11, "popupDynamicConfig");
        TabKitViewModel r1 = k0();
        int r2 = 0;
        AttributeSet r3 = null;
        if (r1 == null) goto L5;
        String r4 = TabKitViewModel.buildBundleUrlWithRouterParams$default(r1, r11.a(), false, 2, null);
    L6:
        r11.d(r4);
        TabKitDialogView r5 = new TabKitDialogView(a0().getContext(), r3, 6, r2);
        com.bytedance.android.shopping.store.tabkit.f r6 = this.D;
        Intrinsics.checkNotNullParameter(r6, "tabKitFragment");
        Intrinsics.checkNotNullParameter(r11, "popupDynamicConfig");
        FrameLayout r7 = r6.Mc().u;
        if (r7 == null) goto L51;
        r5.b = r6;
        r5.c = r11;
        com.bytedance.android.shopping.extensions.f.a(r7, r5);
        Integer r8 = r11.c();
        if (r8 == null) goto L12;
        float r9 = r8.intValue();
    L13:
        ViewCompat.setZ(r5, r9);
        TabKitViewModel r10 = r6.getTabKitViewModel();
        if (r10 == null) goto L52;
        String r12 = r11.a();
        if (r12 == null) goto L53;
        com.bytedance.android.shopping.store.tabkit.bridge.c r13 = r10.getJsEventStub();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "popupDynamicConfig");
        r13.a("ecTabKit.popupDidShow", com.bytedance.android.ec.hybrid.list.util.k.b(r11));
        TabKitRouterParams r14 = r10.getRouterParams();
        if (r14 == null) goto L22;
        HashMap<String, String> r15 = r14.getParamsMap();
    L24:
        if ((r15 instanceof Map) == true) goto L26;
        r15 = null;
    L26:
        JSONObject r0 = new JSONObject(r15);
        HashMap r16 = new HashMap();
        r16.put("frame_data", GsonProtectorUtils.toJson(new Gson(), r10.getTabResponse().getValue()));
        r16.put("tab_data", GsonProtectorUtils.toJson(new Gson(), r10.getAnchorTab()));
        r16.put("router_params", r0);
        int r17 = (Integer) r10.getScreenState().getValue();
        if (r17 != null) goto L29;
        r17 = 0;
    L29:
        r16.put("screen_state", r17);
        r16.put("popup", com.bytedance.android.ec.hybrid.list.util.k.d(r11));
        HashMap r18 = new HashMap();
        r18.put("meta_info", r16);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod>> r20 = r10.getJsBridge().a.iterator();
    L31:
        if (r20.hasNext() == false) goto L33;
        TabKitBridge.TabKitBaseBridgeMethod r21 = (TabKitBridge.TabKitBaseBridgeMethod) r20.next().invoke(null);
        r19.put(r21.getName(), com.bytedance.android.shopping.store.tabkit.bridge.a.a(r21));
        goto L31
    L33:
        ECLynxCard r22 = r5.a;
        ECLynxLoadParam.a r23 = new ECLynxLoadParam.a(r5.getContext(), r12, r5);
        ViewGroup.LayoutParams r24 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r24, "ecLayoutParams");
        r23.u = r24;
        Intrinsics.checkNotNullParameter(r19, "ecBridgeMap");
        r23.r = r19;
        Intrinsics.checkNotNullParameter(r18, "appendData");
        r23.m = r18;
        Intrinsics.checkNotNullParameter(r18, "ecGlobalProps");
        r23.p = r18;
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        r23.o = r5;
        r22.j(new ECLynxLoadParam(r23));
        r10.getLynxCards().add(r5.a);
        String r110 = r11.b();
        if (r110 == null) goto L48;
        TabKitViewModel r25 = r6.getTabKitViewModel();
        if (r25 == null) goto L49;
        HashMap<String, ArrayList<TabKitDialogView>> r26 = r25.getDialogsMap();
        if (r26 != null) goto L41;
        return;
    L41:
        if (r26.get(r110) != null) goto L43;
        r26.put(r110, new ArrayList());
    L43:
        ArrayList<TabKitDialogView> r111 = r26.get(r110);
        if (r111 == null) goto L50;
        r111.add(r5);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L22:
        r15 = null;
        goto L24
    L53:
        return;
    L52:
        return;
    L12:
        r9 = 0.0f;
        goto L13
    L51:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void W(long r10) {
        if (this.A == false) goto L5;
        return;
    L5:
        TabKitViewModel r0 = k0();
        boolean r1 = false;
        if (r0 == null) goto L16;
        MutableLiveData<y> r2 = r0.getCurrentTab();
        if (r2 == null) goto L16;
        y r3 = (y) r2.getValue();
        if (r3 == null) goto L16;
        com.bytedance.android.shopping.store.tabkit.model.k r4 = r3.a;
        if (r4 == null) goto L16;
        Integer r5 = r4.n();
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
    L17:
        TabKitViewModel r7 = k0();
        if (r7 == null) goto L59;
        com.bytedance.android.shopping.store.tabkit.h r8 = r7.getInterceptorHelper();
        if (r8 == null) goto L59;
        if (r6 == 0) goto L25;
        com.bytedance.android.shopping.store.tabkit.h.a r9 = r8.b.get(r6);
        if (r9 == null) goto L25;
    L26:
        long r11 = 0;
        if (r9 != null) goto L30;
    L38:
        if (r1 != true) goto L59;
        TabKitViewModel r12 = k0();
        if (r12 == null) goto L44;
        com.bytedance.android.shopping.store.tabkit.bridge.c r13 = r12.getJsEventStub();
        if (r13 == null) goto L44;
        JSONObject r14 = new JSONObject();
        r14.put("tab_id", r6);
        r14.put("action", r10);
        Unit r15 = Unit.INSTANCE;
        r13.a("ecTabKit.closeActionDidIntercept", r14);
    L44:
        this.A = true;
        Handler r16 = this.y;
        c r17 = this.z;
        TabKitViewModel r18 = k0();
        if (r18 == null) goto L58;
        com.bytedance.android.shopping.store.tabkit.h r19 = r18.getInterceptorHelper();
        if (r19 == null) goto L58;
        if (r6 == 0) goto L52;
        com.bytedance.android.shopping.store.tabkit.h.a r20 = r19.b.get(r6);
        if (r20 == null) goto L52;
    L53:
        if (r20 == null) goto L55;
        Long r21 = Long.valueOf(r20.b);
    L56:
        if (r21 == null) goto L58;
        r11 = r21.longValue();
        goto L58
    L55:
        r21 = null;
    L52:
        r20 = r19.a;
    L58:
        r16.postDelayed(r17, r11);
        return;
    L30:
        if (r10 == (-1)) goto L38;
        if (r9.a == false) goto L38;
        long r22 = r9.c;
        if (r22 != 0) goto L36;
    L37:
        r1 = true;
        goto L38
    L36:
        if ((r22 & r10) != r10) goto L38;
    L25:
        r9 = r8.a;
    L59:
        this.D.finish();
        return;
    L16:
        r6 = 0;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(QModel r12) {
        ((QFragmentPresenter) this).e.getLifecycle().addObserver(this);
        Long r13 = k.a;
        k.a = Long.valueOf(System.currentTimeMillis());
        this.j = (RightItemView) a0().findViewById(2131371225);
        this.k = a0().findViewById(2131371224);
        this.l = (ECDraweeView) a0().findViewById(2131370500);
        View r14 = this.k;
        if (r14 == null) goto L5;
        r14.setOnClickListener(new g(this));
    L5:
        this.m = a0().findViewById(2131371220);
        this.h = (MixTabLayout) a0().findViewById(2131371226);
        this.i = (MixTabLayout) a0().findViewById(2131371214);
        this.r = a0().findViewById(2131371217);
        this.s = (ECDraweeView) a0().findViewById(2131371213);
        TabKitViewModel r15 = k0();
        if (r15 == null) goto L10;
        TabKitBridge r16 = r15.getJsBridge();
        if (r16 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "brandMallJsBridgeInterface");
        r16.d = this;
    L10:
        TabKitViewModel r17 = k0();
        View r0 = null;
        if (r17 == null) goto L15;
        TabKitRouterParams r18 = r17.getRouterParams();
        if (r18 == null) goto L15;
        Integer r19 = r18.getPageModal();
    L17:
        if (r19 != null) goto L20;
    L26:
        TabKitViewModel r110 = k0();
        if (r110 == null) goto L31;
        MutableLiveData<Float> r111 = r110.getScreenOffsetFactor();
        if (r111 == null) goto L31;
        r111.setValue(Float.valueOf(1.0f));
    L31:
        TabKitViewModel r112 = k0();
        if (r112 == null) goto L36;
        MutableLiveData<Integer> r113 = r112.getScreenState();
        if (r113 == null) goto L36;
        r113.setValue(0);
    L36:
        TabKitViewModel r114 = k0();
        if (r114 == null) goto L41;
        TabKitRouterParams r115 = r114.getRouterParams();
        if (r115 == null) goto L41;
        Integer r116 = r115.getDisableUpFullScreen();
    L42:
        if (r116 != null) goto L45;
    L47:
        TabKitViewModel r117 = k0();
        if (r117 == null) goto L52;
        TabKitRouterParams r118 = r117.getRouterParams();
        if (r118 == null) goto L52;
        Integer r119 = r118.getDisablePullDownClose();
    L53:
        if (r119 != null) goto L56;
    L58:
        TabKitViewModel r120 = k0();
        if (r120 == null) goto L64;
        MutableLiveData<Boolean> r121 = r120.getPageLandingFinished();
        if (r121 == null) goto L64;
        r121.setValue(Boolean.FALSE);
    L64:
        if (this.D.tv() == null) goto L76;
        Integer r122 = this.D.tv();
        if (r122 == null) goto L68;
        final ScrollableViewPager r123 = (ScrollableViewPager) a0().findViewById(r122.intValue());
    L69:
        this.f = r123;
        if (r123 == null) goto L86;
        r123.setOffscreenPageLimit(4);
        Fragment r4 = this.D;
        if (r4 == null) goto L75;
        r123.setAdapter(new TabKitFragmentPagerAdapter(r4.getChildFragmentManager()));
        r123.setScrollable(false);
        r123.addOnPageChangeListener(new TabKitPresenter$initViewPager$$inlined$apply$lambda$1(r123, this));
        goto L86
    L75:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    L86:
        TabKitViewModel r124 = k0();
        if (r124 == null) goto L91;
        TabKitRouterParams r125 = r124.getRouterParams();
        if (r125 == null) goto L91;
        String r126 = r125.getAnchorUrl();
    L93:
        if (r126 == null) goto L102;
        FrameLayout r127 = (FrameLayout) a0().findViewById(2131371221);
        if (r127 == null) goto L105;
        int r5 = com.bytedance.android.ec.store.utils.h.a;
        if (hk3.e.a() == 0) goto L99;
        boolean r6 = true;
    L100:
        if (r6 == true) goto L105;
        StatusView r7 = new StatusView(a0().getContext(), null, 6, 0);
        r7.setBackgroundColor(-1);
        r7.setVisibility(8);
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.shopping.extensions.f.a(r127, r7);
        goto L105
    L99:
        r6 = false;
    L105:
        TabKitViewModel r128 = k0();
        if (r128 == null) goto L110;
        MutableLiveData<Integer> r129 = r128.getScreenState();
        if (r129 == null) goto L110;
        r129.observe(Y().e(), new TabKitPresenter$initObserver$1(this));
    L110:
        TabKitViewModel r130 = k0();
        if (r130 == null) goto L115;
        MutableLiveData<Integer> r131 = r130.getLoadStatus();
        if (r131 == null) goto L115;
        r131.observe(Y().e(), new TabKitPresenter$initObserver$2(this));
    L115:
        TabKitViewModel r132 = k0();
        if (r132 == null) goto L120;
        MutableLiveData<z> r133 = r132.getTabResponse();
        if (r133 == null) goto L120;
        r133.observe(Y().e(), new TabKitPresenter$initObserver$3(this));
    L120:
        TabKitViewModel r134 = k0();
        if (r134 == null) goto L125;
        MutableLiveData<Float> r135 = r134.getScreenOffsetFactor();
        if (r135 == null) goto L125;
        r135.observe(Y().e(), new TabKitPresenter$initObserver$4(this));
    L125:
        TabKitViewModel r136 = k0();
        if (r136 == null) goto L130;
        MutableLiveData<Pair<Float, Float>> r137 = r136.getScreenOffset();
        if (r137 == null) goto L130;
        r137.observe(Y().e(), new TabKitPresenter$initObserver$5(this));
    L130:
        TabKitViewModel r138 = k0();
        if (r138 == null) goto L135;
        MutableLiveData<Integer> r139 = r138.getTabSwitchMode();
        if (r139 == null) goto L135;
        r139.observe(Y().e(), new TabKitPresenter$initObserver$6(this));
    L135:
        TabKitViewModel r140 = k0();
        if (r140 == null) goto L140;
        MutableLiveData<Pair<Integer, Integer>> r141 = r140.getFoldScreenSize();
        if (r141 == null) goto L140;
        r141.observe(Y().e(), new TabKitPresenter$initObserver$7(this));
    L140:
        TabKitViewModel r142 = k0();
        if (r142 == null) goto L145;
        TabKitRouterParams r143 = r142.getRouterParams();
        if (r143 == null) goto L145;
        String r144 = r143.getAnchorUrl();
    L147:
        if (com.bytedance.android.shopping.extensions.k.c(r144) == false) goto L233;
        TabKitViewModel r8 = k0();
        if (r8 == null) goto L155;
        TabKitRouterParams r9 = r8.getRouterParams();
        if (r9 == null) goto L155;
        Integer r10 = r9.getAnchorTabId();
        if (r10 == null) goto L155;
        int r11 = r10.intValue();
    L156:
        int r20 = t.a;
        TabKitViewModel r21 = k0();
        if (r21 == null) goto L159;
        TabKitAbilityConfig r22 = r21.getAbilityConfig();
    L160:
        boolean r23 = t.i(r144, r22);
        TabKitViewModel r24 = k0();
        if (r24 == null) goto L165;
        v r25 = r24.getTabState(Integer.valueOf(r11));
        if (r25 == null) goto L165;
        r25.f = r23;
    L165:
        com.bytedance.android.shopping.store.tabkit.model.k r26 = new com.bytedance.android.shopping.store.tabkit.model.k();
        r26.w(Integer.valueOf(r11));
        s r27 = new s();
        r27.f(r144);
        TabKitViewModel r145 = k0();
        if (r145 == null) goto L170;
        TabKitRouterParams r146 = r145.getRouterParams();
        if (r146 == null) goto L170;
        String r147 = r146.getAnchorUrlType();
    L172:
        if (TextUtils.equals(r147, "lynx") == false) goto L174;
        int r148 = 2;
    L175:
        r27.g(r148);
        if (r23 == false) goto L178;
        Integer r149 = 1;
    L184:
        r27.h(r149);
        Unit r150 = Unit.INSTANCE;
        r26.t(r27);
        r26.e = true;
        Bundle r151 = ((QFragmentPresenter) this).e.getArguments();
        if (r151 == null) goto L187;
        r151.getString("pre_create_anniex_uid");
    L187:
        TabKitViewModel r152 = k0();
        if (r152 == null) goto L190;
        r152.notifyLandingStart();
    L190:
        TabKitViewModel r153 = k0();
        if (r153 == null) goto L202;
        TabKitRouterParams r154 = r153.getRouterParams();
        if (r154 == null) goto L202;
        if (r154.getSingleTabMode() != true) goto L202;
        TabKitViewModel r155 = k0();
        if (r155 == null) goto L199;
        r155.notifyLandingFinished();
    L199:
        TabKitViewModel r156 = k0();
        if (r156 == null) goto L202;
        r156.notifyPageLandingFinished();
    L202:
        TabKitViewModel r157 = k0();
        if (r157 == null) goto L233;
        int r28 = z.b;
        TabKitViewModel r29 = k0();
        Intrinsics.checkNotNullParameter(r26, "tab");
        z r30 = new z();
        if (r29 == null) goto L209;
        TabKitRouterParams r31 = r29.getRouterParams();
        if (r31 == null) goto L209;
        Integer r32 = r31.getAnchorTabId();
    L210:
        r30.m(r32);
        q r33 = new q();
        com.bytedance.android.shopping.store.tabkit.model.p r34 = new com.bytedance.android.shopping.store.tabkit.model.p();
        r34.l(2);
        r33.m(r34);
        r30.n(r33);
        ArrayList r35 = new ArrayList();
        r35.add(r26);
        r30.p(r35);
        if (r29 == null) goto L219;
        TabKitRouterParams r36 = r29.getRouterParams();
        if (r36 == null) goto L219;
        if (r36.getShowBackIcon() != true) goto L219;
        if (r29.getRouterParams().getSingleTabMode() == false) goto L219;
        com.bytedance.android.shopping.store.tabkit.model.e r37 = new com.bytedance.android.shopping.store.tabkit.model.e();
        r37.d(Boolean.FALSE);
        r30.o(r37);
    L219:
        if (r29 == null) goto L223;
        TabKitRouterParams r38 = r29.getRouterParams();
        if (r38 == null) goto L223;
        String r39 = r38.getTitle();
    L225:
        if (com.bytedance.android.shopping.extensions.k.c(r39) == false) goto L232;
        if (r29 == null) goto L232;
        TabKitRouterParams r40 = r29.getRouterParams();
        if (r40 == null) goto L232;
        if (r40.getSingleTabMode() != true) goto L232;
        q r41 = new q();
        r41.l(1);
        r30.q(r41);
    L232:
        r157.setTabKitData(r30);
    L223:
        r39 = null;
    L209:
        r32 = null;
        goto L210
    L178:
        TabKitViewModel r158 = k0();
        if (r158 == null) goto L183;
        TabKitRouterParams r159 = r158.getRouterParams();
        if (r159 == null) goto L183;
        r149 = r159.getAnchorHybridContainer();
    L183:
        r149 = null;
        goto L184
    L174:
        r148 = 3;
    L170:
        r147 = null;
        goto L172
    L159:
        r22 = null;
    L155:
        r11 = 0;
    L233:
        TabKitViewModel r160 = k0();
        if (r160 == null) goto L240;
        TabKitRouterParams r161 = r160.getRouterParams();
        if (r161 == null) goto L240;
        Integer r162 = r161.getHeightMode();
        if (r162 == null) goto L240;
        k(r162.intValue());
    L240:
        com.bytedance.android.shopping.store.tabkit.f r163 = this.D;
        if ((r163 instanceof TabKitFragment) == true) goto L243;
        r163 = null;
    L243:
        TabKitFragment r164 = (TabKitFragment) r163;
        if (r164 == null) goto L294;
        Window r165 = r164.e;
        if (r165 == null) goto L294;
        View r166 = d0(r165);
        if (r166 == null) goto L294;
        this.p = r166.findViewById(2131389274);
        this.o = r166.findViewById(2131388066);
        TabKitViewModel r167 = k0();
        if (r167 == null) goto L253;
        TabKitRouterParams r168 = r167.getRouterParams();
    L254:
        if (r168 != null) goto L256;
    L257:
        View r42 = this.p;
        if (r42 == null) goto L265;
        if (r168 == null) goto L263;
        Double r43 = r168.getMaskAlpha();
        if (r43 == null) goto L263;
        float r44 = (float) r43.doubleValue();
    L264:
        r42.setAlpha(r44);
    L263:
        r44 = 0.0f;
    L265:
        if (r168 == null) goto L267;
        Integer r45 = r168.getSplitIndicatorHidden();
    L268:
        if (r45 != null) goto L271;
    L272:
        if (r168 == null) goto L274;
        Integer r46 = r168.getPageModal();
    L275:
        if (r46 != null) goto L278;
    L282:
        ECDraweeView r47 = this.l;
        if (r47 == null) goto L294;
        if (r168 == null) goto L286;
        Integer r169 = r168.getPageModal();
    L287:
        if (r169 != null) goto L290;
    L292:
        int r170 = 2131234790;
    L293:
        com.bytedance.android.shopping.store.tabkit.e.f(r47, r170);
        goto L294
    L290:
        if (r169.intValue() != 1) goto L292;
        r170 = 2131248082;
        goto L293
    L286:
        r169 = null;
        goto L287
    L278:
        if (r46.intValue() != 1) goto L282;
        View r48 = this.o;
        if (r48 == null) goto L282;
        r48.setVisibility(0);
        goto L282
    L274:
        r46 = null;
        goto L275
    L271:
        if (r45.intValue() == 1) goto L282;
    L267:
        r45 = null;
        goto L268
    L256:
        if (r168.get_maskAlphaOpt() == true) goto L265;
    L253:
        r168 = null;
    L294:
        TabKitViewModel r171 = k0();
        if (r171 == null) goto L335;
        TabKitRouterParams r172 = r171.getRouterParams();
        if (r172 == null) goto L335;
        if (r172.getEnableDebugTool() != true) goto L335;
        FloatDebugLynxView r173 = new FloatDebugLynxView(Y().c(), null);
        r173.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TabKitViewModel r49 = k0();
        if (r49 == null) goto L329;
        Lazy r50 = ECSettingKeys.a;
        int r51 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r52 = "aweme://lynxview/?surl=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2F10180%2Fgecko%2Fresource%2Fecommerce_tabkit_aweme%2Fcontrol_panel%2Ftemplate.js";
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L308
        jj4.b r54 = jj4.b.b;     // Catch: Throwable -> L308
        Object r55 = jj4.a.a("tabkit_debug_tool_bundle_url", String.class, "aweme://lynxview/?surl=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2F10180%2Fgecko%2Fresource%2Fecommerce_tabkit_aweme%2Fcontrol_panel%2Ftemplate.js", false);     // Catch: Throwable -> L308
        if (r55 != null) goto L314;
        Intrinsics.throwNpe();     // Catch: Throwable -> L308
    L314:
        String r2 = TabKitViewModel.buildBundleUrlWithRouterParams$default(r49, (String) r55, false, 2, null);
        if (r2 == null) goto L329;
        TabKitRouterParams r56 = r49.getRouterParams();
        if (r56 == null) goto L320;
        HashMap<String, String> r57 = r56.getParamsMap();
    L322:
        if ((r57 instanceof Map) == true) goto L324;
        r57 = null;
    L324:
        JSONObject r58 = new JSONObject(r57);
        int r59 = !r49.isAnchorFinished() ? 1 : 0;
        HashMap r60 = new HashMap();
        r60.put("frame_data", GsonProtectorUtils.toJson(new Gson(), r49.getTabResponse().getValue()));
        r60.put("router_params", r58);
        r60.put("screen_state", String.valueOf(r49.getScreenState().getValue()));
        r60.put("monitor_enter_type", Integer.valueOf(1 ^ r59));
        r60.put("bottom_tab_data", GsonProtectorUtils.toJson(new Gson(), r49.getAnchorHomeTab()));
        r60.put("tab_data", GsonProtectorUtils.toJson(new Gson(), r49.getAnchorTab()));
        HashMap r1 = new HashMap();
        r1.put("meta_info", r60);
        LinkedHashMap r61 = new LinkedHashMap();
        Iterator<Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod>> r62 = r49.getJsBridge().a.iterator();
    L326:
        if (r62.hasNext() == false) goto L328;
        TabKitBridge.TabKitBaseBridgeMethod r63 = (TabKitBridge.TabKitBaseBridgeMethod) r62.next().invoke(null);
        r61.put(r63.getName(), com.bytedance.android.shopping.store.tabkit.bridge.a.a(r63));
        goto L326
    L328:
        String r64 = String.valueOf(r173.hashCode());
        ECLynxCard r65 = r173.a;
        ECLynxLoadParam.a r66 = new ECLynxLoadParam.a(r173.getContext(), r2, r173);
        Intrinsics.checkNotNullParameter(r1, "appendData");
        r66.m = r1;
        Intrinsics.checkNotNullParameter(r61, "ecBridgeMap");
        r66.r = r61;
        Intrinsics.checkNotNullParameter(r1, "ecGlobalProps");
        r66.p = r1;
        ViewGroup.LayoutParams r67 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r67, "ecLayoutParams");
        r66.u = r67;
        Intrinsics.checkNotNullParameter(r173, "lifecycle");
        r66.o = r173;
        ArrayList r68 = new ArrayList();
        r68.add(new rk3.a());
        Unit r69 = Unit.INSTANCE;
        r66.a(r68);
        r66.h(r64);
        r65.j(new ECLynxLoadParam(r66));
        r49.getLynxCards().add(r173.a);
        goto L329
    L320:
        r57 = null;
    L308:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        Object r71 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r71) == true) goto L313;
        r52 = r71;
    L313:
        r55 = r52;
    L329:
        Unit r72 = Unit.INSTANCE;
        this.q = r173;
        View r174 = a0();
        if ((r174 instanceof FrameLayout) == true) goto L332;
        r174 = null;
    L332:
        FrameLayout r175 = (FrameLayout) r174;
        if (r175 == null) goto L335;
        r175.addView(this.q);
    L335:
        FrameLayout r176 = new FrameLayout(a0().getContext());
        View r73 = a0();
        if ((r73 instanceof FrameLayout) == false) goto L339;
        r0 = r73;
    L339:
        FrameLayout r74 = (FrameLayout) r0;
        if (r74 == null) goto L342;
        com.bytedance.android.shopping.extensions.f.a(r74, r176);
    L342:
        Unit r75 = Unit.INSTANCE;
        this.u = r176;
        return;
    L145:
        r144 = null;
        goto L147
    L102:
        FrameLayout r177 = (FrameLayout) a0().findViewById(2131371221);
        if (r177 == null) goto L105;
        StatusView r76 = new StatusView(a0().getContext(), null, 6, 0);
        r76.setBackgroundColor(-1);
        com.bytedance.android.shopping.extensions.f.a(r177, r76);
        View r178 = th.a.c(Y().c(), 2131564809, r76, false);
        FrameLayout.LayoutParams r77 = new FrameLayout.LayoutParams(-2, -2);
        r77.gravity = 17;
        Unit r78 = Unit.INSTANCE;
        r178.setLayoutParams(r77);
        r76.b(null, r178, true);
        r76.showLoading();
        this.n = r76;
    L91:
        r126 = null;
        goto L93
    L68:
        r123 = null;
        goto L69
    L76:
        TabKitMainContainerView r179 = (TabKitMainContainerView) a0().findViewById(2131371219);
        this.t = r179;
        if (r179 == null) goto L83;
        com.bytedance.android.shopping.store.tabkit.f r79 = this.D;
        if (r79 == null) goto L82;
        TabKitFragment r80 = (TabKitFragment) r79;
        Intrinsics.checkNotNullParameter(r80, "fragment");
        r179.b = r80;
        goto L83
    L82:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.TabKitFragment");
    L83:
        TabKitMainContainerView r180 = this.t;
        if (r180 == null) goto L86;
        r180.setOnPageChangeListener(this);
        goto L86
    L56:
        if (r119.intValue() != 1) goto L58;
        this.D.Ju();
    L52:
        r119 = null;
        goto L53
    L45:
        if (r116.intValue() != 1) goto L47;
        this.D.jC();
    L41:
        r116 = null;
        goto L42
    L20:
        if (r19.intValue() != 1) goto L26;
        TabKitViewModel r181 = k0();
        if (r181 == null) goto L36;
        MutableLiveData<Integer> r182 = r181.getScreenState();
        if (r182 == null) goto L36;
        r182.setValue(1);
    L15:
        r19 = null;
        goto L17
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final com.bytedance.android.shopping.store.tabkit.bridge.Result f0(int r2) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = r0.getTabById(Integer.valueOf(r2));
    L6:
        if (r3 == null) goto L8;
        p0(r3, CommentConstants$CmtLongPanelStrategy.DEFAULT);
    L8:
        if (r3 == null) goto L10;
        com.bytedance.android.shopping.store.tabkit.bridge.Result r4 = new com.bytedance.android.shopping.store.tabkit.bridge.Result();
        r4.setSuccess(true);
        return r4;
    L10:
        com.bytedance.android.shopping.store.tabkit.bridge.Result r5 = new com.bytedance.android.shopping.store.tabkit.bridge.Result();
        r5.setSuccess(false);
        r5.setErrorMsg(com.bytedance.android.shopping.store.tabkit.bridge.Result.ERROR_MSG_TARGET_NOT_FOUND);
        return r5;
    L5:
        r3 = null;
        goto L6
    }

    public final Map<String, String> i0(com.bytedance.android.shopping.store.tabkit.model.k r6) {
        Object r0 = null;
        if (r6 == null) goto L7;
        Map<String, String> r7 = r6.h();
        if (r7 == null) goto L7;
        String r8 = r7.get("btm");
    L36:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        TabKitViewModel r2 = this.D.getTabKitViewModel();     // Catch: Throwable -> L26
        if (r2 == null) goto L23;
        TabKitTabFragment r3 = r2.getCurrentSelectedFragment();     // Catch: Throwable -> L26
        if (r3 == null) goto L23;
        PageFinder r4 = PageFinder.via(r3);     // Catch: Throwable -> L26
        BtmSDK r5 = BtmSDK.INSTANCE;     // Catch: Throwable -> L26
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        Map r9 = r5.createReportParams(r8, r4);     // Catch: Throwable -> L26
        ArrayList r10 = new ArrayList(r9.size());     // Catch: Throwable -> L26
        Iterator r11 = r9.entrySet().iterator();     // Catch: Throwable -> L26
    L17:
        if (r11.hasNext() == false) goto L22;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L26
        Object r13 = r12.getKey();     // Catch: Throwable -> L26
        Object r14 = r12.getValue();     // Catch: Throwable -> L26
        if ((r14 instanceof String) == true) goto L21;
        r14 = null;
    L21:
        r10.add(TuplesKt.to(r13, (String) r14));     // Catch: Throwable -> L26
        goto L17
    L22:
        Map r15 = MapsKt.toMap(r10);     // Catch: Throwable -> L26
    L24:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r16) == true) goto L32;
        r0 = r16;
    L32:
        Map<String, String> r17 = (Map) r0;
        if (r17 == null) goto L35;
        return r17;
    L35:
        return MapsKt.emptyMap();
    L23:
        r15 = null;
    L26:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r8 = null;
        goto L36
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void j(z r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L5;
        r0.notifyLandingFinished();
    L5:
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L8;
        r1.notifyPageLandingFinished();
    L8:
        TabKitViewModel r3 = k0();
        if (r3 == null) goto L12;
        r3.setTabKitData(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void k(int r12) {
        ConstraintLayout r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        MixTabLayout r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        TabKitMainContainerView r2 = this.t;
        if (r2 == null) goto L12;
        int r3 = r2.getId();
    L11:
        Integer r4 = Integer.valueOf(r3);
    L16:
        if (r4 == null) goto L32;
        int r5 = r4.intValue();
        MixTabLayout r6 = this.i;
        if (r6 != null) goto L20;
        return;
    L20:
        Intrinsics.checkNotNullParameter(r0, "constraintLayout");
        Intrinsics.checkNotNullParameter(r1, "topView");
        Intrinsics.checkNotNullParameter(r6, "bottomView");
        ConstraintSet r7 = new ConstraintSet();
        int r8 = r1.getId();
        r7.connect(r8, 1, 0, 1);
        r7.connect(r8, 2, 0, 2);
        r7.connect(r8, 3, 0, 3);
        r7.setVisibility(r8, r1.getVisibility());
        r7.constrainHeight(r8, -2);
        int r10 = r6.getId();
        r7.connect(r10, 1, 0, 1);
        r7.connect(r10, 2, 0, 2);
        r7.constrainHeight(r10, -2);
        r7.connect(r10, 4, 0, 4);
        r7.setVisibility(r10, r6.getVisibility());
        if (r12 == 0) goto L29;
        if (r12 == 1) goto L28;
        if (r12 == 2) goto L27;
        if (r12 != 3) goto L30;
        r7.connect(r5, 1, 0, 1);
        r7.connect(r5, 2, 0, 2);
        r7.connect(r5, 3, r8, 4);
        r7.connect(r5, 4, r10, 3);
    L30:
        r7.applyTo(r0);
        return;
    L27:
        r7.connect(r5, 1, 0, 1);
        r7.connect(r5, 2, 0, 2);
        r7.connect(r5, 3, r8, 4);
        r7.connect(r5, 4, 0, 4);
        goto L30
    L28:
        r7.connect(r5, 1, 0, 1);
        r7.connect(r5, 2, 0, 2);
        r7.connect(r5, 3, 0, 3);
        r7.connect(r5, 4, r10, 3);
        goto L30
    L29:
        r7.connect(r5, 1, 0, 1);
        r7.connect(r5, 2, 0, 2);
        r7.connect(r5, 3, 0, 3);
        r7.connect(r5, 4, 0, 4);
        goto L30
    L32:
        return;
    L12:
        ViewPager r9 = this.f;
        if (r9 == null) goto L15;
        r3 = r9.getId();
        goto L11
    L15:
        r4 = null;
        goto L16
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void l(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L11;
        final com.bytedance.android.shopping.store.tabkit.i r2 = r1.getKvStorage();
        if (r2 == null) goto L12;
        LifecycleOwner r3 = Y().e();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        MutableLiveData<Object> r0 = r2.a.get(r6);
        if (r0 != null) goto L9;
        r0 = new MutableLiveData();
        r2.a.put(r6, r0);
    L9:
        final Object r4 = r0.getValue();
        r0.observe(r3, new KVStorage$observeValue$1(r2, r6, r4));
        return;
    L12:
        return;
    }

    public final void l0(z r12) {
        Intrinsics.checkNotNullParameter(r12, "tabResponse");
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L9;
        ITabKitComponentFactory r1 = r0.getTabKitComponentFactory();
        if (r1 == null) goto L9;
        if (r1.getDisableBottomBar() != true) goto L9;
        return;
    L9:
        MixTabLayout r2 = this.i;
        if (r2 == null) goto L12;
        r2.setVisibility(0);
    L12:
        TabKitViewModel r3 = k0();
        if (r3 == null) goto L17;
        MutableLiveData<Boolean> r4 = r3.isUseNativeBottomBar();
        if (r4 == null) goto L17;
        Boolean r5 = (Boolean) r4.getValue();
    L19:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L144;
        MixTabLayout r6 = this.i;
        if (r6 == null) goto L143;
        ECTabLayout r7 = r6.getNativeTabLayout();
        if (r7 == null) goto L180;
        MixTabLayout r8 = this.i;
        if (r8 == null) goto L30;
        ExtensionsKt.visible(r8);
        ExtensionsKt.visible(r8.a);
        HybridTabLayout r9 = r8.b;
        if (r9 == null) goto L30;
        ExtensionsKt.gone(r9);
    L30:
        MixTabLayout r10 = this.i;
        if (r10 == null) goto L33;
        r10.setDefaultStyle(false);
    L33:
        r7.removeAllTabs();
        r7.removeOnTabSelectedListener(this.x);
        r7.addOnTabSelectedListener(this.x);
        List<com.bytedance.android.shopping.store.tabkit.model.k> r11 = r12.j();
        if (r11 == null) goto L71;
        Iterator<T> r13 = r11.iterator();
        int r14 = 0;
    L37:
        if (r13.hasNext() == false) goto L71;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        com.bytedance.android.shopping.store.tabkit.model.k r17 = (com.bytedance.android.shopping.store.tabkit.model.k) r15;
        ECTabLayout.Tab r18 = r7.newTab();
        TabKitViewModel r19 = k0();
        if (r19 == null) goto L70;
        ITabKitComponentFactory r20 = r19.getTabKitComponentFactory();
        if (r20 == null) goto L178;
        BottomTabItemView r21 = r20.createBottomTabItemView(a0().getContext());
        if (r21 == null) goto L179;
        r21.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r21.setTab(r17);
        r21.setSelected(false);
        TabKitViewModel r22 = k0();
        if (r22 != null) goto L50;
    L52:
        boolean r23 = false;
    L53:
        r21.setFullScreenState(r23);
        r18.setCustomView(r21);
        ECTabLayout.TabView r24 = r18.view;
        if ((r24 instanceof ViewGroup) == true) goto L56;
        r24 = null;
    L56:
        if (r24 == null) goto L58;
        r24.setClipToPadding(false);
        r24.setClipChildren(false);
    L58:
        r7.addTab(r18, false);
        s r25 = r17.f();
        if (r25 == null) goto L61;
        String r26 = r25.e();
    L62:
        if (r26 == null) goto L64;
        r21.setOnClickListener(new d(r17, r26, this));
    L64:
        ECTabLayout.TabView r27 = r18.view;
        if ((r27 instanceof View) == true) goto L67;
        r27 = null;
    L67:
        if (r27 == null) goto L69;
        r27.setEnabled(!Intrinsics.areEqual(r17.r(), Boolean.TRUE));
    L69:
        r14 = r16;
        goto L37
    L61:
        r26 = null;
        goto L62
    L50:
        if (r22.isFullScreen() != true) goto L52;
        r23 = true;
        goto L53
    L179:
        return;
    L178:
        return;
    L70:
        return;
    L71:
        View r28 = r7.getChildAt(0);
        if ((r28 instanceof ViewGroup) == true) goto L74;
        r28 = null;
    L74:
        ViewGroup r29 = (ViewGroup) r28;
        if (r29 == null) goto L78;
        r29.setClipToPadding(false);
        r29.setClipChildren(false);
    L78:
        TabKitViewModel r30 = k0();
        if (r30 == null) goto L89;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r31 = r30.getCurrentHomeTab();
        if (r31 == null) goto L89;
        com.bytedance.android.shopping.store.tabkit.model.k r32 = (com.bytedance.android.shopping.store.tabkit.model.k) r31.getValue();
        if (r32 == null) goto L89;
        Pair<Integer, Integer> r33 = r32.b;
        if (r33 == null) goto L89;
        Integer r34 = (Integer) r33.getFirst();
        if (r34 == null) goto L89;
        r7.selectTab(r34.intValue());
    L89:
        q0();
        List<com.bytedance.android.shopping.store.tabkit.model.k> r110 = r12.j();
        if (r110 == null) goto L126;
        Iterator<T> r111 = r110.iterator();
        int r35 = 0;
    L93:
        if (r111.hasNext() == false) goto L126;
        Object r36 = r111.next();
        int r37 = r35 + 1;
        if (r35 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        com.bytedance.android.shopping.store.tabkit.model.k r38 = (com.bytedance.android.shopping.store.tabkit.model.k) r36;
        TabKitViewModel r39 = k0();
        if (r39 == null) goto L102;
        com.bytedance.android.shopping.store.tabkit.bridge.c r40 = r39.getJsEventStub();
        if (r40 == null) goto L102;
        r40.b(r38);
    L102:
        TabKitViewModel r41 = k0();
        if (r41 == null) goto L107;
        com.bytedance.android.shopping.store.tabkit.bridge.c r42 = r41.getJsEventStub();
        if (r42 == null) goto L107;
        Intrinsics.checkNotNullParameter(r38, "tab");
        JSONObject r43 = new JSONObject();
        r43.put("tab_id", r38.n());
        r43.put("tab_item", r38.d);
        Unit r44 = Unit.INSTANCE;
        r42.a("ecTabKit.bottomTabItemDidShow", r43);
    L107:
        com.bytedance.android.shopping.store.tabkit.model.c r45 = r38.a();
        if (r45 == null) goto L125;
        a0 r46 = r45.a();
        if (r46 == null) goto L125;
        List<b0> r47 = r46.c();
        if (r47 == null) goto L125;
        Iterator<T> r48 = r47.iterator();
    L115:
        if (r48.hasNext() == false) goto L125;
        ExtensionsKt$toBaseMetricEvent2$3 r49 = com.bytedance.android.shopping.store.tabkit.e.r((b0) r48.next(), r38);
        if (r49 == null) goto L115;
        BaseEventContext[] r50 = new BaseEventContext[1];
        TabKitViewModel r51 = k0();
        if (r51 == null) goto L121;
        TabKitEventContext r52 = r51.getEventContext();
    L122:
        r50[0] = r52;
        BaseMetricsEvent2 r53 = r49.with(r50);
        if (r53 == null) goto L115;
        r53.post(null, null);
        goto L115
    L121:
        r52 = null;
    L125:
        r35 = r37;
    L126:
        Iterator r112 = ((ArrayList) com.bytedance.android.shopping.store.tabkit.e.k(r7)).iterator();
    L128:
        if (r112.hasNext() == false) goto L181;
        ECTabLayout.Tab r54 = (ECTabLayout.Tab) r112.next();
        TabKitViewModel r55 = k0();
        if (r55 == null) goto L128;
        ArrayList<com.bytedance.android.shopping.store.tabkit.g> r56 = r55.getTabKitLifeListeners();
        if (r56 == null) goto L128;
        Iterator<T> r57 = r56.iterator();
    L135:
        if (r57.hasNext() == false) goto L128;
        com.bytedance.android.shopping.store.tabkit.g r58 = (com.bytedance.android.shopping.store.tabkit.g) r57.next();
        View r59 = r54.getCustomView();
        if (r59 == null) goto L142;
        com.bytedance.android.shopping.store.tabkit.model.k r60 = ((BaseTabItemView) r59).getTab();
        if (r60 == null) goto L135;
        r54.isSelected();
        r58.k(r60);
        goto L135
    L142:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView");
    L181:
        return;
    L180:
        return;
    L143:
        return;
    L144:
        m r113 = r12.c();
        if (r113 != null) goto L147;
        return;
    L147:
        m0(r113, this.i, false);
        return;
    L17:
        r5 = null;
        goto L19
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void n(String r2) {
        TabKitViewModel r0 = this.D.getTabKitViewModel();
        if (r0 == null) goto L12;
        HashMap<String, ArrayList<TabKitDialogView>> r1 = r0.getDialogsMap();
        if (r1 == null) goto L14;
        ArrayList<TabKitDialogView> r3 = r1.get(r2);
        if (r3 == null) goto L15;
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        ((TabKitDialogView) r4.next()).a();
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void n0(z r6) {
        ECTabLayout r0 = j0();
        if (r0 != null) goto L5;
        return;
    L5:
        TabKitViewModel r1 = k0();
        com.bytedance.android.shopping.store.tabkit.model.g r2 = null;
        if (r1 == null) goto L10;
        MutableLiveData<Boolean> r3 = r1.isUseNativeTopBar();
        if (r3 == null) goto L10;
        Boolean r4 = (Boolean) r3.getValue();
    L12:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L22;
        r0.setTabMode(0);
        MixTabLayout r5 = this.h;
        if (r5 == null) goto L21;
        ExtensionsKt.visible(r5);
        ExtensionsKt.visible(r5.a);
        HybridTabLayout r7 = r5.b;
        if (r7 == null) goto L18;
        ExtensionsKt.gone(r7);
    L18:
        MixTabLayout r8 = this.h;
        if (r8 == null) goto L21;
        r8.setDefaultStyle(true);
    L21:
        r0.addOnAttachStateChangeListener(new f(this));
        r0.addOnTabSelectedListener(this.B);
    L26:
        com.bytedance.android.shopping.store.tabkit.model.e r9 = r6.f();
        if (r9 == null) goto L29;
        r2 = r9.b();
    L29:
        com.bytedance.android.shopping.store.tabkit.e.s(r2, this.l);
        return;
    L22:
        m r10 = r6.k();
        if (r10 != null) goto L25;
        return;
    L25:
        m0(r10, this.h, true);
    L10:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final Object p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L12;
        com.bytedance.android.shopping.store.tabkit.i r2 = r1.getKvStorage();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "key");
        MutableLiveData<Object> r4 = r2.a.get(r3);
        if (r4 == null) goto L14;
        Object r5 = r4.getValue();
        if (r5 == null) goto L14;
        return r5;
    L14:
        return new Object();
    L12:
        return new Object();
    }

    public final void r0(com.bytedance.android.shopping.store.tabkit.model.e r9) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.isUseNativeTopBar();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L86;
        s0();
        ECDraweeView r3 = this.l;
        if (r3 == null) goto L26;
        if (r9 == null) goto L15;
        com.bytedance.android.shopping.store.tabkit.model.g r4 = r9.b();
        if (r4 == null) goto L15;
    L25:
        com.bytedance.android.shopping.store.tabkit.e.d(r4, r3);
        com.bytedance.android.shopping.store.tabkit.e.s(r4, r3);
    L15:
        TabKitViewModel r5 = k0();
        if (r5 == null) goto L24;
        MutableLiveData<z> r6 = r5.getTabResponse();
        if (r6 == null) goto L24;
        z r7 = (z) r6.getValue();
        if (r7 == null) goto L24;
        com.bytedance.android.shopping.store.tabkit.model.e r8 = r7.f();
        if (r8 == null) goto L24;
        r4 = r8.b();
    L24:
        r4 = null;
    L26:
        RightItemView r10 = this.j;
        if (r10 == null) goto L35;
        if (r9 == null) goto L30;
        List<com.bytedance.android.shopping.store.tabkit.model.f> r11 = r9.c();
    L31:
        if (r9 == null) goto L33;
        com.bytedance.android.shopping.store.tabkit.model.g r12 = r9.b();
    L34:
        r10.a(r11, r12);
        goto L35
    L33:
        r12 = null;
        goto L34
    L30:
        r11 = null;
    L35:
        RightItemView r13 = this.j;
        if (r13 == null) goto L38;
        r13.setOnItemClickListener(new i(this));
    L38:
        TabKitViewModel r14 = k0();
        if (r14 == null) goto L45;
        MutableLiveData<y> r15 = r14.getCurrentTab();
        if (r15 == null) goto L45;
        y r16 = (y) r15.getValue();
        if (r16 == null) goto L45;
        com.bytedance.android.shopping.store.tabkit.model.k r17 = r16.a;
    L46:
        if (r9 == null) goto L86;
        List<com.bytedance.android.shopping.store.tabkit.model.f> r18 = r9.c();
        if (r18 == null) goto L86;
        Iterator<T> r19 = r18.iterator();
    L51:
        if (r19.hasNext() == false) goto L86;
        com.bytedance.android.shopping.store.tabkit.model.f r20 = (com.bytedance.android.shopping.store.tabkit.model.f) r19.next();
        String r21 = "nav_item_" + r20.d();
        TabKitViewModel r22 = k0();
        if (r22 == null) goto L57;
        HashMap<String, Boolean> r23 = r22.getRecordedEventsMap();
        if (r23 == null) goto L57;
        Boolean r24 = r23.get(r21);
    L59:
        if ((!Intrinsics.areEqual(r24, Boolean.TRUE)) == false) goto L51;
        TabKitViewModel r25 = k0();
        if (r25 == null) goto L65;
        com.bytedance.android.shopping.store.tabkit.bridge.c r26 = r25.getJsEventStub();
        if (r26 == null) goto L65;
        Intrinsics.checkNotNullParameter(r20, "navItem");
        JSONObject r27 = new JSONObject();
        r27.put("item_name", r20.d());
        r27.put("nav_item", r20.a);
        Unit r28 = Unit.INSTANCE;
        r26.a("ecTabKit.navItemDidShow", r27);
    L65:
        com.bytedance.android.shopping.store.tabkit.model.c r29 = r20.a();
        if (r29 == null) goto L68;
        a0 r30 = r29.a();
    L69:
        com.bytedance.android.shopping.store.tabkit.model.c r31 = r20.a();
        if (r31 == null) goto L81;
        a0 r32 = r31.a();
        if (r32 == null) goto L81;
        List<b0> r33 = r32.c();
        if (r33 == null) goto L81;
        Iterator<T> r34 = r33.iterator();
    L77:
        if (r34.hasNext() == false) goto L81;
        ExtensionsKt$toBaseMetricEvent2$1 r35 = com.bytedance.android.shopping.store.tabkit.e.q((b0) r34.next(), r17, r30);
        if (r35 == null) goto L77;
        r35.post(null, null);
    L81:
        TabKitViewModel r36 = k0();
        if (r36 == null) goto L51;
        HashMap<String, Boolean> r37 = r36.getRecordedEventsMap();
        if (r37 == null) goto L51;
        r37.put(r21, Boolean.TRUE);
        goto L51
    L68:
        r30 = null;
    L57:
        r24 = null;
    L45:
        r17 = null;
    L86:
        s0();
        return;
    L7:
        r2 = null;
        goto L9
    }

    public static final void e0(TabKitPresenter r4, ECTabLayout.Tab r5) {
        TabKitViewModel r0 = r4.k0();
        if (r0 == null) goto L9;
        ok3.a r1 = r0.getTabKitMonitor();
        if (r1 == null) goto L9;
        TabkitFirstFramePref r2 = r1.d;
        if (r2 == null) goto L9;
        TabkitFramePref.recordTime$default(r2, "t_tab_click_time", null, 2, null);
    L9:
        if (r5 == null) goto L36;
        TabKitViewModel r3 = r4.k0();
        if (r3 == null) goto L31;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r6 = r3.getHomeTabs();
        if (r6 == null) goto L32;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r6, r5.getPosition());
        if (r7 != null) goto L19;
        return;
    L19:
        if (r7.g() == false) goto L21;
        r7 = r7.d();
    L21:
        if (r7 == null) goto L38;
        Integer r8 = r7.n();
        if (r8 == null) goto L33;
        int r9 = r8.intValue();
        TabKitViewModel r10 = r4.k0();
        if (r10 == null) goto L34;
        ok3.a r11 = r10.getTabKitMonitor();
        if (r11 == null) goto L35;
        TabkitFramePref.recordTime$default(r11.c(r9), "t_tab_click_time", null, 2, null);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L38:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void G(JSONObject r2, ECBaseBridgeMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "iReturn");
        com.bytedance.android.shopping.store.tabkit.f r4 = this.D;
        if ((r4 instanceof Fragment) == true) goto L6;
        r4 = null;
    L6:
        if (((Fragment) r4) == null) goto L13;
        boolean r5 = true;
        if (r2.optInt("skipPermissionRequest") == 1) goto L11;
        r5 = false;
    L11:
        Logger.i("contacts_log", "call jsb ecChooseContact, skipPermissionRequest " + r5);
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.TabKitMainContainerView.a
    public final void d(ScrollableViewPager r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        if (r5.b == false) goto L34;
        TabKitViewModel r7 = k0();
        if (r7 == null) goto L9;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r8 = r7.getCurrentHomeTab();
        if (r8 == null) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r9 = (com.bytedance.android.shopping.store.tabkit.model.k) r8.getValue();
    L10:
        if (r9 == null) goto L14;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r10 = r9.m();
        if (r10 == null) goto L14;
        com.bytedance.android.shopping.store.tabkit.model.k r11 = (com.bytedance.android.shopping.store.tabkit.model.k) ListProtector.get(r10, r6);
    L15:
        if (r11 != null) goto L17;
        return;
    L17:
        dm.a.a("顶底tab切换").a("滑动选中的tab_id=" + r11.n() + ",对应的index=" + r6);
        p0(r11, "slide");
        EcomPageCrossSlideEvent r12 = new EcomPageCrossSlideEvent();
        Map<String, String> r13 = r11.h();
        if (r13 == null) goto L20;
        r12.appendParam(r13);
    L20:
        TabKitViewModel r14 = k0();
        if (r14 == null) goto L27;
        com.bytedance.android.shopping.store.tabkit.model.k r15 = r14.getLastTab();
        if (r15 == null) goto L27;
        Map<String, String> r16 = r15.h();
        if (r16 == null) goto L27;
        String r17 = r16.get("main_tab");
    L28:
        r12.appendParam("main_tab", r17);
        BaseEventContext[] r18 = new BaseEventContext[1];
        TabKitViewModel r1 = k0();
        if (r1 == null) goto L31;
        TabKitEventContext r2 = r1.getEventContext();
    L32:
        r18[0] = r2;
        r12.with(r18).post(null, null);
        return;
    L31:
        r2 = null;
    L27:
        r17 = null;
    L14:
        r11 = null;
    L9:
        r9 = null;
        goto L10
    }

    public final b0 h0(b0 r2, com.bytedance.android.shopping.store.tabkit.model.k r3) {
        if (((Boolean) this.v.getValue()).booleanValue() == true) goto L17;
        return r2;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(com.bytedance.android.shopping.store.tabkit.e.e(r2, i0(r3)));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r4) == false) goto L12;
        r4 = null;
    L12:
        b0 r5 = (b0) r4;
        if (r5 != null) goto L16;
        return r2;
    L16:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void p0(com.bytedance.android.shopping.store.tabkit.model.k r14, String r15) {
        Boolean r1 = null;
        if (r14.g() == false) goto L10;
        com.bytedance.android.shopping.store.tabkit.model.k r0 = r14.d();
        if (r0 != null) goto L11;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r2 = r14.m();
        if (r2 == null) goto L9;
        r0 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.first(r2);
        goto L11
    L9:
        r0 = null;
    L11:
        if (r0 != null) goto L13;
        return;
    L13:
        com.bytedance.android.shopping.store.tabkit.model.k r3 = r14.a;
        int r4 = 0;
        if (r3 != null) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        r3 = r14;
    L19:
        if (r3 != null) goto L21;
        return;
    L21:
        TabKitViewModel r6 = k0();
        if (r6 == null) goto L28;
        MutableLiveData<y> r7 = r6.getCurrentTab();
        if (r7 == null) goto L28;
        y r8 = (y) r7.getValue();
        if (r8 == null) goto L28;
        com.bytedance.android.shopping.store.tabkit.model.k r9 = r8.a;
    L30:
        if (Intrinsics.areEqual(r0, r9) == false) goto L33;
        dm.a.a("ECTabKitDebug").i("TabKitPresenter select same tab");
        return;
    L33:
        TabKitViewModel r10 = k0();
        if (r10 == null) goto L44;
        TabKitViewModel r11 = k0();
        if (r11 == null) goto L42;
        MutableLiveData<y> r12 = r11.getCurrentTab();
        if (r12 == null) goto L42;
        y r13 = (y) r12.getValue();
        if (r13 == null) goto L42;
        com.bytedance.android.shopping.store.tabkit.model.k r16 = r13.a;
    L43:
        r10.setLastTab(r16);
    L42:
        r16 = null;
    L44:
        TabKitViewModel r17 = k0();
        if (r17 == null) goto L49;
        MutableLiveData<y> r18 = r17.getCurrentTab();
        if (r18 == null) goto L49;
        r18.setValue(new y(r0, r15));
    L49:
        TabKitMainContainerView r19 = this.t;
        if (r19 == null) goto L52;
        r19.setCurrentTab(r0);
    L52:
        Pair<Integer, Integer> r20 = r0.b;
        r3.c = (Integer) r20.getSecond();
        TabKitViewModel r21 = k0();
        if (r21 == null) goto L57;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r22 = r21.getCurrentHomeTab();
        if (r22 == null) goto L57;
        com.bytedance.android.shopping.store.tabkit.model.k r23 = (com.bytedance.android.shopping.store.tabkit.model.k) r22.getValue();
    L58:
        boolean r24 = !Intrinsics.areEqual(r23, r3);
        if (r24 == false) goto L100;
        TabKitViewModel r25 = k0();
        if (r25 == null) goto L65;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r26 = r25.getCurrentHomeTab();
        if (r26 == null) goto L65;
        r26.setValue(r3);
    L65:
        ScrollableViewPager r27 = this.f;
        if (r27 == null) goto L68;
        PagerAdapter r28 = r27.getAdapter();
    L70:
        if ((r28 instanceof TabKitFragmentPagerAdapter) == true) goto L72;
        r28 = null;
    L72:
        TabKitFragmentPagerAdapter r29 = (TabKitFragmentPagerAdapter) r28;
        if (r29 == null) goto L100;
        TabKitViewModel r30 = k0();
        if (r30 == null) goto L100;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r31 = r30.getCurrentHomeTab();
        if (r31 == null) goto L100;
        com.bytedance.android.shopping.store.tabkit.model.k r32 = (com.bytedance.android.shopping.store.tabkit.model.k) r31.getValue();
        if (r32 == null) goto L100;
        LinkedList<TabKitTabFragment> r110 = r29.a;
        r110.clear();
        if (r32.g() == true) goto L89;
        TabKitViewModel r111 = k0();
        if (r111 == null) goto L99;
        TabKitTabFragment r33 = TabKitViewModel.getTabFragment$default(r111, r32, false, 2, null);
        if (r33 == null) goto L99;
        r110.add(r33);
    L99:
        r29.notifyDataSetChanged();
        goto L100
    L89:
        List<com.bytedance.android.shopping.store.tabkit.model.k> r34 = r32.m();
        if (r34 == null) goto L99;
        Iterator<T> r35 = r34.iterator();
    L93:
        if (r35.hasNext() == false) goto L99;
        com.bytedance.android.shopping.store.tabkit.model.k r112 = (com.bytedance.android.shopping.store.tabkit.model.k) r35.next();
        TabKitViewModel r113 = k0();
        if (r113 == null) goto L93;
        TabKitTabFragment r114 = TabKitViewModel.getTabFragment$default(r113, r112, false, 2, null);
        if (r114 == null) goto L93;
        r110.add(r114);
        goto L93
    L68:
        r28 = null;
    L100:
        Integer r36 = (Integer) r20.getSecond();
        if (r36 == null) goto L105;
        int r37 = r36.intValue();
        ScrollableViewPager r38 = this.f;
        if (r38 == null) goto L105;
        r38.setCurrentItem(r37, false);
    L105:
        if (r24 == false) goto L107;
        v0();
    L107:
        MixTabLayout r39 = this.i;
        if (r39 == null) goto L112;
        ECTabLayout r40 = r39.getNativeTabLayout();
        if (r40 == null) goto L112;
        r40.selectTab(((Number) r20.getFirst()).intValue());
    L112:
        q0();
        s r41 = r0.f();
        if (r41 == null) goto L115;
        String r42 = r41.b();
    L116:
        if (r42 != null) goto L118;
    L120:
        s0();
        r0(r0.i());
        if (r3.g() == false) goto L125;
        w0();
        ScrollableViewPager r43 = this.f;
        if (r43 == null) goto L125;
        r43.setScrollable(!com.bytedance.android.shopping.store.tabkit.e.m(r0));
    L125:
        TabKitViewModel r44 = k0();
        if (r44 == null) goto L128;
        com.bytedance.android.shopping.store.tabkit.model.k r45 = r44.getLastTab();
    L129:
        if (r45 != null) goto L133;
        TabKitViewModel r46 = k0();
        if (r46 == null) goto L140;
        r46.setLastTimeStamp(Long.valueOf(System.currentTimeMillis()));
    L140:
        s r47 = r14.f();
        if (r47 == null) goto L143;
        String r48 = r47.b();
    L144:
        int r49 = hk3.b.a;
        if (r48 == null) goto L157;
        String r50 = n.b(r48);
        if (r50 == null) goto L157;
        if ((!StringsKt.isBlank(r50)) == true) goto L152;
        r50 = null;
    L152:
        if (r50 == null) goto L157;
        if (hk3.b.g(hk3.b.h().e(), hk3.b.j().e(), r50) <= 0) goto L157;
        boolean r51 = true;
    L158:
        if (r51 == true) goto L169;
        TabKitViewModel r52 = k0();
        if (r52 == null) goto L168;
        TabKitRouterParams r53 = r52.getRouterParams();
        if (r53 == null) goto L168;
        if (r53.getSingleTabMode() != true) goto L168;
        if (((Boolean) this.w.getValue()).booleanValue() == true) goto L169;
    L168:
        boolean r54 = false;
    L170:
        if (r54 == true) goto L189;
        PageViewEvent r55 = new PageViewEvent();
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L174;
        r55.appendParam(i0(r0));
    L174:
        Map<String, String> r56 = r0.h();
        if (r56 == null) goto L177;
        r55.appendParam(r56);
    L177:
        r55.setEnterType(r15);
        TabKitViewModel r57 = k0();
        if (r57 == null) goto L183;
        Integer r58 = r57.getAnchorTabId();
        if (r58 == null) goto L183;
        String r59 = String.valueOf(r58.intValue());
        if (r59 == null) goto L183;
    L184:
        r55.setAnchorTabId(r59);
        BaseEventContext[] r60 = new BaseEventContext[1];
        TabKitViewModel r61 = k0();
        if (r61 == null) goto L187;
        TabKitEventContext r62 = r61.getEventContext();
    L188:
        r60[0] = r62;
        r55.with(r60).post(null, null);
        goto L189
    L187:
        r62 = null;
    L183:
        r59 = "-1";
    L189:
        TabKitViewModel r63 = k0();
        if (r63 == null) goto L194;
        com.bytedance.android.shopping.store.tabkit.bridge.c r64 = r63.getJsEventStub();
        if (r64 == null) goto L194;
        Intrinsics.checkNotNullParameter(r0, "tab");
        JSONObject r65 = new JSONObject();
        r65.put("tab_id", r0.n());
        r65.put("tab_item", r0.d);
        Unit r66 = Unit.INSTANCE;
        r64.a("ecTabKit.tabDidChange", r65);
    L194:
        com.bytedance.android.shopping.store.tabkit.model.j r115 = r14.k();
        if (r115 == null) goto L197;
        Integer r116 = r115.a();
    L198:
        if (r116 != null) goto L201;
    L203:
        int r117 = 2131247642;
    L204:
        View r67 = this.o;
        if (r67 == null) goto L207;
        r67.setBackgroundResource(r117);
    L207:
        TabKitViewModel r118 = k0();
        if (r118 == null) goto L212;
        MutableLiveData<Boolean> r119 = r118.isUseNativeTopBar();
        if (r119 == null) goto L212;
        Boolean r120 = (Boolean) r119.getValue();
    L213:
        Boolean r68 = Boolean.FALSE;
        if (Intrinsics.areEqual(r120, r68) == false) goto L220;
        MixTabLayout r121 = this.h;
        if (r121 == null) goto L220;
        HybridTabLayout r122 = r121.getHybridTabLayout();
        if (r122 == null) goto L220;
        r122.b(r3, r0);
    L220:
        TabKitViewModel r123 = k0();
        if (r123 == null) goto L226;
        MutableLiveData<Boolean> r124 = r123.isUseNativeBottomBar();
        if (r124 == null) goto L226;
        r1 = (Boolean) r124.getValue();
    L226:
        if (Intrinsics.areEqual(r1, r68) == false) goto L232;
        MixTabLayout r125 = this.i;
        if (r125 == null) goto L232;
        HybridTabLayout r126 = r125.getHybridTabLayout();
        if (r126 == null) goto L232;
        r126.b(r3, r0);
    L232:
        TabKitViewModel r127 = k0();
        if (r127 == null) goto L237;
        MutableLiveData<y> r128 = r127.getCurrentTabAfter();
        if (r128 == null) goto L237;
        r128.setValue(new y(r0, r15));
    L237:
        dm.a.b r129 = dm.a.a("红人店tab问题");
        StringBuilder r130 = new StringBuilder("顶tab:");
        r130.append(r0.n());
        r130.append(",viewModel:");
        TabKitViewModel r69 = k0();
        if (r69 == null) goto L240;
        r4 = r69.hashCode();
    L240:
        r130.append(r4);
        r129.a(r130.toString());
        return;
    L212:
        r120 = null;
        goto L213
    L201:
        if (r116.intValue() != 2) goto L203;
        r117 = 2131247641;
        goto L204
    L197:
        r116 = null;
    L169:
        r54 = true;
    L157:
        r51 = false;
        goto L158
    L143:
        r48 = null;
        goto L144
    L133:
        TabKitViewModel r70 = k0();
        if (r70 == null) goto L136;
        com.bytedance.android.shopping.store.tabkit.model.k r71 = r70.getLastTab();
    L138:
        if ((!Intrinsics.areEqual(r0, r71)) == false) goto L140;
        o0();
        goto L140
    L136:
        r71 = null;
        goto L138
    L128:
        r45 = null;
        goto L129
    L118:
        if (com.bytedance.android.shopping.extensions.k.c(r42) != true) goto L120;
        this.D.ay(!Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r42), "status_bar_color"), "white"));
        goto L120
    L115:
        r42 = null;
    L57:
        r23 = null;
    L28:
        r9 = null;
        goto L30
    L16:
        r5 = false;
        goto L17
    L10:
        r0 = r14;
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void q(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        TabKitViewModel r2 = k0();
        if (r2 == null) goto L11;
        com.bytedance.android.shopping.store.tabkit.i r3 = r2.getKvStorage();
        if (r3 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        MutableLiveData<Object> r0 = r3.a.get(r4);
        if (r0 != null) goto L9;
        r0 = new MutableLiveData();
        r3.a.put(r4, r0);
    L9:
        r0.setValue(r5);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void z5(int r3, boolean r4) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L7;
        TabKitRouterParams r1 = r0.getRouterParams();
        if (r1 == null) goto L7;
        Integer r2 = r1.getPageModal();
    L8:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.intValue() != 1) goto L14;
        this.D.z5(r3, r4);
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void N(int r6, String r7, JSONObject r8) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L61;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = r0.getTabById(Integer.valueOf(r6));
        if (r1 != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.shopping.extensions.k.c(r7) == false) goto L25;
        TabKitViewModel r9 = k0();
        String r2 = null;
        if (r9 == null) goto L12;
        Integer r10 = r9.getAnchorTabId();
    L13:
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        s r12 = r1.f();
        if (r12 == null) goto L62;
        TabKitViewModel r3 = k0();
        if (r3 == null) goto L24;
        r2 = r3.buildBundleUrlWithRouterParams(r7, r11);
    L24:
        r12.f(r2);
        return;
    L62:
        return;
    L16:
        if (r10.intValue() != r6) goto L18;
        r11 = true;
        goto L19
    L12:
        r10 = null;
        goto L13
    L25:
        s r13 = r1.f();
        if (r13 == null) goto L64;
        String r14 = r13.b();
        if (r14 == null) goto L67;
        Uri r15 = UriProtector.parse(r14);
        ArrayList r16 = new ArrayList(UriProtector.getQueryParameterNames(r15));
        if (r8 == null) goto L39;
        Iterator<String> r4 = r8.keys();
        if (r4 == null) goto L39;
    L35:
        if (r4.hasNext() == false) goto L39;
        String r5 = r4.next();
        if (r16.contains(r5) == false) goto L35;
        r16.remove(r5);
    L39:
        Uri.Builder r17 = r15.buildUpon();
        r17.clearQuery();
        if (r8 == null) goto L46;
        Iterator<String> r18 = r8.keys();
        if (r18 == null) goto L46;
    L44:
        if (r18.hasNext() == false) goto L46;
        String r19 = r18.next();
        r17.appendQueryParameter(r19, r8.optString(r19));
    L46:
        Iterator r20 = r16.iterator();
    L48:
        if (r20.hasNext() == false) goto L50;
        String r21 = (String) r20.next();
        r17.appendQueryParameter(r21, UriProtector.getQueryParameter(r15, r21));
        goto L48
    L50:
        s r22 = r1.f();
        if (r22 == null) goto L65;
        r22.f(r17.build().toString());
        return;
    L65:
        return;
    L67:
        return;
    L64:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.store.tabkit.view.TabKitMainContainerView.a
    public final void b(ScrollableViewPager r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L11;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.getCurrentHomeTab();
        if (r1 == null) goto L11;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = (com.bytedance.android.shopping.store.tabkit.model.k) r1.getValue();
        if (r2 == null) goto L11;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r6 = r2.m();
        if (r6 == null) goto L11;
        int r7 = r6.size();
    L12:
        int r8 = r3.getWidth();
        if (r7 <= 1) goto L34;
        int r9 = (r7 - 1) * r8;
        int r10 = (r4 * r8) + r5;
        MixTabLayout r11 = this.h;
        if (r11 == null) goto L21;
        HybridTabLayout r12 = r11.getHybridTabLayout();
        if (r12 == null) goto L21;
        ECTabKitView r13 = r12.getTabKitView();
        if (r13 == null) goto L21;
        r13.N(r10, r9);
    L21:
        MixTabLayout r14 = this.i;
        if (r14 == null) goto L28;
        HybridTabLayout r15 = r14.getHybridTabLayout();
        if (r15 == null) goto L28;
        ECTabKitView r16 = r15.getTabKitView();
        if (r16 == null) goto L28;
        r16.N(r10, r9);
    L28:
        FloatDebugLynxView r17 = this.q;
        if (r17 == null) goto L35;
        ECTabKitView r18 = r17.getTabKitView();
        if (r18 == null) goto L36;
        r18.N(r10, r9);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L11:
        r7 = 0;
        goto L12
    }

    public final void m0(m r10, MixTabLayout r11, boolean r12) {
        if (r11 == null) goto L5;
        HybridTabLayout r1 = r11.getHybridTabLayout();
    L6:
        if (r11 == null) goto L11;
        ExtensionsKt.visible(r11);
        HybridTabLayout r2 = r11.b;
        if (r2 == null) goto L10;
        ExtensionsKt.visible(r2);
    L10:
        ExtensionsKt.gone(r11.a);
    L11:
        TabKitViewModel r3 = k0();
        if (r3 == null) goto L64;
        if (r1 == null) goto L64;
        Intrinsics.checkNotNullParameter(r10, "tabBarDynamicConfig");
        Intrinsics.checkNotNullParameter(r3, "tabKitViewModel");
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        String r5 = r10.b();
        if (r5 == null) goto L19;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L19;
        int r7 = r6.intValue();
    L20:
        r4.height = r7;
        String r13 = r10.a();
        if (r13 == null) goto L64;
        TabKitRouterParams r8 = r3.getRouterParams();
        if (r8 == null) goto L26;
        HashMap<String, String> r9 = r8.getParamsMap();
    L28:
        if ((r9 instanceof Map) == true) goto L30;
        r9 = null;
    L30:
        JSONObject r14 = new JSONObject(r9);
        HashMap<String, Object> r15 = r1.c;
        r15.put("bottom_tab_data", GsonProtectorUtils.toJson(new Gson(), r3.getAnchorHomeTab()));
        r15.put("frame_data", GsonProtectorUtils.toJson(new Gson(), r3.getTabResponse().getValue()));
        r15.put("tab_data", GsonProtectorUtils.toJson(new Gson(), r3.getAnchorTab()));
        r15.put("router_params", r14);
        int r16 = (Integer) r3.getScreenState().getValue();
        if (r16 != null) goto L33;
        r16 = 0;
    L33:
        r15.put("screen_state", r16);
        r1.d.put("tabs_container_id", r3.getTabsContainerId());
        HashMap<String, Object> r17 = r1.d;
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator<Function1<com.bytedance.android.shopping.store.tabkit.model.k, TabKitBridge.TabKitBaseBridgeMethod>> r19 = r3.getJsBridge().a.iterator();
    L35:
        if (r19.hasNext() == false) goto L37;
        TabKitBridge.TabKitBaseBridgeMethod r20 = (TabKitBridge.TabKitBaseBridgeMethod) r19.next().invoke(null);
        r18.put(r20.getName(), com.bytedance.android.shopping.store.tabkit.bridge.a.a(r20));
        goto L35
    L37:
        ECLynxCard r21 = r1.a;
        ECLynxLoadParam.a r22 = new ECLynxLoadParam.a(r1.getContext(), r13, r1);
        Intrinsics.checkNotNullParameter(r18, "ecBridgeMap");
        r22.r = r18;
        Intrinsics.checkNotNullParameter(r17, "appendData");
        r22.m = r17;
        Intrinsics.checkNotNullParameter(r17, "ecGlobalProps");
        r22.p = r17;
        Intrinsics.checkNotNullParameter(r1, "lifecycle");
        r22.o = r1;
        if (r3.isFoldPage() == false) goto L62;
        y r110 = (y) r3.getCurrentTab().getValue();
        if (r110 == null) goto L62;
        com.bytedance.android.shopping.store.tabkit.model.k r111 = r110.a;
        if (r111 == null) goto L62;
        TabKitTabFragment r112 = TabKitViewModel.getTabFragment$default(r3, r111, false, 2, null);
        if (r112 == null) goto L62;
        com.bytedance.android.shopping.store.tabkit.f r113 = r112.getTabKitFragment();
        if (r113 == null) goto L62;
        if ((r113 instanceof Fragment) == true) goto L52;
        r113 = null;
    L52:
        Fragment r114 = (Fragment) r113;
        if (r114 == null) goto L62;
        Fragment r115 = r114.getParentFragment();
        if (r115 == null) goto L62;
        if ((r115 instanceof TabKitFoldFragment) == true) goto L59;
        r115 = null;
    L59:
        TabKitFoldFragment r116 = (TabKitFoldFragment) r115;
        if (r116 == null) goto L62;
        Lifecycle r117 = r116.getLifecycle();
    L63:
        r22.i = r117;
        ArrayList r118 = new ArrayList();
        r118.add(new rk3.b());
        Unit r23 = Unit.INSTANCE;
        r22.a(r118);
        r21.j(new ECLynxLoadParam(r22));
        r1.a(r3, null);
        r3.getLynxCards().add(r1.a);
    L62:
        r117 = null;
        goto L63
    L26:
        r9 = null;
    L19:
        r7 = 0;
    L64:
        if (r1 == null) goto L70;
        ArrayList<IECLynxCardLifeCycle> r119 = r1.getListener();
        if (r119 == null) goto L71;
        r119.add(new e(this, r11, r12));
        return;
    L71:
        return;
    L70:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void u(int r10, boolean r11, boolean r12) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L118;
        MutableLiveData<y> r1 = r0.getCurrentTab();
        if (r1 == null) goto L119;
        y r2 = (y) r1.getValue();
        if (r2 == null) goto L120;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = r2.a;
        if (r3 == null) goto L123;
        View r4 = null;
        r4 = null;
        r4 = null;
        Integer r5 = null;
        r5 = null;
        Integer r6 = null;
        r6 = null;
        if (r10 == 0) goto L79;
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L93;
        TabKitViewModel r7 = k0();
        if (r7 == null) goto L21;
        MutableLiveData<Boolean> r8 = r7.isUseNativeBottomBar();
        if (r8 == null) goto L21;
        Boolean r9 = (Boolean) r8.getValue();
    L23:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L93;
        r4 = this.i;
    L21:
        r9 = null;
    L93:
        TabKitViewModel r13 = k0();
        if (r13 == null) goto L98;
        com.bytedance.android.shopping.store.tabkit.bridge.c r14 = r13.getJsEventStub();
        if (r14 == null) goto L98;
        JSONObject r15 = new JSONObject();
        r15.put("component", r10);
        r15.put("visibility", r11);
        r15.put("animated", r12);
        Unit r16 = Unit.INSTANCE;
        r14.a("ecTabKit.componentVisibilityDidChange", r15);
    L98:
        if (r4 != null) goto L100;
        return;
    L100:
        if (r12 == true) goto L102;
    L114:
        if (r11 == false) goto L116;
        r4.setVisibility(0);
        return;
    L116:
        r4.setVisibility(8);
        return;
    L102:
        if (r4.getVisibility() != 0) goto L104;
        boolean r17 = true;
    L105:
        if (r17 == r11) goto L114;
        float[] r18 = new float[2];
        float r19 = 0.0f;
        if (r11 == false) goto L109;
        float r20 = 0.0f;
    L110:
        r18[0] = r20;
        if (r11 == false) goto L113;
        r19 = 1.0f;
    L113:
        r18[1] = r19;
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r4, "alpha", r18);
        r110.setDuration(300);
        r110.addListener(new b(r11, r4));
        r110.start();
        return;
    L109:
        r20 = 1.0f;
        goto L110
    L104:
        r17 = false;
        goto L105
    L25:
        TabKitViewModel r21 = k0();
        if (r21 == null) goto L30;
        MutableLiveData<Boolean> r22 = r21.isUseNativeTopBar();
        if (r22 == null) goto L30;
        Boolean r23 = (Boolean) r22.getValue();
    L32:
        if (Intrinsics.areEqual(r23, Boolean.TRUE) == true) goto L34;
    L48:
        FrameLayout r24 = null;
    L49:
        TabKitViewModel r25 = k0();
        if (r25 == null) goto L78;
        HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> r26 = r25.getTopTabBarVisibilityMap();
        if (r26 == null) goto L78;
        com.bytedance.android.shopping.store.tabkit.model.d r27 = r26.get(r3);
        if (r27 != null) goto L67;
        com.bytedance.android.shopping.store.tabkit.model.d r28 = new com.bytedance.android.shopping.store.tabkit.model.d();
        TabKitViewModel r29 = k0();
        if (r29 == null) goto L60;
        MutableLiveData<Integer> r30 = r29.getScreenState();
        if (r30 == null) goto L60;
        r5 = (Integer) r30.getValue();
    L60:
        if (r5 != null) goto L63;
    L65:
        r28.b = Boolean.valueOf(r11);
    L66:
        Unit r31 = Unit.INSTANCE;
        r26.put(r3, r28);
        goto L78
    L63:
        if (r5.intValue() != 1) goto L65;
        r28.a = Boolean.valueOf(r11);
        goto L66
    L67:
        TabKitViewModel r32 = k0();
        if (r32 == null) goto L72;
        MutableLiveData<Integer> r33 = r32.getScreenState();
        if (r33 == null) goto L72;
        r6 = (Integer) r33.getValue();
    L72:
        if (r6 != null) goto L75;
    L77:
        r27.b = Boolean.valueOf(r11);
        goto L78
    L75:
        if (r6.intValue() != 1) goto L77;
        r27.a = Boolean.valueOf(r11);
    L78:
        r4 = r24;
        goto L93
    L34:
        if (r3.a == null) goto L36;
        r24 = this.h;
        goto L49
    L36:
        TabKitViewModel r34 = k0();
        if (r34 == null) goto L39;
        TabKitTabFragment r35 = TabKitViewModel.getTabFragment$default(r34, r3, false, 2, null);
    L41:
        if ((r35 instanceof TabKitHybridTabFragment) == false) goto L44;
        r24 = ((TabKitHybridTabFragment) r35).getTitleContainer();
        goto L49
    L44:
        if ((r35 instanceof TabKitAnnieXTabFragment) == false) goto L48;
        TabRootView r36 = ((TabKitAnnieXTabFragment) r35).getRootView();
        if (r36 == null) goto L48;
        r24 = r36.getTitleContainer();
        goto L49
    L39:
        r35 = null;
    L30:
        r23 = null;
        goto L32
    L79:
        TabKitViewModel r37 = k0();
        if (r37 == null) goto L84;
        HashMap<com.bytedance.android.shopping.store.tabkit.model.k, Boolean> r38 = r37.getNavBarVisibilityMap();
        if (r38 == null) goto L84;
        r38.remove(r3);
        r38.put(r3, Boolean.valueOf(r11));
    L84:
        TabKitViewModel r39 = k0();
        if (r39 == null) goto L89;
        MutableLiveData<Boolean> r40 = r39.isUseNativeTopBar();
        if (r40 == null) goto L89;
        Boolean r41 = (Boolean) r40.getValue();
    L91:
        if (Intrinsics.areEqual(r41, Boolean.TRUE) == false) goto L93;
        r4 = this.m;
    L89:
        r41 = null;
        goto L91
    L123:
        return;
    L120:
        return;
    L119:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.bridge.b
    public final void s(boolean r4, long r5, long r7, int r9) {
        TabKitViewModel r0 = k0();
        if (r0 == null) goto L14;
        com.bytedance.android.shopping.store.tabkit.h r1 = r0.getInterceptorHelper();
        if (r1 == null) goto L15;
        if (r9 != 0) goto L8;
        com.bytedance.android.shopping.store.tabkit.h.a r10 = r1.a;
    L12:
        r10.a = r4;
        r10.b = r5;
        r10.c = r7;
        return;
    L8:
        com.bytedance.android.shopping.store.tabkit.h.a r2 = r1.b.get(r9);
        if (r2 != null) goto L11;
        r2 = new com.bytedance.android.shopping.store.tabkit.h.a(0);
        r1.b.put(r9, r2);
    L11:
        r10 = r2;
        goto L12
    L15:
        return;
    }
}
