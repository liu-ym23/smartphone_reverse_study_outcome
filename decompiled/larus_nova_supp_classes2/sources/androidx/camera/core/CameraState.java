package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class CameraState {
    public static final int ERROR_CAMERA_DISABLED = 5;
    public static final int ERROR_CAMERA_FATAL_ERROR = 6;
    public static final int ERROR_CAMERA_IN_USE = 2;
    public static final int ERROR_DO_NOT_DISTURB_MODE_ENABLED = 7;
    public static final int ERROR_MAX_CAMERAS_IN_USE = 1;
    public static final int ERROR_OTHER_RECOVERABLE_ERROR = 3;
    public static final int ERROR_STREAM_CONFIG = 4;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType CRITICAL = null;
        public static final ErrorType RECOVERABLE = null;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{RECOVERABLE, CRITICAL};
        }

        static {
            RECOVERABLE = new ErrorType("RECOVERABLE", 0);
            CRITICAL = new ErrorType("CRITICAL", 1);
            $VALUES = $values();
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        public static ErrorType valueOf(String r1) {
            return (ErrorType) r27.a.a(ErrorType.class, r1);
        }

        private ErrorType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class StateError {
        public StateError() {
        }

        public abstract Throwable getCause();

        public abstract int getCode();

        public ErrorType getType() {
            int r0 = getCode();
            if (r0 == 2) goto L12;
            if (r0 == 1) goto L12;
            if (r0 == 3) goto L12;
            return ErrorType.CRITICAL;
        L12:
            return ErrorType.RECOVERABLE;
        }

        public static StateError create(int r1) {
            return create(r1, null);
        }

        public static StateError create(int r1, Throwable r2) {
            return new AutoValue_CameraState_StateError(r1, r2);
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CLOSED = null;
        public static final Type CLOSING = null;
        public static final Type OPEN = null;
        public static final Type OPENING = null;
        public static final Type PENDING_OPEN = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{PENDING_OPEN, OPENING, OPEN, CLOSING, CLOSED};
        }

        static {
            PENDING_OPEN = new Type("PENDING_OPEN", 0);
            OPENING = new Type("OPENING", 1);
            OPEN = new Type("OPEN", 2);
            CLOSING = new Type("CLOSING", 3);
            CLOSED = new Type("CLOSED", 4);
            $VALUES = $values();
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CameraState() {
    }

    public abstract StateError getError();

    public abstract Type getType();

    public static CameraState create(Type r1) {
        return create(r1, null);
    }

    public static CameraState create(Type r1, StateError r2) {
        return new AutoValue_CameraState(r1, r2);
    }
}
