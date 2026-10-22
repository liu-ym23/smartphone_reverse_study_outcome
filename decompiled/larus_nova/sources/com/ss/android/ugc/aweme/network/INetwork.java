package com.ss.android.ugc.aweme.network;

import com.bytedance.retrofit2.SsResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001e\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/network/INetwork;", "", "getDependConfig", "Lcom/ss/android/ugc/aweme/network/NetworkDependConfig;", "getInitConfig", "Lcom/ss/android/ugc/aweme/network/NetworkOuterConfig;", "init", "", "config", "listener", "Lcom/ss/android/ugc/aweme/network/NetworkInitListener;", "monitorNetwork", "response", "Lcom/bytedance/retrofit2/SsResponse;", "errorCode", "", "useMonitorRefactor", "", "waitTTNetInit", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public interface INetwork {
    NetworkDependConfig getDependConfig();

    NetworkOuterConfig getInitConfig();

    void init(NetworkDependConfig r100, NetworkInitListener r101);

    void monitorNetwork(SsResponse<Object> r100, int r101);

    boolean useMonitorRefactor();

    void waitTTNetInit();
}
