package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public interface IMetadataObserver {
    void onMetadataReceived(byte[] r100, String r101, long r102);

    byte[] onReadyToSendMetadata(long r100);
}
