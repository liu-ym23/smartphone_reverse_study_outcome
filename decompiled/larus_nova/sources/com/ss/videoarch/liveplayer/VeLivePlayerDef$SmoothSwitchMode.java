package com.ss.videoarch.liveplayer;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes38.dex */
public final enum VeLivePlayerDef$SmoothSwitchMode extends Enum<VeLivePlayerDef$SmoothSwitchMode> {
    public static final VeLivePlayerDef$SmoothSwitchMode LLASH = null;
    public static final VeLivePlayerDef$SmoothSwitchMode NONE = null;
    public static final VeLivePlayerDef$SmoothSwitchMode RTM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VeLivePlayerDef$SmoothSwitchMode[] f458615a = null;

    static {
        VeLivePlayerDef$SmoothSwitchMode r100 = new VeLivePlayerDef$SmoothSwitchMode(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VeLivePlayerDef$SmoothSwitchMode r101 = new VeLivePlayerDef$SmoothSwitchMode("LLASH", 1);
        LLASH = r101;
        VeLivePlayerDef$SmoothSwitchMode r102 = new VeLivePlayerDef$SmoothSwitchMode("RTM", 2);
        RTM = r102;
        f458615a = new VeLivePlayerDef$SmoothSwitchMode[]{r100, r101, r102};
    }

    public static VeLivePlayerDef$SmoothSwitchMode[] values() {
        return (VeLivePlayerDef$SmoothSwitchMode[]) f458615a.clone();
    }

    public static VeLivePlayerDef$SmoothSwitchMode valueOf(String r100) {
        return (VeLivePlayerDef$SmoothSwitchMode) r27.a.a(VeLivePlayerDef$SmoothSwitchMode.class, r100);
    }

    private VeLivePlayerDef$SmoothSwitchMode(String r100, int r101) {
        super(r100, r101);
    }
}
