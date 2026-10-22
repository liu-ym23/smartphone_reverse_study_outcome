package com.bytedance.common.support.service;

import com.bytedance.common.model.PushCommonConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public interface IPushConfigurationService {
    long getCurProcessStartTimeStamp();

    PushCommonConfiguration getPushCommonConfiguration();

    void injectConfiguration(PushCommonConfiguration r100);

    boolean keepOldInitTimeCost();

    boolean keepOldInitTimeCostV2();
}
