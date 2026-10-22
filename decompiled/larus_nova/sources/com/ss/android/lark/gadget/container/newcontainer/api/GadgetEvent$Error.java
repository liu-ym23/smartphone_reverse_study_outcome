package com.ss.android.lark.gadget.container.newcontainer.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum GadgetEvent$Error extends Enum<GadgetEvent$Error> {
    public static final GadgetEvent$Error FORBIDDEN = null;
    public static final GadgetEvent$Error INVALID_PARAM = null;
    public static final GadgetEvent$Error NONE = null;
    public static final GadgetEvent$Error NOT_FOUND = null;
    public static final GadgetEvent$Error UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GadgetEvent$Error[] f425766a = null;

    static {
        GadgetEvent$Error r100 = new GadgetEvent$Error(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        GadgetEvent$Error r101 = new GadgetEvent$Error("NOT_FOUND", 1);
        NOT_FOUND = r101;
        GadgetEvent$Error r102 = new GadgetEvent$Error("INVALID_PARAM", 2);
        INVALID_PARAM = r102;
        GadgetEvent$Error r103 = new GadgetEvent$Error("UNKNOWN_ERROR", 3);
        UNKNOWN_ERROR = r103;
        GadgetEvent$Error r104 = new GadgetEvent$Error("FORBIDDEN", 4);
        FORBIDDEN = r104;
        f425766a = new GadgetEvent$Error[]{r100, r101, r102, r103, r104};
    }

    public static GadgetEvent$Error[] values() {
        return (GadgetEvent$Error[]) f425766a.clone();
    }

    public static GadgetEvent$Error valueOf(String r100) {
        return (GadgetEvent$Error) a.a(GadgetEvent$Error.class, r100);
    }

    public GadgetEvent$Error(String r100, int r101) {
        super(r100, r101);
    }
}
