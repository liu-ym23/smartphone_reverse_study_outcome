package com.larus.bmhome.taskskill.interaction;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.utils.logger.FLogger;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements com.larus.platform.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PcDevice f314312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PcDeviceSelectionHandler f314313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f314314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f314315d;

    @Override // com.larus.platform.api.a
    public final void onSuccess(String r100, String r110) {
        FLogger.f375446a.i("PcDeviceSelectionHandler", "[startMfaVerify] success, deviceId=" + this.f314312a.getDeviceId() + ", verifyWay=" + r100);
        this.f314313b.a(this.f314314c, this.f314315d, this.f314312a, r110, false);
    }

    @Override // com.larus.platform.api.a
    public final void a(int r100, String r101, Throwable r102) {
        PcDeviceSelectionHandler.a r103 = this.f314313b.f314306b;
        if (r103 == null) goto L5;
        r103.b(null);
    L5:
        FLogger.f375446a.w("PcDeviceSelectionHandler", "[startMfaVerify] failed, deviceId=" + this.f314312a.getDeviceId() + ", code=" + r100 + ", msg=" + r101, r102);
    }

    public a(PcDevice r100, PcDeviceSelectionHandler r101, Context r102, LifecycleCoroutineScope r103) {
        this.f314312a = r100;
        this.f314313b = r101;
        this.f314314c = r102;
        this.f314315d = r103;
    }
}
