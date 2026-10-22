package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceInviteFriendsBinding;
import com.larus.commercecredit.impl.page.adapter.CommerceInviteInfoAdapter;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import com.larus.home.impl.sdk.c1;
import com.larus.home.impl.sdk.h2;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0014J&\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\f2\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020$0#H\u0002J&\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u001b0#H\u0002J\b\u0010(\u001a\u00020)H\u0002J$\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020)H\u0002J\u0012\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0002J*\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u00109\u001a\u00020\u001b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002J\u0018\u0010=\u001a\u00020\u001b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceInviteFriendsFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceInviteFriendsBinding;", "<init>", "()V", "inviteInfoAdapter", "Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "getInviteInfoAdapter", "()Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "inviteInfoAdapter$delegate", "Lkotlin/Lazy;", "campaignKey", "", "getCampaignKey", "()Ljava/lang/String;", "campaignKey$delegate", "invitationInfo", "Lcom/larus/commercecredit/impl/entity/GroupInvitationInfo;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "initViews", "", "setupAccessibility", "adapterNightMode", "adapterPadConfig", "initEvents", "handleShareAction", "shareChannel", "createShareContent", "Lkotlin/Function1;", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "getGroupInvitationInfo", "scene", "inviteAction", "checkSecurityMode", "", "updateCampaignInfo", "localCampaignInfo", "Lcom/larus/commercecredit/impl/entity/CampaignInfo;", "remoteCampaignInfo", "isFromLocal", "setupBasicInfo", "basicInfo", "Lcom/larus/commercecredit/impl/entity/BasicInfo;", "setupDescriptionText", "setupClickableDescription", "fullText", "startIndex", "", "endIndex", "schema", "setupStepList", "stepList", "", "Lcom/larus/commercecredit/impl/entity/Step;", "updateInviteInfoHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceInviteFriendsFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceInviteFriendsBinding> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f325737i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f325738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f325739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qz8.l f325740h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.page.CommerceInviteFriendsFragment$initViews$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceInviteFriendsFragment$initViews$1", f = "CommerceInviteFriendsFragment.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommerceInviteFriendsFragment this$0;

        public AnonymousClass1(CommerceInviteFriendsFragment r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CommerceCreditConfigManager r103 = CommerceCreditConfigManager.f325801a;
            CommerceInviteFriendsFragment r104 = this.this$0;
            int r105 = CommerceInviteFriendsFragment.f325737i;
            String r106 = (String) r104.f325739g.getValue();
            final CommerceInviteFriendsFragment r107 = this.this$0;
            Function3 r108 = new j0(r107);
            this.label = 1;
            if (CommerceCreditConfigManager.c("CommerceInviteFriendsFragment_initViews", r106, true, r108, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public CommerceInviteFriendsFragment() {
        this.f325738f = LazyKt.lazy(new c0());
        this.f325739g = LazyKt.lazy(new d0(this));
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void V90() {
        super.V90();
        LarusFragmentCommerceInviteFriendsBinding r100 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f325697b;
        if (r101 == null) goto L7;
        e1.d(r101, new w(this));
    L7:
        LarusFragmentCommerceInviteFriendsBinding r102 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r102 == null) goto L12;
        LinearLayout r103 = r102.f325698c;
        if (r103 == null) goto L12;
        e1.d(r103, new z(this));
    L12:
        LarusFragmentCommerceInviteFriendsBinding r104 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r104 == null) goto L18;
        TextView r105 = r104.f325707l;
        if (r105 == null) goto L19;
        e1.d(r105, new a0(this));
        return;
    L19:
        return;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        Context r100 = getContext();
        if (r100 == null) goto L26;
        boolean r101 = v19.h.f552477a;
        if (v19.h.b(r100) == false) goto L16;
        LarusFragmentCommerceInviteFriendsBinding r102 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r102 == null) goto L11;
        SimpleDraweeView r103 = r102.f325700e;
        if (r103 == null) goto L11;
        r103.setActualImageResource(R.drawable.larus_ic_commerce_credit_douyin_night);
    L11:
        LarusFragmentCommerceInviteFriendsBinding r104 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r104 == null) goto L26;
        SimpleDraweeView r105 = r104.f325702g;
        if (r105 == null) goto L26;
        r105.setActualImageResource(R.drawable.larus_ic_commerce_credit_wechat_night);
        goto L26
    L16:
        LarusFragmentCommerceInviteFriendsBinding r106 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r106 == null) goto L21;
        SimpleDraweeView r107 = r106.f325700e;
        if (r107 == null) goto L21;
        r107.setActualImageResource(R.drawable.larus_ic_commerce_credit_douyin);
    L21:
        LarusFragmentCommerceInviteFriendsBinding r108 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r108 == null) goto L26;
        SimpleDraweeView r109 = r108.f325702g;
        if (r109 == null) goto L26;
        r109.setActualImageResource(R.drawable.larus_ic_commerce_credit_wechat);
    L26:
        boolean r110 = false;
        if (e2.f365734a.isPad() == false) goto L53;
        int r111 = i5.Q();
        LarusFragmentCommerceInviteFriendsBinding r112 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r112 == null) goto L33;
        LinearLayout r113 = r112.f325704i;
        if (r113 == null) goto L33;
        r113.setPadding(r111, 0, r111, 0);
    L33:
        LarusFragmentCommerceInviteFriendsBinding r114 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r114 == null) goto L38;
        TextView r115 = r114.f325708m;
        if (r115 == null) goto L38;
        r115.setPadding(r111, 0, r111, 0);
    L38:
        LarusFragmentCommerceInviteFriendsBinding r116 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r116 == null) goto L43;
        TextView r117 = r116.f325708m;
        if (r117 == null) goto L43;
        r117.setMaxWidth(Integer.MAX_VALUE);
    L43:
        LarusFragmentCommerceInviteFriendsBinding r118 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r118 == null) goto L48;
        RecyclerView r119 = r118.f325706k;
        if (r119 == null) goto L48;
        r119.setPadding(r111, 0, r111, 0);
    L48:
        LarusFragmentCommerceInviteFriendsBinding r120 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r120 == null) goto L53;
        LinearLayout r121 = r120.f325699d;
        if (r121 == null) goto L53;
        r121.setPadding(r111, 0, r111, 0);
    L53:
        LarusFragmentCommerceInviteFriendsBinding r122 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r122 == null) goto L58;
        RecyclerView r123 = r122.f325706k;
        if (r123 == null) goto L58;
        r123.setLayoutManager(new LinearLayoutManager(getContext()));
    L58:
        LarusFragmentCommerceInviteFriendsBinding r124 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r124 == null) goto L63;
        RecyclerView r125 = r124.f325706k;
        if (r125 == null) goto L63;
        r125.setAdapter((CommerceInviteInfoAdapter) this.f325738f.getValue());
    L63:
        LarusFragmentCommerceInviteFriendsBinding r126 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r126 == null) goto L68;
        RecyclerView r127 = r126.f325706k;
        if (r127 == null) goto L68;
        r127.setItemAnimator(null);
    L68:
        ShareServiceDelegate r128 = ShareServiceDelegate.f313831b;
        if (r128.a(ShareChannel.DOUYIN) == false) goto L75;
        LarusFragmentCommerceInviteFriendsBinding r129 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r129 == null) goto L81;
        LinearLayout r130 = r129.f325697b;
        if (r130 == null) goto L81;
        e1.x(r130);
    L81:
        if (r128.a("wechat") == false) goto L87;
        LarusFragmentCommerceInviteFriendsBinding r131 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r131 == null) goto L92;
        LinearLayout r132 = r131.f325698c;
        if (r132 == null) goto L92;
        e1.x(r132);
    L92:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        IFlowSdkDepend r133 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r133 == null) goto L97;
        r133.S();
        if (c1.f346148a.a() != true) goto L97;
        r110 = true;
    L97:
        if (r110 == false) goto L107;
        Dialog r134 = getDialog();
        if (r134 == null) goto L106;
        View r135 = r134.findViewById(R.id.view_top_close_range);
        if (r135 == null) goto L108;
        e1.x(r135);
        e1.d(r135, new b0(this));
        return;
    L108:
        return;
    L106:
        return;
    L107:
        return;
    L87:
        LarusFragmentCommerceInviteFriendsBinding r136 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r136 == null) goto L92;
        LinearLayout r137 = r136.f325698c;
        if (r137 == null) goto L92;
        e1.o(r137);
        goto L92
    L75:
        LarusFragmentCommerceInviteFriendsBinding r138 = (LarusFragmentCommerceInviteFriendsBinding) this.f325726d;
        if (r138 == null) goto L81;
        LinearLayout r139 = r138.f325697b;
        if (r139 == null) goto L81;
        e1.o(r139);
        goto L81
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceInviteFriendsActivity.class;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r210, ViewGroup r211) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_fragment_commerce_invite_friends, r211, false);
        int r101 = R.id.btn_first;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.btn_first);
        if (r102 == null) goto L41;
        r101 = R.id.btn_second;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.btn_second);
        if (r103 == null) goto L41;
        r101 = R.id.buttons_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.buttons_container);
        if (r104 == null) goto L41;
        r101 = R.id.iv_first_icon;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.iv_first_icon);
        if (r105 == null) goto L41;
        r101 = R.id.iv_invite_friends_bg;
        SimpleDraweeView r106 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.iv_invite_friends_bg);
        if (r106 == null) goto L41;
        r101 = R.id.iv_second_icon;
        SimpleDraweeView r110 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.iv_second_icon);
        if (r110 == null) goto L41;
        r101 = R.id.layout_container_invite_friends;
        LinearLayout r111 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_container_invite_friends);
        if (r111 == null) goto L41;
        r101 = R.id.layout_container_invite_title;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_container_invite_title);
        if (r112 == null) goto L41;
        r101 = R.id.layout_failed_to_retry;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_failed_to_retry);
        if (r113 == null) goto L41;
        r101 = R.id.rv_invite_infos;
        RecyclerView r114 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.rv_invite_infos);
        if (r114 == null) goto L41;
        r101 = R.id.tv_copy_invite_link;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_copy_invite_link);
        if (r115 == null) goto L41;
        r101 = R.id.tv_description;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_description);
        if (r116 == null) goto L41;
        r101 = R.id.tv_first_text;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_first_text);
        if (r117 == null) goto L41;
        r101 = R.id.tv_left_title;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_left_title);
        if (r118 == null) goto L41;
        r101 = R.id.tv_right_title;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_right_title);
        if (r119 == null) goto L41;
        r101 = R.id.tv_second_text;
        TextView r212 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_second_text);
        if (r212 == null) goto L41;
        r101 = R.id.view_credit_indicator;
        View r213 = ViewBindings.findChildViewById(r100, R.id.view_credit_indicator);
        if (r213 == null) goto L41;
        r101 = R.id.view_top_close_range;
        View r214 = ViewBindings.findChildViewById(r100, R.id.view_top_close_range);
        if (r214 == null) goto L41;
        return new LarusFragmentCommerceInviteFriendsBinding((FrameLayout) r100, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void Y90(final String r110, final Function1<? super qz8.l, com.larus.bmhome.share.panel.b> r111) {
        Context r100 = getContext();
        boolean r101 = true;
        if (r100 == null) goto L16;
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r102 == null) goto L7;
        r102.T();
        h2 r103 = h2.f346184a;
    L9:
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
        r103.d(r100);
        r101 = false;
        goto L16
    L11:
        if (r103.isBasicMode() != true) goto L13;
        r104 = true;
        goto L14
    L7:
        r103 = null;
    L16:
        if (r101 == true) goto L18;
        return;
    L18:
        String r105 = "CommerceInviteFriendsFragment_handleShareAction_".concat(r110);
        Function1 r106 = new x(r111, this, r110);
        qz8.l r112 = this.f325740h;
        if (r112 == null) goto L21;
        String r113 = r112.c();
    L23:
        if (o0.d(r113) == false) goto L31;
        qz8.l r114 = this.f325740h;
        if (r114 == null) goto L27;
        String r115 = r114.d();
    L29:
        if (o0.d(r115) == false) goto L31;
        r106.invoke(this.f325740h);
        return;
    L27:
        r115 = null;
    L31:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommerceInviteFriendsFragment$getGroupInvitationInfo$1(r105, this, r106, null), 3, null);
        return;
    L21:
        r113 = null;
        goto L23
    }

    public static final void X90(final CommerceInviteFriendsFragment r100, qz8.d r110, qz8.d r111, boolean r112) {
        r100.getClass();
        if (r112 == false) goto L5;
        qz8.d r101 = r110;
    L6:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("loadCampaignInfo campaignKey=");
        r103.append((String) r100.f325739g.getValue());
        r103.append(" isFromLocal=");
        r103.append(r112);
        r103.append(" campaignInfo=");
        if (r101 == null) goto L13;
        qz8.b r104 = r101.a();
        if (r104 == null) goto L13;
        List<qz8.o> r105 = r104.g();
        if (r105 == null) goto L13;
        Integer r106 = Integer.valueOf(r105.size());
    L14:
        r103.append(r106);
        r102.i("CommerceInviteFriendsFragment", r103.toString());
        if (r101 == null) goto L17;
        qz8.b r107 = r101.a();
    L18:
        if (r107 != null) goto L21;
    L109:
        if (r101 == null) goto L115;
        qz8.b r108 = r101.a();
        if (r108 == null) goto L115;
        List<qz8.o> r109 = r108.g();
        if (r109 == null) goto L115;
        List r113 = CollectionsKt.filterNotNull(r109);
    L116:
        if (r113 == null) goto L135;
        ((CommerceInviteInfoAdapter) r100.f325738f.getValue()).submitList(r113);
        int r114 = Math.min(r113.size() * i5.m0(), ((Number) i5.I1.getValue()).intValue());
        LarusFragmentCommerceInviteFriendsBinding r115 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r115 == null) goto L122;
        RecyclerView r116 = r115.f325706k;
        if (r116 == null) goto L122;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
    L123:
        if (r117 == null) goto L125;
        r117.height = r114;
    L125:
        LarusFragmentCommerceInviteFriendsBinding r118 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r118 == null) goto L130;
        RecyclerView r119 = r118.f325706k;
        if (r119 == null) goto L130;
        r119.setLayoutParams(r117);
    L130:
        LarusFragmentCommerceInviteFriendsBinding r120 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r120 == null) goto L135;
        RecyclerView r121 = r120.f325706k;
        if (r121 == null) goto L135;
        r121.post(new y(r100));
    L122:
        r117 = null;
    L135:
        View r122 = r100.getView();
        if (r122 == null) goto L138;
        r122.post(new b(r100));
    L138:
        if (r110 != null) goto L172;
        if (r111 != null) goto L172;
        if (r112 == true) goto L157;
        LarusFragmentCommerceInviteFriendsBinding r123 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r123 == null) goto L147;
        LinearLayout r124 = r123.f325705j;
        if (r124 == null) goto L147;
        e1.d(r124, new e0(r100));
    L147:
        LarusFragmentCommerceInviteFriendsBinding r125 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r125 == null) goto L152;
        LinearLayout r126 = r125.f325703h;
        if (r126 == null) goto L152;
        e1.q(r126);
    L152:
        LarusFragmentCommerceInviteFriendsBinding r127 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r127 == null) goto L188;
        LinearLayout r128 = r127.f325705j;
        if (r128 == null) goto L189;
        e1.x(r128);
        return;
    L189:
        return;
    L188:
        return;
    L157:
        LarusFragmentCommerceInviteFriendsBinding r129 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r129 == null) goto L162;
        LinearLayout r130 = r129.f325705j;
        if (r130 == null) goto L162;
        r130.setOnClickListener(null);
    L162:
        LarusFragmentCommerceInviteFriendsBinding r131 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r131 == null) goto L167;
        LinearLayout r132 = r131.f325703h;
        if (r132 == null) goto L167;
        e1.q(r132);
    L167:
        LarusFragmentCommerceInviteFriendsBinding r133 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r133 == null) goto L191;
        LinearLayout r134 = r133.f325705j;
        if (r134 == null) goto L192;
        e1.o(r134);
        return;
    L192:
        return;
    L191:
        return;
    L172:
        LarusFragmentCommerceInviteFriendsBinding r135 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r135 == null) goto L177;
        LinearLayout r136 = r135.f325705j;
        if (r136 == null) goto L177;
        r136.setOnClickListener(null);
    L177:
        LarusFragmentCommerceInviteFriendsBinding r137 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r137 == null) goto L182;
        LinearLayout r138 = r137.f325703h;
        if (r138 == null) goto L182;
        e1.x(r138);
    L182:
        LarusFragmentCommerceInviteFriendsBinding r139 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r139 == null) goto L194;
        LinearLayout r140 = r139.f325705j;
        if (r140 == null) goto L195;
        e1.o(r140);
        return;
    L195:
        return;
    L194:
        return;
    L115:
        r113 = null;
        goto L116
    L21:
        if (e2.f365734a.isPad() == false) goto L23;
        String r141 = null;
    L24:
        if (r141 == null) goto L30;
        LarusFragmentCommerceInviteFriendsBinding r142 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r142 == null) goto L30;
        SimpleDraweeView r143 = r142.f325701f;
        if (r143 == null) goto L30;
        ImageLoaderKt.u(r143, r141, "commerce_invite_friends_bg");
    L30:
        LarusFragmentCommerceInviteFriendsBinding r144 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        String r145 = "";
        if (r144 == null) goto L39;
        TextView r146 = r144.f325710o;
        if (r146 == null) goto L39;
        String r147 = r107.h();
        if (r147 != null) goto L38;
        r147 = "";
    L38:
        r146.setText(r147);
    L39:
        LarusFragmentCommerceInviteFriendsBinding r148 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r148 == null) goto L48;
        TextView r149 = r148.f325711p;
        if (r149 == null) goto L48;
        String r150 = r107.i();
        if (r150 != null) goto L47;
        r150 = "";
    L47:
        r149.setText(r150);
    L48:
        String r151 = r107.e();
        if (r151 != null) goto L51;
        r151 = "";
    L51:
        String r152 = r107.d();
        if (r152 != null) goto L54;
        r152 = "";
    L54:
        boolean r153 = true;
        if (r152.length() <= 0) goto L57;
        boolean r154 = true;
    L58:
        if (r154 == false) goto L60;
        String r155 = r151.concat(r152);
    L62:
        if (r152.length() > 0) goto L65;
        r153 = false;
    L65:
        if (r153 == true) goto L67;
    L78:
        LarusFragmentCommerceInviteFriendsBinding r156 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r156 == null) goto L83;
        TextView r157 = r156.f325708m;
        if (r157 == null) goto L83;
        r157.setText(r155);
    L83:
        LarusFragmentCommerceInviteFriendsBinding r158 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r158 == null) goto L92;
        TextView r159 = r158.f325709n;
        if (r159 == null) goto L92;
        String r160 = r107.f();
        if (r160 != null) goto L91;
        r160 = "";
    L91:
        r159.setText(r160);
    L92:
        LarusFragmentCommerceInviteFriendsBinding r161 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r161 == null) goto L101;
        TextView r162 = r161.f325712q;
        if (r162 == null) goto L101;
        String r163 = r107.j();
        if (r163 != null) goto L100;
        r163 = "";
    L100:
        r162.setText(r163);
    L101:
        LarusFragmentCommerceInviteFriendsBinding r164 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r164 == null) goto L109;
        TextView r165 = r164.f325707l;
        if (r165 == null) goto L109;
        String r166 = r107.b();
        if (r166 == null) goto L108;
        r145 = r166;
    L108:
        r165.setText(r145);
        goto L109
    L67:
        if (r107.c() == null) goto L78;
        int r167 = r151.length();
        int r168 = r155.length();
        String r169 = r107.c();
        SpannableString r170 = new SpannableString(r155);
        r170.setSpan(new k0(r169, r100), r167, r168, 33);
        LarusFragmentCommerceInviteFriendsBinding r171 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r171 == null) goto L73;
        TextView r172 = r171.f325708m;
        if (r172 == null) goto L73;
        r172.setText(r170);
    L73:
        LarusFragmentCommerceInviteFriendsBinding r173 = (LarusFragmentCommerceInviteFriendsBinding) r100.f325726d;
        if (r173 == null) goto L83;
        TextView r174 = r173.f325708m;
        if (r174 == null) goto L83;
        r174.setMovementMethod(LinkMovementMethod.getInstance());
        goto L83
    L60:
        r155 = r151;
        goto L62
    L57:
        r154 = false;
        goto L58
    L23:
        r141 = r107.a();
        goto L24
    L17:
        r107 = null;
    L13:
        r106 = null;
        goto L14
    L5:
        r101 = r111;
        goto L6
    }
}
