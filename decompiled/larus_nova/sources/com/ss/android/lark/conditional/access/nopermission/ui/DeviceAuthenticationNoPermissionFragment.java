package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceAuthenticationNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "nonce", "", "challengeType", "", "needCertVerify", "", "firstLoad", "disposable", "Lio/reactivex/disposables/Disposable;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initObserver", "initView", "initData", "parseDeviceChallenge", "onPrimaryButtonClick", "showButtonLoading", "resetButton", "onPageUpdate", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceAuthenticationNoPermissionFragment extends Hilt_DeviceAuthenticationNoPermissionFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f418198o = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f418199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f418200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f418201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f418202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f418203n;

    public static final class a {
    }

    static {
    }

    public final void initView() {
        this.f418202m = true;
        S90().f417994j.setText(requireContext().getText(R.string.Lark_Conditions_NewVerAccessStrategy_NoAccess_Title));
        S90().f417992h.setText(requireContext().getText(R.string.Lark_Conditions_NewVerAccessStrategy_DeviceVeri_Text));
        S90().f417991g.setText(requireContext().getText(R.string.Lark_Conditions_NewVerAccessStrategy_VisitAccessAdmin_Button));
        Y90();
        t4c.b.a(S90().f417990f);
        t4c.b.a(S90().f417986b);
        t4c.b.b(S90().f417989e.f417996a);
        S90().f417989e.f418000e.setText(requireContext().getText(R.string.Lark_Conditions_NewVerAccessStrategy_CheckDeviceInfo_EmptyTitle));
        t4c.b.b(S90().f417989e.f418000e);
        S90().f417989e.f417999d.setText(requireContext().getText(R.string.Lark_Conditions_NewVerAccessStrategy_CheckingDeviceInfo_EmptyDesc));
        S90().f417989e.f417997b.playAnimation();
    }

    public DeviceAuthenticationNoPermissionFragment() {
        super(NoPermissionType.DEVICE_AUTHENTICATION);
        this.f418199j = "";
        this.f418202m = true;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "btnDeviceDeclare onClick");
        Z90();
        qqb.a.h("DeviceAuthenticationNoPermissionFragment button click device authentication");     // Catch: Throwable -> L6
        this.f418203n = T90().startDeviceAuthentication(qqb.a.d());     // Catch: Throwable -> L6
        qqb.a.a();
        return;
    L6:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void initData() {
        InternalSecurityAction r100 = this.f418271g;
        if (r100 == null) goto L7;
        DecisionData.Action r101 = r100.getCurrentAction();
        if (r101 == null) goto L7;
        m8b.c r102 = com.ss.android.lark.conditional.access.network.model.response.a.b(r101);
    L8:
        if (r102 == null) goto L11;
        String r103 = r102.f512540b;
        if (r103 == null) goto L11;
    L12:
        this.f418199j = r103;
        boolean r104 = false;
        if (r102 == null) goto L17;
        Integer r105 = r102.f512539a;
        if (r105 == null) goto L17;
        int r106 = r105.intValue();
    L18:
        this.f418200k = r106;
        if (r102 == null) goto L23;
        m8b.a r107 = r102.f512541c;
        if (r107 == null) goto L23;
        boolean r108 = r107.f512538a;
    L24:
        this.f418201l = r108;
        qqb.a.h("DeviceAuthenticationNoPermissionFragment silent device authentication");     // Catch: Throwable -> L32
        if (this.f418199j.length() <= 0) goto L28;
        r104 = true;
    L28:
        if (r104 == false) goto L30;
        this.f418203n = T90().startDeviceAuthenticationWithNonce(qqb.a.d(), this.f418199j, this.f418200k, this.f418201l);     // Catch: Throwable -> L32
    L30:
        qqb.a.a();
        return;
    L32:
        th = move-exception;
        qqb.a.a();
        throw th;
    L23:
        r108 = false;
    L17:
        r106 = 0;
    L11:
        r103 = "";
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "onPageUpdate");
        Disposable r100 = this.f418203n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        initView();
        initData();
    }

    public final void Y90() {
        UDButton r100 = S90().f417987c;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L5;
        String r102 = r101.getString(R.string.Lark_Conditions_NewVerAccessStrategy_VisitAccessAdmin_Button);
    L6:
        com.larksuite.component.universe_design.button.e.a r103 = com.larksuite.component.universe_design.button.e.f284623a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larksuite.component.universe_design.button.e.b(r100, r102);
        S90().f417987c.setEnabled(true);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void Z90() {
        UDButton r100 = S90().f417987c;
        com.larksuite.component.universe_design.button.d r101 = new com.larksuite.component.universe_design.button.d();
        FragmentActivity r102 = getActivity();
        Integer r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getString(R.string.Lark_Conditions_NewVerAccessStrategy_EquipCertifi_Button);
    L6:
        r101.f284588b = r104;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L11;
        Resources r106 = r105.getResources();
        if (r106 == null) goto L11;
        r103 = Integer.valueOf(r106.getColor(R.color.static_white));
    L11:
        r101.f284621j = r103;
        com.larksuite.component.universe_design.button.e.g(r100, r101);
        S90().f417987c.setEnabled(false);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "onViewCreated");
        initView();
        T90().getAuthLiveData().observe(getViewLifecycleOwner(), new d(this));
        initData();
    }
}
