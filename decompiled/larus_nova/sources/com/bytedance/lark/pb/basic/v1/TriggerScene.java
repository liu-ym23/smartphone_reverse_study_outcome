package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TriggerScene extends Enum<TriggerScene> implements WireEnum {
    private static final /* synthetic */ TriggerScene[] $VALUES = null;
    public static final ProtoAdapter<TriggerScene> ADAPTER = null;
    public static final TriggerScene AT_KNOWLEDGE = null;
    public static final TriggerScene UNREAD_RECOMMEND = null;
    public static final TriggerScene UNREAD_RECOMMEND_AUTO = null;
    public static final TriggerScene UNREAD_RECOMMEND_FOLLOW_UP = null;
    public static final TriggerScene UNREAD_RECOMMEND_PRELOAD = null;
    private final int value;

    static {
        TriggerScene r100 = new TriggerScene("AT_KNOWLEDGE", 0, 0);
        AT_KNOWLEDGE = r100;
        TriggerScene r101 = new TriggerScene("UNREAD_RECOMMEND", 1, 1);
        UNREAD_RECOMMEND = r101;
        TriggerScene r102 = new TriggerScene("UNREAD_RECOMMEND_AUTO", 2, 2);
        UNREAD_RECOMMEND_AUTO = r102;
        TriggerScene r103 = new TriggerScene("UNREAD_RECOMMEND_PRELOAD", 3, 3);
        UNREAD_RECOMMEND_PRELOAD = r103;
        TriggerScene r104 = new TriggerScene("UNREAD_RECOMMEND_FOLLOW_UP", 4, 4);
        UNREAD_RECOMMEND_FOLLOW_UP = r104;
        $VALUES = new TriggerScene[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(TriggerScene.class);
    }

    public static TriggerScene[] values() {
        return (TriggerScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TriggerScene fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return UNREAD_RECOMMEND_FOLLOW_UP;
    L16:
        return UNREAD_RECOMMEND_PRELOAD;
    L18:
        return UNREAD_RECOMMEND_AUTO;
    L20:
        return UNREAD_RECOMMEND;
    L22:
        return AT_KNOWLEDGE;
    }

    public static TriggerScene valueOf(String r100) {
        return (TriggerScene) a.a(TriggerScene.class, r100);
    }

    private TriggerScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
