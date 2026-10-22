package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public interface ZipEncoding {
    boolean canEncode(String r100);

    String decode(byte[] r100) throws IOException;

    ByteBuffer encode(String r100) throws IOException;
}
