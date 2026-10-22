package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class UnownedUserDataKey<T extends UnownedUserData> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Class<T> mClazz;
    private final Set<UnownedUserDataHost> mWeakHostAttachments;

    private void assertNoDestroyedAttachments() {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L12;
        Iterator<UnownedUserDataHost> r100 = this.mWeakHostAttachments.iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        if (r100.next().isDestroyed() == false) goto L6;
        throw new IllegalStateException();
    L16:
        return;
    }

    static {
    }

    public final Class<T> getValueClass() {
        return this.mClazz;
    }

    public UnownedUserDataKey(Class<T> r100) {
        this.mWeakHostAttachments = Collections.newSetFromMap(new WeakHashMap());
        this.mClazz = r100;
    }

    private void removeHostAttachment(UnownedUserDataHost r100) {
        r100.remove(this);
        this.mWeakHostAttachments.remove(r100);
    }

    public final void detachFromAllHosts(T r100) {
        assertNoDestroyedAttachments();
        Iterator r101 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        UnownedUserDataHost r102 = (UnownedUserDataHost) r101.next();
        if (r100.equals(r102.get(this)) == false) goto L4;
        removeHostAttachment(r102);
        goto L4
    }

    public final void detachFromHost(UnownedUserDataHost r100) {
        assertNoDestroyedAttachments();
        Iterator r101 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        UnownedUserDataHost r102 = (UnownedUserDataHost) r101.next();
        if (r100.equals(r102) == false) goto L4;
        removeHostAttachment(r102);
        goto L4
    }

    public int getHostAttachmentCount(T r100) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r101 = this.mWeakHostAttachments.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.equals(r101.next().get(this)) == false) goto L4;
        r102 = r102 + 1;
        goto L4
    L8:
        return r102;
    }

    public final boolean isAttachedToAnyHost(T r100) {
        if (getHostAttachmentCount(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAttachedToHost(UnownedUserDataHost r100) {
        if (retrieveDataFromHost(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final T retrieveDataFromHost(UnownedUserDataHost r100) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r101 = this.mWeakHostAttachments.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.equals(r101.next()) == false) goto L4;
        return (T) r100.get(this);
    L9:
        return null;
    }

    public final void attachToHost(UnownedUserDataHost r100, T r101) {
        Objects.requireNonNull(r101);
        r100.set(this, r101);
        if (isAttachedToHost(r100) == true) goto L6;
        this.mWeakHostAttachments.add(r100);
        return;
    }
}
