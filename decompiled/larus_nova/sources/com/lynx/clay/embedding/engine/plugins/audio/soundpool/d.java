package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.SoundPool;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements GenericSoundPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SoundPool f380823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GenericSoundPool.b f380824b;

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void a() {
        this.f380823a.autoResume();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void f() {
        this.f380823a.autoPause();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void release() {
        this.f380823a.setOnLoadCompleteListener(null);
        this.f380823a.release();
        this.f380823a = null;
    }

    public d() {
        SoundPool r100 = new SoundPool(1, 3, 0);
        this.f380823a = r100;
        r100.setOnLoadCompleteListener(new c(this));
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void b(com.lynx.clay.embedding.engine.plugins.audio.a.C4547a r100) {
        this.f380824b = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int load(String r100) {
        return this.f380823a.load(r100, 1);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void pause(int r100) {
        this.f380823a.pause(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void resume(int r100) {
        this.f380823a.resume(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void stop(int r100) {
        this.f380823a.stop(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void c(int r100, int r101) {
        this.f380823a.setLoop(r100, r101);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void e(int r100, float r101, float r102) {
        this.f380823a.setVolume(r100, r101, r102);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int d(int r100, float r101, float r110, int r111) {
        return this.f380823a.play(r100, r101, r110, 1, r111, 1.0f);
    }
}
