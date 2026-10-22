package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.item.BaseItemAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "from", "", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalViewFeishuBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "qrCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "getQrCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "qrCodeHandler$delegate", "showLoadingRunnable", "Ljava/lang/Runnable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initData", "initView", "copyDoubaoId", DyPayConstant.KEY_SHOW_LOADING, "dismissLoading", "cancelDelayedLoading", "showError", "getExternalItems", "", "Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalItem;", "bindQrCard", "info", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfo;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalFragment extends InvBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f419262i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f419263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContactDbInviteExternalViewFeishuBinding f419264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f419266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f419267h;

    public static final class a {
    }

    static {
    }

    public final OfficeInviteExternalViewModel U90() {
        return (OfficeInviteExternalViewModel) this.f419265f.getValue();
    }

    public OfficeInviteExternalFragment() {
        final Function0<Fragment> r100 = new OfficeInviteExternalFragment$special$$inlined$viewModels$default$1(this);
        this.f419265f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeInviteExternalViewModel.class), new OfficeInviteExternalFragment$special$$inlined$viewModels$default$2(r100), new OfficeInviteExternalFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f419266g = LazyKt.lazy(OfficeInviteExternalFragment$qrCodeHandler$2.INSTANCE);
    }

    public static final void S90(OfficeInviteExternalFragment r100) {
        r100.getClass();
        String r101 = ((x1c.d) OfficeContactUtils.f418960a.getValue()).y1().f562155b;
        Intrinsics.checkNotNullParameter("LARK-PSDA-ug-invite-external", "psdaToken");
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L23;
    L15:
        r102 = false;
    L16:
        if (r102 == false) goto L25;
        ContactDbInviteExternalViewFeishuBinding r104 = r100.f419264e;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L21:
        FlowToast.a r105 = FlowToast.a(r104.f419046a.getContext());
        String r106 = UIHelper.getString(R.string.LarkIM_Friend_AddContact_Copied_Toast);
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.f417628b = r106;
        r105.f417629c = UDIconUtils.getIconDrawable(r105.f417627a, R.drawable.contact_db_icon_succeed);
        r105.c(49, 0, UIHelper.dp2px(44.0f));
        r105.a().show();
        return;
    L25:
        return;
    L23:
        Token r107 = new Token("LARK-PSDA-ug-invite-external");     // Catch: SensitiveAPIException -> L13
        qf7.a r108 = qf7.a.f532746a;     // Catch: SensitiveAPIException -> L13
        Object r109 = LarkContext.getApplication().getSystemService(DataType.CLIPBOARD);     // Catch: SensitiveAPIException -> L13
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: SensitiveAPIException -> L13
        r108.a((ClipboardManager) r109, ClipData.newPlainText("text", r101), r107);     // Catch: SensitiveAPIException -> L13
    L13:
        e = move-exception;
        Log.e("Contact_Utils", "copyText error", e);
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static final void T90(OfficeInviteExternalFragment r100) {
        j r101 = r100.f419267h;
        ContactDbInviteExternalViewFeishuBinding r102 = null;
        if (r101 == null) goto L9;
        ContactDbInviteExternalViewFeishuBinding r103 = r100.f419264e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L8:
        r103.f419046a.removeCallbacks(r101);
        r100.f419267h = null;
    L9:
        ContactDbInviteExternalViewFeishuBinding r104 = r100.f419264e;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L12:
        r104.f419049d.a();
        ContactDbInviteExternalViewFeishuBinding r105 = r100.f419264e;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L15:
        r105.f419048c.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r106 = r100.f419264e;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L19:
        if (r106.f419047b.getVisibility() == 0) goto L26;
        ContactDbInviteExternalViewFeishuBinding r107 = r100.f419264e;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L24:
        r102.f419060o.setVisibility(0);
        return;
    L23:
        r102 = r107;
        goto L24
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L5;
        Lazy r103 = OfficeContactUtils.f418960a;
        OfficeContactUtils.e(this, UIUtils.getColor(r102, R.color.flow_ud_bg_base_1));
    L5:
        Bundle r104 = getArguments();
        ContactDbInviteExternalViewFeishuBinding r105 = null;
        if (r104 == null) goto L8;
        String r106 = r104.getString(InvRouter.PARAM_FROM_SCENES);
    L9:
        this.f419263d = r106;
        ContactDbInviteExternalViewFeishuBinding r107 = this.f419264e;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r107 = null;
    L12:
        r107.f419057l.setVisibility(0);
        if (OfficeContactUtils.f() == false) goto L18;
        ContactDbInviteExternalViewFeishuBinding r108 = this.f419264e;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r108 = null;
    L17:
        r108.f419062q.setTitle(UIHelper.getString(R.string.Lark_NewContacts_AddExternalContactsB));
    L18:
        ContactDbInviteExternalViewFeishuBinding r109 = this.f419264e;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r109 = null;
    L21:
        r109.f419062q.setLeftIconClickListener(new c(this));
        ICUUtils.FormatArgsBuilder r110 = new ICUUtils.FormatArgsBuilder();
        r110.b("brandName", UIHelper.getAppName());
        List<ICUUtils.UFormatPair> r111 = r110.f285892a;
        ContactDbInviteExternalViewFeishuBinding r112 = this.f419264e;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L24:
        r112.f419061p.setText(ICUUtils.icuFormat(UIHelper.getString(R.string.LarkIM_Friend_SearchPhoneOrBrandAdd_Placeholder), r111));
        ContactDbInviteExternalViewFeishuBinding r113 = this.f419264e;
        if (r113 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L27:
        ViewCompat.setTransitionName(r113.f419059n, "contact_db_transition_invite_search_bar");
        ContactDbInviteExternalViewFeishuBinding r114 = this.f419264e;
        if (r114 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L30:
        r114.f419059n.setOnClickListener(new d(this));
        ContactDbInviteExternalViewFeishuBinding r115 = this.f419264e;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r115 = null;
    L33:
        r115.f419059n.setOnLongClickListener(new e(this));
        BaseItemAdapter r116 = new BaseItemAdapter();
        ArrayList r117 = new ArrayList();
        r117.add(new k(UIHelper.getString(R.string.LarkIM_Friend_ScanCode_Title), UIHelper.getString(R.string.LarkIM_Friend_ScanCode_Desc), new com.ss.android.lark.contact.customized.externalinvite.view.a(this)));
        r116.f448189a = r117;
        ContactDbInviteExternalViewFeishuBinding r118 = this.f419264e;
        if (r118 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r118 = null;
    L36:
        r118.f419058m.setAdapter(r116);
        ContactDbInviteExternalViewFeishuBinding r119 = this.f419264e;
        if (r119 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L39:
        r119.f419058m.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (OfficeContactUtils.f() == false) goto L45;
        ContactDbInviteExternalViewFeishuBinding r120 = this.f419264e;
        if (r120 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L44:
        r120.f419054i.setVisibility(8);
    L55:
        ContactDbInviteExternalViewFeishuBinding r121 = this.f419264e;
        if (r121 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L59:
        r105.f419050e.setOnClickListener(h.f419276a);
        int r122 = com.ss.android.lark.contact.customized.common.b.f418964a;
        String r123 = this.f419263d;
        String r124 = "";
        if (r123 != null) goto L62;
        r123 = "";
    L62:
        Intrinsics.checkNotNullParameter(r123, "previousPage");
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Statistics.sendEvent("enter_add_friend_page", new JSONObject().put("previous_page", r123).put("current_page", "profile_add_friend"));
        String r125 = this.f419263d;
        if (r125 == null) goto L66;
        r124 = r125;
    L66:
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter(r124, "enterFrom");
        Statistics.sendEvent("search_bar_show", new JSONObject().put("function_type", "contact").put("current_page", "profile_add_friend").put("enter_from", r124));
        U90().getInvitationInfoGroupLiveData().observe(getViewLifecycleOwner(), new b(this));
        U90().onPageViewCreated(SystemClock.elapsedRealtime());
        U90().fetchContactToken();
        return;
    L58:
        r105 = r121;
        goto L59
    L45:
        ContactDbInviteExternalViewFeishuBinding r126 = this.f419264e;
        if (r126 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r126 = null;
    L48:
        r126.f419054i.setVisibility(0);
        ContactDbInviteExternalViewFeishuBinding r127 = this.f419264e;
        if (r127 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r127 = null;
    L51:
        r127.f419054i.setOnClickListener(new f(this));
        ContactDbInviteExternalViewFeishuBinding r128 = this.f419264e;
        if (r128 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r128 = null;
    L54:
        r128.f419055j.setOnLongClickListener(new g(this));
        goto L55
    L8:
        r106 = null;
        goto L9
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.contact_db_invite_external_view_feishu, r211, false);
        int r101 = R.id.iefErrorView;
        ContactOfficeEmptyStateView r102 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r100, R.id.iefErrorView);
        if (r102 == null) goto L43;
        r101 = R.id.iefLoadingLayout;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.iefLoadingLayout);
        if (r103 == null) goto L43;
        r101 = R.id.iefLoadingSpinner;
        ContactOfficeLoadingView r104 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r100, R.id.iefLoadingSpinner);
        if (r104 == null) goto L43;
        r101 = R.id.iefQrCard;
        if (((LKUIRoundLinearLayout) ViewBindings.findChildViewById(r100, R.id.iefQrCard)) == null) goto L43;
        r101 = R.id.iefQrContainer;
        LKUIRoundableLayout r105 = (LKUIRoundableLayout) ViewBindings.findChildViewById(r100, R.id.iefQrContainer);
        if (r105 == null) goto L43;
        r101 = R.id.iefQrIv;
        LKUIRoundedImageView2 r106 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(r100, R.id.iefQrIv);
        if (r106 == null) goto L43;
        r101 = R.id.iefQrLogo;
        LKUIRoundedImageView2 r110 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(r100, R.id.iefQrLogo);
        if (r110 == null) goto L43;
        r101 = R.id.iefQrNameTv;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r100, R.id.iefQrNameTv);
        if (r111 == null) goto L43;
        r101 = R.id.iefQrTipIcon;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iefQrTipIcon);
        if (r112 == null) goto L43;
        r101 = R.id.iefQrTipLayout;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.iefQrTipLayout);
        if (r113 == null) goto L43;
        r101 = R.id.iefQrTipTv;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r100, R.id.iefQrTipTv);
        if (r114 == null) goto L43;
        LinearLayout r107 = (LinearLayout) r100;
        RecyclerView r115 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.iefRv);
        if (r115 == null) goto L40;
        LKUIRoundLinearLayout r116 = (LKUIRoundLinearLayout) ViewBindings.findChildViewById(r100, R.id.iefSearchLl);
        if (r116 == null) goto L39;
        ScrollView r117 = (ScrollView) ViewBindings.findChildViewById(r100, R.id.iefSearchRoot);
        if (r117 == null) goto L38;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.iefSearchTv);
        if (r118 == null) goto L37;
        ContactOfficeTitleBar r213 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r100, R.id.iefTitleBar);
        if (r213 == null) goto L36;
        this.f419264e = new ContactDbInviteExternalViewFeishuBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r115, r116, r117, r118, r213);
        return r107;
    L36:
        r101 = R.id.iefTitleBar;
        goto L43
    L37:
        r101 = R.id.iefSearchTv;
        goto L43
    L38:
        r101 = R.id.iefSearchRoot;
        goto L43
    L39:
        r101 = R.id.iefSearchLl;
        goto L43
    L40:
        r101 = R.id.iefRv;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
