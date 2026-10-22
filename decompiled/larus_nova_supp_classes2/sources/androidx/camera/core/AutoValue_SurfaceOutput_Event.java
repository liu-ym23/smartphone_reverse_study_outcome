package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceOutput_Event extends SurfaceOutput.Event {
    private final int eventCode;
    private final SurfaceOutput surfaceOutput;

    public int hashCode() {
        return ((this.eventCode ^ 1000003) * 1000003) ^ this.surfaceOutput.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.eventCode + ", surfaceOutput=" + this.surfaceOutput + "}";
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public int getEventCode() {
        return this.eventCode;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public SurfaceOutput getSurfaceOutput() {
        return this.surfaceOutput;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceOutput.Event) == false) goto L14;
        SurfaceOutput.Event r6 = (SurfaceOutput.Event) r5;
        if (this.eventCode == r6.getEventCode()) goto L10;
    L12:
        return false;
    L10:
        if (this.surfaceOutput.equals(r6.getSurfaceOutput()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceOutput_Event(int r1, SurfaceOutput r2) {
        this.eventCode = r1;
        if (r2 == null) goto L7;
        this.surfaceOutput = r2;
        return;
    L7:
        throw new NullPointerException("Null surfaceOutput");
    }
}
