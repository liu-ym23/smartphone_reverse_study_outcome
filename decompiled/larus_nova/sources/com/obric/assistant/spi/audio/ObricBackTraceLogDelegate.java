package com.obric.assistant.spi.audio;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J#\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0016H\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricBackTraceLogDelegate;", "Lcom/obric/assistant/spi/audio/IObricBackTraceLogService;", "<init>", "()V", "createTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "reportAudioRecorderStart", "", "source", "", "reportAudioRecorderStartResult", "success", "", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "reportBackTraceRecorderConfig", "scene", "historyLengthMs", "", "reportBacktraceDuration", "payloadJson", "reportBacktraceRecordError", "setHistoryLengthMs", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBackTraceLogDelegate implements IObricBackTraceLogService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricBackTraceLogDelegate f392833b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricBackTraceLogService f392834a;

    static {
        f392833b = new ObricBackTraceLogDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f392834a.a(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void b(int r100) {
        this.f392834a.b(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final b c() {
        return this.f392834a.c();
    }

    private ObricBackTraceLogDelegate() {
        IObricBackTraceLogService r100 = (IObricBackTraceLogService) ServiceManager.get().getService(IObricBackTraceLogService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricBackTraceLogServiceImpl();
    L5:
        this.f392834a = r100;
    }
}
