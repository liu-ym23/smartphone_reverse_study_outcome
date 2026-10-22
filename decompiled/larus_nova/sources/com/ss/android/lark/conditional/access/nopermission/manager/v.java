package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InternalSecurityAction f418193a;

    public v(InternalSecurityAction r100) {
        this.f418193a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceOwnershipErrorDialog retry button click.");
        SecurityPolicyDialogActionManager r102 = SecurityPolicyDialogActionManager.f418129a;
        InternalSecurityAction r103 = this.f418193a;
        r102.getClass();
        SecurityPolicyDialogActionManager.c(r103);
    }
}
