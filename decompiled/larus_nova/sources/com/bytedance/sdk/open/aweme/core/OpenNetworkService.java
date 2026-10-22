package com.bytedance.sdk.open.aweme.core;

import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenNetworkService extends IOpenService {
    IOpenHostNetCall newCall(OpenHostRequest r100);
}
