package com.larus.kmp.voice_setting.voice.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/bridge/VoiceSingleScreenSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "RESULT_ONLY", "UPDATE_BOT", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSingleScreenSelectionMode extends Enum<VoiceSingleScreenSelectionMode> {
    public static final VoiceSingleScreenSelectionMode RESULT_ONLY = null;
    public static final VoiceSingleScreenSelectionMode UPDATE_BOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSingleScreenSelectionMode[] f351854a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351855b = null;

    public static EnumEntries<VoiceSingleScreenSelectionMode> getEntries() {
        return f351855b;
    }

    static {
        VoiceSingleScreenSelectionMode r100 = new VoiceSingleScreenSelectionMode("RESULT_ONLY", 0);
        RESULT_ONLY = r100;
        VoiceSingleScreenSelectionMode r101 = new VoiceSingleScreenSelectionMode("UPDATE_BOT", 1);
        UPDATE_BOT = r101;
        VoiceSingleScreenSelectionMode[] r102 = {r100, r101};
        f351854a = r102;
        f351855b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceSingleScreenSelectionMode[] values() {
        return (VoiceSingleScreenSelectionMode[]) f351854a.clone();
    }

    public static VoiceSingleScreenSelectionMode valueOf(String r100) {
        return (VoiceSingleScreenSelectionMode) r27.a.a(VoiceSingleScreenSelectionMode.class, r100);
    }

    public VoiceSingleScreenSelectionMode(String r100, int r101) {
        super(r100, r101);
    }
}
