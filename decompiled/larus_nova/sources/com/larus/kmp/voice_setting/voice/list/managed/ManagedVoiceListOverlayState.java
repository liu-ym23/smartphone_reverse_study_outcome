package com.larus.kmp.voice_setting.voice.list.managed;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/managed/ManagedVoiceListOverlayState;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "EMPTY", "ERROR", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManagedVoiceListOverlayState extends Enum<ManagedVoiceListOverlayState> {
    public static final ManagedVoiceListOverlayState EMPTY = null;
    public static final ManagedVoiceListOverlayState ERROR = null;
    public static final ManagedVoiceListOverlayState NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManagedVoiceListOverlayState[] f353421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353422b = null;

    public static EnumEntries<ManagedVoiceListOverlayState> getEntries() {
        return f353422b;
    }

    static {
        ManagedVoiceListOverlayState r100 = new ManagedVoiceListOverlayState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ManagedVoiceListOverlayState r101 = new ManagedVoiceListOverlayState("EMPTY", 1);
        EMPTY = r101;
        ManagedVoiceListOverlayState r102 = new ManagedVoiceListOverlayState("ERROR", 2);
        ERROR = r102;
        ManagedVoiceListOverlayState[] r103 = {r100, r101, r102};
        f353421a = r103;
        f353422b = EnumEntriesKt.enumEntries(r103);
    }

    public static ManagedVoiceListOverlayState[] values() {
        return (ManagedVoiceListOverlayState[]) f353421a.clone();
    }

    public static ManagedVoiceListOverlayState valueOf(String r100) {
        return (ManagedVoiceListOverlayState) r27.a.a(ManagedVoiceListOverlayState.class, r100);
    }

    public ManagedVoiceListOverlayState(String r100, int r101) {
        super(r100, r101);
    }
}
