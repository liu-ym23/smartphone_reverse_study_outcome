package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class SeekBarState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<State, Action, Unit> f193644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f193645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public State f193646c;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f193647a = null;

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f193647a.clone();
        }

        static {
            Action r100 = new Action("PAUSE", 0);
            PAUSE = r100;
            Action r101 = new Action("RESUME", 1);
            RESUME = r101;
            Action r102 = new Action("DRAG", 2);
            DRAG = r102;
            Action r103 = new Action("RELEASE", 3);
            RELEASE = r103;
            Action r104 = new Action("TIMEOUT", 4);
            TIMEOUT = r104;
            Action r105 = new Action("FREEZE", 5);
            FREEZE = r105;
            Action r110 = new Action("UNFREEZE", 6);
            UNFREEZE = r110;
            Action r111 = new Action("VIDEO_CHANGE", 7);
            VIDEO_CHANGE = r111;
            Action r112 = new Action("RENDER_FIRST", 8);
            RENDER_FIRST = r112;
            Action r113 = new Action("SEARCH_SEEK", 9);
            SEARCH_SEEK = r113;
            f193647a = new Action[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "", UserProfileEvent.POSITION_NONE, "FROZEN", "DEFAULT", "ACTIVE", "DRAGGING", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum State extends Enum<State> {
        public static final State ACTIVE = null;
        public static final State DEFAULT = null;
        public static final State DRAGGING = null;
        public static final State FROZEN = null;
        public static final State NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f193648a = null;

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f193648a.clone();
        }

        static {
            State r100 = new State(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            State r101 = new State("FROZEN", 1);
            FROZEN = r101;
            State r102 = new State("DEFAULT", 2);
            DEFAULT = r102;
            State r103 = new State("ACTIVE", 3);
            ACTIVE = r103;
            State r104 = new State("DRAGGING", 4);
            DRAGGING = r104;
            f193648a = new State[]{r100, r101, r102, r103, r104};
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f193649a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f193650b = null;

        static {
            int[] r100 = new int[State.values().length];
            r100[State.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L38:
            r100[State.ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L54:
            r100[State.DRAGGING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L8:
            f193649a = r100;
            int[] r101 = new int[Action.values().length];
            r101[Action.FREEZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L42:
            r101[Action.VIDEO_CHANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L56:
            r101[Action.UNFREEZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L34:
            r101[Action.PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L46:
            r101[Action.RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L36:
            r101[Action.DRAG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L48:
            r101[Action.RELEASE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L52:
            r101[Action.TIMEOUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L40:
            r101[Action.RENDER_FIRST.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L44:
            r101[Action.SEARCH_SEEK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L19:
            f193650b = r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeekBarState(Function2<? super State, ? super Action, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onStateChangeListener");
        this.f193644a = r100;
        State r101 = State.NONE;
        this.f193645b = r101;
        this.f193646c = r101;
    }
}
