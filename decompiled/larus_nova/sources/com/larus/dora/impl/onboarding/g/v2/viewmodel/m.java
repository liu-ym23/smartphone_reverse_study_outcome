package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import com.larus.platform.api.n0;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f336821a;

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
        g49.d.d("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onCompletion");
        this.f336821a.f336818e = false;
    }

    @Override // com.larus.platform.api.n0
    public final void onRenderStart() {
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onRenderStart");
    }

    public m(l r100) {
        this.f336821a = r100;
    }

    @Override // com.larus.platform.api.n0
    public final void a(Integer r100, Integer r101) {
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onError");
        this.f336821a.f336818e = false;
    }
}
