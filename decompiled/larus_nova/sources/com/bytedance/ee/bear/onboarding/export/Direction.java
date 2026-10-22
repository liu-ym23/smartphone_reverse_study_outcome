package com.bytedance.ee.bear.onboarding.export;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum Direction extends Enum<Direction> {
    public static final Direction DOWN = null;
    public static final Direction NONE = null;
    public static final Direction UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f236151a = null;

    static {
        Direction r100 = new Direction("UP", 0);
        UP = r100;
        Direction r101 = new Direction("DOWN", 1);
        DOWN = r101;
        Direction r102 = new Direction(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        f236151a = new Direction[]{r100, r101, r102};
    }

    public static Direction[] values() {
        return (Direction[]) f236151a.clone();
    }

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public Direction(String r100, int r101) {
        super(r100, r101);
    }
}
