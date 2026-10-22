package com.bytedance.common.wschannel.channel.impl.ok.policy;

import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
public interface RetryPolicy {
    long getRandomInterval();

    long getRetryIntervalWithResponse(Response r100);

    void reset();
}
