package androidx.camera.lifecycle;

import android.os.Build;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class LifecycleCamera implements LifecycleObserver, Camera {
    private final CameraUseCaseAdapter mCameraUseCaseAdapter;
    private volatile boolean mIsActive;
    private final LifecycleOwner mLifecycleOwner;
    private final Object mLock;
    private boolean mReleased;
    private boolean mSuspended;

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, r1);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... r1) {
        return Camera.CC.$default$isUseCasesCombinationSupportedByFramework(this, r1);
    }

    @Override // androidx.camera.core.Camera
    public CameraControl getCameraControl() {
        return this.mCameraUseCaseAdapter.getCameraControl();
    }

    @Override // androidx.camera.core.Camera
    public CameraInfo getCameraInfo() {
        return this.mCameraUseCaseAdapter.getCameraInfo();
    }

    @Override // androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        return this.mCameraUseCaseAdapter.getExtendedConfig();
    }

    public LifecycleOwner getLifecycleOwner() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LifecycleOwner r1 = this.mLifecycleOwner;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraInfo getSecondaryCameraInfo() {
        return this.mCameraUseCaseAdapter.getSecondaryCameraInfo();
    }

    public List<UseCase> getUseCases() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<UseCase> r1 = Collections.unmodifiableList(this.mCameraUseCaseAdapter.getUseCases());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsActive;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void release() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mReleased = true;     // Catch: Throwable -> L8
        this.mIsActive = false;     // Catch: Throwable -> L8
        this.mLifecycleOwner.getLifecycle().removeObserver(this);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void suspend() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mSuspended == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        onStop(this.mLifecycleOwner);     // Catch: Throwable -> L11
        this.mSuspended = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void unbindAll() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CameraUseCaseAdapter r1 = this.mCameraUseCaseAdapter;     // Catch: Throwable -> L7
        r1.removeUseCases(r1.getUseCases());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsuspend() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mSuspended == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.mSuspended = false;     // Catch: Throwable -> L13
        if (this.mLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L11;
        onStart(this.mLifecycleOwner);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public CameraUseCaseAdapter getCameraUseCaseAdapter() {
        return this.mCameraUseCaseAdapter;
    }

    public void bind(Collection<UseCase> r3) throws CameraUseCaseAdapter.CameraException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCameraUseCaseAdapter.addUseCases(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isBound(UseCase r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r4 = this.mCameraUseCaseAdapter.getUseCases().contains(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner r3) {
        Object r4 = this.mLock;
        monitor-enter(r4);
        CameraUseCaseAdapter r0 = this.mCameraUseCaseAdapter;     // Catch: Throwable -> L7
        r0.removeUseCases(r0.getUseCases());     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mCameraUseCaseAdapter.setActiveResumingMode(false);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mCameraUseCaseAdapter.setActiveResumingMode(true);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner r2) {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mSuspended == false) goto L7;
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mReleased == true) goto L9;
        this.mCameraUseCaseAdapter.attachUseCases();     // Catch: Throwable -> L11
        this.mIsActive = true;     // Catch: Throwable -> L11
        goto L9
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner r2) {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mSuspended == false) goto L7;
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mReleased == true) goto L9;
        this.mCameraUseCaseAdapter.detachUseCases();     // Catch: Throwable -> L11
        this.mIsActive = false;     // Catch: Throwable -> L11
        goto L9
    }

    public void unbind(Collection<UseCase> r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r3);     // Catch: Throwable -> L7
        r1.retainAll(this.mCameraUseCaseAdapter.getUseCases());     // Catch: Throwable -> L7
        this.mCameraUseCaseAdapter.removeUseCases(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public LifecycleCamera(LifecycleOwner r3, CameraUseCaseAdapter r4) {
        this.mLock = new Object();
        this.mIsActive = false;
        this.mSuspended = false;
        this.mReleased = false;
        this.mLifecycleOwner = r3;
        this.mCameraUseCaseAdapter = r4;
        if (r3.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L5;
        r4.attachUseCases();
    L6:
        r3.getLifecycle().addObserver(this);
        return;
    L5:
        r4.detachUseCases();
        goto L6
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(boolean r2, UseCase... r3) {
        return this.mCameraUseCaseAdapter.isUseCasesCombinationSupported(r2, r3);
    }
}
