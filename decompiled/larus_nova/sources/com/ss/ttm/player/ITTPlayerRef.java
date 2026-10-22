package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import com.ss.ttm.utils.OnceConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ITTPlayerRef {
    public ITTPlayerRef() {
    }

    public abstract void close();

    public abstract Context getContext();

    public abstract double getDoubleOption(int r100, double r101);

    public abstract float getFloatOption(int r100, float r101);

    public abstract int getIntOption(int r100, int r101);

    public abstract int getLifeId();

    public abstract long getLongOption(int r100, long r101);

    public abstract Object getObjectOption(int r100);

    public abstract String getStringOption(int r100);

    public abstract String getSubtitleContent(int r100);

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public void invalid() {
    }

    public abstract boolean isValid();

    public abstract void mouseEvent(int r100, int r101, int r102);

    public abstract void pause();

    public abstract int preDemux();

    public abstract void prepare();

    public abstract void prevClose();

    public abstract void release();

    public abstract void reset();

    public abstract void rotateCamera(float r100, float r101);

    public abstract void seekTo(int r100);

    public abstract void seekTo(int r100, int r101);

    public abstract void setABRStrategy(ABRStrategy r100);

    public abstract void setAIBarrageInfo(MaskInfo r100);

    public abstract void setAudioProcessor(AudioProcessor r100);

    public abstract void setCacheFile(String r100, int r101);

    public abstract void setDataSource(IMediaDataSource r100);

    public abstract void setDataSource(String r100);

    public abstract void setDataSourceFd(int r100);

    public abstract int setDoubleOption(int r100, double r101);

    public abstract int setFloatOption(int r100, float r101);

    public int setFloatOptionArray(int[] r100, float[] r101) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener r100);

    public abstract int setIntOption(int r100, int r101);

    public int setIntOptionArray(int[] r100, int[] r101) {
        return -1;
    }

    public abstract void setLoadControl(LoadControl r100);

    public abstract int setLongOption(int r100, long r101);

    public int setLongOptionArray(int[] r100, long[] r101) {
        return -1;
    }

    public abstract void setLooping(int r100);

    public abstract void setMaskInfo(MaskInfo r100);

    public abstract void setMediaTransport(MediaTransport r100);

    public abstract void setNotifyState(long r100);

    public abstract void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101);

    public abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener r100);

    public abstract void setStrategyParamsTransport(StrategyParamsTransport r100);

    public abstract int setStringOption(int r100, String r101);

    public int setStringOptionArray(int[] r100, String[] r101) {
        return -1;
    }

    public abstract void setSubInfo(SubInfo r100);

    public abstract void setSurface(Surface r100);

    public abstract void setSurfaceTimeOut(Surface r100, int r101);

    public abstract void setTraitObject(int r100, TraitObject r101);

    public abstract void setVolume(float r100, float r101);

    public abstract void setWindowClient(TTAVWindowClient r100);

    public abstract void setupMediaCodec();

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int r100, int r101);

    public abstract void takeScreenshot();

    public static void setGlobalIntOptionForKey(int r100, int r101) {
        TTPlayerRef.setGlobalIntOptionForKey(r100, r101);
    }

    public static void setGlobalStringOptionForKey(int r100, String r101) {
        TTPlayerRef.setGlobalStringOptionForKey(r100, r101);
    }

    public static synchronized ITTPlayerRef create(Context r100, TTPlayerClient r101, HashMap<Integer, Integer> r102, OnceConfig r110) {
        monitor-enter(ITTPlayerRef.class);
        Integer r103 = 0;     // Catch: Throwable -> L47
        if (r110 != null) goto L8;
        OnceConfig r104 = new OnceConfig(null);     // Catch: Throwable -> L47
    L10:
        if (r102 != null) goto L12;
    L14:
        int r105 = 1;
    L15:
        r104.setIntValue(42097, r105);     // Catch: Throwable -> L47
        if (r102 != null) goto L18;
    L20:
        int r106 = 0;
    L21:
        r104.setIntValue(42098, r106);     // Catch: Throwable -> L47
        TTPlayerRef r107 = TTPlayerRef.create(r101, r100, r104);     // Catch: Throwable -> L47
        if (r107 == null) goto L26;
        if (r110 != null) goto L25;
        r107.mOnceBySelf = r104;     // Catch: Throwable -> L47
    L25:
        TTPlayerConfiger.isPrintInfo();     // Catch: Throwable -> L47
    L26:
        if (r107 != null) goto L45;
        TTPlayerConfiger.getValue(16, "not find start service info.");     // Catch: Throwable -> L47
        if (r102 == null) goto L31;
        r103 = r102.get(100);     // Catch: Throwable -> L47
    L31:
        if (r102 == null) goto L41;
        if (r103 == null) goto L41;
        if (r103.intValue() != 1) goto L41;
        if (r102.get(7).intValue() != 0) goto L45;
        if (r102.get(10).intValue() >= 3) goto L45;
        r102.put(7, 1);     // Catch: Throwable -> L47
    L41:
        if (TTPlayerConfiger.getValue(7, false) == true) goto L45;
        if (TTPlayerConfiger.getValue(10, 0) >= 3) goto L45;
        TTPlayerConfiger.setValue(7, true);     // Catch: Throwable -> L47
    L45:
        monitor-exit(ITTPlayerRef.class);
        return r107;
    L18:
        if (r102.get(43) == null) goto L20;
        r106 = r102.get(43).intValue();     // Catch: Throwable -> L47
        goto L21
    L12:
        if (r102.get(33) == null) goto L14;
        r105 = r102.get(33).intValue();     // Catch: Throwable -> L47
        goto L15
    L8:
        r104 = r110;
    L47:
        th = move-exception;
        throw th;
    }
}
