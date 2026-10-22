package androidx.camera.video;

import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.core.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Recording implements AutoCloseable {
    private final CloseGuardHelper mCloseGuard;
    private final AtomicBoolean mIsClosed;
    private final boolean mIsPersistent;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;
    private final long mRecordingId;

    @Override // java.lang.AutoCloseable
    public void close() {
        stopWithError(0, null);
    }

    public void finalize() throws Throwable {
        this.mCloseGuard.warnIfOpen();     // Catch: Throwable -> L5
        stopWithError(10, new RuntimeException("Recording stopped due to being garbage collected."));     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public boolean isClosed() {
        return this.mIsClosed.get();
    }

    public void pause() {
        if (this.mIsClosed.get() == true) goto L7;
        this.mRecorder.pause(this);
        return;
    L7:
        throw new IllegalStateException("The recording has been stopped.");
    }

    public void resume() {
        if (this.mIsClosed.get() == true) goto L7;
        this.mRecorder.resume(this);
        return;
    L7:
        throw new IllegalStateException("The recording has been stopped.");
    }

    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    public long getRecordingId() {
        return this.mRecordingId;
    }

    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    public void stop() {
        close();
    }

    public void mute(boolean r2) {
        if (this.mIsClosed.get() == true) goto L7;
        this.mRecorder.mute(this, r2);
        return;
    L7:
        throw new IllegalStateException("The recording has been stopped.");
    }

    public static Recording createFinalizedFrom(PendingRecording r8, long r9) {
        Preconditions.checkNotNull(r8, "The given PendingRecording cannot be null.");
        return new Recording(r8.getRecorder(), r9, r8.getOutputOptions(), r8.isPersistent(), true);
    }

    public static Recording from(PendingRecording r8, long r9) {
        Preconditions.checkNotNull(r8, "The given PendingRecording cannot be null.");
        return new Recording(r8.getRecorder(), r9, r8.getOutputOptions(), r8.isPersistent(), false);
    }

    private void stopWithError(int r3, Throwable r4) {
        this.mCloseGuard.close();
        if (this.mIsClosed.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.mRecorder.stop(this, r3, r4);
    }

    public Recording(Recorder r3, long r4, OutputOptions r6, boolean r7, boolean r8) {
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.mIsClosed = r0;
        CloseGuardHelper r1 = CloseGuardHelper.create();
        this.mCloseGuard = r1;
        this.mRecorder = r3;
        this.mRecordingId = r4;
        this.mOutputOptions = r6;
        this.mIsPersistent = r7;
        if (r8 == false) goto L5;
        r0.set(true);
        return;
    L5:
        r1.open("stop");
    }
}
