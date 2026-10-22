package com.bytedance.live.layout;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/live/layout/LayoutAlign;", "", UserProfileEvent.POSITION_NONE, "LEFT_BOTTOM", "CENTER_BOTTOM", "RIGHT_BOTTOM", "LEFT_CENTER", "CENTER", "RIGHT_CENTER", "LEFT_TOP", "CENTER_TOP", "RIGHT_TOP", "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum LayoutAlign extends Enum<LayoutAlign> {
    public static final LayoutAlign CENTER = null;
    public static final LayoutAlign CENTER_BOTTOM = null;
    public static final LayoutAlign CENTER_TOP = null;
    public static final LayoutAlign LEFT_BOTTOM = null;
    public static final LayoutAlign LEFT_CENTER = null;
    public static final LayoutAlign LEFT_TOP = null;

    @Deprecated(message = "not support")
    public static final LayoutAlign NONE = null;
    public static final LayoutAlign RIGHT_BOTTOM = null;
    public static final LayoutAlign RIGHT_CENTER = null;
    public static final LayoutAlign RIGHT_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutAlign[] f255173a = null;

    public static LayoutAlign valueOf(String r100) {
        return (LayoutAlign) r27.a.a(LayoutAlign.class, r100);
    }

    public static LayoutAlign[] values() {
        return (LayoutAlign[]) f255173a.clone();
    }

    static {
        LayoutAlign r100 = new LayoutAlign(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        LayoutAlign r101 = new LayoutAlign("LEFT_BOTTOM", 1);
        LEFT_BOTTOM = r101;
        LayoutAlign r102 = new LayoutAlign("CENTER_BOTTOM", 2);
        CENTER_BOTTOM = r102;
        LayoutAlign r103 = new LayoutAlign("RIGHT_BOTTOM", 3);
        RIGHT_BOTTOM = r103;
        LayoutAlign r104 = new LayoutAlign("LEFT_CENTER", 4);
        LEFT_CENTER = r104;
        LayoutAlign r105 = new LayoutAlign("CENTER", 5);
        CENTER = r105;
        LayoutAlign r110 = new LayoutAlign("RIGHT_CENTER", 6);
        RIGHT_CENTER = r110;
        LayoutAlign r111 = new LayoutAlign("LEFT_TOP", 7);
        LEFT_TOP = r111;
        LayoutAlign r112 = new LayoutAlign("CENTER_TOP", 8);
        CENTER_TOP = r112;
        LayoutAlign r113 = new LayoutAlign("RIGHT_TOP", 9);
        RIGHT_TOP = r113;
        f255173a = new LayoutAlign[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public LayoutAlign(String r100, int r101) {
        super(r100, r101);
    }
}
