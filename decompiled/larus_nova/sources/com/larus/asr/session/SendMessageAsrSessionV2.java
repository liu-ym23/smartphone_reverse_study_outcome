package com.larus.asr.session;

import android.os.Handler;
import android.os.Looper;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrMessageResultPostComponent;
import com.larus.asr.session.component.ObricAsrPreComponent;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class SendMessageAsrSessionV2 extends ComponentAsrSession {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f287549q = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d58.a f287550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Long f287551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Long f287552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f287553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f287554n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f287555o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final x3 f287556p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void clear() {
        this.f287554n = true;
        this.f287551k = null;
        this.f287555o.removeCallbacks(this.f287556p);
        super.clear();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.asr.session.u3] */
    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.f287439a, new t3()), new com.larus.asr.session.component.t0(this.f287439a, VoiceInputType.TouchSpeaker, new u3(this)), new com.larus.asr.session.component.z(this.f287439a, null, new v3(this), 14), new ObricAsrPreComponent(this.f287444f, true), new com.larus.asr.session.component.u0(this.f287439a, this.f287440b, this.f287444f, new com.larus.asr.session.component.e(true, false, null, null, 62))}), CollectionsKt.listOf(new com.larus.asr.session.component.o0[]{new com.larus.asr.session.component.y0(this.f287439a, this.f287444f, true, new SendMessageAsrSessionV2$createComponents$4(this)), new com.larus.asr.session.component.l0(this.f287439a, this.f287444f), new AsrMessageResultPostComponent(this.f287439a, this.f287440b, this.f287444f, this.f287441c, new w3(this)), new com.larus.asr.session.component.z0(this.f287439a, this.f287444f, true)}));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean f(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f287553m == true) goto L5;
    L10:
        return true;
    L5:
        if (this.f287554n == false) goto L7;
    L9:
        return false;
    L7:
        if (e(r100) == false) goto L9;
        goto L9
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f287550j = r100.b().f287756h;
        this.f287551k = r100.b().f287754f;
        this.f287553m = true;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f287554n = true;
        this.f287555o.removeCallbacks(this.f287556p);
        super.qa(r100, r101);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f287552l = Long.valueOf(System.currentTimeMillis());
        this.f287554n = true;
        this.f287555o.removeCallbacks(this.f287556p);
        super.ma(r100, r101, r102);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.asr.session.x3] */
    public SendMessageAsrSessionV2(final p r100, final String r101, final VoiceInputType r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "voiceInputType");
        Intrinsics.checkNotNullParameter(r103, "isCurrentSession");
        super(r100, r101, r102, r103);
        this.f287550j = d58.a.f467063d;
        this.f287553m = true;
        this.f287555o = new Handler(Looper.getMainLooper());
        this.f287556p = new x3(this, r100, r101, r102);
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void j(com.larus.asr.session.component.f0 r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "path");
        this.f287554n = true;
        this.f287555o.removeCallbacks(this.f287556p);
        r100.f(true);
        r100.d();
        if (r103 != AsrEventEnum.ASR_RECORDER_SILENCED.getCode()) goto L5;
    L6:
        r100.f287704f.set(false);
        r100.f287703e.compareAndSet(false, true);
        return;
    L5:
        if (r103 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L6;
    }
}
