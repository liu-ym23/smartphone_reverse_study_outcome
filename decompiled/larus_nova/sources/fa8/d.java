package fa8;

import com.larus.avlink.n1;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends com.larus.audio.call.play.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f476045a;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onPlayComplete() {
        c r100 = this.f476045a;
        if (r100.f476043x.compareAndSet(false, true) == false) goto L13;
        n1.d("DoraGSiAudioPlayManager", "stop DoraG SI player after play complete");     // Catch: Throwable -> L8
        r100.d(false, false, "dora_g_si_play_complete");     // Catch: Throwable -> L8
        r100.f476043x.set(false);
        return;
    L8:
        th = move-exception;
        r100.f476043x.set(false);
        throw th;
    }

    public d(c r100) {
        this.f476045a = r100;
    }
}
