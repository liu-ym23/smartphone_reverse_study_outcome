package com.bytedance.flow_audio.api.foundation.record;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/record/RecordAmplitudeType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "AMPLITUDE", "AMPLITUDE_CALL", "AMPLITUDE_METER", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordAmplitudeType extends Enum<RecordAmplitudeType> {
    public static final RecordAmplitudeType AMPLITUDE = null;
    public static final RecordAmplitudeType AMPLITUDE_CALL = null;
    public static final RecordAmplitudeType AMPLITUDE_METER = null;
    public static final RecordAmplitudeType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordAmplitudeType[] f243712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243713b = null;

    public static EnumEntries<RecordAmplitudeType> getEntries() {
        return f243713b;
    }

    static {
        RecordAmplitudeType r100 = new RecordAmplitudeType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        RecordAmplitudeType r101 = new RecordAmplitudeType("AMPLITUDE", 1);
        AMPLITUDE = r101;
        RecordAmplitudeType r102 = new RecordAmplitudeType("AMPLITUDE_CALL", 2);
        AMPLITUDE_CALL = r102;
        RecordAmplitudeType r103 = new RecordAmplitudeType("AMPLITUDE_METER", 3);
        AMPLITUDE_METER = r103;
        RecordAmplitudeType[] r104 = {r100, r101, r102, r103};
        f243712a = r104;
        f243713b = EnumEntriesKt.enumEntries(r104);
    }

    public static RecordAmplitudeType[] values() {
        return (RecordAmplitudeType[]) f243712a.clone();
    }

    public static RecordAmplitudeType valueOf(String r100) {
        return (RecordAmplitudeType) r27.a.a(RecordAmplitudeType.class, r100);
    }

    public RecordAmplitudeType(String r100, int r101) {
        super(r100, r101);
    }
}
