package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CameraState extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    public int hashCode() {
        int r0 = (this.type.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError r1 = this.error;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CameraState{type=" + this.type + ", error=" + this.error + "}";
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.StateError getError() {
        return this.error;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.Type getType() {
        return this.type;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraState) == false) goto L19;
        CameraState r6 = (CameraState) r5;
        if (this.type.equals(r6.getType()) == false) goto L17;
        CameraState.StateError r1 = this.error;
        if (r1 != null) goto L15;
        if (r6.getError() != null) goto L17;
        return true;
    L15:
        if (r1.equals(r6.getError()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public AutoValue_CameraState(CameraState.Type r1, CameraState.StateError r2) {
        if (r1 == null) goto L7;
        this.type = r1;
        this.error = r2;
        return;
    L7:
        throw new NullPointerException("Null type");
    }
}
