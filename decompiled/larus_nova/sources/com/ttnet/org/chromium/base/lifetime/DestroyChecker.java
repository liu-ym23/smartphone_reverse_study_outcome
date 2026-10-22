package com.ttnet.org.chromium.base.lifetime;

/* JADX INFO: loaded from: classes41.dex */
public class DestroyChecker implements Destroyable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsDestroyed;

    public DestroyChecker() {
    }

    public void checkNotDestroyed() {
    }

    @Override // com.ttnet.org.chromium.base.lifetime.Destroyable
    public void destroy() {
        checkNotDestroyed();
        this.mIsDestroyed = true;
    }

    static {
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }
}
