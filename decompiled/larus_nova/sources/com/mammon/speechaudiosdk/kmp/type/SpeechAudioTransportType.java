package com.mammon.speechaudiosdk.kmp.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTransportType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "WEBSOCKET", "QUIC", "HOST_INJECTION", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechAudioTransportType extends Enum<SpeechAudioTransportType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechAudioTransportType[] $VALUES = null;
    public static final SpeechAudioTransportType HOST_INJECTION = null;
    public static final SpeechAudioTransportType QUIC = null;
    public static final SpeechAudioTransportType UNKNOWN = null;
    public static final SpeechAudioTransportType WEBSOCKET = null;
    private final int value;

    private static final /* synthetic */ SpeechAudioTransportType[] $values() {
        return new SpeechAudioTransportType[]{UNKNOWN, WEBSOCKET, QUIC, HOST_INJECTION};
    }

    public static EnumEntries<SpeechAudioTransportType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new SpeechAudioTransportType("UNKNOWN", 0, -1);
        WEBSOCKET = new SpeechAudioTransportType("WEBSOCKET", 1, 0);
        QUIC = new SpeechAudioTransportType("QUIC", 2, 1);
        HOST_INJECTION = new SpeechAudioTransportType("HOST_INJECTION", 3, 2);
        SpeechAudioTransportType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SpeechAudioTransportType[] values() {
        return (SpeechAudioTransportType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechAudioTransportType valueOf(String r100) {
        return (SpeechAudioTransportType) a.a(SpeechAudioTransportType.class, r100);
    }

    private SpeechAudioTransportType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
