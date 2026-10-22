package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public interface ISpeedPredictorMLConfig {
    boolean enable();

    String getModelDirName();

    String getModelType();

    String modelUrl();
}
