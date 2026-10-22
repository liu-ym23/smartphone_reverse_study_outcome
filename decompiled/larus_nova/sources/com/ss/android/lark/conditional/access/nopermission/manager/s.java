package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.DialogInterface;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InternalSecurityAction f418190a;

    public s(InternalSecurityAction r100) {
        this.f418190a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        SecurityPolicyDialogActionManager r102 = SecurityPolicyDialogActionManager.f418129a;
        r102.getClass();
        SecurityPolicyDialogActionManager.b();
        r102.f(21, this.f418190a);
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceCertRetryDialog retry button click.");
    }
}
