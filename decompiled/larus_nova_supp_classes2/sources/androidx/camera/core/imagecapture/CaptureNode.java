package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CaptureNode implements Node<In, ProcessingNode.In> {
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    ProcessingRequest mCurrentRequest;
    private In mInputEdge;
    private NoMetadataImageReader mNoMetadataImageReader;
    private ProcessingNode.In mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderForPostview;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    /* JADX INFO: renamed from: androidx.camera.core.imagecapture.CaptureNode$1, reason: invalid class name */
    public class AnonymousClass1 extends CameraCaptureCallback {
        final /* synthetic */ CaptureNode this$0;

        public static /* synthetic */ void a(AnonymousClass1 r0) {
            r0.lambda$onCaptureStarted$0();
        }

        public static /* synthetic */ void b(AnonymousClass1 r0, int r1) {
            r0.lambda$onCaptureProcessProgressed$1(r1);
        }

        private /* synthetic */ void lambda$onCaptureStarted$0() {
            ProcessingRequest r0 = this.this$0.mCurrentRequest;
            if (r0 == null) goto L6;
            r0.onCaptureStarted();
            return;
        }

        public AnonymousClass1(CaptureNode r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onCaptureProcessProgressed$1(int r2) {
            ProcessingRequest r0 = this.this$0.mCurrentRequest;
            if (r0 == null) goto L6;
            r0.onCaptureProcessProgressed(r2);
            return;
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r2) {
            CameraXExecutors.mainThreadExecutor().execute(new h(this));
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureProcessProgressed(int r2, final int r3) {
            CameraXExecutors.mainThreadExecutor().execute(new i(this, r3));
        }
    }

    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback;
        private DeferrableSurface mPostviewSurface;
        private DeferrableSurface mSurface;

        public abstract Edge<TakePictureManager.CaptureError> getErrorEdge();

        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract int getPostviewImageFormat();

        public abstract Size getPostviewSize();

        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        public abstract boolean isVirtualCamera();

        public DeferrableSurface getSurface() {
            DeferrableSurface r0 = this.mSurface;
            Objects.requireNonNull(r0);
            return r0;
        }

        public In() {
            this.mCameraCaptureCallback = new AnonymousClass1(this);
            this.mPostviewSurface = null;
        }

        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        public DeferrableSurface getPostviewSurface() {
            return this.mPostviewSurface;
        }

        public void setCameraCaptureCallback(CameraCaptureCallback r1) {
            this.mCameraCaptureCallback = r1;
        }

        public void setSurface(Surface r4) {
            if (this.mSurface != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "The surface is already set.");
            this.mSurface = new ImmediateSurface(r4, getSize(), getInputFormat());
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void setPostviewSurface(Surface r2, Size r3, int r4) {
            this.mPostviewSurface = new ImmediateSurface(r2, r3, r4);
        }

        public static In of(Size r11, int r12, int r13, boolean r14, ImageReaderProxyProvider r15) {
            return new AutoValue_CaptureNode_In(r11, r12, r13, r14, r15, null, 35, new Edge(), new Edge());
        }

        public static In of(Size r11, int r12, int r13, boolean r14, ImageReaderProxyProvider r15, Size r16, int r17) {
            return new AutoValue_CaptureNode_In(r11, r12, r13, r14, r15, r16, r17, new Edge(), new Edge());
        }
    }

    public static /* synthetic */ void a(CaptureNode r0, ImageReaderProxy r1) {
        r0.lambda$transform$1(r1);
    }

    public static /* synthetic */ void b(CaptureNode r0, ProcessingRequest r1) {
        r0.lambda$transform$0(r1);
    }

    public static /* synthetic */ void c(SafeCloseImageReaderProxy r0) {
        lambda$releaseInputResources$3(r0);
    }

    public static /* synthetic */ void d(SafeCloseImageReaderProxy r0) {
        lambda$releaseInputResources$4(r0);
    }

    public static /* synthetic */ void e(CaptureNode r0, ImageReaderProxy r1) {
        r0.lambda$transform$2(r1);
    }

    public In getInputEdge() {
        In r0 = this.mInputEdge;
        Objects.requireNonNull(r0);
        return r0;
    }

    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy r0 = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(r0);
        return r0;
    }

    public CaptureNode() {
        this.mCurrentRequest = null;
        this.mNoMetadataImageReader = null;
    }

    public int getCapacity() {
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        Threads.checkMainThread();
        In r0 = this.mInputEdge;
        Objects.requireNonNull(r0);
        SafeCloseImageReaderProxy r1 = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(r1);
        releaseInputResources(r0, r1, this.mSafeCloseImageReaderForPostview);
    }

    public static /* synthetic */ NoMetadataImageReader access$000(CaptureNode r0) {
        return r0.mNoMetadataImageReader;
    }

    private static /* synthetic */ void lambda$releaseInputResources$3(SafeCloseImageReaderProxy r0) {
        r0.safeClose();
    }

    private static /* synthetic */ void lambda$releaseInputResources$4(SafeCloseImageReaderProxy r0) {
        if (r0 == null) goto L5;
        r0.safeClose();
        return;
    }

    private /* synthetic */ void lambda$transform$0(ProcessingRequest r2) {
        onRequestAvailable(r2);
        this.mNoMetadataImageReader.acceptProcessingRequest(r2);
    }

    private /* synthetic */ void lambda$transform$1(ImageReaderProxy r5) {
        ImageProxy r6 = r5.acquireLatestImage();     // Catch: IllegalStateException -> L10
        if (r6 == null) goto L6;
        onImageProxyAvailable(r6);     // Catch: IllegalStateException -> L10
    L15:
        return;
    L6:
        ProcessingRequest r7 = this.mCurrentRequest;     // Catch: IllegalStateException -> L10
        if (r7 == null) goto L15;
        sendCaptureError(TakePictureManager.CaptureError.of(r7.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", null)));     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        ProcessingRequest r2 = this.mCurrentRequest;
        if (r2 == null) goto L19;
        sendCaptureError(TakePictureManager.CaptureError.of(r2.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
        return;
    }

    private /* synthetic */ void lambda$transform$2(ImageReaderProxy r3) {
        ImageProxy r4 = r3.acquireLatestImage();     // Catch: IllegalStateException -> L6
        if (r4 == null) goto L11;
        propagatePostviewImage(r4);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire latest image of postview", e);
    }

    private void matchAndPropagateImage(ImageProxy r3) {
        Threads.checkMainThread();
        ProcessingNode.In r0 = this.mOutputEdge;
        Objects.requireNonNull(r0);
        r0.getEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, r3));
        ProcessingRequest r4 = this.mCurrentRequest;
        this.mCurrentRequest = null;
        r4.onImageCaptured();
    }

    private void propagatePostviewImage(ImageProxy r3) {
        if (this.mCurrentRequest != null) goto L6;
        Logger.w(TAG, "Postview image is closed due to request completed or aborted");
        r3.close();
        return;
    L6:
        ProcessingNode.In r0 = this.mOutputEdge;
        Objects.requireNonNull(r0);
        r0.getPostviewEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, r3));
    }

    public void onImageProxyAvailable(ImageProxy r4) {
        Threads.checkMainThread();
        if (this.mCurrentRequest != null) goto L6;
        Logger.w(TAG, "Discarding ImageProxy which was inadvertently acquired: " + r4);
        r4.close();
        return;
    L6:
        if (((Integer) r4.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey())) != null) goto L9;
        Logger.w(TAG, "Discarding ImageProxy which was acquired for aborted request");
        r4.close();
        return;
    L9:
        matchAndPropagateImage(r4);
    }

    public void onRequestAvailable(final ProcessingRequest r5) {
        Threads.checkMainThread();
        boolean r1 = false;
        if (r5.getStageIds().size() != 1) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "only one capture stage is supported.");
        if (getCapacity() <= 0) goto L9;
        r1 = true;
    L9:
        Preconditions.checkState(r1, "Too many acquire images. Close image to be able to process next.");
        this.mCurrentRequest = r5;
        Futures.addCallback(r5.getCaptureFuture(), new AnonymousClass2(this, r5), CameraXExecutors.directExecutor());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void sendCaptureError(TakePictureManager.CaptureError r3) {
        Threads.checkMainThread();
        ProcessingRequest r0 = this.mCurrentRequest;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getRequestId() != r3.getRequestId()) goto L9;
        this.mCurrentRequest.onCaptureFailure(r3.getImageCaptureException());
        return;
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener r3) {
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public ProcessingNode.In transform2(In r9) {
        if (this.mInputEdge == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkState(r0, "CaptureNode does not support recreation yet.");
        this.mInputEdge = r9;
        Size r1 = r9.getSize();
        int r3 = r9.getInputFormat();
        boolean r4 = !r9.isVirtualCamera();
        CameraCaptureCallback r5 = new AnonymousClass1(this);
        if (r4 == true) goto L11;
    L13:
        NoMetadataImageReader r6 = new NoMetadataImageReader(createImageReaderProxy(r9.getImageReaderProxyProvider(), r1.getWidth(), r1.getHeight(), r3));
        this.mNoMetadataImageReader = r6;
        Consumer<ProcessingRequest> r2 = new b(this);
        ImageReaderProxy r7 = r6;
    L14:
        r9.setCameraCaptureCallback(r5);
        Surface r8 = r7.getSurface();
        Objects.requireNonNull(r8);
        r9.setSurface(r8);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(r7);
        r7.setOnImageAvailableListener(new c(this), CameraXExecutors.mainThreadExecutor());
        if (r9.getPostviewSize() == null) goto L17;
        ImageReaderProxy r10 = createImageReaderProxy(r9.getImageReaderProxyProvider(), r9.getPostviewSize().getWidth(), r9.getPostviewSize().getHeight(), r9.getPostviewImageFormat());
        r10.setOnImageAvailableListener(new d(this), CameraXExecutors.mainThreadExecutor());
        this.mSafeCloseImageReaderForPostview = new SafeCloseImageReaderProxy(r10);
        r9.setPostviewSurface(r10.getSurface(), r9.getPostviewSize(), r9.getPostviewImageFormat());
    L17:
        r9.getRequestEdge().setListener(r2);
        r9.getErrorEdge().setListener(new e(this));
        ProcessingNode.In r11 = ProcessingNode.In.of(r9.getInputFormat(), r9.getOutputFormat());
        this.mOutputEdge = r11;
        return r11;
    L11:
        if (r9.getImageReaderProxyProvider() != null) goto L13;
        MetadataImageReader r12 = new MetadataImageReader(r1.getWidth(), r1.getHeight(), r3, 4);
        r5 = CameraCaptureCallbacks.createComboCallback(new CameraCaptureCallback[]{r5, r12.getCameraCaptureCallback()});
        r2 = new a(this);
        r7 = r12;
        goto L14
    L5:
        if (this.mSafeCloseImageReaderProxy != null) goto L7;
        r0 = true;
        goto L8
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ ProcessingNode.In transform(In r1) {
        return transform2(r1);
    }

    private void releaseInputResources(In r3, final SafeCloseImageReaderProxy r4, final SafeCloseImageReaderProxy r5) {
        r3.getSurface().close();
        r3.getSurface().getTerminationFuture().addListener(new f(r4), CameraXExecutors.mainThreadExecutor());
        if (r3.getPostviewSurface() == null) goto L6;
        r3.getPostviewSurface().close();
        r3.getPostviewSurface().getTerminationFuture().addListener(new g(r5), CameraXExecutors.mainThreadExecutor());
        return;
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider r7, int r8, int r9, int r10) {
        if (r7 == null) goto L6;
        return r7.newInstance(r8, r9, r10, 4, 0);
    L6:
        return ImageReaderProxys.createIsolatedReader(r8, r9, r10, 4);
    }
}
