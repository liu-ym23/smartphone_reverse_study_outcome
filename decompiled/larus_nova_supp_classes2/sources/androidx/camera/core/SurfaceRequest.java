package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SurfaceRequest {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = null;
    private final CameraInternal mCamera;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRate;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final boolean mIsPrimary;
    private final Object mLock;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final ListenableFuture<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final ListenableFuture<Surface> mSurfaceFuture;
    private final CallbackToFutureAdapter.Completer<Void> mSurfaceRecreationCompleter;
    private TransformationInfo mTransformationInfo;
    private Executor mTransformationInfoExecutor;
    private TransformationInfoListener mTransformationInfoListener;

    public static final class RequestCancelledException extends RuntimeException {
        public RequestCancelledException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        public abstract int getResultCode();

        public abstract Surface getSurface();

        public Result() {
        }

        public static Result of(int r1, Surface r2) {
            return new AutoValue_SurfaceRequest_Result(r1, r2);
        }
    }

    public static abstract class TransformationInfo {
        public abstract Rect getCropRect();

        public abstract int getRotationDegrees();

        public abstract Matrix getSensorToBufferTransform();

        public abstract int getTargetRotation();

        public abstract boolean hasCameraTransform();

        public abstract boolean isMirroring();

        public TransformationInfo() {
        }

        public static TransformationInfo of(Rect r8, int r9, int r10, boolean r11, Matrix r12, boolean r13) {
            return new AutoValue_SurfaceRequest_TransformationInfo(r8, r9, r10, r11, r12, r13);
        }
    }

    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(TransformationInfo r1);
    }

    public static /* synthetic */ void a(Consumer r0, Surface r1) {
        lambda$provideSurface$4(r0, r1);
    }

    public static /* synthetic */ void b(TransformationInfoListener r0, TransformationInfo r1) {
        lambda$setTransformationInfoListener$8(r0, r1);
    }

    public static /* synthetic */ Object c(SurfaceRequest r0, AtomicReference r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$initialSurfaceRecreationCompleter$6(r1, r2);
    }

    public static /* synthetic */ void d(Consumer r0, Surface r1) {
        lambda$provideSurface$5(r0, r1);
    }

    public static /* synthetic */ void e(SurfaceRequest r0) {
        r0.lambda$new$3();
    }

    public static /* synthetic */ Object f(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) {
        return lambda$new$2(r0, r1, r2);
    }

    public static /* synthetic */ Object g(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) {
        return lambda$new$0(r0, r1, r2);
    }

    public static /* synthetic */ Object h(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) {
        return lambda$new$1(r0, r1, r2);
    }

    public static /* synthetic */ void i(TransformationInfoListener r0, TransformationInfo r1) {
        lambda$updateTransformationInfo$7(r0, r1);
    }

    static {
        FRAME_RATE_RANGE_UNSPECIFIED = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    private /* synthetic */ void lambda$new$3() {
        this.mSurfaceFuture.cancel(true);
    }

    public void clearTransformationInfoListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTransformationInfoListener = null;     // Catch: Throwable -> L8
        this.mTransformationInfoExecutor = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isServiced() {
        return this.mSurfaceFuture.isDone();
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public boolean invalidate() {
        willNotProvideSurface();
        return this.mSurfaceRecreationCompleter.set(null);
    }

    public CameraInternal getCamera() {
        return this.mCamera;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public DynamicRange getDynamicRange() {
        return this.mDynamicRange;
    }

    public Range<Integer> getExpectedFrameRate() {
        return this.mExpectedFrameRate;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    public boolean isPrimary() {
        return this.mIsPrimary;
    }

    public void updateTransformationInfo(final TransformationInfo r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTransformationInfo = r4;     // Catch: Throwable -> L10
        final TransformationInfoListener r1 = this.mTransformationInfoListener;     // Catch: Throwable -> L10
        Executor r2 = this.mTransformationInfoExecutor;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 == null) goto L15;
        if (r2 == null) goto L16;
        r2.execute(new o0(r1, r4));
        return;
    L16:
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private CallbackToFutureAdapter.Completer<Void> initialSurfaceRecreationCompleter(Executor r4, final Runnable r5) {
        final AtomicReference r0 = new AtomicReference(null);
        Futures.addCallback(CallbackToFutureAdapter.getFuture(new g0(this, r0)), new AnonymousClass5(this, r5), r4);
        return (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r0.get());
    }

    private /* synthetic */ Object lambda$initialSurfaceRecreationCompleter$6(AtomicReference r1, CallbackToFutureAdapter.Completer r2) throws Exception {
        r1.set(r2);
        return "SurfaceRequest-surface-recreation(" + hashCode() + ")";
    }

    private static /* synthetic */ void lambda$provideSurface$4(Consumer r1, Surface r2) {
        r1.accept(Result.of(3, r2));
    }

    private static /* synthetic */ void lambda$provideSurface$5(Consumer r1, Surface r2) {
        r1.accept(Result.of(4, r2));
    }

    private static /* synthetic */ void lambda$setTransformationInfoListener$8(TransformationInfoListener r0, TransformationInfo r1) {
        r0.onTransformationInfoUpdate(r1);
    }

    private static /* synthetic */ void lambda$updateTransformationInfo$7(TransformationInfoListener r0, TransformationInfo r1) {
        r0.onTransformationInfoUpdate(r1);
    }

    public void addRequestCancellationListener(Executor r2, Runnable r3) {
        this.mRequestCancellationCompleter.addCancellationListener(r3, r2);
    }

    public void setTransformationInfoListener(Executor r3, final TransformationInfoListener r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTransformationInfoListener = r4;     // Catch: Throwable -> L9
        this.mTransformationInfoExecutor = r3;     // Catch: Throwable -> L9
        final TransformationInfo r1 = this.mTransformationInfo;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r3.execute(new n0(r4, r1));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public SurfaceRequest(Size r7, CameraInternal r8, Runnable r9) {
        this(r7, r8, DynamicRange.SDR, FRAME_RATE_RANGE_UNSPECIFIED, r9);
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) throws Exception {
        r0.set(r2);
        return r1 + "-cancellation";
    }

    private static /* synthetic */ Object lambda$new$1(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) throws Exception {
        r0.set(r2);
        return r1 + "-status";
    }

    private static /* synthetic */ Object lambda$new$2(AtomicReference r0, String r1, CallbackToFutureAdapter.Completer r2) throws Exception {
        r0.set(r2);
        return r1 + "-Surface";
    }

    public void provideSurface(final Surface r3, Executor r4, final Consumer<Result> r5) {
        if (this.mSurfaceCompleter.set(r3) == false) goto L5;
    L11:
        Futures.addCallback(this.mSessionStatusFuture, new AnonymousClass4(this, r5, r3), r4);
        return;
    L5:
        if (this.mSurfaceFuture.isCancelled() == true) goto L11;
        Preconditions.checkState(this.mSurfaceFuture.isDone());
        this.mSurfaceFuture.get();     // Catch: Throwable -> L10
        r4.execute(new h0(r5, r3));     // Catch: Throwable -> L10
        return;
    L10:
        r4.execute(new i0(r5, r3));
    }

    public SurfaceRequest(Size r8, CameraInternal r9, DynamicRange r10, Range<Integer> r11, Runnable r12) {
        this(r8, r9, true, r10, r11, r12);
    }

    public SurfaceRequest(final Size r4, CameraInternal r5, boolean r6, DynamicRange r7, Range<Integer> r8, Runnable r9) {
        this.mLock = new Object();
        this.mResolution = r4;
        this.mCamera = r5;
        this.mIsPrimary = r6;
        this.mDynamicRange = r7;
        this.mExpectedFrameRate = r8;
        final String r10 = "SurfaceRequest[size: " + r4 + ", id: " + hashCode() + "]";
        final AtomicReference r11 = new AtomicReference(null);
        final ListenableFuture r12 = CallbackToFutureAdapter.getFuture(new j0(r11, r10));
        final CallbackToFutureAdapter.Completer<Void> r13 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r11.get());
        this.mRequestCancellationCompleter = r13;
        final AtomicReference r0 = new AtomicReference(null);
        ListenableFuture<Void> r1 = CallbackToFutureAdapter.getFuture(new k0(r0, r10));
        this.mSessionStatusFuture = r1;
        Futures.addCallback(r1, new AnonymousClass1(this, r13, r12), CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer r14 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r0.get());
        final AtomicReference r15 = new AtomicReference(null);
        ListenableFuture<Surface> r16 = CallbackToFutureAdapter.getFuture(new l0(r15, r10));
        this.mSurfaceFuture = r16;
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r15.get());
        final int r2 = 34;
        DeferrableSurface r17 = new AnonymousClass2(this, r4, r2);
        this.mInternalDeferrableSurface = r17;
        final ListenableFuture<Void> r18 = r17.getTerminationFuture();
        Futures.addCallback(r16, new AnonymousClass3(this, r18, r14, r10), CameraXExecutors.directExecutor());
        r18.addListener(new m0(this), CameraXExecutors.directExecutor());
        this.mSurfaceRecreationCompleter = initialSurfaceRecreationCompleter(CameraXExecutors.directExecutor(), r9);
    }
}
