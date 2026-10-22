package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraBurstCaptureCallback extends CameraCaptureSession.CaptureCallback {
    final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> mCallbackMap;
    CaptureSequenceCallback mCaptureSequenceCallback;

    public interface CaptureSequenceCallback {
        void onCaptureSequenceCompletedOrAborted(CameraCaptureSession r1, int r2, boolean r3);
    }

    public CameraBurstCaptureCallback() {
        this.mCaptureSequenceCallback = null;
        this.mCallbackMap = new HashMap();
    }

    private List<CameraCaptureSession.CaptureCallback> getCallbacks(CaptureRequest r2) {
        List<CameraCaptureSession.CaptureCallback> r3 = this.mCallbackMap.get(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return Collections.emptyList();
    }

    public void setCaptureSequenceCallback(CaptureSequenceCallback r1) {
        this.mCaptureSequenceCallback = r1;
    }

    public void addCamera2Callbacks(CaptureRequest r5, List<CameraCaptureSession.CaptureCallback> r6) {
        List<CameraCaptureSession.CaptureCallback> r0 = this.mCallbackMap.get(r5);
        if (r0 == null) goto L5;
        ArrayList r1 = new ArrayList(r6.size() + r0.size());
        r1.addAll(r6);
        r1.addAll(r0);
        this.mCallbackMap.put(r5, r1);
        return;
    L5:
        this.mCallbackMap.put(r5, r6);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession r4, int r5) {
        Iterator<List<CameraCaptureSession.CaptureCallback>> r0 = this.mCallbackMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<CameraCaptureSession.CaptureCallback> r1 = r0.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r1.next().onCaptureSequenceAborted(r4, r5);
        goto L7
    L9:
        CaptureSequenceCallback r2 = this.mCaptureSequenceCallback;
        if (r2 == null) goto L15;
        r2.onCaptureSequenceCompletedOrAborted(r4, r5, true);
        return;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession r3, CaptureRequest r4, TotalCaptureResult r5) {
        Iterator<CameraCaptureSession.CaptureCallback> r0 = getCallbacks(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureCompleted(r3, r4, r5);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession r3, CaptureRequest r4, CaptureFailure r5) {
        Iterator<CameraCaptureSession.CaptureCallback> r0 = getCallbacks(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureFailed(r3, r4, r5);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession r3, CaptureRequest r4, CaptureResult r5) {
        Iterator<CameraCaptureSession.CaptureCallback> r0 = getCallbacks(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureProgressed(r3, r4, r5);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession r4, int r5, long r6) {
        Iterator<List<CameraCaptureSession.CaptureCallback>> r0 = this.mCallbackMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<CameraCaptureSession.CaptureCallback> r1 = r0.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r1.next().onCaptureSequenceCompleted(r4, r5, r6);
        goto L7
    L9:
        CaptureSequenceCallback r7 = this.mCaptureSequenceCallback;
        if (r7 == null) goto L15;
        r7.onCaptureSequenceCompletedOrAborted(r4, r5, false);
        return;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession r9, CaptureRequest r10, Surface r11, long r12) {
        Iterator<CameraCaptureSession.CaptureCallback> r0 = getCallbacks(r10).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ApiCompat.Api24Impl.onCaptureBufferLost(r0.next(), r9, r10, r11, r12);
        goto L4
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession r10, CaptureRequest r11, long r12, long r14) {
        Iterator<CameraCaptureSession.CaptureCallback> r0 = getCallbacks(r11).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCaptureStarted(r10, r11, r12, r14);
        goto L4
    }
}
