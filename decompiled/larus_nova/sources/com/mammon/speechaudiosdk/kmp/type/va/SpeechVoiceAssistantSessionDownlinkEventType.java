package com.mammon.speechaudiosdk.kmp.type.va;

import com.mammon.audiosdk.session.type.ResponseEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionDownlinkEventType;", "", "eventType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventType", "()Ljava/lang/String;", "Unknown", ResponseEvent.TaskStarted, ResponseEvent.TaskFinished, ResponseEvent.TaskFailed, ResponseEvent.SessionStarted, ResponseEvent.SessionFinished, ResponseEvent.SessionCanceled, ResponseEvent.SessionFailed, ResponseEvent.ASRInfo, ResponseEvent.ASRResponse, ResponseEvent.ASREnded, ResponseEvent.ChatResponse, ResponseEvent.ChatEnded, ResponseEvent.TTSSentenceStart, ResponseEvent.TTSResponse, ResponseEvent.TTSSentenceEnd, ResponseEvent.TTSEnded, "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechVoiceAssistantSessionDownlinkEventType extends Enum<SpeechVoiceAssistantSessionDownlinkEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventType[] $VALUES = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType ASREnded = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType ASRInfo = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType ASRResponse = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType ChatEnded = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType ChatResponse = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType SessionCanceled = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType SessionFailed = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType SessionFinished = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType SessionStarted = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TTSEnded = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TTSResponse = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TTSSentenceEnd = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TTSSentenceStart = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TaskFailed = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TaskFinished = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType TaskStarted = null;
    public static final SpeechVoiceAssistantSessionDownlinkEventType Unknown = null;
    private final String eventType;

    private static final /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventType[] $values() {
        return new SpeechVoiceAssistantSessionDownlinkEventType[]{Unknown, TaskStarted, TaskFinished, TaskFailed, SessionStarted, SessionFinished, SessionCanceled, SessionFailed, ASRInfo, ASRResponse, ASREnded, ChatResponse, ChatEnded, TTSSentenceStart, TTSResponse, TTSSentenceEnd, TTSEnded};
    }

    public static EnumEntries<SpeechVoiceAssistantSessionDownlinkEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new SpeechVoiceAssistantSessionDownlinkEventType("Unknown", 0, "unknown");
        TaskStarted = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TaskStarted, 1, ResponseEvent.TaskStarted);
        TaskFinished = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TaskFinished, 2, ResponseEvent.TaskFinished);
        TaskFailed = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TaskFailed, 3, ResponseEvent.TaskFailed);
        SessionStarted = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.SessionStarted, 4, ResponseEvent.SessionStarted);
        SessionFinished = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.SessionFinished, 5, ResponseEvent.SessionFinished);
        SessionCanceled = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.SessionCanceled, 6, ResponseEvent.SessionCanceled);
        SessionFailed = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.SessionFailed, 7, ResponseEvent.SessionFailed);
        ASRInfo = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.ASRInfo, 8, ResponseEvent.ASRInfo);
        ASRResponse = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.ASRResponse, 9, ResponseEvent.ASRResponse);
        ASREnded = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.ASREnded, 10, ResponseEvent.ASREnded);
        ChatResponse = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.ChatResponse, 11, ResponseEvent.ChatResponse);
        ChatEnded = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.ChatEnded, 12, ResponseEvent.ChatEnded);
        TTSSentenceStart = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TTSSentenceStart, 13, ResponseEvent.TTSSentenceStart);
        TTSResponse = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TTSResponse, 14, ResponseEvent.TTSResponse);
        TTSSentenceEnd = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TTSSentenceEnd, 15, ResponseEvent.TTSSentenceEnd);
        TTSEnded = new SpeechVoiceAssistantSessionDownlinkEventType(ResponseEvent.TTSEnded, 16, ResponseEvent.TTSEnded);
        SpeechVoiceAssistantSessionDownlinkEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SpeechVoiceAssistantSessionDownlinkEventType[] values() {
        return (SpeechVoiceAssistantSessionDownlinkEventType[]) $VALUES.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public static SpeechVoiceAssistantSessionDownlinkEventType valueOf(String r100) {
        return (SpeechVoiceAssistantSessionDownlinkEventType) a.a(SpeechVoiceAssistantSessionDownlinkEventType.class, r100);
    }

    private SpeechVoiceAssistantSessionDownlinkEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
