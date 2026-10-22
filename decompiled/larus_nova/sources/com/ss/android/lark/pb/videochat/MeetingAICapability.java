package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MeetingAICapability extends Enum<MeetingAICapability> implements WireEnum {
    private static final /* synthetic */ MeetingAICapability[] $VALUES = null;
    public static final ProtoAdapter<MeetingAICapability> ADAPTER = null;
    public static final MeetingAICapability AI_Chat = null;
    public static final MeetingAICapability Unknown_Capability = null;
    private final int value;

    static {
        MeetingAICapability r100 = new MeetingAICapability("Unknown_Capability", 0, 0);
        Unknown_Capability = r100;
        MeetingAICapability r101 = new MeetingAICapability("AI_Chat", 1, 1);
        AI_Chat = r101;
        $VALUES = new MeetingAICapability[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(MeetingAICapability.class);
    }

    public static MeetingAICapability[] values() {
        return (MeetingAICapability[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MeetingAICapability fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return AI_Chat;
    L10:
        return Unknown_Capability;
    }

    public static MeetingAICapability valueOf(String r100) {
        return (MeetingAICapability) a.a(MeetingAICapability.class, r100);
    }

    private MeetingAICapability(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
