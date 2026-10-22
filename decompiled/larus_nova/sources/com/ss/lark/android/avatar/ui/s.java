package com.ss.lark.android.avatar.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.lark.android.avatar.statistics.AvatarHit;

/* JADX INFO: loaded from: classes40.dex */
public final class s extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDialog f456772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AvatarPreviewView f456773b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        UDDialog r101 = this.f456772a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        AvatarHit.b(this.f456773b.f456728f, AvatarHit.ProfilePhotoSettingClick.OPEN_PREVIOUS_PROFILE_PHOTO);
        this.f456773b.f456723a.r8();
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }

    public s(AvatarPreviewView r100, UDDialog r101) {
        this.f456773b = r100;
        this.f456772a = r101;
    }
}
