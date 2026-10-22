package com.bytedance.awemeopen.apps.framework.story.profile;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.apps.framework.player.d;
import gz3.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vz3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/story/profile/StoryUserFeedFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosFeedPagerListFragment;", "Lcom/bytedance/awemeopen/apps/framework/story/profile/StoryUserProfileFeedFragmentViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryUserFeedFragment extends AosFeedPagerListFragment<StoryUserProfileFeedFragmentViewModel> {
    public static final /* synthetic */ int E = 0;
    public final String A;
    public final Lazy B;
    public final Lazy C;
    public final Map<Integer, View> D;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.D).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<StoryUserProfileFeedFragmentViewModel> da0() {
        return StoryUserProfileFeedFragmentViewModel.class;
    }

    public StoryUserFeedFragment() {
        this.D = new LinkedHashMap();
        this.A = "StoryUserFeedFragment" + System.currentTimeMillis() + '_' + hashCode();
        this.B = LazyKt.lazy(new StoryUserFeedFragment$feedSeekBarHelper$2(this));
        this.C = LazyKt.lazy(StoryUserFeedFragment$feedPageConfig$2.INSTANCE);
    }

    public final FeedSeekBarHelper Fa0() {
        return (FeedSeekBarHelper) this.B.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        Fa0().f();
        pa0().c(Fa0());
        StoryUserProfileFeedFragmentViewModel r0 = (StoryUserProfileFeedFragmentViewModel) W90();
        if (r0 == null) goto L7;
        r0.setFeedSeekBarHelper(Fa0());
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        super.Z90();
        pa0().v(Fa0());
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void aa0() {
        super.aa0();
        ((StoryUserProfileFeedFragmentViewModel) W90()).copyFromTransientDataCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new t04.a(((StoryUserProfileFeedFragmentViewModel) W90()).getFromUserOpenId(), ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().e().g(), ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().e().getCurrentPosition()));
        ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().g(d.a);
        d.b(this.A);
        Fa0().g();
        S90();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final int ra0() {
        return ((StoryUserProfileFeedFragmentViewModel) W90()).initIndex();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final AosPagerListFragment.PullDownType ma0() {
        return AosPagerListFragment.PullDownType.NONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment
    public final void Ea0(jz3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r5, "model");
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new t04.a(((StoryUserProfileFeedFragmentViewModel) W90()).getFromUserOpenId(), r5.a.c(), ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().e().getCurrentPosition()));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        V90().post(new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment
    public final void Da0(int r3, jz3.a r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new t04.b(((StoryUserProfileFeedFragmentViewModel) W90()).getFromUserOpenId(), r3));
        ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().e().d(1.0f);
        Fa0().j(r4.a);
        d r5 = d.a;
        d.i(this.A, r4.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final g<jz3.a> ga0(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        int r0 = h.a;
        FeedPagerListViewModel r1 = (FeedPagerListViewModel) W90();
        FragmentActivity r10 = getActivity();
        FragmentActivity r2 = getActivity();
        Intrinsics.checkNotNull(r2);
        return h.b(r13, r14, r1, r10, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r2, V90(), r13, this, this, null, 0, 224), Fa0(), new VideoPreRenderHelper(((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().e()), (c) this.C.getValue());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final int ia0(int r1, jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        int r4 = h.a;
        return h.c(r3.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((StoryUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().c(d.a);
    }
}
