package com.ss.kmp.ugc.aweme.concurrent.lock;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock;", "", "()V", "delegate", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "readLock", "Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock$ReadLock;", "writeLock", "Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock$WriteLock;", "ReadLock", "WriteLock", "concurrent_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReentrantReadWriteLock {
    private final java.util.concurrent.locks.ReentrantReadWriteLock delegate;
    private final ReadLock readLock;
    private final WriteLock writeLock;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock$ReadLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "lock", "Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock;", "(Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock;)V", "concurrent_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReadLock extends java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock {
        public ReadLock(ReentrantReadWriteLock r100) {
            Intrinsics.checkNotNullParameter(r100, "lock");
            super(ReentrantReadWriteLock.access$getDelegate$p(r100));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock$WriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "lock", "Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock;", "(Lcom/ss/kmp/ugc/aweme/concurrent/lock/ReentrantReadWriteLock;)V", "concurrent_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WriteLock extends java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock {
        public WriteLock(ReentrantReadWriteLock r100) {
            Intrinsics.checkNotNullParameter(r100, "lock");
            super(ReentrantReadWriteLock.access$getDelegate$p(r100));
        }
    }

    public ReentrantReadWriteLock() {
        this.delegate = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.readLock = new ReadLock(this);
        this.writeLock = new WriteLock(this);
    }

    public final ReadLock readLock() {
        return this.readLock;
    }

    public final WriteLock writeLock() {
        return this.writeLock;
    }

    public static final /* synthetic */ java.util.concurrent.locks.ReentrantReadWriteLock access$getDelegate$p(ReentrantReadWriteLock r100) {
        return r100.delegate;
    }
}
