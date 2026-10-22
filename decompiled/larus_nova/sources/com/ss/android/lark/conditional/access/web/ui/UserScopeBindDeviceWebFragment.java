package com.ss.android.lark.conditional.access.web.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentBindDeviceWebBinding;
import com.ss.android.lark.conditional.access.network.model.response.BindDeviceWebData;
import com.ss.android.lark.conditional.access.utils.PrivacyPolicyUtils;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = UserScopeBindDeviceWebActivity.class)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001)B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020(H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/conditional/access/web/ui/UserScopeBindDeviceWebFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentBindDeviceWebBinding;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/conditional/access/web/viewmodel/BindDeviceWebViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/web/viewmodel/BindDeviceWebViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mWebDid", "", "mBundleId", "mTvPolicy", "Landroid/widget/TextView;", "mBtnAuthorize", "Lcom/larksuite/component/universe_design/button/UDButton;", "mBtnCancel", "mCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "mTvDesc", "mTvSubDesc", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "popPolicyNotice", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeBindDeviceWebFragment extends Hilt_UserScopeBindDeviceWebFragment<ScsFragmentBindDeviceWebBinding> implements View.OnClickListener, d0c.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f418499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f418500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f418501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f418502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDButton f418503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UDButton f418504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public UDCheckBox f418505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f418506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f418507q;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserScopeBindDeviceWebFragment f418508a;

        public b(UserScopeBindDeviceWebFragment r100) {
            this.f418508a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            BindDeviceWebData r101 = (BindDeviceWebData) r100;
            if (r101 != null) goto L8;
            ScsLogger.c("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb error");
            FragmentActivity r102 = this.f418508a.getActivity();
            if (r102 == null) goto L22;
            UDToast.show(r102, r102.getString(R.string.Lark_Conditions_NetworkFailed));
            return;
        L22:
            return;
        L8:
            if (r101.getSuccess() == false) goto L18;
            ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb success");
            FragmentActivity r103 = this.f418508a.getActivity();
            if (r103 != null) goto L12;
            return;
        L12:
            if (this.f418508a.f418501k.length() != 0) goto L14;
            boolean r104 = true;
        L15:
            if (r104 == false) goto L17;
            r103.finish();
            return;
        L17:
            r103.moveTaskToBack(true);
            r103.finish();
            return;
        L14:
            r104 = false;
            goto L15
        L18:
            ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bindDeviceWeb failed");
            FragmentActivity r105 = this.f418508a.getActivity();
            if (r105 == null) goto L27;
            UDToast.show(r105, r105.getString(R.string.Lark_Conditions_NetworkFailed));
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public UserScopeBindDeviceWebFragment() {
        this.f418499i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindDeviceWebViewModel.class), new UserScopeBindDeviceWebFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeBindDeviceWebFragment$special$$inlined$activityViewModels$default$2(this));
        this.f418500j = "";
        this.f418501k = "";
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (Intrinsics.areEqual(r100, this.f418503m) == false) goto L19;
        UDCheckBox r101 = this.f418505o;
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.isChecked() != true) goto L9;
    L10:
        if (r102 == false) goto L12;
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bind device web, mPolicyAgree: true, web id: " + this.f418500j + ", bundleID: " + this.f418501k);
        ((BindDeviceWebViewModel) this.f418499i.getValue()).bindDeviceWeb(this.f418500j);
        return;
    L12:
        int r104 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "bind device web, mPolicyAgree: false, web id: " + this.f418500j + ", bundleID: " + this.f418501k);
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "popPolicyNotice");
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L25;
        UDDialogBuilder r106 = new UDDialogBuilder(r105);
        View r107 = LayoutInflater.from(r105).inflate(R.layout.scs_widget_dialog_content, null);
        TextView r108 = (TextView) r107.findViewById(R.id.tv_content_message);
        if (r108 == null) goto L17;
        new PrivacyPolicyUtils.c(r108, R.string.Lark_Conditions_PleaseReadAndAgree).a();
    L17:
        r106.title(r105.getString(R.string.Lark_Conditions_TipsNotice)).contentLayout(r107).addActionButton(R.id.ud_dialog_btn_primary, r105.getString(R.string.Lark_Conditions_OK), new d(this)).addActionButton(R.id.ud_dialog_btn_secondary, r105.getString(R.string.Lark_Conditions_CancelButton), new e(this)).show();
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "did show pop policy notice, web did: " + this.f418500j);
        return;
    L25:
        return;
    L9:
        r102 = false;
        goto L10
    L19:
        if (Intrinsics.areEqual(r100, this.f418504n) == false) goto L27;
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "cancel bind device web id: " + this.f418500j + ", bundleID: " + this.f418501k);
        FragmentActivity r110 = getActivity();
        if (r110 == null) goto L28;
        r110.finish();
        return;
    L28:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.scs_fragment_bind_device_web, r101, false);
        int r103 = R.id.btn_authorize;
        if (((UDButton) ViewBindings.findChildViewById(r102, R.id.btn_authorize)) == null) goto L25;
        r103 = R.id.btn_cancel;
        if (((UDButton) ViewBindings.findChildViewById(r102, R.id.btn_cancel)) == null) goto L25;
        r103 = R.id.check_box_policy;
        if (((UDCheckBox) ViewBindings.findChildViewById(r102, R.id.check_box_policy)) == null) goto L25;
        r103 = R.id.ll_subtitle;
        if (((LinearLayout) ViewBindings.findChildViewById(r102, R.id.ll_subtitle)) == null) goto L25;
        r103 = R.id.ll_subtitle2;
        if (((LinearLayout) ViewBindings.findChildViewById(r102, R.id.ll_subtitle2)) == null) goto L25;
        r103 = R.id.tv_desc;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_desc)) == null) goto L25;
        r103 = R.id.tv_desc2;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_desc2)) == null) goto L25;
        r103 = R.id.tv_policy;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_policy)) == null) goto L25;
        r103 = R.id.tv_sub_desc;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_sub_desc)) == null) goto L25;
        r103 = R.id.tv_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_title)) == null) goto L25;
        return new ScsFragmentBindDeviceWebBinding((ConstraintLayout) r102);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getString("web_did");
    L6:
        this.f418500j = String.valueOf(r104);
        Bundle r105 = getArguments();
        if (r105 == null) goto L9;
        String r106 = r105.getString("bundle_id");
    L10:
        this.f418501k = String.valueOf(r106);
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L13;
        UDButton r108 = (UDButton) r107.findViewById(R.id.btn_authorize);
    L14:
        this.f418503m = r108;
        FragmentActivity r109 = getActivity();
        if (r109 == null) goto L17;
        UDButton r110 = (UDButton) r109.findViewById(R.id.btn_cancel);
    L18:
        this.f418504n = r110;
        UDButton r111 = this.f418503m;
        if (r111 == null) goto L21;
        r111.setOnClickListener(this);
    L21:
        UDButton r112 = this.f418504n;
        if (r112 == null) goto L24;
        r112.setOnClickListener(this);
    L24:
        FragmentActivity r113 = getActivity();
        if (r113 == null) goto L27;
        TextView r114 = (TextView) r113.findViewById(R.id.tv_policy);
    L28:
        this.f418502l = r114;
        FragmentActivity r115 = getActivity();
        if (r115 == null) goto L31;
        UDCheckBox r116 = (UDCheckBox) r115.findViewById(R.id.check_box_policy);
    L32:
        this.f418505o = r116;
        FragmentActivity r117 = getActivity();
        if (r117 == null) goto L35;
        TextView r118 = (TextView) r117.findViewById(R.id.tv_desc);
    L36:
        this.f418506p = r118;
        FragmentActivity r119 = getActivity();
        if (r119 == null) goto L39;
        TextView r120 = (TextView) r119.findViewById(R.id.tv_desc2);
    L40:
        this.f418507q = r120;
        TextView r121 = this.f418502l;
        if (r121 == null) goto L43;
        new PrivacyPolicyUtils.c(r121, R.string.Lark_Conditions_IAgree).a();
    L43:
        TextView r122 = this.f418506p;
        if (r122 == null) goto L50;
        FragmentActivity r123 = getActivity();
        if (r123 == null) goto L48;
        String r124 = com.ss.android.lark.security.compliance.infra.util.a.f440477a.a(r123);
    L49:
        r122.setText(UIHelper.mustacheFormat(R.string.Lark_Conditions_BecauseCompany, "brand", r124));
        goto L50
    L48:
        r124 = null;
    L50:
        TextView r125 = this.f418507q;
        if (r125 == null) goto L56;
        FragmentActivity r126 = getActivity();
        if (r126 == null) goto L55;
        r103 = com.ss.android.lark.security.compliance.infra.util.a.f440477a.a(r126);
    L55:
        r125.setText(UIHelper.mustacheFormat(R.string.Lark_Conditions_BrandDevicing, "brand", r103));
    L56:
        ((BindDeviceWebViewModel) this.f418499i.getValue()).getBindDeviceWebLiveData().observe(getViewLifecycleOwner(), new b(this));
        return;
    L39:
        r120 = null;
        goto L40
    L35:
        r118 = null;
        goto L36
    L31:
        r116 = null;
        goto L32
    L27:
        r114 = null;
        goto L28
    L17:
        r110 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
