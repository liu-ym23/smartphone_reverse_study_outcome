package com.bytedance.vcloud.abrmodule;

import com.ss.ttm.player.ABRStrategy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IABRModule {
    public static final int SELECT_SCENE_PRELOAD = 0;
    public static final int SELECT_SCENE_STARTUP = 1;

    void addBufferInfo(int r100, String r101, long r102, long r103, long r104);

    float getFloatOption(int r100, float r101);

    long getLongOption(int r100, long r101);

    ABRResult getPredict();

    String getPredictByJsonParams(String r100);

    String getStringOption(int r100, String r101);

    String getVersion();

    void init(IPlayStateSupplier r100);

    ABRResult onceSelect(int r100, int r101);

    void release();

    void setDeviceInfo(IDeviceInfo r100);

    void setDoubleOptionForKey(int r100, double r101);

    void setFloatOptionForKey(int r100, float r101);

    void setInfoListener(IABRInfoListener r100);

    void setIntOptionForKey(int r100, int r101);

    void setLongOptionForKey(int r100, long r101);

    void setMediaInfo(List<IVideoStream> r100, List<IAudioStream> r101);

    void setSRBenchmark(Map<Integer, Integer> r100);

    void setSRBenchmarkMap(Map<Integer, List<Integer>> r100);

    void setStringOptionForKey(int r100, String r101);

    void start(int r100, int r101);

    void stop();

    ABRStrategy toStratrgy();
}
