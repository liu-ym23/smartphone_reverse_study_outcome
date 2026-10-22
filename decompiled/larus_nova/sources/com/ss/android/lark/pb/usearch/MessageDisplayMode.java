package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MessageDisplayMode extends Enum<MessageDisplayMode> implements WireEnum {
    private static final /* synthetic */ MessageDisplayMode[] $VALUES = null;
    public static final ProtoAdapter<MessageDisplayMode> ADAPTER = null;
    public static final MessageDisplayMode DISABLE = null;
    public static final MessageDisplayMode INVISIBLE = null;
    public static final MessageDisplayMode UNKNOWN_MODE = null;
    private final int value;

    static {
        MessageDisplayMode r100 = new MessageDisplayMode("UNKNOWN_MODE", 0, 0);
        UNKNOWN_MODE = r100;
        MessageDisplayMode r101 = new MessageDisplayMode("DISABLE", 1, 1);
        DISABLE = r101;
        MessageDisplayMode r102 = new MessageDisplayMode("INVISIBLE", 2, 2);
        INVISIBLE = r102;
        $VALUES = new MessageDisplayMode[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(MessageDisplayMode.class);
    }

    public static MessageDisplayMode[] values() {
        return (MessageDisplayMode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MessageDisplayMode fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return INVISIBLE;
    L12:
        return DISABLE;
    L14:
        return UNKNOWN_MODE;
    }

    public static MessageDisplayMode valueOf(String r100) {
        return (MessageDisplayMode) a.a(MessageDisplayMode.class, r100);
    }

    private MessageDisplayMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
