package com.ss.android.lark.screenprotect.userscope;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: classes38.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenProtectGlobalManager f439847a;

    public e(ScreenProtectGlobalManager r100) {
        this.f439847a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        ScsLogger.d("ScreenshotProtection_US", "addSwitchChangeListener: switchFromBusiness data changes");
        ScreenProtectGlobalManager.b(this.f439847a);
    }
}
