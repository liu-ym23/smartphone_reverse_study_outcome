package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_DefaultSurfaceProcessor_PendingSnapshot extends DefaultSurfaceProcessor.PendingSnapshot {
    private final CallbackToFutureAdapter.Completer<Void> completer;
    private final int jpegQuality;
    private final int rotationDegrees;

    public int hashCode() {
        return ((((this.jpegQuality ^ 1000003) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.completer.hashCode();
    }

    public String toString() {
        return "PendingSnapshot{jpegQuality=" + this.jpegQuality + ", rotationDegrees=" + this.rotationDegrees + ", completer=" + this.completer + "}";
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    public CallbackToFutureAdapter.Completer<Void> getCompleter() {
        return this.completer;
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultSurfaceProcessor.PendingSnapshot) == false) goto L16;
        DefaultSurfaceProcessor.PendingSnapshot r6 = (DefaultSurfaceProcessor.PendingSnapshot) r5;
        if (this.jpegQuality == r6.getJpegQuality()) goto L10;
    L14:
        return false;
    L10:
        if (this.rotationDegrees != r6.getRotationDegrees()) goto L14;
        if (this.completer.equals(r6.getCompleter()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_DefaultSurfaceProcessor_PendingSnapshot(int r1, int r2, CallbackToFutureAdapter.Completer<Void> r3) {
        this.jpegQuality = r1;
        this.rotationDegrees = r2;
        if (r3 == null) goto L7;
        this.completer = r3;
        return;
    L7:
        throw new NullPointerException("Null completer");
    }
}
