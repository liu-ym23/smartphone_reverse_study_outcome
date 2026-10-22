package com.bytedance.awemeopen.apps.framework.collect;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.UserProfileViewPager;
import com.bytedance.awemeopen.apps.framework.collect.presenter.UserCollectDampScrollMaxHeightPresenter;
import com.bytedance.awemeopen.apps.framework.collect.works.UserCollectWorksFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosFeedsHomeLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosRecommendFeedLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedsChannelFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.profile.presenter.UserProfileHeaderInfoPresenter;
import com.bytedance.awemeopen.apps.framework.profile.works.UserProfileWorksFragment;
import com.bytedance.awemeopen.apps.framework.utils.v;
import com.bytedance.awemeopen.export.api.pageconfig.collect.CollectPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import fy3.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/AosUserCollectFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/collect/UserCollectViewModel;", "Landroidx/lifecycle/Observer;", "Lo04/a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserCollectFragment extends AosBaseFragment<UserCollectViewModel> implements Observer<o04.a> {
    public static final /* synthetic */ int t = 0;
    public final String g;
    public DmtStatusView h;
    public DampScrollableLayout i;
    public UserProfileViewPager j;
    public UserCollectContainerAdapter k;
    public f04.b<Unit> l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;
    public FlexibleLifecycleOwner q;
    public final d r;
    public final Map<Integer, View> s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedHomeContainerViewModel.EnterProfileStyle.values().length];
            r0[FeedHomeContainerViewModel.EnterProfileStyle.DraggingToEnter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FeedHomeContainerViewModel.EnterProfileStyle.ClickHeadToEnter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FeedHomeContainerViewModel.EnterProfileStyle.ClickUserNameToEnter.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements FlexibleLifecycleOwner.b {
        public final /* synthetic */ AosUserCollectFragment a;

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void a() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void c() {
            f04.b<Unit> r0 = this.a.l;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
            r0 = null;
        L5:
            UserProfileHeaderInfoPresenter r1 = (UserProfileHeaderInfoPresenter) r0.g(UserProfileHeaderInfoPresenter.class);
            if (r1 == null) goto L9;
            AoLogger.g(r1.e, new Object[]{"onHide"});
            r1.p = false;
            return;
        }

        public c(AosUserCollectFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void b(int r6) {
            f04.b<Unit> r1 = null;
            if (r6 != 1) goto L12;
            f04.b<Unit> r7 = this.a.l;
            if (r7 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
            r7 = null;
        L7:
            com.bytedance.awemeopen.apps.framework.profile.presenter.h r8 = (com.bytedance.awemeopen.apps.framework.profile.presenter.h) r7.g(com.bytedance.awemeopen.apps.framework.profile.presenter.h.class);
            if (r8 == null) goto L12;
            if (r8.i == false) goto L12;
            r8.m();
        L12:
            f04.b<Unit> r9 = this.a.l;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
        L16:
            UserProfileHeaderInfoPresenter r10 = (UserProfileHeaderInfoPresenter) r1.g(UserProfileHeaderInfoPresenter.class);
            if (r10 == null) goto L20;
            AoLogger.g(r10.e, new Object[]{"onShow"});
            r10.p = true;
            r10.n();
            return;
        L20:
            return;
        L15:
            r1 = r9;
            goto L16
        }
    }

    public static final class d implements DampScrollableLayout.d {
        public final /* synthetic */ AosUserCollectFragment a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public d(AosUserCollectFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r3) {
            UserProfileViewPager r0 = null;
            if (r3 >= 0) goto L9;
            UserProfileViewPager r4 = this.a.j;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        L8:
            r0.setScrollable(false);
            return;
        L7:
            r0 = r4;
            goto L8
        L9:
            UserProfileViewPager r5 = this.a.j;
            if (r5 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        L13:
            r0.setScrollable(true);
            return;
        L12:
            r0 = r5;
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.s).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558651;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<UserCollectViewModel> da0() {
        return UserCollectViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosUserCollectFragment() {
        this.s = new LinkedHashMap();
        this.g = "UserCollectFragment";
        this.r = new d(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        DampScrollableLayout r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r0 = null;
    L5:
        r0.e(this.r);
        f04.b<Unit> r1 = this.l;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
        r1 = null;
    L8:
        r1.l();
        LiveDataBus r2 = LiveDataBus.c;
        LiveDataBus.a.a(o04.a.class).removeObserver(this);
        m04.a.a = null;
    }

    public final UserCollectContainerAdapter ga0() {
        UserCollectContainerAdapter r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        UserCollectViewModel r0 = W90();
        Fragment r1 = getParentFragment();
        FlexibleLifecycleOwner r3 = null;
        if ((r1 instanceof AosFeedsHomeFragment) == false) goto L5;
        AosFeedsHomeFragment r2 = (AosFeedsHomeFragment) r1;
    L7:
        if (r2 == null) goto L9;
        boolean r4 = true;
    L10:
        r0.setNestingUsed(r4);
        W90().clearUserInfo();
        i r5 = new i(V90(), W90(), this, getActivity(), this);
        f04.b<Unit> r6 = new f04.b(r5.a);
        this.l = r6;
        r6.m(new m(r5));
        r6.m(new fy3.b(r5));
        r6.m(new fy3.h(r5));
        r6.m(new UserCollectDampScrollMaxHeightPresenter(r5));
        r6.f(Unit.INSTANCE);
        if (W90().isNestingUsed() == false) goto L63;
        FragmentManager r7 = getFragmentManager();
        if (r7 == null) goto L57;
        List r8 = r7.getFragments();
        if (r8 == null) goto L57;
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((Fragment) r10).getClass(), AosFeedsChannelFragment.class) == false) goto L18;
    L23:
        Fragment r11 = (Fragment) r10;
        if (r11 == null) goto L57;
        if (AosExtConfig.b.W1().a == false) goto L52;
        AosFeedsChannelFragment r12 = (AosFeedsChannelFragment) r11;
        AosFeedsHomeLayout r13 = r12.S90();
        if (r13 == null) goto L30;
        List<View> r14 = r13.getFeedPages();
    L31:
        if (r14 == null) goto L33;
        Integer r15 = Integer.valueOf(r14.size());
    L34:
        Intrinsics.checkNotNull(r15);
        int r16 = r15.intValue();
        int r17 = 0;
    L36:
        if (r17 >= r16) goto L47;
        AosFeedsHomeLayout r18 = r12.S90();
        if (r18 != null) goto L40;
    L42:
        boolean r19 = false;
    L43:
        if (r19 == true) goto L46;
        Object r20 = ListProtector.get(r14, r17);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout<*>");
        ha0(r12, (AosFeedPagerListLayout) r20);
    L46:
        r17 = r17 + 1;
        goto L36
    L40:
        if (r17 != r18.getCurrentSeletecdIndex()) goto L42;
        r19 = true;
        goto L43
    L47:
        AosFeedsHomeLayout r21 = r12.S90();
        if (r21 == null) goto L50;
        View r22 = (View) ListProtector.get(r14, r21.getCurrentSeletecdIndex());
    L51:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout<*>");
        ha0(r12, (AosFeedPagerListLayout) r22);
        goto L57
    L50:
        r22 = null;
        goto L51
    L33:
        r15 = null;
        goto L34
    L30:
        r14 = null;
        goto L31
    L52:
        AosFeedsChannelFragment r23 = (AosFeedsChannelFragment) r11;
        AosFeedsHomeLayout r24 = r23.S90();
        if (r24 == null) goto L55;
        AosRecommendFeedLayout r25 = r24.getAosRecommendFeedLayout();
    L56:
        Intrinsics.checkNotNull(r25);
        ha0(r23, r25);
        goto L57
    L55:
        r25 = null;
        goto L56
    L22:
        r10 = null;
    L57:
        LifecycleOwner r26 = getParentFragment();
        if ((r26 instanceof AosFeedsHomeFragment) == false) goto L60;
        AosFeedsHomeFragment r27 = (AosFeedsHomeFragment) r26;
    L61:
        if (r27 == null) goto L71;
        ViewModelProviderFactory r28 = ViewModelProviderFactory.a;
        r28.getClass();
        FeedHomeContainerViewModel r29 = (FeedHomeContainerViewModel) new ViewModelProvider(r27, r28).get(FeedHomeContainerViewModel.class);
        r29.getStartEnteringToProfile().observe(r27, new com.bytedance.awemeopen.apps.framework.collect.c(this));
        r29.getSelectedIndex().observe(r27, new com.bytedance.awemeopen.apps.framework.collect.d(this));
        r29.getDeliveredHiddenChangedState().observe(r27, new e(this));
    L71:
        DampScrollableLayout r30 = this.i;
        if (r30 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r30 = null;
    L74:
        r30.d(this.r);
        LiveDataBus r31 = LiveDataBus.c;
        LiveDataBus.a.a(o04.a.class).observeForever(this);
        FlexibleLifecycleOwner r32 = this.q;
        if (r32 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("flexibleLifecycleOwner");
    L78:
        c r33 = new c(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r33, "observer");
        if (r3.c.getCurrentState() == Lifecycle.State.DESTROYED) goto L88;
        ((ArrayList) r3.d).add(r33);
        return;
    L88:
        return;
    L77:
        r3 = r32;
        goto L78
    L60:
        r27 = null;
        goto L61
    L63:
        W90().getServerUserStatus().observe(this, new com.bytedance.awemeopen.apps.framework.collect.b(this));
        UserCollectViewModel r34 = W90();
        Bundle r35 = getArguments();
        String r36 = "";
        if (r35 == null) goto L66;
        String r37 = r35.getString("user_collect_feed_enter_method", "");
    L67:
        if (r37 == null) goto L70;
        r36 = r37;
    L70:
        r34.setEnterMethod(r36);
        W90().getUserInfo(requireContext());
        goto L71
    L66:
        r37 = null;
        goto L67
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void fa0() {
        if (W90().isShowingInNestingPage() == false) goto L5;
        return;
    L5:
        if (W90().userInfoHasBeenCleared() == false) goto L7;
        return;
    L7:
        W90().clearUserInfo();
        q04.b r0 = W90().getProfileIds();
        UserProfileViewPager r1 = null;
        r0.a = null;
        r0.b = "";
        jz3.a r2 = W90().getCachedFeedItemEntity();
        if (r2 == null) goto L10;
        r14.c r3 = r2.a;
    L12:
        if (r3 != null) goto L14;
        this.m = "";
        this.o = false;
    L15:
        UserCollectContainerAdapter r4 = ga0();
        String r5 = this.m;
        boolean r6 = this.o;
        String r7 = W90().getProfileIds().b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "userOpenId");
        r4.d = r6;
        r4.c = r5;
        Fragment r8 = r4.f(0);
        if ((r8 instanceof UserCollectWorksFragment) == false) goto L18;
        UserCollectWorksFragment r9 = (UserCollectWorksFragment) r8;
    L19:
        if (r9 == null) goto L21;
        r9.ma0(r5, r6, r7);
    L21:
        DmtStatusView r10 = this.h;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r10 = null;
    L24:
        r10.c();
        DampScrollableLayout r11 = this.i;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r11 = null;
    L28:
        if (r11.x == 0) goto L30;
        r11.scrollTo(0, 0);
    L30:
        List r12 = getChildFragmentManager().getFragments();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L32:
        if (r14.hasNext() == false) goto L36;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Fragment) r15).getClass(), UserCollectWorksFragment.class) == false) goto L32;
        r13.add(r15);
        goto L32
    L36:
        Iterator r16 = r13.iterator();
    L38:
        if (r16.hasNext() == false) goto L48;
        Fragment r17 = (Fragment) r16.next();
        if ((r17 instanceof AosRecyclerListFragment) == false) goto L42;
        AosRecyclerListFragment r18 = (AosRecyclerListFragment) r17;
    L43:
        if (r18 == null) goto L38;
        RecyclerView r19 = r18.i;
        if (r19 == null) goto L47;
        r19.scrollToPosition(0);
    L47:
        ((AosRecyclerListViewModel) r18.W90()).clearData();
        goto L38
    L42:
        r18 = null;
        goto L43
    L48:
        UserProfileViewPager r20 = this.j;
        if (r20 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L52:
        r1.y(0, false);
        return;
    L51:
        r1 = r20;
        goto L52
    L18:
        r9 = null;
        goto L19
    L14:
        this.m = r3.c();
        this.o = v.b(r3);
        goto L15
    L10:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        this.h = (DmtStatusView) findViewById(2131387318);
        this.i = (DampScrollableLayout) findViewById(2131385230);
        this.j = (UserProfileViewPager) findViewById(2131392076);
        DmtStatusView.a r0 = DmtStatusView.a.a(getContext());
        DmtStatusView r1 = this.h;
        UserProfileViewPager r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r1 = null;
    L5:
        AosDefaultNetErrorView r3 = U90(r1);
        r3.findViewById(2131384465).setOnClickListener(new f(this));
        r0.d(r3);
        DmtStatusView r4 = this.h;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r4 = null;
    L8:
        r4.setBuilder(r0);
        DmtStatusView r5 = this.h;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r5 = null;
    L11:
        r5.c();
        DampScrollableLayout r6 = m04.a.a;
        DampScrollableLayout r7 = this.i;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r7 = null;
    L14:
        m04.a.a = r7;
        DampScrollableLayout r8 = this.i;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r8 = null;
    L17:
        Resources r9 = Resources.getSystem();
        r8.setMinY(MathKt.roundToInt(TypedValue.applyDimension(1, -300, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()))));
        UserProfileViewPager r10 = this.j;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        UserProfileViewPager r11 = null;
    L21:
        String r12 = this.m;
        boolean r13 = this.o;
        String r14 = this.n;
        Intrinsics.checkNotNull(r14);
        UserCollectContainerAdapter r15 = new UserCollectContainerAdapter(r11, this, r12, r13, r14, W90().getPageConfig().getHideLongPressTab(), W90().getPageConfig().getHostCommonParams().optString("host_enter_from", ""));
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.k = r15;
        UserProfileViewPager r16 = this.j;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r16 = null;
    L24:
        r16.setAdapter(ga0());
        ViewPager.OnPageChangeListener r17 = new AosUserCollectFragment$initViewPage$pageChangeListener$1(this);
        UserProfileViewPager r18 = this.j;
        if (r18 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r18 = null;
    L27:
        r18.b(r17);
        DampScrollableLayout r19 = this.i;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r19 = null;
    L30:
        UserProfileViewPager r20 = this.j;
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L34:
        r19.setChildViewPager(r2);
        return;
    L33:
        r2 = r20;
        goto L34
    L20:
        r11 = r10;
        goto L21
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        if (W90().isShowingInNestingPage() == false) goto L12;
        Fragment r0 = getParentFragment();
        if ((r0 instanceof AosFeedsHomeFragment) == false) goto L7;
        AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
    L8:
        if (r1 == null) goto L12;
        r1.ea0(0);
        return Boolean.TRUE;
    L7:
        r1 = null;
    L12:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r5) {
        boolean r0 = false;
        if (r5 == null) goto L5;
        boolean r6 = true;
    L6:
        this.p = r6;
        Bundle r7 = getArguments();
        String r1 = null;
        if (r7 == null) goto L9;
        CollectPageConfig r8 = (CollectPageConfig) r7.getParcelable("COLLECT_PAGE_CONFIG_CONFIG_KEY");
    L10:
        UserCollectViewModel r2 = W90();
        if (r8 != null) goto L13;
        CollectPageConfig r3 = new CollectPageConfig();
    L14:
        r2.initPageConfig(r3);
        if (r8 == null) goto L17;
        String r4 = r8.getAid();
    L18:
        this.m = r4;
        if (r8 == null) goto L23;
        Boolean r9 = r8.isLive();
        if (r9 == null) goto L23;
        r0 = r9.booleanValue();
    L23:
        this.o = r0;
        if (r8 == null) goto L26;
        r1 = r8.getOpenId();
    L26:
        this.n = r1;
        return;
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = r8;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    public final void ea0(int r4) {
        DampScrollableLayout r0 = this.i;
        xx3.b.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r0 = null;
    L5:
        xx3.b r2 = r0.getHelper();
        Fragment r5 = ga0().f(r4);
        if ((r5 instanceof xx3.b.a) == false) goto L8;
        r1 = (xx3.b.a) r5;
    L8:
        r2.a = r1;
    }

    public final void onChanged(Object r2) {
        o04.a r3 = (o04.a) r2;
        if (r3 == null) goto L13;
        Object r0 = W90().getSelectedIndex().getValue();
        Intrinsics.checkNotNull(r0);
        int r1 = ((Number) r0).intValue();
        if (r1 >= 0) goto L10;
        if (Intrinsics.areEqual(r3.a, UserProfileWorksFragment.class.getName()) == false) goto L14;
        ea0(0);
        W90().updatePage(0);
        return;
    L14:
        return;
    L10:
        if (r1 != r3.b) goto L16;
        ea0(r1);
        return;
    L16:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        FlexibleLifecycleOwner r3 = new FlexibleLifecycleOwner(new AnonymousClass1(this));
        this.q = r3;
        r3.a(getLifecycle());
    }

    public final void ha0(AosFeedsChannelFragment r3, AosFeedPagerListLayout<?> r4) {
        Intrinsics.checkNotNull(r4);
        ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
        r1.getClass();
        final FeedPagerListViewModel r5 = (FeedPagerListViewModel) new ViewModelProvider(r4, r1).get(r4.m());
        r5.getPalpableIndex().observe(r3, new g(this, r5));
    }
}
