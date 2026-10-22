package com.obric.assistant.spi.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTriggerType;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKEUP", "BREATH_WAKEUP", "CLICK_TALK", "LONG_PRESS", "UNKNOWN", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WakeupAudioCaptureTriggerType extends Enum<WakeupAudioCaptureTriggerType> {
    public static final WakeupAudioCaptureTriggerType BREATH_WAKEUP = null;
    public static final WakeupAudioCaptureTriggerType CLICK_TALK = null;
    public static final WakeupAudioCaptureTriggerType LONG_PRESS = null;
    public static final WakeupAudioCaptureTriggerType UNKNOWN = null;
    public static final WakeupAudioCaptureTriggerType VOICE_WAKEUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WakeupAudioCaptureTriggerType[] f392849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392850b = null;

    public static EnumEntries<WakeupAudioCaptureTriggerType> getEntries() {
        return f392850b;
    }

    static {
        WakeupAudioCaptureTriggerType r100 = new WakeupAudioCaptureTriggerType("VOICE_WAKEUP", 0);
        VOICE_WAKEUP = r100;
        WakeupAudioCaptureTriggerType r101 = new WakeupAudioCaptureTriggerType("BREATH_WAKEUP", 1);
        BREATH_WAKEUP = r101;
        WakeupAudioCaptureTriggerType r102 = new WakeupAudioCaptureTriggerType("CLICK_TALK", 2);
        CLICK_TALK = r102;
        WakeupAudioCaptureTriggerType r103 = new WakeupAudioCaptureTriggerType("LONG_PRESS", 3);
        LONG_PRESS = r103;
        WakeupAudioCaptureTriggerType r104 = new WakeupAudioCaptureTriggerType("UNKNOWN", 4);
        UNKNOWN = r104;
        WakeupAudioCaptureTriggerType[] r105 = {r100, r101, r102, r103, r104};
        f392849a = r105;
        f392850b = EnumEntriesKt.enumEntries(r105);
    }

    public static WakeupAudioCaptureTriggerType[] values() {
        return (WakeupAudioCaptureTriggerType[]) f392849a.clone();
    }

    public static WakeupAudioCaptureTriggerType valueOf(String r100) {
        return (WakeupAudioCaptureTriggerType) r27.a.a(WakeupAudioCaptureTriggerType.class, r100);
    }

    public WakeupAudioCaptureTriggerType(String r100, int r101) {
        super(r100, r101);
    }
}
