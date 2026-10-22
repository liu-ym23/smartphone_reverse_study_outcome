package com.larus.asr.task;

import android.os.SystemClock;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.report.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements h68.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xa8.d f288074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f288075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<byte[], JSONObject, Unit> f288076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<byte[], Unit> f288077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f288078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y58.a f288079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h68.d f288080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile AsrState f288081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f288082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C3951b f288083k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.asr.task.b$b, reason: collision with other inner class name */
    public static final class C3951b implements z2a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f288084a;

        @Override // z2a.a
        public final void c() {
            b r100 = this.f288084a;
            r100.f288074b.gq(r100.f288075c.invoke().intValue());
            this.f288084a.f288078f.invoke();
        }

        public C3951b(b r100) {
            this.f288084a = r100;
        }

        @Override // z2a.a
        public final void a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f288084a.f288077e.invoke(r100);
            this.f288084a.f288074b.rV();
        }

        @Override // z2a.a
        public final void b(byte[] r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f288084a.f288076d.invoke(r100, r101);
        }
    }

    static {
    }

    @Override // h68.e
    public final int a(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        return 0;
    }

    @Override // h68.e
    public final boolean b() {
        return false;
    }

    @Override // h68.e
    public final void c(String r100, Object r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // h68.e
    public final void g(h r100) {
    }

    @Override // h68.e
    public final void cancel() {
        FLogger.f375446a.i("QuicAsrTask", "cancel quic asr, taskId=" + this.f288073a);
        if (this.f288074b.K70() == true) goto L5;
    L7:
        this.f288081i = AsrState.ASR_STOP;
        return;
    L5:
        if (this.f288074b.Ig() == true) goto L7;
        this.f288074b.gq(this.f288075c.invoke().intValue());
        goto L7
    }

    @Override // h68.e
    public final long e() {
        if (this.f288082j != 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - this.f288082j;
    }

    @Override // h68.e
    public final void release() {
        FLogger.f375446a.i("QuicAsrTask", "release quic asr, taskId=" + this.f288073a);
        this.f288074b.gq(this.f288075c.invoke().intValue());
        this.f288081i = AsrState.ASR_IDLE;
    }

    @Override // h68.e
    public final void start() {
        AsrState r100 = this.f288081i;
        AsrState r101 = AsrState.ASR_STARTED;
        if (r100 != r101) goto L6;
        FLogger.f375446a.w("QuicAsrTask", "start ignored, already started, taskId=" + this.f288073a);
        return;
    L6:
        this.f288082j = SystemClock.elapsedRealtime();
        int r102 = this.f288075c.invoke().intValue();
        FLogger.f375446a.i("QuicAsrTask", "start quic asr, taskId=" + this.f288073a + ", speakerMode=" + r102);
        this.f288074b.gq(r102);
        this.f288074b.VJ(this.f288083k);
        this.f288074b.lw(r102);
        this.f288081i = r101;
        h68.d r103 = this.f288080h;
        if (r103 == null) goto L10;
        r103.e(r101);
        return;
    }

    @Override // h68.e
    public final void stop() {
        if (this.f288081i == AsrState.ASR_STARTED) goto L6;
        FLogger.f375446a.w("QuicAsrTask", "stop ignored, not started, taskId=" + this.f288073a);
        return;
    L6:
        FLogger.f375446a.i("QuicAsrTask", "stop quic asr (submit), taskId=" + this.f288073a);
        this.f288074b.JX();
        AsrState r100 = AsrState.ASR_STOP;
        this.f288081i = r100;
        h68.d r101 = this.f288080h;
        if (r101 == null) goto L10;
        r101.e(r100);
        return;
    }

    @Override // h68.e
    public final AsrState d() {
        return this.f288081i;
    }

    @Override // h68.e
    public final y58.a getConfig() {
        return this.f288079g;
    }

    @Override // h68.e
    public final String getTaskId() {
        return this.f288073a;
    }

    @Override // h68.e
    public final void f(h68.d r100) {
        this.f288080h = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, xa8.d r101, Function0<Integer> r102, Function2<? super byte[], ? super JSONObject, Unit> r103, Function1<? super byte[], Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "translatorAbility");
        Intrinsics.checkNotNullParameter(r102, "speakerModeProvider");
        Intrinsics.checkNotNullParameter(r103, "onReceiveTranslatedAudio");
        Intrinsics.checkNotNullParameter(r104, "onSendAudioData");
        Intrinsics.checkNotNullParameter(r105, "onTranslatedAudioPlayComplete");
        this.f288073a = r100;
        this.f288074b = r101;
        this.f288075c = r102;
        this.f288076d = r103;
        this.f288077e = r104;
        this.f288078f = r105;
        this.f288081i = AsrState.ASR_IDLE;
        this.f288083k = new C3951b(this);
    }
}
