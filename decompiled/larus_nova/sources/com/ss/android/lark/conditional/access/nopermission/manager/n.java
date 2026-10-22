package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f418185a = null;

    static {
        f418185a = new n();
    }

    public n() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        SecurityPolicyDialogActionManager.f418129a.getClass();
        SecurityPolicyDialogActionManager.b();
    }
}
