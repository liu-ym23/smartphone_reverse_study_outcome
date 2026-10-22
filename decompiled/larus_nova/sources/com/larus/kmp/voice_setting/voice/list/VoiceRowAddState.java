package com.larus.kmp.voice_setting.voice.list;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceRowAddState;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "READY", "ADDED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowAddState extends Enum<VoiceRowAddState> {
    public static final VoiceRowAddState ADDED = null;
    public static final VoiceRowAddState NONE = null;
    public static final VoiceRowAddState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowAddState[] f353407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353408b = null;

    public static EnumEntries<VoiceRowAddState> getEntries() {
        return f353408b;
    }

    static {
        VoiceRowAddState r100 = new VoiceRowAddState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceRowAddState r101 = new VoiceRowAddState("READY", 1);
        READY = r101;
        VoiceRowAddState r102 = new VoiceRowAddState("ADDED", 2);
        ADDED = r102;
        VoiceRowAddState[] r103 = {r100, r101, r102};
        f353407a = r103;
        f353408b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceRowAddState[] values() {
        return (VoiceRowAddState[]) f353407a.clone();
    }

    public static VoiceRowAddState valueOf(String r100) {
        return (VoiceRowAddState) a.a(VoiceRowAddState.class, r100);
    }

    public VoiceRowAddState(String r100, int r101) {
        super(r100, r101);
    }
}
