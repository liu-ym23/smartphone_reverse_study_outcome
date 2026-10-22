package com.ss.android.vesdk;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEMulticamMode extends Enum<VEMulticamMode> {
    public static final VEMulticamMode BACK_PRIMARY = null;
    public static final VEMulticamMode BACK_PRIMARY_MULTI_RENDER = null;
    public static final VEMulticamMode DEFAULT_PRIMARY = null;
    public static final VEMulticamMode FRONT_PRIMARY = null;
    public static final VEMulticamMode FRONT_PRIMARY_MULTI_RENDER = null;
    public static final VEMulticamMode NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEMulticamMode[] f455633a = null;

    static {
        VEMulticamMode r100 = new VEMulticamMode(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VEMulticamMode r101 = new VEMulticamMode("DEFAULT_PRIMARY", 1);
        DEFAULT_PRIMARY = r101;
        VEMulticamMode r102 = new VEMulticamMode("FRONT_PRIMARY", 2);
        FRONT_PRIMARY = r102;
        VEMulticamMode r103 = new VEMulticamMode("BACK_PRIMARY", 3);
        BACK_PRIMARY = r103;
        VEMulticamMode r104 = new VEMulticamMode("FRONT_PRIMARY_MULTI_RENDER", 4);
        FRONT_PRIMARY_MULTI_RENDER = r104;
        VEMulticamMode r105 = new VEMulticamMode("BACK_PRIMARY_MULTI_RENDER", 5);
        BACK_PRIMARY_MULTI_RENDER = r105;
        f455633a = new VEMulticamMode[]{r100, r101, r102, r103, r104, r105};
    }

    public static VEMulticamMode[] values() {
        return (VEMulticamMode[]) f455633a.clone();
    }

    public static VEMulticamMode valueOf(String r100) {
        return (VEMulticamMode) r27.a.a(VEMulticamMode.class, r100);
    }

    public VEMulticamMode(String r100, int r101) {
        super(r100, r101);
    }
}
