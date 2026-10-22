package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.core.util.Consumer;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface SurfaceOutput extends Closeable {

    /* JADX INFO: renamed from: androidx.camera.core.SurfaceOutput$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getFormat(SurfaceOutput r0) {
            return 34;
        }

        public static void $default$updateTransformMatrix(SurfaceOutput r0, float[] r1, float[] r2, boolean r3) {
        }

        public static Matrix $default$getSensorToBufferTransform(SurfaceOutput r0) {
            return new Matrix();
        }
    }

    public static abstract class CameraInputInfo {
        public CameraInputInfo() {
        }

        public abstract CameraInternal getCameraInternal();

        public abstract Rect getInputCropRect();

        public abstract Size getInputSize();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        public static CameraInputInfo of(Size r7, Rect r8, CameraInternal r9, int r10, boolean r11) {
            return new AutoValue_SurfaceOutput_CameraInputInfo(r7, r8, r9, r10, r11);
        }
    }

    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventCode {
        }

        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();

        public Event() {
        }

        public static Event of(int r1, SurfaceOutput r2) {
            return new AutoValue_SurfaceOutput_Event(r1, r2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getFormat();

    Matrix getSensorToBufferTransform();

    Size getSize();

    Surface getSurface(Executor r1, Consumer<Event> r2);

    int getTargets();

    void updateTransformMatrix(float[] r1, float[] r2);

    void updateTransformMatrix(float[] r1, float[] r2, boolean r3);
}
