package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoiceStatusTone;", "", "<init>", "(Ljava/lang/String;I)V", "NEUTRAL", "DANGER", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceStatusTone extends Enum<VoiceStatusTone> {
    public static final VoiceStatusTone DANGER = null;
    public static final VoiceStatusTone NEUTRAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceStatusTone[] f353609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353610b = null;

    public static EnumEntries<VoiceStatusTone> getEntries() {
        return f353610b;
    }

    static {
        VoiceStatusTone r100 = new VoiceStatusTone("NEUTRAL", 0);
        NEUTRAL = r100;
        VoiceStatusTone r101 = new VoiceStatusTone("DANGER", 1);
        DANGER = r101;
        VoiceStatusTone[] r102 = {r100, r101};
        f353609a = r102;
        f353610b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceStatusTone[] values() {
        return (VoiceStatusTone[]) f353609a.clone();
    }

    public static VoiceStatusTone valueOf(String r100) {
        return (VoiceStatusTone) r27.a.a(VoiceStatusTone.class, r100);
    }

    public VoiceStatusTone(String r100, int r101) {
        super(r100, r101);
    }
}
