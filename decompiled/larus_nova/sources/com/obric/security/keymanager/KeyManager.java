package com.obric.security.keymanager;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class KeyManager {
    private KeyManager() {
    }

    public static KeyManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public int deleteSyncKey(Context r100, String r101) {
        throw new RuntimeException("Stub!!");
    }

    public UDIDManagerResult getUDID(Context r100, Bundle r101) {
        throw new RuntimeException("Stub!!");
    }

    public int importKey(Context r100, Bundle r101) {
        throw new RuntimeException("Stub!!");
    }

    public int importKeyLegacy(Context r100, Bundle r101) {
        throw new RuntimeException("Stub!!");
    }

    public int deleteKey(Context r100, String r101, Bundle r102) {
        throw new RuntimeException("Stub!!");
    }

    public int generateKeyPair(Context r100, String r101, Bundle r102) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult getCertificateChain(Context r100, String r101, Bundle r102) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAttestation(Context r100, String r101, Bundle r102) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult sign(Context r100, String r101, byte[] r102, Bundle r103) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103) {
        throw new RuntimeException("Stub!!");
    }

    public int verify(Context r100, String r101, byte[] r102, byte[] r103, Bundle r104) {
        throw new RuntimeException("Stub!!");
    }
}
