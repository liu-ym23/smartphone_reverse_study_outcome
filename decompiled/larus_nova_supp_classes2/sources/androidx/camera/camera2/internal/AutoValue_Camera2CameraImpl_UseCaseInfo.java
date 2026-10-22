package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Camera2CameraImpl_UseCaseInfo extends Camera2CameraImpl.UseCaseInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final SessionConfig sessionConfig;
    private final StreamSpec streamSpec;
    private final Size surfaceResolution;
    private final UseCaseConfig<?> useCaseConfig;
    private final String useCaseId;
    private final Class<?> useCaseType;

    public int hashCode() {
        int r0 = (((((((this.useCaseId.hashCode() ^ 1000003) * 1000003) ^ this.useCaseType.hashCode()) * 1000003) ^ this.sessionConfig.hashCode()) * 1000003) ^ this.useCaseConfig.hashCode()) * 1000003;
        Size r2 = this.surfaceResolution;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 ^ r4) * 1000003;
        StreamSpec r5 = this.streamSpec;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r1 ^ r6) * 1000003;
        List<UseCaseConfigFactory.CaptureType> r8 = this.captureTypes;
        if (r8 == null) goto L15;
        r3 = r8.hashCode();
    L15:
        return r7 ^ r3;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.useCaseId + ", useCaseType=" + this.useCaseType + ", sessionConfig=" + this.sessionConfig + ", useCaseConfig=" + this.useCaseConfig + ", surfaceResolution=" + this.surfaceResolution + ", streamSpec=" + this.streamSpec + ", captureTypes=" + this.captureTypes + "}";
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public StreamSpec getStreamSpec() {
        return this.streamSpec;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public Size getSurfaceResolution() {
        return this.surfaceResolution;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public UseCaseConfig<?> getUseCaseConfig() {
        return this.useCaseConfig;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public String getUseCaseId() {
        return this.useCaseId;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public Class<?> getUseCaseType() {
        return this.useCaseType;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Camera2CameraImpl.UseCaseInfo) == false) goto L39;
        Camera2CameraImpl.UseCaseInfo r6 = (Camera2CameraImpl.UseCaseInfo) r5;
        if (this.useCaseId.equals(r6.getUseCaseId()) == true) goto L10;
    L37:
        return false;
    L10:
        if (this.useCaseType.equals(r6.getUseCaseType()) == false) goto L37;
        if (this.sessionConfig.equals(r6.getSessionConfig()) == false) goto L37;
        if (this.useCaseConfig.equals(r6.getUseCaseConfig()) == false) goto L37;
        Size r1 = this.surfaceResolution;
        if (r1 != null) goto L21;
        if (r6.getSurfaceResolution() != null) goto L37;
    L22:
        StreamSpec r2 = this.streamSpec;
        if (r2 != null) goto L28;
        if (r6.getStreamSpec() != null) goto L37;
    L29:
        List<UseCaseConfigFactory.CaptureType> r3 = this.captureTypes;
        if (r3 != null) goto L35;
        if (r6.getCaptureTypes() != null) goto L37;
        return true;
    L35:
        if (r3.equals(r6.getCaptureTypes()) == false) goto L37;
        return true;
    L28:
        if (r2.equals(r6.getStreamSpec()) == false) goto L37;
    L21:
        if (r1.equals(r6.getSurfaceResolution()) == false) goto L37;
    L39:
        return false;
    }

    public AutoValue_Camera2CameraImpl_UseCaseInfo(String r1, Class<?> r2, SessionConfig r3, UseCaseConfig<?> r4, Size r5, StreamSpec r6, List<UseCaseConfigFactory.CaptureType> r7) {
        if (r1 == null) goto L19;
        this.useCaseId = r1;
        if (r2 == null) goto L17;
        this.useCaseType = r2;
        if (r3 == null) goto L15;
        this.sessionConfig = r3;
        if (r4 == null) goto L13;
        this.useCaseConfig = r4;
        this.surfaceResolution = r5;
        this.streamSpec = r6;
        this.captureTypes = r7;
        return;
    L13:
        throw new NullPointerException("Null useCaseConfig");
    L15:
        throw new NullPointerException("Null sessionConfig");
    L17:
        throw new NullPointerException("Null useCaseType");
    L19:
        throw new NullPointerException("Null useCaseId");
    }
}
