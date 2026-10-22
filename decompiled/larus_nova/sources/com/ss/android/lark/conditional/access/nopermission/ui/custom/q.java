package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f418390a = null;

    static {
        f418390a = new q();
    }

    public q() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "deviceAuthentication fail, cancel button click.");
    }
}
