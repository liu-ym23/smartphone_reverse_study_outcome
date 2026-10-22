package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SessionConfigurationCompat {
    public static final int SESSION_HIGH_SPEED = 1;
    public static final int SESSION_REGULAR = 0;
    private final SessionConfigurationCompatImpl mImpl;

    public static final class SessionConfigurationCompatApi28Impl implements SessionConfigurationCompatImpl {
        private final SessionConfiguration mObject;
        private final List<OutputConfigurationCompat> mOutputConfigurations;

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Executor getExecutor() {
            return this.mObject.getExecutor();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat getInputConfiguration() {
            return InputConfigurationCompat.wrap(this.mObject.getInputConfiguration());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mObject.getSessionParameters();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mObject.getSessionType();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mObject.getStateCallback();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object getSessionConfiguration() {
            return this.mObject;
        }

        public SessionConfigurationCompatApi28Impl(Object r1) {
            SessionConfiguration r2 = (SessionConfiguration) r1;
            this.mObject = r2;
            this.mOutputConfigurations = Collections.unmodifiableList(SessionConfigurationCompat.transformToCompat(r2.getOutputConfigurations()));
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof SessionConfigurationCompatApi28Impl) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mObject, ((SessionConfigurationCompatApi28Impl) r2).mObject);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(InputConfigurationCompat r2) {
            this.mObject.setInputConfiguration((InputConfiguration) r2.unwrap());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(CaptureRequest r2) {
            this.mObject.setSessionParameters(r2);
        }

        public SessionConfigurationCompatApi28Impl(int r2, List<OutputConfigurationCompat> r3, Executor r4, CameraCaptureSession.StateCallback r5) {
            this(new SessionConfiguration(r2, SessionConfigurationCompat.transformFromCompat(r3), r4, r5));
        }
    }

    public static final class SessionConfigurationCompatBaseImpl implements SessionConfigurationCompatImpl {
        private final Executor mExecutor;
        private InputConfigurationCompat mInputConfig;
        private final List<OutputConfigurationCompat> mOutputConfigurations;
        private CaptureRequest mSessionParameters;
        private final int mSessionType;
        private final CameraCaptureSession.StateCallback mStateCallback;

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object getSessionConfiguration() {
            return null;
        }

        public int hashCode() {
            int r0 = this.mOutputConfigurations.hashCode() ^ 31;
            int r1 = (r0 << 5) - r0;
            InputConfigurationCompat r2 = this.mInputConfig;
            if (r2 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = r3 ^ r1;
            int r5 = (r4 << 5) - r4;
            return this.mSessionType ^ r5;
        L5:
            r3 = r2.hashCode();
            goto L6
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Executor getExecutor() {
            return this.mExecutor;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat getInputConfiguration() {
            return this.mInputConfig;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mSessionParameters;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mSessionType;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mStateCallback;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof SessionConfigurationCompatBaseImpl) == false) goto L22;
            SessionConfigurationCompatBaseImpl r7 = (SessionConfigurationCompatBaseImpl) r6;
            if (Objects.equals(this.mInputConfig, r7.mInputConfig) == false) goto L22;
            if (this.mSessionType != r7.mSessionType) goto L22;
            if (this.mOutputConfigurations.size() != r7.mOutputConfigurations.size()) goto L22;
            int r1 = 0;
        L16:
            if (r1 >= this.mOutputConfigurations.size()) goto L21;
            if (((OutputConfigurationCompat) ListProtector.get(this.mOutputConfigurations, r1)).equals(ListProtector.get(r7.mOutputConfigurations, r1)) == false) goto L19;
            r1 = r1 + 1;
            goto L16
        L19:
            return false;
        L21:
            return true;
        L22:
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(InputConfigurationCompat r3) {
            if (this.mSessionType == 1) goto L7;
            this.mInputConfig = r3;
            return;
        L7:
            throw new UnsupportedOperationException("Method not supported for high speed session types");
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(CaptureRequest r1) {
            this.mSessionParameters = r1;
        }

        public SessionConfigurationCompatBaseImpl(int r2, List<OutputConfigurationCompat> r3, Executor r4, CameraCaptureSession.StateCallback r5) {
            this.mInputConfig = null;
            this.mSessionParameters = null;
            this.mSessionType = r2;
            this.mOutputConfigurations = Collections.unmodifiableList(new ArrayList(r3));
            this.mStateCallback = r5;
            this.mExecutor = r4;
        }
    }

    public interface SessionConfigurationCompatImpl {
        Executor getExecutor();

        InputConfigurationCompat getInputConfiguration();

        List<OutputConfigurationCompat> getOutputConfigurations();

        Object getSessionConfiguration();

        CaptureRequest getSessionParameters();

        int getSessionType();

        CameraCaptureSession.StateCallback getStateCallback();

        void setInputConfiguration(InputConfigurationCompat r1);

        void setSessionParameters(CaptureRequest r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionMode {
    }

    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    public InputConfigurationCompat getInputConfiguration() {
        return this.mImpl.getInputConfiguration();
    }

    public List<OutputConfigurationCompat> getOutputConfigurations() {
        return this.mImpl.getOutputConfigurations();
    }

    public CaptureRequest getSessionParameters() {
        return this.mImpl.getSessionParameters();
    }

    public int getSessionType() {
        return this.mImpl.getSessionType();
    }

    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mImpl.getStateCallback();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Object unwrap() {
        return this.mImpl.getSessionConfiguration();
    }

    private SessionConfigurationCompat(SessionConfigurationCompatImpl r1) {
        this.mImpl = r1;
    }

    public static List<OutputConfiguration> transformFromCompat(List<OutputConfigurationCompat> r2) {
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<OutputConfigurationCompat> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add((OutputConfiguration) r3.next().unwrap());
        goto L4
    L6:
        return r0;
    }

    public static List<OutputConfigurationCompat> transformToCompat(List<OutputConfiguration> r2) {
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<OutputConfiguration> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(OutputConfigurationCompat.wrap(r3.next()));
        goto L4
    L6:
        return r0;
    }

    public static SessionConfigurationCompat wrap(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return null;
    L9:
        return new SessionConfigurationCompat(new SessionConfigurationCompatApi28Impl(r3));
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof SessionConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((SessionConfigurationCompat) r2).mImpl);
    }

    public void setInputConfiguration(InputConfigurationCompat r2) {
        this.mImpl.setInputConfiguration(r2);
    }

    public void setSessionParameters(CaptureRequest r2) {
        this.mImpl.setSessionParameters(r2);
    }

    public SessionConfigurationCompat(int r3, List<OutputConfigurationCompat> r4, Executor r5, CameraCaptureSession.StateCallback r6) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        this.mImpl = new SessionConfigurationCompatBaseImpl(r3, r4, r5, r6);
        return;
    L5:
        this.mImpl = new SessionConfigurationCompatApi28Impl(r3, r4, r5, r6);
    }
}
