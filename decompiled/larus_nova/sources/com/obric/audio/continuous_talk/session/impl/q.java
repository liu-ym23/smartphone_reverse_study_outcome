package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioManager;
import android.media.AudioTrack;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f395354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioTrack f395355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f395356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f395357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f395358e;

    public final void a() {
        int r100 = AudioTrack.getMinBufferSize(this.f395356c, this.f395357d, this.f395358e);     // Catch: Exception -> L21
        if (r100 >= 0) goto L24;
        com.larus.audio.call.util.e.f289645a.e(this.f395354a, "getMinBufferSize failed: " + r100);     // Catch: Exception -> L21
        return;
    L24:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L15;
        r102 = 3;     // Catch: Exception -> L21
    L15:
        AudioTrack r103 = new AudioTrack(((Number) r102).intValue(), this.f395356c, this.f395357d, this.f395358e, r100, 1);     // Catch: Exception -> L21
        this.f395355b = r103;     // Catch: Exception -> L21
        if (fna.g.d() == true) goto L18;
        r103.play();     // Catch: Exception -> L21
    L19:
        com.larus.audio.call.util.e.f289645a.i(this.f395354a, "SilentAudioTrackPlayer started");     // Catch: Exception -> L21
        return;
    L18:
        r103.play();     // Catch: Exception -> L21
        gna.a.c(r103.hashCode());     // Catch: Exception -> L21
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Exception -> L21
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(this.f395354a, "start failed: " + e);
        b();
    }

    public final void b() {
        AudioTrack r100 = this.f395355b;     // Catch: Throwable -> L13 Exception -> L15
        if (r100 != null) goto L6;
    L12:
        this.f395355b = null;
        com.larus.audio.call.util.e.f289645a.i(this.f395354a, "SilentAudioTrackPlayer stopped");
        return;
    L6:
        if (r100.getState() != 1) goto L12;
        if (fna.g.d() == true) goto L10;
        r100.stop();     // Catch: Throwable -> L13 Exception -> L15
    L11:
        r100.release();     // Catch: Throwable -> L13 Exception -> L15
    L10:
        r100.stop();     // Catch: Throwable -> L13 Exception -> L15
        gna.a.a(r100.hashCode());     // Catch: Throwable -> L13 Exception -> L15
    L13:
        th = move-exception;
        this.f395355b = null;
        com.larus.audio.call.util.e.f289645a.i(this.f395354a, "SilentAudioTrackPlayer stopped");
        throw th;
    L15:
        e = move-exception;
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L13
        r101.e(this.f395354a, "stop failed: " + e);     // Catch: Throwable -> L13
        this.f395355b = null;
        r101.i(this.f395354a, "SilentAudioTrackPlayer stopped");
    }

    public q() {
        this.f395354a = "SilentAudioTrackPlayer";
        this.f395356c = 24000;
        this.f395357d = 4;
        this.f395358e = 2;
    }
}
