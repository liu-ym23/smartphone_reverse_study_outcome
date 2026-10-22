package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ForceCloseCaptureSession {
    private final CaptureSessionOnClosedNotCalledQuirk mCaptureSessionOnClosedNotCalledQuirk;

    @FunctionalInterface
    public interface OnConfigured {
        void run(SynchronizedCaptureSession r1);
    }

    public boolean shouldForceClose() {
        if (this.mCaptureSessionOnClosedNotCalledQuirk == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ForceCloseCaptureSession(Quirks r2) {
        this.mCaptureSessionOnClosedNotCalledQuirk = (CaptureSessionOnClosedNotCalledQuirk) r2.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void forceOnClosed(Set<SynchronizedCaptureSession> r3) {
        Iterator<SynchronizedCaptureSession> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        SynchronizedCaptureSession r0 = r4.next();
        r0.getStateCallback().onClosed(r0);
        goto L4
    }

    private void forceOnConfigureFailed(Set<SynchronizedCaptureSession> r3) {
        Iterator<SynchronizedCaptureSession> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        SynchronizedCaptureSession r0 = r4.next();
        r0.getStateCallback().onConfigureFailed(r0);
        goto L4
    }

    public void onSessionConfigured(SynchronizedCaptureSession r3, List<SynchronizedCaptureSession> r4, List<SynchronizedCaptureSession> r5, OnConfigured r6) {
        if (shouldForceClose() == false) goto L12;
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<SynchronizedCaptureSession> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        SynchronizedCaptureSession r1 = r7.next();
        if (r1 == r3) goto L11;
        r0.add(r1);
    L11:
        forceOnConfigureFailed(r0);
    L12:
        r6.run(r3);
        if (shouldForceClose() == false) goto L27;
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator<SynchronizedCaptureSession> r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        SynchronizedCaptureSession r10 = r9.next();
        if (r10 == r3) goto L21;
        r8.add(r10);
    L21:
        forceOnClosed(r8);
        return;
    }
}
