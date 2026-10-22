package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SeekBarState {
    public final Function2<State, Action, Unit> a;
    public State b;
    public State c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$Action;", "", "PAUSE", "RESUME", "DRAG", "RELEASE", "TIMEOUT", "FREEZE", "UNFREEZE", "VIDEO_CHANGE", "RENDER_FIRST", "SEARCH_SEEK", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Action extends Enum<Action> {
        public static final Action DRAG = null;
        public static final Action FREEZE = null;
        public static final Action PAUSE = null;
        public static final Action RELEASE = null;
        public static final Action RENDER_FIRST = null;
        public static final Action RESUME = null;
        public static final Action SEARCH_SEEK = null;
        public static final Action TIMEOUT = null;
        public static final Action UNFREEZE = null;
        public static final Action VIDEO_CHANGE = null;
        public static final /* synthetic */ Action[] a = null;

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        static {
            Action r0 = new Action("PAUSE", 0);
            PAUSE = r0;
            Action r1 = new Action("RESUME", 1);
            RESUME = r1;
            Action r3 = new Action("DRAG", 2);
            DRAG = r3;
            Action r5 = new Action("RELEASE", 3);
            RELEASE = r5;
            Action r7 = new Action("TIMEOUT", 4);
            TIMEOUT = r7;
            Action r9 = new Action("FREEZE", 5);
            FREEZE = r9;
            Action r11 = new Action("UNFREEZE", 6);
            UNFREEZE = r11;
            Action r13 = new Action("VIDEO_CHANGE", 7);
            VIDEO_CHANGE = r13;
            Action r15 = new Action("RENDER_FIRST", 8);
            RENDER_FIRST = r15;
            Action r14 = new Action("SEARCH_SEEK", 9);
            SEARCH_SEEK = r14;
            a = new Action[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        public Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "", "NONE", "FROZEN", "DEFAULT", "ACTIVE", "DRAGGING", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum State extends Enum<State> {
        public static final State ACTIVE = null;
        public static final State DEFAULT = null;
        public static final State DRAGGING = null;
        public static final State FROZEN = null;
        public static final State NONE = null;
        public static final /* synthetic */ State[] a = null;

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        static {
            State r0 = new State("NONE", 0);
            NONE = r0;
            State r1 = new State("FROZEN", 1);
            FROZEN = r1;
            State r3 = new State("DEFAULT", 2);
            DEFAULT = r3;
            State r5 = new State("ACTIVE", 3);
            ACTIVE = r5;
            State r7 = new State("DRAGGING", 4);
            DRAGGING = r7;
            a = new State[]{r0, r1, r3, r5, r7};
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[State.values().length];
            r0[State.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L38:
            r0[State.ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L54:
            r0[State.DRAGGING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L8:
            a = r0;
            int[] r1 = new int[Action.values().length];
            r1[Action.FREEZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L42:
            r1[Action.VIDEO_CHANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L56:
            r1[Action.UNFREEZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L34:
            r1[Action.PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L46:
            r1[Action.RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L36:
            r1[Action.DRAG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L48:
            r1[Action.RELEASE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L52:
            r1[Action.TIMEOUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L40:
            r1[Action.RENDER_FIRST.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L44:
            r1[Action.SEARCH_SEEK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L19:
            b = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeekBarState(Function2<? super State, ? super Action, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onStateChangeListener");
        this.a = r2;
        State r3 = State.NONE;
        this.b = r3;
        this.c = r3;
    }
}
