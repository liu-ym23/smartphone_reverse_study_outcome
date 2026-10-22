package com.ss.android.bytedcert.camera.common;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum CameraFactory$WhiteBalanceType extends Enum<CameraFactory$WhiteBalanceType> {
    public static final CameraFactory$WhiteBalanceType AUTO_INCANDESCENT = null;
    public static final CameraFactory$WhiteBalanceType BLUE = null;
    public static final CameraFactory$WhiteBalanceType GREEN = null;
    public static final CameraFactory$WhiteBalanceType NONE = null;
    public static final CameraFactory$WhiteBalanceType RED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraFactory$WhiteBalanceType[] f407269a = null;

    static {
        CameraFactory$WhiteBalanceType r100 = new CameraFactory$WhiteBalanceType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CameraFactory$WhiteBalanceType r101 = new CameraFactory$WhiteBalanceType("RED", 1);
        RED = r101;
        CameraFactory$WhiteBalanceType r102 = new CameraFactory$WhiteBalanceType("GREEN", 2);
        GREEN = r102;
        CameraFactory$WhiteBalanceType r103 = new CameraFactory$WhiteBalanceType("BLUE", 3);
        BLUE = r103;
        CameraFactory$WhiteBalanceType r104 = new CameraFactory$WhiteBalanceType("AUTO_INCANDESCENT", 4);
        AUTO_INCANDESCENT = r104;
        f407269a = new CameraFactory$WhiteBalanceType[]{r100, r101, r102, r103, r104};
    }

    public static CameraFactory$WhiteBalanceType[] values() {
        return (CameraFactory$WhiteBalanceType[]) f407269a.clone();
    }

    public static CameraFactory$WhiteBalanceType valueOf(String r100) {
        return (CameraFactory$WhiteBalanceType) a.a(CameraFactory$WhiteBalanceType.class, r100);
    }

    public CameraFactory$WhiteBalanceType(String r100, int r101) {
        super(r100, r101);
    }
}
