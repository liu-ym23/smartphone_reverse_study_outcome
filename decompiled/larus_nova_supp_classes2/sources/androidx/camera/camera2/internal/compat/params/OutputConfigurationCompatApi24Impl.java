package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    public static final class OutputConfigurationParamsApi24 {
        long mDynamicRangeProfile;
        boolean mIsShared;
        final OutputConfiguration mOutputConfiguration;
        String mPhysicalCameraId;

        public int hashCode() {
            int r0 = this.mOutputConfiguration.hashCode() ^ 31;
            int r1 = (r0 << 5) - r0;
            int r2 = (this.mIsShared ? 1 : 0) ^ r1;
            int r3 = (r2 << 5) - r2;
            String r4 = this.mPhysicalCameraId;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = r5 ^ r3;
            int r7 = (r6 << 5) - r6;
            long r8 = this.mDynamicRangeProfile;
            return ((int) (r8 ^ (r8 >>> 32))) ^ r7;
        L5:
            r5 = r4.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi24(OutputConfiguration r3) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r3;
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof OutputConfigurationParamsApi24) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi24 r8 = (OutputConfigurationParamsApi24) r7;
            if (Objects.equals(this.mOutputConfiguration, r8.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mIsShared == r8.mIsShared) goto L10;
            return false;
        L10:
            if (this.mDynamicRangeProfile == r8.mDynamicRangeProfile) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mPhysicalCameraId, r8.mPhysicalCameraId) == false) goto L18;
            return true;
        L18:
            return false;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }

    public OutputConfigurationCompatApi24Impl(Surface r3) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(r3)));
    }

    public static OutputConfigurationCompatApi24Impl wrap(OutputConfiguration r2) {
        return new OutputConfigurationCompatApi24Impl(new OutputConfigurationParamsApi24(r2));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r2) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = r2;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r2) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = r2;
    }

    public OutputConfigurationCompatApi24Impl(Object r1) {
        super(r1);
    }

    public OutputConfigurationCompatApi24Impl(int r3, Surface r4) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(r3, r4)));
    }
}
