package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class SharedReference<T> {
    private static final Map<Object, Integer> sLiveObjects = null;
    private int mRefCount;
    private final ResourceReleaser<T> mResourceReleaser;
    private T mValue;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public synchronized void addReference() {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L6
        this.mRefCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int decreaseRefCount() {
        monitor-enter(this);
        ensureValid();     // Catch: Throwable -> L10
        if (this.mRefCount <= 0) goto L6;
        boolean r100 = true;
    L7:
        Preconditions.checkArgument(r100);     // Catch: Throwable -> L10
        int r101 = this.mRefCount - 1;     // Catch: Throwable -> L10
        this.mRefCount = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L6:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized T get() {
        monitor-enter(this);
        T r100 = this.mValue;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getRefCountTestOnly() {
        monitor-enter(this);
        int r100 = this.mRefCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isValid() {
        monitor-enter(this);
        if (this.mRefCount <= 0) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        sLiveObjects = new IdentityHashMap();
    }

    private void ensureValid() {
        if (isValid(this) == false) goto L6;
        return;
    L6:
        throw new NullReferenceException();
    }

    public void deleteReference() {
        if (decreaseRefCount() != 0) goto L11;
        monitor-enter(this);
        T r100 = this.mValue;     // Catch: Throwable -> L8
        this.mValue = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.mResourceReleaser.release(r100);
        removeLiveReference(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static Map<Object, Integer> getLiveObjects() {
        return sLiveObjects;
    }

    public int getRefCount() {
        return this.mRefCount;
    }

    private static void addLiveReference(Object r100) {
        Map<Object, Integer> r101 = sLiveObjects;
        monitor-enter(r101);
        Integer r102 = r101.get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        r101.put(r100, 1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r101.put(r100, Integer.valueOf(r102.intValue() + 1));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean isValid(SharedReference<?> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isValid() == false) goto L6;
        return true;
    }

    private static void removeLiveReference(Object r100) {
        Map<Object, Integer> r101 = sLiveObjects;
        monitor-enter(r101);
        Integer r102 = r101.get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L8;
        FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[]{r100.getClass()});     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        if (r102.intValue() != 1) goto L10;
        r101.remove(r100);     // Catch: Throwable -> L13
        goto L11
    L10:
        r101.put(r100, Integer.valueOf(r102.intValue() - 1));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public SharedReference(T r100, ResourceReleaser<T> r101) {
        this.mValue = (T) Preconditions.checkNotNull(r100);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(r101);
        this.mRefCount = 1;
        addLiveReference(r100);
    }
}
