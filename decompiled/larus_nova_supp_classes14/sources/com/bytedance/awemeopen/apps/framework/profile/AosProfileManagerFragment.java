package com.bytedance.awemeopen.apps.framework.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosFeedsHomeLayout;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosRecommendFeedLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedsChannelFragment;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/AosProfileManagerFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/profile/ProfileManagerViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosProfileManagerFragment extends AosBaseFragment<ProfileManagerViewModel> {
    public static final /* synthetic */ int k = 0;
    public Integer g;
    public FrameLayout h;
    public ProfilePageConfig i;
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
        return 2131558650;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<ProfileManagerViewModel> da0() {
        return ProfileManagerViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosProfileManagerFragment() {
        this.j = new LinkedHashMap();
        this.g = 0;
    }

    public final void ea0() {
        int r0 = j64.b.a;
        AoHostService r1 = j64.b.a(AoHostService.class);
        FragmentActivity r2 = getActivity();
        Intrinsics.checkNotNull(r2);
        r1.A0(r2, new Bundle());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        Integer r0 = this.g;
        if (r0 == null) goto L15;
        if (r0.intValue() != 1) goto L15;
        Fragment r1 = getParentFragment();
        if ((r1 instanceof AosFeedsHomeFragment) == false) goto L10;
        AosFeedsHomeFragment r2 = (AosFeedsHomeFragment) r1;
    L11:
        if (r2 == null) goto L15;
        r2.ea0(0);
        return Boolean.TRUE;
    L10:
        r2 = null;
    L15:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        Bundle r0 = getArguments();
        LifecycleOwner r1 = null;
        if (r0 == null) goto L5;
        ProfilePageConfig r2 = (ProfilePageConfig) r0.getParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY");
    L6:
        this.i = r2;
        Fragment r3 = getParentFragment();
        if ((r3 instanceof AosFeedsHomeFragment) == false) goto L9;
        AosFeedsHomeFragment r4 = (AosFeedsHomeFragment) r3;
    L10:
        boolean r5 = false;
        if (r4 == null) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L40;
        FragmentManager r7 = getFragmentManager();
        if (r7 == null) goto L35;
        List r8 = r7.getFragments();
        if (r8 == null) goto L35;
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((Fragment) r10).getClass(), AosFeedsChannelFragment.class) == false) goto L21;
    L26:
        Fragment r11 = (Fragment) r10;
        if (r11 == null) goto L35;
        AosFeedsHomeLayout r12 = ((AosFeedsChannelFragment) r11).S90();
        if (r12 == null) goto L31;
        AosRecommendFeedLayout r13 = r12.getAosRecommendFeedLayout();
    L32:
        if (r13 == null) goto L35;
        ViewModelProviderFactory r14 = ViewModelProviderFactory.a;
        r14.getClass();
        final AosRecomendFeedViewModel r15 = (AosRecomendFeedViewModel) new ViewModelProvider(r13, r14).get(AosRecomendFeedViewModel.class);
        r15.getSelectedIndex().observe(r11, new com.bytedance.awemeopen.apps.framework.profile.a(r15, this));
        goto L35
    L31:
        r13 = null;
        goto L32
    L25:
        r10 = null;
    L35:
        LifecycleOwner r16 = getParentFragment();
        if ((r16 instanceof AosFeedsHomeFragment) == false) goto L38;
        r1 = (AosFeedsHomeFragment) r16;
    L38:
        if (r1 == null) goto L61;
        ViewModelProviderFactory r17 = ViewModelProviderFactory.a;
        r17.getClass();
        ((FeedHomeContainerViewModel) new ViewModelProvider(r1, r17).get(FeedHomeContainerViewModel.class)).getSelectedIndex().observe(r1, new b(this));
        return;
    L61:
        return;
    L40:
        ProfilePageConfig r18 = this.i;
        if (r18 == null) goto L43;
        String r19 = r18.getUserProfile();
    L44:
        if (r19 != null) goto L46;
    L47:
        r5 = true;
    L48:
        if (r5 == false) goto L53;
        ProfilePageConfig r20 = this.i;
        if (r20 == null) goto L52;
        r1 = r20.getFromReqId();
    L52:
        fa0(r1);
        return;
    L53:
        ProfilePageConfig r21 = this.i;
        if (r21 == null) goto L56;
        r21.getUserProfile();
    L56:
        ea0();
        return;
    L46:
        if (r19.length() != 0) goto L48;
    L43:
        r19 = null;
        goto L44
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        this.h = (FrameLayout) findViewById(2131383215);
    }

    public final void fa0(String r5) {
        int r0 = com.bytedance.awemeopen.apps.framework.utils.d.a;
        FragmentManager r1 = getFragmentManager();
        Intrinsics.checkNotNull(r1);
        Observer r2 = r1.findFragmentByTag("tag_AosUserProfileFragment");
        if ((r2 instanceof AosUserProfileFragment) == true) goto L9;
        Object r3 = AosUserProfileFragment.class.newInstance();
        if (r3 == null) goto L8;
        r2 = (AosUserProfileFragment) r3;
    L10:
        AosUserProfileFragment r4 = (AosUserProfileFragment) ((AosBaseFragment) r2);
        Bundle r6 = new Bundle();
        ProfilePageConfig r7 = this.i;
        if (r7 == null) goto L14;
        r7.setFromReqId(r5);
    L14:
        r6.putParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY", this.i);
        Bundle r8 = r4.getArguments();
        if (r8 == null) goto L17;
        String r9 = r8.getString("user_profile_feed_enter_method");
    L18:
        r6.putString("user_profile_feed_enter_method", r9);
        r4.setArguments(r6);
        r4.w = new AosProfileManagerFragment$showProfileFragment$1(this);
        FragmentManager r10 = getFragmentManager();
        Intrinsics.checkNotNull(r10);
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(r10, 2131383215, r4, "tag_AosUserProfileFragment");
        return;
    L17:
        r9 = null;
        goto L18
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.profile.AosUserProfileFragment");
    L9:
        AosBaseFragment r11 = (AosBaseFragment) r2;
        goto L10
    }
}
