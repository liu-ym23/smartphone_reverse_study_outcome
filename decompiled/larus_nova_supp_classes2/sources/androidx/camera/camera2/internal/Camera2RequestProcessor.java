package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Camera2RequestProcessor implements RequestProcessor {
    private static final String TAG = "Camera2RequestProcessor";
    private CaptureSession mCaptureSession;
    private volatile boolean mIsClosed;
    private final Object mLock;
    private List<SessionProcessorSurface> mProcessorSurfaces;
    private volatile SessionConfig mSessionConfig;

    public class Camera2CallbackWrapper extends CameraCaptureSession.CaptureCallback {
        private final RequestProcessor.Callback mCallback;
        private final boolean mInvokeSequenceCallback;
        private final RequestProcessor.Request mRequest;
        final /* synthetic */ Camera2RequestProcessor this$0;

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r1, int r2) {
            if (this.mInvokeSequenceCallback == false) goto L6;
            this.mCallback.onCaptureSequenceAborted(r2);
            return;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r2, CaptureRequest r3, TotalCaptureResult r4) {
            this.mCallback.onCaptureCompleted(this.mRequest, new Camera2CameraCaptureResult(r4));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r3, CaptureRequest r4, CaptureFailure r5) {
            this.mCallback.onCaptureFailed(this.mRequest, new Camera2CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR, r5));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession r2, CaptureRequest r3, CaptureResult r4) {
            this.mCallback.onCaptureProgressed(this.mRequest, new Camera2CameraCaptureResult(r4));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r1, int r2, long r3) {
            if (this.mInvokeSequenceCallback == false) goto L6;
            this.mCallback.onCaptureSequenceCompleted(r2, r3);
            return;
        }

        public Camera2CallbackWrapper(Camera2RequestProcessor r1, RequestProcessor.Request r2, RequestProcessor.Callback r3, boolean r4) {
            this.this$0 = r1;
            this.mCallback = r3;
            this.mRequest = r2;
            this.mInvokeSequenceCallback = r4;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession r2, CaptureRequest r3, Surface r4, long r5) {
            this.mCallback.onCaptureBufferLost(this.mRequest, r5, this.this$0.findOutputConfigId(r4));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r7, CaptureRequest r8, long r9, long r11) {
            this.mCallback.onCaptureStarted(this.mRequest, r11, r9);
        }
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public void abortCaptures() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == true) goto L12;
        CaptureSession r1 = this.mCaptureSession;     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        r1.abortCaptures();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsClosed = true;     // Catch: Throwable -> L8
        this.mCaptureSession = null;     // Catch: Throwable -> L8
        this.mSessionConfig = null;     // Catch: Throwable -> L8
        this.mProcessorSurfaces = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public void stopRepeating() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == true) goto L12;
        CaptureSession r1 = this.mCaptureSession;     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        r1.stopRepeating();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private boolean areRequestsValid(List<RequestProcessor.Request> r2) {
        Iterator<RequestProcessor.Request> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (isRequestValid(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    private DeferrableSurface findSurface(int r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<SessionProcessorSurface> r1 = this.mProcessorSurfaces;     // Catch: Throwable -> L17
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L8:
        Iterator<SessionProcessorSurface> r2 = r1.iterator();     // Catch: Throwable -> L17
    L10:
        if (r2.hasNext() == false) goto L15;
        SessionProcessorSurface r3 = r2.next();     // Catch: Throwable -> L17
        if (r3.getOutputConfigId() != r6) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r3;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    private boolean isRequestValid(RequestProcessor.Request r5) {
        if (r5.getTargetOutputConfigIds().isEmpty() == false) goto L6;
        Logger.e(TAG, "Unable to submit the RequestProcessor.Request: empty targetOutputConfigIds");
        return false;
    L6:
        Iterator<Integer> r6 = r5.getTargetOutputConfigIds().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Integer r0 = r6.next();
        if (findSurface(r0.intValue()) != null) goto L8;
        Logger.e(TAG, "Unable to submit the RequestProcessor.Request: targetOutputConfigId(" + r0 + ") is not a valid id");
        return false;
    L13:
        return true;
    }

    public int findOutputConfigId(Surface r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<SessionProcessorSurface> r1 = this.mProcessorSurfaces;     // Catch: Throwable -> L19
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return -1;
    L8:
        Iterator<SessionProcessorSurface> r2 = r1.iterator();     // Catch: Throwable -> L19
    L10:
        if (r2.hasNext() == false) goto L17;
        SessionProcessorSurface r3 = r2.next();     // Catch: Throwable -> L19
        if (r3.getSurface().get() != r6) goto L10;
        int r7 = r3.getOutputConfigId();     // Catch: Throwable -> L22 Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r7;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return -1;
    L19:
        th = move-exception;
        throw th;
    }

    public void updateSessionConfig(SessionConfig r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSessionConfig = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Camera2RequestProcessor(CaptureSession r4, List<SessionProcessorSurface> r5) {
        this.mLock = new Object();
        boolean r0 = false;
        this.mIsClosed = false;
        if (r4.mState != CaptureSession.State.OPENED) goto L5;
        r0 = true;
    L5:
        Preconditions.checkArgument(r0, "CaptureSession state must be OPENED. Current state:" + r4.mState);
        this.mCaptureSession = r4;
        this.mProcessorSurfaces = Collections.unmodifiableList(new ArrayList(r5));
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int setRepeating(RequestProcessor.Request r6, RequestProcessor.Callback r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L7;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return -1;
    L7:
        if (isRequestValid(r6) == false) goto L28;
        if (this.mCaptureSession == null) goto L28;
        SessionConfig.Builder r1 = new SessionConfig.Builder();     // Catch: Throwable -> L31
        r1.setTemplateType(r6.getTemplateId());     // Catch: Throwable -> L31
        r1.setImplementationOptions(r6.getParameters());     // Catch: Throwable -> L31
        r1.addCameraCaptureCallback(CaptureCallbackContainer.create(new Camera2CallbackWrapper(this, r6, r7, true)));     // Catch: Throwable -> L31
        if (this.mSessionConfig == null) goto L21;
        Iterator<CameraCaptureCallback> r8 = this.mSessionConfig.getRepeatingCameraCaptureCallbacks().iterator();     // Catch: Throwable -> L31
    L15:
        if (r8.hasNext() == false) goto L17;
        r1.addCameraCaptureCallback(r8.next());     // Catch: Throwable -> L31
        goto L15
    L17:
        TagBundle r9 = this.mSessionConfig.getRepeatingCaptureConfig().getTagBundle();     // Catch: Throwable -> L31
        Iterator<String> r2 = r9.listKeys().iterator();     // Catch: Throwable -> L31
    L19:
        if (r2.hasNext() == false) goto L21;
        String r3 = r2.next();     // Catch: Throwable -> L31
        r1.addTag(r3, r9.getTag(r3));     // Catch: Throwable -> L31
    L21:
        Iterator<Integer> r10 = r6.getTargetOutputConfigIds().iterator();     // Catch: Throwable -> L31
    L23:
        if (r10.hasNext() == false) goto L25;
        r1.addSurface(findSurface(r10.next().intValue()));     // Catch: Throwable -> L31
        goto L23
    L25:
        int r11 = this.mCaptureSession.issueRepeatingCaptureRequests(r1.build());     // Catch: Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        return r11;
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int submit(List<RequestProcessor.Request> r7, RequestProcessor.Callback r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L7;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return -1;
    L7:
        if (areRequestsValid(r7) == false) goto L22;
        if (this.mCaptureSession == null) goto L22;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L25
        Iterator<RequestProcessor.Request> r9 = r7.iterator();     // Catch: Throwable -> L25
        boolean r2 = true;
    L13:
        if (r9.hasNext() == false) goto L19;
        RequestProcessor.Request r3 = r9.next();     // Catch: Throwable -> L25
        CaptureConfig.Builder r4 = new CaptureConfig.Builder();     // Catch: Throwable -> L25
        r4.setTemplateType(r3.getTemplateId());     // Catch: Throwable -> L25
        r4.setImplementationOptions(r3.getParameters());     // Catch: Throwable -> L25
        r4.addCameraCaptureCallback(CaptureCallbackContainer.create(new Camera2CallbackWrapper(this, r3, r8, r2)));     // Catch: Throwable -> L25
        Iterator<Integer> r5 = r3.getTargetOutputConfigIds().iterator();     // Catch: Throwable -> L25
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.addSurface(findSurface(r5.next().intValue()));     // Catch: Throwable -> L25
        goto L16
    L18:
        r1.add(r4.build());     // Catch: Throwable -> L25
        r2 = false;
        goto L13
    L19:
        int r10 = this.mCaptureSession.issueBurstCaptureRequest(r1);     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        return r10;
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int submit(RequestProcessor.Request r3, RequestProcessor.Callback r4) {
        return submit(Arrays.asList(new RequestProcessor.Request[]{r3}), r4);
    }
}
