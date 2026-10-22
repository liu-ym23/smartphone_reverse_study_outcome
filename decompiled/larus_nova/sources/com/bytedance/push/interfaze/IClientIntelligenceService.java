package com.bytedance.push.interfaze;

import com.bytedance.push.b0;
import l77.b;

/* JADX INFO: loaded from: classes3.dex */
public interface IClientIntelligenceService extends com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService {
    boolean curIsLowCtr();

    boolean enableClientIntelligencePushShow();

    b getClientIntelligenceSettings();

    void onPushStart();

    com.bytedance.push.client.intelligence.b showPushWithClientIntelligenceStrategy(b0 r100, boolean r101);
}
