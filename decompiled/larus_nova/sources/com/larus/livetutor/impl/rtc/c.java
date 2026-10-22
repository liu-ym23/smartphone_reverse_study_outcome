package com.larus.livetutor.impl.rtc;

import com.ss.bytertc.engine.IAudioFrameObserver;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements IAudioFrameObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f356283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jj9.c f356284b;

    @Override // com.ss.bytertc.engine.IAudioFrameObserver
    public final void onCaptureMixedAudioFrame(IAudioFrame r100) {
    }

    @Override // com.ss.bytertc.engine.IAudioFrameObserver
    public final void onMixedAudioFrame(IAudioFrame r100) {
    }

    @Override // com.ss.bytertc.engine.IAudioFrameObserver
    public final void onPlaybackAudioFrame(IAudioFrame r100) {
    }

    @Override // com.ss.bytertc.engine.IAudioFrameObserver
    public final void onRecordAudioFrame(IAudioFrame r100) {
    }

    public c(String r100, com.larus.livetutor.impl.rtc.handler.q.c r101) {
        this.f356283a = r100;
        this.f356284b = r101;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameObserver
    public final void onRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101) {
        if (r100 == null) goto L4;
        String r102 = r100.userId;
    L6:
        if (Intrinsics.areEqual(r102, this.f356283a) == false) goto L12;
        if (r101 == null) goto L13;
        ByteBuffer r103 = r101.getExtraInfo();
        if (r103 == null) goto L14;
        this.f356284b.a(StandardCharsets.UTF_8.decode(r103).toString());
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    L4:
        r102 = null;
        goto L6
    }
}
