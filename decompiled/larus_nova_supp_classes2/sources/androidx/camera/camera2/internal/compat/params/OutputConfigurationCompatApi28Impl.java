package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class OutputConfigurationCompatApi28Impl extends OutputConfigurationCompatApi26Impl {

    public static final class OutputConfigurationParamsApi28 {
        long mDynamicRangeProfile;
        final OutputConfiguration mOutputConfiguration;

        public int hashCode() {
            int r0 = this.mOutputConfiguration.hashCode() ^ 31;
            int r1 = (r0 << 5) - r0;
            long r2 = this.mDynamicRangeProfile;
            return ((int) (r2 ^ (r2 >>> 32))) ^ r1;
        }

        public OutputConfigurationParamsApi28(OutputConfiguration r3) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r3;
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof OutputConfigurationParamsApi28) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi28 r8 = (OutputConfigurationParamsApi28) r7;
            if (Objects.equals(this.mOutputConfiguration, r8.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mDynamicRangeProfile != r8.mDynamicRangeProfile) goto L12;
            return true;
        L12:
            return false;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi28);
        return ((OutputConfigurationParamsApi28) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return ((OutputConfiguration) getOutputConfiguration()).getMaxSharedSurfaceCount();
    }

    public OutputConfigurationCompatApi28Impl(Surface r3) {
        this(new OutputConfigurationParamsApi28(new OutputConfiguration(r3)));
    }

    public static OutputConfigurationCompatApi28Impl wrap(OutputConfiguration r2) {
        return new OutputConfigurationCompatApi28Impl(new OutputConfigurationParamsApi28(r2));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r2) {
        ((OutputConfiguration) getOutputConfiguration()).removeSurface(r2);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r2) {
        ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile = r2;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r2) {
        ((OutputConfiguration) getOutputConfiguration()).setPhysicalCameraId(r2);
    }

    public OutputConfigurationCompatApi28Impl(Object r1) {
        super(r1);
    }

    public OutputConfigurationCompatApi28Impl(int r3, Surface r4) {
        this(new OutputConfigurationParamsApi28(new OutputConfiguration(r3, r4)));
    }
}
