package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    private SnackbarRecord currentSnackbar;
    private final Handler handler;
    private final Object lock;
    private SnackbarRecord nextSnackbar;

    public interface Callback {
        void dismiss(int r100);

        void show();
    }

    public static class SnackbarRecord {
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        public boolean isSnackbar(Callback r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.callback.get() != r100) goto L6;
            return true;
        }

        public SnackbarRecord(int r100, Callback r101) {
            this.callback = new WeakReference(r101);
            this.duration = r100;
        }
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager != null) goto L6;
        snackbarManager = new SnackbarManager();
    L6:
        return snackbarManager;
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord r100 = this.nextSnackbar;
        if (r100 == null) goto L9;
        this.currentSnackbar = r100;
        this.nextSnackbar = null;
        Callback r101 = r100.callback.get();
        if (r101 == null) goto L7;
        r101.show();
        return;
    L7:
        this.currentSnackbar = null;
        return;
    }

    private SnackbarManager() {
        this.lock = new Object();
        this.handler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    private boolean isCurrentSnackbarLocked(Callback r100) {
        SnackbarRecord r101 = this.currentSnackbar;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isSnackbar(r100) == false) goto L7;
        return true;
    }

    private boolean isNextSnackbarLocked(Callback r100) {
        SnackbarRecord r101 = this.nextSnackbar;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isSnackbar(r100) == false) goto L7;
        return true;
    }

    private void scheduleTimeoutLocked(SnackbarRecord r100) {
        int r101 = r100.duration;
        if (r101 != (-2)) goto L5;
        return;
    L5:
        if (r101 <= 0) goto L8;
    L11:
        this.handler.removeCallbacksAndMessages(r100);
        Handler r102 = this.handler;
        r102.sendMessageDelayed(Message.obtain(r102, 0, r100), r101);
        return;
    L8:
        if (r101 != (-1)) goto L10;
        r101 = 1500;
        goto L11
    L10:
        r101 = LONG_DURATION_MS;
        goto L11
    }

    public void handleTimeout(SnackbarRecord r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.currentSnackbar != r100) goto L7;
    L8:
        cancelSnackbarLocked(r100, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.nextSnackbar != r100) goto L9;
        goto L8
    }

    public boolean isCurrent(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = isCurrentSnackbarLocked(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCurrentOrNext(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102;
    L7:
        if (isNextSnackbarLocked(r100) == true) goto L10;
        r102 = false;
        goto L11
    }

    public void onDismissed(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L9;
        this.currentSnackbar = null;     // Catch: Throwable -> L11
        if (this.nextSnackbar == null) goto L9;
        showNextSnackbarLocked();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void onShown(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L7;
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void pauseTimeout(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L9;
        SnackbarRecord r102 = this.currentSnackbar;     // Catch: Throwable -> L11
        if (r102.paused == true) goto L9;
        r102.paused = true;     // Catch: Throwable -> L11
        this.handler.removeCallbacksAndMessages(r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void restoreTimeoutIfPaused(Callback r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L9;
        SnackbarRecord r102 = this.currentSnackbar;     // Catch: Throwable -> L11
        if (r102.paused == false) goto L9;
        r102.paused = false;     // Catch: Throwable -> L11
        scheduleTimeoutLocked(r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    private boolean cancelSnackbarLocked(SnackbarRecord r100, int r101) {
        Callback r102 = r100.callback.get();
        if (r102 == null) goto L6;
        this.handler.removeCallbacksAndMessages(r100);
        r102.dismiss(r101);
        return true;
    L6:
        return false;
    }

    public void dismiss(Callback r100, int r101) {
        Object r102 = this.lock;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r100) == false) goto L8;
        cancelSnackbarLocked(this.currentSnackbar, r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L8:
        if (isNextSnackbarLocked(r100) == false) goto L10;
        cancelSnackbarLocked(this.nextSnackbar, r101);     // Catch: Throwable -> L12
        goto L10
    }

    public void show(int r100, Callback r101) {
        Object r102 = this.lock;
        monitor-enter(r102);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r101) == false) goto L10;
        SnackbarRecord r103 = this.currentSnackbar;     // Catch: Throwable -> L22
        r103.duration = r100;     // Catch: Throwable -> L22
        this.handler.removeCallbacksAndMessages(r103);     // Catch: Throwable -> L22
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L10:
        if (isNextSnackbarLocked(r101) == false) goto L12;
        this.nextSnackbar.duration = r100;     // Catch: Throwable -> L22
    L13:
        SnackbarRecord r104 = this.currentSnackbar;     // Catch: Throwable -> L22
        if (r104 != null) goto L16;
    L19:
        this.currentSnackbar = null;     // Catch: Throwable -> L22
        showNextSnackbarLocked();     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L16:
        if (cancelSnackbarLocked(r104, 4) == false) goto L19;
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L12:
        this.nextSnackbar = new SnackbarRecord(r100, r101);     // Catch: Throwable -> L22
        goto L13
    }
}
