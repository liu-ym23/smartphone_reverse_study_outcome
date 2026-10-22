package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChatResourceType extends Enum<ChatResourceType> implements WireEnum {
    private static final /* synthetic */ ChatResourceType[] $VALUES = null;
    public static final ProtoAdapter<ChatResourceType> ADAPTER = null;
    public static final ChatResourceType IMAGE = null;
    public static final ChatResourceType VIDEO = null;
    private final int value;

    static {
        ChatResourceType r100 = new ChatResourceType("IMAGE", 0, 1);
        IMAGE = r100;
        ChatResourceType r101 = new ChatResourceType("VIDEO", 1, 2);
        VIDEO = r101;
        $VALUES = new ChatResourceType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatResourceType.class);
    }

    public static ChatResourceType[] values() {
        return (ChatResourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatResourceType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return VIDEO;
    L11:
        return IMAGE;
    }

    public static ChatResourceType valueOf(String r100) {
        return (ChatResourceType) a.a(ChatResourceType.class, r100);
    }

    private ChatResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
