package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeDeviceDeclareFragment f418038a;

    public k(UserScopeDeviceDeclareFragment r100) {
        this.f418038a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "click ApplyRejectDialog");
        if (r100 == null) goto L5;
        r100.dismiss();
    L5:
        UserScopeDeviceDeclareFragment r102 = this.f418038a;
        int r103 = UserScopeDeviceDeclareFragment.f418024m;
        r102.da0();
    }
}
