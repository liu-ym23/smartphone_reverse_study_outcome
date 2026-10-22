package com.ss.lark.android.avatar.ui;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public final enum AvatarSource extends Enum<AvatarSource> implements Serializable {
    public static final AvatarSource CHAT_SETTING = null;
    public static final AvatarSource EDIT_ALIAS = null;
    public static final AvatarSource MOMENTS = null;
    public static final AvatarSource MY_AI_SCENE_LOGO = null;
    public static final AvatarSource NONE = null;
    public static final AvatarSource PROFILE = null;
    public static final AvatarSource SELF_AVATAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarSource[] f456745a = null;
    private static final long serialVersionUID = 8163352475894755756L;
    int mValue;

    static {
        AvatarSource r100 = new AvatarSource("MOMENTS", 0, 0);
        MOMENTS = r100;
        AvatarSource r101 = new AvatarSource("PROFILE", 1, 1);
        PROFILE = r101;
        AvatarSource r102 = new AvatarSource("CHAT_SETTING", 2, 2);
        CHAT_SETTING = r102;
        AvatarSource r103 = new AvatarSource("EDIT_ALIAS", 3, 3);
        EDIT_ALIAS = r103;
        AvatarSource r104 = new AvatarSource("SELF_AVATAR", 4, 5);
        SELF_AVATAR = r104;
        AvatarSource r105 = new AvatarSource("MY_AI_SCENE_LOGO", 5, 6);
        MY_AI_SCENE_LOGO = r105;
        AvatarSource r110 = new AvatarSource(UserProfileEvent.POSITION_NONE, 6, 4);
        NONE = r110;
        f456745a = new AvatarSource[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static AvatarSource[] values() {
        return (AvatarSource[]) f456745a.clone();
    }

    public static AvatarSource valueOf(String r100) {
        return (AvatarSource) r27.a.a(AvatarSource.class, r100);
    }

    public AvatarSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
