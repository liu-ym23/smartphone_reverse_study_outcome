package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DeferrableSurfaces {
    public static /* synthetic */ void a(ListenableFuture r0) {
        lambda$surfaceListWithTimeout$0(r0);
    }

    public static /* synthetic */ Object b(ListenableFuture r0, Executor r1, boolean r2, Collection r3, CallbackToFutureAdapter.Completer r4) {
        return lambda$surfaceListWithTimeout$1(r0, r1, r2, r3, r4);
    }

    private DeferrableSurfaces() {
    }

    public static void decrementAll(List<DeferrableSurface> r1) {
        Iterator<DeferrableSurface> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().decrementUseCount();
        goto L4
    }

    public static void incrementAll(List<DeferrableSurface> r3) throws DeferrableSurface.SurfaceClosedException {
        if (r3.isEmpty() == true) goto L13;
        int r0 = 0;
    L14:
        ((DeferrableSurface) ListProtector.get(r3, r0)).incrementUseCount();     // Catch: DeferrableSurface.SurfaceClosedException -> L8
        r0 = r0 + 1;     // Catch: DeferrableSurface.SurfaceClosedException -> L8
        if (r0 < r3.size()) goto L14;
        return;
    L8:
        e = move-exception;
        int r1 = r0 - 1;
    L10:
        if (r1 < 0) goto L12;
        ((DeferrableSurface) ListProtector.get(r3, r1)).decrementUseCount();
        r1 = r1 - 1;
        goto L10
    L12:
        throw e;
    }

    private static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture r1) {
        r1.cancel(true);
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> r0) {
        incrementAll(r0);     // Catch: DeferrableSurface.SurfaceClosedException -> L5
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ Object lambda$surfaceListWithTimeout$1(final ListenableFuture r1, Executor r2, final boolean r3, Collection r4, final CallbackToFutureAdapter.Completer r5) throws Exception {
        r5.addCancellationListener(new n(r1), r2);
        Futures.addCallback(r1, new AnonymousClass1(r3, r5), r2);
        return "surfaceList[" + r4 + "]";
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(final Collection<DeferrableSurface> r3, final boolean r4, long r5, final Executor r7, ScheduledExecutorService r8) {
        ArrayList r0 = new ArrayList();
        Iterator<DeferrableSurface> r1 = r3.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(Futures.nonCancellationPropagating(r1.next().getSurface()));
        goto L4
    L6:
        final ListenableFuture r6 = Futures.makeTimeoutFuture(r5, r8, Futures.successfulAsList(r0));
        return CallbackToFutureAdapter.getFuture(new m(r6, r7, r4, r3));
    }
}
