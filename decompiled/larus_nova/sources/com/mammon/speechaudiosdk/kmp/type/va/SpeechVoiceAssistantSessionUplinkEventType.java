package com.mammon.speechaudiosdk.kmp.type.va;

import com.mammon.audiosdk.session.type.RequestEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionUplinkEventType;", "", "event", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", RequestEvent.StartSession, RequestEvent.FinishSession, RequestEvent.CancelSession, RequestEvent.EndASR, RequestEvent.StartTTS, "BidirectionalTTSText", "BIDIRECTIONALEndTTS", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechVoiceAssistantSessionUplinkEventType extends Enum<SpeechVoiceAssistantSessionUplinkEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechVoiceAssistantSessionUplinkEventType[] $VALUES = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType BIDIRECTIONALEndTTS = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType BidirectionalTTSText = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType CancelSession = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType EndASR = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType FinishSession = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType StartSession = null;
    public static final SpeechVoiceAssistantSessionUplinkEventType StartTTS = null;
    private final String event;

    private static final /* synthetic */ SpeechVoiceAssistantSessionUplinkEventType[] $values() {
        return new SpeechVoiceAssistantSessionUplinkEventType[]{StartSession, FinishSession, CancelSession, EndASR, StartTTS, BidirectionalTTSText, BIDIRECTIONALEndTTS};
    }

    public static EnumEntries<SpeechVoiceAssistantSessionUplinkEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        StartSession = new SpeechVoiceAssistantSessionUplinkEventType(RequestEvent.StartSession, 0, RequestEvent.StartSession);
        FinishSession = new SpeechVoiceAssistantSessionUplinkEventType(RequestEvent.FinishSession, 1, RequestEvent.FinishSession);
        CancelSession = new SpeechVoiceAssistantSessionUplinkEventType(RequestEvent.CancelSession, 2, RequestEvent.CancelSession);
        EndASR = new SpeechVoiceAssistantSessionUplinkEventType(RequestEvent.EndASR, 3, RequestEvent.EndASR);
        StartTTS = new SpeechVoiceAssistantSessionUplinkEventType(RequestEvent.StartTTS, 4, RequestEvent.StartTTS);
        BidirectionalTTSText = new SpeechVoiceAssistantSessionUplinkEventType("BidirectionalTTSText", 5, "BidirectionalTTS");
        BIDIRECTIONALEndTTS = new SpeechVoiceAssistantSessionUplinkEventType("BIDIRECTIONALEndTTS", 6, RequestEvent.EndTTS);
        SpeechVoiceAssistantSessionUplinkEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SpeechVoiceAssistantSessionUplinkEventType[] values() {
        return (SpeechVoiceAssistantSessionUplinkEventType[]) $VALUES.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public static SpeechVoiceAssistantSessionUplinkEventType valueOf(String r100) {
        return (SpeechVoiceAssistantSessionUplinkEventType) a.a(SpeechVoiceAssistantSessionUplinkEventType.class, r100);
    }

    private SpeechVoiceAssistantSessionUplinkEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.event = r102;
    }
}
