package com.larus.kmp.voice_setting.voice.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceRowPlayState;", "", "<init>", "(Ljava/lang/String;I)V", "STOPPED", "PLAYING", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowPlayState extends Enum<VoiceRowPlayState> {
    public static final VoiceRowPlayState PLAYING = null;
    public static final VoiceRowPlayState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowPlayState[] f353411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353412b = null;

    public static EnumEntries<VoiceRowPlayState> getEntries() {
        return f353412b;
    }

    static {
        VoiceRowPlayState r100 = new VoiceRowPlayState("STOPPED", 0);
        STOPPED = r100;
        VoiceRowPlayState r101 = new VoiceRowPlayState("PLAYING", 1);
        PLAYING = r101;
        VoiceRowPlayState[] r102 = {r100, r101};
        f353411a = r102;
        f353412b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceRowPlayState[] values() {
        return (VoiceRowPlayState[]) f353411a.clone();
    }

    public static VoiceRowPlayState valueOf(String r100) {
        return (VoiceRowPlayState) a.a(VoiceRowPlayState.class, r100);
    }

    public VoiceRowPlayState(String r100, int r101) {
        super(r100, r101);
    }
}
