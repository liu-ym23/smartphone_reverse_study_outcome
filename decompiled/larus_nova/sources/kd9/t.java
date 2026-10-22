package kd9;

import com.larus.im.internal.jni.media.OmniAudioEngineProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class t implements com.larus.im.service.audio.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OmniAudioEngineProtocol f502936a;

    @Override // com.larus.im.service.audio.n
    public final void setup() {
    }

    @Override // com.larus.im.service.audio.n
    public final void startCapture() {
        this.f502936a.startRecorder();
    }

    @Override // com.larus.im.service.audio.n
    public final void stopCapture() {
        this.f502936a.stopRecorder();
    }

    @Override // com.larus.im.service.audio.n
    public final void release() {
        com.larus.im.internal.delegate.w.c r100 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r100 == null) goto L5;
        boolean r101 = r100.f348345q;
    L6:
        if (r101 == true) goto L9;
        this.f502936a.destroyEngine();
        return;
    L9:
        return;
    L5:
        r101 = true;
        goto L6
    }

    public t(OmniAudioEngineProtocol r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        this.f502936a = r100;
    }

    @Override // com.larus.im.service.audio.n
    public final void setBluetoothForceToMedia(boolean r100) {
        this.f502936a.setBluetoothForceToMedia(r100);
    }
}
