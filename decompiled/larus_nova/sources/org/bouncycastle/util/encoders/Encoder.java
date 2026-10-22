package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public interface Encoder {
    int decode(String r100, OutputStream r101) throws IOException;

    int decode(byte[] r100, int r101, int r102, OutputStream r103) throws IOException;

    int encode(byte[] r100, int r101, int r102, OutputStream r103) throws IOException;
}
