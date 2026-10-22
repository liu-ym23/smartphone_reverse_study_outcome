package com.lynx.clay.embedding.engine.plugins.audio;

import c5a.c;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class AudioPlayer {
    private static final String TAG = "AudioPlayer";
    private boolean autoPrepare;
    private boolean autoplay;
    private final ClayPluginContext factory;
    private a impl;
    private int interval;
    private boolean loop;
    private boolean mute;
    private long nativePtr;
    private String playUrl;
    private String srcId;
    private String type;
    private String vid;
    private float volume;

    public interface a {
        void a(int r100);

        int b();

        void c(boolean r100);

        int d();

        void dispose();

        void e();

        void enterBackground();

        void enterForeground();

        void f();

        int getCurrentTime();

        int getDuration();

        int getPlaybackState();

        void pause();

        void play();

        void prepare();

        void resume();

        void setInterval(int r100);

        void setLoop(boolean r100);

        void setSrc(String r100);

        void setVid(String r100);

        void setVolume(float r100);

        void stop();
    }

    private static native void nativeOnError(long r100, int r101, String r102, String r103);

    private static native void nativeOnFinished(long r100, String r101);

    private static native void nativeOnLoadingStateChanged(long r100, int r101, String r102, String r103);

    private static native void nativeOnPlaybackStateChanged(long r100, int r101, String r102, String r103);

    private static native void nativeOnPrepared(long r100, String r101);

    private static native void nativeOnSeek(long r100, String r101);

    private static native void nativeOnTimeUpdate(long r100, int r101, String r102);

    private void createPlayerImpl() {
        a r100 = this.impl;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        String r101 = this.type;
        switch(r101.hashCode()) {
            case -238594573: goto L18;
            case 102970646: goto L15;
            case 109413500: goto L12;
            case 1544803905: goto L9;
            default: goto L20;
        };
    L20:
        byte r102 = -1;
    L21:
        if (r102 == 0) goto L30;
        if (r102 == 1) goto L30;
        if (r5a.a.a(this.factory.f380756a.getContext()) == true) goto L38;
    L29:
        this.impl = new com.lynx.clay.embedding.engine.plugins.audio.a(this, "short-compat");
    L31:
        c.d(6, TAG, "AudioPlayer created, type = " + this.type);
        this.impl.e();
        this.impl.f();
        this.impl.setLoop(this.loop);
        this.impl.setInterval(this.interval);
        this.impl.c(this.mute);
        this.impl.setVolume(this.volume);
        String r103 = this.vid;
        if (r103 != null) goto L34;
    L36:
        this.impl.setSrc(this.playUrl);
        return;
    L34:
        if (r103.isEmpty() == true) goto L36;
        this.impl.setVid(this.vid);
        return;
    L38:
        this.impl = new b(this, this.type);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L30:
        this.impl = new com.lynx.clay.embedding.engine.plugins.audio.a(this, this.type);
        goto L31
    L9:
        if (r101.equals("default") == false) goto L20;
        r102 = 3;
        goto L21
    L12:
        if (r101.equals("short") == false) goto L20;
        r102 = 0;
        goto L21
    L15:
        if (r101.equals("light") == false) goto L20;
        r102 = 2;
        goto L21
    L18:
        if (r101.equals("short-compat") == false) goto L20;
        r102 = 1;
        goto L21
    }

    public int getCacheTime() {
        a r100 = this.impl;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.d();
    }

    public int getCurrentTime() {
        a r100 = this.impl;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentTime();
    }

    public int getDuration() {
        a r100 = this.impl;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    public FlutterView getFlutterView() {
        return this.factory.f380756a;
    }

    public int getPlayBitrate() {
        a r100 = this.impl;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.b();
    }

    public int getPlaybackState() {
        a r100 = this.impl;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getPlaybackState();
    }

    public void onDestroy() {
        a r100 = this.impl;
        if (r100 == null) goto L5;
        r100.dispose();
        this.impl = null;
    L5:
        this.nativePtr = 0;
    }

    public void onEnterBackground() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.enterBackground();
        return;
    }

    public void onEnterForeground() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.enterForeground();
        return;
    }

    public void pause() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    public void play() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    public void prepare() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.prepare();
        return;
    }

    public void resume() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.resume();
        return;
    }

    public void stop() {
        a r100 = this.impl;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public String getCurrentSrcID() {
        return this.srcId;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public float getVolume() {
        return this.volume;
    }

    public boolean isAutoplay() {
        return this.autoplay;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isMute() {
        return this.mute;
    }

    public AudioPlayer(ClayPluginContext r100) {
        this.autoplay = false;
        this.autoPrepare = false;
        this.loop = false;
        this.interval = 500;
        this.type = "default";
        this.mute = false;
        this.volume = 1.0f;
        this.nativePtr = 0;
        this.factory = r100;
    }

    public static AudioPlayer Create(ClayPluginContext r100) {
        return new AudioPlayer(r100);
    }

    private void setNativePtr(long r100) {
        this.nativePtr = r100;
    }

    public boolean isRemoteUrl(String r100) {
        if (r100.startsWith("http://") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.startsWith("https://") == true) goto L8;
        return false;
    }

    public void mute(boolean r100) {
        if (this.mute != r100) goto L5;
        return;
    L5:
        this.mute = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.c(r100);
        return;
    }

    public void onFinished(String r100) {
        nativeOnFinished(this.nativePtr, r100);
    }

    public void onPrepared(String r100) {
        nativeOnPrepared(this.nativePtr, r100);
    }

    public void onSeek(String r100) {
        nativeOnSeek(this.nativePtr, r100);
    }

    public void seek(int r100) {
        a r101 = this.impl;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void setAutoPrepare(boolean r100) {
        if (this.autoPrepare != r100) goto L5;
        return;
    L5:
        this.autoPrepare = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.e();
        return;
    }

    public void setAutoplay(boolean r100) {
        if (this.autoplay != r100) goto L5;
        return;
    L5:
        this.autoplay = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.f();
        return;
    }

    public void setInterval(int r100) {
        if (this.interval != r100) goto L5;
        return;
    L5:
        this.interval = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.setInterval(r100);
        return;
    }

    public void setLoop(boolean r100) {
        if (this.loop != r100) goto L5;
        return;
    L5:
        this.loop = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.setLoop(r100);
        return;
    }

    public void setPlayerType(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.equals(this.type) == true) goto L20;
        this.type = r100;
        if (this.playUrl != null) goto L14;
        String r101 = this.vid;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.isEmpty() == false) goto L14;
        return;
    L14:
        createPlayerImpl();
        return;
    }

    public void setSrc(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (r100.startsWith("{") == true) goto L34;
        String r101 = r100;
    L14:
        if (r100 != null) goto L16;
        return;
    L16:
        if (r100.isEmpty() == false) goto L18;
        return;
    L18:
        if (r100.equals(this.playUrl) == true) goto L41;
        if (r101 != null) goto L22;
    L23:
        r101 = r100;
    L24:
        this.srcId = r101;
        this.playUrl = r100;
        String r102 = this.vid;
        if (r102 != null) goto L27;
    L29:
        a r103 = this.impl;
        if (r103 == null) goto L32;
        r103.setSrc(r100);
        return;
    L32:
        createPlayerImpl();
        return;
    L27:
        if (r102.isEmpty() == true) goto L29;
        return;
    L22:
        if (r101.isEmpty() == false) goto L24;
    L41:
        return;
    L34:
        JSONObject r104 = new JSONObject(r100);     // Catch: Exception -> L10
        String r105 = r104.optString("id", null);     // Catch: Exception -> L10
        String r106 = r104.optString("play_url", null);     // Catch: Exception -> L10
        r101 = r105;
        r100 = r106;
    L10:
        e = move-exception;
        c.d(6, TAG, "AudioPlayer.setSrc failed");
        e.printStackTrace();
    }

    public void setVid(String r100) {
        if (r100 != null) goto L4;
    L14:
        String r101 = this.vid;
        if (r101 != null) goto L17;
        return;
    L17:
        if (r101.isEmpty() == true) goto L32;
        this.vid = null;
        this.srcId = "";
        a r102 = this.impl;
        if (r102 == null) goto L29;
        r102.setVid(null);
        String r103 = this.playUrl;
        if (r103 != null) goto L24;
        return;
    L24:
        if (r103.isEmpty() == true) goto L31;
        this.impl.setSrc(this.playUrl);
        return;
    L31:
        return;
    L29:
        return;
    L32:
        return;
    L4:
        if (r100.isEmpty() == true) goto L14;
        if (r100.equals(this.vid) == false) goto L9;
        return;
    L9:
        this.vid = r100;
        this.srcId = r100;
        a r104 = this.impl;
        if (r104 == null) goto L12;
        r104.setVid(r100);
        return;
    L12:
        createPlayerImpl();
    }

    public void setVolume(float r100) {
        if (this.volume != r100) goto L5;
        return;
    L5:
        this.volume = r100;
        a r101 = this.impl;
        if (r101 == null) goto L9;
        r101.setVolume(r100);
        return;
    }

    public void onTimeUpdate(int r100, String r101) {
        nativeOnTimeUpdate(this.nativePtr, r100, r101);
    }

    public void onError(int r100, String r101, String r102) {
        nativeOnError(this.nativePtr, r100, r101, r102);
    }

    public void onLoadingStateChanged(int r100, String r101, String r102) {
        nativeOnLoadingStateChanged(this.nativePtr, r100, r101, r102);
    }

    public void onPlaybackStateChanged(int r100, String r101, String r102) {
        nativeOnPlaybackStateChanged(this.nativePtr, r100, r101, r102);
    }
}
