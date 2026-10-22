package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeFeedFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosFeedPagerListFragment;", "Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeFeedViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeFeedFragment extends AosFeedPagerListFragment<MixAwemeFeedViewModel> {
    public static final /* synthetic */ int L = 0;
    public final String A;
    public long B;
    public String C;
    public final Lazy D;
    public final Lazy E;
    public final c F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final d J;
    public final Map<Integer, View> K;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeFeedFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lr14/c;", "invoke", "()Lr14/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function0<r14.c> {
        final /* synthetic */ MixAwemeFeedFragment this$0;

        public AnonymousClass1(MixAwemeFeedFragment r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final r14.c m1337invoke() {
            MixAwemeFeedFragment r0 = this.this$0;
            int r1 = MixAwemeFeedFragment.L;
            return r0.w;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1337invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.K).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<MixAwemeFeedViewModel> da0() {
        return MixAwemeFeedViewModel.class;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.bytedance.awemeopen.apps.framework.feed.mix.d] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.awemeopen.apps.framework.feed.mix.c] */
    public MixAwemeFeedFragment() {
        this.K = new LinkedHashMap();
        this.A = "MixAwemeFeedFragment_" + System.currentTimeMillis() + '_' + hashCode();
        this.B = -1;
        this.C = "";
        this.D = LazyKt.lazy(new MixAwemeFeedFragment$feedSeekBarHelper$2(this));
        this.E = LazyKt.lazy(new MixAwemeFeedFragment$videoPreRenderHelper$2(this));
        this.F = new c(this);
        this.G = LazyKt.lazy(MixAwemeFeedFragment$feedPageConfig$2.INSTANCE);
        this.H = LazyKt.lazy(new MixAwemeFeedFragment$sendPlayPosition$2(this));
        this.I = LazyKt.lazy(new MixAwemeFeedFragment$autoPlayHelper$2(this));
        this.J = new d(this);
    }

    public final FeedSeekBarHelper Ga0() {
        return (FeedSeekBarHelper) this.D.getValue();
    }

    public final VideoPreRenderHelper Ha0() {
        return (VideoPreRenderHelper) this.E.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).L(this.C);
        b14.a.a(t24.a.class).H1(this.J);
        Ga0().f();
        VerticalViewPager r1 = pa0();
        r1.c(Ga0());
        r1.c(Ha0());
        r1.c((AutoPlayHelper) this.I.getValue());
        MixAwemeFeedViewModel r2 = (MixAwemeFeedViewModel) W90();
        if (r2 == null) goto L6;
        r2.setFeedSeekBarHelper(Ga0());
    L6:
        ((MixAwemeFeedViewModel) W90()).getMixInfoLiveData().observe(this, new e(this));
        ((MixAwemeFeedViewModel) W90()).getSelectedIndex().observe(this, new f(this));
        ((MixAwemeFeedViewModel) W90()).getLoading().observe(this, new g(this));
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L9;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r3).getItemClick().observe(r3, new h(this));
        MixAwemeListDialogViewModel.a.a(r3).isLoadingMore().observe(r3, new i(this));
        MixAwemeListDialogViewModel.a.a(r3).isLoadingForward().observe(r3, new j(this));
    L9:
        MixAwemeFeedViewModel r4 = (MixAwemeFeedViewModel) W90();
        AutoPlayHelper r5 = (AutoPlayHelper) this.I.getValue();
        r5.e.observe(this, this.F);
        r4.setAutoPlayHelper(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        super.Z90();
        VerticalViewPager r0 = pa0();
        r0.v(Ga0());
        r0.v(Ha0());
        r0.v((AutoPlayHelper) this.I.getValue());
        AutoPlayHelper r1 = ((MixAwemeFeedViewModel) W90()).getAutoPlayHelper();
        if (r1 == null) goto L7;
        MutableLiveData<Integer> r2 = r1.e;
        if (r2 == null) goto L7;
        r2.removeObserver(this.F);
    L7:
        AutoPlayHelper r3 = ((MixAwemeFeedViewModel) W90()).getAutoPlayHelper();
        if (r3 == null) goto L10;
        r3.b();
    L10:
        d14.a r4 = b14.a.a;
        b14.a.a(t24.a.class).L("");
        b14.a.a(t24.a.class).z0(this.J);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void aa0() {
        super.aa0();
        ((MixAwemeFeedViewModel) W90()).copyFromTemp();
        MixAwemeFeedViewModel r0 = (MixAwemeFeedViewModel) W90();
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getString("mixId");
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.setMixId(r3);
        MixAwemeFeedViewModel r5 = (MixAwemeFeedViewModel) W90();
        Bundle r6 = getArguments();
        if (r6 == null) goto L12;
        int r7 = r6.getInt("currentEpisode");
    L13:
        r5.setCurrentEpisode(r7);
        Bundle r8 = getArguments();
        long r9 = -1;
        if (r8 == null) goto L16;
        long r10 = r8.getLong("currentPosition");
    L17:
        this.B = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L20;
        r9 = r11.getLong("currentPosition");
    L20:
        this.B = r9;
        Bundle r12 = getArguments();
        if (r12 == null) goto L23;
        r2 = r12.getString("scene_id_enter_from");
    L23:
        if (r2 == null) goto L26;
        r4 = r2;
    L26:
        this.C = r4;
        return;
    L16:
        r10 = -1;
        goto L17
    L12:
        r7 = 0;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((MixAwemeFeedViewModel) W90()).getFeedPlayerHelper().g(com.bytedance.awemeopen.apps.framework.player.d.a);
        com.bytedance.awemeopen.apps.framework.player.d.b(this.A);
        Ga0().g();
        VideoPreRenderHelper r0 = Ha0();
        ((MixAwemeFeedViewModel) W90()).getFeedPlayerHelper().g(r0);
        r0.c.clear();
        this.H.getValue();
        Unit r1 = Unit.INSTANCE;
        S90();
    }

    public final void onPause() {
        super.onPause();
        Ha0().b = false;
    }

    public final void onResume() {
        super.onResume();
        Ha0().b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void sa0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r0).isLoadingForward().setValue(Boolean.FALSE);
        MixAwemeListDialogViewModel.a.a(r0).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        zx3.a.a(r0).d();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void ua0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r0).isLoadingMore().setValue(Boolean.FALSE);
        MixAwemeListDialogViewModel.a.a(r0).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        zx3.a.a(r0).d();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final AosPagerListFragment.PullDownType ma0() {
        return AosPagerListFragment.PullDownType.LOAD_FORWARD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MixAwemeFeedViewModel Fa0(MixAwemeFeedFragment r0) {
        return (MixAwemeFeedViewModel) r0.W90();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        V90().post(new k(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void wa0(boolean r3) {
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MutableLiveData<Boolean> r0 = MixAwemeListDialogViewModel.a.a(r4).isLoadingMore();
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        MixAwemeListDialogViewModel.a.a(r4).isLoadingForward().setValue(r1);
        MixAwemeListDialogViewModel.a.a(r4).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        zx3.a.a(r4).d();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment
    public final void Da0(int r2, jz3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Ga0().j(r3.a);
        com.bytedance.awemeopen.apps.framework.player.d r4 = com.bytedance.awemeopen.apps.framework.player.d.a;
        com.bytedance.awemeopen.apps.framework.player.d.i(this.A, r3.a);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> ga0(ViewGroup r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "parent");
        g54.b r11 = AosExtConfig.b.p2();
        LayoutInflater r0 = LayoutInflater.from(getContext());
        int r1 = VideoFeedViewHolder.p;
        View r14 = r11.a(r0.inflate(2131558665, r19, false));
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r15 = (com.bytedance.awemeopen.apps.framework.framework.viewpager.o) W90();
        FragmentActivity r16 = getActivity();
        FragmentActivity r2 = getActivity();
        Intrinsics.checkNotNull(r2);
        return new VideoFeedViewHolder(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r14, r19, r15, r16, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r2, V90(), r19, this, this, null, 0, 224), r11, (vz3.c) this.G.getValue(), MixAwemeFeedFragment$aosCreateViewHolder$1.INSTANCE), Ga0(), new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p(), Ha0(), new MixAwemeFeedFragment$aosCreateViewHolder$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final int ia0(int r1, jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        d14.a r4 = b14.a.a;
        b14.a.a(c34.a.class).i();
        ((MixAwemeFeedViewModel) W90()).getFeedPlayerHelper().c(com.bytedance.awemeopen.apps.framework.player.d.a);
        ((MixAwemeFeedViewModel) W90()).getFeedPlayerHelper().c(Ha0());
        com.bytedance.awemeopen.apps.framework.player.d.a(this.A, ((MixAwemeFeedViewModel) W90()).getFeedPlayerHelper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void ta0(List<jz3.a> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r4).setCanShowLoadForward(r3);
        MixAwemeListDialogViewModel.a.a(r4).isLoadingForward().setValue(Boolean.FALSE);
        MixAwemeListDialogViewModel.a.a(r4).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void va0(List<jz3.a> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r1, "data");
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r4).setCanShowLoadMore(r2);
        MixAwemeListDialogViewModel.a.a(r4).isLoadingMore().setValue(Boolean.FALSE);
        MixAwemeListDialogViewModel.a.a(r4).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void xa0(List<jz3.a> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.xa0(r2, r3, r4);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L6;
        MixAwemeListDialogViewModel.Companion.getClass();
        MixAwemeListDialogViewModel.a.a(r5).setCanShowLoadMore(r4);
        MutableLiveData<Boolean> r6 = MixAwemeListDialogViewModel.a.a(r5).isLoadingMore();
        Boolean r0 = Boolean.FALSE;
        r6.setValue(r0);
        MixAwemeListDialogViewModel.a.a(r5).setCanShowLoadForward(r3);
        MixAwemeListDialogViewModel.a.a(r5).isLoadingForward().setValue(r0);
        MixAwemeListDialogViewModel.a.a(r5).getDataList().setValue(((MixAwemeFeedViewModel) W90()).getDataList().getValue());
        return;
    }
}
