package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.impl.core.task.FlowAudioAssistantTask;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAudioParam;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionUplinkEventType;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f244018e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dx5.a f244019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f244020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qw5.a f244021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dx5.d f244022d;

    public static final class a {
    }

    static {
        f244018e = zw5.b.a("FlowAsrTaskCoordinator");
    }

    public final dx5.d b() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        String r101 = f244018e;
        zw5.a r102 = this.f244020b;
        StringBuilder r103 = new StringBuilder("create assistant session requestType=");
        r103.append(this.f244021c.f534995c);
        r103.append(" audioSrc=");
        gw5.i r104 = this.f244021c.f535002j;
        if (r104 == null) goto L7;
        gw5.b r105 = r104.getContext();
        if (r105 == null) goto L7;
        Integer r106 = Integer.valueOf(r105.f483038f);
    L8:
        r103.append(r106);
        lp7.a.c(r101, r102.a(r103.toString()));
        dx5.d r107 = new dx5.d(this.f244021c);
        dx5.a r108 = this.f244019a;
        Intrinsics.checkNotNullParameter(r108, "listener");
        ReentrantLock r109 = r107.f470425f;
        r109.lock();
        r107.f470424e.add(r108);     // Catch: Throwable -> L12
        r109.unlock();
        return r107;
    L12:
        th = move-exception;
        r109.unlock();
        throw th;
    L7:
        r106 = null;
        goto L8
    }

    public final void c() throws Exception {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c(f244018e, this.f244020b.a("end asr uplink"));
        dx5.d r101 = this.f244022d;
        r101.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        r101.e("run:endAsr");     // Catch: Throwable -> L12
        ReentrantLock r103 = r101.f470423d;     // Catch: Throwable -> L12
        r103.lock();     // Catch: Throwable -> L12
        FlowAudioAssistantTask r104 = r101.f470422c;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.c("endAsr");     // Catch: Throwable -> L9
        r104.a(r104.d(SpeechVoiceAssistantSessionUplinkEventType.EndASR, null), "endAsr");     // Catch: Throwable -> L9
        r104.c("endAsr: ok");     // Catch: Throwable -> L9
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r103.unlock();     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        r101.d("run:endAsr error=" + r107);
    L17:
        ResultKt.throwOnFailure(r106);
        return;
    L9:
        th = move-exception;
        r103.unlock();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final void e() throws Exception {
        IKMPLoggerService r100 = lp7.a.f510233a;
        String r101 = f244018e;
        zw5.a r102 = this.f244020b;
        StringBuilder r103 = new StringBuilder("start assistant task audioSrc=");
        gw5.i r104 = this.f244021c.f535002j;
        if (r104 == null) goto L7;
        gw5.b r105 = r104.getContext();
        if (r105 == null) goto L7;
        Integer r106 = Integer.valueOf(r105.f483038f);
    L8:
        r103.append(r106);
        lp7.a.c(r101, r102.a(r103.toString()));
        this.f244022d.g();
        return;
    L7:
        r106 = null;
        goto L8
    }

    public final void a(boolean r100) {
        IKMPLoggerService r101 = lp7.a.f510233a;
        lp7.a.c(f244018e, this.f244020b.a("clear assistant task reuseTask=" + r100));
        this.f244022d.b(r100);
    }

    public final int d(rw5.d r210) {
        Intrinsics.checkNotNullParameter(r210, "frame");
        dx5.d r100 = this.f244022d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "frame");
        String r101 = "sendAsrAudio size=" + r210.f539717b.length;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        String r103 = "runOrNull:" + r101;     // Catch: Throwable -> L22
        Long r104 = (Long) ((LinkedHashMap) r100.f470426g).get("sendAsrAudio");     // Catch: Throwable -> L22
        if (r104 == null) goto L6;
        long r110 = r104.longValue();     // Catch: Throwable -> L22
    L7:
        long r111 = r110 + 1;     // Catch: Throwable -> L22
        r100.f470426g.put("sendAsrAudio", Long.valueOf(r111));     // Catch: Throwable -> L22
        if (r111 != 1) goto L10;
    L11:
        r100.e(r103);     // Catch: Throwable -> L22
    L12:
        ReentrantLock r105 = r100.f470423d;     // Catch: Throwable -> L22
        r105.lock();     // Catch: Throwable -> L22
        FlowAudioAssistantTask r106 = r100.f470422c;     // Catch: Throwable -> L19
        if (r106 == null) goto L17;
        Intrinsics.checkNotNullParameter(r210, "frame");     // Catch: Throwable -> L19
        String r107 = r106.f244096a.f534993a;     // Catch: Throwable -> L19
        byte[] r108 = r210.f539717b;     // Catch: Throwable -> L19
        Integer r109 = Integer.valueOf(r106.f244097b.sendUplinkAudio(new SpeechVoiceAssistantSessionAudioParam(r107, r107, r108, r108.length, null, 0, null)));     // Catch: Throwable -> L19
    L18:
        r105.unlock();     // Catch: Throwable -> L22
        Object r112 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L22
    L24:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L28;
        r100.d("runOrNull:" + r101 + " error=" + r113);
    L28:
        if (Result.m9455isFailureimpl(r112) == false) goto L30;
        Object r114 = null;
    L31:
        Integer r115 = (Integer) r114;
        if (r115 != null) goto L39;
        return -1;
    L39:
        return r115.intValue();
    L30:
        r114 = r112;
        goto L31
    L17:
        r109 = null;
    L19:
        th = move-exception;
        r105.unlock();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L10:
        if ((r111 % ((long) 50)) != 0) goto L12;
    L6:
        r110 = 0;
    L22:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public r(qw5.a r100, dx5.a r101, zw5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "initialConfig");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "logContext");
        this.f244019a = r101;
        this.f244020b = r102;
        this.f244021c = r100;
        this.f244022d = b();
    }
}
