package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceEditAreaLayoutMode;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY_MIX", "SELECTED_SINGLE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceEditAreaLayoutMode extends Enum<VoiceEditAreaLayoutMode> {
    public static final VoiceEditAreaLayoutMode LEGACY_MIX = null;
    public static final VoiceEditAreaLayoutMode SELECTED_SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceEditAreaLayoutMode[] f352074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352075b = null;

    public static EnumEntries<VoiceEditAreaLayoutMode> getEntries() {
        return f352075b;
    }

    static {
        VoiceEditAreaLayoutMode r100 = new VoiceEditAreaLayoutMode("LEGACY_MIX", 0);
        LEGACY_MIX = r100;
        VoiceEditAreaLayoutMode r101 = new VoiceEditAreaLayoutMode("SELECTED_SINGLE", 1);
        SELECTED_SINGLE = r101;
        VoiceEditAreaLayoutMode[] r102 = {r100, r101};
        f352074a = r102;
        f352075b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceEditAreaLayoutMode[] values() {
        return (VoiceEditAreaLayoutMode[]) f352074a.clone();
    }

    public static VoiceEditAreaLayoutMode valueOf(String r100) {
        return (VoiceEditAreaLayoutMode) r27.a.a(VoiceEditAreaLayoutMode.class, r100);
    }

    public VoiceEditAreaLayoutMode(String r100, int r101) {
        super(r100, r101);
    }
}
