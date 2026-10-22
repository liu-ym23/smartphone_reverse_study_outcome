package com.larus.voicecall.impl.util;

import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EarphoneChecker f379465a;

    public /* synthetic */ c(EarphoneChecker r100) {
        this.f379465a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f379465a.getClass();
        IAudioDeviceMonitorReporter r100 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.a(AudioDeviceMonitorScenes.SWITCH);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("EarphoneChecker", "reportDeviceSwitch error: " + e.getMessage());
    }
}
