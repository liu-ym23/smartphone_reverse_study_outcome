package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class OutputConfigurationCompat {
    public static final int STREAM_USE_CASE_NONE = -1;
    public static final int SURFACE_GROUP_ID_NONE = -1;
    private final OutputConfigurationCompatImpl mImpl;

    public interface OutputConfigurationCompatImpl {
        void addSurface(Surface r1);

        void enableSurfaceSharing();

        long getDynamicRangeProfile();

        int getMaxSharedSurfaceCount();

        int getMirrorMode();

        Object getOutputConfiguration();

        String getPhysicalCameraId();

        long getStreamUseCase();

        Surface getSurface();

        int getSurfaceGroupId();

        List<Surface> getSurfaces();

        void removeSurface(Surface r1);

        void setDynamicRangeProfile(long r1);

        void setMirrorMode(int r1);

        void setPhysicalCameraId(String r1);

        void setStreamUseCase(long r1);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public long getDynamicRangeProfile() {
        return this.mImpl.getDynamicRangeProfile();
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    public int getMirrorMode() {
        return this.mImpl.getMirrorMode();
    }

    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public long getStreamUseCase() {
        return this.mImpl.getStreamUseCase();
    }

    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    public List<Surface> getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }

    public OutputConfigurationCompat(OutputConfiguration r1) {
        this.mImpl = OutputConfigurationCompatApi33Impl.wrap(r1);
    }

    public static OutputConfigurationCompat wrap(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 33) goto L9;
        OutputConfigurationCompatImpl r4 = OutputConfigurationCompatApi33Impl.wrap((OutputConfiguration) r3);
    L18:
        if (r4 != null) goto L21;
        return null;
    L21:
        return new OutputConfigurationCompat(r4);
    L9:
        if (r1 < 28) goto L12;
        r4 = OutputConfigurationCompatApi28Impl.wrap((OutputConfiguration) r3);
        goto L18
    L12:
        if (r1 < 26) goto L15;
        r4 = OutputConfigurationCompatApi26Impl.wrap((OutputConfiguration) r3);
        goto L18
    L15:
        if (r1 < 24) goto L17;
        r4 = OutputConfigurationCompatApi24Impl.wrap((OutputConfiguration) r3);
        goto L18
    L17:
        r4 = null;
        goto L18
    }

    public void addSurface(Surface r2) {
        this.mImpl.addSurface(r2);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof OutputConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((OutputConfigurationCompat) r2).mImpl);
    }

    public void removeSurface(Surface r2) {
        this.mImpl.removeSurface(r2);
    }

    public void setDynamicRangeProfile(long r2) {
        this.mImpl.setDynamicRangeProfile(r2);
    }

    public void setMirrorMode(int r2) {
        this.mImpl.setMirrorMode(r2);
    }

    public void setPhysicalCameraId(String r2) {
        this.mImpl.setPhysicalCameraId(r2);
    }

    public void setStreamUseCase(long r2) {
        this.mImpl.setStreamUseCase(r2);
    }

    private OutputConfigurationCompat(OutputConfigurationCompatImpl r1) {
        this.mImpl = r1;
    }

    public OutputConfigurationCompat(Surface r2) {
        this(-1, r2);
    }

    public OutputConfigurationCompat(int r3, Surface r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L6;
        this.mImpl = new OutputConfigurationCompatApi33Impl(r3, r4);
        return;
    L6:
        if (r0 < 28) goto L9;
        this.mImpl = new OutputConfigurationCompatApi28Impl(r3, r4);
        return;
    L9:
        if (r0 < 26) goto L12;
        this.mImpl = new OutputConfigurationCompatApi26Impl(r3, r4);
        return;
    L12:
        if (r0 < 24) goto L14;
        this.mImpl = new OutputConfigurationCompatApi24Impl(r3, r4);
        return;
    L14:
        this.mImpl = new OutputConfigurationCompatBaseImpl(r4);
    }

    public <T> OutputConfigurationCompat(Size r2, Class<T> r3) {
        OutputConfiguration r4 = ApiCompat.Api26Impl.newOutputConfiguration(r2, r3);
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 33) goto L6;
        this.mImpl = OutputConfigurationCompatApi33Impl.wrap(r4);
        return;
    L6:
        if (r5 < 28) goto L8;
        this.mImpl = OutputConfigurationCompatApi28Impl.wrap(r4);
        return;
    L8:
        this.mImpl = OutputConfigurationCompatApi26Impl.wrap(r4);
    }
}
