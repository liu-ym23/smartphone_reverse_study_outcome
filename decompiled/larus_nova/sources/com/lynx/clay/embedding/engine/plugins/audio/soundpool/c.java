package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.SoundPool;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements SoundPool.OnLoadCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f380822a;

    public c(d r100) {
        this.f380822a = r100;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool r100, int r101, int r102) {
        GenericSoundPool.b r103 = this.f380822a.f380824b;
        if (r103 == null) goto L9;
        if (r102 != 0) goto L6;
        boolean r104 = true;
    L7:
        ((com.lynx.clay.embedding.engine.plugins.audio.a.C4547a) r103).a(r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }
}
