package androidx.camera.camera2.internal.compat.params;

import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {
    static final String TAG = "OutputConfigCompat";
    final Object mObject;

    public static final class OutputConfigurationParamsApi21 {
        private static final String DETECT_SURFACE_TYPE_METHOD = "detectSurfaceType";
        private static final String GET_GENERATION_ID_METHOD = "getGenerationId";
        private static final String GET_SURFACE_SIZE_METHOD = "getSurfaceSize";
        private static final String LEGACY_CAMERA_DEVICE_CLASS = "android.hardware.camera2.legacy.LegacyCameraDevice";
        static final int MAX_SURFACES_COUNT = 1;
        final int mConfiguredFormat;
        final int mConfiguredGenerationId;
        final Size mConfiguredSize;
        long mDynamicRangeProfile;
        boolean mIsShared;
        String mPhysicalCameraId;
        final List<Surface> mSurfaces;

        public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        public int hashCode() {
            int r0 = this.mSurfaces.hashCode() ^ 31;
            int r1 = (r0 << 5) - r0;
            int r2 = this.mConfiguredGenerationId ^ r1;
            int r3 = (r2 << 5) - r2;
            int r4 = this.mConfiguredSize.hashCode() ^ r3;
            int r5 = (r4 << 5) - r4;
            int r6 = this.mConfiguredFormat ^ r5;
            int r7 = (r6 << 5) - r6;
            int r8 = (this.mIsShared ? 1 : 0) ^ r7;
            int r9 = (r8 << 5) - r8;
            String r10 = this.mPhysicalCameraId;
            if (r10 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = r11 ^ r9;
            int r13 = (r12 << 5) - r12;
            long r14 = this.mDynamicRangeProfile;
            return ((int) (r14 ^ (r14 >>> 32))) ^ r13;
        L5:
            r11 = r10.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi21(Surface r3) {
            this.mIsShared = false;
            this.mDynamicRangeProfile = 1;
            Preconditions.checkNotNull(r3, "Surface must not be null");
            this.mSurfaces = Collections.singletonList(r3);
            this.mConfiguredSize = getSurfaceSize(r3);
            this.mConfiguredFormat = getSurfaceFormat(r3);
            this.mConfiguredGenerationId = getSurfaceGenerationId(r3);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$000(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$000(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }

        private static int getSurfaceFormat(Surface r6) {
            Method r1 = INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(DETECT_SURFACE_TYPE_METHOD, new Class[]{Surface.class});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 Throwable -> L14
            if (Build.VERSION.SDK_INT >= 22) goto L6;
            r1.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 Throwable -> L14
        L6:
            return ((Integer) r1.invoke(null, new Object[]{r6})).intValue();
        L14:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
            return 0;
        }

        private static int getSurfaceGenerationId(Surface r4) {
            return ((Integer) Surface.class.getDeclaredMethod(GET_GENERATION_ID_METHOD, new Class[0]).invoke(r4, new Object[0])).intValue();
        L6:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface generation id.", e);
            return -1;
        }

        private static Size getSurfaceSize(Surface r7) {
            Method r1 = INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(GET_SURFACE_SIZE_METHOD, new Class[]{Surface.class});     // Catch: Throwable -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
            r1.setAccessible(true);     // Catch: Throwable -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
            return (Size) r1.invoke(null, new Object[]{r7});
        L5:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface size.", e);
            return null;
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof OutputConfigurationParamsApi21) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi21 r8 = (OutputConfigurationParamsApi21) r7;
            if (this.mConfiguredSize.equals(r8.mConfiguredSize) == true) goto L8;
        L26:
            return false;
        L8:
            if (this.mConfiguredFormat != r8.mConfiguredFormat) goto L26;
            if (this.mConfiguredGenerationId != r8.mConfiguredGenerationId) goto L26;
            if (this.mIsShared != r8.mIsShared) goto L26;
            if (this.mDynamicRangeProfile != r8.mDynamicRangeProfile) goto L26;
            if (Objects.equals(this.mPhysicalCameraId, r8.mPhysicalCameraId) == false) goto L26;
            int r0 = Math.min(this.mSurfaces.size(), r8.mSurfaces.size());
            int r2 = 0;
        L19:
            if (r2 >= r0) goto L24;
            if (ListProtector.get(this.mSurfaces, r2) != ListProtector.get(r8.mSurfaces, r2)) goto L22;
            r2 = r2 + 1;
            goto L19
        L22:
            return false;
        L24:
            return true;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return 1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMirrorMode() {
        return 0;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getStreamUseCase() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setMirrorMode(int r1) {
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setStreamUseCase(long r1) {
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        List<Surface> r0 = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (r0.size() != 0) goto L7;
        return null;
    L7:
        return (Surface) ListProtector.get(r0, 0);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    public OutputConfigurationCompatBaseImpl(Surface r2) {
        this.mObject = new OutputConfigurationParamsApi21(r2);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(Surface r2) {
        Preconditions.checkNotNull(r2, "Surface must not be null");
        if (getSurface() == r2) goto L11;
        if (isSurfaceSharingEnabled() == true) goto L9;
        throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
    L9:
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    L11:
        throw new IllegalStateException("Surface is already added!");
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof OutputConfigurationCompatBaseImpl) == true) goto L7;
        return false;
    L7:
        return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) r2).mObject);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r2) {
        if (getSurface() != r2) goto L7;
        throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
    L7:
        throw new IllegalArgumentException("Surface is not part of this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r2) {
        ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile = r2;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r2) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = r2;
    }

    public OutputConfigurationCompatBaseImpl(Object r1) {
        this.mObject = r1;
    }
}
