package com.larus.audio.flow.client.kmp_com.service;

import c68.b;
import com.bytedance.flow_audio.api.service.common.IKMPTrackerService;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m58.a;
import m58.h;
import m58.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016JV\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/service/TrackerService;", "Lcom/bytedance/flow_audio/api/service/common/IKMPTrackerService;", "<init>", "()V", "event", "", "", "params", "", "", "hmdTrackService", "serviceName", "metric", "", "category", "extra", "onTtsStart", "ensureNotReachHere", "e", "", "msg", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackerService implements IKMPTrackerService {
    public TrackerService() {
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPTrackerService
    public final void W0() {
        IAudioDeviceMonitorReporter r100 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);
        if (r100 == null) goto L6;
        r100.a(AudioDeviceMonitorScenes.TTS);
        return;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPTrackerService
    public final void ensureNotReachHere(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "msg");
        a r102 = h.f512137h;
        if (r102 == null) goto L6;
        r102.ensureNotReachHere(r100, r101);
        return;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPTrackerService
    public final void event(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 != null) goto L18;
        b.b("TrackerService", "report error by empty params");
        return;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        s r103 = h.f512131b;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        r103.report(r100, new JSONObject(r101));     // Catch: Throwable -> L12
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L20;
        int r107 = b.f22600a;
        b.b("TrackerService", "report error by " + r106.getMessage());
        return;
    L20:
        return;
    L9:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
