package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ChatTypeValue extends Enum<ChatTypeValue> implements WireEnum {
    private static final /* synthetic */ ChatTypeValue[] $VALUES = null;
    public static final ProtoAdapter<ChatTypeValue> ADAPTER = null;
    public static final ChatTypeValue GROUP = null;
    public static final ChatTypeValue P2P = null;
    private final int value;

    static {
        ChatTypeValue r100 = new ChatTypeValue("P2P", 0, 1);
        P2P = r100;
        ChatTypeValue r101 = new ChatTypeValue("GROUP", 1, 2);
        GROUP = r101;
        $VALUES = new ChatTypeValue[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatTypeValue.class);
    }

    public static ChatTypeValue[] values() {
        return (ChatTypeValue[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatTypeValue fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return GROUP;
    L11:
        return P2P;
    }

    public static ChatTypeValue valueOf(String r100) {
        return (ChatTypeValue) a.a(ChatTypeValue.class, r100);
    }

    private ChatTypeValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
