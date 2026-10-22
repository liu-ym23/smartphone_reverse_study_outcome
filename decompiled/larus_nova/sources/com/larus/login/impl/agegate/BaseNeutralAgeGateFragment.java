package com.larus.login.impl.agegate;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.common_ui.dialog.l0;
import com.larus.login.impl.AccountUtils;
import com.larus.nova.R;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH&J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J1\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0004¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0014J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0004J \u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0004J,\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0004J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/login/impl/agegate/BaseNeutralAgeGateFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "commonLoadDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "subScene", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onViewCreated", "view", "Landroid/view/View;", "reportAgeGateInfo", "time", "", CommonConstant.KEY_AGE_RANGE, "ageInterceptor", "Lkotlin/Function0;", "", "(Ljava/lang/Long;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "onReportTooMinAge", "onReportNotAllowedAge", "showNotAllowedConfirmDialog", "getAgeGateVerificationType", "", "goAccountLoginPage", "mobAgeGatePageShow", "ageVerificationType", "pageHierarchy", "mobAgeGatePageClick", "clickFrom", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseNeutralAgeGateFragment extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f357311g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f357312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FragmentExtKt$addOnBackPressed$callback$1 f357313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f357314f;

    public static final class a {
    }

    static {
    }

    public abstract void onBackPressed();

    public void V90() {
        t19.s r100 = t19.s.f544207a;
        Context r101 = getContext();
        r100.getClass();
        t19.s.s(r101, R.string.larus_ageGate_enter_errToast_type_age_global);
    }

    public final void S90() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(getContext(), "//flow/account_login");
        r100.f267554c.addFlags(67108864);
        Bundle r101 = getArguments();
        if (r101 == null) goto L7;
        String r102 = r101.getString("pending_deeplink_schema");
        if (r102 == null) goto L7;
        FLogger.f375446a.i("BaseNeutralAgeGateFragment", "pass uri from push when route to ROUTER_ACCOUNT_LOGIN");
        r100.j("pending_deeplink_schema", r102);
    L7:
        r100.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        FragmentExtKt$addOnBackPressed$callback$1 r100 = this.f357313e;
        if (r100 == null) goto L6;
        r100.remove();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        l0 r100 = this.f357312d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L27;
        l0 r102 = this.f357312d;
        if (r102 == null) goto L31;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r104 == null) goto L24;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r103.getLooper()) goto L15;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L31:
        return;
    L27:
        return;
    L5:
        if (r100.isShowing() != true) goto L7;
        r101 = true;
        goto L7
    }

    public BaseNeutralAgeGateFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f357313e = com.larus.utils.v.a(this, new e0(this));
        Bundle r101 = getArguments();
        int r102 = 0;
        if (r101 == null) goto L5;
        r102 = r101.getInt("neutral_age_gate_sub_scene", 0);
    L5:
        this.f357314f = r102;
    }

    public static void U90(String r100, String r101) {
        tx9.e.d(AgeGateManagerService.f286218a.getLoginPlatform(), null, r100, r101, 50);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Context r112 = getContext();
        String r113 = null;
        if (r112 == null) goto L5;
        l0 r100 = new l0(r112, 0.0f, false, 6);
    L6:
        this.f357312d = r100;
        AccountUtils r114 = AccountUtils.f357130a;
        AccountUtils.r(this);
        l0 r101 = this.f357312d;
        Bundle r115 = getArguments();
        if (r115 == null) goto L9;
        r113 = r115.getString("pending_deeplink_schema");
    L9:
        AccountUtils.p(this, this, r101, null, false, r113, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_HEIGHT);
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static void T90(String r100, String r101, String r102) {
        tx9.e.c(r100, AgeGateManagerService.f286218a.getLoginPlatform(), r101, r102, 48);
    }

    public static /* synthetic */ void X90(BaseNeutralAgeGateFragment r100, Long r101, Integer r102) {
        r100.W90(r101, r102, new f0());
    }

    public final void W90(Long r100, Integer r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r102, "ageInterceptor");
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r102.invoke().booleanValue() == false) goto L9;
        return;
    L9:
        FLogger.f375446a.i("BaseNeutralAgeGateFragment", "reportAgeGateInfo time=" + r100 + " ageRange=" + r101);
        l0 r103 = this.f357312d;
        if (r103 != null) goto L12;
    L16:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new BaseNeutralAgeGateFragment$reportAgeGateInfo$2(this, r100, r101, null), 3, null);
        return;
    L12:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r103);
        goto L16
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L16
    }
}
