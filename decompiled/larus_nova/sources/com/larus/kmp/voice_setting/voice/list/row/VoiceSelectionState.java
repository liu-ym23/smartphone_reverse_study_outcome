package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoiceSelectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNSELECTED", "SELECTING", "SELECTED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSelectionState extends Enum<VoiceSelectionState> {
    public static final VoiceSelectionState SELECTED = null;
    public static final VoiceSelectionState SELECTING = null;
    public static final VoiceSelectionState UNSELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSelectionState[] f353605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353606b = null;

    public static EnumEntries<VoiceSelectionState> getEntries() {
        return f353606b;
    }

    static {
        VoiceSelectionState r100 = new VoiceSelectionState("UNSELECTED", 0);
        UNSELECTED = r100;
        VoiceSelectionState r101 = new VoiceSelectionState("SELECTING", 1);
        SELECTING = r101;
        VoiceSelectionState r102 = new VoiceSelectionState("SELECTED", 2);
        SELECTED = r102;
        VoiceSelectionState[] r103 = {r100, r101, r102};
        f353605a = r103;
        f353606b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceSelectionState[] values() {
        return (VoiceSelectionState[]) f353605a.clone();
    }

    public static VoiceSelectionState valueOf(String r100) {
        return (VoiceSelectionState) r27.a.a(VoiceSelectionState.class, r100);
    }

    public VoiceSelectionState(String r100, int r101) {
        super(r100, r101);
    }
}
