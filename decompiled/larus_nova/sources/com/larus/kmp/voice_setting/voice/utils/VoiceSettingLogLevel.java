package com.larus.kmp.voice_setting.voice.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/utils/VoiceSettingLogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "ERROR", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingLogLevel extends Enum<VoiceSettingLogLevel> {
    public static final VoiceSettingLogLevel ERROR = null;
    public static final VoiceSettingLogLevel INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingLogLevel[] f355089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355090b = null;

    public static EnumEntries<VoiceSettingLogLevel> getEntries() {
        return f355090b;
    }

    static {
        VoiceSettingLogLevel r100 = new VoiceSettingLogLevel("INFO", 0);
        INFO = r100;
        VoiceSettingLogLevel r101 = new VoiceSettingLogLevel("ERROR", 1);
        ERROR = r101;
        VoiceSettingLogLevel[] r102 = {r100, r101};
        f355089a = r102;
        f355090b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceSettingLogLevel[] values() {
        return (VoiceSettingLogLevel[]) f355089a.clone();
    }

    public static VoiceSettingLogLevel valueOf(String r100) {
        return (VoiceSettingLogLevel) r27.a.a(VoiceSettingLogLevel.class, r100);
    }

    public VoiceSettingLogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
