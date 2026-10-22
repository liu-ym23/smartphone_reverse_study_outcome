package com.ss.bytertc.engine.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteMirrorType extends Enum<RemoteMirrorType> {
    private static final /* synthetic */ RemoteMirrorType[] $VALUES = null;
    public static final RemoteMirrorType NONE = null;
    public static final RemoteMirrorType RENDER = null;
    private int value;

    static {
        RemoteMirrorType r100 = new RemoteMirrorType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        RemoteMirrorType r101 = new RemoteMirrorType("RENDER", 1, 1);
        RENDER = r101;
        $VALUES = new RemoteMirrorType[]{r100, r101};
    }

    public static RemoteMirrorType[] values() {
        return (RemoteMirrorType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != NONE) goto L7;
        return UserProfileEvent.POSITION_NONE;
    L7:
        if (this != RENDER) goto L10;
        return "RENDER";
    L10:
        return "";
    }

    public int value() {
        return this.value;
    }

    public static RemoteMirrorType fromId(int r100) {
        RemoteMirrorType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RemoteMirrorType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RemoteMirrorType valueOf(String r100) {
        return (RemoteMirrorType) a.a(RemoteMirrorType.class, r100);
    }

    private RemoteMirrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
