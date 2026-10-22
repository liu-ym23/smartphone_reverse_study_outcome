package com.bytedance.vcloud.networkpredictor;

import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface ISpeedPredictor {
    void close();

    float getAverageDownloadSpeed(int r100, int r101, boolean r102);

    Map<String, String> getDownloadSpeed(int r100);

    float getLastPredictConfidence();

    String getMultidimensionalDownloadSpeeds();

    SpeedPredictorResultCollection getMultidimensionalDownloadSpeedsObj();

    String getMultidimensionalPredictSpeeds();

    SpeedPredictorResultCollection getMultidimensionalPredictSpeedsObj();

    float getPredictSpeed();

    float getPredictSpeed(int r100);

    String getVersion();

    void prepare();

    void release();

    void setConfigInfo(Map r100);

    void setSpeedQueueSize(int r100);

    void start();

    void update(long r100, long r101, long r102);

    void update(ISpeedRecordOld r100, Map<String, Integer> r101);

    void update(String r100, Map<String, Integer> r101);
}
