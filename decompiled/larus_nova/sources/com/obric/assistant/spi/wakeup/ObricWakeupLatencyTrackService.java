package com.obric.assistant.spi.wakeup;

import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/spi/wakeup/ObricWakeupLatencyTrackService;", "Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "<init>", "()V", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "", "mainProcessReady", "", "markAssistantLaunchStart", "timestamp", "markIpcStart", "scene", InteractConst.WAKEUP_SESSION_NAME, "ipcStartTime", "markMainProcessReceived", "markRecordStart", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupLatencyTrackService implements IWakeupLatencyTrackService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricWakeupLatencyTrackService f392922b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IWakeupLatencyTrackService f392923a;

    static {
        f392922b = new ObricWakeupLatencyTrackService();
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void a(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "launchMethod");
        this.f392923a.a(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void b(long r100) {
        this.f392923a.b(r100);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void c(long r100) {
        this.f392923a.c(r100);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void d(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_SESSION_NAME);
        this.f392923a.d(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void e(long r100) {
        this.f392923a.e(r100);
    }

    private ObricWakeupLatencyTrackService() {
        IWakeupLatencyTrackService r100 = (IWakeupLatencyTrackService) ServiceManager.get().getService(IWakeupLatencyTrackService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultWakeupLatencyTrackServiceImpl();
    L5:
        this.f392923a = r100;
    }
}
