package com.ss.cast.discovery.mdns;

/* JADX INFO: loaded from: classes40.dex */
public interface NsdListener {
    void onNsdDiscoveryFinished();

    void onNsdError(String r100, int r101, String r102);

    void onNsdRegistered(NsdService r100);

    void onNsdServiceFound(NsdService r100);

    void onNsdServiceLost(NsdService r100);

    void onNsdServiceResolved(NsdService r100);

    void onNsdUnRegistered(NsdService r100);
}
