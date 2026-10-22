package com.larus.kmp.voice_setting.voice.entry;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/entry/VoiceActivityFragmentKind;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "DOUBLE_TAB", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceActivityFragmentKind extends Enum<VoiceActivityFragmentKind> {
    public static final VoiceActivityFragmentKind DOUBLE_TAB = null;
    public static final VoiceActivityFragmentKind SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceActivityFragmentKind[] f353272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353273b = null;

    public static EnumEntries<VoiceActivityFragmentKind> getEntries() {
        return f353273b;
    }

    static {
        VoiceActivityFragmentKind r100 = new VoiceActivityFragmentKind("SINGLE", 0);
        SINGLE = r100;
        VoiceActivityFragmentKind r101 = new VoiceActivityFragmentKind("DOUBLE_TAB", 1);
        DOUBLE_TAB = r101;
        VoiceActivityFragmentKind[] r102 = {r100, r101};
        f353272a = r102;
        f353273b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceActivityFragmentKind[] values() {
        return (VoiceActivityFragmentKind[]) f353272a.clone();
    }

    public static VoiceActivityFragmentKind valueOf(String r100) {
        return (VoiceActivityFragmentKind) a.a(VoiceActivityFragmentKind.class, r100);
    }

    public VoiceActivityFragmentKind(String r100, int r101) {
        super(r100, r101);
    }
}
