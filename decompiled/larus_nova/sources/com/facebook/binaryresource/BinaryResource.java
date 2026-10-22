package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
