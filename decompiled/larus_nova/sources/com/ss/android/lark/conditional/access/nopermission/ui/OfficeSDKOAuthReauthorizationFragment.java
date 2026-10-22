package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/OfficeSDKOAuthReauthorizationFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "isAuthorizing", "", "authorizationRequestId", "", "resetLoadingRunnable", "Ljava/lang/Runnable;", "mainHandler", "Landroid/os/Handler;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onPrimaryButtonClick", "onPageUpdate", "onDestroyView", "scheduleLoadingFallback", "requestId", "cancelLoadingFallback", "invalidateAuthorizationRequest", "renderPage", "setAuthorizing", "authorizing", "getAuthorizeButtonText", "", "handleAuthorizationResult", "result", "Lcom/ss/android/lark/conditional/access/dependency/DeviceTokenClaimsChallengeResult;", "showGenericError", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKOAuthReauthorizationFragment extends Hilt_OfficeSDKOAuthReauthorizationFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f418275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f418276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f418277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f418278m;

    public static final class a {
    }

    public static final class b implements k8b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment f418279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f418280b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeSDKOAuthReauthorizationFragment f418281a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f418282b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k8b.b f418283c;

            public a(OfficeSDKOAuthReauthorizationFragment r100, long r101, k8b.b r102) {
                this.f418281a = r100;
                this.f418282b = r101;
                this.f418283c = r102;
            }

            public final void a() {
                if (this.f418281a.isAdded() == true) goto L5;
                return;
            L5:
                if (this.f418281a.getView() == null) goto L44;
                long r100 = this.f418282b;
                OfficeSDKOAuthReauthorizationFragment r101 = this.f418281a;
                if (r100 != r101.f418276k) goto L45;
                r101.Y90();
                boolean r102 = false;
                this.f418281a.aa0(false);
                OfficeSDKOAuthReauthorizationFragment r103 = this.f418281a;
                k8b.b r104 = this.f418283c;
                r103.getClass();
                if (Intrinsics.areEqual(r104, k8b.b.d.f502135a) == false) goto L12;
                ScsLogger.d("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization success, start ping");
                r103.W90("device_token_claims_challenge");
                return;
            L12:
                String r105 = null;
                if ((r104 instanceof k8b.b.c) == false) goto L27;
                int r106 = ScsLogger.f440428a;
                StringBuilder r107 = new StringBuilder("OAuth reauthorization failed, code=");
                k8b.b.c r108 = (k8b.b.c) r104;
                r107.append(r108.f502133a);
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", r107.toString());
                FileAuthMonitor.UpdateTrigger[] r109 = FileAuthMonitor.f418450a;
                FileAuthMonitor.j("page", r108.f502133a, r108.f502134b);
                String r110 = r108.f502134b;
                if (r110 == null) goto L23;
                String r111 = StringsKt.trim(r110).toString();
                if (r111 == null) goto L23;
                if (r111.length() <= 0) goto L21;
                r102 = true;
            L21:
                if (r102 == false) goto L23;
                r105 = r111;
            L23:
                if (r105 != null) goto L25;
                r103.ba0();
                return;
            L25:
                UDToast.show(r103.requireContext(), r105);
                return;
            L27:
                if (Intrinsics.areEqual(r104, k8b.b.C6522b.f502132a) == false) goto L30;
                ScsLogger.d("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization cancelled");
                FileAuthMonitor.UpdateTrigger[] r112 = FileAuthMonitor.f418450a;
                FileAuthMonitor.j("page", "cancelled", null);
                return;
            L30:
                if (Intrinsics.areEqual(r104, k8b.b.a.f502131a) == false) goto L33;
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization failed, app not installed");
                FileAuthMonitor.UpdateTrigger[] r113 = FileAuthMonitor.f418450a;
                FileAuthMonitor.j("page", "app_not_installed", null);
                r103.ba0();
                return;
            L33:
                if (Intrinsics.areEqual(r104, k8b.b.e.f502136a) == false) goto L37;
                ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth reauthorization unsupported");
                FileAuthMonitor.UpdateTrigger[] r114 = FileAuthMonitor.f418450a;
                FileAuthMonitor.j("page", "unsupported", null);
                r103.ba0();
                return;
            L37:
                throw new NoWhenBranchMatchedException();
            L45:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // k8b.d
        public final void a(k8b.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (this.f418279a.isAdded() == true) goto L5;
            return;
        L5:
            if (this.f418279a.getView() == null) goto L10;
            OfficeSDKOAuthReauthorizationFragment r101 = this.f418279a;
            r101.f418278m.post(new a(r101, this.f418280b, r100));
            return;
        }

        public b(OfficeSDKOAuthReauthorizationFragment r100, long r101) {
            this.f418279a = r100;
            this.f418280b = r101;
        }
    }

    static {
    }

    public OfficeSDKOAuthReauthorizationFragment() {
        super(NoPermissionType.OAUTH_REAUTHORIZATION);
        this.f418278m = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void U90() {
        if (this.f418275j == false) goto L5;
        return;
    L5:
        InternalSecurityAction r100 = this.f418271g;
        if (r100 == null) goto L19;
        DecisionData.Action r101 = r100.getCurrentAction();
        if (r101 == null) goto L19;
        String r102 = com.ss.android.lark.conditional.access.network.model.response.a.b(r101).f512542d;
        if (r102 == null) goto L19;
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L19;
        if (r103.length() <= 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
    L20:
        if (r103 != null) goto L23;
        ScsLogger.c("SecurityPolicy_OfficeSDKOAuthReauthorizationFragment", "OAuth challenge code is missing");
        FileAuthMonitor.UpdateTrigger[] r105 = FileAuthMonitor.f418450a;
        FileAuthMonitor.j("page", "missing_challenge_code", null);
        ba0();
        return;
    L23:
        aa0(true);
        long r106 = this.f418276k + 1;
        this.f418276k = r106;
        int r107 = g8b.b.f480460a;
        g8b.b.a.a().getDependency().getPassportDependency().a(r103, new b(this, r106));
        Y90();
        w r108 = new w(r106, this);
        S90().f417985a.postDelayed(r108, 2000);
        this.f418277l = r108;
        return;
    L16:
        r104 = false;
    L19:
        r103 = null;
        goto L20
    }

    public final void Y90() {
        Runnable r100 = this.f418277l;
        if (r100 == null) goto L5;
        S90().f417985a.removeCallbacks(r100);
    L5:
        this.f418277l = null;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f418276k++;
        Y90();
        this.f418275j = false;
        super.onDestroyView();
    }

    public final void Z90() {
        S90().f417994j.setText(getString(R.string.Lark_PolicyCenter_NoAccessPermission_Title));
        S90().f417992h.setText(UIHelper.mustacheFormat(R.string.Lark_PolicyMgmt_DeviceInfoAuthRequiredToContinueAccess_Desc, "APP_DISPLAY_NAME", UIHelper.getString(R.string.Lark_Invitation_BrandNameFeishu)));
        t4c.b.a(S90().f417986b);
        UDButton r100 = S90().f417987c;
        r100.setText(getString(R.string.Lark_Conditions_GoToBrand));
        r100.setEnabled(true);
        Intrinsics.checkNotNull(r100);
        t4c.b.b(r100);
        UDButton r101 = S90().f417988d;
        r101.setText(getString(R.string.Lark_Conditions_Refresh));
        r101.setEnabled(true);
        Intrinsics.checkNotNull(r101);
        t4c.b.b(r101);
    }

    public final void ba0() {
        if (isAdded() == false) goto L6;
        UDToast.show(requireContext(), getString(R.string.Lark_Conditions_SystemError_Error));
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        super.onPageUpdate();
        this.f418276k++;
        Y90();
        aa0(false);
        Z90();
    }

    public final void aa0(boolean r100) {
        this.f418275j = r100;
        if (r100 == false) goto L5;
        UDButton r101 = S90().f417987c;
        com.larksuite.component.universe_design.button.d r102 = new com.larksuite.component.universe_design.button.d();
        r102.f284588b = getString(R.string.Lark_Conditions_GoToBrand);
        r102.f284621j = Integer.valueOf(ContextCompat.getColor(requireContext(), R.color.static_white));
        com.larksuite.component.universe_design.button.e.g(r101, r102);
    L6:
        S90().f417987c.setEnabled(!r100);
        return;
    L5:
        UDButton r103 = S90().f417987c;
        String r104 = getString(R.string.Lark_Conditions_GoToBrand);
        com.larksuite.component.universe_design.button.e.a r105 = com.larksuite.component.universe_design.button.e.f284623a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        com.larksuite.component.universe_design.button.e.b(r103, r104);
        goto L6
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Z90();
    }
}
