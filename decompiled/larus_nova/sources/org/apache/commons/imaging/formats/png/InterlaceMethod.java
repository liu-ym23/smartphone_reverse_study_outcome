package org.apache.commons.imaging.formats.png;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum InterlaceMethod extends Enum<InterlaceMethod> {
    private static final /* synthetic */ InterlaceMethod[] $VALUES = null;
    public static final InterlaceMethod ADAM7 = null;
    public static final InterlaceMethod NONE = null;
    private final boolean progressive;

    static {
        InterlaceMethod r100 = new InterlaceMethod(UserProfileEvent.POSITION_NONE, 0, false);
        NONE = r100;
        InterlaceMethod r101 = new InterlaceMethod("ADAM7", 1, true);
        ADAM7 = r101;
        $VALUES = new InterlaceMethod[]{r100, r101};
    }

    public static InterlaceMethod[] values() {
        return (InterlaceMethod[]) $VALUES.clone();
    }

    public boolean isProgressive() {
        return this.progressive;
    }

    public static InterlaceMethod valueOf(String r100) {
        return (InterlaceMethod) a.a(InterlaceMethod.class, r100);
    }

    private InterlaceMethod(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.progressive = r102;
    }
}
