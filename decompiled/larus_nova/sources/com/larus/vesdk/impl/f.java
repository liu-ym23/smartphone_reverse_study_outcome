package com.larus.vesdk.impl;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VELogProtocol;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements VELogProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f375611a;

    public f(boolean r100) {
        this.f375611a = r100;
    }

    @Override // com.ss.android.vesdk.VELogProtocol
    public final void logToLocal(int r100, String r101) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L16;
        if (r100 != 3) goto L11;
        FLogger.f375446a.w("VE_SDK_LOG", r101);
        return;
    L11:
        if (r100 != 4) goto L32;
        FLogger.f375446a.e("VE_SDK_LOG", r101);
        return;
    L32:
        return;
    L16:
        if (this.f375611a == false) goto L27;
        FLogger.f375446a.i("VE_SDK_LOG", r101);
        return;
    L27:
        return;
    L19:
        if (this.f375611a == false) goto L29;
        FLogger.f375446a.d("VE_SDK_LOG", r101);
        return;
    L29:
        return;
    L22:
        if (this.f375611a == false) goto L31;
        FLogger.f375446a.v("VE_SDK_LOG", r101);
        return;
    }
}
