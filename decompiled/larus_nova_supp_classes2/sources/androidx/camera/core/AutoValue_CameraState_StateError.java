package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public int hashCode() {
        int r0 = (this.code ^ 1000003) * 1000003;
        Throwable r1 = this.cause;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }

    @Override // androidx.camera.core.CameraState.StateError
    public Throwable getCause() {
        return this.cause;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int getCode() {
        return this.code;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraState.StateError) == false) goto L19;
        CameraState.StateError r6 = (CameraState.StateError) r5;
        if (this.code != r6.getCode()) goto L17;
        Throwable r1 = this.cause;
        if (r1 != null) goto L15;
        if (r6.getCause() != null) goto L17;
        return true;
    L15:
        if (r1.equals(r6.getCause()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public AutoValue_CameraState_StateError(int r1, Throwable r2) {
        this.code = r1;
        this.cause = r2;
    }
}
