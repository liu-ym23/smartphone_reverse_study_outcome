package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AbsAudioPlayManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x extends com.larus.audio.call.play.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f378627x;

    @Override // com.larus.audio.call.play.c
    public final boolean q() {
        if (this.f289310p == AbsAudioPlayManager.Wait.COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.audio.call.play.c
    public final String t() {
        return this.f378627x;
    }

    public x(RealtimeCallParam r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "realtimeCallParam");
        super(r100, r101, r101);
        this.f378627x = "QuicAudioPlayManager" + hashCode();
    }
}
