package com.ss.ttm.ttvideodecode;

/* JADX INFO: loaded from: classes40.dex */
public class Native {
    public Native() {
    }

    private static native byte[] _encryptAesCbc128(byte[] r100, byte[] r101);

    private static native String _getDecodedStr(byte[] r100, byte[] r101);

    private static native byte[] _getSignature(String r100);

    private static native int _getSupportedMethod();

    public static int getSupportedMethod() {
        return _getSupportedMethod();
    }

    public static byte[] getSignature(String r100) {
        return _getSignature(r100);
    }

    public static byte[] encryptAesCbc128(byte[] r100, byte[] r101) {
        return _encryptAesCbc128(r100, r101);
    }

    public static String getDecodedStr(byte[] r100, byte[] r101) {
        return _getDecodedStr(r100, r101);
    }
}
