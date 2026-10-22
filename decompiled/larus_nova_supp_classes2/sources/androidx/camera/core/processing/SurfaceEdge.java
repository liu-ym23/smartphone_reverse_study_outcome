package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceEdge {
    private final Rect mCropRect;
    private final int mFormat;
    private final boolean mHasCameraTransform;
    private boolean mHasConsumer;
    private boolean mIsClosed;
    private final boolean mMirroring;
    private final Set<Runnable> mOnInvalidatedListeners;
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private SettableSurface mSettableSurface;
    private final StreamSpec mStreamSpec;
    private int mTargetRotation;
    private final int mTargets;
    private final List<Consumer<SurfaceRequest.TransformationInfo>> mTransformationUpdatesListeners;

    public static class SettableSurface extends DeferrableSurface {
        CallbackToFutureAdapter.Completer<Surface> mCompleter;
        private SurfaceOutputImpl mConsumer;
        private DeferrableSurface mProvider;
        final ListenableFuture<Surface> mSurfaceFuture;

        public static /* synthetic */ void d(SettableSurface r0) {
            r0.lambda$close$1();
        }

        public static /* synthetic */ Object e(SettableSurface r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$new$0(r1);
        }

        private /* synthetic */ void lambda$close$1() {
            SurfaceOutputImpl r0 = this.mConsumer;
            if (r0 == null) goto L6;
            r0.requestClose();
        L6:
            if (this.mProvider != null) goto L9;
            this.mCompleter.setCancelled();
            return;
        }

        public boolean hasProvider() {
            if (this.mProvider == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean canSetProvider() {
            Threads.checkMainThread();
            if (this.mProvider == null) goto L5;
        L7:
            return false;
        L5:
            if (isClosed() == true) goto L7;
            return true;
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public void close() {
            super.close();
            Threads.runOnMain(new b0(this));
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public ListenableFuture<Surface> provideSurface() {
            return this.mSurfaceFuture;
        }

        private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r2) throws Exception {
            this.mCompleter = r2;
            return "SettableFuture hashCode: " + hashCode();
        }

        public void setConsumer(SurfaceOutputImpl r3) {
            if (this.mConsumer != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "Consumer can only be linked once.");
            this.mConsumer = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public SettableSurface(Size r1, int r2) {
            super(r1, r2);
            this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new z(this));
        }

        public boolean setProvider(final DeferrableSurface r7, Runnable r8) throws DeferrableSurface.SurfaceClosedException {
            Threads.checkMainThread();
            Preconditions.checkNotNull(r7);
            DeferrableSurface r0 = this.mProvider;
            if (r0 != r7) goto L6;
            return false;
        L6:
            if (r0 != null) goto L8;
            boolean r1 = true;
        L9:
            Preconditions.checkState(r1, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            Preconditions.checkArgument(getPrescribedSize().equals(r7.getPrescribedSize()), String.format("The provider's size(%s) must match the parent(%s)", new Object[]{getPrescribedSize(), r7.getPrescribedSize()}));
            if (getPrescribedStreamFormat() != r7.getPrescribedStreamFormat()) goto L12;
            boolean r2 = true;
        L13:
            Preconditions.checkArgument(r2, String.format("The provider's format(%s) must match the parent(%s)", new Object[]{Integer.valueOf(getPrescribedStreamFormat()), Integer.valueOf(r7.getPrescribedStreamFormat())}));
            Preconditions.checkState(!isClosed(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.mProvider = r7;
            Futures.propagate(r7.getSurface(), this.mCompleter);
            r7.incrementUseCount();
            getTerminationFuture().addListener(new a0(r7), CameraXExecutors.directExecutor());
            r7.getCloseFuture().addListener(r8, CameraXExecutors.mainThreadExecutor());
            return true;
        L12:
            r2 = false;
            goto L13
        L8:
            r1 = false;
            goto L9
        }
    }

    public static /* synthetic */ void a(SurfaceEdge r0, int r1, int r2) {
        r0.lambda$updateTransformation$3(r1, r2);
    }

    public static /* synthetic */ void b(SurfaceEdge r0) {
        r0.lambda$createSurfaceRequest$1();
    }

    public static /* synthetic */ void c(SurfaceEdge r0) {
        r0.lambda$createSurfaceRequest$0();
    }

    public static /* synthetic */ ListenableFuture d(SurfaceEdge r0, SettableSurface r1, int r2, SurfaceOutput.CameraInputInfo r3, SurfaceOutput.CameraInputInfo r4, Surface r5) {
        return r0.lambda$createSurfaceOutputFuture$2(r1, r2, r3, r4, r5);
    }

    private void checkAndSetHasConsumer() {
        Preconditions.checkState(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
    }

    private void checkNotClosed() {
        Preconditions.checkState(!this.mIsClosed, "Edge is already closed.");
    }

    private /* synthetic */ void lambda$createSurfaceRequest$0() {
        if (this.mIsClosed == true) goto L6;
        invalidate();
        return;
    }

    public boolean hasProvider() {
        return this.mSettableSurface.hasProvider();
    }

    private /* synthetic */ void lambda$createSurfaceRequest$1() {
        CameraXExecutors.mainThreadExecutor().execute(new s(this));
    }

    private void notifyTransformationInfoUpdate() {
        Threads.checkMainThread();
        SurfaceRequest.TransformationInfo r0 = SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, hasCameraTransform(), this.mSensorToBufferTransform, this.mMirroring);
        SurfaceRequest r1 = this.mProviderSurfaceRequest;
        if (r1 == null) goto L5;
        r1.updateTransformationInfo(r0);
    L5:
        Iterator<Consumer<SurfaceRequest.TransformationInfo>> r2 = this.mTransformationUpdatesListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().accept(r0);
        goto L7
    }

    public final void close() {
        Threads.checkMainThread();
        this.mSettableSurface.close();
        this.mIsClosed = true;
    }

    public final void disconnect() {
        Threads.checkMainThread();
        checkNotClosed();
        this.mSettableSurface.close();
    }

    public DeferrableSurface getDeferrableSurface() {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        return this.mSettableSurface;
    }

    public void invalidate() {
        Threads.checkMainThread();
        checkNotClosed();
        if (this.mSettableSurface.canSetProvider() == false) goto L5;
        return;
    L5:
        this.mHasConsumer = false;
        this.mSettableSurface.close();
        this.mSettableSurface = new SettableSurface(this.mStreamSpec.getResolution(), this.mFormat);
        Iterator<Runnable> r0 = this.mOnInvalidatedListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().run();
        goto L7
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public DeferrableSurface getDeferrableSurfaceForTesting() {
        return this.mSettableSurface;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public StreamSpec getStreamSpec() {
        return this.mStreamSpec;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean hasCameraTransform() {
        return this.mHasCameraTransform;
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    public boolean isMirroring() {
        return this.mMirroring;
    }

    public void addOnInvalidatedListener(Runnable r2) {
        Threads.checkMainThread();
        checkNotClosed();
        this.mOnInvalidatedListeners.add(r2);
    }

    public void addTransformationUpdateListener(Consumer<SurfaceRequest.TransformationInfo> r2) {
        Preconditions.checkNotNull(r2);
        this.mTransformationUpdatesListeners.add(r2);
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal r2) {
        return createSurfaceRequest(r2, true);
    }

    public void removeTransformationUpdateListener(Consumer<SurfaceRequest.TransformationInfo> r2) {
        Preconditions.checkNotNull(r2);
        this.mTransformationUpdatesListeners.remove(r2);
    }

    public void setProvider(DeferrableSurface r3) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        checkNotClosed();
        SettableSurface r0 = this.mSettableSurface;
        Objects.requireNonNull(r0);
        r0.setProvider(r3, new t(r0));
    }

    public void updateTransformation(int r2) {
        updateTransformation(r2, -1);
    }

    private /* synthetic */ void lambda$updateTransformation$3(int r3, int r4) {
        boolean r1 = true;
        if (this.mRotationDegrees == r3) goto L5;
        this.mRotationDegrees = r3;
        boolean r5 = true;
    L7:
        if (this.mTargetRotation == r4) goto L9;
        this.mTargetRotation = r4;
    L10:
        if (r1 == false) goto L13;
        notifyTransformationInfoUpdate();
        return;
    L13:
        return;
    L9:
        r1 = r5;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal r9, boolean r10) {
        Threads.checkMainThread();
        checkNotClosed();
        SurfaceRequest r7 = new SurfaceRequest(this.mStreamSpec.getResolution(), r9, r10, this.mStreamSpec.getDynamicRange(), this.mStreamSpec.getExpectedFrameRateRange(), new u(this));
        final DeferrableSurface r11 = r7.getDeferrableSurface();     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        SettableSurface r12 = this.mSettableSurface;     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        Objects.requireNonNull(r12);     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        if (r12.setProvider(r11, new t(r12)) == false) goto L6;
        ListenableFuture<Void> r13 = r12.getTerminationFuture();     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        Objects.requireNonNull(r11);     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
        r13.addListener(new v(r11), CameraXExecutors.directExecutor());     // Catch: RuntimeException -> L8 DeferrableSurface.SurfaceClosedException -> L11
    L6:
        this.mProviderSurfaceRequest = r7;
        notifyTransformationInfoUpdate();
        return r7;
    L11:
        e = move-exception;
        throw new AssertionError("Surface is somehow already closed", e);
    L8:
        e = move-exception;
        r7.willNotProvideSurface();
        throw e;
    }

    public void updateTransformation(final int r2, final int r3) {
        Threads.runOnMain(new y(this, r2, r3));
    }

    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(final int r9, final SurfaceOutput.CameraInputInfo r10, final SurfaceOutput.CameraInputInfo r11) {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        final SettableSurface r2 = this.mSettableSurface;
        return Futures.transformAsync(r2.getSurface(), new w(this, r2, r9, r10, r11), CameraXExecutors.mainThreadExecutor());
    }

    private /* synthetic */ ListenableFuture lambda$createSurfaceOutputFuture$2(final SettableSurface r10, int r11, SurfaceOutput.CameraInputInfo r12, SurfaceOutput.CameraInputInfo r13, Surface r14) throws Exception {
        Preconditions.checkNotNull(r14);
        r10.incrementUseCount();     // Catch: DeferrableSurface.SurfaceClosedException -> L6
        SurfaceOutputImpl r8 = new SurfaceOutputImpl(r14, getTargets(), r11, this.mStreamSpec.getResolution(), r12, r13, this.mSensorToBufferTransform);
        r8.getCloseFuture().addListener(new x(r10), CameraXExecutors.directExecutor());
        r10.setConsumer(r8);
        return Futures.immediateFuture(r8);
    L6:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    }

    public SurfaceEdge(int r3, int r4, StreamSpec r5, Matrix r6, boolean r7, Rect r8, int r9, int r10, boolean r11) {
        this.mHasConsumer = false;
        this.mOnInvalidatedListeners = new HashSet();
        this.mIsClosed = false;
        this.mTransformationUpdatesListeners = new ArrayList();
        this.mTargets = r3;
        this.mFormat = r4;
        this.mStreamSpec = r5;
        this.mSensorToBufferTransform = r6;
        this.mHasCameraTransform = r7;
        this.mCropRect = r8;
        this.mRotationDegrees = r9;
        this.mTargetRotation = r10;
        this.mMirroring = r11;
        this.mSettableSurface = new SettableSurface(r5.getResolution(), this.mFormat);
    }
}
