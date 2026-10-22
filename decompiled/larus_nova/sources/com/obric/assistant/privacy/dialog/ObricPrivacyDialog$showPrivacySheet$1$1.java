package com.obric.assistant.privacy.dialog;

import android.app.Activity;
import android.content.Context;
import com.larus.home.api.main.HomeService;
import com.larus.network.HttpConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricPrivacyDialog$showPrivacySheet$1$1 implements com.obric.oui.privacy.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricPrivacyDialog f391110a;

    @Override // com.obric.oui.privacy.i
    public final void a() {
        ObricPrivacyDialog r100 = this.f391110a;
        r100.f391107h = false;
        Context r101 = r100.f391105f;
        if (r101 == null) goto L5;
        String r102 = r101.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r102, "com.larus.home.impl.MainActivity") == false) goto L15;
        Context r103 = this.f391110a.f391105f;
        if ((r103 instanceof Activity) == false) goto L11;
        Activity r104 = (Activity) r103;
    L12:
        if (r104 == null) goto L14;
        r104.finish();
    L14:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricPrivacyDialog$showPrivacySheet$1$1$onExitClicked$1(this, null), 3, null);
        return;
    L11:
        r104 = null;
        goto L12
    L15:
        com.obric.oui.privacy.c r105 = this.f391110a.f391106g;
        if (r105 == null) goto L20;
        r105.b();
        return;
    L20:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.obric.oui.privacy.i
    public final void b() {
        ObricPrivacyDialog r100 = this.f391110a;
        r100.f391107h = true;
        com.obric.oui.privacy.c r101 = r100.f391106g;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.obric.oui.privacy.i
    public final void onDismiss() {
        ObricPrivacyDialog r100 = this.f391110a;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        if (r100.f391107h == false) goto L6;
        ObricPrivacyDialog.T90(r100);     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L6:
        FLogger.f375446a.i("ObricPrivacyDialog", "click disagree");     // Catch: Throwable -> L20
        Context r102 = r100.f391105f;     // Catch: Throwable -> L20
        if (r102 == null) goto L9;
        HomeService.f344094a.Y(r102, false);     // Catch: Throwable -> L20
    L9:
        com.larus.common_ui.dialog.u r103 = r100.f391104e;     // Catch: Throwable -> L20
        if (r103 == null) goto L23;
        r103.cancel();     // Catch: Throwable -> L20
    L23:
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L14 Throwable -> L20
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L20
        Throwable r104 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L20
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.obric.oui.privacy.i
    public final void onBackPressed() {
        a();
    }

    public ObricPrivacyDialog$showPrivacySheet$1$1(ObricPrivacyDialog r100) {
        this.f391110a = r100;
    }

    @Override // com.obric.oui.privacy.i
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkText");
        ObricPrivacyDialog r101 = this.f391110a;
        int r102 = ObricPrivacyDialog.f391102k;
        if (Intrinsics.areEqual(r100, r101.U90(R.string.obric_privacy_policy_link)) == false) goto L6;
        ObricPrivacyDialog r103 = this.f391110a;
        HttpConst.f359979a.getClass();
        ObricPrivacyDialog.S90(r103, HttpConst.M);
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.f391110a.U90(R.string.obric_privacy_doubao_assistant_special_term_link)) == false) goto L9;
        ObricPrivacyDialog.S90(this.f391110a, "https://www.doubao.com/ocean_legal/terms");
        return;
    L9:
        if (Intrinsics.areEqual(r100, this.f391110a.U90(R.string.obric_privacy_doubao_term_link)) == false) goto L14;
        ObricPrivacyDialog r104 = this.f391110a;
        HttpConst.f359979a.getClass();
        ObricPrivacyDialog.S90(r104, HttpConst.L);
        return;
    }
}
