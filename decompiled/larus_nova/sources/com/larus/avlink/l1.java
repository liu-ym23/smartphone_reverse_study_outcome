package com.larus.avlink;

import com.larus.avlink.activeSummary.SoundPlayManager;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes24.dex */
public final class l1 implements SoundPlayManager.b {
    public l1() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onBegin() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onError() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onEnd() {
        Lazy r100 = DoraWakeupSoundController.f291405a;
        DoraWakeupSoundController.f291411g = false;
    }
}
