package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.AccountUsageHintHelper;
import com.bytedance.awemeopen.apps.framework.utils.IconSettingUtils;
import com.bytedance.awemeopen.apps.framework.utils.c0;
import com.bytedance.awemeopen.apps.framework.utils.z;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosFeedPagerListFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListFragment;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/utils/z;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosFeedPagerListFragment<VM extends FeedPagerListViewModel> extends AosPagerListFragment<jz3.a, VM> implements z {
    public static final /* synthetic */ int z = 0;
    public r14.c w;
    public final com.bytedance.awemeopen.apps.framework.utils.audio.a x;
    public final Map<Integer, View> y;

    public abstract void Da0(int r1, jz3.a r2);

    public void Ea0(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void S90() {
        ((LinkedHashMap) this.y).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558648;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public void wa0(boolean r1) {
    }

    public AosFeedPagerListFragment() {
        this.y = new LinkedHashMap();
        this.x = new com.bytedance.awemeopen.apps.framework.utils.audio.a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Y90() {
        super.Y90();
        boolean r0 = W90().getPageConfig().getShowBackButton();
        View r1 = findViewById(2131372213);
        if (r1 == null) goto L8;
        if (r0 == false) goto L7;
        x54.b.d(r1);
        r1.setOnClickListener(new e(this));
        goto L8
    L7:
        x54.b.a(r1);
    L8:
        LifecycleOwner r2 = getParentFragment();
        Drawable r3 = null;
        if ((r2 instanceof AosFeedsHomeFragment) == false) goto L11;
        AosFeedsHomeFragment r4 = (AosFeedsHomeFragment) r2;
    L12:
        if (r4 == null) goto L18;
        ViewModelProviderFactory r5 = ViewModelProviderFactory.a;
        r5.getClass();
        FeedHomeContainerViewModel r6 = (FeedHomeContainerViewModel) new ViewModelProvider(r4, r5).get(FeedHomeContainerViewModel.class);
        if (r6 == null) goto L18;
        LiveData<Integer> r7 = r6.getSelectedIndex();
        if (r7 == null) goto L18;
        r7.observe(r4, new c(this));
    L18:
        LifecycleOwner r8 = getParentFragment();
        if ((r8 instanceof AosFeedsHomeFragment) == false) goto L21;
        AosFeedsHomeFragment r9 = (AosFeedsHomeFragment) r8;
    L22:
        if (r9 == null) goto L28;
        ViewModelProviderFactory r10 = ViewModelProviderFactory.a;
        r10.getClass();
        FeedHomeContainerViewModel r11 = (FeedHomeContainerViewModel) new ViewModelProvider(r9, r10).get(FeedHomeContainerViewModel.class);
        if (r11 == null) goto L28;
        DiscardFirstValueLiveData<Boolean> r12 = r11.getDeliveredHiddenChangedState();
        if (r12 == null) goto L28;
        r12.observe(r9, new d(this));
    L28:
        W90().getFeedPlayerHelper().c(new f(this));
        ImageView r13 = (ImageView) findViewById(2131363758);
        if (r13 != null) goto L32;
    L67:
        W90().getEnterCleanMode().observe(this, new b(this));
        Context r14 = getContext();
        if (r14 == null) goto L71;
        String[] r15 = c0.a;
        c0.b(r14, this);
        return;
    L71:
        return;
    L32:
        if (((Boolean) IconSettingUtils.b.getValue()).booleanValue() == false) goto L36;
        Context r16 = getContext();
        if (r16 == null) goto L39;
        r3 = r16.getDrawable(2131231431);
    L39:
        r13.setImageDrawable(r3);
        boolean r17 = true;
        int r18 = 0;
        if (IconSettingUtils.a() != (-1)) goto L49;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == false) goto L44;
    L50:
        boolean r19 = true;
    L52:
        r14.c r20 = this.w;
        if (r20 != null) goto L55;
    L57:
        boolean r21 = false;
    L58:
        if (r21 == true) goto L64;
        if (r19 == true) goto L64;
        if (((Boolean) IconSettingUtils.a.getValue()).booleanValue() == true) goto L64;
        r17 = false;
    L64:
        if (r17 == false) goto L66;
        r18 = 8;
    L66:
        r13.setVisibility(r18);
        goto L67
    L55:
        if (r20.W() != true) goto L57;
        r21 = true;
        goto L58
    L44:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.h == true) goto L50;
        if (W90().getEnableFollowChannel() == true) goto L50;
    L51:
        r19 = false;
        goto L52
    L49:
        if (IconSettingUtils.a() != 0) goto L51;
    L36:
        Context r22 = getContext();
        if (r22 == null) goto L39;
        r3 = r22.getDrawable(2131231432);
        goto L39
    L21:
        r9 = null;
        goto L22
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Z90() {
        super.Z90();
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String[] r1 = c0.a;
        c0.c(r0, this);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void aa0() {
        W90().getFeedHomeContainerDeliverHiddenState().setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.z
    public final void M00(String r3) {
        Intrinsics.checkNotNullParameter(r3, "filePath");
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L6;
        AosEventReporter r4 = AosEventReporter.a;
        VM r0 = W90();
        r14.c r1 = this.w;
        r4.getClass();
        AosEventReporter.P(r0, r1);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r2) {
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        FeedPageConfig r4 = (FeedPageConfig) r3.getParcelable("FEED_PAGE_CONFIG_CONFIG_KEY");
    L6:
        if (r4 != null) goto L8;
        r4 = new FeedPageConfig();
        r4.setShowBackButton(true);
    L8:
        W90().initPageConfig(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void Ca0(int r7, jz3.a r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        r14.c r0 = this.w;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        Da0(r7, r8);
    L9:
        this.w = r8.a;
        return;
    L5:
        if (r0.c != r8.a.c) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final boolean ha0(jz3.a r4, g<jz3.a> r5) {
        jz3.a r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        jz3.a r7 = r5.b;
        if (r7 == null) goto L9;
        r14.c r8 = r7.a;
        if (r8 == null) goto L9;
        if (r6.a.c != r8.c) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public /* bridge */ /* synthetic */ void ja0(int r1, jz3.a r2) {
        Ca0(r1, r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public final void ka0(int r5, jz3.a r6) {
        jz3.a r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "model");
        ListState r0 = (ListState) W90().getDataList().getValue();
        Long r1 = null;
        if (r0 == null) goto L9;
        List r2 = (List) r0.a;
        if (r2 == null) goto L9;
        jz3.a r8 = (jz3.a) CollectionsKt.getOrNull(r2, r5);
        if (r8 == null) goto L9;
        r14.c r9 = r8.a;
    L10:
        r14.c r3 = this.w;
        if (r3 == null) goto L13;
        Long r4 = Long.valueOf(r3.c);
    L14:
        if (r9 == null) goto L17;
        r1 = Long.valueOf(r9.c);
    L17:
        if (Intrinsics.areEqual(r4, r1) == false) goto L20;
        Ea0(r7);
        return;
    L20:
        return;
    L13:
        r4 = null;
    L9:
        r9 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListFragment
    public void xa0(List<jz3.a> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r1, "data");
        Object r4 = W90().getDataList().getValue();
        Intrinsics.checkNotNull(r4);
        if (((ListState) r4).c != ListState.State.INITIAL_SUCCESS) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(W90().sceneId(), "homepage_hot") == false) goto L12;
        W90().getPageConfig().getEnterAid();
        Lazy r6 = AccountUsageHintHelper.a;
        AccountUsageHintHelper.c(getActivity());
        return;
    L12:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
