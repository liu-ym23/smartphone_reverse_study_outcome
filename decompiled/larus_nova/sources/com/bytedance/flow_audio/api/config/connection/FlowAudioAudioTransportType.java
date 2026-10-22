package com.bytedance.flow_audio.api.config.connection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/flow_audio/api/config/connection/FlowAudioAudioTransportType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "WEBSOCKET", "QUIC", "HOST_INJECTION", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAudioAudioTransportType extends Enum<FlowAudioAudioTransportType> {
    public static final FlowAudioAudioTransportType HOST_INJECTION = null;
    public static final FlowAudioAudioTransportType QUIC = null;
    public static final FlowAudioAudioTransportType UNKNOWN = null;
    public static final FlowAudioAudioTransportType WEBSOCKET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAudioAudioTransportType[] f243694a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243695b = null;
    private final int value;

    public static EnumEntries<FlowAudioAudioTransportType> getEntries() {
        return f243695b;
    }

    static {
        FlowAudioAudioTransportType r100 = new FlowAudioAudioTransportType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        FlowAudioAudioTransportType r101 = new FlowAudioAudioTransportType("WEBSOCKET", 1, 0);
        WEBSOCKET = r101;
        FlowAudioAudioTransportType r102 = new FlowAudioAudioTransportType("QUIC", 2, 1);
        QUIC = r102;
        FlowAudioAudioTransportType r103 = new FlowAudioAudioTransportType("HOST_INJECTION", 3, 2);
        HOST_INJECTION = r103;
        FlowAudioAudioTransportType[] r104 = {r100, r101, r102, r103};
        f243694a = r104;
        f243695b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlowAudioAudioTransportType[] values() {
        return (FlowAudioAudioTransportType[]) f243694a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowAudioAudioTransportType valueOf(String r100) {
        return (FlowAudioAudioTransportType) a.a(FlowAudioAudioTransportType.class, r100);
    }

    public FlowAudioAudioTransportType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
