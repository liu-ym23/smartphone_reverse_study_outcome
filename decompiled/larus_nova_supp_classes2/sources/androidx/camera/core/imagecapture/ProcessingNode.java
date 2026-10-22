package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ProcessingNode implements Node<In, Void> {
    private static final String TAG = "ProcessingNode";
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;
    final Executor mBlockingExecutor;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation<Packet<ImageProxy>, Bitmap> mImage2Bitmap;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;
    final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;
    private final Quirks mQuirks;

    public static abstract class In {
        public In() {
        }

        public abstract Edge<InputPacket> getEdge();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract Edge<InputPacket> getPostviewEdge();

        public static In of(int r3, int r4) {
            return new AutoValue_ProcessingNode_In(new Edge(), new Edge(), r3, r4);
        }
    }

    public static abstract class InputPacket {
        public InputPacket() {
        }

        public abstract ImageProxy getImageProxy();

        public abstract ProcessingRequest getProcessingRequest();

        public static InputPacket of(ProcessingRequest r1, ImageProxy r2) {
            return new AutoValue_ProcessingNode_InputPacket(r1, r2);
        }
    }

    public static /* synthetic */ void a(ProcessingNode r0, InputPacket r1) {
        r0.lambda$transform$0(r1);
    }

    public static /* synthetic */ void b(ProcessingNode r0, InputPacket r1) {
        r0.lambda$transform$1(r1);
    }

    public static /* synthetic */ void c(ProcessingRequest r0, ImageProxy r1) {
        lambda$processInputPacket$4(r0, r1);
    }

    public static /* synthetic */ void d(ProcessingNode r0, InputPacket r1) {
        r0.lambda$transform$2(r1);
    }

    public static /* synthetic */ void e(ProcessingNode r0, InputPacket r1) {
        r0.lambda$transform$3(r1);
    }

    public static /* synthetic */ void f(ProcessingRequest r0, ImageCaptureException r1) {
        lambda$sendError$7(r0, r1);
    }

    public static /* synthetic */ void g(ProcessingRequest r0, Bitmap r1) {
        lambda$processPostviewInputPacket$6(r0, r1);
    }

    public static /* synthetic */ void h(ProcessingRequest r0, ImageCapture.OutputFileResults r1) {
        lambda$processInputPacket$5(r0, r1);
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    public ProcessingNode(Executor r3) {
        this(r3, null, DeviceQuirks.getAll());
    }

    private /* synthetic */ void lambda$transform$0(InputPacket r1) {
        processInputPacket(r1);
    }

    private /* synthetic */ void lambda$transform$1(final InputPacket r3) {
        if (r3.getProcessingRequest().isAborted() == false) goto L6;
        r3.getImageProxy().close();
        return;
    L6:
        this.mBlockingExecutor.execute(new p(this, r3));
    }

    private /* synthetic */ void lambda$transform$2(InputPacket r1) {
        processPostviewInputPacket(r1);
    }

    private /* synthetic */ void lambda$transform$3(final InputPacket r3) {
        if (r3.getProcessingRequest().isAborted() == false) goto L6;
        Logger.w(TAG, "The postview image is closed due to request aborted");
        r3.getImageProxy().close();
        return;
    L6:
        this.mBlockingExecutor.execute(new o(this, r3));
    }

    public void injectProcessingInput2Packet(Operation<InputPacket, Packet<ImageProxy>> r1) {
        this.mInput2Packet = r1;
    }

    public ImageProxy processInMemoryCapture(InputPacket r4) throws ImageCaptureException {
        ProcessingRequest r0 = r4.getProcessingRequest();
        Packet<ImageProxy> r5 = this.mInput2Packet.apply(r4);
        if (r5.getFormat() == 35) goto L9;
        if (this.mBitmapEffect != null) goto L9;
        if (this.mHasIncorrectJpegMetadataQuirk == true) goto L9;
    L15:
        return this.mJpegImage2Result.apply(r5);
    L9:
        if (this.mInputEdge.getOutputFormat() != 256) goto L15;
        Packet<byte[]> r6 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(r5, r0.getJpegQuality()));
        if (this.mBitmapEffect == null) goto L13;
        r6 = cropAndMaybeApplyEffect(r6, r0.getJpegQuality());
    L13:
        r5 = this.mJpegBytes2Image.apply(r6);
        goto L15
    }

    public void processInputPacket(InputPacket r5) {
        final ProcessingRequest r0 = r5.getProcessingRequest();
    L12:
        e = move-exception;
        sendError(r0, e);
        return;
    L10:
        e = move-exception;
        sendError(r0, new ImageCaptureException(0, "Processing failed due to low memory.", e));
        return;
    L8:
        e = move-exception;
        sendError(r0, new ImageCaptureException(0, "Processing failed.", e));
        return;
    L4:
        if (r5.getProcessingRequest().isInMemoryCapture() == false) goto L6;
        final ImageProxy r6 = processInMemoryCapture(r5);     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        CameraXExecutors.mainThreadExecutor().execute(new q(r0, r6));     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
    L15:
        return;
    L6:
        final ImageCapture.OutputFileResults r7 = processOnDiskCapture(r5);     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        CameraXExecutors.mainThreadExecutor().execute(new r(r0, r7));     // Catch: RuntimeException -> L8 OutOfMemoryError -> L10 ImageCaptureException -> L12
        goto L15
    }

    public ImageCapture.OutputFileResults processOnDiskCapture(InputPacket r5) throws ImageCaptureException {
        int r0 = this.mInputEdge.getOutputFormat();
        Preconditions.checkArgument(ImageUtil.isJpegFormats(r0), String.format("On-disk capture only support JPEG and JPEG/R output formats. Output format: %s", new Object[]{Integer.valueOf(r0)}));
        ProcessingRequest r1 = r5.getProcessingRequest();
        Packet<byte[]> r6 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(r5), r1.getJpegQuality()));
        if (r6.hasCropping() == false) goto L5;
    L6:
        r6 = cropAndMaybeApplyEffect(r6, r1.getJpegQuality());
    L7:
        Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> r2 = this.mJpegBytes2Disk;
        ImageCapture.OutputFileOptions r3 = r1.getOutputFileOptions();
        Objects.requireNonNull(r3);
        return r2.apply(JpegBytes2Disk.In.of(r6, r3));
    L5:
        if (this.mBitmapEffect == null) goto L7;
        goto L6
    }

    public void processPostviewInputPacket(InputPacket r5) {
        int r0 = this.mInputEdge.getOutputFormat();
        if (r0 != 35) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Preconditions.checkArgument(r1, String.format("Postview only support YUV and JPEG output formats. Output format: %s", new Object[]{Integer.valueOf(r0)}));
        final ProcessingRequest r2 = r5.getProcessingRequest();
        final Bitmap r3 = this.mImage2Bitmap.apply(this.mInput2Packet.apply(r5));     // Catch: Exception -> L12
        CameraXExecutors.mainThreadExecutor().execute(new k(r2, r3));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r5.getImageProxy().close();
        Logger.e(TAG, "process postview input packet failed.", e);
        return;
    L5:
        if (r0 == 256) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public Void transform2(In r3) {
        this.mInputEdge = r3;
        r3.getEdge().setListener(new l(this));
        r3.getPostviewEdge().setListener(new m(this));
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        this.mImage2Bitmap = new Image2Bitmap();
        if (r3.getInputFormat() != 35) goto L5;
    L8:
        this.mJpegBytes2Image = new JpegBytes2Image();
    L9:
        InternalImageProcessor r4 = this.mImageProcessor;
        if (r4 == null) goto L14;
        this.mBitmapEffect = new BitmapEffect(r4);
        return null;
    L14:
        return null;
    L5:
        if (this.mImageProcessor != null) goto L8;
        if (this.mHasIncorrectJpegMetadataQuirk == false) goto L9;
        goto L8
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ Void transform(In r1) {
        return transform2(r1);
    }

    public ProcessingNode(Executor r2, InternalImageProcessor r3) {
        this(r2, r3, DeviceQuirks.getAll());
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> r2, int r3) throws ImageCaptureException {
        Preconditions.checkState(ImageUtil.isJpegFormats(r2.getFormat()));
        Packet<Bitmap> r4 = this.mJpegBytes2CroppedBitmap.apply(r2);
        Operation<Packet<Bitmap>, Packet<Bitmap>> r0 = this.mBitmapEffect;
        if (r0 == null) goto L6;
        r4 = r0.apply(r4);
    L6:
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(r4, r3));
    }

    private static /* synthetic */ void lambda$processInputPacket$4(ProcessingRequest r0, ImageProxy r1) {
        r0.onFinalResult(r1);
    }

    private static /* synthetic */ void lambda$processInputPacket$5(ProcessingRequest r0, ImageCapture.OutputFileResults r1) {
        r0.onFinalResult(r1);
    }

    private static /* synthetic */ void lambda$processPostviewInputPacket$6(ProcessingRequest r0, Bitmap r1) {
        r0.onPostviewBitmapAvailable(r1);
    }

    private static /* synthetic */ void lambda$sendError$7(ProcessingRequest r0, ImageCaptureException r1) {
        r0.onProcessFailure(r1);
    }

    private static void sendError(final ProcessingRequest r2, final ImageCaptureException r3) {
        CameraXExecutors.mainThreadExecutor().execute(new n(r2, r3));
    }

    public ProcessingNode(Executor r2, Quirks r3) {
        this(r2, null, r3);
    }

    public ProcessingNode(Executor r2, InternalImageProcessor r3, Quirks r4) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(r2);
    L9:
        this.mImageProcessor = r3;
        this.mQuirks = r4;
        this.mHasIncorrectJpegMetadataQuirk = r4.contains(IncorrectJpegMetadataQuirk.class);
        return;
    L8:
        this.mBlockingExecutor = r2;
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
