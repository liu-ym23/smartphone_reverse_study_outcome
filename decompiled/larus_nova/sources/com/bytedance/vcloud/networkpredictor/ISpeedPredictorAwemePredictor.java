package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public interface ISpeedPredictorAwemePredictor {
    double calculateSpeed();

    void configMlModel(ISpeedPredictorMLConfig r100);

    double getSpeed();

    void monitorVideoSpeed(double r100, double r101, long r102);

    void setPredictorListener(ISpeedPredictorAwemeListener r100);

    void setSpeedAlgorithmType(int r100);
}
