package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class x implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f418195a = null;

    static {
        f418195a = new x();
    }

    public x() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        SecurityPolicyDialogActionManager.f418129a.getClass();
        SecurityPolicyDialogActionManager.b();
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceOwnershipNoSwitchDialog button click.");
    }
}
