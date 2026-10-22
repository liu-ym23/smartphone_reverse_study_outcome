package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
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
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedsChannelFragment;", "Landroidx/fragment/app/Fragment;", "Ld54/a;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFeedsChannelFragment extends Fragment implements d54.a {
    public static final /* synthetic */ int j = 0;
    public final Lazy d;
    public FeedPageConfig e;
    public boolean f;
    public View g;
    public jz3.b h;
    public final Map<Integer, View> i;

    public static final class a implements r {
        public final /* synthetic */ AosFeedsChannelFragment a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void c() {
            AosFeedsHomeLayout r0 = this.a.S90();
            if (r0 == null) goto L19;
            Fragment r1 = this.a.getParentFragment();
            AosRecommendFeedLayout r2 = r0.t;
            AosFeedsHomeFragment r3 = null;
            if (r2 == null) goto L7;
            AutoPlayHelper r4 = r2.getAutoPlayHelper();
        L9:
            if ((r4 instanceof ViewPager.SimpleOnPageChangeListener) == true) goto L12;
            r4 = null;
        L12:
            if (r4 != null) goto L14;
            return;
        L14:
            if ((r1 instanceof AosFeedsHomeFragment) == false) goto L16;
            r3 = (AosFeedsHomeFragment) r1;
        L16:
            if (r3 == null) goto L21;
            Intrinsics.checkNotNullParameter(r4, "listener");
            ((RtlViewPager) r3.findViewById(2131363039)).v(r4);
            return;
        L21:
            return;
        L7:
            r4 = null;
            goto L9
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void d() {
            Fragment r0 = this.a.getParentFragment();
            AosFeedsHomeFragment r2 = null;
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L10;
            FeedHomeContainerViewModel r3 = r1.W90();
            if (r3 == null) goto L10;
            r3.updateStartEnteringToProfile(FeedHomeContainerViewModel.EnterProfileStyle.ClickHeadToEnter);
        L10:
            Fragment r4 = this.a.getParentFragment();
            if ((r4 instanceof AosFeedsHomeFragment) == false) goto L13;
            r2 = (AosFeedsHomeFragment) r4;
        L13:
            if (r2 == null) goto L16;
            r2.ea0(1);
            return;
        L16:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final boolean e() {
            Fragment r0 = this.a.getParentFragment();
            AosFeedsHomeFragment r2 = null;
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L10;
            Boolean r3 = (Boolean) r1.W90().getScrollable().getValue();
            if (r3 == null) goto L10;
            boolean r4 = r3.booleanValue();
        L11:
            Fragment r5 = this.a.getParentFragment();
            if ((r5 instanceof AosFeedsHomeFragment) == false) goto L14;
            r2 = (AosFeedsHomeFragment) r5;
        L14:
            if (r2 == null) goto L16;
            r2.fa0(false);
        L16:
            return r4;
        L10:
            r4 = true;
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void k() {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.ea0(0);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void onBind() {
            LifecycleOwner r0 = this.a.getParentFragment();
            AutoPlayHelper r2 = null;
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L8;
            final AosFeedsChannelFragment r3 = this.a;
            ViewModelProviderFactory r4 = ViewModelProviderFactory.a;
            r4.getClass();
            FeedHomeContainerViewModel r5 = (FeedHomeContainerViewModel) new ViewModelProvider(r1, r4).get(FeedHomeContainerViewModel.class);
            r5.getSelectedIndex().observe(r1, new h(r3));
            r5.getDeliveredHiddenChangedState().observe(r1, new i(r3));
        L8:
            Fragment r6 = this.a.getParentFragment();
            if ((r6 instanceof AosFeedsHomeFragment) == false) goto L11;
            AosFeedsHomeFragment r7 = (AosFeedsHomeFragment) r6;
        L12:
            if (r7 == null) goto L30;
            AosFeedsChannelFragment r8 = this.a;
            r7.fa0(false);
            AosFeedsHomeLayout r9 = r8.S90();
            if (r9 == null) goto L31;
            Fragment r10 = r8.getParentFragment();
            if ((r10 instanceof AosFeedsHomeFragment) == false) goto L18;
            AosFeedsHomeFragment r11 = (AosFeedsHomeFragment) r10;
        L19:
            if (r11 == null) goto L32;
            r11.fa0(false);
            AosRecommendFeedLayout r12 = r9.t;
            if (r12 == null) goto L23;
            AutoPlayHelper r13 = r12.getAutoPlayHelper();
        L25:
            if ((r13 instanceof ViewPager.SimpleOnPageChangeListener) == false) goto L27;
            r2 = r13;
        L27:
            if (r2 == null) goto L33;
            Intrinsics.checkNotNullParameter(r2, "listener");
            ((RtlViewPager) r11.findViewById(2131363039)).b(r2);
            return;
        L33:
            return;
        L23:
            r13 = null;
            goto L25
        L32:
            return;
        L18:
            r11 = null;
            goto L19
        L31:
            return;
        L30:
            return;
        L11:
            r7 = null;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public a(AosFeedsChannelFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void f(boolean r3) {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.fa0(r3);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void g(boolean r3) {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.W90().getEnableSwipeLeft().setValue(Boolean.valueOf(r3));
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void h(boolean r3) {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.W90().getEnableSwipeRight().setValue(Boolean.valueOf(r3));
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void i(boolean r3) {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.fa0(r3);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.layout.r
        public final void j(boolean r3) {
            Fragment r0 = this.a.getParentFragment();
            if ((r0 instanceof AosFeedsHomeFragment) == false) goto L5;
            AosFeedsHomeFragment r1 = (AosFeedsHomeFragment) r0;
        L6:
            if (r1 == null) goto L9;
            r1.fa0(r3);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public final Fragment f() {
        return this;
    }

    public AosFeedsChannelFragment() {
        this.i = new LinkedHashMap();
        this.d = LazyKt.lazy(new AosFeedsChannelFragment$feedsHomeLayout$2(this));
    }

    public final AosFeedsHomeLayout S90() {
        return (AosFeedsHomeLayout) this.d.getValue();
    }

    public final void N7() {
        AosFeedsHomeLayout r0 = S90();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.r() == false) goto L7;
    L12:
        View r1 = (View) ListProtector.get(r0.r, r0.getCurrentSeletecdIndex());
        if ((r1 instanceof AosRecommendFeedLayout) == false) goto L16;
        ((AosRecommendFeedLayout) r1).B();
        return;
    L16:
        if ((r1 instanceof AosFollowFeedLayout) == false) goto L23;
        ((AosFollowFeedLayout) r1).B();
        return;
    L23:
        return;
    L7:
        if (r0.s() == true) goto L12;
        AosRecommendFeedLayout r2 = r0.t;
        if (r2 == null) goto L20;
        r2.B();
        return;
    }

    public final void V5() {
        AosFeedsHomeLayout r0 = S90();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.r() == false) goto L7;
    L12:
        View r1 = (View) ListProtector.get(r0.r, r0.getCurrentSeletecdIndex());
        if ((r1 instanceof AosRecommendFeedLayout) == false) goto L16;
        ((AosRecommendFeedLayout) r1).Z();
        return;
    L16:
        if ((r1 instanceof AosFollowFeedLayout) == false) goto L23;
        ((AosFollowFeedLayout) r1).Z();
        return;
    L23:
        return;
    L7:
        if (r0.s() == true) goto L12;
        AosRecommendFeedLayout r2 = r0.t;
        if (r2 == null) goto L20;
        r2.Z();
        return;
    }

    public final Boolean onBackPressed() {
        AosFeedsHomeLayout r0 = S90();
        if (r0 == null) goto L5;
        boolean r1 = r0.g();
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        int r0 = j64.b.a;
        j64.b.a(AoHostService.class).D();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.i).clear();
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onStop() {
        super.onStop();
    }

    public final void RF(final k54.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (getContext() == null) goto L8;
        AosFeedsHomeLayout r0 = S90();
        if (r0 == null) goto L8;
        r0.setFeedPageListener(r3);
    L8:
        if (this.h != null) goto L10;
        this.h = new jz3.b();
    L10:
        jz3.b r1 = this.h;
        if (r1 == null) goto L15;
        r1.b = new AosFeedsChannelFragment$setFeedPageListener$1(r3);
        return;
    }

    public final void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        if (r2 == false) goto L6;
        int r0 = j64.b.a;
        j64.b.a(AoHostService.class).g1();
    L6:
        if (this.f == false) goto L11;
        AosFeedsHomeLayout r1 = S90();
        if (r1 == null) goto L12;
        r1.t(Boolean.valueOf(!r2));
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FrameLayout r6 = (FrameLayout) r4.findViewById(2131372240);
        View r7 = r4.findViewById(2131383429);
        this.g = r7;
        if (r7 == null) goto L5;
        r7.setOnClickListener(new g());
    L5:
        AosFeedsHomeLayout r8 = S90();
        if (r8 == null) goto L8;
        Bundle r0 = new Bundle();
        r0.putParcelable("FEED_PAGE_CONFIG_CONFIG_KEY", this.e);
        r8.setArguments(r0);
    L8:
        AosFeedsHomeLayout r9 = S90();
        if (r9 == null) goto L12;
        r9.setRecommendFeedListener(new a(this));
    L12:
        AosFeedsHomeLayout r10 = S90();
        if (r10 == null) goto L16;
        r10.setViewModelStoreOwner(this);
    L16:
        AosFeedsHomeLayout r11 = S90();
        if (r11 == null) goto L19;
        r11.b();
    L19:
        AosFeedsHomeLayout r12 = S90();
        if (r12 == null) goto L22;
        r6.addView(r12.getView());
        getLifecycle().addObserver(r12);
    L22:
        this.f = true;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131558647, r3, false);
        Bundle r6 = getArguments();
        if (r6 == null) goto L6;
        FeedPageConfig r7 = (FeedPageConfig) r6.getParcelable("FEED_PAGE_CONFIG_CONFIG_KEY");
        if (r7 == null) goto L6;
    L7:
        this.e = r7;
        return r5;
    L6:
        r7 = new FeedPageConfig();
        goto L7
    }
}
