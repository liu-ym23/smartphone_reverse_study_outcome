package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class OutputConfigurationCompatApi26Impl extends OutputConfigurationCompatApi24Impl {
    private static final String MAX_SHARED_SURFACES_COUNT_FIELD = "MAX_SURFACES_COUNT";
    private static final String SURFACES_FIELD = "mSurfaces";

    public static final class OutputConfigurationParamsApi26 {
        long mDynamicRangeProfile;
        final OutputConfiguration mOutputConfiguration;
        String mPhysicalCameraId;

        public int hashCode() {
            int r0 = this.mOutputConfiguration.hashCode() ^ 31;
            int r1 = (r0 << 5) - r0;
            String r2 = this.mPhysicalCameraId;
            if (r2 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = r3 ^ r1;
            int r5 = (r4 << 5) - r4;
            long r6 = this.mDynamicRangeProfile;
            return ((int) (r6 ^ (r6 >>> 32))) ^ r5;
        L5:
            r3 = r2.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi26(OutputConfiguration r3) {
            this.mDynamicRangeProfile = 1;
            this.mOutputConfiguration = r3;
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof OutputConfigurationParamsApi26) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi26 r8 = (OutputConfigurationParamsApi26) r7;
            if (Objects.equals(this.mOutputConfiguration, r8.mOutputConfiguration) == true) goto L8;
            return false;
        L8:
            if (this.mDynamicRangeProfile == r8.mDynamicRangeProfile) goto L10;
            return false;
        L10:
            if (Objects.equals(this.mPhysicalCameraId, r8.mPhysicalCameraId) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    private static int getMaxSharedSurfaceCountApi26() throws NoSuchFieldException, IllegalAccessException {
        Field r0 = OutputConfiguration.class.getDeclaredField(MAX_SHARED_SURFACES_COUNT_FIELD);
        r0.setAccessible(true);
        return r0.getInt(null);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi26);
        return ((OutputConfigurationParamsApi26) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final boolean isSurfaceSharingEnabled() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfiguration) getOutputConfiguration()).enableSurfaceSharing();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return getMaxSharedSurfaceCountApi26();
    L6:
        e = move-exception;
        Logger.e("OutputConfigCompat", "Unable to retrieve max shared surface count.", e);
        return super.getMaxSharedSurfaceCount();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaces();
    }

    public OutputConfigurationCompatApi26Impl(Surface r3) {
        this(new OutputConfigurationParamsApi26(new OutputConfiguration(r3)));
    }

    private static List<Surface> getMutableSurfaceListApi26(OutputConfiguration r2) throws NoSuchFieldException, IllegalAccessException {
        Field r0 = OutputConfiguration.class.getDeclaredField(SURFACES_FIELD);
        r0.setAccessible(true);
        return (List) r0.get(r2);
    }

    public static OutputConfigurationCompatApi26Impl wrap(OutputConfiguration r2) {
        return new OutputConfigurationCompatApi26Impl(new OutputConfigurationParamsApi26(r2));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(Surface r2) {
        ((OutputConfiguration) getOutputConfiguration()).addSurface(r2);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r3) {
        if (getSurface() == r3) goto L15;
    L11:
        e = move-exception;
        Logger.e("OutputConfigCompat", "Unable to remove surface from this output configuration.", e);
        return;
    L5:
        if (getMutableSurfaceListApi26((OutputConfiguration) getOutputConfiguration()).remove(r3) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Surface is not part of this output configuration");     // Catch: NoSuchFieldException -> L9 Throwable -> L11
    L15:
        throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r2) {
        ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile = r2;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r2) {
        ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId = r2;
    }

    public OutputConfigurationCompatApi26Impl(Object r1) {
        super(r1);
    }

    public OutputConfigurationCompatApi26Impl(int r3, Surface r4) {
        this(new OutputConfigurationParamsApi26(new OutputConfiguration(r3, r4)));
    }
}
