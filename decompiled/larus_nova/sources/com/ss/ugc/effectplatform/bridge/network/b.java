package com.ss.ugc.effectplatform.bridge.network;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends INetworkClient {
    NetResponse a(NetRequest r100, String r101, String r102, a r103);

    void cancel(String r100);

    void pause(String r100);
}
