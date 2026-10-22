package com.bytedance.flow_audio.api.foundation.record;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/record/AudioEngineAECType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "HARDWARE", "SOFTWARE", "HARDWARE_AND_SOFTWARE", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioEngineAECType extends Enum<AudioEngineAECType> {
    public static final AudioEngineAECType HARDWARE = null;
    public static final AudioEngineAECType HARDWARE_AND_SOFTWARE = null;
    public static final AudioEngineAECType NONE = null;
    public static final AudioEngineAECType SOFTWARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioEngineAECType[] f243706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243707b = null;

    public static EnumEntries<AudioEngineAECType> getEntries() {
        return f243707b;
    }

    static {
        AudioEngineAECType r100 = new AudioEngineAECType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AudioEngineAECType r101 = new AudioEngineAECType("HARDWARE", 1);
        HARDWARE = r101;
        AudioEngineAECType r102 = new AudioEngineAECType("SOFTWARE", 2);
        SOFTWARE = r102;
        AudioEngineAECType r103 = new AudioEngineAECType("HARDWARE_AND_SOFTWARE", 3);
        HARDWARE_AND_SOFTWARE = r103;
        AudioEngineAECType[] r104 = {r100, r101, r102, r103};
        f243706a = r104;
        f243707b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioEngineAECType[] values() {
        return (AudioEngineAECType[]) f243706a.clone();
    }

    public static AudioEngineAECType valueOf(String r100) {
        return (AudioEngineAECType) r27.a.a(AudioEngineAECType.class, r100);
    }

    public AudioEngineAECType(String r100, int r101) {
        super(r100, r101);
    }
}
