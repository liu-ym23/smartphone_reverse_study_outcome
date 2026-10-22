package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.utils.HardWareInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class TTMediaPlayer implements MediaPlayer {
    protected MediaPlayerClient mClient;
    protected int mPlayerType;

    @Override // com.ss.ttm.player.MediaPlayer
    public void setCacheFile(String r100, int r101) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentPosition();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getDataSource();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getType();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTrackInfo();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoHeight();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoType();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoWidth();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isLooping();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isMute();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isOSPlayer() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.getType() == 0) goto L8;
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isPlaying();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void pause() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void preDemux() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.preDemux();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.prepare();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.prepareAsync();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prevClose() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.prevClose();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void release() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.releaseAsync();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void reset() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void start() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void stop() {
        MediaPlayerClient r100 = this.mClient;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public TTMediaPlayer() {
        this.mPlayerType = 0;
    }

    static {
        TTVersion.saveVersionInfo();
    }

    public static final synchronized TTMediaPlayer create(Context r100) {
        monitor-enter(TTMediaPlayer.class);
        TTMediaPlayer r101 = new TTMediaPlayer();     // Catch: Throwable -> L31
        if (TTPlayerConfiger.isPrintInfo() == false) goto L36;
        TTPlayerConfiger.getValue(1, false);     // Catch: Throwable -> L31
        TTPlayerConfiger.getValue(2, false);     // Catch: Throwable -> L31
        TTPlayerConfiger.getValue(7, false);     // Catch: Throwable -> L31
        HardWareInfo.getCpuFamily();     // Catch: Throwable -> L31
        TTPlayerConfiger.getValue(10, 0);     // Catch: Throwable -> L31
        TTPlayerConfiger.getValue(11, false);     // Catch: Throwable -> L31
        TTPlayerConfiger.getValue(15, "not find version info");     // Catch: Throwable -> L31
    L36:
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
        if (TTPlayerConfiger.getValue(7, false) == true) goto L18;
        TTPlayerConfiger.setValue(7, true);     // Catch: Throwable -> L31
    L18:
        MediaPlayerClient r102 = null;
    L19:
        if (r102 != null) goto L25;
        TTPlayerConfiger.isPrintInfo();     // Catch: Throwable -> L31
        if (TTPlayerConfiger.getValue(11, false) == false) goto L24;
        monitor-exit(TTMediaPlayer.class);
        return null;
    L24:
        r102 = OSPlayerClient.create(r101, r100);     // Catch: Throwable -> L31
        r101.mPlayerType = 0;     // Catch: Throwable -> L31
    L25:
        if (r102 != null) goto L28;
        monitor-exit(TTMediaPlayer.class);
        return null;
    L28:
        r101.mClient = r102;     // Catch: Throwable -> L31
        monitor-exit(TTMediaPlayer.class);
        return r101;
    L9:
        if (TTPlayerConfiger.isOnTTPlayer() == false) goto L11;
    L12:
        r102 = TTPlayerClient.create(r101, r100, null, null);     // Catch: Throwable -> L14
    L11:
        if (TTPlayerConfiger.getValue(11, false) == false) goto L18;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void deselectTrack(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        if (r100 != 0) goto L6;
        r101.setIntOption(261, 1);
        return;
    L6:
        if (r101 == null) goto L10;
        r101.setIntOption(65, (r100 << 8) | 0);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getSelectedTrack(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getSelectedTrack(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getStringOption(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getStringOption(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void seekTo(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.seekTo(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void selectTrack(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L7;
        if (r100 != 0) goto L8;
        r101.setIntOption(261, 0);
        return;
    L8:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, IOException {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setDataSource(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDisplay(SurfaceHolder r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setDisplay(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIsMute(boolean r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setIsMute(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLooping(boolean r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setMediaTransport(MediaTransport r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setMediaTransport(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnBufferingUpdateListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnCompletionListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnErrorListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnExternInfoListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnInfoListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnLogListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnPreparedListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnSARChangedListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnSeekCompleteListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setOnVideoSizeChangedListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPanoVideoControlModel(int r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setPanoVideoControlModel(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setPlaybackParams(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setScreenOnWhilePlaying(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurface(Surface r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isValid() == false) goto L11;
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L12;
        r101.setSurface(r100);
        return;
    L12:
        return;
    }

    public void setUnSupportSampleRates(int[] r100) {
        if (isOSPlayer() == false) goto L5;
        return;
    L5:
        int r101 = r100.length;
        if (r101 > 0) goto L8;
        return;
    L8:
        int r102 = MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES.length;
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r101) goto L17;
        int r105 = 0;
    L11:
        if (r105 >= r102) goto L16;
        if (MediaPlayer.MEDIA_PLAYER_SUPPORT_SAMPLERATES[r105] == r100[r103]) goto L14;
        r105 = r105 + 1;
        goto L11
    L14:
        r104 = r104 | (1 << r105);
    L16:
        r103 = r103 + 1;
        goto L9
    L17:
        MediaPlayerClient r106 = this.mClient;
        if (r106 == null) goto L25;
        r106.setIntOption(111, r104);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWindowClient(TTAVWindowClient r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setWindowClient(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener r100) {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.takeScreenshot(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(String r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r101 = this.mClient;
        if (r101 == null) goto L6;
        r101.setDataSource(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public float getFloatOption(int r100, float r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getFloatOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getIntOption(int r100, int r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getIntOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long getLongOption(int r100, long r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void rotateCamera(float r100, float r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.rotateCamera(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context r100, Uri r101) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setDataSource(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int setFloatOption(int r100, float r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L5;
        return -1;
    L5:
        return r102.setFloatOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setFloatOptionArray(int[] r100, float[] r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setFloatOptionArray(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOption(int r100, int r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setIntOption(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOptionArray(int[] r100, int[] r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setIntOptionArray(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long setLongOption(int r100, long r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L5;
        return -1;
    L5:
        return r102.setLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLongOptionArray(int[] r100, long[] r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setLongOptionArray(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 != null) goto L6;
        r102.setOnImageAvailableListener(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOption(int r100, String r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setStringOption(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOptionArray(int[] r100, String[] r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setStringOptionArray(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurfaceTimeOut(Surface r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isValid() == false) goto L11;
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L12;
        r102.setSurfaceTimeOut(r100, r101);
        return;
    L12:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setTraitObject(int r100, TraitObject r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setTraitObject(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setVolume(float r100, float r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setVolume(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWakeMode(Context r100, int r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setWakeMode(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void switchStream(int r100, int r101) {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.switchStream(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void mouseEvent(int r100, int r101, int r102) {
        MediaPlayerClient r103 = this.mClient;
        if (r103 == null) goto L6;
        r103.mouseEvent(r100, r101, r102);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(FileDescriptor r100, long r101, long r110) throws IllegalStateException, IllegalArgumentException, IOException {
        MediaPlayerClient r102 = this.mClient;
        if (r102 == null) goto L6;
        r102.setDataSource(r100, r101, r110);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context r100, Uri r101, Map<String, String> r102) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r103 = this.mClient;
        if (r103 == null) goto L6;
        r103.setDataSource(r100, r101, r102);
        return;
    }
}
