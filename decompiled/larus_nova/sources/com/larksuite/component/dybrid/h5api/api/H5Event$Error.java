package com.larksuite.component.dybrid.h5api.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum H5Event$Error extends Enum<H5Event$Error> {
    public static final H5Event$Error FORBIDDEN = null;
    public static final H5Event$Error INVALID_PARAM = null;
    public static final H5Event$Error NONE = null;
    public static final H5Event$Error NOT_FOUND = null;
    public static final H5Event$Error UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H5Event$Error[] f283988a = null;

    static {
        H5Event$Error r100 = new H5Event$Error(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        H5Event$Error r101 = new H5Event$Error("NOT_FOUND", 1);
        NOT_FOUND = r101;
        H5Event$Error r102 = new H5Event$Error("INVALID_PARAM", 2);
        INVALID_PARAM = r102;
        H5Event$Error r103 = new H5Event$Error("UNKNOWN_ERROR", 3);
        UNKNOWN_ERROR = r103;
        H5Event$Error r104 = new H5Event$Error("FORBIDDEN", 4);
        FORBIDDEN = r104;
        f283988a = new H5Event$Error[]{r100, r101, r102, r103, r104};
    }

    public static H5Event$Error[] values() {
        return (H5Event$Error[]) f283988a.clone();
    }

    public static H5Event$Error valueOf(String r100) {
        return (H5Event$Error) a.a(H5Event$Error.class, r100);
    }

    public H5Event$Error(String r100, int r101) {
        super(r100, r101);
    }
}
