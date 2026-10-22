package com.ss.android.lark.screenprotect.userscope;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes38.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenProtectGlobalManager f439846a;

    public d(ScreenProtectGlobalManager r100) {
        this.f439846a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        ScsLogger.d("ScreenshotProtection_US", "addSwitchChangeListener: switchFromAudit data changes");
        ScreenProtectGlobalManager.b(this.f439846a);
    }
}
