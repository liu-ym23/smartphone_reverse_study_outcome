package com.obric.common.oea.foundation.blur;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final enum BlurUtils$BlurType extends Enum<BlurUtils$BlurType> {
    public static final BlurUtils$BlurType NONE = null;
    public static final BlurUtils$BlurType NORMAL_BLUR = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_DOWN_UP = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
    public static final BlurUtils$BlurType PROGRESS_BLUR_UP_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlurUtils$BlurType[] f396409a = null;

    static {
        BlurUtils$BlurType r100 = new BlurUtils$BlurType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        BlurUtils$BlurType r101 = new BlurUtils$BlurType("NORMAL_BLUR", 1);
        NORMAL_BLUR = r101;
        BlurUtils$BlurType r102 = new BlurUtils$BlurType("PROGRESS_BLUR_DOWN_UP", 2);
        PROGRESS_BLUR_DOWN_UP = r102;
        BlurUtils$BlurType r103 = new BlurUtils$BlurType("PROGRESS_BLUR_UP_DOWN", 3);
        PROGRESS_BLUR_UP_DOWN = r103;
        BlurUtils$BlurType r104 = new BlurUtils$BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
        PROGRESS_BLUR_LEFT_RIGHT = r104;
        BlurUtils$BlurType r105 = new BlurUtils$BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
        PROGRESS_BLUR_RIGHT_LEFT = r105;
        f396409a = new BlurUtils$BlurType[]{r100, r101, r102, r103, r104, r105};
    }

    public static BlurUtils$BlurType[] values() {
        return (BlurUtils$BlurType[]) f396409a.clone();
    }

    public static BlurUtils$BlurType valueOf(String r100) {
        return (BlurUtils$BlurType) a.a(BlurUtils$BlurType.class, r100);
    }

    public BlurUtils$BlurType(String r100, int r101) {
        super(r100, r101);
    }
}
