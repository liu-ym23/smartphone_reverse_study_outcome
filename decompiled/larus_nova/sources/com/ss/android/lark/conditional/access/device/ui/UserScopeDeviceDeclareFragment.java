package com.ss.android.lark.conditional.access.device.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.google.android.flexbox.FlexboxLayout;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.RomUtils;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentDeviceDeclareOldBinding;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = UserScopeDeviceDeclareActivity.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001?B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000fH\u0002J\u001c\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&H\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0012\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010!H\u0016J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u001fH\u0002J\b\u0010;\u001a\u00020\u001fH\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J\b\u0010=\u001a\u00020>H\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006@"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeviceDeclareFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentDeviceDeclareOldBinding;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "kvStorage", "Lcom/ss/android/lark/storage/kv/storage/KVStorage;", "getKvStorage$annotations", "getKvStorage", "()Lcom/ss/android/lark/storage/kv/storage/KVStorage;", "setKvStorage", "(Lcom/ss/android/lark/storage/kv/storage/KVStorage;)V", "mApplyStatus", "", "Ljava/lang/Integer;", "mNeedProbe", "", "viewModel", "Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "getOS", "", "getDeviceName", "getDeviceInfo", "getApplyStatusLocalData", "updateApplyStatusLocalData", "status", "refreshDeviceStateUI", "applyStatus", "rejectReasonInfo", "getApplySwitchStatus", "showApplyStatusDialog", "refreshDeviceOwnerUI", "ownership", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "refreshApplyStatus", "showApplyActionPanel", "applyDeviceOwner", "deviceOwnership", "Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceOwnership;", "showApplyProcessingDialog", "showApplySuccessDialog", "showApplyRejectDialog", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeDeviceDeclareFragment extends Hilt_UserScopeDeviceDeclareFragment<ScsFragmentDeviceDeclareOldBinding> implements View.OnClickListener, d0c.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f418024m = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.storage.kv.storage.a f418025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f418026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f418027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f418028l;

    public static final class a {
    }

    public static final class b implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserScopeDeviceDeclareFragment f418029a;

        public b(UserScopeDeviceDeclareFragment r100) {
            this.f418029a = r100;
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            if (r100 != 0) goto L4;
            UserScopeDeviceDeclareFragment.X90(this.f418029a, ConditionalAccessNetDependency.DeviceOwnership.Company);
            return;
        L4:
            UserScopeDeviceDeclareFragment.X90(this.f418029a, ConditionalAccessNetDependency.DeviceOwnership.Personal);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void aa0() {
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "getDeviceInfo");
        if (this.f418026j != null) goto L9;
        com.ss.android.lark.storage.kv.storage.a r100 = this.f418025i;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r100 = null;
    L8:
        com.ss.android.lark.storage.a r101 = com.ss.android.lark.security.compliance.infra.storage.d.f440474a;
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f418026j = Integer.valueOf(LarkKVStorage.d(LarkKVStorage.f440926a, r100, com.ss.android.lark.security.compliance.infra.storage.d.f440474a, "common").getInt("scs_sp_conditional_access_apply_status", ConditionalAccessNetDependency.DeviceApplyStatus.Unknown.getValue()));
    L9:
        ba0().getDeviceInfo();
    }

    public final DeviceDeclareViewModel ba0() {
        return (DeviceDeclareViewModel) this.f418028l.getValue();
    }

    public UserScopeDeviceDeclareFragment() {
        this.f418028l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeviceDeclareViewModel.class), new UserScopeDeviceDeclareFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeDeviceDeclareFragment$special$$inlined$activityViewModels$default$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void da0() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L6;
        ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(r100).title(r100.getString(R.string.Lark_Conditions_SelectBelonging))).items(CollectionsKt.listOf(new String[]{r100.getString(R.string.Lark_SelfDeclareDevice_Option_OrganizationDevice), r100.getString(R.string.Lark_SelfDeclareDevice_Option_PersonalDevice)})).itemClickListener(new b(this)).addActionButton(R.id.ud_dialog_btn_cancel, r100.getString(R.string.Lark_Conditions_CancelButton), null)).show();
        return;
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (Intrinsics.areEqual(r100, ((ScsFragmentDeviceDeclareOldBinding) T90()).f417974b) == false) goto L6;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "btnApply onclick");
        da0();
        return;
    L6:
        if (Intrinsics.areEqual(r100, ((ScsFragmentDeviceDeclareOldBinding) T90()).f417982j) == false) goto L13;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "llRefreshContainer onclick");
        p8b.a.a("refresh");
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L10;
        UDToast.show(r101, r101.getString(R.string.Lark_Conditions_DeclarationUnderReview));
    L10:
        aa0();
        return;
    }

    public static final void X90(UserScopeDeviceDeclareFragment r100, ConditionalAccessNetDependency.DeviceOwnership r101) {
        r100.getClass();
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "applyDeviceOwner, owner: " + r101);
        if (r100.ba0().deviceApplyReasonEnable() == false) goto L5;
        r100.ba0().launchReasonEditPage(r101.getValue());
        return;
    L5:
        DeviceDeclareViewModel.applyDevice$default(r100.ba0(), r101.getValue(), null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y90(UserScopeDeviceDeclareFragment r100, int r101) {
        TextView r102 = ((ScsFragmentDeviceDeclareOldBinding) r100.T90()).f417979g;
        if (r101 != ConditionalAccessNetDependency.DeviceOwnership.Company.getValue()) goto L8;
        FragmentActivity r103 = r100.getActivity();
        if (r103 == null) goto L15;
        String r104 = r103.getString(R.string.Lark_SelfDeclareDevice_Option_OrganizationDevice);
    L16:
        r102.setText(r104);
        return;
    L15:
        r104 = null;
        goto L16
    L8:
        if (r101 != ConditionalAccessNetDependency.DeviceOwnership.Personal.getValue()) goto L12;
        FragmentActivity r105 = r100.getActivity();
        if (r105 == null) goto L15;
        r104 = r105.getString(R.string.Lark_SelfDeclareDevice_Option_PersonalDevice);
        goto L16
    L12:
        FragmentActivity r106 = r100.getActivity();
        if (r106 == null) goto L15;
        r104 = r106.getString(R.string.Lark_Conditions_UnknownUnknown);
        goto L16
    }

    public static final void Z90(UserScopeDeviceDeclareFragment r100, int r101) {
        r100.getClass();
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "showApplyStatusDialog, applyStatus: " + r101);
        if (r101 != ConditionalAccessNetDependency.DeviceApplyStatus.Pass.getValue()) goto L11;
        FragmentActivity r103 = r100.getActivity();
        if (r103 == null) goto L21;
        UDDialogBuilder r104 = new UDDialogBuilder(r103);
        if (r100.f418027k == false) goto L9;
        r104.title(r103.getString(R.string.Lark_Conditions_TipsNotice)).message(r103.getString(R.string.Lark_Conditions_SuccessfulYay)).addActionButton(R.id.ud_dialog_btn_secondary, r103.getString(R.string.Lark_Conditions_GotIt), l.f418039a).addActionButton(R.id.ud_dialog_btn_primary, r103.getString(R.string.Lark_Conditions_VisitAgain), new m(r100)).show();
        return;
    L9:
        r104.title(r103.getString(R.string.Lark_Conditions_TipsNotice)).message(r103.getString(R.string.Lark_Conditions_SuccessfulYay)).addActionButton(R.id.ud_dialog_btn_primary, r103.getString(R.string.Lark_Conditions_GotIt), n.f418041a).show();
        return;
    L21:
        return;
    L11:
        if (r101 != ConditionalAccessNetDependency.DeviceApplyStatus.Processing.getValue()) goto L16;
        FragmentActivity r105 = r100.getActivity();
        if (r105 == null) goto L24;
        new UDDialogBuilder(r105).title(r105.getString(R.string.Lark_Conditions_TipsNotice)).message(r105.getString(R.string.Lark_Conditions_Submitted)).addActionButton(R.id.ud_dialog_btn_primary, r105.getString(R.string.Lark_Conditions_GotIt), i.f418036a).show();
        return;
    L24:
        return;
    L16:
        if (r101 != ConditionalAccessNetDependency.DeviceApplyStatus.Reject.getValue()) goto L26;
        FragmentActivity r106 = r100.getActivity();
        if (r106 == null) goto L27;
        new UDDialogBuilder(r106).title(r106.getString(R.string.Lark_Conditions_TipsNotice)).message(r106.getString(R.string.Lark_Conditions_TakenBack)).addActionButton(R.id.ud_dialog_btn_secondary, r106.getString(R.string.Lark_Conditions_GotIt), j.f418037a).addActionButton(R.id.ud_dialog_btn_primary, r106.getString(R.string.Lark_Conditions_OkDoAgain), new k(r100)).show();
        return;
    L27:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r110, ViewGroup r111) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.scs_fragment_device_declare_old, r111, false);
        int r101 = R.id.applyButton;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.applyButton);
        if (r102 == null) goto L43;
        r101 = R.id.applyGroup;
        Group r103 = (Group) ViewBindings.findChildViewById(r100, R.id.applyGroup);
        if (r103 == null) goto L43;
        r101 = R.id.deviceApplyStatus;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.deviceApplyStatus);
        if (r104 == null) goto L43;
        r101 = R.id.deviceInfoContainer;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.deviceInfoContainer)) == null) goto L43;
        r101 = R.id.deviceName;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.deviceName);
        if (r105 == null) goto L43;
        r101 = R.id.deviceNameContainer;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.deviceNameContainer)) == null) goto L43;
        r101 = R.id.deviceOS;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r100, R.id.deviceOS);
        if (r106 == null) goto L43;
        r101 = R.id.deviceOSContainer;
        if (((FlexboxLayout) ViewBindings.findChildViewById(r100, R.id.deviceOSContainer)) == null) goto L43;
        r101 = R.id.deviceOwner;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r100, R.id.deviceOwner);
        if (r112 == null) goto L43;
        r101 = R.id.deviceOwnerContainer;
        if (((FlexboxLayout) ViewBindings.findChildViewById(r100, R.id.deviceOwnerContainer)) == null) goto L43;
        r101 = R.id.emptySpace;
        if (((Space) ViewBindings.findChildViewById(r100, R.id.emptySpace)) == null) goto L43;
        r101 = R.id.iv_device_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.iv_device_icon)) == null) goto L43;
        r101 = R.id.lineApply;
        View r113 = ViewBindings.findChildViewById(r100, R.id.lineApply);
        if (r113 == null) goto L43;
        r101 = R.id.lineRefresh;
        View r114 = ViewBindings.findChildViewById(r100, R.id.lineRefresh);
        if (r114 == null) goto L43;
        r101 = R.id.refreshButton;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.refreshButton);
        if (r115 == null) goto L43;
        r101 = R.id.refreshGroup;
        Group r116 = (Group) ViewBindings.findChildViewById(r100, R.id.refreshGroup);
        if (r116 == null) goto L43;
        r101 = R.id.rejectReason;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.rejectReason);
        if (r117 == null) goto L43;
        r101 = R.id.rejectReasonContainer;
        if (((ScrollView) ViewBindings.findChildViewById(r100, R.id.rejectReasonContainer)) == null) goto L43;
        r101 = R.id.tv_hint;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.tv_hint)) == null) goto L43;
        return new ScsFragmentDeviceDeclareOldBinding((ConstraintLayout) r100, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r117);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ca0(int r100, String r101) {
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417975c.setVisibility(8);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417983k.setVisibility(8);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417984l.setVisibility(8);
        if (r100 != ConditionalAccessNetDependency.DeviceApplyStatus.Pass.getValue()) goto L5;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setText(getString(R.string.Lark_Conditions_OngoingHere));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setTextColor(getResources().getColor(R.color.udtoken_tag_text_s_green));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setBackground(getResources().getDrawable(R.drawable.scs_bg_green_text));
        return;
    L5:
        boolean r102 = false;
        if (r100 != ConditionalAccessNetDependency.DeviceApplyStatus.Processing.getValue()) goto L9;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setText(getString(R.string.Lark_Conditions_NotYet));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setTextColor(getResources().getColor(R.color.udtoken_tag_text_s_purple));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setBackground(getResources().getDrawable(R.drawable.scs_bg_purple_text));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417983k.setVisibility(0);
        return;
    L9:
        if (r100 != ConditionalAccessNetDependency.DeviceApplyStatus.Reject.getValue()) goto L26;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setText(getString(R.string.Lark_Conditions_FailedFailed));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setTextColor(getResources().getColor(R.color.udtoken_tag_text_s_red));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setBackground(getResources().getDrawable(R.drawable.scs_bg_red_text));
        if (ba0().deviceApplyReasonEnable() == false) goto L25;
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417984l.setVisibility(0);
        StringBuilder r103 = new StringBuilder(String.valueOf(getString(R.string.Lark_SelfDeclareDevice_Title_ReasonforRejection)));
        if (r101 == null) goto L22;
        String r104 = StringsKt.trim(r101).toString();
        if (r104 == null) goto L22;
        if (r104.length() <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 != true) goto L22;
        r102 = true;
        goto L22
    L19:
        r105 = false;
    L22:
        if (r102 == false) goto L24;
        TextView r106 = ((ScsFragmentDeviceDeclareOldBinding) T90()).f417984l;
        r103.append(r101);
        r106.setText(r103.toString());
        goto L25
    L24:
        TextView r107 = ((ScsFragmentDeviceDeclareOldBinding) T90()).f417984l;
        r103.append("-");
        r107.setText(r103.toString());
    L25:
        ba0().getDeviceApplySwitchData();
        return;
    L26:
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setText(getString(R.string.Lark_Conditions_StatusOfThis));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setTextColor(getResources().getColor(R.color.udtoken_tag_neutral_text_normal));
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417976d.setBackground(getResources().getDrawable(R.drawable.scs_bg_grey_text));
        ba0().getDeviceApplySwitchData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "onViewCreated");
        Bundle r102 = getArguments();
        boolean r103 = false;
        if (r102 == null) goto L5;
        r103 = r102.getBoolean("need_probe", false);
    L5:
        this.f418027k = r103;
        String r104 = null;
        if (r103 == true) goto L8;
        p8b.a.d("scs_device_declare_view", null);
    L8:
        CommonTitleBar r105 = S90();
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L11;
        r104 = r106.getString(R.string.Lark_Conditions_Device);
    L11:
        r105.setTitle(r104);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417977e.setText(RomUtils.c());
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417978f.setText(RomUtils.d());
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417974b.setOnClickListener(this);
        ((ScsFragmentDeviceDeclareOldBinding) T90()).f417982j.setOnClickListener(this);
        ba0().getDeviceInfoLiveData().observe(getViewLifecycleOwner(), new e(this));
        ba0().getDeviceApplySwitchLiveData().observe(getViewLifecycleOwner(), new f(this));
        ba0().getApplyDeviceLiveData().observe(getViewLifecycleOwner(), new g(this));
        ba0().getPinLiveData().observe(getViewLifecycleOwner(), new h(this));
        aa0();
    }
}
