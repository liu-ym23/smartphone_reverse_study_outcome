package com.larus.kmp.voice_setting.voice.mix;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/mix/VoiceMixPlayVisualState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Playing", "Loading", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceMixPlayVisualState extends Enum<VoiceMixPlayVisualState> {
    public static final VoiceMixPlayVisualState Idle = null;
    public static final VoiceMixPlayVisualState Loading = null;
    public static final VoiceMixPlayVisualState Playing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceMixPlayVisualState[] f353736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353737b = null;

    public static EnumEntries<VoiceMixPlayVisualState> getEntries() {
        return f353737b;
    }

    static {
        VoiceMixPlayVisualState r100 = new VoiceMixPlayVisualState("Idle", 0);
        Idle = r100;
        VoiceMixPlayVisualState r101 = new VoiceMixPlayVisualState("Playing", 1);
        Playing = r101;
        VoiceMixPlayVisualState r102 = new VoiceMixPlayVisualState("Loading", 2);
        Loading = r102;
        VoiceMixPlayVisualState[] r103 = {r100, r101, r102};
        f353736a = r103;
        f353737b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceMixPlayVisualState[] values() {
        return (VoiceMixPlayVisualState[]) f353736a.clone();
    }

    public static VoiceMixPlayVisualState valueOf(String r100) {
        return (VoiceMixPlayVisualState) r27.a.a(VoiceMixPlayVisualState.class, r100);
    }

    public VoiceMixPlayVisualState(String r100, int r101) {
        super(r100, r101);
    }
}
