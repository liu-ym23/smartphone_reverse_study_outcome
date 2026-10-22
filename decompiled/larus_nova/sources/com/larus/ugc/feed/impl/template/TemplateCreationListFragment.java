package com.larus.ugc.feed.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.nova.R;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.o;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020\u001eH\u0002J\b\u00100\u001a\u00020\u0014H\u0002J'\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010>\u001a\u00020\u001eH\u0016J\b\u0010?\u001a\u00020\u001eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006A"}, d2 = {"Lcom/larus/ugc/feed/impl/template/TemplateCreationListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/creation/ICreationFeedFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "communityRecommendType", "", "scene", "", "useCache", "", "relatedRecommendation", "relatedCreationId", "pendingAICreationAppletPublishId", "creationDoSameLandingType", "getCreationDoSameLandingType", "()I", "creationDoSameLandingType$delegate", "Lkotlin/Lazy;", "setCreationDoSameInterceptor", "", "interceptor", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initializeAbility", "isCurrentRecommendTab", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "(ZZLjava/lang/Long;)V", "insertFirstUserCreation", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "insertPendingAICreationAppletPublishIfNeeded", "pushPendingPublishNotify", "consumePendingAICreationAppletPublishIfMatched", "creationId", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationListFragment extends Fragment implements o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f374933n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.RecycledViewPool f374934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zp9.m f374935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TabItemInfo f374936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f374937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f374938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f374939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f374940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f374941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f374942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f374943m;

    public static final class a {
    }

    static {
    }

    public final boolean U90() {
        TabItemInfo r100 = this.f374936f;
        if (r100 == null) goto L5;
        String r101 = r100.getId();
    L7:
        if (this.f374936f != null) goto L9;
        return true;
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return true;
    L17:
        if (Intrinsics.areEqual(r101, "0") == true) goto L23;
        return false;
    L23:
        return true;
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    L5:
        r101 = null;
        goto L7
    }

    public TemplateCreationListFragment() {
        this.f374937g = 2;
        this.f374943m = LazyKt.lazy(new h());
    }

    public final zp9.l T90() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f374935e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f374942l = null;
    }

    public final void S90(String r100) {
        UserCreation r101 = cy9.e.f465961a;
        UserCreation r102 = cy9.e.b(getArguments());
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r102.f364987a;
        if (r100 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
    L16:
        boolean r105 = w0a.a.f557826a;
        w0a.a.c("TemplateCreationListFragment[Kmp]", "consumePendingAICreationAppletPublish:" + r103);
        cy9.e.a(getArguments());
        this.f374942l = null;
        zp9.l r106 = T90();
        if (r106 == null) goto L20;
        zp9.l.a.a(r106, false, true, null, false, false, 29);
        return;
    L20:
        return;
    L14:
        if (Intrinsics.areEqual(r103, r100) == true) goto L16;
        return;
    L8:
        if (r100.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        int r102 = 2;
        if (r101 == null) goto L5;
        r102 = r101.getInt("key_creation_recommend_type", 2);
    L5:
        this.f374937g = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L8;
        boolean r104 = r103.getBoolean("key_creation_use_cache", false);
    L9:
        this.f374939i = r104;
        Bundle r105 = getArguments();
        String r106 = null;
        if (r105 == null) goto L12;
        String r107 = r105.getString("key_creation_scene");
    L13:
        this.f374938h = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L16;
        TabItemInfo r109 = (TabItemInfo) r108.getParcelable("key_tab_item_info");
    L17:
        this.f374936f = r109;
        if (U90() == false) goto L32;
        Bundle r110 = getArguments();
        if (r110 == null) goto L22;
        String r111 = r110.getString("related_recommendation");
    L23:
        this.f374940j = r111;
        Bundle r112 = getArguments();
        if (r112 == null) goto L26;
        r106 = r112.getString("related_creation_id");
    L26:
        this.f374941k = r106;
        boolean r113 = w0a.a.f557826a;
        w0a.a.c("TemplateCreationListFragment[Kmp]", "relatedRecommendation=" + this.f374940j + " relatedCreationId=" + this.f374941k);
        if (o0.d(this.f374940j) == false) goto L29;
    L30:
        this.f374939i = false;
        return;
    L29:
        if (o0.d(this.f374941k) == true) goto L30;
        return;
    L22:
        r111 = null;
        goto L23
    L32:
        return;
    L16:
        r109 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L8:
        r104 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r410, Bundle r510) {
        Intrinsics.checkNotNullParameter(r410, "view");
        super.onViewCreated(r410, r510);
        k1a.b.a(this, new i(this));
        zp9.l r100 = T90();
        if (r100 != null) goto L5;
        w0a.a.b("TemplateCreationListFragment[Kmp]", "ICreationFeedAbility not bound, skip initialize");
    L112:
        r410.post(new j(this));
        this.f374940j = null;
        this.f374941k = null;
        return;
    L5:
        Bundle r101 = getArguments();
        if (r101 == null) goto L8;
        String r102 = r101.getString("argBotId");
    L10:
        if (r102 != null) goto L12;
        String r103 = "";
    L14:
        if (U90() == true) goto L16;
    L26:
        CreationFeedCacheEntity r104 = null;
    L27:
        String r310 = "List_TemplateCreationList_Kmp_" + this.f374937g;
        Bundle r105 = getArguments();
        if (r105 == null) goto L30;
        String r106 = r105.getString("recommend_from");
    L31:
        Bundle r107 = getArguments();
        if (r107 == null) goto L34;
        String r108 = r107.getString("argConversationId");
    L35:
        if (r108 != null) goto L37;
        String r110 = "";
    L38:
        Bundle r109 = getArguments();
        if (r109 == null) goto L41;
        Integer r111 = Integer.valueOf(r109.getInt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID));
    L42:
        Bundle r112 = getArguments();
        if (r112 == null) goto L45;
        String r113 = r112.getString("arg_chat_type");
    L46:
        if (r113 != null) goto L48;
        String r114 = "";
    L49:
        Bundle r115 = getArguments();
        if (r115 == null) goto L52;
        String r116 = r115.getString("enter_from");
    L53:
        Bundle r117 = getArguments();
        if (r117 == null) goto L56;
        String r118 = r117.getString("previous_page");
    L57:
        Bundle r119 = getArguments();
        if (r119 == null) goto L61;
        String r120 = r119.getString("enter_method");
        if (r120 == null) goto L61;
    L62:
        String r121 = r120;
        Bundle r122 = getArguments();
        if (r122 == null) goto L65;
        boolean r123 = r122.getBoolean("key_is_chat_double_page", false);
    L66:
        Boolean r124 = Boolean.valueOf(r123);
        Bundle r125 = getArguments();
        if (r125 == null) goto L69;
        String r126 = r125.getString("template_page_type");
    L70:
        zp9.g r311 = new zp9.g("template_page", r106, r103, r110, r111, r114, r116, r118, r121, "action_bar_template", r124, null, r126, null, null, null, null, null, null, null, null, null, 4188160);
        Bundle r127 = getArguments();
        if (r127 == null) goto L73;
        boolean r312 = r127.getBoolean("open_new_chat_page_on_send", false);
    L74:
        TabItemInfo r128 = this.f374936f;
        Bundle r129 = getArguments();
        if (r129 == null) goto L77;
        int r130 = r129.getInt("key_template_list_bottom_padding");
    L78:
        Bundle r131 = getArguments();
        if (r131 == null) goto L81;
        boolean r132 = r131.getBoolean("key_show_user_info");
    L83:
        if (U90() == true) goto L85;
    L95:
        String r133 = null;
    L97:
        if (o0.d(this.f374940j) == true) goto L99;
    L101:
        boolean r134 = false;
    L103:
        if (U90() == false) goto L110;
        Bundle r135 = getArguments();
        if (r135 == null) goto L107;
        boolean r136 = r135.getBoolean("key_disable_initial_auto_refresh_once", false);
    L108:
        if (r136 == false) goto L110;
        boolean r137 = true;
    L111:
        boolean r313 = r132;
        String r314 = r133;
        zp9.f r138 = new zp9.f(r134, r137, r310, false, r311, null, Integer.valueOf(r130), null, true, r128, null, false, null, null, null, r313, r314, r312, null, null, z2.f365865a.creationFeedVideoAutoPlay(), false, null, null, Integer.valueOf(((Number) this.f374943m.getValue()).intValue()), Boolean.TRUE, null, null, null, null, 1022131368);
        ICommunityService.Companion r139 = ICommunityService.f328743a;
        int r140 = this.f374937g;
        TabItemInfo r141 = this.f374936f;
        String r142 = this.f374938h;
        String r143 = this.f374940j;
        String r144 = this.f374941k;
        ICommunityFeedRequestSourceFactory.a r145 = ICommunityFeedRequestSourceFactory.f328747a;
        Bundle r146 = getArguments();
        r145.getClass();
        r100.nh(r138, new zp9.e(r139.v1(r140, r141, r142, r143, r104, r144, false, ICommunityFeedRequestSourceFactory.a.a(r146)), this.f374935e, null, this.f374934d, 4));
        goto L112
    L107:
        r136 = false;
    L110:
        r137 = false;
        goto L111
    L99:
        if (o0.d(this.f374941k) == false) goto L101;
        r134 = true;
        goto L103
    L85:
        if (this.f374939i == false) goto L95;
        String r147 = this.f374938h;
        if (r147 != null) goto L89;
    L92:
        boolean r148 = true;
    L93:
        if (r148 == false) goto L95;
        r133 = String.valueOf(this.f374937g);
        goto L97
    L89:
        if (r147.length() == 0) goto L92;
        r148 = false;
        goto L93
    L81:
        r132 = false;
        goto L83
    L77:
        r130 = 0;
        goto L78
    L73:
        r312 = false;
        goto L74
    L69:
        r126 = null;
        goto L70
    L65:
        r123 = false;
    L61:
        r120 = "chat_action_bar";
        goto L62
    L56:
        r118 = null;
        goto L57
    L52:
        r116 = null;
        goto L53
    L48:
        r114 = r113;
        goto L49
    L45:
        r113 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = r108;
        goto L38
    L34:
        r108 = null;
        goto L35
    L30:
        r106 = null;
        goto L31
    L16:
        if (this.f374939i == false) goto L26;
        String r149 = this.f374938h;
        if (r149 != null) goto L20;
    L23:
        boolean r150 = true;
    L24:
        if (r150 == false) goto L26;
        r104 = ICommunityService.f328743a.b1(String.valueOf(this.f374937g), true);
        goto L27
    L20:
        if (r149.length() == 0) goto L23;
        r150 = false;
        goto L24
    L12:
        r103 = r102;
        goto L14
    L8:
        r102 = null;
        goto L10
    }

    @Override // zp9.o
    public final void V60(boolean r100, boolean r101, Long r110) {
        zp9.l r102 = T90();
        if (r102 == null) goto L6;
        zp9.l.a.a(r102, r100, r101, r110, false, false, 24);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_template_creation_kmp_list_fragment_layout, r101, false);
    }
}
