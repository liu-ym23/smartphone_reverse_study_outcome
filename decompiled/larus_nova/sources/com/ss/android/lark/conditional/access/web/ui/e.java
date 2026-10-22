package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeBindDeviceWebFragment f418512a;

    public e(UserScopeBindDeviceWebFragment r100) {
        this.f418512a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", "dismiss policy notice, web did: " + this.f418512a.f418500j);
    }
}
