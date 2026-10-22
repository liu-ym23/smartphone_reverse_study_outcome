package com.larus.dora.impl.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements com.larus.platform.api.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f337342a;

    @Override // com.larus.platform.api.n0
    public final void b(Integer r100, Integer r101) {
    }

    @Override // com.larus.platform.api.n0
    public final void c(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void d(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepare() {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepared() {
    }

    @Override // com.larus.platform.api.n0
    public final void onVideoStatusException(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void onCompletion() {
        g49.d.d("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onCompletion");
        this.f337342a.f337339f = false;
    }

    @Override // com.larus.platform.api.n0
    public final void onRenderStart() {
        g49.d.b("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onRenderStart");
    }

    public s(r r100) {
        this.f337342a = r100;
    }

    @Override // com.larus.platform.api.n0
    public final void a(Integer r100, Integer r101) {
        g49.d.b("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onError");
        this.f337342a.f337339f = false;
    }
}
