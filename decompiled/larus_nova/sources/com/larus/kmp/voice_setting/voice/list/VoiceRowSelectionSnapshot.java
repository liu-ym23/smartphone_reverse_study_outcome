package com.larus.kmp.voice_setting.voice.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceRowSelectionSnapshot;", "", "<init>", "(Ljava/lang/String;I)V", "UNSELECTED", "SELECTING", "SELECTED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowSelectionSnapshot extends Enum<VoiceRowSelectionSnapshot> {
    public static final VoiceRowSelectionSnapshot SELECTED = null;
    public static final VoiceRowSelectionSnapshot SELECTING = null;
    public static final VoiceRowSelectionSnapshot UNSELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowSelectionSnapshot[] f353413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353414b = null;

    public static EnumEntries<VoiceRowSelectionSnapshot> getEntries() {
        return f353414b;
    }

    static {
        VoiceRowSelectionSnapshot r100 = new VoiceRowSelectionSnapshot("UNSELECTED", 0);
        UNSELECTED = r100;
        VoiceRowSelectionSnapshot r101 = new VoiceRowSelectionSnapshot("SELECTING", 1);
        SELECTING = r101;
        VoiceRowSelectionSnapshot r102 = new VoiceRowSelectionSnapshot("SELECTED", 2);
        SELECTED = r102;
        VoiceRowSelectionSnapshot[] r103 = {r100, r101, r102};
        f353413a = r103;
        f353414b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceRowSelectionSnapshot[] values() {
        return (VoiceRowSelectionSnapshot[]) f353413a.clone();
    }

    public static VoiceRowSelectionSnapshot valueOf(String r100) {
        return (VoiceRowSelectionSnapshot) a.a(VoiceRowSelectionSnapshot.class, r100);
    }

    public VoiceRowSelectionSnapshot(String r100, int r101) {
        super(r100, r101);
    }
}
