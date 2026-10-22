package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
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
        RNFollowEventTypes r100 = new RNFollowEventTypes("FOLLOW_ACTION", 0);
        FOLLOW_ACTION = r100;
        RNFollowEventTypes r101 = new RNFollowEventTypes("FOLLOW_REPLAY", 1);
        FOLLOW_REPLAY = r101;
        RNFollowEventTypes r102 = new RNFollowEventTypes("FOLLOW_EVENT", 2);
        FOLLOW_EVENT = r102;
        RNFollowEventTypes r103 = new RNFollowEventTypes("PRESENTER_STATE", 3);
        PRESENTER_STATE = r103;
        RNFollowEventTypes r104 = new RNFollowEventTypes("PRESENTER_FOLLOWER_LOCATION", 4);
        PRESENTER_FOLLOWER_LOCATION = r104;
        RNFollowEventTypes r105 = new RNFollowEventTypes("NEW_ACTIONS", 5);
        NEW_ACTIONS = r105;
        RNFollowEventTypes r110 = new RNFollowEventTypes("NEW_PATCHES", 6);
        NEW_PATCHES = r110;
        RNFollowEventTypes r111 = new RNFollowEventTypes("SUITE_TITLE_CHANGE", 7);
        SUITE_TITLE_CHANGE = r111;
        $VALUES = new RNFollowEventTypes[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static RNFollowEventTypes[] values() {
        return (RNFollowEventTypes[]) $VALUES.clone();
    }

    public static RNFollowEventTypes valueOf(String r100) {
        return (RNFollowEventTypes) a.a(RNFollowEventTypes.class, r100);
    }

    private RNFollowEventTypes(String r100, int r101) {
        super(r100, r101);
    }
}
