package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.imageformat.ImageFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {
    static final long INACTIVITY_CHECK_POLLING_TIME_MS = 1000;
    static final long INACTIVITY_THRESHOLD_MS = 2000;
    private long mInactivityCheckPollingTimeMs;
    private boolean mInactivityCheckScheduled;

    @Nullable
    private InactivityListener mInactivityListener;
    private long mInactivityThresholdMs;
    private final Runnable mIsInactiveCheck;
    private long mLastDrawnTimeMs;
    private final MonotonicClock mMonotonicClock;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public interface InactivityListener {
        void onInactive();
    }

    private synchronized void maybeScheduleInactivityCheck() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mInactivityCheckScheduled == true) goto L6;
        this.mInactivityCheckScheduled = true;     // Catch: Throwable -> L8
        this.mScheduledExecutorServiceForUiThread.schedule(this.mIsInactiveCheck, this.mInactivityCheckPollingTimeMs, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private boolean isInactive() {
        if ((this.mMonotonicClock.now() - this.mLastDrawnTimeMs) <= this.mInactivityThresholdMs) goto L5;
        return true;
    L5:
        return false;
    }

    public long getInactivityCheckPollingTimeMs() {
        return this.mInactivityCheckPollingTimeMs;
    }

    public long getInactivityThresholdMs() {
        return this.mInactivityThresholdMs;
    }

    public static /* synthetic */ boolean access$100(AnimationBackendDelegateWithInactivityCheck r100) {
        return r100.isInactive();
    }

    public static /* synthetic */ InactivityListener access$200(AnimationBackendDelegateWithInactivityCheck r100) {
        return r100.mInactivityListener;
    }

    public static /* synthetic */ void access$300(AnimationBackendDelegateWithInactivityCheck r100) {
        r100.maybeScheduleInactivityCheck();
    }

    public void setInactivityCheckPollingTimeMs(long r100) {
        this.mInactivityCheckPollingTimeMs = r100;
    }

    public void setInactivityListener(@Nullable InactivityListener r100) {
        this.mInactivityListener = r100;
    }

    public void setInactivityThresholdMs(long r100) {
        this.mInactivityThresholdMs = r100;
    }

    public static /* synthetic */ boolean access$002(AnimationBackendDelegateWithInactivityCheck r100, boolean r101) {
        r100.mInactivityCheckScheduled = r101;
        return r101;
    }

    public static <T extends AnimationBackend & InactivityListener> AnimationBackendDelegate<T> createForBackend(T r100, MonotonicClock r101, ScheduledExecutorService r102) {
        return createForBackend(r100, (InactivityListener) r100, r101, r102);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable r100, Canvas r101, int r102) {
        this.mLastDrawnTimeMs = this.mMonotonicClock.now();
        boolean r103 = super.drawFrame(r100, r101, r102);
        maybeScheduleInactivityCheck();
        return r103;
    }

    private AnimationBackendDelegateWithInactivityCheck(@Nullable T r100, @Nullable InactivityListener r101, MonotonicClock r102, ScheduledExecutorService r103) {
        super(r100);
        this.mInactivityCheckScheduled = false;
        this.mInactivityThresholdMs = 2000;
        this.mInactivityCheckPollingTimeMs = 1000;
        this.mIsInactiveCheck = new AnonymousClass1(this);
        this.mInactivityListener = r101;
        this.mMonotonicClock = r102;
        this.mScheduledExecutorServiceForUiThread = r103;
    }

    public static <T extends AnimationBackend & InactivityListener> AnimationBackendDelegate<T> createForBackend(ImageFormat r100, T r101, MonotonicClock r102, ScheduledExecutorService r103) {
        return createForBackend(r100, r101, (InactivityListener) r101, r102, r103);
    }

    public static <T extends AnimationBackend> AnimationBackendDelegate<T> createForBackend(T r100, InactivityListener r101, MonotonicClock r102, ScheduledExecutorService r103) {
        return new AnimationBackendDelegateWithInactivityCheck(r100, r101, r102, r103);
    }

    private AnimationBackendDelegateWithInactivityCheck(ImageFormat r100, @Nullable T r101, @Nullable InactivityListener r102, MonotonicClock r103, ScheduledExecutorService r104) {
        super(r101, r100);
        this.mInactivityCheckScheduled = false;
        this.mInactivityThresholdMs = 2000;
        this.mInactivityCheckPollingTimeMs = 1000;
        this.mIsInactiveCheck = new AnonymousClass1(this);
        this.mInactivityListener = r102;
        this.mMonotonicClock = r103;
        this.mScheduledExecutorServiceForUiThread = r104;
    }

    public static <T extends AnimationBackend> AnimationBackendDelegate<T> createForBackend(ImageFormat r100, T r101, InactivityListener r102, MonotonicClock r110, ScheduledExecutorService r111) {
        return new AnimationBackendDelegateWithInactivityCheck(r100, r101, r102, r110, r111);
    }
}
