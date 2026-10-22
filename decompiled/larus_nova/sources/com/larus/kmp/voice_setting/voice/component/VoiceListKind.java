package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceListKind;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "SINGLE_SCREEN", "PUBLIC", "MANAGED", "DOUBLE_TAB", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceListKind extends Enum<VoiceListKind> {
    public static final VoiceListKind DOUBLE_TAB = null;
    public static final VoiceListKind MANAGED = null;
    public static final VoiceListKind PUBLIC = null;
    public static final VoiceListKind SINGLE_SCREEN = null;
    public static final VoiceListKind UNSPECIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceListKind[] f352085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352086b = null;

    public static EnumEntries<VoiceListKind> getEntries() {
        return f352086b;
    }

    static {
        VoiceListKind r100 = new VoiceListKind("UNSPECIFIED", 0);
        UNSPECIFIED = r100;
        VoiceListKind r101 = new VoiceListKind("SINGLE_SCREEN", 1);
        SINGLE_SCREEN = r101;
        VoiceListKind r102 = new VoiceListKind("PUBLIC", 2);
        PUBLIC = r102;
        VoiceListKind r103 = new VoiceListKind("MANAGED", 3);
        MANAGED = r103;
        VoiceListKind r104 = new VoiceListKind("DOUBLE_TAB", 4);
        DOUBLE_TAB = r104;
        VoiceListKind[] r105 = {r100, r101, r102, r103, r104};
        f352085a = r105;
        f352086b = EnumEntriesKt.enumEntries(r105);
    }

    public static VoiceListKind[] values() {
        return (VoiceListKind[]) f352085a.clone();
    }

    public static VoiceListKind valueOf(String r100) {
        return (VoiceListKind) r27.a.a(VoiceListKind.class, r100);
    }

    public VoiceListKind(String r100, int r101) {
        super(r100, r101);
    }
}
