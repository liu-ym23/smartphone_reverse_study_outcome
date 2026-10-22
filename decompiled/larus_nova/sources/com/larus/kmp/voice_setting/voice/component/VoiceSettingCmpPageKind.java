package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceSettingCmpPageKind;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "DOUBLE_TAB", "PUBLIC_LIST", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingCmpPageKind extends Enum<VoiceSettingCmpPageKind> {
    public static final VoiceSettingCmpPageKind DOUBLE_TAB = null;
    public static final VoiceSettingCmpPageKind PUBLIC_LIST = null;
    public static final VoiceSettingCmpPageKind SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceSettingCmpPageKind[] f352107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352108b = null;

    public static EnumEntries<VoiceSettingCmpPageKind> getEntries() {
        return f352108b;
    }

    static {
        VoiceSettingCmpPageKind r100 = new VoiceSettingCmpPageKind("SINGLE", 0);
        SINGLE = r100;
        VoiceSettingCmpPageKind r101 = new VoiceSettingCmpPageKind("DOUBLE_TAB", 1);
        DOUBLE_TAB = r101;
        VoiceSettingCmpPageKind r102 = new VoiceSettingCmpPageKind("PUBLIC_LIST", 2);
        PUBLIC_LIST = r102;
        VoiceSettingCmpPageKind[] r103 = {r100, r101, r102};
        f352107a = r103;
        f352108b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceSettingCmpPageKind[] values() {
        return (VoiceSettingCmpPageKind[]) f352107a.clone();
    }

    public static VoiceSettingCmpPageKind valueOf(String r100) {
        return (VoiceSettingCmpPageKind) r27.a.a(VoiceSettingCmpPageKind.class, r100);
    }

    public VoiceSettingCmpPageKind(String r100, int r101) {
        super(r100, r101);
    }
}
