package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.pb.videochat.SIStreamSyncInfo;
import com.ss.android.lark.pb.videochat.StreamSyncInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f434784a = null;

    static {
        f434784a = new n();
    }

    public n() {
    }

    public static m a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        SIStreamSyncInfo r103 = StreamSyncInfo.ADAPTER.decode(r100).msiInfo;     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        Long r104 = r103.mseq_id;     // Catch: Throwable -> L12
    L7:
        if (r103 == null) goto L9;
        boolean r105 = Intrinsics.areEqual(r103.mchange_to_origin, Boolean.TRUE);     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(new m(r104, r105));     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L18;
        lvb.a.b("MmAIInterpretationStreamSyncInfoParser", "[parse] failed: " + r107);
    L18:
        if (Result.m9455isFailureimpl(r106) == true) goto L22;
        r101 = r106;
    L22:
        return (m) r101;
    L9:
        r105 = false;
        goto L10
    L6:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
