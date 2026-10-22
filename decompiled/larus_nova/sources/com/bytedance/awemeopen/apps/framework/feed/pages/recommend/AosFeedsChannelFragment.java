package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosFeedsHomeLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosFollowFeedLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosRecommendFeedLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.r;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfigBuilder;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;", "Landroidx/fragment/app/Fragment;", "Ld54/a;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFeedsChannelFragment extends Fragment implements d54.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f195012j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f195013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FeedPageConfig f195014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f195015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f195016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jz3.b f195017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, View> f195018i;

    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosFeedsChannelFragment f195019a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void c() {
            AosFeedsHomeLayout r100 = this.f195019a.S90();
            if (r100 == null) goto L19;
            Fragment r101 = this.f195019a.getParentFragment();
            AosRecommendFeedLayout r102 = r100.f194805t;
            AosFeedsHomeFragment r103 = null;
            if (r102 == null) goto L7;
            AutoPlayHelper r104 = r102.getAutoPlayHelper();
        L9:
            if ((r104 instanceof ViewPager.SimpleOnPageChangeListener) == true) goto L12;
            r104 = null;
        L12:
            if (r104 != null) goto L14;
            return;
        L14:
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L16;
            r103 = (AosFeedsHomeFragment) r101;
        L16:
            if (r103 == null) goto L21;
            Intrinsics.checkNotNullParameter(r104, "listener");
            ((RtlViewPager) r103.findViewById(R.id.ao_feed_viewpage)).v(r104);
            return;
        L21:
            return;
        L7:
            r104 = null;
            goto L9
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void d() {
            Fragment r100 = this.f195019a.getParentFragment();
            AosFeedsHomeFragment r101 = null;
            if ((r100 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r100;
        L6:
            if (r102 == null) goto L10;
            FeedHomeContainerViewModel r103 = r102.W90();
            if (r103 == null) goto L10;
            r103.updateStartEnteringToProfile(FeedHomeContainerViewModel.EnterProfileStyle.ClickHeadToEnter);
        L10:
            Fragment r104 = this.f195019a.getParentFragment();
            if ((r104 instanceof AosFeedsHomeFragment) == false) goto L13;
            r101 = (AosFeedsHomeFragment) r104;
        L13:
            if (r101 == null) goto L16;
            r101.ea0(1);
            return;
        L16:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final boolean e() {
            Fragment r100 = this.f195019a.getParentFragment();
            AosFeedsHomeFragment r101 = null;
            if ((r100 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r100;
        L6:
            if (r102 == null) goto L10;
            Boolean r103 = r102.W90().getScrollable().getValue();
            if (r103 == null) goto L10;
            boolean r104 = r103.booleanValue();
        L11:
            Fragment r105 = this.f195019a.getParentFragment();
            if ((r105 instanceof AosFeedsHomeFragment) == false) goto L14;
            r101 = (AosFeedsHomeFragment) r105;
        L14:
            if (r101 == null) goto L16;
            r101.fa0(false);
        L16:
            return r104;
        L10:
            r104 = true;
            goto L11
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void k() {
            Fragment r100 = this.f195019a.getParentFragment();
            if ((r100 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r101 = (AosFeedsHomeFragment) r100;
        L6:
            if (r101 == null) goto L9;
            r101.ea0(0);
            return;
        L9:
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void onBind() {
            Fragment r100 = this.f195019a.getParentFragment();
            AutoPlayHelper r101 = null;
            if ((r100 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r100;
        L6:
            if (r102 == null) goto L8;
            final AosFeedsChannelFragment r103 = this.f195019a;
            ViewModelProviderFactory r104 = ViewModelProviderFactory.f196951a;
            r104.getClass();
            FeedHomeContainerViewModel r105 = (FeedHomeContainerViewModel) new ViewModelProvider(r102, r104).get(FeedHomeContainerViewModel.class);
            r105.getSelectedIndex().observe(r102, new h(r103));
            r105.getDeliveredHiddenChangedState().observe(r102, new i(r103));
        L8:
            Fragment r106 = this.f195019a.getParentFragment();
            if ((r106 instanceof AosFeedsHomeFragment) == false) goto L11;
            AosFeedsHomeFragment r107 = (AosFeedsHomeFragment) r106;
        L12:
            if (r107 == null) goto L30;
            AosFeedsChannelFragment r108 = this.f195019a;
            r107.fa0(false);
            AosFeedsHomeLayout r109 = r108.S90();
            if (r109 == null) goto L31;
            Fragment r110 = r108.getParentFragment();
            if ((r110 instanceof AosFeedsHomeFragment) == false) goto L18;
            AosFeedsHomeFragment r111 = (AosFeedsHomeFragment) r110;
        L19:
            if (r111 == null) goto L32;
            r111.fa0(false);
            AosRecommendFeedLayout r112 = r109.f194805t;
            if (r112 == null) goto L23;
            AutoPlayHelper r113 = r112.getAutoPlayHelper();
        L25:
            if ((r113 instanceof ViewPager.SimpleOnPageChangeListener) == false) goto L27;
            r101 = r113;
        L27:
            if (r101 == null) goto L33;
            Intrinsics.checkNotNullParameter(r101, "listener");
            ((RtlViewPager) r111.findViewById(R.id.ao_feed_viewpage)).b(r101);
            return;
        L33:
            return;
        L23:
            r113 = null;
            goto L25
        L32:
            return;
        L18:
            r111 = null;
            goto L19
        L31:
            return;
        L30:
            return;
        L11:
            r107 = null;
            goto L12
        L5:
            r102 = null;
            goto L6
        }

        public a(AosFeedsChannelFragment r100) {
            this.f195019a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void f(boolean r100) {
            Fragment r101 = this.f195019a.getParentFragment();
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r101;
        L6:
            if (r102 == null) goto L9;
            r102.fa0(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void g(boolean r100) {
            Fragment r101 = this.f195019a.getParentFragment();
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r101;
        L6:
            if (r102 == null) goto L9;
            r102.W90().getEnableSwipeLeft().setValue(Boolean.valueOf(r100));
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void h(boolean r100) {
            Fragment r101 = this.f195019a.getParentFragment();
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r101;
        L6:
            if (r102 == null) goto L9;
            r102.W90().getEnableSwipeRight().setValue(Boolean.valueOf(r100));
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void i(boolean r100) {
            Fragment r101 = this.f195019a.getParentFragment();
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r101;
        L6:
            if (r102 == null) goto L9;
            r102.fa0(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void j(boolean r100) {
            Fragment r101 = this.f195019a.getParentFragment();
            if ((r101 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r102 = (AosFeedsHomeFragment) r101;
        L6:
            if (r102 == null) goto L9;
            r102.fa0(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    @Override // n44.a
    public final Fragment f() {
        return this;
    }

    public AosFeedsChannelFragment() {
        this.f195018i = new LinkedHashMap();
        this.f195013d = LazyKt.lazy(new AosFeedsChannelFragment$feedsHomeLayout$2(this));
    }

    public final AosFeedsHomeLayout S90() {
        return (AosFeedsHomeLayout) this.f195013d.getValue();
    }

    @Override // d54.a
    public final void N7() {
        AosFeedsHomeLayout r100 = S90();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.r() == false) goto L7;
    L12:
        View r101 = (View) ListProtector.get(r100.f194803r, r100.getCurrentSeletecdIndex());
        if ((r101 instanceof AosRecommendFeedLayout) == false) goto L16;
        ((AosRecommendFeedLayout) r101).B();
        return;
    L16:
        if ((r101 instanceof AosFollowFeedLayout) == false) goto L23;
        ((AosFollowFeedLayout) r101).B();
        return;
    L23:
        return;
    L7:
        if (r100.s() == true) goto L12;
        AosRecommendFeedLayout r102 = r100.f194805t;
        if (r102 == null) goto L20;
        r102.B();
        return;
    }

    @Override // d54.a
    public final void V5() {
        AosFeedsHomeLayout r100 = S90();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.r() == false) goto L7;
    L12:
        View r101 = (View) ListProtector.get(r100.f194803r, r100.getCurrentSeletecdIndex());
        if ((r101 instanceof AosRecommendFeedLayout) == false) goto L16;
        ((AosRecommendFeedLayout) r101).Z();
        return;
    L16:
        if ((r101 instanceof AosFollowFeedLayout) == false) goto L23;
        ((AosFollowFeedLayout) r101).Z();
        return;
    L23:
        return;
    L7:
        if (r100.s() == true) goto L12;
        AosRecommendFeedLayout r102 = r100.f194805t;
        if (r102 == null) goto L20;
        r102.Z();
        return;
    }

    @Override // n44.a
    public final Boolean onBackPressed() {
        AosFeedsHomeLayout r100 = S90();
        if (r100 == null) goto L5;
        boolean r101 = r100.g();
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        int r100 = j64.b.f497514a;
        ((AoHostService) j64.b.a(AoHostService.class)).D();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f195018i).clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    @Override // d54.a
    public final void RF(final k54.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (getContext() == null) goto L8;
        AosFeedsHomeLayout r101 = S90();
        if (r101 == null) goto L8;
        r101.setFeedPageListener(r100);
    L8:
        if (this.f195017h != null) goto L10;
        this.f195017h = new jz3.b();
    L10:
        jz3.b r102 = this.f195017h;
        if (r102 == null) goto L15;
        r102.f501182b = new AosFeedsChannelFragment$setFeedPageListener$1(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == false) goto L6;
        int r101 = j64.b.f497514a;
        ((AoHostService) j64.b.a(AoHostService.class)).g1();
    L6:
        if (this.f195015f == false) goto L11;
        AosFeedsHomeLayout r102 = S90();
        if (r102 == null) goto L12;
        r102.t(Boolean.valueOf(!r100));
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FrameLayout r102 = (FrameLayout) r100.findViewById(R.id.feed_layout);
        View r103 = r100.findViewById(R.id.publish_insert);
        this.f195016g = r103;
        if (r103 == null) goto L5;
        r103.setOnClickListener(new g());
    L5:
        AosFeedsHomeLayout r104 = S90();
        if (r104 == null) goto L8;
        Bundle r105 = new Bundle();
        r105.putParcelable(FeedPageConfigBuilder.CONFIG_KEY, this.f195014e);
        r104.setArguments(r105);
    L8:
        AosFeedsHomeLayout r106 = S90();
        if (r106 == null) goto L12;
        r106.setRecommendFeedListener(new a(this));
    L12:
        AosFeedsHomeLayout r107 = S90();
        if (r107 == null) goto L16;
        r107.setViewModelStoreOwner(this);
    L16:
        AosFeedsHomeLayout r108 = S90();
        if (r108 == null) goto L19;
        r108.b();
    L19:
        AosFeedsHomeLayout r109 = S90();
        if (r109 == null) goto L22;
        r102.addView(r109.getView());
        getLifecycle().addObserver(r109);
    L22:
        this.f195015f = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.aos_fragment_feed_rec, r101, false);
        Bundle r104 = getArguments();
        if (r104 == null) goto L6;
        FeedPageConfig r105 = (FeedPageConfig) r104.getParcelable(FeedPageConfigBuilder.CONFIG_KEY);
        if (r105 == null) goto L6;
    L7:
        this.f195014e = r105;
        return r103;
    L6:
        r105 = new FeedPageConfig();
        goto L7
    }
}
