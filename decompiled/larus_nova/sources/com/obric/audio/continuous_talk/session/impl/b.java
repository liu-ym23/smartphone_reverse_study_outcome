package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioManager;
import com.larus.audio.call.RealtimeCallParam;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b extends com.larus.audio.call.play.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f395264x;

    @Override // com.larus.audio.call.play.AbsAudioPlayManager
    public final com.larus.audio.call.play.b l() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r101) == null) goto L10;
        r101 = 3;
    L10:
        int r102 = ((Number) r101).intValue();
        if (this.f289285a == true) goto L13;
    L15:
        int r103 = 1280;
    L16:
        Integer r104 = this.f289287c;
        if (r104 == null) goto L19;
        int r105 = r104.intValue();
    L21:
        if (this.f289285a == true) goto L23;
    L25:
        int r106 = com.larus.audio.call.common.a.f289093a;
        int r107 = 4;
    L27:
        return new com.larus.audio.call.play.b(r102, r103, r105, r107);
    L23:
        if (this.f289286b == false) goto L25;
        int r108 = com.larus.audio.call.common.a.f289093a;
        r107 = 12;
        goto L27
    L19:
        r105 = 24000;
        goto L21
    L13:
        if (this.f289286b == false) goto L15;
        r103 = TECameraUtils.CAPTURE_HQ_2X;
    L4:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.audio.call.play.c
    public final String t() {
        return this.f395264x;
    }

    public b(RealtimeCallParam r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "realtimeCallParam");
        super(r100, r101, r102);
        this.f395264x = "ObricContAudioPlayManager" + hashCode();
    }
}
