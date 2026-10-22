package org.apache.commons.compress.compressors.pack200;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes42.dex */
class InMemoryCachingStreamBridge extends StreamBridge {
    public InMemoryCachingStreamBridge() {
        super(new ByteArrayOutputStream());
    }
}
