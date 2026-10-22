package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/LaunchEventListener;", "", "onFailure", "", "info", "Lcom/bytedance/cloudplay/xplay2/api/LaunchInfo;", "errCode", "", "errMsg", "", "onQueueRequired", "queueState", "Lcom/bytedance/cloudplay/xplay2/api/QueueState;", "onRequestSuccess", "onStartRequest", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LaunchEventListener {
    void onFailure(LaunchInfo r100, int r101, String r102);

    void onQueueRequired(LaunchInfo r100, QueueState r101);

    void onRequestSuccess(LaunchInfo r100);

    void onStartRequest();
}
