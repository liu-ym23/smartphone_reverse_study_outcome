package com.obric.oui.constraintlayout.core.state;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes34.dex */
public final enum ConstraintSetParser$MotionLayoutDebugFlags extends Enum<ConstraintSetParser$MotionLayoutDebugFlags> {
    public static final ConstraintSetParser$MotionLayoutDebugFlags NONE = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags SHOW_ALL = null;
    public static final ConstraintSetParser$MotionLayoutDebugFlags UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintSetParser$MotionLayoutDebugFlags[] f399680a = null;

    static {
        ConstraintSetParser$MotionLayoutDebugFlags r100 = new ConstraintSetParser$MotionLayoutDebugFlags(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ConstraintSetParser$MotionLayoutDebugFlags r101 = new ConstraintSetParser$MotionLayoutDebugFlags("SHOW_ALL", 1);
        SHOW_ALL = r101;
        ConstraintSetParser$MotionLayoutDebugFlags r102 = new ConstraintSetParser$MotionLayoutDebugFlags("UNKNOWN", 2);
        UNKNOWN = r102;
        f399680a = new ConstraintSetParser$MotionLayoutDebugFlags[]{r100, r101, r102};
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags[] values() {
        return (ConstraintSetParser$MotionLayoutDebugFlags[]) f399680a.clone();
    }

    public static ConstraintSetParser$MotionLayoutDebugFlags valueOf(String r100) {
        return (ConstraintSetParser$MotionLayoutDebugFlags) r27.a.a(ConstraintSetParser$MotionLayoutDebugFlags.class, r100);
    }

    public ConstraintSetParser$MotionLayoutDebugFlags(String r100, int r101) {
        super(r100, r101);
    }
}
