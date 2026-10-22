package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrAudioRecordException;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f243970l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sw5.a f243971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<rw5.d, Unit> f243973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f243974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f243975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<hw5.a, Unit> f243976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final buc.a f243977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final buc.e<hw5.a> f243978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final buc.d f243979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final buc.d f243980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f243981k;

    public static final class a {
    }

    static {
        f243970l = zw5.b.a("FlowAsrAudioRecordController");
    }

    public final hw5.a a() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c(f243970l, this.f243972b.a("record release begin frames=" + this.f243979i.c() + " bytes=" + this.f243980j.c()));
        Unit r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        sw5.a r103 = this.f243971a;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.stopRecorder();     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        hw5.a r107 = c(r106, FlowAsrErrorType.SOURCE_RELEASE_FAILED);
    L31:
        sw5.a r108 = this.f243971a;     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        r108.M0(this.f243981k);     // Catch: Throwable -> L20
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L20
    L22:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L25;
        IKMPLoggerService r111 = lp7.a.f510233a;
        lp7.a.b(f243970l, this.f243972b.a("record release remove listener failed " + zw5.b.c(r110)));
    L25:
        if (r107 != null) goto L27;
        IKMPLoggerService r112 = lp7.a.f510233a;
        lp7.a.c(f243970l, this.f243972b.a("record release success"));
    L28:
        return r107;
    L27:
        IKMPLoggerService r113 = lp7.a.f510233a;
        lp7.a.b(f243970l, this.f243972b.a("record release failed " + zw5.b.b(r107)));
    L20:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L14:
        r107 = null;
        goto L31
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final hw5.a b() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c(f243970l, this.f243972b.a("record stop begin frames=" + this.f243979i.c() + " bytes=" + this.f243980j.c()));
        Unit r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        sw5.a r103 = this.f243971a;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.stopRecorder();     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        hw5.a r107 = c(r106, FlowAsrErrorType.SOURCE_STOP_FAILED);
    L31:
        sw5.a r108 = this.f243971a;     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        r108.M0(this.f243981k);     // Catch: Throwable -> L20
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L20
    L22:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L25;
        IKMPLoggerService r111 = lp7.a.f510233a;
        lp7.a.b(f243970l, this.f243972b.a("record remove listener failed " + zw5.b.c(r110)));
    L25:
        if (r107 != null) goto L27;
        IKMPLoggerService r112 = lp7.a.f510233a;
        lp7.a.c(f243970l, this.f243972b.a("record stop success frames=" + this.f243979i.c() + " bytes=" + this.f243980j.c()));
    L28:
        return r107;
    L27:
        IKMPLoggerService r113 = lp7.a.f510233a;
        lp7.a.b(f243970l, this.f243972b.a("record stop failed " + zw5.b.b(r107)));
    L20:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L14:
        r107 = null;
        goto L31
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static hw5.a c(Throwable r100, FlowAsrErrorType r101) {
        if ((r100 instanceof FlowAsrAudioRecordException) == false) goto L5;
        FlowAsrAudioRecordException r102 = (FlowAsrAudioRecordException) r100;
    L6:
        if (r102 == null) goto L10;
        return r102.getError();
    L10:
        return i.b(r100, r101, null, 6);
    L5:
        r102 = null;
        goto L6
    }

    public f(sw5.a r100, zw5.a r101, com.bytedance.flow_audio.impl.business.asr.core.o r102, com.bytedance.flow_audio.impl.business.asr.core.p r103, com.bytedance.flow_audio.impl.business.asr.core.q r104, com.bytedance.flow_audio.impl.business.asr.core.r r105) {
        Intrinsics.checkNotNullParameter(r101, "logContext");
        Intrinsics.checkNotNullParameter(r102, "onFrame");
        Intrinsics.checkNotNullParameter(r103, "onRecordPaused");
        Intrinsics.checkNotNullParameter(r104, "onRecordResumed");
        Intrinsics.checkNotNullParameter(r105, "onRecordError");
        this.f243971a = r100;
        this.f243972b = r101;
        this.f243973c = r102;
        this.f243974d = r103;
        this.f243975e = r104;
        this.f243976f = r105;
        this.f243977g = buc.b.a(false);
        this.f243978h = buc.b.d(null);
        this.f243979i = buc.b.c(0);
        this.f243980j = buc.b.c(0);
        this.f243981k = new g(this);
    }
}
