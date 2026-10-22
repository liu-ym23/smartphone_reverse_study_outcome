package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeBindDeviceWebFragment f418511a;

    public d(UserScopeBindDeviceWebFragment r100) {
        this.f418511a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        UDCheckBox r102 = this.f418511a.f418505o;
        if (r102 == null) goto L5;
        r102.setChecked(true);
    L5:
        ((BindDeviceWebViewModel) this.f418511a.f418499i.getValue()).bindDeviceWeb(this.f418511a.f418500j);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_UserScopeBindDeviceWebFragment", " policy notice bindDeviceWeb, web did: " + this.f418511a.f418500j);
    }
}
