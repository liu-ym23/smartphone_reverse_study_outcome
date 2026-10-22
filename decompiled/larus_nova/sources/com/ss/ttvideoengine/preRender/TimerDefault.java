package com.ss.ttvideoengine.preRender;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public final class TimerDefault implements Timer {
    private ScheduledExecutorService mExecutor;
    private int mInternal;
    private final CopyOnWriteArrayList<Timer.TimerListener> mListeners;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.preRender.TimerDefault$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final TimerDefault TIMER_DEFAULT = null;

        private Holder() {
        }

        static {
            TIMER_DEFAULT = new TimerDefault(null);
        }

        public static /* synthetic */ TimerDefault access$100() {
            return TIMER_DEFAULT;
        }
    }

    public static /* synthetic */ void a(TimerDefault r100) {
        r100.run();
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void start() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mListeners.isEmpty() == false) goto L8;
        stopTimer();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        ScheduledExecutorService r100 = this.mExecutor;     // Catch: Throwable -> L15
        if (r100 != null) goto L11;
    L12:
        ScheduledExecutorService r101 = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("/TimerDefault"));     // Catch: Throwable -> L15
        this.mExecutor = r101;     // Catch: Throwable -> L15
        r101.scheduleWithFixedDelay(new e(this), 0, this.mInternal, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        if (r100.isShutdown() == false) goto L13;
        goto L12
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void stop() {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void run() {
        Iterator<Timer.TimerListener> r100 = this.mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Timer.TimerListener r101 = r100.next();
        if (r101 == null) goto L4;
        r101.trigger();
        goto L4
    }

    public void stopTimer() {
        ScheduledExecutorService r100 = this.mExecutor;
        if (r100 == null) goto L6;
        r100.shutdownNow();
        this.mExecutor = null;
        return;
    }

    private TimerDefault() {
        this.mInternal = 300;
        this.mListeners = new CopyOnWriteArrayList();
    }

    public static TimerDefault instance() {
        return Holder.access$100();
    }

    public /* synthetic */ TimerDefault(AnonymousClass1 r100) {
        this();
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void addTimerListener(Timer.TimerListener r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.mListeners.addIfAbsent(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttvideoengine.preRender.Timer
    public synchronized void removeTimerListener(Timer.TimerListener r100) {
        monitor-enter(this);
        this.mListeners.remove(r100);     // Catch: Throwable -> L8
        if (this.mListeners.isEmpty() == false) goto L6;
        stopTimer();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setInternal(int r100) {
        this.mInternal = r100;
    }
}
