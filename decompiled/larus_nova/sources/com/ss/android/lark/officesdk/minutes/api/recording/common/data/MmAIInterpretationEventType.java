package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmAIInterpretationEventType;", "", "<init>", "(Ljava/lang/String;I)V", "TARGET_LANGUAGE_SELECTED", "TARGET_LANGUAGE_UNCHANGED", "START_SUCCESS", "START_FAILED", "STOP_SUCCESS", "STOP_FAILED", "SWITCH_SUCCESS", "SWITCH_FAILED", "NO_TARGET_LANGUAGE", "LANGUAGE_LIST_EMPTY", "ENTRY_UNAVAILABLE", "RECORDING_NOT_FOUND", "SPOKEN_LANGUAGE_UNSUPPORTED", "HEADSET_RECOMMENDED", "HEADSET_FORCE_REQUIRED", "PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET", "STOPPED_BY_HUMAN_INTERPRETATION_STARTED", "START_WAITING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAIInterpretationEventType extends Enum<MmAIInterpretationEventType> {
    public static final MmAIInterpretationEventType ENTRY_UNAVAILABLE = null;
    public static final MmAIInterpretationEventType HEADSET_FORCE_REQUIRED = null;
    public static final MmAIInterpretationEventType HEADSET_RECOMMENDED = null;
    public static final MmAIInterpretationEventType LANGUAGE_LIST_EMPTY = null;
    public static final MmAIInterpretationEventType NO_TARGET_LANGUAGE = null;
    public static final MmAIInterpretationEventType PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET = null;
    public static final MmAIInterpretationEventType RECORDING_NOT_FOUND = null;
    public static final MmAIInterpretationEventType SPOKEN_LANGUAGE_UNSUPPORTED = null;
    public static final MmAIInterpretationEventType START_FAILED = null;
    public static final MmAIInterpretationEventType START_SUCCESS = null;
    public static final MmAIInterpretationEventType START_WAITING = null;
    public static final MmAIInterpretationEventType STOPPED_BY_HUMAN_INTERPRETATION_STARTED = null;
    public static final MmAIInterpretationEventType STOP_FAILED = null;
    public static final MmAIInterpretationEventType STOP_SUCCESS = null;
    public static final MmAIInterpretationEventType SWITCH_FAILED = null;
    public static final MmAIInterpretationEventType SWITCH_SUCCESS = null;
    public static final MmAIInterpretationEventType TARGET_LANGUAGE_SELECTED = null;
    public static final MmAIInterpretationEventType TARGET_LANGUAGE_UNCHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAIInterpretationEventType[] f433512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433513b = null;

    public static EnumEntries<MmAIInterpretationEventType> getEntries() {
        return f433513b;
    }

    static {
        MmAIInterpretationEventType r100 = new MmAIInterpretationEventType("TARGET_LANGUAGE_SELECTED", 0);
        TARGET_LANGUAGE_SELECTED = r100;
        MmAIInterpretationEventType r101 = new MmAIInterpretationEventType("TARGET_LANGUAGE_UNCHANGED", 1);
        TARGET_LANGUAGE_UNCHANGED = r101;
        MmAIInterpretationEventType r102 = new MmAIInterpretationEventType("START_SUCCESS", 2);
        START_SUCCESS = r102;
        MmAIInterpretationEventType r103 = new MmAIInterpretationEventType("START_FAILED", 3);
        START_FAILED = r103;
        MmAIInterpretationEventType r104 = new MmAIInterpretationEventType("STOP_SUCCESS", 4);
        STOP_SUCCESS = r104;
        MmAIInterpretationEventType r105 = new MmAIInterpretationEventType("STOP_FAILED", 5);
        STOP_FAILED = r105;
        MmAIInterpretationEventType r110 = new MmAIInterpretationEventType("SWITCH_SUCCESS", 6);
        SWITCH_SUCCESS = r110;
        MmAIInterpretationEventType r111 = new MmAIInterpretationEventType("SWITCH_FAILED", 7);
        SWITCH_FAILED = r111;
        MmAIInterpretationEventType r112 = new MmAIInterpretationEventType("NO_TARGET_LANGUAGE", 8);
        NO_TARGET_LANGUAGE = r112;
        MmAIInterpretationEventType r113 = new MmAIInterpretationEventType("LANGUAGE_LIST_EMPTY", 9);
        LANGUAGE_LIST_EMPTY = r113;
        MmAIInterpretationEventType r114 = new MmAIInterpretationEventType("ENTRY_UNAVAILABLE", 10);
        ENTRY_UNAVAILABLE = r114;
        MmAIInterpretationEventType r115 = new MmAIInterpretationEventType("RECORDING_NOT_FOUND", 11);
        RECORDING_NOT_FOUND = r115;
        MmAIInterpretationEventType r106 = new MmAIInterpretationEventType("SPOKEN_LANGUAGE_UNSUPPORTED", 12);
        SPOKEN_LANGUAGE_UNSUPPORTED = r106;
        MmAIInterpretationEventType r107 = new MmAIInterpretationEventType("HEADSET_RECOMMENDED", 13);
        HEADSET_RECOMMENDED = r107;
        MmAIInterpretationEventType r108 = new MmAIInterpretationEventType("HEADSET_FORCE_REQUIRED", 14);
        HEADSET_FORCE_REQUIRED = r108;
        MmAIInterpretationEventType r109 = new MmAIInterpretationEventType("PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET", 15);
        PLAYBACK_MUTED_BY_ORIGINAL_AUDIO_SAVE_WITHOUT_HEADSET = r109;
        MmAIInterpretationEventType r116 = new MmAIInterpretationEventType("STOPPED_BY_HUMAN_INTERPRETATION_STARTED", 16);
        STOPPED_BY_HUMAN_INTERPRETATION_STARTED = r116;
        MmAIInterpretationEventType r117 = new MmAIInterpretationEventType("START_WAITING", 17);
        START_WAITING = r117;
        MmAIInterpretationEventType[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f433512a = r118;
        f433513b = EnumEntriesKt.enumEntries(r118);
    }

    public static MmAIInterpretationEventType[] values() {
        return (MmAIInterpretationEventType[]) f433512a.clone();
    }

    public static MmAIInterpretationEventType valueOf(String r100) {
        return (MmAIInterpretationEventType) a.a(MmAIInterpretationEventType.class, r100);
    }

    public MmAIInterpretationEventType(String r100, int r101) {
        super(r100, r101);
    }
}
