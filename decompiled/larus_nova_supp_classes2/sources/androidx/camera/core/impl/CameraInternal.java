package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getHasTransform(CameraInternal r0) {
            return true;
        }

        public static void $default$setActiveResumingMode(CameraInternal r0, boolean r1) {
        }

        public static void $default$setExtendedConfig(CameraInternal r0, CameraConfig r1) {
        }

        public static void $default$setPrimary(CameraInternal r0, boolean r1) {
        }

        public static CameraControl $default$getCameraControl(CameraInternal r0) {
            return r0.getCameraControlInternal();
        }

        public static CameraInfo $default$getCameraInfo(CameraInternal r0) {
            return r0.getCameraInfoInternal();
        }

        public static CameraConfig $default$getExtendedConfig(CameraInternal r0) {
            return CameraConfigs.defaultConfig();
        }

        public static boolean $default$isFrontFacing(CameraInternal r0) {
            if (r0.getCameraInfo().getLensFacing() != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State CLOSING = null;
        public static final State CONFIGURED = null;
        public static final State OPEN = null;
        public static final State OPENING = null;
        public static final State PENDING_OPEN = null;
        public static final State RELEASED = null;
        public static final State RELEASING = null;
        private final boolean mHoldsCameraSlot;

        private static /* synthetic */ State[] $values() {
            return new State[]{RELEASED, RELEASING, CLOSED, PENDING_OPEN, CLOSING, OPENING, OPEN, CONFIGURED};
        }

        static {
            RELEASED = new State("RELEASED", 0, false);
            RELEASING = new State("RELEASING", 1, true);
            CLOSED = new State("CLOSED", 2, false);
            PENDING_OPEN = new State("PENDING_OPEN", 3, false);
            CLOSING = new State("CLOSING", 4, true);
            OPENING = new State("OPENING", 5, true);
            OPEN = new State("OPEN", 6, true);
            CONFIGURED = new State("CONFIGURED", 7, true);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        private State(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.mHoldsCameraSlot = r3;
        }
    }

    void attachUseCases(Collection<UseCase> r1);

    void close();

    void detachUseCases(Collection<UseCase> r1);

    @Override // androidx.camera.core.Camera
    CameraControl getCameraControl();

    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    CameraInfo getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    @Override // androidx.camera.core.Camera
    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void open();

    ListenableFuture<Void> release();

    void setActiveResumingMode(boolean r1);

    void setExtendedConfig(CameraConfig r1);

    void setPrimary(boolean r1);
}
