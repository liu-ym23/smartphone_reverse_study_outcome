package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CameraCaptureFailure {
    private final Reason mReason;

    public static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason ERROR = null;

        private static /* synthetic */ Reason[] $values() {
            return new Reason[]{ERROR};
        }

        static {
            ERROR = new Reason("ERROR", 0);
            $VALUES = $values();
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }

        public static Reason valueOf(String r1) {
            return (Reason) r27.a.a(Reason.class, r1);
        }

        private Reason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public Object getCaptureFailure() {
        return null;
    }

    public Reason getReason() {
        return this.mReason;
    }

    public CameraCaptureFailure(Reason r1) {
        this.mReason = r1;
    }
}
