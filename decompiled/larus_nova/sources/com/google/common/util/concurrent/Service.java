package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Create an AbstractIdleService")
@ElementTypesAreNonnullByDefault
public interface Service {

    public static abstract class Listener {
        public Listener() {
        }

        public void failed(State r100, Throwable r101) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State r100) {
        }

        public void terminated(State r100) {
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State FAILED = null;
        public static final State NEW = null;
        public static final State RUNNING = null;
        public static final State STARTING = null;
        public static final State STOPPING = null;
        public static final State TERMINATED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NEW, STARTING, RUNNING, STOPPING, TERMINATED, FAILED};
        }

        static {
            NEW = new State("NEW", 0);
            STARTING = new State("STARTING", 1);
            RUNNING = new State("RUNNING", 2);
            STOPPING = new State("STOPPING", 3);
            TERMINATED = new State("TERMINATED", 4);
            FAILED = new State("FAILED", 5);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    void addListener(Listener r100, Executor r101);

    void awaitRunning();

    void awaitRunning(long r100, TimeUnit r101) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long r100, TimeUnit r101) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    Service startAsync();

    State state();

    Service stopAsync();
}
