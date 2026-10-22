package u52;

import com.bytedance.speech.speechengine.SpeechEngine;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements SpeechEngine.SpeechListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f548800a;

    public i(j r100) {
        this.f548800a = r100;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine.SpeechListener
    public final void onSpeechMessage(int r100, byte[] r101, int r102) {
        this.f548800a.g(r100, r101);
    }
}
