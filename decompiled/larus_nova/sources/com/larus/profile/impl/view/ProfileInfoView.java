package com.larus.profile.impl.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.list.ListAdapter;
import com.larus.bmhome.auth.ImmersConfig;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.nova.R;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.profile.impl.databinding.LarusPageProfileInfoSkeletonBinding;
import com.larus.profile.impl.databinding.LarusProfileInfoViewBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import ic8.l0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 e2\u00020\u0001:\u0002efB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010*\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0014\u0010-\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0014\u0010/\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0010\u00100\u001a\u00020\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u00101\u001a\u0004\u0018\u000102J\u000f\u00103\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u0004\u0018\u00010\u001d2\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020,H\u0082@¢\u0006\u0002\u0010=J0\u0010>\u001a\u00020\"2\u0006\u0010;\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001dH\u0002J@\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020,2\u0006\u0010;\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010F\u001a\u00020\"*\u00020G2\u0006\u0010H\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0003H\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020,H\u0002J\f\u0010K\u001a\u00020,*\u000209H\u0002J\u0014\u0010L\u001a\u00020\"*\u00020G2\u0006\u0010J\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020\"H\u0002J\u0006\u0010N\u001a\u00020,J\r\u0010O\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u00104J\u001f\u0010P\u001a\u0004\u0018\u00010\"2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020,¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020\"2\u0006\u0010Q\u001a\u00020VJ\u0006\u0010W\u001a\u00020\"J\u0014\u0010X\u001a\u00020\"2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZJ\r\u0010\\\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u00104J\u000f\u0010]\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00104J\u000e\u0010^\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u001dJ\u000e\u0010`\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u001dJ\u000e\u0010a\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010d\u001a\u00020\"2\u0006\u0010b\u001a\u00020cR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larus/profile/impl/view/ProfileInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "parentFragment", "Landroidx/fragment/app/Fragment;", "getParentFragment", "()Landroidx/fragment/app/Fragment;", "parentFragment$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/profile/impl/databinding/LarusProfileInfoViewBinding;", "adapter", "Lcom/ixigua/lib/list/ListAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "tracePageName", "", "mobPageName", "enterFrom", "navigateToEditProfile", "Lkotlin/Function0;", "", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setRecommendFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "navigateToQrCode", "init", "initViewLifecycle", "", "openEditProfile", "action", "setQrCodeAction", "bindLoadMoreManager", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initRecyclerView", "()Lkotlin/Unit;", "reportItemShow", "index", "getChatType", "data", "Lcom/larus/profile/api/bean/ProfileBot;", "checkAndCreateConversation", "profileBot", "isDeleted", "(Lcom/larus/profile/api/bean/ProfileBot;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChatFragment", "existConv", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "clickEnterFrom", "openProfileBotChat", "routeContext", "useNoAnim", "putProfileBotRouteModeParams", "Landroid/os/Bundle;", "routeBelowAICreationApplet", "getProfileBotChatRoute", "openImmersiveChat", "shouldOpenImmersiveChat", "putProfileBotImmersiveParamsIfNeeded", "checkTitleVisibility", "needTitleVisible", "onLoading", "onSuccess", "response", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "isFirstPageChanged", "(Lcom/larus/profile/api/bean/ProfileOverviewResponse;Z)Lkotlin/Unit;", "onLoadMoreSuccess", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "loadMoreFail", "replaceItems", "list", "", "", "onFail", "dismissFailView", "setMobPageName", "pageName", "setTracePageName", "setEnterFrom", "callback", "Lcom/larus/profile/impl/view/ProfileInfoView$ViewUpdateCallback;", "setViewUpdateCallback", "Companion", "ViewUpdateCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f366891n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleOwner f366892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f366893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LarusProfileInfoViewBinding f366894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ListAdapter f366895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayoutManager f366896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoadMoreManager f366897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f366898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f366899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f366900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f366901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecommendFrom f366902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f366903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f366904m;

    public static final class a {
    }

    public interface b {
        Unit a(fs9.n r100);

        void b(boolean r100);

        void c();

        Object d(fs9.n r100, Continuation<? super String> r101);

        void e(r38.b r100);

        Unit f(String r100, String r101);

        Unit g(fs9.n r100);

        void h();
    }

    static {
    }

    private final Fragment getParentFragment() {
        return (Fragment) this.f366893b.getValue();
    }

    public final void V5() {
        LarusProfileInfoViewBinding r100 = this.f366894c;
        if (r100 == null) goto L21;
        ListAdapter r101 = this.f366895d;
        if (r101 == null) goto L13;
        com.ixigua.lib.list.e r102 = r101.f278490b;
        if (r102 == null) goto L13;
        List<Object> r103 = r102.getItems();
        if (r103 == null) goto L13;
        boolean r104 = true;
        if ((!r103.isEmpty()) != true) goto L13;
    L14:
        if (r104 == true) goto L19;
        r100.f366547d.f366511a.setVisibility(8);
        r100.f366545b.setVisibility(0);
        View r105 = r100.f366544a.findViewById(R.id.profile_info_error_view);
        if (r105 == null) goto L19;
        e1.d(r105, new w(this));
    L19:
        Unit r106 = Unit.INSTANCE;
        return;
    L13:
        r104 = false;
        goto L14
    }

    public final RecyclerView getRecyclerView() {
        LarusProfileInfoViewBinding r100 = this.f366894c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f366546c;
    }

    public final RecommendFrom getRecommendFrom() {
        return this.f366902k;
    }

    public ProfileInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f366893b = LazyKt.lazy(new r(this));
        this.f366898g = "";
        this.f366899h = "other";
        this.f366900i = "other";
        U5(r100, null);
    }

    public static final /* synthetic */ Fragment S5(ProfileInfoView r100) {
        return r100.getParentFragment();
    }

    public final String T5(fs9.n r100) {
        int r101 = r100.h();
        if (r101 != 0) goto L5;
        BotCreatorInfo r102 = r100.k();
        if (r102 == null) goto L14;
        String r103 = r102.getId();
    L16:
        if (Intrinsics.areEqual(r103, AccountService.f365697a.getUserId()) == false) goto L18;
        return "self_created";
    L18:
        return "others_created";
    L14:
        r103 = null;
        goto L16
    L5:
        if (r101 != 1) goto L7;
        return "default";
    L7:
        if (r101 == 4) goto L9;
        return "other_default";
    L9:
        return "notice";
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.f366900i = r100;
    }

    public final void setMobPageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f366899h = r100;
    }

    public final void setQrCodeAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f366903l = r100;
    }

    public final void setRecommendFrom(RecommendFrom r100) {
        this.f366902k = r100;
    }

    public final void setTracePageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f366898g = r100;
    }

    public final void setViewUpdateCallback(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f366904m = r100;
    }

    public ProfileInfoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f366893b = LazyKt.lazy(new r(this));
        this.f366898g = "";
        this.f366899h = "other";
        this.f366900i = "other";
        U5(r100, r101);
    }

    public final void U5(Context r110, AttributeSet r111) {
        View r112 = LayoutInflater.from(r110).inflate(R.layout.larus_profile_info_view, this, false);
        addView(r112);
        int r113 = R.id.profile_info_error_stub;
        ViewStub r100 = (ViewStub) ViewBindings.findChildViewById(r112, R.id.profile_info_error_stub);
        if (r100 == null) goto L25;
        r113 = R.id.profile_info_recycler_view;
        RecyclerView r101 = (RecyclerView) ViewBindings.findChildViewById(r112, R.id.profile_info_recycler_view);
        if (r101 == null) goto L25;
        r113 = R.id.profile_info_skeleton;
        View r102 = ViewBindings.findChildViewById(r112, R.id.profile_info_skeleton);
        if (r102 == null) goto L25;
        int r114 = R.id.profile_info_skeleton_avatar;
        View r103 = ViewBindings.findChildViewById(r102, R.id.profile_info_skeleton_avatar);
        if (r103 == null) goto L23;
        r114 = R.id.profile_info_skeleton_bots_info;
        View r104 = ViewBindings.findChildViewById(r102, R.id.profile_info_skeleton_bots_info);
        if (r104 == null) goto L23;
        r114 = R.id.profile_info_skeleton_nickname;
        View r105 = ViewBindings.findChildViewById(r102, R.id.profile_info_skeleton_nickname);
        if (r105 == null) goto L23;
        r114 = R.id.profile_info_skeleton_username;
        View r115 = ViewBindings.findChildViewById(r102, R.id.profile_info_skeleton_username);
        if (r115 == null) goto L23;
        this.f366894c = new LarusProfileInfoViewBinding((ConstraintLayout) r112, r100, r101, new LarusPageProfileInfoSkeletonBinding((ConstraintLayout) r102, r103, r104, r105, r115));
        Context r116 = getContext();
        if (r116 == null) goto L20;
        LinearLayoutManager r117 = new LinearLayoutManager(r116);
        this.f366896e = r117;
        r101.setLayoutManager(r117);
        ListAdapter r118 = new ListAdapter(new ay7.b(r116), CollectionsKt.listOf(new ay7.a[]{new x(), new com.larus.profile.impl.b(), new g(), new f()}));
        r118.f278491c = new ProfileInfoView$initRecyclerView$1$1$1(this);
        this.f366895d = r118;
        r101.addOnScrollListener(new ProfileInfoView$initRecyclerView$1$2(this));
        r101.setItemAnimator(null);
        y6.f(r101, new s(this), new t(), 0.1f, new u(this), 49);
    L20:
        Unit r119 = Unit.INSTANCE;
        post(new v(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r114)));
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public ProfileInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f366893b = LazyKt.lazy(new r(this));
        this.f366898g = "";
        this.f366899h = "other";
        this.f366900i = "other";
        U5(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(Bundle r100, boolean r101, Context r102) {
        if (r101 == false) goto L10;
        r100.putBoolean("disable_activity_transition", true);
        if ((r102 instanceof j4) == false) goto L9;
        r100.putBoolean("route_native_below_ai_creation_applet", true);
        if (((j4) r102).B0() == false) goto L12;
        r100.putString("is_side_bar", "1");
        return;
    L12:
        return;
    L9:
        r100.putString("ignore_side_bar", "1");
        return;
    L10:
        r100.putString("ignore_side_bar", "1");
    }

    public static final Object R5(ProfileInfoView r100, fs9.n r101, boolean r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof ProfileInfoView$checkAndCreateConversation$1) == false) goto L7;
        ProfileInfoView$checkAndCreateConversation$1 r104 = (ProfileInfoView$checkAndCreateConversation$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L29:
        return (String) r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (o0.d(r101.i()) == true) goto L17;
    L20:
        b r109 = r100.f366904m;
        if (r109 == null) goto L26;
        r104.label = 1;
        r106 = r109.d(r101, r104);
        if (r106 != r107) goto L29;
        return r107;
    L26:
        String r110 = null;
    L28:
        return r110;
    L17:
        if (Intrinsics.areEqual(r101.i(), "0") == true) goto L20;
        if (r102 == true) goto L20;
        r110 = r101.i();
    L7:
        r104 = new ProfileInfoView$checkAndCreateConversation$1(r100, r103);
        goto L8
    }

    public final void Y5(Context r210, boolean r211, fs9.n r212, wc9.e r213, String r214, String r215) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L55
        String r101 = r212.e();     // Catch: Throwable -> L55
        if (r213 == null) goto L6;
        ConversationPage r102 = r213.f559204g;     // Catch: Throwable -> L55
    L7:
        if (r211 == false) goto L9;
        int r103 = R.anim.larus_router_no_anim;
    L10:
        if (r102 == null) goto L12;
        List<Integer> r110 = r102.getPageList();     // Catch: Throwable -> L55
    L15:
        if (l0.b(r110) == false) goto L21;
        int r111 = f5.f302997a;     // Catch: Throwable -> L55
        if (r102 == null) goto L19;
        Integer r112 = r102.getDefaultStatus();     // Catch: Throwable -> L55
    L20:
        int r113 = f5.a(r112);     // Catch: Throwable -> L55
        com.bytedance.router.i r114 = SmartRouter.buildRoute(r210, "//flow/chat_page_double_tab");     // Catch: Throwable -> L55
        int r115 = r103;
        Bundle r104 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", this.f366899h), TuplesKt.to("argConversationId", r214), TuplesKt.to("argClickEnterFrom", r215), TuplesKt.to("argBotId", r101), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("is_create_sub_conversation", Boolean.FALSE), TuplesKt.to("default_tab", Integer.valueOf(r113)), TuplesKt.to(CommentPublishScene.CONVERSATION_PAGE, r102)});     // Catch: Throwable -> L55
        Z5(r104, r211, r210);     // Catch: Throwable -> L55
        by7.h.j(r104, this);     // Catch: Throwable -> L55
        r114.f267554c.putExtras(r104);     // Catch: Throwable -> L55
        r114.f267555d = r115;     // Catch: Throwable -> L55
        r114.f267556e = R.anim.larus_router_no_anim;     // Catch: Throwable -> L55
        r114.d();     // Catch: Throwable -> L55
    L53:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
        return;
    L19:
        r112 = null;
        goto L20
    L21:
        if (r211 == true) goto L23;
    L34:
        boolean r116 = false;
    L35:
        if (r116 == false) goto L37;
        String r105 = "//flow/chat_page_immers";
    L38:
        com.bytedance.router.i r106 = SmartRouter.buildRoute(r210, r105);     // Catch: Throwable -> L55
        int r117 = r103;
        Bundle r107 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.PROFILE_INFO_VIEW.getChannel()), TuplesKt.to("argPreviousPage", this.f366899h), TuplesKt.to("argClickEnterFrom", r215), TuplesKt.to("argCvsBgImgUrl", r212.c()), TuplesKt.to("argCvsBgImgColor", r212.a()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r212.b())), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("argConversationId", r214), TuplesKt.to("argBotId", r101), TuplesKt.to("navigate_up_from", this.f366900i)});     // Catch: Throwable -> L55
        Z5(r107, r211, r210);     // Catch: Throwable -> L55
        if (r116 == true) goto L42;
    L52:
        by7.h.j(r107, this);     // Catch: Throwable -> L55
        r106.f267554c.putExtras(r107);     // Catch: Throwable -> L55
        r106.f267555d = r117;     // Catch: Throwable -> L55
        r106.f267556e = R.anim.larus_router_no_anim;     // Catch: Throwable -> L55
        r106.d();     // Catch: Throwable -> L55
        goto L53
    L42:
        if (r107.getBoolean("is_single_mode", false) == true) goto L50;
        LaunchInfo r108 = LaunchCacheDelegate.f295726b.c();     // Catch: Throwable -> L55
        if (r108 == null) goto L46;
        ImmersConfig r109 = r108.L0();     // Catch: Throwable -> L55
    L47:
        if (r109 == null) goto L50;
        boolean r118 = false;
    L51:
        r107.putBoolean("is_single_mode", r118);     // Catch: Throwable -> L55
        goto L52
    L46:
        r109 = null;
    L50:
        r118 = true;
        goto L51
    L37:
        r105 = "//flow/chat_page";
        goto L38
    L23:
        if (z2.f365865a.chatImmerseEnable() == true) goto L25;
    L31:
        boolean r119 = false;
    L32:
        if (r119 == false) goto L34;
        r116 = true;
        goto L35
    L25:
        if (r212.b() == false) goto L31;
        if (o0.d(r212.c()) == false) goto L31;
        if (o0.d(r212.a()) == false) goto L31;
        r119 = true;
        goto L32
    L12:
        r110 = null;
        goto L15
    L9:
        r103 = R.anim.larus_router_slide_in_right;
        goto L10
    L6:
        r102 = r212.j();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
