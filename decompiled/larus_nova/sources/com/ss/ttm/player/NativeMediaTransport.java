package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes40.dex */
public class NativeMediaTransport extends MediaTransport {
    public NativeMediaTransport() {
    }

    private static boolean isNativeMediaTransport(MediaTransport r100) {
        return r100 instanceof NativeMediaTransport;
    }

    @Override // com.ss.ttm.player.MediaTransport
    public void sendPacket(MediaTransport.MediaPacket r100) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
