package com.bytedance.awemeopen.apps.framework.profile;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout;
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
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragment;
import com.bytedance.awemeopen.apps.framework.profile.presenter.UserProfileDampScrollMaxHeightPresenter;
import com.bytedance.awemeopen.apps.framework.profile.presenter.UserProfileHeaderInfoPresenter;
import com.bytedance.awemeopen.apps.framework.profile.presenter.g0;
import com.bytedance.awemeopen.apps.framework.profile.presenter.i0;
import com.bytedance.awemeopen.apps.framework.profile.presenter.k0;
import com.bytedance.awemeopen.apps.framework.profile.presenter.o0;
import com.bytedance.awemeopen.apps.framework.profile.presenter.t;
import com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper;
import com.bytedance.awemeopen.apps.framework.profile.works.UserProfileWorksFragment;
import com.bytedance.awemeopen.apps.framework.utils.v;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/AosUserProfileFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/profile/UserProfileViewModel;", "Landroidx/lifecycle/Observer;", "Lo04/a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserProfileFragment extends AosBaseFragment<UserProfileViewModel> implements Observer<o04.a> {
    public static final /* synthetic */ int D = 0;
    public final i A;
    public k34.a B;
    public final Map<Integer, View> C;
    public final String g;
    public UserProfileDampScrollMaxHeightPresenter h;
    public DmtStatusView i;
    public DampScrollableLayout j;
    public DmtTabLayout k;
    public FrameLayout l;
    public UserProfileViewPager m;
    public UserProfileWorksContainerAdapter n;
    public f04.b<Unit> o;
    public boolean p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final int[] u;
    public FlexibleLifecycleOwner v;
    public Function0<Boolean> w;
    public final d x;
    public String y;
    public String z;

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
        public final /* synthetic */ AosUserProfileFragment a;

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void a() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void c() {
            f04.b<Unit> r0 = this.a.o;
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

        public c(AosUserProfileFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.livedata.FlexibleLifecycleOwner.b
        public final void b(int r6) {
            f04.b<Unit> r1 = null;
            if (r6 != 1) goto L12;
            f04.b<Unit> r7 = this.a.o;
            if (r7 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
            r7 = null;
        L7:
            com.bytedance.awemeopen.apps.framework.profile.presenter.h r8 = (com.bytedance.awemeopen.apps.framework.profile.presenter.h) r7.g(com.bytedance.awemeopen.apps.framework.profile.presenter.h.class);
            if (r8 == null) goto L12;
            if (r8.i == false) goto L12;
            r8.m();
        L12:
            f04.b<Unit> r9 = this.a.o;
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
        public final /* synthetic */ AosUserProfileFragment a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public d(AosUserProfileFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r3) {
            UserProfileViewPager r0 = null;
            if (r3 >= 0) goto L9;
            UserProfileViewPager r4 = this.a.m;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        L8:
            r0.setScrollable(false);
            return;
        L7:
            r0 = r4;
            goto L8
        L9:
            UserProfileViewPager r5 = this.a.m;
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
        ((LinkedHashMap) this.C).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558655;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<UserProfileViewModel> da0() {
        return UserProfileViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.awemeopen.apps.framework.profile.i] */
    public AosUserProfileFragment() {
        this.C = new LinkedHashMap();
        this.g = "UserProfileFragment";
        this.u = new int[2];
        this.x = new d(this);
        this.A = new i(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        DampScrollableLayout r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r0 = null;
    L5:
        r0.e(W90().getRecentlySeeHelper().y);
        DampScrollableLayout r1 = this.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r1 = null;
    L8:
        r1.e(this.x);
        f04.b<Unit> r2 = this.o;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
        r2 = null;
    L11:
        r2.l();
        LiveDataBus r3 = LiveDataBus.c;
        LiveDataBus.a.a(o04.a.class).removeObserver(this);
        m04.a.a = null;
        d14.a r4 = b14.a.a;
        b14.a.a(t24.a.class).z0(this.A);
        this.B = null;
    }

    public final UserProfileWorksContainerAdapter ga0() {
        UserProfileWorksContainerAdapter r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        UserProfileViewModel r0 = W90();
        Fragment r1 = getParentFragment();
        FlexibleLifecycleOwner r3 = null;
        if ((r1 instanceof AosFeedsHomeFragment) == false) goto L5;
        AosFeedsHomeFragment r2 = (AosFeedsHomeFragment) r1;
    L6:
        int r4 = 0;
        if (r2 == null) goto L9;
        boolean r5 = true;
    L10:
        r0.setNestingUsed(r5);
        W90().clearUserInfo();
        d14.a r6 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.A);
        m r7 = new m(V90(), W90(), this, getActivity(), this);
        this.o = new f04.b(r7.a);
        this.h = new UserProfileDampScrollMaxHeightPresenter(r7);
        f04.b<Unit> r8 = this.o;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("groupPresenter");
        r8 = null;
    L13:
        r8.m(new o0(r7));
        r8.m(new com.bytedance.awemeopen.apps.framework.profile.presenter.b(r7));
        r8.m(new UserProfileHeaderInfoPresenter(r7));
        r8.m(new com.bytedance.awemeopen.apps.framework.profile.presenter.j(r7));
        r8.m(new k0(r7));
        r8.m(new t(r7));
        r8.m(new i0(r7));
        r8.m(new g0(r7));
        r8.m(new com.bytedance.awemeopen.apps.framework.profile.presenter.h(r7));
        UserProfileDampScrollMaxHeightPresenter r9 = this.h;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("dampScrollMaxHeightPresenter");
        r9 = null;
    L16:
        r8.m(r9);
        r8.f(Unit.INSTANCE);
        if (W90().isNestingUsed() == false) goto L85;
        FragmentManager r10 = getFragmentManager();
        if (r10 == null) goto L79;
        List r11 = r10.getFragments();
        if (r11 == null) goto L79;
        Iterator r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L28;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((Fragment) r13).getClass(), AosFeedsChannelFragment.class) == false) goto L24;
    L29:
        Fragment r14 = (Fragment) r13;
        if (r14 == null) goto L79;
        if (AosExtConfig.b.W1().a == true) goto L34;
    L74:
        AosFeedsChannelFragment r15 = (AosFeedsChannelFragment) r14;
        AosFeedsHomeLayout r16 = r15.S90();
        if (r16 == null) goto L77;
        AosRecommendFeedLayout r17 = r16.getAosRecommendFeedLayout();
    L78:
        Intrinsics.checkNotNull(r17);
        ha0(r15, r17);
        goto L79
    L77:
        r17 = null;
        goto L78
    L34:
        if (this.p == true) goto L74;
        AosFeedsChannelFragment r18 = (AosFeedsChannelFragment) r14;
        AosFeedsHomeLayout r19 = r18.S90();
        if (r19 == null) goto L38;
        List<View> r20 = r19.getFeedPages();
    L39:
        if (r20 == null) goto L41;
        Integer r21 = Integer.valueOf(r20.size());
    L42:
        Intrinsics.checkNotNull(r21);
        int r22 = r21.intValue();
        int r23 = 0;
    L44:
        if (r23 >= r22) goto L57;
        AosFeedsHomeLayout r24 = r18.S90();
        if (r24 != null) goto L48;
    L50:
        boolean r25 = false;
    L51:
        if (r25 == true) goto L56;
        if ((ListProtector.get(r20, r23) instanceof AosFeedPagerListLayout) == false) goto L56;
        Object r26 = ListProtector.get(r20, r23);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout<*>");
        ha0(r18, (AosFeedPagerListLayout) r26);
    L56:
        r23 = r23 + 1;
        goto L44
    L48:
        if (r23 != r24.getCurrentSeletecdIndex()) goto L50;
        r25 = true;
        goto L51
    L57:
        if (r20 == null) goto L79;
        AosFeedsHomeLayout r27 = r18.S90();
        if (r27 == null) goto L62;
        r4 = r27.getCurrentSeletecdIndex();
    L62:
        if (r4 >= r20.size()) goto L79;
        AosFeedsHomeLayout r28 = r18.S90();
        if (r28 == null) goto L66;
        View r29 = (View) ListProtector.get(r20, r28.getCurrentSeletecdIndex());
    L68:
        if ((r29 instanceof AosFeedPagerListLayout) == false) goto L79;
        AosFeedsHomeLayout r30 = r18.S90();
        if (r30 == null) goto L72;
        View r31 = (View) ListProtector.get(r20, r30.getCurrentSeletecdIndex());
    L73:
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout<*>");
        ha0(r18, (AosFeedPagerListLayout) r31);
        goto L79
    L72:
        r31 = null;
        goto L73
    L66:
        r29 = null;
        goto L68
    L41:
        r21 = null;
        goto L42
    L38:
        r20 = null;
        goto L39
    L28:
        r13 = null;
    L79:
        LifecycleOwner r32 = getParentFragment();
        if ((r32 instanceof AosFeedsHomeFragment) == false) goto L82;
        AosFeedsHomeFragment r33 = (AosFeedsHomeFragment) r32;
    L83:
        if (r33 == null) goto L93;
        ViewModelProviderFactory r34 = ViewModelProviderFactory.a;
        r34.getClass();
        FeedHomeContainerViewModel r35 = (FeedHomeContainerViewModel) new ViewModelProvider(r33, r34).get(FeedHomeContainerViewModel.class);
        r35.getStartEnteringToProfile().observe(r33, new com.bytedance.awemeopen.apps.framework.profile.d(this));
        r35.getSelectedIndex().observe(r33, new e(this));
        r35.getDeliveredHiddenChangedState().observe(r33, new f(this));
    L93:
        DampScrollableLayout r36 = this.j;
        if (r36 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r36 = null;
    L96:
        r36.d(W90().getRecentlySeeHelper().y);
        DampScrollableLayout r37 = this.j;
        if (r37 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r37 = null;
    L99:
        r37.d(this.x);
        LiveDataBus r38 = LiveDataBus.c;
        LiveDataBus.a.a(o04.a.class).observeForever(this);
        FlexibleLifecycleOwner r39 = this.v;
        if (r39 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("flexibleLifecycleOwner");
    L103:
        c r40 = new c(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r40, "observer");
        if (r3.c.getCurrentState() == Lifecycle.State.DESTROYED) goto L114;
        ((ArrayList) r3.d).add(r40);
        return;
    L114:
        return;
    L102:
        r3 = r39;
        goto L103
    L82:
        r33 = null;
        goto L83
    L85:
        W90().getServerUserStatus().observe(this, new h(this));
        UserProfileViewModel r41 = W90();
        Bundle r42 = getArguments();
        String r43 = "";
        if (r42 == null) goto L88;
        String r44 = r42.getString("user_profile_feed_enter_method", "");
    L89:
        if (r44 == null) goto L92;
        r43 = r44;
    L92:
        r41.setEnterMethod(r43);
        W90().getUserInfo(requireContext());
        goto L93
    L88:
        r44 = null;
        goto L89
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
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
        this.q = "";
        this.r = false;
    L15:
        ga0().g(this.q, this.r, W90().getPageConfig().getHostExtraParams());
        DmtStatusView r4 = this.i;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r4 = null;
    L18:
        r4.c();
        DampScrollableLayout r5 = this.j;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r5 = null;
    L22:
        if (r5.x == 0) goto L24;
        r5.scrollTo(0, 0);
    L24:
        List r6 = getChildFragmentManager().getFragments();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L26:
        if (r8.hasNext() == false) goto L36;
        Object r9 = r8.next();
        Fragment r10 = (Fragment) r9;
        if (Intrinsics.areEqual(r10.getClass(), UserProfileLikesFragment.class) == false) goto L30;
    L33:
        boolean r11 = true;
    L34:
        if (r11 == false) goto L26;
        r7.add(r9);
        goto L26
    L30:
        if (Intrinsics.areEqual(r10.getClass(), UserProfileWorksFragment.class) == true) goto L33;
        r11 = false;
        goto L34
    L36:
        Iterator r12 = r7.iterator();
    L38:
        if (r12.hasNext() == false) goto L48;
        Fragment r13 = (Fragment) r12.next();
        if ((r13 instanceof AosRecyclerListFragment) == false) goto L42;
        AosRecyclerListFragment r14 = (AosRecyclerListFragment) r13;
    L43:
        if (r14 == null) goto L38;
        RecyclerView r15 = r14.i;
        if (r15 == null) goto L47;
        r15.scrollToPosition(0);
    L47:
        ((AosRecyclerListViewModel) r14.W90()).clearData();
        goto L38
    L42:
        r14 = null;
        goto L43
    L48:
        UserProfileViewPager r16 = this.m;
        if (r16 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L52:
        r1.y(0, false);
        com.bytedance.awemeopen.apps.framework.utils.c r17 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        this.B = com.bytedance.awemeopen.apps.framework.utils.c.b();
        return;
    L51:
        r1 = r16;
        goto L52
    L14:
        this.q = r3.c();
        this.r = v.b(r3);
        goto L15
    L10:
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        this.i = (DmtStatusView) findViewById(2131387318);
        this.j = (DampScrollableLayout) findViewById(2131385230);
        this.m = (UserProfileViewPager) findViewById(2131392076);
        this.k = (DmtTabLayout) findViewById(2131392060);
        this.l = (FrameLayout) findViewById(2131374530);
        final RecentlySeeHelper r0 = W90().getRecentlySeeHelper();
        ViewGroup r1 = (ViewGroup) findViewById(2131383867);
        boolean r2 = this.s;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "layout");
        r0.e = (ImageView) r1.findViewById(2131383868);
        r0.d = (TextView) r1.findViewById(2131383870);
        r0.c = r1;
        r1.setOnClickListener(new com.bytedance.awemeopen.apps.framework.profile.works.d(r0));
        r0.l = r2;
        DmtTabLayout r3 = null;
        if (r2 == false) goto L8;
        ViewGroup r4 = r0.c;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r4 = null;
    L7:
        x54.b.b(r4);
    L8:
        RecentlySeeHelper r5 = W90().getRecentlySeeHelper();
        Function0<String> r6 = new AnonymousClass1(this);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.u = r6;
        RecentlySeeHelper r7 = W90().getRecentlySeeHelper();
        Function0<Integer> r8 = new AnonymousClass2(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.v = r8;
        W90().getRecentlySeeHelper().x = new AnonymousClass3(this);
        DmtStatusView.a r9 = DmtStatusView.a.a(getContext());
        DmtStatusView r10 = this.i;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r10 = null;
    L11:
        AosDefaultNetErrorView r11 = U90(r10);
        r11.findViewById(2131384465).setOnClickListener(new g(this));
        r9.d(r11);
        DmtStatusView r12 = this.i;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r12 = null;
    L14:
        r12.setBuilder(r9);
        DmtStatusView r13 = this.i;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        r13 = null;
    L17:
        r13.c();
        DampScrollableLayout r14 = m04.a.a;
        DampScrollableLayout r15 = this.j;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r15 = null;
    L20:
        m04.a.a = r15;
        DampScrollableLayout r16 = this.j;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r16 = null;
    L23:
        Resources r17 = Resources.getSystem();
        r16.setMinY(MathKt.roundToInt(TypedValue.applyDimension(1, -300, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()))));
        UserProfileViewPager r18 = this.m;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        UserProfileViewPager r19 = null;
    L27:
        UserProfileWorksContainerAdapter r20 = new UserProfileWorksContainerAdapter(r19, this, this.q, this.r, W90().getPageConfig().getHideLongPressTab(), W90().getPageConfig().getHostExtraParams(), W90().getPageConfig().getHostCommonParams().optString("host_enter_from", ""));
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        this.n = r20;
        UserProfileViewPager r21 = this.m;
        if (r21 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r21 = null;
    L30:
        r21.setAdapter(ga0());
        ViewPager.OnPageChangeListener r22 = new AosUserProfileFragment$initViewPage$pageChangeListener$1(this);
        UserProfileViewPager r23 = this.m;
        if (r23 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r23 = null;
    L33:
        r23.b(r22);
        DampScrollableLayout r24 = this.j;
        if (r24 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
        r24 = null;
    L36:
        UserProfileViewPager r25 = this.m;
        if (r25 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r25 = null;
    L39:
        r24.setChildViewPager(r25);
        DmtTabLayout r26 = this.k;
        if (r26 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r26 = null;
    L42:
        r26.setTabMode(0);
        DmtTabLayout r27 = this.k;
        if (r27 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r27 = null;
    L45:
        r27.setAutoFillWhenScrollable(true);
        DmtTabLayout r28 = this.k;
        if (r28 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r28 = null;
    L48:
        DmtTabLayout r29 = this.k;
        if (r29 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r29 = null;
    L51:
        DmtTabLayout.h r30 = r29.j(2131558690);
        r30.c("作品");
        r28.b(r30, true);
        DmtTabLayout r31 = this.k;
        if (r31 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r31 = null;
    L54:
        DmtTabLayout r32 = this.k;
        if (r32 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r32 = null;
    L57:
        DmtTabLayout.h r33 = r32.j(2131558690);
        r33.c("喜欢");
        r31.b(r33, r31.a.isEmpty());
        DmtTabLayout r34 = this.k;
        if (r34 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L61:
        r3.setOnTabClickListener(new j(this));
        return;
    L60:
        r3 = r34;
        goto L61
    L26:
        r19 = r18;
        goto L27
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

    public final void onResume() {
        super.onResume();
        k34.a r0 = this.B;
        if (r0 == null) goto L6;
        com.bytedance.awemeopen.apps.framework.utils.c r1 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        com.bytedance.awemeopen.apps.framework.utils.c.c(r0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r5) {
        boolean r0 = false;
        if (r5 == null) goto L5;
        boolean r6 = true;
    L6:
        this.t = r6;
        Bundle r7 = getArguments();
        String r1 = null;
        if (r7 == null) goto L9;
        ProfilePageConfig r8 = (ProfilePageConfig) r7.getParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY");
    L10:
        if (r8 == null) goto L12;
        String r2 = r8.getFromReqId();
    L13:
        this.y = r2;
        if (r8 == null) goto L16;
        String r3 = r8.getAid();
    L17:
        this.z = r3;
        UserProfileViewModel r4 = W90();
        if (r8 != null) goto L20;
        ProfilePageConfig r9 = new ProfilePageConfig();
    L21:
        r4.initPageConfig(r9);
        if (r8 == null) goto L24;
        boolean r10 = r8.getUselessFollowChannel();
    L25:
        this.p = r10;
        if (r8 == null) goto L28;
        r1 = r8.getAid();
    L28:
        this.q = r1;
        if (r8 == null) goto L33;
        Boolean r11 = r8.isLive();
        if (r11 == null) goto L33;
        boolean r12 = r11.booleanValue();
    L34:
        this.r = r12;
        if (r8 == null) goto L37;
        r0 = r8.getHideRecently();
    L37:
        this.s = r0;
        com.bytedance.awemeopen.apps.framework.utils.c r13 = com.bytedance.awemeopen.apps.framework.utils.c.a;
        this.B = com.bytedance.awemeopen.apps.framework.utils.c.b();
        return;
    L33:
        r12 = false;
        goto L34
    L24:
        r10 = false;
        goto L25
    L20:
        r9 = r8;
        goto L21
    L16:
        r3 = null;
        goto L17
    L12:
        r2 = null;
        goto L13
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    public final void ea0(int r4) {
        DampScrollableLayout r0 = this.j;
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
        FlexibleLifecycleOwner r3 = new FlexibleLifecycleOwner(new C02351(this));
        this.v = r3;
        r3.a(getLifecycle());
    }

    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
    }

    public final void ha0(AosFeedsChannelFragment r3, AosFeedPagerListLayout<?> r4) {
        Intrinsics.checkNotNull(r4);
        ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
        r1.getClass();
        final FeedPagerListViewModel r5 = (FeedPagerListViewModel) new ViewModelProvider(r4, r1).get(r4.m());
        r5.getPalpableIndex().observe(r3, new k(this, r5));
    }
}
