package androidx.camera.lifecycle;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class LifecycleCameraRepository {
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners;
    CameraCoordinator mCameraCoordinator;
    private final Map<Key, LifecycleCamera> mCameraMap;
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap;
    private final Object mLock;

    public static abstract class Key {
        public Key() {
        }

        public abstract CameraUseCaseAdapter.CameraId getCameraId();

        public abstract LifecycleOwner getLifecycleOwner();

        public static Key create(LifecycleOwner r1, CameraUseCaseAdapter.CameraId r2) {
            return new AutoValue_LifecycleCameraRepository_Key(r1, r2);
        }
    }

    public static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner r2) {
            this.mLifecycleCameraRepository.unregisterLifecycle(r2);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner r2) {
            this.mLifecycleCameraRepository.setActive(r2);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner r2) {
            this.mLifecycleCameraRepository.setInactive(r2);
        }

        public LifecycleCameraRepositoryObserver(LifecycleOwner r1, LifecycleCameraRepository r2) {
            this.mLifecycleOwner = r1;
            this.mLifecycleCameraRepository = r2;
        }
    }

    public void clear() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator r1 = new HashSet(this.mLifecycleObserverMap.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        unregisterLifecycle(((LifecycleCameraRepositoryObserver) r1.next()).getLifecycleOwner());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public Collection<LifecycleCamera> getLifecycleCameras() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Collection<LifecycleCamera> r1 = Collections.unmodifiableCollection(this.mCameraMap.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void unbindAll() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Key> r1 = this.mCameraMap.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        Key r2 = r1.next();     // Catch: Throwable -> L10
        LifecycleCamera r3 = this.mCameraMap.get(r2);     // Catch: Throwable -> L10
        r3.unbindAll();     // Catch: Throwable -> L10
        setInactive(r3.getLifecycleOwner());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public LifecycleCameraRepository() {
        this.mLock = new Object();
        this.mCameraMap = new HashMap();
        this.mLifecycleObserverMap = new HashMap();
        this.mActiveLifecycleOwners = new ArrayDeque();
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<LifecycleCameraRepositoryObserver> r1 = this.mLifecycleObserverMap.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L11;
        LifecycleCameraRepositoryObserver r2 = r1.next();     // Catch: Throwable -> L14
        if (r5.equals(r2.getLifecycleOwner()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean hasUseCaseBound(LifecycleOwner r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleCameraRepositoryObserver r6 = getLifecycleCameraRepositoryObserver(r5);     // Catch: Throwable -> L18
        if (r6 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L8:
        Iterator<Key> r7 = this.mLifecycleObserverMap.get(r6).iterator();     // Catch: Throwable -> L18
    L10:
        if (r7.hasNext() == false) goto L16;
        Key r2 = r7.next();     // Catch: Throwable -> L18
        if (((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r2))).getUseCases().isEmpty() == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    private void registerCamera(LifecycleCamera r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleOwner r1 = r7.getLifecycleOwner();     // Catch: Throwable -> L13
        Key r2 = Key.create(r1, CameraUseCaseAdapter.generateCameraId((RestrictedCameraInfo) r7.getCameraInfo(), (RestrictedCameraInfo) r7.getSecondaryCameraInfo()));     // Catch: Throwable -> L13
        LifecycleCameraRepositoryObserver r3 = getLifecycleCameraRepositoryObserver(r1);     // Catch: Throwable -> L13
        if (r3 == null) goto L7;
        Set<Key> r4 = this.mLifecycleObserverMap.get(r3);     // Catch: Throwable -> L13
    L8:
        r4.add(r2);     // Catch: Throwable -> L13
        this.mCameraMap.put(r2, r7);     // Catch: Throwable -> L13
        if (r3 != null) goto L11;
        LifecycleCameraRepositoryObserver r8 = new LifecycleCameraRepositoryObserver(r1, this);     // Catch: Throwable -> L13
        this.mLifecycleObserverMap.put(r8, r4);     // Catch: Throwable -> L13
        r1.getLifecycle().addObserver(r8);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        r4 = new HashSet();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void suspendUseCases(LifecycleOwner r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleCameraRepositoryObserver r5 = getLifecycleCameraRepositoryObserver(r4);     // Catch: Throwable -> L14
        if (r5 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        Iterator<Key> r6 = this.mLifecycleObserverMap.get(r5).iterator();     // Catch: Throwable -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        Key r1 = r6.next();     // Catch: Throwable -> L14
        ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r1))).suspend();     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void unsuspendUseCases(LifecycleOwner r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleCameraRepositoryObserver r5 = getLifecycleCameraRepositoryObserver(r4);     // Catch: Throwable -> L12
        Iterator<Key> r6 = this.mLifecycleObserverMap.get(r5).iterator();     // Catch: Throwable -> L12
    L6:
        if (r6.hasNext() == false) goto L10;
        Key r1 = r6.next();     // Catch: Throwable -> L12
        LifecycleCamera r2 = this.mCameraMap.get(r1);     // Catch: Throwable -> L12
        if (((LifecycleCamera) Preconditions.checkNotNull(r2)).getUseCases().isEmpty() == true) goto L6;
        r2.unsuspend();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setActive(LifecycleOwner r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (hasUseCaseBound(r4) == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L9:
        if (this.mActiveLifecycleOwners.isEmpty() == false) goto L11;
        this.mActiveLifecycleOwners.push(r4);     // Catch: Throwable -> L21
    L18:
        unsuspendUseCases(r4);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L11:
        CameraCoordinator r1 = this.mCameraCoordinator;     // Catch: Throwable -> L21
        if (r1 != null) goto L14;
    L15:
        LifecycleOwner r2 = this.mActiveLifecycleOwners.peek();     // Catch: Throwable -> L21
        if (r4.equals(r2) == true) goto L18;
        suspendUseCases(r2);     // Catch: Throwable -> L21
        this.mActiveLifecycleOwners.remove(r4);     // Catch: Throwable -> L21
        this.mActiveLifecycleOwners.push(r4);     // Catch: Throwable -> L21
        goto L18
    L14:
        if (r1.getCameraOperatingMode() == 2) goto L18;
        goto L15
    }

    public void setInactive(LifecycleOwner r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveLifecycleOwners.remove(r3);     // Catch: Throwable -> L9
        suspendUseCases(r3);     // Catch: Throwable -> L9
        if (this.mActiveLifecycleOwners.isEmpty() == true) goto L7;
        unsuspendUseCases(this.mActiveLifecycleOwners.peek());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void unbind(Collection<UseCase> r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Key> r1 = this.mCameraMap.keySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L16;
        Key r2 = r1.next();     // Catch: Throwable -> L18
        LifecycleCamera r3 = this.mCameraMap.get(r2);     // Catch: Throwable -> L18
        if (r3.getUseCases().isEmpty() == true) goto L10;
        boolean r4 = true;
    L11:
        r3.unbind(r5);     // Catch: Throwable -> L18
        if (r4 == false) goto L6;
        if (r3.getUseCases().isEmpty() == false) goto L6;
        setInactive(r3.getLifecycleOwner());     // Catch: Throwable -> L18
        goto L6
    L10:
        r4 = false;
        goto L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void unregisterLifecycle(LifecycleOwner r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleCameraRepositoryObserver r1 = getLifecycleCameraRepositoryObserver(r5);     // Catch: Throwable -> L15
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        setInactive(r5);     // Catch: Throwable -> L15
        Iterator<Key> r6 = this.mLifecycleObserverMap.get(r1).iterator();     // Catch: Throwable -> L15
    L10:
        if (r6.hasNext() == false) goto L12;
        Key r2 = r6.next();     // Catch: Throwable -> L15
        this.mCameraMap.remove(r2);     // Catch: Throwable -> L15
        goto L10
    L12:
        this.mLifecycleObserverMap.remove(r1);     // Catch: Throwable -> L15
        r1.getLifecycleOwner().getLifecycle().removeObserver(r1);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public LifecycleCamera createLifecycleCamera(LifecycleOwner r4, CameraUseCaseAdapter r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Key r1 = Key.create(r4, r5.getCameraId());     // Catch: Throwable -> L18
        if (this.mCameraMap.get(r1) != null) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkArgument(r2, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");     // Catch: Throwable -> L18
        LifecycleCamera r3 = new LifecycleCamera(r4, r5);     // Catch: Throwable -> L18
        if (r5.getUseCases().isEmpty() == false) goto L12;
        r3.suspend();     // Catch: Throwable -> L18
    L12:
        if (r4.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r3;
    L15:
        registerCamera(r3);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r3;
    L7:
        r2 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public LifecycleCamera getLifecycleCamera(LifecycleOwner r3, CameraUseCaseAdapter.CameraId r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleCamera r5 = this.mCameraMap.get(Key.create(r3, r4));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public void bindToLifecycleCamera(LifecycleCamera r5, ViewPort r6, List<CameraEffect> r7, Collection<UseCase> r8, CameraCoordinator r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (r8.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkArgument(r1);     // Catch: Throwable -> L35
        this.mCameraCoordinator = r9;     // Catch: Throwable -> L35
        LifecycleOwner r10 = r5.getLifecycleOwner();     // Catch: Throwable -> L35
        LifecycleCameraRepositoryObserver r2 = getLifecycleCameraRepositoryObserver(r10);     // Catch: Throwable -> L35
        if (r2 != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L12:
        Set<Key> r3 = this.mLifecycleObserverMap.get(r2);     // Catch: Throwable -> L35
        CameraCoordinator r4 = this.mCameraCoordinator;     // Catch: Throwable -> L35
        if (r4 != null) goto L15;
    L16:
        Iterator<Key> r11 = r3.iterator();     // Catch: Throwable -> L35
    L18:
        if (r11.hasNext() == false) goto L39;
        Key r12 = r11.next();     // Catch: Throwable -> L35
        LifecycleCamera r13 = (LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r12));     // Catch: Throwable -> L35
        if (r13.equals(r5) == true) goto L18;
        if (r13.getUseCases().isEmpty() == true) goto L18;
        throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");     // Catch: Throwable -> L35
    L39:
        r5.getCameraUseCaseAdapter().setViewPort(r6);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
        r5.getCameraUseCaseAdapter().setEffects(r7);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
        r5.bind(r8);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
    L28:
        if (r10.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L30;
        setActive(r10);     // Catch: Throwable -> L35
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L32:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L35
    L15:
        if (r4.getCameraOperatingMode() == 2) goto L39;
    L7:
        r1 = false;
        goto L8
    }
}
