package com.larus.kmp.voice_setting.voice.base.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/base/api/VoiceTabSource;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE", "AUDIO_CONFIG", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceTabSource extends Enum<VoiceTabSource> {
    public static final VoiceTabSource AUDIO_CONFIG = null;
    public static final VoiceTabSource CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceTabSource[] f351764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351765b = null;

    public static EnumEntries<VoiceTabSource> getEntries() {
        return f351765b;
    }

    static {
        VoiceTabSource r100 = new VoiceTabSource("CACHE", 0);
        CACHE = r100;
        VoiceTabSource r101 = new VoiceTabSource("AUDIO_CONFIG", 1);
        AUDIO_CONFIG = r101;
        VoiceTabSource[] r102 = {r100, r101};
        f351764a = r102;
        f351765b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceTabSource[] values() {
        return (VoiceTabSource[]) f351764a.clone();
    }

    public static VoiceTabSource valueOf(String r100) {
        return (VoiceTabSource) r27.a.a(VoiceTabSource.class, r100);
    }

    public VoiceTabSource(String r100, int r101) {
        super(r100, r101);
    }
}
