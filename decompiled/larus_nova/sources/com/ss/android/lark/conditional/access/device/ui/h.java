package com.ss.android.lark.conditional.access.device.ui;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes35.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeDeviceDeclareFragment f418035a;

    public h(UserScopeDeviceDeclareFragment r100) {
        this.f418035a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f418035a.finish();
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "finish page");
    }
}
