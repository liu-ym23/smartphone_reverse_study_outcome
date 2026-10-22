package com.larus.im.internal.jni.media;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineDeviceState;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "STARTED", "STOPPED", "ERROR", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAudioEngineDeviceState extends Enum<OmniAudioEngineDeviceState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAudioEngineDeviceState[] $VALUES = null;
    public static final OmniAudioEngineDeviceState ERROR = null;
    public static final OmniAudioEngineDeviceState NONE = null;
    public static final OmniAudioEngineDeviceState STARTED = null;
    public static final OmniAudioEngineDeviceState STOPPED = null;

    private static final /* synthetic */ OmniAudioEngineDeviceState[] $values() {
        return new OmniAudioEngineDeviceState[]{NONE, STARTED, STOPPED, ERROR};
    }

    public static EnumEntries<OmniAudioEngineDeviceState> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new OmniAudioEngineDeviceState(UserProfileEvent.POSITION_NONE, 0);
        STARTED = new OmniAudioEngineDeviceState("STARTED", 1);
        STOPPED = new OmniAudioEngineDeviceState("STOPPED", 2);
        ERROR = new OmniAudioEngineDeviceState("ERROR", 3);
        OmniAudioEngineDeviceState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OmniAudioEngineDeviceState[] values() {
        return (OmniAudioEngineDeviceState[]) $VALUES.clone();
    }

    public static OmniAudioEngineDeviceState valueOf(String r100) {
        return (OmniAudioEngineDeviceState) a.a(OmniAudioEngineDeviceState.class, r100);
    }

    private OmniAudioEngineDeviceState(String r100, int r101) {
        super(r100, r101);
    }
}
