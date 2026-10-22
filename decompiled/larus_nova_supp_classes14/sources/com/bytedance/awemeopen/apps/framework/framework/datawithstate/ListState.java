package com.bytedance.awemeopen.apps.framework.framework.datawithstate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ListState<T> {
    public T a;
    public final T b;
    public State c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState$State;", "", "NEW", "REQUEST_LAUNCH_CONFIG", "REQUEST_LAUNCH_CONFIG_SUCCESS", "REQUEST_LAUNCH_CONFIG_FAIL", "INITIAL_LOAD", "INITIAL_SUCCESS", "INITIAL_FAIL", "START_REFRESH", "REFRESH_SUCCESS", "REFRESH_FAIL", "START_LOAD_MORE", "LOAD_MORE_SUCCESS", "LOAD_MORE_FAIL", "START_LOAD_FORWARD", "LOAD_FORWARD_SUCCESS", "LOAD_FORWARD_FAIL", "DISLIKE_CURRENT", "DISCARD_AFTER_CURRENT", "SERIES_CHOOSE_TARGET_EPISODE", "SERIES_SEGMENT_UPDATE", "CLEAR_DATA", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum State extends Enum<State> {
        public static final State CLEAR_DATA = null;
        public static final State DISCARD_AFTER_CURRENT = null;
        public static final State DISLIKE_CURRENT = null;
        public static final State INITIAL_FAIL = null;
        public static final State INITIAL_LOAD = null;
        public static final State INITIAL_SUCCESS = null;
        public static final State LOAD_FORWARD_FAIL = null;
        public static final State LOAD_FORWARD_SUCCESS = null;
        public static final State LOAD_MORE_FAIL = null;
        public static final State LOAD_MORE_SUCCESS = null;
        public static final State NEW = null;
        public static final State REFRESH_FAIL = null;
        public static final State REFRESH_SUCCESS = null;
        public static final State REQUEST_LAUNCH_CONFIG = null;
        public static final State REQUEST_LAUNCH_CONFIG_FAIL = null;
        public static final State REQUEST_LAUNCH_CONFIG_SUCCESS = null;
        public static final State SERIES_CHOOSE_TARGET_EPISODE = null;
        public static final State SERIES_SEGMENT_UPDATE = null;
        public static final State START_LOAD_FORWARD = null;
        public static final State START_LOAD_MORE = null;
        public static final State START_REFRESH = null;
        public static final /* synthetic */ State[] a = null;

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        static {
            State r0 = new State("NEW", 0);
            NEW = r0;
            State r1 = new State("REQUEST_LAUNCH_CONFIG", 1);
            REQUEST_LAUNCH_CONFIG = r1;
            State r3 = new State("REQUEST_LAUNCH_CONFIG_SUCCESS", 2);
            REQUEST_LAUNCH_CONFIG_SUCCESS = r3;
            State r5 = new State("REQUEST_LAUNCH_CONFIG_FAIL", 3);
            REQUEST_LAUNCH_CONFIG_FAIL = r5;
            State r7 = new State("INITIAL_LOAD", 4);
            INITIAL_LOAD = r7;
            State r9 = new State("INITIAL_SUCCESS", 5);
            INITIAL_SUCCESS = r9;
            State r11 = new State("INITIAL_FAIL", 6);
            INITIAL_FAIL = r11;
            State r13 = new State("START_REFRESH", 7);
            START_REFRESH = r13;
            State r15 = new State("REFRESH_SUCCESS", 8);
            REFRESH_SUCCESS = r15;
            State r14 = new State("REFRESH_FAIL", 9);
            REFRESH_FAIL = r14;
            State r12 = new State("START_LOAD_MORE", 10);
            START_LOAD_MORE = r12;
            State r10 = new State("LOAD_MORE_SUCCESS", 11);
            LOAD_MORE_SUCCESS = r10;
            State r8 = new State("LOAD_MORE_FAIL", 12);
            LOAD_MORE_FAIL = r8;
            State r6 = new State("START_LOAD_FORWARD", 13);
            START_LOAD_FORWARD = r6;
            State r4 = new State("LOAD_FORWARD_SUCCESS", 14);
            LOAD_FORWARD_SUCCESS = r4;
            State r2 = new State("LOAD_FORWARD_FAIL", 15);
            LOAD_FORWARD_FAIL = r2;
            State r16 = new State("DISLIKE_CURRENT", 16);
            DISLIKE_CURRENT = r16;
            State r17 = new State("DISCARD_AFTER_CURRENT", 17);
            DISCARD_AFTER_CURRENT = r17;
            State r18 = new State("SERIES_CHOOSE_TARGET_EPISODE", 18);
            SERIES_CHOOSE_TARGET_EPISODE = r18;
            State r19 = new State("SERIES_SEGMENT_UPDATE", 19);
            SERIES_SEGMENT_UPDATE = r19;
            State r20 = new State("CLEAR_DATA", 20);
            CLEAR_DATA = r20;
            a = new State[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void a(State r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public ListState(T r1, T r2) {
        this.a = r1;
        this.b = r2;
        this.c = State.NEW;
        this.i = "";
        this.j = -1;
    }
}
