package com.bytedance.dux.panel.anim;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/dux/panel/anim/AnimController$AnimProcessType", "", "Lcom/bytedance/dux/panel/anim/AnimController$AnimProcessType;", UserProfileEvent.POSITION_NONE, "DOING", "DONE", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimController$AnimProcessType extends Enum<AnimController$AnimProcessType> {
    public static final AnimController$AnimProcessType DOING = null;
    public static final AnimController$AnimProcessType DONE = null;
    public static final AnimController$AnimProcessType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimController$AnimProcessType[] f205353a = null;

    public static AnimController$AnimProcessType valueOf(String r100) {
        return (AnimController$AnimProcessType) a.a(AnimController$AnimProcessType.class, r100);
    }

    public static AnimController$AnimProcessType[] values() {
        return (AnimController$AnimProcessType[]) f205353a.clone();
    }

    static {
        AnimController$AnimProcessType r100 = new AnimController$AnimProcessType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AnimController$AnimProcessType r101 = new AnimController$AnimProcessType("DOING", 1);
        DOING = r101;
        AnimController$AnimProcessType r102 = new AnimController$AnimProcessType("DONE", 2);
        DONE = r102;
        f205353a = new AnimController$AnimProcessType[]{r100, r101, r102};
    }

    public AnimController$AnimProcessType(String r100, int r101) {
        super(r100, r101);
    }
}
