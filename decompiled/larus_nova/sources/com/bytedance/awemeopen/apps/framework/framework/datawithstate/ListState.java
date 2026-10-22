package com.bytedance.awemeopen.apps.framework.framework.datawithstate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final class ListState<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f196927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f196928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public State f196929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f196930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f196931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f196932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f196933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f196934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f196935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f196936j;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f196937a = null;

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f196937a.clone();
        }

        static {
            State r100 = new State("NEW", 0);
            NEW = r100;
            State r101 = new State("REQUEST_LAUNCH_CONFIG", 1);
            REQUEST_LAUNCH_CONFIG = r101;
            State r102 = new State("REQUEST_LAUNCH_CONFIG_SUCCESS", 2);
            REQUEST_LAUNCH_CONFIG_SUCCESS = r102;
            State r103 = new State("REQUEST_LAUNCH_CONFIG_FAIL", 3);
            REQUEST_LAUNCH_CONFIG_FAIL = r103;
            State r104 = new State("INITIAL_LOAD", 4);
            INITIAL_LOAD = r104;
            State r105 = new State("INITIAL_SUCCESS", 5);
            INITIAL_SUCCESS = r105;
            State r110 = new State("INITIAL_FAIL", 6);
            INITIAL_FAIL = r110;
            State r111 = new State("START_REFRESH", 7);
            START_REFRESH = r111;
            State r112 = new State("REFRESH_SUCCESS", 8);
            REFRESH_SUCCESS = r112;
            State r113 = new State("REFRESH_FAIL", 9);
            REFRESH_FAIL = r113;
            State r114 = new State("START_LOAD_MORE", 10);
            START_LOAD_MORE = r114;
            State r115 = new State("LOAD_MORE_SUCCESS", 11);
            LOAD_MORE_SUCCESS = r115;
            State r106 = new State("LOAD_MORE_FAIL", 12);
            LOAD_MORE_FAIL = r106;
            State r107 = new State("START_LOAD_FORWARD", 13);
            START_LOAD_FORWARD = r107;
            State r108 = new State("LOAD_FORWARD_SUCCESS", 14);
            LOAD_FORWARD_SUCCESS = r108;
            State r109 = new State("LOAD_FORWARD_FAIL", 15);
            LOAD_FORWARD_FAIL = r109;
            State r116 = new State("DISLIKE_CURRENT", 16);
            DISLIKE_CURRENT = r116;
            State r117 = new State("DISCARD_AFTER_CURRENT", 17);
            DISCARD_AFTER_CURRENT = r117;
            State r118 = new State("SERIES_CHOOSE_TARGET_EPISODE", 18);
            SERIES_CHOOSE_TARGET_EPISODE = r118;
            State r119 = new State("SERIES_SEGMENT_UPDATE", 19);
            SERIES_SEGMENT_UPDATE = r119;
            State r120 = new State("CLEAR_DATA", 20);
            CLEAR_DATA = r120;
            f196937a = new State[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void a(State r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f196929c = r100;
    }

    public ListState(T r100, T r101) {
        this.f196927a = r100;
        this.f196928b = r101;
        this.f196929c = State.NEW;
        this.f196935i = "";
        this.f196936j = -1;
    }
}
