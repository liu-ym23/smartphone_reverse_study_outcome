package com.larus.drive.sdk.impl.view.preview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common_ui.dialog.l0;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements com.larus.bmhome.share.panel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiFilePreviewShareSheet f342299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.share.panel.c f342300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.drive.sdk.impl.store.a f342301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f342302d;

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r100, String r101, Boolean r102) {
        return true;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        FLogger.f375446a.i("AiFilePreviewShare", "share panel dismissed");
        this.f342299a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    public c(AiFilePreviewShareSheet r100, com.larus.bmhome.share.panel.c r101, com.larus.drive.sdk.impl.store.a r102, String r103) {
        this.f342299a = r100;
        this.f342300b = r101;
        this.f342301c = r102;
        this.f342302d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.larus.drive.sdk.impl.view.preview.b] */
    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r100, DialogFragment r110, View r111, jr9.a r112) {
        Intrinsics.checkNotNullParameter(r112, "shareItemConfig");
        String r101 = r112.b();
        if (r101 == null) goto L73;
        int r113 = r101.hashCode();
        if (r113 == (-1879227763)) goto L54;
        com.bytedance.ee.bear.office.export.space.a r102 = 0;
        String r103 = null;
        r102 = 0;
        if (r113 == 1397633267) goto L29;
        if (r113 == 1406022185) goto L12;
        return false;
    L12:
        if (r101.equals(ShareChannel.SAVE_LOCAL) == false) goto L75;
        FLogger r104 = FLogger.f375446a;
        r104.i("AiFilePreviewShare", "share channel clicked, channel=save_local");
        AiFilePreviewShareSheet r114 = this.f342299a;
        AiFilePreviewShareSheet.a r105 = AiFilePreviewShareSheet.f342271j;
        Bundle r106 = r114.getArguments();
        if (r106 == null) goto L17;
        r103 = r106.getString("download_request_key");
    L17:
        if (r103 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == false) goto L27;
        r104.w("AiFilePreviewShare", "request download unavailable, reason=request_key_missing");
        Context r108 = r114.getContext();
        if (r108 == null) goto L68;
        s.f544207a.g(r108, R.string.LarkCCM_Wiki_FileSecurity_CantDownload_Mob, false);
    L68:
        return true;
    L27:
        r114.getParentFragmentManager().setFragmentResult(r103, Bundle.EMPTY);
        r104.i("AiFilePreviewShare", "request download dispatched");
        AiFilePreviewShareSheet.S90(r114);
        goto L68
    L19:
        if (StringsKt.isBlank(r103) == true) goto L22;
        r107 = false;
        goto L23
    L75:
        return false;
    L29:
        if (r101.equals(ShareChannel.SAVE_CLOUD) == false) goto L76;
        FLogger r109 = FLogger.f375446a;
        r109.i("AiFilePreviewShare", "share channel clicked, channel=save_cloud");
        final AiFilePreviewShareSheet r115 = this.f342299a;
        com.larus.drive.sdk.impl.store.a r116 = this.f342301c;
        String r117 = this.f342302d;
        if (r115.f342276h == false) goto L34;
        r109.i("AiFilePreviewShare", "skip save to space, reason=request_in_flight");
        goto L68
    L34:
        final Context r118 = r115.getContext();
        if (r118 == null) goto L68;
        IOfficeSdkServiceV2 r119 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r119 == null) goto L42;
        gk5.e r120 = r119.q0();
        if (r120 == null) goto L42;
        r102 = r120.e7();
    L42:
        if (r102 != 0) goto L44;
        r109.w("AiFilePreviewShare", "save to space unavailable, reason=office_space_sdk_missing");
        s.f544207a.g(r118, R.string.LarkCCM_IM_DLP_UnableToSaveToMySpace_Toast, false);
        goto L68
    L44:
        r115.f342276h = true;
        com.larus.bmhome.share.panel.a r121 = r115.f342273e;
        if (r121 == null) goto L47;
        r121.c(ShareChannel.SAVE_CLOUD, false);
    L47:
        l0 r122 = new l0(r118, 0.0f, false, 6);
        if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L71;
        DialogLancet.handleBlockedDialogShow(r122);
    L52:
        r115.f342275g = r122;
        FLogger.f375446a.i("AiFilePreviewShare", "save to space started");
        r102.d(r116.f341980a.getCurrent().getToken(), r117, new b(r115, r118));
        goto L68
    L71:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L70
    L51:
        DialogLancet.beforeDialogShow(r122);
        r122.show();
        DialogLancet.afterDialogShow(r122);
        goto L52
    L76:
        return false;
    L54:
        if (r101.equals(ShareChannel.MESSAGE_FORWARD) == false) goto L77;
        FLogger r123 = FLogger.f375446a;
        r123.i("AiFilePreviewShare", "share channel clicked, channel=message_forward");
        AiFilePreviewShareSheet r124 = this.f342299a;
        com.larus.bmhome.share.panel.c r125 = this.f342300b;
        AiFilePreviewShareSheet.a r126 = AiFilePreviewShareSheet.f342271j;
        Context r127 = r124.getContext();
        if (r127 == null) goto L68;
        IShareDoubaoForwardService r128 = (IShareDoubaoForwardService) ServiceManager.get().getService(IShareDoubaoForwardService.class);
        if (r128 != null) goto L62;
    L64:
        boolean r129 = false;
    L65:
        if (r129 == false) goto L67;
        r123.i("AiFilePreviewShare", "open file forward picker, result=accepted");
        AiFilePreviewShareSheet.S90(r124);
        goto L68
    L67:
        r123.w("AiFilePreviewShare", "open file forward picker, result=unavailable");
        s.f544207a.g(r127, R.string.larus_not_available_attempts_try_agagain_toast, false);
        goto L68
    L62:
        if (r128.f(r127, r125) != true) goto L64;
        r129 = true;
        goto L65
    L77:
        return false;
    L73:
        return false;
    }
}
