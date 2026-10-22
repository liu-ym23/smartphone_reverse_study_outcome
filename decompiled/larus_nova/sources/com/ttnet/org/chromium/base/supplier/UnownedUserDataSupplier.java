package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.base.UnownedUserDataHost;
import com.ttnet.org.chromium.base.UnownedUserDataKey;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import com.ttnet.org.chromium.base.lifetime.Destroyable;

/* JADX INFO: loaded from: classes41.dex */
public abstract class UnownedUserDataSupplier<E> extends ObservableSupplierImpl<E> implements Destroyable, UnownedUserData {
    private final DestroyChecker mDestroyChecker;
    private final UnownedUserDataKey<UnownedUserDataSupplier<E>> mUudKey;

    @Override // com.ttnet.org.chromium.base.UnownedUserData
    public final /* synthetic */ boolean informOnDetachmentFromHost() {
        return UnownedUserData.CC.$default$informOnDetachmentFromHost(this);
    }

    @Override // com.ttnet.org.chromium.base.UnownedUserData
    public final /* synthetic */ void onDetachedFromHost(UnownedUserDataHost r100) {
        UnownedUserData.CC.$default$onDetachedFromHost(this, r100);
    }

    @Override // com.ttnet.org.chromium.base.lifetime.Destroyable
    public void destroy() {
        this.mDestroyChecker.destroy();
        this.mUudKey.detachFromAllHosts(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnownedUserDataSupplier(UnownedUserDataKey<? extends UnownedUserDataSupplier<E>> r100) {
        this.mDestroyChecker = new DestroyChecker();
        this.mUudKey = r100;
    }

    public void attach(UnownedUserDataHost r100) {
        this.mDestroyChecker.checkNotDestroyed();
        this.mUudKey.attachToHost(r100, this);
    }
}
