package com.lynx.clay.embedding.engine.plugins.audio;

import c5a.c;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements AudioPlayer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioPlayer f380757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GenericSoundPool f380758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f380759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f380760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f380761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f380764h;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.a$a, reason: collision with other inner class name */
    public class C4547a implements GenericSoundPool.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f380765a;

        public C4547a(a r100) {
            this.f380765a = r100;
        }

        public final void a(int r100, boolean r101) {
            if (r101 == false) goto L8;
            a r102 = this.f380765a;
            r102.f380760d = r100;
            AudioPlayer r103 = r102.f380757a;
            r103.onPrepared(r103.getCurrentSrcID());
            a r104 = this.f380765a;
            if (r104.f380762f == false) goto L6;
        L7:
            this.f380765a.h();
        L9:
            this.f380765a.f380759c.set(false);
            return;
        L6:
            if (r104.f380757a.isAutoplay() == false) goto L9;
        L8:
            AudioPlayer r105 = this.f380765a.f380757a;
            r105.onError(-1, "load error", r105.getCurrentSrcID());
            goto L9
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void a(int r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int b() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int d() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void dispose() {
        c.d(6, "AudioPlayerSPImpl", "dispose");
        GenericSoundPool r100 = this.f380758b;
        if (r100 == null) goto L6;
        r100.release();
        this.f380758b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void f() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getCurrentTime() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getDuration() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getPlaybackState() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void pause() {
        c.d(5, "AudioPlayerSPImpl", "pause");
        int r100 = this.f380761e;
        if (r100 != 0) goto L5;
        c.d(5, "AudioPlayerSPImpl", "nothing to pause");
        return;
    L5:
        this.f380758b.pause(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void prepare() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void resume() {
        c.d(6, "AudioPlayerSPImpl", "resume");
        GenericSoundPool r100 = this.f380758b;
        if (r100 == null) goto L6;
        r100.resume(this.f380761e);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setInterval(int r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVid(String r100) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void stop() {
        c.d(5, "AudioPlayerSPImpl", "stop");
        int r100 = this.f380761e;
        if (r100 != 0) goto L5;
        c.d(5, "AudioPlayerSPImpl", "nothing to stop");
        return;
    L5:
        this.f380758b.stop(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterBackground() {
        if (this.f380763g == false) goto L5;
        return;
    L5:
        c.d(6, "AudioPlayerSPImpl", "enterBackground");
        GenericSoundPool r100 = this.f380758b;
        if (r100 == null) goto L8;
        r100.f();
    L8:
        this.f380763g = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterForeground() {
        if (this.f380763g == true) goto L5;
        return;
    L5:
        c.d(6, "AudioPlayerSPImpl", "enterForeground");
        GenericSoundPool r100 = this.f380758b;
        if (r100 == null) goto L8;
        r100.a();
    L8:
        this.f380763g = false;
    }

    public final void h() {
        if (this.f380757a.isMute() == false) goto L5;
        float r100 = 0.0f;
    L7:
        if (this.f380757a.isLoop() == false) goto L9;
        int r101 = -1;
    L10:
        int r102 = this.f380758b.d(this.f380760d, r100, r100, r101);
        this.f380761e = r102;
        if (r102 != 0) goto L14;
        c.d(6, "AudioPlayerSPImpl", "play sound failed");
        return;
    L14:
        return;
    L9:
        r101 = 0;
        goto L10
    L5:
        r100 = this.f380764h;
        goto L7
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void play() {
        if (this.f380758b != null) goto L5;
        return;
    L5:
        if (this.f380757a == null) goto L20;
        c.d(6, "AudioPlayerSPImpl", "play " + this.f380761e);
        int r100 = this.f380761e;
        if (r100 == 0) goto L11;
        this.f380758b.stop(r100);
    L11:
        if (this.f380760d == 0) goto L14;
        h();
        return;
    L14:
        if (this.f380759c.get() == false) goto L19;
        this.f380762f = true;
        return;
    L19:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void c(boolean r100) {
        int r101 = this.f380761e;
        if (r101 == 0) goto L11;
        GenericSoundPool r102 = this.f380758b;
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        float r103 = 0.0f;
    L9:
        r102.e(r101, r103, r103);
        return;
    L8:
        r103 = this.f380764h;
        goto L9
    L12:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setLoop(boolean r100) {
        c.d(6, "AudioPlayerSPImpl", "setLoop");
        int r101 = this.f380761e;
        if (r101 == 0) goto L10;
        GenericSoundPool r102 = this.f380758b;
        if (r100 == false) goto L7;
        int r103 = -1;
    L8:
        r102.c(r101, r103);
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setSrc(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.f380758b == null) goto L20;
        AudioPlayer r101 = this.f380757a;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isRemoteUrl(r100) == true) goto L14;
        ThreadMethodProxy.start(new PthreadThreadV2(new h5a.b(this, r100), "AudioPlayerSPImpl"));
        return;
    L14:
        if (this.f380757a == null) goto L24;
        ResourceLoaderImpl.create().loadAsFile(r100, new h5a.a(this), false);
        return;
    L24:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVolume(float r100) {
        this.f380764h = r100;
        if (this.f380758b == null) goto L13;
        AudioPlayer r101 = this.f380757a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f380761e != 0) goto L10;
        return;
    L10:
        if (r101.isMute() == true) goto L15;
        this.f380758b.e(this.f380761e, r100, r100);
        return;
    L15:
        return;
    }

    public a(AudioPlayer r100, String r101) {
        byte r102 = 0;
        this.f380759c = new AtomicBoolean(false);
        this.f380760d = 0;
        this.f380761e = 0;
        this.f380762f = false;
        this.f380763g = false;
        this.f380764h = 1.0f;
        this.f380757a = r100;
        int r103 = r101.hashCode();
        if (r103 == (-238594573)) goto L11;
        if (r103 == 109413500) goto L8;
    L13:
        r102 = -1;
    L14:
        if (r102 == 0) goto L16;
        this.f380758b = GenericSoundPool.Types.SYSTEM.create(r100.getFlutterView().getContext().getApplicationContext());
    L17:
        this.f380758b.b(new C4547a(this));
        return;
    L16:
        this.f380758b = GenericSoundPool.Types.COMPACT.create(r100.getFlutterView().getContext().getApplicationContext());
        goto L17
    L8:
        if (r101.equals("short") == false) goto L13;
        r102 = 1;
        goto L14
    L11:
        if (r101.equals("short-compat") == false) goto L13;
        goto L13
    }

    public static void g(a r100, String r101) {
        if (r100.f380758b != null) goto L5;
        return;
    L5:
        if (r100.f380757a == null) goto L14;
        r100.f380759c.set(true);
        r100.f380758b.load(r101);     // Catch: Exception -> L10
        return;
    L15:
        return;
    }
}
