package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public interface Translator {
    int decode(byte[] r100, int r101, int r102, byte[] r103, int r104);

    int encode(byte[] r100, int r101, int r102, byte[] r103, int r104);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
