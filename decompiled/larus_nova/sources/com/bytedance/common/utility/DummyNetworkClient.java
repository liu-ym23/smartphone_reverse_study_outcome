package com.bytedance.common.utility;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DummyNetworkClient extends NetworkClient {
    public DummyNetworkClient() {
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r100, Map<String, String> r101, NetworkClient.ReqContext r102) throws Exception {
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, List<Pair<String, String>> r101, Map<String, String> r102, NetworkClient.ReqContext r103) throws CommonHttpException {
        throw new CommonHttpException(0, "not implemented");
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, byte[] r101, Map<String, String> r102, NetworkClient.ReqContext r103) throws CommonHttpException {
        throw new CommonHttpException(0, "not implemented");
    }
}
