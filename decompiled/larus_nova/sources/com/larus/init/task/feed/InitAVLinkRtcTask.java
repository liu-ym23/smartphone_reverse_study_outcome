package com.larus.init.task.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.IAudioService;
import com.larus.network.http.ServiceType;
import com.larus.utils.y;
import com.larus.voicecall.api.IVoiceCallConfigService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/init/task/feed/InitAVLinkRtcTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "requestAudioLaunchAndInitRtc", "audioService", "Lcom/larus/audio/IAudioService;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAVLinkRtcTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f351222b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351223a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        IVoiceCallConfigService r100 = (IVoiceCallConfigService) ServiceManager.get().getService(IVoiceCallConfigService.class);
        if (r100 == null) goto L5;
        r100.h();
        r100.d();
    L5:
        final IAudioService r101 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r101 == null) goto L9;
        y.c(new com.larus.init.task.feed.a(r101));
        return;
    }

    public InitAVLinkRtcTask() {
        this.f351223a = ServiceType.AUDIO;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351223a;
    }
}
