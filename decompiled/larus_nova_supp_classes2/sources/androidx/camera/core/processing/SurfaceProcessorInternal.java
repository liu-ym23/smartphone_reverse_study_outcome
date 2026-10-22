package androidx.camera.core.processing;

import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface SurfaceProcessorInternal extends SurfaceProcessor {

    /* JADX INFO: renamed from: androidx.camera.core.processing.SurfaceProcessorInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ListenableFuture $default$snapshot(SurfaceProcessorInternal r0, int r1, int r2) {
            return Futures.immediateFuture(null);
        }
    }

    void release();

    ListenableFuture<Void> snapshot(int r1, int r2);
}
