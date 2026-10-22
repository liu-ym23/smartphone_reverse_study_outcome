package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    private static final String TAG = "StreamConfigurationMapCompatBaseImpl";
    final StreamConfigurationMap mStreamConfigurationMap;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap r0, int r1) {
            return r0.getHighResolutionOutputSizes(r1);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public int[] getOutputFormats() {
        return this.mStreamConfigurationMap.getOutputFormats();
    L6:
        e = move-exception;
        Logger.w(TAG, "Failed to get output formats from StreamConfigurationMap", e);
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public StreamConfigurationMap unwrap() {
        return this.mStreamConfigurationMap;
    }

    public StreamConfigurationMapCompatBaseImpl(StreamConfigurationMap r1) {
        this.mStreamConfigurationMap = r1;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighResolutionOutputSizes(int r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.getHighResolutionOutputSizes(this.mStreamConfigurationMap, r3);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getOutputSizes(int r2) {
        if (r2 != 34) goto L6;
        return this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class);
    L6:
        return this.mStreamConfigurationMap.getOutputSizes(r2);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public <T> Size[] getOutputSizes(Class<T> r2) {
        return this.mStreamConfigurationMap.getOutputSizes(r2);
    }
}
