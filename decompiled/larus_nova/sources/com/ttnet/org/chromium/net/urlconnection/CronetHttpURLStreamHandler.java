package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX INFO: loaded from: classes41.dex */
class CronetHttpURLStreamHandler extends URLStreamHandler {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetHttpURLStreamHandler(ExperimentalCronetEngine r100) {
        this.mCronetEngine = r100;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r100) throws IOException {
        return this.mCronetEngine.openConnection(r100);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL r100, Proxy r101) throws IOException {
        return this.mCronetEngine.openConnection(r100, r101);
    }
}
