package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class StagingArea {
    private static final Class<?> TAG = null;
    private Map<CacheKey, EncodedImage> mMap;

    private synchronized void logStats() {
        monitor-enter(this);
        FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void clearAll() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList(this.mMap.values());     // Catch: Throwable -> L13
        this.mMap.clear();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        int r101 = 0;
    L7:
        if (r101 >= r100.size()) goto L12;
        EncodedImage r102 = (EncodedImage) r100.get(r101);
        if (r102 == null) goto L11;
        r102.close();
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        TAG = StagingArea.class;
    }

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    private StagingArea() {
        this.mMap = new HashMap();
    }

    public synchronized boolean containsKey(CacheKey r100) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L22
        if (this.mMap.containsKey(r100) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        EncodedImage r101 = this.mMap.get(r100);     // Catch: Throwable -> L22
        monitor-enter(r101);     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L11:
        if (EncodedImage.isValid(r101) == true) goto L16;
        this.mMap.remove(r100);     // Catch: Throwable -> L19
        FLog.w(TAG, "Found closed reference %d for key %s (%d)", new Object[]{Integer.valueOf(System.identityHashCode(r101)), r100.getUriString(), Integer.valueOf(System.identityHashCode(r100))});     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized EncodedImage get(CacheKey r100) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L21
        EncodedImage r101 = this.mMap.get(r100);     // Catch: Throwable -> L21
        if (r101 == null) goto L19;
        monitor-enter(r101);     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L7:
        if (EncodedImage.isValid(r101) == true) goto L13;
        this.mMap.remove(r100);     // Catch: Throwable -> L16
        FLog.w(TAG, "Found closed reference %d for key %s (%d)", new Object[]{Integer.valueOf(System.identityHashCode(r101)), r100.getUriString(), Integer.valueOf(System.identityHashCode(r100))});     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        monitor-exit(this);
        return null;
    L13:
        EncodedImage r102 = EncodedImage.cloneOrNull(r101);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        r101 = r102;
    L19:
        monitor-exit(this);
        return r101;
    L21:
        th = move-exception;
        throw th;
    }

    public boolean remove(CacheKey r100) {
        Preconditions.checkNotNull(r100);
        monitor-enter(this);
        EncodedImage r101 = this.mMap.remove(r100);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r101 != null) goto L18;
        return false;
    L18:
        boolean r102 = r101.isValid();     // Catch: Throwable -> L12
        r101.close();
        return r102;
    L12:
        th = move-exception;
        r101.close();
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void put(CacheKey r100, EncodedImage r101) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L6
        Preconditions.checkArgument(EncodedImage.isValid(r101));     // Catch: Throwable -> L6
        EncodedImage.closeSafely(this.mMap.put(r100, EncodedImage.cloneOrNull(r101)));     // Catch: Throwable -> L6
        logStats();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean remove(CacheKey r100, EncodedImage r101) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L25
        Preconditions.checkNotNull(r101);     // Catch: Throwable -> L25
        Preconditions.checkArgument(EncodedImage.isValid(r101));     // Catch: Throwable -> L25
        EncodedImage r102 = this.mMap.get(r100);     // Catch: Throwable -> L25
        if (r102 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        CloseableReference<PooledByteBuffer> r103 = r102.getByteBufferRef();     // Catch: Throwable -> L25
        CloseableReference<PooledByteBuffer> r104 = r101.getByteBufferRef();     // Catch: Throwable -> L25
        if (r103 == null) goto L22;
        if (r104 == null) goto L22;
    L19:
        th = move-exception;
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L25
        CloseableReference.closeSafely(r103);     // Catch: Throwable -> L25
        EncodedImage.closeSafely(r102);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L12:
        if (r103.get() != r104.get()) goto L22;
        this.mMap.remove(r100);     // Catch: Throwable -> L19
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L25
        CloseableReference.closeSafely(r103);     // Catch: Throwable -> L25
        EncodedImage.closeSafely(r102);     // Catch: Throwable -> L25
        logStats();     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L22:
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L25
        CloseableReference.closeSafely(r103);     // Catch: Throwable -> L25
        EncodedImage.closeSafely(r102);     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L25:
        th = move-exception;
        throw th;
    }
}
