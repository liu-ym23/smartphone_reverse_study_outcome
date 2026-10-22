package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f418298a = null;

    static {
        f418298a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "deviceAuthentication fail, cancel button click.");
    }
}
