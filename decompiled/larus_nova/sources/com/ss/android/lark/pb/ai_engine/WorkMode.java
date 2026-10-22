package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum WorkMode extends Enum<WorkMode> implements WireEnum {
    private static final /* synthetic */ WorkMode[] $VALUES = null;
    public static final ProtoAdapter<WorkMode> ADAPTER = null;
    public static final WorkMode AtAIKnowledge = null;
    public static final WorkMode Chat = null;
    public static final WorkMode IMReply = null;
    public static final WorkMode Inline = null;
    public static final WorkMode Playground = null;
    public static final WorkMode UnreadRecommend = null;
    private final int value;

    static {
        WorkMode r100 = new WorkMode("Chat", 0, 1);
        Chat = r100;
        WorkMode r101 = new WorkMode("Inline", 1, 2);
        Inline = r101;
        WorkMode r102 = new WorkMode("Playground", 2, 3);
        Playground = r102;
        WorkMode r103 = new WorkMode("IMReply", 3, 4);
        IMReply = r103;
        WorkMode r104 = new WorkMode("AtAIKnowledge", 4, 5);
        AtAIKnowledge = r104;
        WorkMode r110 = new WorkMode("UnreadRecommend", 5, 6);
        UnreadRecommend = r110;
        $VALUES = new WorkMode[]{r100, r101, r102, r103, r104, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(WorkMode.class);
    }

    public static WorkMode[] values() {
        return (WorkMode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static WorkMode fromValue(int r100) {
        switch(r100) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return UnreadRecommend;
    L8:
        return AtAIKnowledge;
    L10:
        return IMReply;
    L12:
        return Playground;
    L14:
        return Inline;
    L16:
        return Chat;
    }

    public static WorkMode valueOf(String r100) {
        return (WorkMode) a.a(WorkMode.class, r100);
    }

    private WorkMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
