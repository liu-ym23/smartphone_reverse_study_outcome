package com.larus.kmp.voice_setting.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/platform/VoiceQualityStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PASSED", "AUDIO_RECORD_SILENCED", "OTHER_FAILURE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceQualityStatus extends Enum<VoiceQualityStatus> {
    public static final VoiceQualityStatus AUDIO_RECORD_SILENCED = null;
    public static final VoiceQualityStatus OTHER_FAILURE = null;
    public static final VoiceQualityStatus PASSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceQualityStatus[] f351666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351667b = null;

    public static EnumEntries<VoiceQualityStatus> getEntries() {
        return f351667b;
    }

    static {
        VoiceQualityStatus r100 = new VoiceQualityStatus("PASSED", 0);
        PASSED = r100;
        VoiceQualityStatus r101 = new VoiceQualityStatus("AUDIO_RECORD_SILENCED", 1);
        AUDIO_RECORD_SILENCED = r101;
        VoiceQualityStatus r102 = new VoiceQualityStatus("OTHER_FAILURE", 2);
        OTHER_FAILURE = r102;
        VoiceQualityStatus[] r103 = {r100, r101, r102};
        f351666a = r103;
        f351667b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceQualityStatus[] values() {
        return (VoiceQualityStatus[]) f351666a.clone();
    }

    public static VoiceQualityStatus valueOf(String r100) {
        return (VoiceQualityStatus) r27.a.a(VoiceQualityStatus.class, r100);
    }

    public VoiceQualityStatus(String r100, int r101) {
        super(r100, r101);
    }
}
