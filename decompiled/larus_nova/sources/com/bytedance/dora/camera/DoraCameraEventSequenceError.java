package com.bytedance.dora.camera;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraCameraEventSequenceError extends Enum<DoraCameraEventSequenceError> {
    public static final DoraCameraEventSequenceError LOSS_TAKE_IMAGE_EVENT = null;
    public static final DoraCameraEventSequenceError NONE = null;
    public static final DoraCameraEventSequenceError OUT_OF_ORDER = null;
    public static final DoraCameraEventSequenceError PRE_EVENT_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraCameraEventSequenceError[] f204384a = null;
    private final int code;

    static {
        DoraCameraEventSequenceError r100 = new DoraCameraEventSequenceError(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        DoraCameraEventSequenceError r101 = new DoraCameraEventSequenceError("LOSS_TAKE_IMAGE_EVENT", 1, 1);
        LOSS_TAKE_IMAGE_EVENT = r101;
        DoraCameraEventSequenceError r102 = new DoraCameraEventSequenceError("OUT_OF_ORDER", 2, 2);
        OUT_OF_ORDER = r102;
        DoraCameraEventSequenceError r103 = new DoraCameraEventSequenceError("PRE_EVENT_ERROR", 3, 3);
        PRE_EVENT_ERROR = r103;
        f204384a = new DoraCameraEventSequenceError[]{r100, r101, r102, r103};
    }

    public static DoraCameraEventSequenceError[] values() {
        return (DoraCameraEventSequenceError[]) f204384a.clone();
    }

    public int getCode() {
        return this.code;
    }

    public static DoraCameraEventSequenceError valueOf(String r100) {
        return (DoraCameraEventSequenceError) a.a(DoraCameraEventSequenceError.class, r100);
    }

    public DoraCameraEventSequenceError(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
