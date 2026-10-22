package u52;

import com.bytedance.speech.speechengine.SpeechEngine;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements SpeechEngine.SpeechListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f548783a;

    public a(b r100) {
        this.f548783a = r100;
    }

    @Override // com.bytedance.speech.speechengine.SpeechEngine.SpeechListener
    public final void onSpeechMessage(int r100, byte[] r101, int r102) {
        this.f548783a.g(r100, r101);
    }
}
