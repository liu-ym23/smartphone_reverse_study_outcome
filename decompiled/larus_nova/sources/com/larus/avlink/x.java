package com.larus.avlink;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.k4;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes24.dex */
public final class x extends k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f294739a;

    @Override // com.larus.avlink.plugins.k4, f49.b
    public final void d(int r100) {
    }

    public x(w r100) {
        this.f294739a = r100;
    }

    @Override // com.larus.avlink.plugins.k4, f49.b
    public final void j(byte[] r100, byte[] r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        w r102 = this.f294739a;
        AudioRecordState r103 = r102.f294729b;
        if (r103 != AudioRecordState.INITIALIZED) goto L7;
    L15:
        r102.f294731d.write(r100);     // Catch: Exception -> L12
        this.f294739a.f294731d.flush();     // Catch: Exception -> L12
        if (r101 == null) goto L18;
        ((LinkedBlockingQueue) this.f294739a.f294732e).offer(r101);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        n1.c("DoraAudioRecorder", "onVoiceData called", e);
        return;
    L7:
        if (r103 == AudioRecordState.STARTED) goto L15;
    }
}
