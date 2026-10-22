package com.bytedance.scene;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes19.dex */
public final enum State extends Enum<State> {
    public static final State ACTIVITY_CREATED = null;
    public static final State NONE = null;
    public static final State RESUMED = null;
    public static final State STARTED = null;
    public static final State VIEW_CREATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State[] f268618a = null;
    public final String name;
    public final int value;

    static {
        State r100 = new State(UserProfileEvent.POSITION_NONE, 0, 0, UserProfileEvent.POSITION_NONE);
        NONE = r100;
        State r101 = new State("VIEW_CREATED", 1, 1, "VIEW_CREATED");
        VIEW_CREATED = r101;
        State r102 = new State("ACTIVITY_CREATED", 2, 2, "ACTIVITY_CREATED");
        ACTIVITY_CREATED = r102;
        State r103 = new State("STARTED", 3, 3, "STARTED");
        STARTED = r103;
        State r104 = new State("RESUMED", 4, 4, "RESUMED");
        RESUMED = r104;
        f268618a = new State[]{r100, r101, r102, r103, r104};
    }

    public static State[] values() {
        return (State[]) f268618a.clone();
    }

    public String getName() {
        return this.name;
    }

    public static State valueOf(String r100) {
        return (State) r27.a.a(State.class, r100);
    }

    public State(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.name = r103;
    }
}
