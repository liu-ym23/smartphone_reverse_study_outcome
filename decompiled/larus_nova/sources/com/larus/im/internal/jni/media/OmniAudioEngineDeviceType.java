package com.larus.im.internal.jni.media;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "RECORDER", "PLAYER", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAudioEngineDeviceType extends Enum<OmniAudioEngineDeviceType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAudioEngineDeviceType[] $VALUES = null;
    public static final OmniAudioEngineDeviceType NONE = null;
    public static final OmniAudioEngineDeviceType PLAYER = null;
    public static final OmniAudioEngineDeviceType RECORDER = null;

    private static final /* synthetic */ OmniAudioEngineDeviceType[] $values() {
        return new OmniAudioEngineDeviceType[]{NONE, RECORDER, PLAYER};
    }

    public static EnumEntries<OmniAudioEngineDeviceType> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new OmniAudioEngineDeviceType(UserProfileEvent.POSITION_NONE, 0);
        RECORDER = new OmniAudioEngineDeviceType("RECORDER", 1);
        PLAYER = new OmniAudioEngineDeviceType("PLAYER", 2);
        OmniAudioEngineDeviceType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OmniAudioEngineDeviceType[] values() {
        return (OmniAudioEngineDeviceType[]) $VALUES.clone();
    }

    public static OmniAudioEngineDeviceType valueOf(String r100) {
        return (OmniAudioEngineDeviceType) a.a(OmniAudioEngineDeviceType.class, r100);
    }

    private OmniAudioEngineDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
