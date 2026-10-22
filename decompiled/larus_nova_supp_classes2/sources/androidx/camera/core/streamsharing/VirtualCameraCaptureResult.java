package androidx.camera.core.streamsharing;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VirtualCameraCaptureResult implements CameraCaptureResult {
    private static final long INVALID_TIMESTAMP = -1;
    private final CameraCaptureResult mBaseCameraCaptureResult;
    private final TagBundle mTagBundle;
    private final long mTimestamp;

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public final /* synthetic */ CaptureResult getCaptureResult() {
        return CameraCaptureResult.CC.$default$getCaptureResult(this);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public final /* synthetic */ void populateExifData(ExifData.Builder r1) {
        CameraCaptureResult.CC.$default$populateExifData(this, r1);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeMode getAeMode() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAeMode();
    L6:
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeState getAeState() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAeState();
    L6:
        return CameraCaptureMetaData.AeState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfMode getAfMode() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAfMode();
    L6:
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfState getAfState() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAfState();
    L6:
        return CameraCaptureMetaData.AfState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbMode getAwbMode() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAwbMode();
    L6:
        return CameraCaptureMetaData.AwbMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbState getAwbState() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getAwbState();
    L6:
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.FlashState getFlashState() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 == null) goto L6;
        return r0.getFlashState();
    L6:
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        CameraCaptureResult r0 = this.mBaseCameraCaptureResult;
        if (r0 != null) goto L5;
        long r1 = this.mTimestamp;
        if (r1 == (-1)) goto L10;
        return r1;
    L10:
        throw new IllegalStateException("No timestamp is available.");
    L5:
        return r0.getTimestamp();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public VirtualCameraCaptureResult(TagBundle r3, CameraCaptureResult r4) {
        this(r4, r3, -1);
    }

    public VirtualCameraCaptureResult(TagBundle r2, long r3) {
        this(null, r2, r3);
    }

    private VirtualCameraCaptureResult(CameraCaptureResult r1, TagBundle r2, long r3) {
        this.mBaseCameraCaptureResult = r1;
        this.mTagBundle = r2;
        this.mTimestamp = r3;
    }
}
