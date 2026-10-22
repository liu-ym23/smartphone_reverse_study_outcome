package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class UnownedUserDataHost {
    private final DestroyChecker mDestroyChecker;
    private Handler mHandler;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    public static /* synthetic */ void a(UnownedUserDataHost r100, UnownedUserData r101) {
        r100.lambda$remove$0(r101);
    }

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    private void checkState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mDestroyChecker.isDestroyed() == false) goto L5;
        return;
    L5:
        Iterator r100 = new HashSet(this.mUnownedUserDataMap.keySet()).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((UnownedUserDataKey) r100.next()).detachFromHost(this);
        goto L7
    L9:
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mDestroyChecker.destroy();
    }

    public boolean isDestroyed() {
        return this.mDestroyChecker.isDestroyed();
    }

    private static Looper retrieveNonNullLooperOrThrow() {
        Looper r100 = Looper.myLooper();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException();
    }

    public int getMapSize() {
        checkState();
        return this.mUnownedUserDataMap.size();
    }

    public UnownedUserDataHost(Handler r100) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mUnownedUserDataMap = new HashMap();
        this.mHandler = r100;
    }

    private /* synthetic */ void lambda$remove$0(UnownedUserData r100) {
        r100.onDetachedFromHost(this);
    }

    public <T extends UnownedUserData> T get(UnownedUserDataKey<T> r100) {
        checkState();
        WeakReference<? extends UnownedUserData> r101 = this.mUnownedUserDataMap.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        UnownedUserData r102 = r101.get();
        if (r102 != null) goto L10;
        r100.detachFromHost(this);
        return null;
    L10:
        return r100.getValueClass().cast(r102);
    }

    public <T extends UnownedUserData> void remove(UnownedUserDataKey<T> r100) {
        checkState();
        WeakReference<? extends UnownedUserData> r101 = this.mUnownedUserDataMap.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        final UnownedUserData r102 = r101.get();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.informOnDetachmentFromHost() == false) goto L12;
        this.mHandler.post(new m(this, r102));
        return;
    }

    public <T extends UnownedUserData> void set(UnownedUserDataKey<T> r100, T r101) {
        checkState();
        if (this.mUnownedUserDataMap.containsKey(r100) == true) goto L5;
    L7:
        this.mUnownedUserDataMap.put(r100, new WeakReference(r101));
        return;
    L5:
        if (r101.equals(get(r100)) == true) goto L7;
        r100.detachFromHost(this);
        goto L7
    }
}
