package com.larus.larkfeed.impl.voice.service.asr;

import com.larus.audio.IFlowAsrClientService;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import com.ss.android.lark.voiceinput.impl.service.asr.VoiceAsrStateMachine;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f355643k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final abc.b f355644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tac.a f355645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xac.a f355646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h68.e f355647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f355648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f355649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b1 f355650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1 f355651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f355652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Job f355653j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Job r100 = this.f355653j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f355653j = null;
        CoroutineScopeKt.cancel$default(this.f355652i, null, 1, null);
        b();
        h r101 = this.f355649f;
        VoiceAsrState r102 = VoiceAsrState.Destroy;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "newState");
        VoiceAsrStateMachine r103 = r101.f355656c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "newState");
        jbc.a<VoiceAsrState> r104 = r103.f445108a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "nextValue");
        r104.f498065b.setValue(r102);
    }

    public final void b() {
        h68.e r100 = this.f355647d;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f355647d = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        IFlowAsrClientService.f288298a.getClass();     // Catch: Throwable -> L8
        IFlowAsrClientService.a.a().v(r100);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        j.c("FlowVoiceAsrSession", "【VoiceApp】Failed to release ASR task: taskId=" + r100.getTaskId(), r103);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public g(abc.b r100, tac.a r101, xac.a r102) {
        Intrinsics.checkNotNullParameter(r100, "recordDetail");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "voiceContext");
        this.f355644a = r100;
        this.f355645b = r101;
        this.f355646c = r102;
        this.f355648e = new e();
        h r103 = new h(r100.f2524a, r101.f545224b.f549299e.f553989a);
        this.f355649f = r103;
        this.f355650g = r103.f355659f;
        this.f355651h = r103.f355657d;
        this.f355652i = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
