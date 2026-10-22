package com.ss.android.lark.conditional.access.device.ui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentDeclareReasonEditBinding;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.ss.android.lark.conditional.access.network.model.response.ApplyDeviceData;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.widget.CustomApplyButton;
import com.suite.lark.emm.design.edittext.SCEditText;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = UserScopeDeviceDeclareActivity.class)
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment;", "Lcom/ss/android/lark/conditional/access/device/ui/BaseTitleBarFragment;", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentDeclareReasonEditBinding;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/device/viewmodel/DeviceDeclareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "maxLength", "", "applyButton", "Lcom/ss/android/lark/security/compliance/infra/widget/CustomApplyButton;", "backCallback", "com/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment$backCallback$1", "Lcom/ss/android/lark/conditional/access/device/ui/UserScopeDeclareReasonEditFragment$backCallback$1;", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "updateInputTextCount", "length", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeDeclareReasonEditFragment extends Hilt_UserScopeDeclareReasonEditFragment<ScsFragmentDeclareReasonEditBinding> implements d0c.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f418014m = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f418015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f418016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CustomApplyButton f418017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UserScopeDeclareReasonEditFragment$backCallback$1 f418018l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f418019a = null;

        static {
            f418019a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserScopeDeclareReasonEditFragment f418020a;

        public c(UserScopeDeclareReasonEditFragment r100) {
            this.f418020a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ApplyDeviceData r101 = (ApplyDeviceData) r100;
            CustomApplyButton r102 = this.f418020a.f418017k;
            if (r102 == null) goto L5;
            r102.f440483b.f440427c.clearAnimation();
        L5:
            setEnabled(false);
            if (r101 == null) goto L8;
            this.f418020a.V90();
            ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "apply finished with success, close page");
            return;
        L8:
            ((ScsFragmentDeclareReasonEditBinding) this.f418020a.T90()).f417972d.setEnabled(true);
            ((ScsFragmentDeclareReasonEditBinding) this.f418020a.T90()).f417970b.setEnabled(true);
            this.f418020a.S90().getLeftText().setEnabled(true);
            UserScopeDeclareReasonEditFragment r103 = this.f418020a;
            r103.Y90(TextUtils.getTrimmedLength(((ScsFragmentDeclareReasonEditBinding) r103.T90()).f417972d.getEditableText()));
            ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "apply finished with error, recovery ui");
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

    public final DeviceDeclareViewModel X90() {
        return (DeviceDeclareViewModel) this.f418015i.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.conditional.access.device.ui.UserScopeDeclareReasonEditFragment$backCallback$1] */
    public UserScopeDeclareReasonEditFragment() {
        this.f418015i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DeviceDeclareViewModel.class), new UserScopeDeclareReasonEditFragment$special$$inlined$activityViewModels$default$1(this), new UserScopeDeclareReasonEditFragment$special$$inlined$activityViewModels$default$2(this));
        this.f418016j = 255;
        this.f418018l = new UserScopeDeclareReasonEditFragment$backCallback$1();
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
    public final void Y90(int r100) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        String r102 = String.valueOf(r100);
        r101.append(r102).append(HTTP.URL_DEFAULT).append(String.valueOf(this.f418016j));
        if (r100 <= this.f418016j) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L12;
        r101.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.mContext, R.color.function_danger_fill_default)), 0, r102.length(), 17);
        CustomApplyButton r104 = this.f418017k;
        if (r104 == null) goto L11;
        r104.b(CustomApplyButton.ApplyButtonStatus.DISABLE);
    L11:
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "disable apply button");
    L16:
        ((ScsFragmentDeclareReasonEditBinding) T90()).f417971c.setText(r101);
        return;
    L12:
        CustomApplyButton r105 = this.f418017k;
        if (r105 == null) goto L15;
        r105.b(CustomApplyButton.ApplyButtonStatus.ENABLE);
    L15:
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "enable apply button");
        goto L16
    L5:
        r103 = false;
        goto L7
    }

    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment
    public final ViewBinding U90(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.scs_fragment_declare_reason_edit, r101, false);
        int r103 = R.id.editContainer;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.editContainer);
        if (r104 == null) goto L11;
        r103 = R.id.editTextCount;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.editTextCount);
        if (r105 == null) goto L11;
        r103 = R.id.reasonEditText;
        SCEditText r106 = (SCEditText) ViewBindings.findChildViewById(r102, R.id.reasonEditText);
        if (r106 == null) goto L11;
        return new ScsFragmentDeclareReasonEditBinding((ConstraintLayout) r102, r104, r105, r106);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.conditional.access.device.ui.BaseTitleBarFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        CustomApplyButton r102 = new CustomApplyButton(requireContext());
        r102.setText(r102.getResources().getString(R.string.Lark_SelfDeclareDevice_Button_SelfDecareConfirm));
        r102.setOnClickListener(new UserScopeDeclareReasonEditFragment$initView$1$1(this));
        this.f418017k = r102;
        S90().addAction(new com.ss.android.lark.ui.d(this.f418017k));
        S90().setLeftTextOnly(R.string.Lark_SelfDeclareDevice_Button_SelfDecareConfirmationCancel);
        S90().setTitle(R.string.Lark_SelfDeclareDevice_Title_DeclareReason);
        ((ScsFragmentDeclareReasonEditBinding) T90()).f417972d.setText(X90().getReason());
        ((ScsFragmentDeclareReasonEditBinding) T90()).f417972d.addTextChangedListener(new com.ss.android.lark.conditional.access.device.ui.b(this));
        Y90(TextUtils.getTrimmedLength(((ScsFragmentDeclareReasonEditBinding) T90()).f417972d.getEditableText()));
        UIUtils.setTextStyle(S90().getLeftText(), R.style.UDText_Body0);
        S90().setLeftTextColor(getResources().getColorStateList(R.color.cancel_text_color));
        getRootView().setOnClickListener(b.f418019a);
        X90().getApplyDeviceLiveData().observe(getViewLifecycleOwner(), new c(this));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.f418018l);
        ScsLogger.d("SecurityPolicy_UserScopeDeclareReasonEditFragment", "onViewCreated");
    }
}
