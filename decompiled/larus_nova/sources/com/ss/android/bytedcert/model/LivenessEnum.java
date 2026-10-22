package com.ss.android.bytedcert.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum LivenessEnum extends Enum<LivenessEnum> {
    public static final LivenessEnum DO_VERIFY = null;
    public static final LivenessEnum FACE_COMPARE = null;
    public static final LivenessEnum LIVENESS_DETECT = null;
    public static final LivenessEnum NONE = null;
    public static final LivenessEnum SHOW_RETAIN_DIALOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivenessEnum[] f407602a = null;

    static {
        LivenessEnum r100 = new LivenessEnum(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        LivenessEnum r101 = new LivenessEnum("LIVENESS_DETECT", 1);
        LIVENESS_DETECT = r101;
        LivenessEnum r102 = new LivenessEnum("DO_VERIFY", 2);
        DO_VERIFY = r102;
        LivenessEnum r103 = new LivenessEnum("FACE_COMPARE", 3);
        FACE_COMPARE = r103;
        LivenessEnum r104 = new LivenessEnum("SHOW_RETAIN_DIALOG", 4);
        SHOW_RETAIN_DIALOG = r104;
        f407602a = new LivenessEnum[]{r100, r101, r102, r103, r104};
    }

    public static LivenessEnum[] values() {
        return (LivenessEnum[]) f407602a.clone();
    }

    public static LivenessEnum valueOf(String r100) {
        return (LivenessEnum) a.a(LivenessEnum.class, r100);
    }

    public LivenessEnum(String r100, int r101) {
        super(r100, r101);
    }
}
