package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class InputConfigurationCompat {
    private final InputConfigurationCompatImpl mImpl;

    public static class InputConfigurationCompatApi23Impl implements InputConfigurationCompatImpl {
        private final InputConfiguration mObject;

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mObject.getFormat();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mObject.getHeight();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mObject.getWidth();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        public String toString() {
            return this.mObject.toString();
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object getInputConfiguration() {
            return this.mObject;
        }

        public InputConfigurationCompatApi23Impl(Object r1) {
            this.mObject = (InputConfiguration) r1;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof InputConfigurationCompatImpl) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mObject, ((InputConfigurationCompatImpl) r2).getInputConfiguration());
        }

        public InputConfigurationCompatApi23Impl(int r2, int r3, int r4) {
            this(new InputConfiguration(r2, r3, r4));
        }
    }

    public static final class InputConfigurationCompatApi31Impl extends InputConfigurationCompatApi23Impl {
        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatApi23Impl, androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return ((InputConfiguration) getInputConfiguration()).isMultiResolution();
        }

        public InputConfigurationCompatApi31Impl(Object r1) {
            super(r1);
        }

        public InputConfigurationCompatApi31Impl(int r1, int r2, int r3) {
            super(r1, r2, r3);
        }
    }

    public static final class InputConfigurationCompatBaseImpl implements InputConfigurationCompatImpl {
        private final int mFormat;
        private final int mHeight;
        private final int mWidth;

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object getInputConfiguration() {
            return null;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public boolean isMultiResolution() {
            return false;
        }

        public String toString() {
            return String.format("InputConfiguration(w:%d, h:%d, format:%d)", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mFormat)});
        }

        public int hashCode() {
            int r0 = 31 ^ this.mWidth;
            int r1 = (r0 << 5) - r0;
            int r2 = this.mHeight ^ r1;
            int r3 = (r2 << 5) - r2;
            return this.mFormat ^ r3;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getFormat() {
            return this.mFormat;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getHeight() {
            return this.mHeight;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public int getWidth() {
            return this.mWidth;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof InputConfigurationCompatBaseImpl) == true) goto L5;
            return false;
        L5:
            InputConfigurationCompatBaseImpl r5 = (InputConfigurationCompatBaseImpl) r4;
            if (r5.getWidth() == this.mWidth) goto L8;
            return false;
        L8:
            if (r5.getHeight() == this.mHeight) goto L10;
            return false;
        L10:
            if (r5.getFormat() != this.mFormat) goto L15;
            return true;
        L15:
            return false;
        }

        public InputConfigurationCompatBaseImpl(int r1, int r2, int r3) {
            this.mWidth = r1;
            this.mHeight = r2;
            this.mFormat = r3;
        }
    }

    public interface InputConfigurationCompatImpl {
        int getFormat();

        int getHeight();

        Object getInputConfiguration();

        int getWidth();

        boolean isMultiResolution();
    }

    public int getFormat() {
        return this.mImpl.getFormat();
    }

    public int getHeight() {
        return this.mImpl.getHeight();
    }

    public int getWidth() {
        return this.mImpl.getWidth();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean isMultiResolution() {
        return this.mImpl.isMultiResolution();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getInputConfiguration();
    }

    private InputConfigurationCompat(InputConfigurationCompatImpl r1) {
        this.mImpl = r1;
    }

    public static InputConfigurationCompat wrap(Object r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 23) goto L9;
        return null;
    L9:
        if (r1 < 31) goto L13;
        return new InputConfigurationCompat(new InputConfigurationCompatApi31Impl(r3));
    L13:
        return new InputConfigurationCompat(new InputConfigurationCompatApi23Impl(r3));
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof InputConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((InputConfigurationCompat) r2).mImpl);
    }

    public InputConfigurationCompat(int r3, int r4, int r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L6;
        this.mImpl = new InputConfigurationCompatApi31Impl(r3, r4, r5);
        return;
    L6:
        if (r0 < 23) goto L8;
        this.mImpl = new InputConfigurationCompatApi23Impl(r3, r4, r5);
        return;
    L8:
        this.mImpl = new InputConfigurationCompatBaseImpl(r3, r4, r5);
    }
}
