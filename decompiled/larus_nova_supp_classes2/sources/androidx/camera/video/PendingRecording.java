package androidx.camera.video;

import android.content.Context;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class PendingRecording {
    private boolean mAudioEnabled;
    private final Context mContext;
    private Consumer<VideoRecordEvent> mEventListener;
    private boolean mIsPersistent;
    private Executor mListenerExecutor;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;

    public PendingRecording asPersistentRecording() {
        this.mIsPersistent = true;
        return this;
    }

    public PendingRecording withAudioEnabled() {
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.RECORD_AUDIO") == (-1)) goto L7;
        Preconditions.checkState(this.mRecorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
        this.mAudioEnabled = true;
        return this;
    L7:
        throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public Consumer<VideoRecordEvent> getEventListener() {
        return this.mEventListener;
    }

    public Executor getListenerExecutor() {
        return this.mListenerExecutor;
    }

    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    public Recorder getRecorder() {
        return this.mRecorder;
    }

    public boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    public Recording start(Executor r2, Consumer<VideoRecordEvent> r3) {
        Preconditions.checkNotNull(r2, "Listener Executor can't be null.");
        Preconditions.checkNotNull(r3, "Event listener can't be null");
        this.mListenerExecutor = r2;
        this.mEventListener = r3;
        return this.mRecorder.start(this);
    }

    public PendingRecording(Context r2, Recorder r3, OutputOptions r4) {
        this.mAudioEnabled = false;
        this.mIsPersistent = false;
        this.mContext = ContextUtil.getApplicationContext(r2);
        this.mRecorder = r3;
        this.mOutputOptions = r4;
    }
}
