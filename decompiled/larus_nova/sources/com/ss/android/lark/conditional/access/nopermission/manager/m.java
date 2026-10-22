package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f418184a = null;

    static {
        f418184a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        SecurityPolicyDialogActionManager.f418129a.getClass();
        SecurityPolicyDialogActionManager.b();
    }
}
