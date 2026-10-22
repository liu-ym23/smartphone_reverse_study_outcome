package com.larus.platform.model.camera.ve;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000102H\u0096\u0002J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e¨\u00067"}, d2 = {"Lcom/larus/platform/model/camera/ve/VeCameraInputParam;", "Ljava/io/Serializable;", "<init>", "()V", "flashMode", "", "getFlashMode", "()Ljava/lang/String;", "setFlashMode", "(Ljava/lang/String;)V", "isFrontCamera", "", "()Z", "setFrontCamera", "(Z)V", "fpsRange", "", "getFpsRange", "()[I", "setFpsRange", "([I)V", "use1080p", "getUse1080p", "setUse1080p", "asyncDestroyRecorder", "getAsyncDestroyRecorder", "setAsyncDestroyRecorder", "firstStopPreview", "getFirstStopPreview", "setFirstStopPreview", "asyncStopPreview", "getAsyncStopPreview", "setAsyncStopPreview", "asyncCloseCapture", "getAsyncCloseCapture", "setAsyncCloseCapture", "previewRatio", "Lcom/larus/platform/model/camera/ve/Ratio;", "getPreviewRatio", "()Lcom/larus/platform/model/camera/ve/Ratio;", "setPreviewRatio", "(Lcom/larus/platform/model/camera/ve/Ratio;)V", "enableRecorder", "getEnableRecorder", "setEnableRecorder", "enableZoomAnimation", "getEnableZoomAnimation", "setEnableZoomAnimation", "equals", "other", "", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VeCameraInputParam implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private boolean asyncCloseCapture;
    private boolean asyncDestroyRecorder;
    private boolean asyncStopPreview;
    private boolean enableRecorder;
    private boolean enableZoomAnimation;
    private boolean firstStopPreview;
    private String flashMode;
    private int[] fpsRange;
    private boolean isFrontCamera;
    private Ratio previewRatio;
    private boolean use1080p;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "flashMode=" + this.flashMode + ",isFrontCamera=" + this.isFrontCamera + ",use1080p=" + this.use1080p + ",asyncDestroyRecorder=" + this.asyncDestroyRecorder + ",firstStopPreview=" + this.firstStopPreview + ",asyncStopPreview=" + this.asyncStopPreview + ",asyncCloseCapture=" + this.asyncCloseCapture;
    }

    public VeCameraInputParam() {
        this.flashMode = "FLASH_MODE_AUTO";
        this.fpsRange = new int[]{7, 30};
        this.previewRatio = Ratio.RATIO_3_4;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final boolean getAsyncCloseCapture() {
        return this.asyncCloseCapture;
    }

    public final boolean getAsyncDestroyRecorder() {
        return this.asyncDestroyRecorder;
    }

    public final boolean getAsyncStopPreview() {
        return this.asyncStopPreview;
    }

    public final boolean getEnableRecorder() {
        return this.enableRecorder;
    }

    public final boolean getEnableZoomAnimation() {
        return this.enableZoomAnimation;
    }

    public final boolean getFirstStopPreview() {
        return this.firstStopPreview;
    }

    public final String getFlashMode() {
        return this.flashMode;
    }

    public final int[] getFpsRange() {
        return this.fpsRange;
    }

    public final Ratio getPreviewRatio() {
        return this.previewRatio;
    }

    public final boolean getUse1080p() {
        return this.use1080p;
    }

    public final boolean isFrontCamera() {
        return this.isFrontCamera;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof VeCameraInputParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((VeCameraInputParam) r100).toString());
    }

    public final void setAsyncCloseCapture(boolean r100) {
        this.asyncCloseCapture = r100;
    }

    public final void setAsyncDestroyRecorder(boolean r100) {
        this.asyncDestroyRecorder = r100;
    }

    public final void setAsyncStopPreview(boolean r100) {
        this.asyncStopPreview = r100;
    }

    public final void setEnableRecorder(boolean r100) {
        this.enableRecorder = r100;
    }

    public final void setEnableZoomAnimation(boolean r100) {
        this.enableZoomAnimation = r100;
    }

    public final void setFirstStopPreview(boolean r100) {
        this.firstStopPreview = r100;
    }

    public final void setFlashMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flashMode = r100;
    }

    public final void setFpsRange(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fpsRange = r100;
    }

    public final void setFrontCamera(boolean r100) {
        this.isFrontCamera = r100;
    }

    public final void setPreviewRatio(Ratio r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previewRatio = r100;
    }

    public final void setUse1080p(boolean r100) {
        this.use1080p = r100;
    }
}
