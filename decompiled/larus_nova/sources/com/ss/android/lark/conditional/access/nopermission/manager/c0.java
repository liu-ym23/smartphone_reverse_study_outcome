package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class c0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f418170a = null;

    static {
        f418170a = new c0();
    }

    public c0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        SecurityPolicyDialogActionManager.f418129a.getClass();
        SecurityPolicyDialogActionManager.b();
        ScsLogger.d("SecurityPolicyDialogFragment", "NormalDialog button click.");
    }
}
