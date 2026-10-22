package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum RNFollowEventTypes extends Enum<RNFollowEventTypes> implements NonProguard {
    private static final /* synthetic */ RNFollowEventTypes[] $VALUES = null;
    public static final RNFollowEventTypes FOLLOW_ACTION = null;
    public static final RNFollowEventTypes FOLLOW_EVENT = null;
    public static final RNFollowEventTypes FOLLOW_REPLAY = null;
    public static final RNFollowEventTypes NEW_ACTIONS = null;
    public static final RNFollowEventTypes NEW_PATCHES = null;
    public static final RNFollowEventTypes PRESENTER_FOLLOWER_LOCATION = null;
    public static final RNFollowEventTypes PRESENTER_STATE = null;
    public static final RNFollowEventTypes SUITE_TITLE_CHANGE = null;

    static {
        RNFollowEventTypes r0 = new RNFollowEventTypes("FOLLOW_ACTION", 0);
        FOLLOW_ACTION = r0;
        RNFollowEventTypes r1 = new RNFollowEventTypes("FOLLOW_REPLAY", 1);
        FOLLOW_REPLAY = r1;
        RNFollowEventTypes r3 = new RNFollowEventTypes("FOLLOW_EVENT", 2);
        FOLLOW_EVENT = r3;
        RNFollowEventTypes r5 = new RNFollowEventTypes("PRESENTER_STATE", 3);
        PRESENTER_STATE = r5;
        RNFollowEventTypes r7 = new RNFollowEventTypes("PRESENTER_FOLLOWER_LOCATION", 4);
        PRESENTER_FOLLOWER_LOCATION = r7;
        RNFollowEventTypes r9 = new RNFollowEventTypes("NEW_ACTIONS", 5);
        NEW_ACTIONS = r9;
        RNFollowEventTypes r11 = new RNFollowEventTypes("NEW_PATCHES", 6);
        NEW_PATCHES = r11;
        RNFollowEventTypes r13 = new RNFollowEventTypes("SUITE_TITLE_CHANGE", 7);
        SUITE_TITLE_CHANGE = r13;
        $VALUES = new RNFollowEventTypes[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static RNFollowEventTypes[] values() {
        return (RNFollowEventTypes[]) $VALUES.clone();
    }

    public static RNFollowEventTypes valueOf(String r1) {
        return (RNFollowEventTypes) a.a(RNFollowEventTypes.class, r1);
    }

    private RNFollowEventTypes(String r1, int r2) {
        super(r1, r2);
    }
}
