package com.larus.community.impl.template;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.cache.CreationListCacheDataSource;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
import com.larus.nova.R;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J'\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020 H\u0002J\u0012\u0010<\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010>\u001a\u00020 H\u0016J\b\u0010?\u001a\u00020 H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006A"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreationListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/creation/ICreationFeedFragment;", "<init>", "()V", "sharedPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getSharedPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setSharedPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityPageTemplateCreationListBinding;", "creationDoSameInterceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "currentTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "communityRecommendType", "", "scene", "", "useCache", "", "relatedRecommendation", "relatedCreationId", "pendingHostPublishedCreationId", "creationDoSameLandingType", "getCreationDoSameLandingType", "()I", "creationDoSameLandingType$delegate", "Lkotlin/Lazy;", "setCreationDoSameInterceptor", "", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "getRecommendType", "isCurrentRecommendTab", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "(ZZLjava/lang/Long;)V", "insertFirstUserCreation", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "insertPendingHostPublishedCreationIfNeeded", "consumePendingHostPublishedCreationIfMatched", "creationId", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationListFragment extends Fragment implements zp9.o {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f329879n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.RecycledViewPool f329880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zp9.m f329881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TabItemInfo f329882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f329883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f329884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f329885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f329886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f329887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f329888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f329889m;

    public static final class a {
    }

    static {
    }

    public final boolean U90() {
        TabItemInfo r100 = this.f329882f;
        if (r100 == null) goto L22;
        String r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.getId();
    L9:
        if (Intrinsics.areEqual(r102, "") == true) goto L22;
        TabItemInfo r103 = this.f329882f;
        if (r103 == null) goto L13;
        String r104 = r103.getId();
    L14:
        if (r104 == null) goto L22;
        TabItemInfo r105 = this.f329882f;
        if (r105 == null) goto L19;
        r101 = r105.getId();
    L19:
        if (Intrinsics.areEqual(r101, "0") == true) goto L22;
        return false;
    L13:
        r104 = null;
        goto L14
    L7:
        r102 = null;
    L22:
        return true;
    }

    public TemplateCreationListFragment() {
        this.f329883g = 2;
        this.f329889m = LazyKt.lazy(new r());
    }

    public final zp9.l T90() {
        return (zp9.l) s1a.a.g(this).getAbility(zp9.l.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f329881e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f329888l = null;
    }

    public final void S90(String r100) {
        int r101 = e29.d.f470843a;
        Bundle r102 = getArguments();
        ICommunityHostBehaviorProvider r103 = e29.d.c();
        if (r103 == null) goto L7;
        boolean r104 = r103.j(r102, r100);
        boolean r105 = true;
        if (r104 != true) goto L7;
    L8:
        if (r105 == true) goto L10;
        return;
    L10:
        this.f329888l = null;
        zp9.l r106 = T90();
        if (r106 == null) goto L14;
        zp9.l.a.a(r106, false, true, null, false, false, 29);
        return;
    L14:
        return;
    L7:
        r105 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        int r102 = 2;
        if (r101 == null) goto L5;
        r102 = r101.getInt("key_creation_recommend_type", 2);
    L5:
        this.f329883g = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L8;
        boolean r104 = r103.getBoolean("key_creation_use_cache", false);
    L9:
        this.f329885i = r104;
        Bundle r105 = getArguments();
        String r106 = null;
        if (r105 == null) goto L12;
        String r107 = r105.getString("key_creation_scene");
    L13:
        this.f329884h = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L16;
        TabItemInfo r109 = (TabItemInfo) r108.getParcelable("key_tab_item_info");
    L17:
        this.f329882f = r109;
        if (U90() == false) goto L33;
        Bundle r110 = getArguments();
        if (r110 == null) goto L22;
        String r111 = r110.getString("related_recommendation");
    L23:
        this.f329886j = r111;
        Bundle r112 = getArguments();
        if (r112 == null) goto L26;
        r106 = r112.getString("related_creation_id");
    L26:
        this.f329887k = r106;
        boolean r113 = m29.a.f511679a;
        m29.a.c("TemplateCreationListFragment", "relatedRecommendation:" + this.f329886j + " relatedCreationId:" + this.f329887k);
        if (o0.d(this.f329886j) == false) goto L29;
    L30:
        this.f329885i = false;
    L31:
        m29.a.c("TemplateCreationListFragment", "relatedRecommendation:" + this.f329886j);
        return;
    L29:
        if (o0.d(this.f329887k) == false) goto L31;
    L22:
        r111 = null;
        goto L23
    L33:
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.larus.platform.api.creation.UserCreation, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [androidx.lifecycle.LiveData] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.community.impl.template.u] */
    /* JADX WARN: Type inference failed for: r4v3, types: [zp9.l] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.community.api.spi.ICommunityHostBehaviorProvider] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r610, Bundle r611) {
        Intrinsics.checkNotNullParameter(r610, "view");
        super.onViewCreated(r610, r611);
        k1a.b.a(this, new s(this));
        Bundle r100 = getArguments();
        if (r100 == null) goto L8;
        String r101 = r100.getString("argBotId");
        if (r101 == null) goto L8;
        String r102 = r101;
    L9:
        zp9.l r103 = T90();
        boolean r210 = true;
        if (r103 == null) goto L110;
        String r310 = "List_TemplateCreationList_" + this.f329883g;
        Bundle r104 = getArguments();
        if (r104 == null) goto L14;
        String r105 = r104.getString("recommend_from");
    L15:
        Bundle r106 = getArguments();
        if (r106 == null) goto L21;
        String r107 = r106.getString("argConversationId");
        if (r107 == null) goto L21;
        String r108 = r107;
    L22:
        Bundle r109 = getArguments();
        if (r109 == null) goto L25;
        Integer r110 = Integer.valueOf(r109.getInt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID));
    L26:
        Bundle r111 = getArguments();
        if (r111 == null) goto L32;
        String r112 = r111.getString("arg_chat_type");
        if (r112 == null) goto L32;
        String r113 = r112;
    L33:
        Bundle r114 = getArguments();
        if (r114 == null) goto L36;
        String r115 = r114.getString("enter_from");
    L37:
        Bundle r116 = getArguments();
        if (r116 == null) goto L40;
        String r117 = r116.getString("previous_page");
    L41:
        Bundle r118 = getArguments();
        if (r118 == null) goto L45;
        String r119 = r118.getString("enter_method");
        if (r119 == null) goto L45;
    L46:
        String r120 = r119;
        Bundle r121 = getArguments();
        if (r121 == null) goto L49;
        Boolean r122 = Boolean.valueOf(r121.getBoolean("key_is_chat_double_page", false));
    L50:
        Bundle r123 = getArguments();
        if (r123 == null) goto L53;
        String r211 = r123.getString("template_page_type");
    L54:
        Boolean r124 = r122;
        String r125 = null;
        zp9.g r311 = new zp9.g("template_page", r105, r102, r108, r110, r113, r115, r117, r120, "action_bar_template", r124, null, r211, null, null, null, null, null, null, null, null, null, 4188160);
        Bundle r126 = getArguments();
        if (r126 == null) goto L57;
        boolean r410 = r126.getBoolean("open_new_chat_page_on_send", false);
    L58:
        TabItemInfo r127 = this.f329882f;
        Bundle r128 = getArguments();
        if (r128 == null) goto L61;
        int r129 = r128.getInt("key_template_list_bottom_padding");
    L62:
        Bundle r130 = getArguments();
        if (r130 == null) goto L65;
        boolean r411 = r130.getBoolean("key_show_user_info");
    L67:
        if (U90() == true) goto L69;
    L79:
        String r412 = null;
    L81:
        if (o0.d(this.f329886j) == true) goto L83;
    L85:
        boolean r212 = false;
    L87:
        if (U90() == false) goto L94;
        Bundle r131 = getArguments();
        if (r131 == null) goto L91;
        boolean r132 = r131.getBoolean("key_disable_initial_auto_refresh_once", false);
    L92:
        if (r132 == false) goto L94;
        boolean r312 = true;
    L95:
        zp9.f r133 = new zp9.f(r212, r312, r310, false, r311, null, Integer.valueOf(r129), null, true, r127, null, false, null, null, null, r411, r412, r410, null, null, z2.f365865a.creationFeedVideoAutoPlay(), false, null, null, Integer.valueOf(((Number) this.f329889m.getValue()).intValue()), Boolean.TRUE, null, null, null, null, 1022131368);
        int r134 = this.f329883g;
        TabItemInfo r135 = this.f329882f;
        String r136 = this.f329884h;
        if (U90() == true) goto L98;
    L108:
        CreationFeedCacheEntity r137 = null;
    L109:
        String r138 = this.f329887k;
        String r139 = this.f329886j;
        ICommunityFeedRequestSourceFactory.a r140 = ICommunityFeedRequestSourceFactory.f328747a;
        Bundle r141 = getArguments();
        r140.getClass();
        r103.nh(r133, new zp9.e(new CommunityCreationRecommendRepository(r134, r135, r136, r137, null, r139, r138, ICommunityFeedRequestSourceFactory.a.a(r141), 16), this.f329881e, null, this.f329880d, 4));
    L111:
        this.f329886j = r125;
        this.f329887k = r125;
        if (U90() == false) goto L150;
        int r142 = e29.d.f470843a;
        Bundle r143 = getArguments();
        ICommunityHostBehaviorProvider r144 = e29.d.c();
        if (r144 == null) goto L117;
        ?? r145 = r144.o(r143);
    L118:
        if (r145 == 0) goto L151;
        final String r146 = r145.f364987a;
        if (r146 != null) goto L123;
    L126:
        if (r210 == false) goto L128;
    L130:
        this.f329888l = r146;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r145, "userCreation");
        ?? r147 = e29.d.c();
        if (r147 == 0) goto L133;
        r147.i(this, r145);
    L133:
        Intrinsics.checkNotNullParameter(r145, "userCreation");
        ?? r148 = T90();
        if (r148 == 0) goto L136;
        r148.fQ(r145);
    L136:
        zp9.l r149 = T90();
        if (r149 == null) goto L139;
        ?? r150 = r149.og();
    L140:
        if (r150 == 0) goto L142;
        boolean r151 = Intrinsics.areEqual(r150.getValue(), Boolean.TRUE);
    L143:
        if (r151 == false) goto L145;
        S90(r146);
        return;
    L145:
        if (r150 == 0) goto L149;
        r150.observe(getViewLifecycleOwner(), new v(new u(this, r146)));
        return;
    L149:
        return;
    L142:
        r151 = false;
        goto L143
    L139:
        r150 = r125;
        goto L140
    L128:
        if (Intrinsics.areEqual(this.f329888l, r146) == false) goto L130;
        return;
    L123:
        if (r146.length() == 0) goto L126;
        r210 = false;
        goto L126
    L151:
        return;
    L117:
        r145 = r125;
        goto L118
    L150:
        return;
    L98:
        if (this.f329885i == false) goto L108;
        String r152 = this.f329884h;
        if (r152 != null) goto L102;
    L105:
        boolean r153 = true;
    L106:
        if (r153 == false) goto L108;
        r137 = CreationListCacheDataSource.c(CreationListCacheDataSource.f328905a, String.valueOf(this.f329883g), false, false, 2);
        goto L109
    L102:
        if (r152.length() == 0) goto L105;
        r153 = false;
        goto L106
    L91:
        r132 = false;
    L94:
        r312 = false;
        goto L95
    L83:
        if (o0.d(this.f329887k) == false) goto L85;
        r212 = true;
        goto L87
    L69:
        if (this.f329885i == false) goto L79;
        String r154 = this.f329884h;
        if (r154 != null) goto L73;
    L76:
        boolean r155 = true;
    L77:
        if (r155 == false) goto L79;
        r412 = String.valueOf(this.f329883g);
        goto L81
    L73:
        if (r154.length() == 0) goto L76;
        r155 = false;
        goto L77
    L65:
        r411 = false;
        goto L67
    L61:
        r129 = 0;
        goto L62
    L57:
        r410 = false;
        goto L58
    L53:
        r211 = null;
        goto L54
    L49:
        r122 = null;
    L45:
        r119 = "chat_action_bar";
        goto L46
    L40:
        r117 = null;
        goto L41
    L36:
        r115 = null;
    L32:
        r113 = "";
        goto L33
    L25:
        r110 = null;
    L21:
        r108 = "";
        goto L22
    L14:
        r105 = null;
        goto L15
    L110:
        r125 = null;
    L8:
        r102 = "";
        goto L9
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
        View r103 = getLayoutInflater().inflate(R.layout.larus_community_page_template_creation_list, r101, false);
        if (r103 == null) goto L7;
        return (FrameLayout) r103;
    L7:
        throw new NullPointerException("rootView");
    }
}
