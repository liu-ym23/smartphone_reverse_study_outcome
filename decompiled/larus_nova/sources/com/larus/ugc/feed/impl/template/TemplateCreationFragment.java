package com.larus.ugc.feed.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.impl.home.CommunityCreateBridgeEmptyState;
import com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel;
import com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zp9.u;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010,J\u0012\u0010;\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u0019H\u0002J\b\u0010I\u001a\u000209H\u0016J\b\u0010J\u001a\u000209H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b1\u00102R\u0010\u00104\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u00106¨\u0006L"}, d2 = {"Lcom/larus/ugc/feed/impl/template/TemplateCreationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sharedPool$delegate", "Lkotlin/Lazy;", "bridgeVM", "Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "getBridgeVM", "()Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "bridgeVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "rootView", "Landroid/view/View;", "tagListContainer", "titleView", "Landroid/widget/TextView;", "profileImageContainer", "profileImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "tabMaskLeftIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "tabListView", "Lcom/larus/platform/api/creation/ITabListLayout;", "adapter", "Lcom/larus/ugc/feed/impl/template/TemplateMainAdapter;", "isMultiTab", "", "multiTabTitleName", "", "creationRecommendType", "", "botId", "currentPageName", "templatePageType", "defaultLandingTabId", "topPadding", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "isClickedTab", "lastSelectedIndex", "hostUiPolicy", "Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/applet/AICreationCommunityHostUiPolicy;", "hostUiPolicy$delegate", "pendingLandingTabId", "isShowAvatar", "()Z", "isShowAvatar$delegate", "setCreationDoSameInterceptor", "", "interceptor", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupTabListView", "setupAvatar", "debounceSlip", "pager", "onResume", "onDestroyView", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationFragment extends Fragment {
    public static final /* synthetic */ int C = 0;
    public String A;
    public final Lazy B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f374904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f374905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f374906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f374907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f374908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f374909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SimpleDraweeView f374910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPager2 f374911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppCompatImageView f374912l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u f374913m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TemplateMainAdapter f374914n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f374915o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f374916p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f374917q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f374918r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f374919s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f374920t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f374921u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f374922v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public zp9.m f374923w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f374924x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f374925y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f374926z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f374927a;

        public b(com.larus.ugc.feed.impl.template.d r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f374927a = r100;
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
            return this.f374927a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f374927a.invoke(r100);
        }
    }

    public static final class c implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f374928a;

        public c(Fragment r100) {
            this.f374928a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f374928a;
        }
    }

    public static final class d implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f374929a;

        public d(Fragment r100) {
            this.f374929a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f374929a;
        }
    }

    public static final class e implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f374930a = null;

        static {
            f374930a = new e();
        }

        public e() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final cy9.f S90() {
        return (cy9.f) this.f374926z.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ViewPager2 r100 = this.f374911k;
        if (r100 == null) goto L5;
        r100.setAdapter(null);
    L5:
        this.f374914n = null;
        this.f374913m = null;
        this.f374906f = null;
        this.f374907g = null;
        this.f374908h = null;
        this.f374909i = null;
        this.f374910j = null;
        this.f374911k = null;
        this.f374912l = null;
        super.onDestroyView();
    }

    public TemplateCreationFragment() {
        this.f374904d = LazyKt.lazy(new com.larus.ugc.feed.impl.template.a());
        this.f374905e = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CommunityCreateLegacyBridgeViewModel.class), Reflection.getOrCreateKotlinClass(CommunityCreateBridgeEmptyState.class), new c(this), new d(this), e.f374930a);
        this.f374916p = "";
        this.f374917q = 1;
        this.f374919s = "";
        this.f374922v = -1;
        this.f374925y = -1;
        this.f374926z = LazyKt.lazy(new com.larus.ugc.feed.impl.template.b(this));
        this.B = LazyKt.lazy(new com.larus.ugc.feed.impl.template.c());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        g0a.f r100 = (g0a.f) s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.f.class));
        if (r100 == null) goto L6;
        r100.ev();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 == null) goto L5;
        r102 = r101.getBoolean("key_is_multi_tab", false);
    L5:
        this.f374915o = r102;
        Bundle r103 = getArguments();
        String r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.getString("key_multi_tab_title_name");
    L9:
        String r106 = "";
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        this.f374916p = r105;
        Bundle r107 = getArguments();
        int r108 = 1;
        if (r107 == null) goto L15;
        r108 = r107.getInt("key_creation_recommend_type", 1);
    L15:
        this.f374917q = r108;
        Bundle r109 = getArguments();
        if (r109 == null) goto L18;
        String r110 = r109.getString("argBotId");
    L19:
        if (r110 != null) goto L21;
        r110 = "";
    L21:
        this.f374918r = r110;
        Bundle r111 = getArguments();
        if (r111 == null) goto L24;
        String r112 = r111.getString("key_current_page_name");
    L25:
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        this.f374919s = r112;
        Bundle r113 = getArguments();
        if (r113 == null) goto L30;
        String r114 = r113.getString("template_page_type");
    L31:
        if (r114 == null) goto L34;
        r106 = r114;
    L34:
        this.f374920t = r106;
        Bundle r115 = getArguments();
        if (r115 == null) goto L37;
        r104 = r115.getString("feed_landing_tab");
    L37:
        this.f374921u = r104;
        Bundle r116 = getArguments();
        int r117 = -1;
        if (r116 == null) goto L40;
        r117 = r116.getInt("key_template_list_top_padding", -1);
    L40:
        this.f374922v = r117;
        this.A = this.f374921u;
        boolean r118 = w0a.a.f557826a;
        w0a.a.c("TemplateCreationFragment[Kmp]", "onCreate isMultiTab=" + this.f374915o + " recommendType=" + this.f374917q + " landingTabId=" + this.f374921u + " templatePageType=" + this.f374920t);
        return;
    L30:
        r114 = null;
        goto L31
    L24:
        r112 = null;
        goto L25
    L18:
        r110 = null;
        goto L19
    L8:
        r105 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.larus.ugc.feed.impl.template.d] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        FLogger r100 = FLogger.f375446a;
        r100.d("TemplateCreationFragment[Kmp]", "onViewCreated");
        int r101 = this.f374922v;
        if (r101 < 0) goto L11;
        View r102 = this.f374906f;
        if (r102 == null) goto L7;
        r102.setPadding(r102.getPaddingLeft(), r101, r102.getPaddingRight(), r102.getPaddingBottom());
    L7:
        View r103 = this.f374907g;
        if (r103 == null) goto L17;
        e1.o(r103);
    L17:
        FragmentAttachExtKt.b(this, ContainerFilter.COMMUNITY_CREATE_KMP);
        final g0a.f r104 = (g0a.f) s1a.a.g(this).o(Reflection.getOrCreateKotlinClass(g0a.f.class));
        if (r104 != null) goto L21;
        r100.e("TemplateCreationFragment[Kmp]", "IKMPCommunityCreateAbility not bound; fragment will render empty");
        return;
    L21:
        CommunityCreateLaunchModeKmp r105 = CommunityCreateLaunchModeKmp.STANDALONE;
        int r106 = this.f374917q;
        boolean r107 = this.f374915o;
        Bundle r108 = getArguments();
        if (r108 == null) goto L24;
        String r109 = r108.getString("enter_method");
    L25:
        if (r109 != null) goto L27;
        r109 = "";
    L27:
        String r110 = r109;
        String r111 = this.f374918r;
        String r112 = this.f374919s;
        if (r112.length() <= 0) goto L30;
        boolean r113 = true;
    L31:
        if (r113 == true) goto L34;
        r112 = null;
    L34:
        r104.yG(new m0a.e(r105, r106, r107, "", r110, r111, this.f374921u, this.f374920t, this.f374916p, this.f374922v, r112, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW), new m0a.d(new CommunityCreateNavigatorAndroidImpl(getActivity(), null), new com.larus.ugc.feed.impl.spi.c(this.f374918r, this.f374920t), new com.larus.ugc.feed.impl.spi.a(), new y0a.e(FlowRuntime.b().c())));
        ((CommunityCreateLegacyBridgeViewModel) this.f374905e.getValue()).bind(r104);
        TemplateMainAdapter r114 = new TemplateMainAdapter(this, this.f374923w, (RecyclerView.RecycledViewPool) this.f374904d.getValue());
        this.f374914n = r114;
        ViewPager2 r115 = this.f374911k;
        if (r115 == null) goto L37;
        r115.setAdapter(r114);
    L37:
        ViewPager2 r116 = this.f374911k;
        if (r116 == null) goto L40;
        r116.setOffscreenPageLimit(1);
    L40:
        ViewPager2 r117 = this.f374911k;
        if (r117 == null) goto L43;
        r117.registerOnPageChangeCallback(new AnonymousClass2(this, r104));
    L43:
        cy9.f r118 = S90();
        if (this.f374915o == true) goto L46;
        r118.getClass();
    L49:
        boolean r119 = false;
    L50:
        if (r119 == false) goto L65;
        TextView r120 = this.f374908h;
        if (r120 == null) goto L54;
        e1.x(r120);
    L54:
        TextView r121 = this.f374908h;
        if (r121 == null) goto L57;
        r121.setText(this.f374916p);
    L57:
        ViewPager2 r122 = this.f374911k;
        if (r122 == null) goto L68;
        View r123 = r122.getChildAt(0);
        if ((r123 instanceof RecyclerView) == false) goto L62;
        RecyclerView r124 = (RecyclerView) r123;
    L63:
        if (r124 == null) goto L68;
        r124.setScrollingTouchSlop(1);
        goto L68
    L62:
        r124 = null;
    L68:
        ((CommunityCreateLegacyBridgeViewModel) this.f374905e.getValue()).getTabListLiveData().observe(getViewLifecycleOwner(), new b(new com.larus.ugc.feed.impl.template.d(this, r104)));
        cy9.f r125 = S90();
        if (((Boolean) this.B.getValue()).booleanValue() == true) goto L71;
        r125.getClass();
    L74:
        boolean r126 = false;
    L75:
        if (r126 == false) goto L80;
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new TemplateCreationFragment$setupAvatar$1(this, AccountService.f365697a.getUserId(), null));
        View r127 = this.f374909i;
        if (r127 == null) goto L81;
        e1.d(r127, new com.larus.ugc.feed.impl.template.e(this));
        return;
    L81:
        return;
    L80:
        return;
    L71:
        if (r125.f465965a == true) goto L74;
        r126 = true;
        goto L75
    L65:
        TextView r128 = this.f374908h;
        if (r128 == null) goto L68;
        e1.o(r128);
        goto L68
    L46:
        if (r118.f465965a == true) goto L49;
        r119 = true;
        goto L50
    L30:
        r113 = false;
        goto L31
    L24:
        r109 = null;
        goto L25
    L11:
        if (this.f374915o == true) goto L17;
        if (S90().f465965a == false) goto L17;
        View r129 = this.f374907g;
        if (r129 == null) goto L17;
        e1.o(r129);
        goto L17
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_template_creation_kmp_fragment_layout, r101, false);
        this.f374906f = r103;
        this.f374907g = r103.findViewById(R.id.tag_list_container_kmp_template);
        this.f374908h = (TextView) r103.findViewById(R.id.title_view_kmp_template);
        this.f374909i = r103.findViewById(R.id.profile_image_container_kmp_template);
        this.f374910j = (SimpleDraweeView) r103.findViewById(R.id.profile_image_kmp_template);
        this.f374911k = (ViewPager2) r103.findViewById(R.id.view_pager2_kmp_template);
        this.f374912l = (AppCompatImageView) r103.findViewById(R.id.tag_mask_left_icon_kmp_template);
        return r103;
    }
}
