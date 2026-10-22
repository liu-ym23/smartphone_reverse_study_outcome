package com.bytedance.sdk.open.aweme.core.net;

/* JADX INFO: loaded from: classes22.dex */
public interface IOpenHostNetCall {
    void cancel();

    OpenHostResponse execute();

    OpenHostRequest getRequest();
}
