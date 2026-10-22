package com.bytedance.mira.plugin.core.func.soloader.utils;

import java.util.Stack;

/* JADX INFO: loaded from: classes21.dex */
public class ObjectPool<T> {
    private final Stack<Result<T>> availableObjects;
    private final int maxPoolSize;

    public synchronized Result<T> acquire() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.availableObjects.isEmpty() == false) goto L8;
        Result<T> r100 = new Result();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L8:
        Result<T> r101 = this.availableObjects.pop();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public ObjectPool(int r100) {
        this.availableObjects = new Stack();
        this.maxPoolSize = r100;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.availableObjects.push(new Result());
        r101 = r101 + 1;
        goto L3
    }

    public synchronized void release(Result<T> r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.availableObjects.size() >= this.maxPoolSize) goto L6;
        r100.setResult(null);     // Catch: Throwable -> L8
        this.availableObjects.push(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
