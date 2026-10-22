package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public final class CloseableReference<T> implements Cloneable, Closeable {
    private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = null;
    private static Class<CloseableReference> TAG;
    public boolean mIsClosed;
    private final SharedReference<T> mSharedReference;

    public synchronized CloseableReference<T> clone() {
        monitor-enter(this);
        Preconditions.checkState(isValid());     // Catch: Throwable -> L6
        CloseableReference<T> r100 = new CloseableReference(this.mSharedReference);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized CloseableReference<T> cloneOrNull() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isValid() == false) goto L8;
        CloseableReference<T> r100 = clone();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L8:
        monitor-exit(this);
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsClosed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.mIsClosed = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.mSharedReference.deleteReference();
    }

    public void finalize() throws Throwable {
        monitor-enter(this);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L4:
        if (this.mIsClosed == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        super.finalize();
        return;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        FLog.d(TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());     // Catch: Throwable -> L15
        close();     // Catch: Throwable -> L15
        super.finalize();
        return;
    L15:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public synchronized T get() {
        monitor-enter(this);
        T r100 = this.mSharedReference.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        monitor-enter(this);
        SharedReference<T> r100 = this.mSharedReference;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isValid() {
        monitor-enter(this);
        boolean r100 = !this.mIsClosed;
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        TAG = CloseableReference.class;
        DEFAULT_CLOSEABLE_RELEASER = new AnonymousClass1();
    }

    public int getValueHash() {
        if (isValid() == true) goto L7;
        return 0;
    L7:
        return System.identityHashCode(this.mSharedReference.get());
    }

    public SharedReference<T> getSharedReference() {
        return this.mSharedReference;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8526clone() throws CloneNotSupportedException {
        return clone();
    }

    private CloseableReference(SharedReference<T> r100) {
        this.mIsClosed = false;
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(r100);
        r100.addReference();
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<CloseableReference<T>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(cloneOrNull(r102.next()));
        goto L7
    L9:
        return r101;
    }

    public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> r100) {
        if (r100 == null) goto L7;
        Iterator<? extends CloseableReference<?>> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        closeSafely(r101.next());
        goto L5
    L9:
        return;
    }

    public static boolean isValid(@Nullable CloseableReference<?> r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isValid() == false) goto L6;
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(Closeable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new CloseableReference(r100, DEFAULT_CLOSEABLE_RELEASER);
    }

    @Nullable
    public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.cloneOrNull();
    }

    public static void closeSafely(@Nullable CloseableReference<?> r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }

    private CloseableReference(T r100, ResourceReleaser<T> r101) {
        this.mIsClosed = false;
        this.mSharedReference = new SharedReference(r100, r101);
    }

    public static <T> CloseableReference<T> of(T r100, ResourceReleaser<T> r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new CloseableReference(r100, r101);
    }
}
