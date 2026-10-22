package com.larus.voice_setting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/VoiceSettingRuntimeKind;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "KMP", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingRuntimeKind extends Enum<VoiceSettingRuntimeKind> {
    public static final VoiceSettingRuntimeKind KMP = null;
    public static final VoiceSettingRuntimeKind NATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingRuntimeKind[] f376052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376053b = null;

    public static EnumEntries<VoiceSettingRuntimeKind> getEntries() {
        return f376053b;
    }

    static {
        VoiceSettingRuntimeKind r100 = new VoiceSettingRuntimeKind("NATIVE", 0);
        NATIVE = r100;
        VoiceSettingRuntimeKind r101 = new VoiceSettingRuntimeKind("KMP", 1);
        KMP = r101;
        VoiceSettingRuntimeKind[] r102 = {r100, r101};
        f376052a = r102;
        f376053b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceSettingRuntimeKind[] values() {
        return (VoiceSettingRuntimeKind[]) f376052a.clone();
    }

    public static VoiceSettingRuntimeKind valueOf(String r100) {
        return (VoiceSettingRuntimeKind) a.a(VoiceSettingRuntimeKind.class, r100);
    }

    public VoiceSettingRuntimeKind(String r100, int r101) {
        super(r100, r101);
    }
}
