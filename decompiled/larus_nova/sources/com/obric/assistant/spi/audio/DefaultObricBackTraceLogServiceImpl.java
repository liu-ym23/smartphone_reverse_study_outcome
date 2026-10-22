package com.obric.assistant.spi.audio;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import hga.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricBackTraceLogServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricBackTraceLogService;", "<init>", "()V", "setHistoryLengthMs", "", "historyLengthMs", "", "createTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "reportBackTraceRecorderConfig", "scene", "", "", "reportAudioRecorderStart", "source", "reportAudioRecorderStartResult", "success", "", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "reportBacktraceDuration", "payloadJson", "reportBacktraceRecordError", "NoOpTracer", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricBackTraceLogServiceImpl implements IObricBackTraceLogService {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f392830a = null;

        static {
            f392830a = new a();
        }

        public a() {
        }

        @Override // hga.b
        public final void a(int r100) {
        }

        @Override // hga.b
        public final void b(String r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
        }

        @Override // hga.b
        public final void c(long r100, int r101, int r102, int r103, String r104) {
            Intrinsics.checkNotNullParameter(r104, "scene");
        }

        @Override // hga.b
        public final void d() {
        }

        @Override // hga.b
        public final void e() {
        }

        @Override // hga.b
        public final void f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
        }

        @Override // hga.b
        public final void g() {
        }

        @Override // hga.b
        public final void h() {
        }

        @Override // hga.b
        public final void i(int r100) {
        }
    }

    public DefaultObricBackTraceLogServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void b(int r100) {
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final b c() {
        return a.f392830a;
    }
}
