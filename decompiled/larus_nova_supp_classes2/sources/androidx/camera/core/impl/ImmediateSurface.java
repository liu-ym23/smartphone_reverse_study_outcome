package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    @Override // androidx.camera.core.impl.DeferrableSurface
    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }

    public ImmediateSurface(Surface r1) {
        this.mSurface = r1;
    }

    public ImmediateSurface(Surface r1, Size r2, int r3) {
        super(r2, r3);
        this.mSurface = r1;
    }
}
