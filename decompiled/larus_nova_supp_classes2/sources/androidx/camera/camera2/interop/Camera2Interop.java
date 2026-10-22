package androidx.camera.camera2.interop;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2Interop {

    public static final class Extender<T> {
        ExtendableBuilder<T> mBaseBuilder;

        public Extender(ExtendableBuilder<T> r1) {
            this.mBaseBuilder = r1;
        }

        public Extender<T> setCaptureRequestTemplate(int r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.TEMPLATE_TYPE_OPTION, Integer.valueOf(r3));
            return this;
        }

        public Extender<T> setDeviceStateCallback(CameraDevice.StateCallback r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.DEVICE_STATE_CALLBACK_OPTION, r3);
            return this;
        }

        public Extender<T> setPhysicalCameraId(String r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION, r3);
            return this;
        }

        public Extender<T> setSessionCaptureCallback(CameraCaptureSession.CaptureCallback r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION, r3);
            return this;
        }

        public Extender<T> setSessionStateCallback(CameraCaptureSession.StateCallback r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.SESSION_STATE_CALLBACK_OPTION, r3);
            return this;
        }

        public Extender<T> setStreamUseCase(long r3) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION, Long.valueOf(r3));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Extender<T> setCaptureRequestOption(CaptureRequest.Key<ValueT> r3, ValueT r4) {
            Config.Option<Object> r5 = Camera2ImplConfig.createCaptureRequestOption(r3);
            this.mBaseBuilder.getMutableConfig().insertOption(r5, Config.OptionPriority.ALWAYS_OVERRIDE, r4);
            return this;
        }
    }

    private Camera2Interop() {
    }
}
