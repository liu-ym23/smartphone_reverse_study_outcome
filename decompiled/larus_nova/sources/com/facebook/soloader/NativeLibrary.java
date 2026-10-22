package com.facebook.soloader;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class NativeLibrary {
    private static final String TAG = null;
    private boolean mLibrariesLoaded;

    @Nullable
    private List<String> mLibraryNames;

    @Nullable
    private volatile UnsatisfiedLinkError mLinkError;
    private Boolean mLoadLibraries;
    private final Object mLock;

    public void initialNativeCheck() throws UnsatisfiedLinkError {
    }

    static {
        TAG = NativeLibrary.class.getName();
    }

    @Nullable
    public boolean loadLibraries() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoadLibraries.booleanValue() == true) goto L29;
        boolean r101 = this.mLibrariesLoaded;     // Catch: Throwable -> L25
        monitor-exit(r100);     // Catch: Throwable -> L25
        return r101;
    L29:
        List<String> r102 = this.mLibraryNames;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        if (r102 == null) goto L16;
        Iterator<String> r103 = r102.iterator();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L14:
        if (r103.hasNext() == false) goto L16;
        SoLoader.loadLibrary(r103.next());     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L16:
        initialNativeCheck();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        this.mLibrariesLoaded = true;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        this.mLibraryNames = null;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L22:
        this.mLoadLibraries = Boolean.FALSE;     // Catch: Throwable -> L25
        boolean r104 = this.mLibrariesLoaded;     // Catch: Throwable -> L25
        monitor-exit(r100);     // Catch: Throwable -> L25
        return r104;
    L18:
        th = move-exception;
        this.mLinkError = new UnsatisfiedLinkError("Failed loading libraries");     // Catch: Throwable -> L25
        this.mLinkError.initCause(th);     // Catch: Throwable -> L25
        this.mLibrariesLoaded = false;     // Catch: Throwable -> L25
    L20:
        e = move-exception;
        this.mLinkError = e;     // Catch: Throwable -> L25
        this.mLibrariesLoaded = false;     // Catch: Throwable -> L25
        goto L22
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        if (loadLibraries() == false) goto L6;
        return;
    L6:
        throw this.mLinkError;
    }

    @Nullable
    public UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }

    public NativeLibrary(List<String> r100) {
        this.mLock = new Object();
        this.mLoadLibraries = Boolean.TRUE;
        this.mLibrariesLoaded = false;
        this.mLinkError = null;
        this.mLibraryNames = r100;
    }
}
