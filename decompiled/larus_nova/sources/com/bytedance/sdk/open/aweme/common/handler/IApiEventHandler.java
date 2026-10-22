package com.bytedance.sdk.open.aweme.common.handler;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* JADX INFO: loaded from: classes22.dex */
public interface IApiEventHandler {
    void onErrorIntent(Intent r100);

    void onReq(BaseReq r100);

    void onResp(BaseResp r100);
}
