package com.bytedance.apm.agent.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private long count;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    private void notifyStreamComplete() {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.impl.close();     // Catch: IOException -> L4
        notifyStreamComplete();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.impl.flush();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    public long getCount() {
        return this.count;
    }

    public CountingOutputStream(OutputStream r3) {
        this.count = 0;
        this.listenerManager = new StreamCompleteListenerManager();
        this.impl = r3;
    }

    private void notifyStreamError(Exception r5) {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, r5));
        return;
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r2) {
        this.listenerManager.addStreamCompleteListener(r2);
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r2) {
        this.listenerManager.removeStreamCompleteListener(r2);
    }

    @Override // java.io.OutputStream
    public void write(int r5) throws IOException {
        this.impl.write(r5);     // Catch: IOException -> L4
        this.count++;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5) throws IOException {
        this.impl.write(r5);     // Catch: IOException -> L4
        this.count += (long) r5.length;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) throws IOException {
        this.impl.write(r3, r4, r5);     // Catch: IOException -> L4
        this.count += (long) r5;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }
}
