package com.ss.android.lark.contact.customized.myqrcode.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbActivityMyQrcodeBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbActivityMyQrcodeBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "showLoadingRunnable", "Ljava/lang/Runnable;", "sharePanelProtocol", "Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanel;", "getSharePanelProtocol", "()Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKSharePanel;", "sharePanelProtocol$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initDataAndObserver", "initView", "renderView", BrowserDependency.UrlClickType.CARD, "Lcom/ss/android/lark/contact/customized/myqrcode/model/OfficeInviteExternalCardRenderModel;", "renderSharePanel", "showError", "errorMsg", "", DyPayConstant.KEY_SHOW_LOADING, "dismissLoading", "cancelDelayedLoading", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyQrCodeFragment extends InvBaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f419322h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactDbActivityMyQrcodeBinding f419323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f419324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f419325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f419326g;

    public static final class a {
    }

    static {
    }

    public final OfficeMyQrCodeViewModel T90() {
        return (OfficeMyQrCodeViewModel) this.f419324e.getValue();
    }

    public OfficeMyQrCodeFragment() {
        final Function0<Fragment> r100 = new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$1(this);
        this.f419324e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeMyQrCodeViewModel.class), new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$2(r100), new OfficeMyQrCodeFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f419326g = LazyKt.lazy(OfficeMyQrCodeFragment$sharePanelProtocol$2.INSTANCE);
    }

    public static final void S90(OfficeMyQrCodeFragment r100) {
        f r101 = r100.f419325f;
        ContactDbActivityMyQrcodeBinding r102 = null;
        if (r101 == null) goto L9;
        ContactDbActivityMyQrcodeBinding r103 = r100.f419323d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L8:
        r103.f418986a.removeCallbacks(r101);
        r100.f419325f = null;
    L9:
        ContactDbActivityMyQrcodeBinding r104 = r100.f419323d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L12:
        r104.f418989d.a();
        ContactDbActivityMyQrcodeBinding r105 = r100.f419323d;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L16:
        r102.f418988c.setVisibility(8);
        return;
    L15:
        r102 = r105;
        goto L16
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ContactDbActivityMyQrcodeBinding r102 = this.f419323d;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        r102.f418993h.setLeftIconClickListener(new d(this));
        Context r103 = getContext();
        if (r103 == null) goto L8;
        Lazy r104 = OfficeContactUtils.f418960a;
        OfficeContactUtils.e(this, UIUtils.getColor(r103, R.color.flow_ud_bg_base_1_overlay));
    L8:
        T90().getInviteCardLiveData().observe(getViewLifecycleOwner(), new c(this));
        T90().onPageViewCreated(SystemClock.elapsedRealtime());
        T90().fetchContactToken();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.contact_db_activity_my_qrcode, r111, false);
        int r114 = R.id.ieErrorView;
        ContactOfficeEmptyStateView r100 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r113, R.id.ieErrorView);
        if (r100 == null) goto L19;
        r114 = R.id.ieLoadingLayout;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.ieLoadingLayout);
        if (r101 == null) goto L19;
        r114 = R.id.ieLoadingSpinner;
        ContactOfficeLoadingView r102 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r113, R.id.ieLoadingSpinner);
        if (r102 == null) goto L19;
        r114 = R.id.ieMyQrCodeContainerView;
        OfficeInviteExternalCardView r103 = (OfficeInviteExternalCardView) ViewBindings.findChildViewById(r113, R.id.ieMyQrCodeContainerView);
        if (r103 == null) goto L19;
        r114 = R.id.ieShareContainer;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.ieShareContainer);
        if (r104 == null) goto L19;
        r114 = R.id.llContent;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.llContent);
        if (r105 == null) goto L19;
        r114 = R.id.title_bar;
        ContactOfficeTitleBar r106 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r113, R.id.title_bar);
        if (r106 == null) goto L19;
        ContactDbActivityMyQrcodeBinding r115 = new ContactDbActivityMyQrcodeBinding((LinearLayout) r113, r100, r101, r102, r103, r104, r105, r106);
        this.f419323d = r115;
        return r115.f418986a;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
