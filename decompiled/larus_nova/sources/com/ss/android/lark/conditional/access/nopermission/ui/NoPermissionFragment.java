package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentNoPermissionBinding;
import com.ss.android.lark.conditional.access.databinding.ScsWidgetLoadingViewBinding;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.handler.policy.center.PolicyCenterDisplayIdActionGate;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u001dH\u0014J\b\u0010,\u001a\u00020\u001dH\u0014J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/PageUpdateFragment;", "type", "Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "<init>", "(Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;)V", "getType", "()Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "viewModel", "Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;", "getViewBinding", "()Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;", "setViewBinding", "(Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentNoPermissionBinding;)V", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "getInternalSecurityAction", "()Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "setInternalSecurityAction", "(Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "ping", "pingSource", "", "onPrimaryButtonClick", "onRetryButtonClick", "onPageUpdate", "onDestroyView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NoPermissionFragment extends BaseFragment implements d0c.c, y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NoPermissionType f418268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f418269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScsFragmentNoPermissionBinding f418270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InternalSecurityAction f418271g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionFragment f418272a;

        public b(NoPermissionFragment r100) {
            this.f418272a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.f418272a.getType().name() + ", btnRetry onClick");
            int r102 = p8b.a.f528276a;
            p8b.a.b(EventConstant.Value.RETRY, this.f418272a.getType().getValue());
            this.f418272a.V90();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionFragment f418273a;

        public c(NoPermissionFragment r100) {
            this.f418273a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.f418273a.getType().name() + ", btn_primary onClick");
            this.f418273a.U90();
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionFragment f418274a;

        public d(NoPermissionFragment r100) {
            this.f418274a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L6;
            Lazy r101 = PolicyCenterDisplayIdActionGate.f418440a;
            InternalSecurityAction r102 = this.f418274a.f418271g;
            ((com.ss.android.lark.conditional.access.traffic.handler.policy.center.a) PolicyCenterDisplayIdActionGate.f418440a.getValue()).i3(r102);
            this.f418274a.finish();
            com.ss.android.lark.conditional.access.nopermission.interception.a.f418091a.getClass();
            com.ss.android.lark.conditional.access.nopermission.interception.a.a();
            return;
        }
    }

    static {
    }

    public void U90() {
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

    public final ScsFragmentNoPermissionBinding S90() {
        ScsFragmentNoPermissionBinding r100 = this.f418270f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final NoPermissionViewModel T90() {
        return (NoPermissionViewModel) this.f418269e.getValue();
    }

    public void V90() {
        W90("refresh_button");
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FileAuthMonitor.UpdateTrigger[] r100 = FileAuthMonitor.f418450a;
        FileAuthMonitor.d(this.f418271g, "dismiss", this.f418268d);
    }

    public void onPageUpdate() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        InternalSecurityAction r101 = (InternalSecurityAction) r100.getParcelable("param_action");
    L6:
        this.f418271g = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public final NoPermissionType getType() {
        return this.f418268d;
    }

    public NoPermissionFragment(NoPermissionType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f418268d = r100;
        final Function0<Fragment> r101 = new NoPermissionFragment$special$$inlined$viewModels$default$1(this);
        this.f418269e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NoPermissionViewModel.class), new NoPermissionFragment$special$$inlined$viewModels$default$2(r101), new NoPermissionFragment$special$$inlined$viewModels$default$3(r101, this));
    }

    public final void W90(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pingSource");
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionFragment", this.f418268d.name() + ", ping()");
        T90().ping(r100, this.f418271g);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        InternalSecurityAction r102 = (InternalSecurityAction) r101.getParcelable("param_action");
    L6:
        this.f418271g = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ScsLogger.d("SecurityPolicy_NoPermissionFragment", "onViewCreated");
        S90().f417988d.setOnClickListener(new b(this));
        S90().f417987c.setOnClickListener(new c(this));
        T90().getPingLiveData().observe(getViewLifecycleOwner(), new d(this));
        FileAuthMonitor.UpdateTrigger[] r102 = FileAuthMonitor.f418450a;
        FileAuthMonitor.d(this.f418271g, "show", this.f418268d);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.scs_fragment_no_permission, r111, false);
        int r114 = R.id.area_reason;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.area_reason);
        if (r100 == null) goto L29;
        r114 = R.id.btn_primary;
        UDButton r101 = (UDButton) ViewBindings.findChildViewById(r113, R.id.btn_primary);
        if (r101 == null) goto L29;
        r114 = R.id.btn_retry;
        UDButton r102 = (UDButton) ViewBindings.findChildViewById(r113, R.id.btn_retry);
        if (r102 == null) goto L29;
        r114 = R.id.iv_no_access;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.iv_no_access)) == null) goto L29;
        r114 = R.id.loading_view;
        View r115 = ViewBindings.findChildViewById(r113, R.id.loading_view);
        if (r115 == null) goto L29;
        ScsWidgetLoadingViewBinding r103 = ScsWidgetLoadingViewBinding.a(r115);
        r114 = R.id.noPermissionContent;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.noPermissionContent);
        if (r104 == null) goto L29;
        r114 = R.id.tv_desc;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_desc);
        if (r105 == null) goto L29;
        r114 = R.id.tv_hint;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_hint);
        if (r106 == null) goto L29;
        r114 = R.id.tv_reason;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_reason);
        if (r107 == null) goto L29;
        r114 = R.id.tv_sub_hint;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.tv_sub_hint)) == null) goto L29;
        r114 = R.id.tv_title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r113, R.id.tv_title);
        if (r116 == null) goto L29;
        r114 = R.id.webView;
        WebView r117 = (WebView) ViewBindings.findChildViewById(r113, R.id.webView);
        if (r117 == null) goto L29;
        ScsFragmentNoPermissionBinding r118 = new ScsFragmentNoPermissionBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105, r106, r107, r116, r117);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f418270f = r118;
        return S90().f417985a;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
