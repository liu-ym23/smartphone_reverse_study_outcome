package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoiceAddButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "READY_ENABLED", "READY_DISABLED", "ADDED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceAddButtonState extends Enum<VoiceAddButtonState> {
    public static final VoiceAddButtonState ADDED = null;
    public static final VoiceAddButtonState HIDDEN = null;
    public static final VoiceAddButtonState READY_DISABLED = null;
    public static final VoiceAddButtonState READY_ENABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceAddButtonState[] f353597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353598b = null;

    public static EnumEntries<VoiceAddButtonState> getEntries() {
        return f353598b;
    }

    static {
        VoiceAddButtonState r100 = new VoiceAddButtonState("HIDDEN", 0);
        HIDDEN = r100;
        VoiceAddButtonState r101 = new VoiceAddButtonState("READY_ENABLED", 1);
        READY_ENABLED = r101;
        VoiceAddButtonState r102 = new VoiceAddButtonState("READY_DISABLED", 2);
        READY_DISABLED = r102;
        VoiceAddButtonState r103 = new VoiceAddButtonState("ADDED", 3);
        ADDED = r103;
        VoiceAddButtonState[] r104 = {r100, r101, r102, r103};
        f353597a = r104;
        f353598b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceAddButtonState[] values() {
        return (VoiceAddButtonState[]) f353597a.clone();
    }

    public static VoiceAddButtonState valueOf(String r100) {
        return (VoiceAddButtonState) r27.a.a(VoiceAddButtonState.class, r100);
    }

    public VoiceAddButtonState(String r100, int r101) {
        super(r100, r101);
    }
}
