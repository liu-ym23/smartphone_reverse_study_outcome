package com.obric.assistant.audio.service;

import com.mammon.audiosdk.session.type.RequestEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "", "<init>", "(Ljava/lang/String;I)V", "SpeechStarted", "Thinking", "QueryRejected", "TtsEnd", RequestEvent.FinishSession, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAssistantAudioVisualizerState extends Enum<ObricAssistantAudioVisualizerState> {
    public static final ObricAssistantAudioVisualizerState FinishSession = null;
    public static final ObricAssistantAudioVisualizerState QueryRejected = null;
    public static final ObricAssistantAudioVisualizerState SpeechStarted = null;
    public static final ObricAssistantAudioVisualizerState Thinking = null;
    public static final ObricAssistantAudioVisualizerState TtsEnd = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAssistantAudioVisualizerState[] f385665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385666b = null;

    public static EnumEntries<ObricAssistantAudioVisualizerState> getEntries() {
        return f385666b;
    }

    static {
        ObricAssistantAudioVisualizerState r100 = new ObricAssistantAudioVisualizerState("SpeechStarted", 0);
        SpeechStarted = r100;
        ObricAssistantAudioVisualizerState r101 = new ObricAssistantAudioVisualizerState("Thinking", 1);
        Thinking = r101;
        ObricAssistantAudioVisualizerState r102 = new ObricAssistantAudioVisualizerState("QueryRejected", 2);
        QueryRejected = r102;
        ObricAssistantAudioVisualizerState r103 = new ObricAssistantAudioVisualizerState("TtsEnd", 3);
        TtsEnd = r103;
        ObricAssistantAudioVisualizerState r104 = new ObricAssistantAudioVisualizerState(RequestEvent.FinishSession, 4);
        FinishSession = r104;
        ObricAssistantAudioVisualizerState[] r105 = {r100, r101, r102, r103, r104};
        f385665a = r105;
        f385666b = EnumEntriesKt.enumEntries(r105);
    }

    public static ObricAssistantAudioVisualizerState[] values() {
        return (ObricAssistantAudioVisualizerState[]) f385665a.clone();
    }

    public static ObricAssistantAudioVisualizerState valueOf(String r100) {
        return (ObricAssistantAudioVisualizerState) a.a(ObricAssistantAudioVisualizerState.class, r100);
    }

    public ObricAssistantAudioVisualizerState(String r100, int r101) {
        super(r100, r101);
    }
}
