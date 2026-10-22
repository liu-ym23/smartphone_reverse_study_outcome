package com.bytedance.awemeopen.apps.framework.feed.home;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.awemeopen.apps.framework.feed.home.presenter.FeedHomePresenter;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosFeedsHomeLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedsChannelFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedsHomePageConfig;
import f04.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k54.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/home/AosFeedsHomeFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerViewModel;", "Ld54/a;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFeedsHomeFragment extends AosBaseFragment<FeedHomeContainerViewModel> implements d54.a {
    public static final /* synthetic */ int k = 0;
    public b<Unit> g;
    public HostCommonParamProvider h;
    public final jz3.b i;
    public final Map<Integer, View> j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.j).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558705;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<FeedHomeContainerViewModel> da0() {
        return FeedHomeContainerViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosFeedsHomeFragment() {
        this.j = new LinkedHashMap();
        jz3.b r0 = new jz3.b();
        r0.a = new AosFeedsHomeFragment$feedListContext$1$1(this);
        this.i = r0;
    }

    public final void N7() {
        b<Unit> r0 = this.g;
        Object r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r0 = null;
    L5:
        FeedHomePresenter r2 = (FeedHomePresenter) r0.g(FeedHomePresenter.class);
        if (r2 == null) goto L28;
        FragmentManager r3 = r2.d.getChildFragmentManager();     // Catch: Throwable -> L9
    L10:
        if (r3 == null) goto L29;
        List r4 = r3.getFragments();
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((Fragment) r6).getClass(), AosFeedsChannelFragment.class) == false) goto L15;
        r1 = r6;
    L19:
        Fragment r7 = (Fragment) r1;
        if (r7 == null) goto L31;
        ((AosFeedsChannelFragment) r7).N7();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void V5() {
        b<Unit> r0 = this.g;
        Object r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r0 = null;
    L5:
        FeedHomePresenter r2 = (FeedHomePresenter) r0.g(FeedHomePresenter.class);
        if (r2 == null) goto L28;
        FragmentManager r3 = r2.d.getChildFragmentManager();     // Catch: Throwable -> L9
    L10:
        if (r3 == null) goto L29;
        List r4 = r3.getFragments();
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((Fragment) r6).getClass(), AosFeedsChannelFragment.class) == false) goto L15;
        r1 = r6;
    L19:
        Fragment r7 = (Fragment) r1;
        if (r7 == null) goto L31;
        ((AosFeedsChannelFragment) r7).V5();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        b<Unit> r0 = new b(V90());
        this.g = r0;
        r0.m(new FeedHomePresenter(V90(), this, W90()));
        b<Unit> r1 = this.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r1 = null;
    L5:
        r1.f(Unit.INSTANCE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        b<Unit> r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r0 = null;
    L5:
        r0.l();
        d14.a r1 = b14.a.a;
        b14.a.a(t24.a.class).z0(this.h);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        b<Unit> r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r0 = null;
    L5:
        FeedHomePresenter r1 = (FeedHomePresenter) r0.g(FeedHomePresenter.class);
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.g.getCurrentItem() != 0) goto L28;
        FragmentManager r2 = r1.d.getChildFragmentManager();     // Catch: Throwable -> L11
    L12:
        if (r2 == null) goto L28;
        List r3 = r2.getFragments();
        if (r3 == null) goto L28;
        Iterator r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Fragment) r5).getClass(), AosFeedsChannelFragment.class) == false) goto L17;
    L22:
        Fragment r6 = (Fragment) r5;
        if (r6 == null) goto L28;
        AosFeedsHomeLayout r7 = ((AosFeedsChannelFragment) r6).S90();
        if (r7 != null) goto L36;
        return null;
    L36:
        return Boolean.valueOf(r7.g());
    L21:
        r5 = null;
    L11:
        r2 = null;
    L28:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void aa0() {
        W90().getDeliveredHiddenChangedState().setValue(Boolean.FALSE);
    }

    public final void RF(final c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        jz3.b r0 = this.i;
        r0.b = new AosFeedsHomeFragment$setFeedPageListener$1(r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r3) {
        FeedHomeContainerViewModel r4 = W90();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        FeedsHomePageConfig r1 = (FeedsHomePageConfig) r0.getParcelable("arguments_AosFeedsHomeFragment");
    L6:
        r4.setFeedsHomePageConfig(r1);
        FeedsHomePageConfig r5 = W90().getFeedsHomePageConfig();
        if (r5 == null) goto L10;
        this.h = new HostCommonParamProvider(r5.getHostCommonParams());
        d14.a r6 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.h);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ea0(int r3) {
        b<Unit> r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenterGroup");
        r0 = null;
    L5:
        FeedHomePresenter r1 = (FeedHomePresenter) r0.g(FeedHomePresenter.class);
        if (r1 == null) goto L9;
        r1.g.y(r3, true);
        return;
    }

    public final void fa0(boolean r2) {
        W90().getScrollable().setValue(Boolean.valueOf(r2));
    }
}
