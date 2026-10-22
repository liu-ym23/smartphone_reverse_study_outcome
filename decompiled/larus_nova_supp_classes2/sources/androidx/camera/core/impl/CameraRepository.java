package androidx.camera.core.impl;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    private final Map<String, CameraInternal> mCameras;
    private final Object mCamerasLock;
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    private ListenableFuture<Void> mDeinitFuture;
    private final Set<CameraInternal> mReleasingCameras;

    public static /* synthetic */ Object a(CameraRepository r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$deinit$0(r1);
    }

    public static /* synthetic */ void b(CameraRepository r0, CameraInternal r1) {
        r0.lambda$deinit$1(r1);
    }

    public ListenableFuture<Void> deinit() {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameras.isEmpty() == false) goto L11;
        ListenableFuture<Void> r1 = this.mDeinitFuture;     // Catch: Throwable -> L21
        if (r1 != null) goto L9;
        r1 = Futures.immediateFuture(null);     // Catch: Throwable -> L21
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r1;
    L11:
        ListenableFuture<Void> r2 = this.mDeinitFuture;     // Catch: Throwable -> L21
        if (r2 != null) goto L14;
        r2 = CallbackToFutureAdapter.getFuture(new e(this));     // Catch: Throwable -> L21
        this.mDeinitFuture = r2;     // Catch: Throwable -> L21
    L14:
        this.mReleasingCameras.addAll(this.mCameras.values());     // Catch: Throwable -> L21
        Iterator<CameraInternal> r3 = this.mCameras.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r3.hasNext() == false) goto L18;
        final CameraInternal r4 = r3.next();     // Catch: Throwable -> L21
        r4.release().addListener(new f(this, r4), CameraXExecutors.directExecutor());     // Catch: Throwable -> L21
        goto L16
    L18:
        this.mCameras.clear();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r2;
    }

    public Set<String> getCameraIds() {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
        LinkedHashSet r1 = new LinkedHashSet(this.mCameras.keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public LinkedHashSet<CameraInternal> getCameras() {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
        LinkedHashSet<CameraInternal> r1 = new LinkedHashSet(this.mCameras.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraRepository() {
        this.mCamerasLock = new Object();
        this.mCameras = new LinkedHashMap();
        this.mReleasingCameras = new HashSet();
    }

    private /* synthetic */ Object lambda$deinit$0(CallbackToFutureAdapter.Completer r2) throws Exception {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
        this.mDeinitCompleter = r2;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return "CameraRepository-deinit";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$deinit$1(CameraInternal r3) {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
        this.mReleasingCameras.remove(r3);     // Catch: Throwable -> L9
        if (this.mReleasingCameras.isEmpty() == false) goto L7;
        Preconditions.checkNotNull(this.mDeinitCompleter);     // Catch: Throwable -> L9
        this.mDeinitCompleter.set(null);     // Catch: Throwable -> L9
        this.mDeinitCompleter = null;     // Catch: Throwable -> L9
        this.mDeinitFuture = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public CameraInternal getCamera(String r5) {
        Object r1 = this.mCamerasLock;
        monitor-enter(r1);
        CameraInternal r2 = this.mCameras.get(r5);     // Catch: Throwable -> L10
        if (r2 == null) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    L9:
        throw new IllegalArgumentException("Invalid camera: " + r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void init(CameraFactory r7) throws InitializationException {
        Object r0 = this.mCamerasLock;
        monitor-enter(r0);
        Iterator<String> r1 = r7.getAvailableCameraIds().iterator();     // Catch: Throwable -> L11 CameraUnavailableException -> L13
    L6:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();     // Catch: Throwable -> L11 CameraUnavailableException -> L13
        Logger.d(TAG, "Added camera: " + r2);     // Catch: Throwable -> L11 CameraUnavailableException -> L13
        this.mCameras.put(r2, r7.getCamera(r2));     // Catch: Throwable -> L11 CameraUnavailableException -> L13
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        e = move-exception;
        throw new InitializationException(e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
