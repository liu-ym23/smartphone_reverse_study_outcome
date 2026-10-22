package com.bytedance.apm.launch.evil;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LaunchSleepDetector {
    public static final ExecutorService a = null;

    public static final enum State extends Enum<State> {
        public static final State DISK_SLEEP = null;
        public static final State NONE = null;
        public static final State NOT_SLEEP = null;
        public static final State SLEEP = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r0 = new State("NONE", 0);
            NONE = r0;
            State r1 = new State("SLEEP", 1);
            SLEEP = r1;
            State r3 = new State("NOT_SLEEP", 2);
            NOT_SLEEP = r3;
            State r5 = new State("DISK_SLEEP", 3);
            DISK_SLEEP = r5;
            a = new State[]{r0, r1, r3, r5};
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r3, "LaunchSleepDetector$1");
            ThreadMethodProxy.setName(r0, "launch_sleep_detector");
            return r0;
        }
    }

    static {
        State r0 = State.NONE;
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new a());
    }
}
