package com.larus.audio.call.play;

import android.media.AudioTrack;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f289319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f289320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f289321c;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        r101.i(this.f289319a.t(), "[" + this.f289320b + "]:onMarkerReached");
        if (this.f289319a.f289315u == true) goto L6;
        r101.i(this.f289319a.t(), "[" + this.f289320b + "]onMarkerReached first frame:" + (System.currentTimeMillis() - this.f289321c) + "ms");
        this.f289319a.f289315u = true;
        this.f289319a.f289289e.c();
        return;
    }

    public d(c r100, long r101) {
        this.f289319a = r100;
        this.f289320b = "tts_start";
        this.f289321c = r101;
    }
}
