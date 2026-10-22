package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
abstract class StreamBridge extends FilterOutputStream {
    private final Object inputLock;

    public StreamBridge() {
        this(null);
    }

    public StreamBridge(OutputStream r100) {
        super(r100);
        this.inputLock = new Object();
    }
}
