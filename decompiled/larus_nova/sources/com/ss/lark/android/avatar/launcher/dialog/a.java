package com.ss.lark.android.avatar.launcher.dialog;

import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarSelectDialogController.AvatarSelectMenuView f456630a;

    public a(AvatarSelectDialogController.AvatarSelectMenuView r100) {
        this.f456630a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        AvatarSelectDialogController.AvatarSelectMenuView.c r101 = this.f456630a.getViewDependency();
        if (r101 == null) goto L5;
        r101.dismiss();
    L5:
        AvatarSelectDialogController.AvatarSelectMenuView.c r102 = this.f456630a.getViewDependency();
        if (r102 == null) goto L8;
        r102.b(this.f456630a.getContext());
    L8:
        Log.i("AvatarSelectDialog", "showModifyAvatarPopup going to take picture");
    }
}
