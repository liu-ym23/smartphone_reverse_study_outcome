package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ChatShareTargetScene extends Enum<ChatShareTargetScene> implements WireEnum {
    private static final /* synthetic */ ChatShareTargetScene[] $VALUES = null;
    public static final ProtoAdapter<ChatShareTargetScene> ADAPTER = null;
    public static final ChatShareTargetScene SCENE_BITABLE = null;
    public static final ChatShareTargetScene UNKNOWN_SCENE = null;
    private final int value;

    static {
        ChatShareTargetScene r100 = new ChatShareTargetScene("UNKNOWN_SCENE", 0, 1);
        UNKNOWN_SCENE = r100;
        ChatShareTargetScene r101 = new ChatShareTargetScene("SCENE_BITABLE", 1, 2);
        SCENE_BITABLE = r101;
        $VALUES = new ChatShareTargetScene[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatShareTargetScene.class);
    }

    public static ChatShareTargetScene[] values() {
        return (ChatShareTargetScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatShareTargetScene fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return SCENE_BITABLE;
    L11:
        return UNKNOWN_SCENE;
    }

    public static ChatShareTargetScene valueOf(String r100) {
        return (ChatShareTargetScene) a.a(ChatShareTargetScene.class, r100);
    }

    private ChatShareTargetScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
