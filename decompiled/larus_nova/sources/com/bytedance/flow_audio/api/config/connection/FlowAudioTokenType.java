package com.bytedance.flow_audio.api.config.connection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/config/connection/FlowAudioTokenType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TOKEN_TO_B", "TOKEN_TO_C_D", "TOKEN_TO_B_MIXED", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAudioTokenType extends Enum<FlowAudioTokenType> {
    public static final FlowAudioTokenType TOKEN_TO_B = null;
    public static final FlowAudioTokenType TOKEN_TO_B_MIXED = null;
    public static final FlowAudioTokenType TOKEN_TO_C_D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAudioTokenType[] f243696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243697b = null;
    private final int value;

    public static EnumEntries<FlowAudioTokenType> getEntries() {
        return f243697b;
    }

    static {
        FlowAudioTokenType r100 = new FlowAudioTokenType("TOKEN_TO_B", 0, 0);
        TOKEN_TO_B = r100;
        FlowAudioTokenType r101 = new FlowAudioTokenType("TOKEN_TO_C_D", 1, 1);
        TOKEN_TO_C_D = r101;
        FlowAudioTokenType r102 = new FlowAudioTokenType("TOKEN_TO_B_MIXED", 2, 2);
        TOKEN_TO_B_MIXED = r102;
        FlowAudioTokenType[] r103 = {r100, r101, r102};
        f243696a = r103;
        f243697b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowAudioTokenType[] values() {
        return (FlowAudioTokenType[]) f243696a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowAudioTokenType valueOf(String r100) {
        return (FlowAudioTokenType) a.a(FlowAudioTokenType.class, r100);
    }

    public FlowAudioTokenType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
