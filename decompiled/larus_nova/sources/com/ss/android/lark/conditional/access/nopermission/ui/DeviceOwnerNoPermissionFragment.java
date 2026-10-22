package com.ss.android.lark.conditional.access.nopermission.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareActivity;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/DeviceOwnerNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "passportService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "getPassportService", "()Lcom/ss/android/lark/passportc/api/IPassportUserService;", "setPassportService", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onPrimaryButtonClick", "onPageUpdate", "setupDeclareUI", "showErrorToast", "gotoDeviceDeclareActivity", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceOwnerNoPermissionFragment extends Hilt_DeviceOwnerNoPermissionFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f418204k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.passportc.api.m f418205j;

    public static final class a {
    }

    static {
    }

    public DeviceOwnerNoPermissionFragment() {
        super(NoPermissionType.DEVICE_OWNER);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "btnDeviceDeclare onClick");
        int r100 = UserScopeDeviceDeclareActivity.f418021c;
        FragmentActivity r101 = requireActivity();
        com.ss.android.lark.passportc.api.m r102 = this.f418205j;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("passportService");
        r102 = null;
    L6:
        UserSession r103 = r102.getSession();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareActivity", "startUi, needRetry: true");
        Intent r104 = new Intent(r101, UserScopeDeviceDeclareActivity.class);
        boolean r105 = r101 instanceof Activity;
        if (r105 == true) goto L9;
        r104.addFlags(268435456);
    L9:
        if (r103 == null) goto L11;
        PassportcConvention.g(r104, r103);
    L12:
        r104.putExtra("can_be_covered", false);
        r104.putExtra("need_probe", true);
        if (r105 == false) goto L15;
        r101.startActivityForResult(r104, 9999);
        return;
    L15:
        r101.startActivity(r104);
        return;
    L11:
        PassportcConvention.e(r104, LarkContext.getApplication());
        goto L12
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "onPageUpdate");
        S90().f417992h.setText(requireContext().getText(R.string.Lark_Conditions_DeviceUnsure));
        S90().f417993i.setText(requireContext().getText(R.string.Lark_Conditions_DeviceBelonging));
        S90().f417991g.setText(requireContext().getText(R.string.Lark_Conditions_Personal));
        t4c.b.b(S90().f417989e.f417996a);
        t4c.b.a(S90().f417990f);
        S90().f417989e.f417997b.playAnimation();
        T90().getDeviceInfo();
    }

    public static final void Y90(DeviceOwnerNoPermissionFragment r100) {
        r100.S90().f417989e.f417997b.cancelAnimation();
        t4c.b.a(r100.S90().f417989e.f417996a);
        t4c.b.b(r100.S90().f417990f);
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L6;
        UDToast.show(r101, r101.getString(R.string.Lark_Conditions_NetworkFailed));
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "onViewCreated");
        S90().f417992h.setText(requireContext().getText(R.string.Lark_Conditions_DeviceUnsure));
        S90().f417993i.setText(requireContext().getText(R.string.Lark_Conditions_DeviceBelonging));
        S90().f417991g.setText(requireContext().getText(R.string.Lark_Conditions_Personal));
        t4c.b.b(S90().f417989e.f417996a);
        t4c.b.a(S90().f417990f);
        S90().f417989e.f417997b.playAnimation();
        T90().getDeviceInfoLiveData().observe(getViewLifecycleOwner(), new h(this));
        T90().getBindDeviceLiveData().observe(getViewLifecycleOwner(), new i(this));
        T90().getDeviceApplySwitchLiveData().observe(getViewLifecycleOwner(), new j(this));
        T90().getDeviceInfo();
    }
}
