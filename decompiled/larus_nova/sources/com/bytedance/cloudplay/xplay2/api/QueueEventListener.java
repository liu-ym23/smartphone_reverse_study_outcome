package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/QueueEventListener;", "", "onDeQueue", "", "onInQueueFailed", "errCode", "", "errMsg", "", "onInQueueSuccess", "onQueueExit", "reason", "onQueueExpire", "onQueueFinish", "queueResult", "Lcom/bytedance/cloudplay/xplay2/api/QueueResult;", "onQueueStateUpdate", "queueState", "Lcom/bytedance/cloudplay/xplay2/api/QueueState;", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QueueEventListener {
    void onDeQueue();

    void onInQueueFailed(int r100, String r101);

    void onInQueueSuccess();

    void onQueueExit(String r100);

    void onQueueExpire();

    void onQueueFinish(QueueResult r100);

    void onQueueStateUpdate(QueueState r100);
}
