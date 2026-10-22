package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.bridge.IEnvBridge;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public interface ICloudTransCrypto {
    byte[] dataDecrypt(byte[] r100);

    byte[] dataEncrypt(byte[] r100);

    void fullFileDecrypt(InputStream r100, OutputStream r101);

    void fullFileEncrypt(InputStream r100, OutputStream r101);

    void init(Context r100, String r101, String r102, IEnvBridge r103);

    TransCryptoContext initDecryptContext(Context r100, String r101, String r102, byte[] r103, IEnvBridge r104);

    TransCryptoContext initEncryptContext(Context r100, String r101, String r102, IEnvBridge r103);

    void pageFileDecrypt(TransCryptoContext r100, InputStream r101, OutputStream r102);

    void pageFileEncrypt(TransCryptoContext r100, InputStream r101, OutputStream r102);

    void streamDecrypt(InputStream r100, OutputStream r101);

    byte[] streamDecryptBytes(TransCryptoContext r100, byte[] r101);

    TransCryptoContext streamDecryptFirstBytes(byte[] r100);

    void streamEncrypt(InputStream r100, OutputStream r101);
}
