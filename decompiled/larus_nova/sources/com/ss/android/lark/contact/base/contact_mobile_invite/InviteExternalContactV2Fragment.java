package com.ss.android.lark.contact.base.contact_mobile_invite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.common_ui.InvErrorView;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.contact.base.contact_mobile_invite.invite.InviteExternalContactInviteFragment;
import com.ss.android.lark.contact.base.contact_mobile_invite.using.InviteExternalContactUsingFragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;
import com.ss.android.lark.contact.base.service.InvRequestUtils;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.b0;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_mobile_invite/InviteExternalContactV2Fragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "loading", "Lcom/ss/android/lark/utils/ViewUtils$PageLoadingDialog;", "mFragmentInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/base/fragment/FragmentInfo;", "Lkotlin/collections/ArrayList;", "index", "", "from", "", "isFirst", "", "rootViewBinding", "Lcom/ss/android/lark/contact/base/databinding/InvInviteExternalContactV2ViewBinding;", "iecErrorView", "Lcom/ss/android/lark/contact/base/common_ui/InvErrorView;", "request", "Lcom/ss/android/lark/contact/base/service/InvRequestUtils$LocalAndServerRequest;", "Lcom/ss/android/lark/contact/base/entity/mobile/ContactsMobileFeishuInfo;", "usingFragment", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/using/InviteExternalContactUsingFragment;", "inviteFragment", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/invite/InviteExternalContactInviteFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "init", "fetchData", DyPayConstant.KEY_SHOW_LOADING, "initView", "isFromLocal", "info", "initSearchView", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalContactV2Fragment extends BaseFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f418641n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewUtils.c f418642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<com.ss.android.lark.base.fragment.a> f418643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f418644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f418645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f418646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InvInviteExternalContactV2ViewBinding f418647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InvErrorView f418648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InvRequestUtils.LocalAndServerRequestImpl f418649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InviteExternalContactUsingFragment f418650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InviteExternalContactInviteFragment f418651m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteExternalContactV2Fragment f418652a;

        public b(InviteExternalContactV2Fragment r100) {
            this.f418652a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            InviteExternalContactV2Fragment r101 = this.f418652a;
            int r102 = InviteExternalContactV2Fragment.f418641n;
            r101.getClass();
            InvApmUtils.g("contact_opt_contact_list_timing_ms");
            y8b.a r103 = new y8b.a(r101);
            int r104 = InvRequestUtils.f418898a;
            Intrinsics.checkNotNullParameter(r103, "callback");
            Intrinsics.checkNotNullParameter(r103, "callback");
            InvRequestUtils.LocalAndServerRequestImpl r105 = new InvRequestUtils.LocalAndServerRequestImpl(r103);
            ViewUtils.runOnUiThread(new b0(r105));
            r101.f418649k = r105;
        }
    }

    public static final class c extends IActionTitlebar$TextAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteExternalContactV2Fragment f418653a;

        @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
        public final void performAction(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intent r101 = new Intent();
            String r102 = this.f418653a.f418645g;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("from");
            r102 = null;
        L5:
            r101.putExtra(r102, Notice.CLICK_TYPE_JUMP);
            this.f418653a.setResult(-1, r101);
            this.f418653a.finish();
        }

        public c(InviteExternalContactV2Fragment r100, String r101) {
            this.f418653a = r100;
            super(r101, R.color.lkui_B500);
        }
    }

    static {
    }

    public InviteExternalContactV2Fragment() {
        this.f418643e = new ArrayList();
        this.f418646h = true;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        InvRequestUtils.LocalAndServerRequestImpl r100 = this.f418649k;
        if (r100 == null) goto L6;
        r100.f418902d.cancel();
        r100.f418903e.cancel();
        return;
    }

    public static final /* synthetic */ String S90(InviteExternalContactV2Fragment r100) {
        return r100.PARENT_TAG;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        a0.f(true);
        this.f418648j = (InvErrorView) r100.findViewById(R.id.iecErrorView);
        String r102 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.f418663k;
        Bundle r103 = getArguments();
        String r104 = "";
        if (r103 == null) goto L6;
        String r105 = r103.getString("invite_msg");
        if (r105 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.f418663k = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L11;
        String r107 = r106.getString(BdpAppEventConstant.PARAMS_UNIQUEID);
        if (r107 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.f418664l = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L18;
        String r109 = r108.getString(InvRouter.PARAM_FROM_SCENES);
        if (r109 == null) goto L18;
        r104 = r109;
    L18:
        this.f418645g = r104;
        if (Intrinsics.areEqual("onboarding", r104) == false) goto L32;
        InvInviteExternalContactV2ViewBinding r110 = this.f418647i;
        if (r110 == null) goto L27;
        CommonTitleBar r111 = r110.f418854h;
        if (r111 == null) goto L27;
        TextView r112 = r111.getLeftText();
        if (r112 == null) goto L27;
        r112.setVisibility(8);
    L27:
        c r113 = new c(this, UIHelper.getString(R.string.Lark_Guide_VideoSkip));
        InvInviteExternalContactV2ViewBinding r114 = this.f418647i;
        if (r114 == null) goto L32;
        CommonTitleBar r115 = r114.f418854h;
        if (r115 == null) goto L32;
        r115.addAction(r113);
    L32:
        InvErrorView r116 = this.f418648j;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("iecErrorView");
        r116 = null;
    L35:
        r116.setOnClickListener(new b(this));
        InvApmUtils.g("contact_opt_contact_list_timing_ms");
        y8b.a r117 = new y8b.a(this);
        int r118 = InvRequestUtils.f418898a;
        Intrinsics.checkNotNullParameter(r117, "callback");
        Intrinsics.checkNotNullParameter(r117, "callback");
        InvRequestUtils.LocalAndServerRequestImpl r119 = new InvRequestUtils.LocalAndServerRequestImpl(r117);
        ViewUtils.runOnUiThread(new b0(r119));
        this.f418649k = r119;
        return;
    L11:
        r107 = "";
    L6:
        r105 = "";
        goto L7
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.inv_invite_external_contact_v2_view, r111, false);
        int r114 = R.id.iecContentFl;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.iecContentFl);
        if (r100 == null) goto L23;
        r114 = R.id.iecErrorView;
        if (((InvErrorView) ViewBindings.findChildViewById(r113, R.id.iecErrorView)) == null) goto L23;
        r114 = R.id.iecIndicator;
        UDTabLayout r101 = (UDTabLayout) ViewBindings.findChildViewById(r113, R.id.iecIndicator);
        if (r101 == null) goto L23;
        r114 = R.id.iecSearchClearIv;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r113, R.id.iecSearchClearIv);
        if (r102 == null) goto L23;
        r114 = R.id.iecSearchEt;
        SearchEditText r103 = (SearchEditText) ViewBindings.findChildViewById(r113, R.id.iecSearchEt);
        if (r103 == null) goto L23;
        r114 = R.id.iecSearchRl;
        RelativeLayout r104 = (RelativeLayout) ViewBindings.findChildViewById(r113, R.id.iecSearchRl);
        if (r104 == null) goto L23;
        r114 = R.id.iecShadowView;
        View r105 = ViewBindings.findChildViewById(r113, R.id.iecShadowView);
        if (r105 == null) goto L23;
        r114 = R.id.iecTitleBar;
        CommonTitleBar r106 = (CommonTitleBar) ViewBindings.findChildViewById(r113, R.id.iecTitleBar);
        if (r106 == null) goto L23;
        r114 = R.id.iecViewPager;
        ViewPager r107 = (ViewPager) ViewBindings.findChildViewById(r113, R.id.iecViewPager);
        if (r107 == null) goto L23;
        RelativeLayout r115 = (RelativeLayout) r113;
        this.f418647i = new InvInviteExternalContactV2ViewBinding(r115, r100, r101, r102, r103, r104, r105, r106, r107);
        return r115;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
