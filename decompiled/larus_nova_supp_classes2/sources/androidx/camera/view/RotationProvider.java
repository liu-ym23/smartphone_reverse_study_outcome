package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class RotationProvider {
    boolean mIgnoreCanDetectForTest;
    final Map<Listener, ListenerWrapper> mListeners;
    final Object mLock;
    final OrientationEventListener mOrientationListener;

    public interface Listener {
        void onRotationChanged(int r1);
    }

    public static class ListenerWrapper {
        private final AtomicBoolean mEnabled;
        private final Executor mExecutor;
        private final Listener mListener;

        public static /* synthetic */ void a(ListenerWrapper r0, int r1) {
            r0.lambda$onRotationChanged$0(r1);
        }

        public void disable() {
            this.mEnabled.set(false);
        }

        private /* synthetic */ void lambda$onRotationChanged$0(int r2) {
            if (this.mEnabled.get() == false) goto L6;
            this.mListener.onRotationChanged(r2);
            return;
        }

        public void onRotationChanged(final int r3) {
            this.mExecutor.execute(new u(this, r3));
        }

        public ListenerWrapper(Listener r1, Executor r2) {
            this.mListener = r1;
            this.mExecutor = r2;
            this.mEnabled = new AtomicBoolean(true);
        }
    }

    public static int orientationToSurfaceRotation(int r1) {
        if (r1 < 315) goto L5;
        return 0;
    L5:
        if (r1 >= 45) goto L8;
        return 0;
    L8:
        if (r1 < 225) goto L12;
        return 1;
    L12:
        if (r1 < 135) goto L15;
        return 2;
    L15:
        return 3;
    }

    public RotationProvider(final Context r2) {
        this.mLock = new Object();
        this.mListeners = new HashMap();
        this.mIgnoreCanDetectForTest = false;
        this.mOrientationListener = new AnonymousClass1(this, r2);
    }

    public void removeListener(Listener r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenerWrapper r1 = this.mListeners.get(r3);     // Catch: Throwable -> L12
        if (r1 == null) goto L8;
        r1.disable();     // Catch: Throwable -> L12
        this.mListeners.remove(r3);     // Catch: Throwable -> L12
    L8:
        if (this.mListeners.isEmpty() == false) goto L10;
        this.mOrientationListener.disable();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean addListener(Executor r4, Listener r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mOrientationListener.canDetectOrientation() == false) goto L7;
    L11:
        this.mListeners.put(r5, new ListenerWrapper(r5, r4));     // Catch: Throwable -> L15
        this.mOrientationListener.enable();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L7:
        if (this.mIgnoreCanDetectForTest == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    }
}
