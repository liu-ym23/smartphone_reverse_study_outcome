package com.larus.avlink;

import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes24.dex */
public final class e1 implements SoundPlayManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f291847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f291848b;

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onBegin() {
        DoraWakeupResponseManager r100 = DoraWakeupResponseManager.f291394a;
        final String r101 = this.f291847a;
        final long r102 = this.f291848b;
        DoraWakeupResponseManager.g(new d1(r101, r102));
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onEnd() {
        FLogger.f375446a.i("DoraWakeupResponse", "wakeup response mp3 finished, taskId=" + this.f291847a);
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onError() {
        DoraWakeupResponseManager r100 = DoraWakeupResponseManager.f291394a;
        final String r101 = this.f291847a;
        final long r102 = this.f291848b;
        DoraWakeupResponseManager.g(new c1(r101, r102));
    }

    public e1(String r100, long r101) {
        this.f291847a = r100;
        this.f291848b = r101;
    }
}
