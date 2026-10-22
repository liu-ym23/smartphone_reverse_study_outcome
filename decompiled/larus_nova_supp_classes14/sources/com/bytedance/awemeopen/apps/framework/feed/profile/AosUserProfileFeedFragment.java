package com.bytedance.awemeopen.apps.framework.feed.profile;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.write.WriteCommentEntranceView;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentCommonDataViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.h;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/profile/AosUserProfileFeedFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosFeedPagerListFragment;", "Lcom/bytedance/awemeopen/apps/framework/feed/profile/AosUserProfileFeedFragmentViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosUserProfileFeedFragment extends AosFeedPagerListFragment<AosUserProfileFeedFragmentViewModel> {
    public static final /* synthetic */ int K = 0;
    public final String A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public int E;
    public final com.bytedance.awemeopen.apps.framework.feed.profile.a F;
    public final b G;
    public HostCommonParamProvider H;
    public WriteCommentEntranceView I;
    public final Map<Integer, View> J;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lr14/c;", "invoke", "()Lr14/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass1 extends Lambda implements Function0<r14.c> {
        final /* synthetic */ AosUserProfileFeedFragment this$0;

        public AnonymousClass1(AosUserProfileFeedFragment r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final r14.c m1425invoke() {
            AosUserProfileFeedFragment r0 = this.this$0;
            int r1 = AosUserProfileFeedFragment.K;
            return r0.w;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1425invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.J).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<AosUserProfileFeedFragmentViewModel> da0() {
        return AosUserProfileFeedFragmentViewModel.class;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.awemeopen.apps.framework.feed.profile.b] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.awemeopen.apps.framework.feed.profile.a] */
    public AosUserProfileFeedFragment() {
        this.J = new LinkedHashMap();
        this.A = "AosUserProfileFeedFragment_" + System.currentTimeMillis() + '_' + hashCode();
        this.B = LazyKt.lazy(new AosUserProfileFeedFragment$feedSeekBarHelper$2(this));
        this.C = LazyKt.lazy(new AosUserProfileFeedFragment$videoPreRenderHelper$2(this));
        this.D = LazyKt.lazy(AosUserProfileFeedFragment$feedPageConfig$2.INSTANCE);
        this.F = new com.bytedance.awemeopen.apps.framework.feed.profile.a(this);
        this.G = new b(this);
    }

    public final FeedSeekBarHelper Fa0() {
        return (FeedSeekBarHelper) this.B.getValue();
    }

    public final VideoPreRenderHelper Ga0() {
        return (VideoPreRenderHelper) this.C.getValue();
    }

    public final int Ha0() {
        if (AosExtConfig.b.getCommentConfig().c == false) goto L6;
        Resources r1 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    L6:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        super.Y90();
        Fa0().f();
        VerticalViewPager r0 = pa0();
        r0.c(Fa0());
        r0.c(Ga0());
        AosUserProfileFeedFragmentViewModel r1 = (AosUserProfileFeedFragmentViewModel) W90();
        if (r1 == null) goto L6;
        r1.setFeedSeekBarHelper(Fa0());
    L6:
        d14.a r2 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        r3.H1(this.F);
        r3.H1(this.G);
        this.H = new HostCommonParamProvider(((AosUserProfileFeedFragmentViewModel) W90()).getPageConfig().getHostCommonParams());
        b14.a.a(t24.a.class).H1(this.H);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        super.Z90();
        VerticalViewPager r0 = pa0();
        r0.v(Fa0());
        r0.v(Ga0());
        LiveDataBus r1 = LiveDataBus.c;
        LiveDataBus.a.b(new gz3.e());
        d14.a r2 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        r3.z0(this.F);
        r3.z0(this.G);
        r3.z0(this.H);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void aa0() {
        super.aa0();
        ((AosUserProfileFeedFragmentViewModel) W90()).copyFromTransientDataCache();
        jz3.a r0 = ((AosUserProfileFeedFragmentViewModel) W90()).getFromAweme();
        if (r0 == null) goto L5;
        r14.c r1 = r0.a;
    L6:
        this.w = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        super.initView();
        if (AosExtConfig.b.getCommentConfig().c == false) goto L9;
        View r1 = V90();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        WriteCommentEntranceView r0 = new WriteCommentEntranceView((ViewGroup) r1, new e(this));
        this.I = r0;
        r0.d();
        WriteCommentEntranceView r2 = this.I;
        if (r2 == null) goto L7;
        FragmentActivity r3 = getActivity();
        Intrinsics.checkNotNull(r3);
        r2.f(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r3, V90(), pa0(), this, this, null, 0, 224), true);
    L7:
        V90().post(new c(this));
        ViewGroup.LayoutParams r4 = na0().getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        Resources r6 = Resources.getSystem();
        r5.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        na0().setLayoutParams(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((AosUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().g(com.bytedance.awemeopen.apps.framework.player.d.a);
        com.bytedance.awemeopen.apps.framework.player.d.b(this.A);
        Fa0().g();
        VideoPreRenderHelper r0 = Ga0();
        ((AosUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().g(r0);
        r0.c.clear();
        S90();
    }

    public final void onPause() {
        super.onPause();
        Ga0().b = false;
    }

    public final void onResume() {
        super.onResume();
        Ga0().b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final int ra0() {
        return ((AosUserProfileFeedFragmentViewModel) W90()).initIndex();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final AosPagerListFragment.PullDownType ma0() {
        return AosPagerListFragment.PullDownType.NONE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        V90().post(new d(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment
    public final void Ca0(int r2, jz3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        super.Ca0(r2, r3);
        this.E = r2;
        if (AosExtConfig.b.getCommentConfig().c == false) goto L19;
        CommentInputContentViewModel.Companion.getClass();
        CommentInputContentViewModel r4 = CommentInputContentViewModel.a.a(this);
        if (r4 == null) goto L7;
        r4.resetAweme(r3.a.c());
    L7:
        CommentCommonDataViewModel.Companion.getClass();
        CommentCommonDataViewModel r5 = CommentCommonDataViewModel.a.a(this);
        if (r5 == null) goto L11;
        r5.setCurrentAweme(this.w);
    L11:
        WriteCommentEntranceView r6 = this.I;
        if (r6 == null) goto L15;
        r6.a = r3.a.c();
    L15:
        WriteCommentEntranceView r7 = this.I;
        if (r7 == null) goto L20;
        r7.e();
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment
    public final void Da0(int r4, jz3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.b(new gz3.d(((AosUserProfileFeedFragmentViewModel) W90()).getFromUserOpenId(), ((AosUserProfileFeedFragmentViewModel) W90()).getFromUserProfileType(), r4));
        Fa0().j(r5.a);
        com.bytedance.awemeopen.apps.framework.player.d r6 = com.bytedance.awemeopen.apps.framework.player.d.a;
        com.bytedance.awemeopen.apps.framework.player.d.i(this.A, r5.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final g<jz3.a> ga0(ViewGroup r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "parent");
        int r0 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.a;
        FeedPagerListViewModel r12 = (FeedPagerListViewModel) W90();
        FragmentActivity r13 = getActivity();
        Context r1 = getContext();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        g<jz3.a> r2 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.b(r20, r21, r12, r13, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r1, V90(), r20, this, this, null, Ha0(), 96), Fa0(), Ga0(), (vz3.c) this.D.getValue(), this.A);
        if (r2 != null) goto L6;
        int r3 = h.a;
        FeedPagerListViewModel r10 = (FeedPagerListViewModel) W90();
        FragmentActivity r11 = getActivity();
        Context r4 = getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        return h.b(r20, r21, r10, r11, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b((Activity) r4, V90(), r20, this, this, null, Ha0(), 96), Fa0(), Ga0(), (vz3.c) this.D.getValue());
    L6:
        return r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final int ia0(int r1, jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        int r4 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.a;
        Integer r5 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.b.c(r3.a);
        if (r5 != null) goto L7;
        int r6 = h.a;
        return h.c(r3.a);
    L7:
        return r5.intValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final /* bridge */ /* synthetic */ void ja0(int r1, jz3.a r2) {
        Ca0(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        d14.a r4 = b14.a.a;
        b14.a.a(c34.a.class).i();
        ((AosUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().c(com.bytedance.awemeopen.apps.framework.player.d.a);
        ((AosUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper().c(Ga0());
        com.bytedance.awemeopen.apps.framework.player.d.a(this.A, ((AosUserProfileFeedFragmentViewModel) W90()).getFeedPlayerHelper());
    }
}
