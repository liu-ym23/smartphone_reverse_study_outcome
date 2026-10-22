package com.larus.profile.impl.creation;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.community.api.ICommunityService;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.z3;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2;
import com.larus.profile.impl.databinding.LarusItemProfileUserBannedBinding;
import com.larus.profile.impl.databinding.LarusProfileCreationList2Binding;
import com.larus.settings.value.e10;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020#H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\u000f\u00102\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u00103J\u0017\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u001dH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020\rH\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010;\u001a\u00020#H\u0016J\b\u0010<\u001a\u00020#H\u0016J\b\u0010=\u001a\u00020#H\u0002J\b\u0010@\u001a\u00020#H\u0002J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0012\u0010D\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010E\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0017J\u0010\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0002J\u001a\u0010M\u001a\u0004\u0018\u00010\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010Q\u001a\u00020#2\u0006\u0010R\u001a\u00020\rH\u0016J\u0010\u0010S\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010>\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/profile/impl/creation/ProfileCreationListFragmentV2;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lcom/larus/profile/impl/creation/IProfileCreationListFragment;", "Lcom/larus/platform/api/creation/ICreationListener;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusProfileCreationList2Binding;", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "userId", "", "viewModel", "Lcom/larus/profile/impl/creation/viewmodel/ProfileCreationViewModelV2;", "getViewModel", "()Lcom/larus/profile/impl/creation/viewmodel/ProfileCreationViewModelV2;", "viewModel$delegate", "Lkotlin/Lazy;", "openMenusDialogHelper", "Lcom/larus/profile/impl/creation/OpenMenusHelper;", "isFirstEnterPage", "", "isEnterCreationPage", "hasReportEnterPage", "hasReportFunctionShow", "shouldReportFunctionShow", "creationMode", "", "getCreationMode", "()I", "setCreationMode", "(I)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initObservers", "initOpenPrivacyDialogHelper", "initBannedView", "getQueryPrivateStatus", "()Ljava/lang/Integer;", "getFragmentTag", "forceMode", "(Ljava/lang/Integer;)Ljava/lang/String;", "getCurrentCreationMode", "isPrivateTab", "getProfileCreationCurrentPage", "initCreationFeedComponent", "onResume", "onPause", "showUserBannedView", "previousPage", "recommendFrom", "initArgs", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tag", "updatePreviousPage", "onEnterMineTab", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "reportItemShow", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "openCreationDetailInHostIfNeeded", "sourceProfileUserIdForDetail", "hostUiPolicy", "Lcom/larus/profile/impl/info/ProfileHostUiPolicy;", "reportClickItem", "onRemoveUserCreation", "creationId", "onSetReferenceImagePublic", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileCreationListFragmentV2 extends ProfileInfoBaseFragment implements k2, zp9.r {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f366228r = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LarusProfileCreationList2Binding f366229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f366230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f366231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n3 f366232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f366233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f366234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f366235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f366236q;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f366237a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f366237a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f366237a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f366237a.invoke(r100);
        }
    }

    static {
    }

    public final String ba0() {
        if (this.f366230k.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L14;
        int r101 = this.f366234o;
        if (r101 == 4) goto L14;
        if (r101 != 2) goto L13;
        return "creation_private";
    L13:
        return "creation_list";
    L14:
        return "creation_others";
    L5:
        r100 = false;
        goto L6
    }

    public final ProfileCreationViewModelV2 ca0() {
        return (ProfileCreationViewModelV2) this.f366231l.getValue();
    }

    public final boolean da0() {
        if (this.f366234o != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        ICommunityService.f328743a.c1(this);
        super.onDestroy();
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final String tag() {
        return "ProfileCreationListFragmentV2" + this.f366234o;
    }

    public ProfileCreationListFragmentV2() {
        this.f366230k = "";
        final Function0<Fragment> r100 = new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$1(this);
        this.f366231l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileCreationViewModelV2.class), new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$2(r100), new ProfileCreationListFragmentV2$special$$inlined$viewModels$default$3(r100, this));
        this.f366233n = true;
    }

    public final zp9.l aa0() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final RecyclerView getRecyclerView() {
        zp9.l r100 = aa0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRecyclerView();
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Lazy r100 = com.larus.platform.service.q3.f365794a;
        z3 r101 = com.larus.platform.service.q3.a();
        if (r101 == null) goto L6;
        r101.k(null);
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f366233n == true) goto L7;
        zp9.l r100 = aa0();
        if (r100 == null) goto L7;
        zp9.l.a.a(r100, true, false, null, true, this.f376368i, 6);
    L7:
        this.f376368i = false;
        this.f366233n = false;
    }

    @Override // com.larus.profile.impl.creation.k2
    public final int to() {
        return this.f366234o;
    }

    public static final Integer Z90(ProfileCreationListFragmentV2 r100) {
        int r101 = r100.f366234o;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return null;
    L11:
        return 2;
    L9:
        return 1;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void S90(String r510) {
        if (r510 != null) goto L5;
        String r100 = "";
    L6:
        this.f366235p = r100;
        if (com.larus.utils.o0.d(r510) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r510, "unknown") == true) goto L13;
        tx9.a1.c(null, null, null, null, null, ba0(), null, null, null, null, null, null, null, null, null, null, r510, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048705, -1, 7);
        return;
    L13:
        return;
    L5:
        r100 = r510;
        goto L6
    }

    @Override // zp9.r
    public final void X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationId");
        zp9.l r101 = aa0();
        if (r101 == null) goto L6;
        r101.deleteUserCreation(r100, false);
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void Y90(String r100) {
        this.f366235p = r100;
    }

    @Override // zp9.r
    public final void bZ(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (isResumed() == false) goto L10;
        zp9.l r101 = aa0();
        if (r101 == null) goto L11;
        RecyclerView r102 = r101.getRecyclerView();
        if (r102 == null) goto L12;
        r102.post(new s3(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ICommunityService.f328743a.e1(this);
        Bundle r101 = getArguments();
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getString("user_id", "");
        if (r103 == null) goto L6;
    L7:
        this.f366230k = r103;
        Bundle r104 = getArguments();
        boolean r105 = false;
        if (r104 == null) goto L10;
        int r106 = r104.getInt("creation_mode", 0);
    L11:
        this.f366234o = r106;
        String r107 = this.f366235p;
        if (r107 != null) goto L14;
    L15:
        r105 = true;
    L16:
        if (r105 == false) goto L22;
        Bundle r108 = getArguments();
        if (r108 == null) goto L21;
        String r109 = r108.getString("previous_page", "");
        if (r109 == null) goto L21;
    L23:
        this.f366235p = r109;
        Bundle r110 = getArguments();
        if (r110 == null) goto L29;
        String r111 = r110.getString("recommend_from", "");
        if (r111 == null) goto L29;
        r102 = r111;
    L29:
        this.f366236q = r102;
        ca0().setUserId(this.f366230k);
        return;
    L21:
        r109 = "";
        goto L23
    L22:
        r109 = this.f366235p;
        goto L23
    L14:
        if (r107.length() != 0) goto L16;
    L10:
        r106 = 0;
    L6:
        r103 = "";
        goto L7
    }

    @Override // zp9.r
    public final void yE(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
        zp9.l r101 = aa0();
        if (r101 == null) goto L6;
        r101.CO(r100);
        return;
    }

    @Override // com.larus.profile.impl.creation.k2
    public final String yq(Integer r100) {
        int r101 = x3.f366399a;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L7:
        return x3.a(Integer.valueOf(r102));
    L5:
        r102 = this.f366234o;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.profile.impl.creation.ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r410, Bundle r411) {
        Intrinsics.checkNotNullParameter(r410, "view");
        super.onViewCreated(r410, r411);
        if (this.f366229j == null) goto L60;
        final BaseContentWidget r100 = ICommunityService.f328743a.w1();
        if (r100 == null) goto L7;
        k1a.b.a(this, new p3(this, r100));
    L7:
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L14;
        r101.H();
        VideoPortraitConfig r102 = com.larus.home.impl.sdk.l1.f346198a.a();
        if (r102 == null) goto L14;
        if (r102.getEnableAvatarCreation() != true) goto L14;
        boolean r103 = true;
    L15:
        zp9.l r104 = aa0();
        if (r104 == null) goto L56;
        String r110 = "List_ProfileCreationList_" + this.f366234o;
        int r105 = 4;
        Integer r106 = null;
        if (this.f366234o != 4) goto L20;
        String r111 = "creation_others";
    L21:
        zp9.g r107 = new zp9.g(ba0(), "personal_homepage_portfolio", null, null, null, null, r111, this.f366235p, "personal_homepage_portfolio", "personal_homepage_portfolio", null, "creation_others", null, null, null, null, null, null, null, null, null, null, 4191292);
        if (da0() == false) goto L24;
        Integer r210 = Integer.valueOf(i5.a());
    L26:
        if (da0() == false) goto L28;
        Integer r211 = Integer.valueOf(i5.a());
    L29:
        boolean r112 = da0();
        if (da0() == false) goto L32;
        Integer r113 = 3;
    L34:
        if (da0() == false) goto L36;
        r106 = Integer.valueOf(i5.b());
    L36:
        Integer r212 = r106;
        int r108 = this.f366234o;
        if (r108 == 1) goto L43;
        if (r108 == 2) goto L42;
        if (r108 != 4) goto L44;
        r105 = 3;
    L44:
        if (r108 != 2) goto L46;
        boolean r213 = false;
    L48:
        if (this.f366234o == 2) goto L51;
        r103 = false;
    L51:
        zp9.f r114 = new zp9.f(false, false, r110, true, r107, Integer.valueOf(r105), null, 0, true, null, r113, r112, r212, r210, r211, r213, null, false, null, null, false, true, 10, Boolean.valueOf(r103), null, null, "ugc_video", "message_card", "ugc_video", "immersive_preview", 52363843);
        if (da0() == false) goto L54;
        zp9.n r109 = ca0().getProfileCreationFeedPrivateTabRepository();
    L55:
        r104.nh(r114, new zp9.e(r109, new v3(this), new w3(this), null, 8));
        goto L56
    L54:
        r109 = ca0().getProfileCreationFeedRepository();
        goto L55
    L46:
        e10 r115 = e10.f368561a;
        r213 = e10.J().b();
        goto L48
    L42:
        r105 = 2;
        goto L44
    L43:
        r105 = 1;
        goto L44
    L32:
        r113 = null;
        goto L34
    L28:
        r211 = null;
        goto L29
    L24:
        r210 = null;
        goto L26
    L20:
        r111 = null;
    L56:
        zp9.l r116 = aa0();
        if (r116 == null) goto L59;
        r116.X20(new q3(this));
    L59:
        X90();
    L14:
        r103 = false;
    L60:
        LiveData<Integer> r117 = ca0().getProfileStatusLiveData();
        if (r117 == null) goto L63;
        r117.observe(getViewLifecycleOwner(), new b(new t3(this)));
    L63:
        LarusProfileCreationList2Binding r118 = this.f366229j;
        if (r118 == null) goto L70;
        Context r119 = getContext();
        FrameLayout r120 = r118.f366542d;
        if (this.f366230k.length() != 0) goto L68;
        boolean r121 = true;
    L69:
        this.f366232m = new n3(r119, r121, this.f366234o, LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1(this), r120);
        goto L70
    L68:
        r121 = false;
    L70:
        zp9.l r122 = aa0();
        if (r122 == null) goto L76;
        LiveData<Boolean> r123 = r122.og();
        if (r123 == null) goto L77;
        r123.observe(getViewLifecycleOwner(), new b(new r3(this)));
        return;
    L77:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_profile_creation_list_2, r101, false);
        int r104 = R.id.creation_exception_view;
        NestedScrollView r105 = (NestedScrollView) ViewBindings.findChildViewById(r103, R.id.creation_exception_view);
        if (r105 == null) goto L13;
        r104 = R.id.creation_list_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.creation_list_container);
        if (r106 == null) goto L13;
        r104 = R.id.share_product_container;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.share_product_container);
        if (r107 == null) goto L13;
        r104 = R.id.user_banned_view;
        View r108 = ViewBindings.findChildViewById(r103, R.id.user_banned_view);
        if (r108 == null) goto L13;
        ConstraintLayout r109 = (ConstraintLayout) r103;
        this.f366229j = new LarusProfileCreationList2Binding(r109, r105, r106, r107, LarusItemProfileUserBannedBinding.a(r108));
        return r109;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    @Override // zp9.r
    public final void i20(UserCreation r100, long r101, long r102, String r103) {
        zp9.r.a.a(r100, r103);
    }
}
