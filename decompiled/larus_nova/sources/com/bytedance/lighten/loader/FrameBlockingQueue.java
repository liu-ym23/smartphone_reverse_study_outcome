package com.bytedance.lighten.loader;

import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes20.dex */
class FrameBlockingQueue<E> extends LinkedBlockingDeque<E> {
    private int mFixedSize;

    public FrameBlockingQueue(int r100) {
        this.mFixedSize = r100;
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (size() != this.mFixedSize) goto L6;
        removeLast();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        return super.offerFirst(r100);
    }
}
