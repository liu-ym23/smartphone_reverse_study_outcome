package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceShellFeedbackKind;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "FAILURE", "SUCCESS", "SHOW", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceShellFeedbackKind extends Enum<VoiceShellFeedbackKind> {
    public static final VoiceShellFeedbackKind FAILURE = null;
    public static final VoiceShellFeedbackKind SHOW = null;
    public static final VoiceShellFeedbackKind SUCCESS = null;
    public static final VoiceShellFeedbackKind WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceShellFeedbackKind[] f352109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352110b = null;

    public static EnumEntries<VoiceShellFeedbackKind> getEntries() {
        return f352110b;
    }

    static {
        VoiceShellFeedbackKind r100 = new VoiceShellFeedbackKind("WARNING", 0);
        WARNING = r100;
        VoiceShellFeedbackKind r101 = new VoiceShellFeedbackKind("FAILURE", 1);
        FAILURE = r101;
        VoiceShellFeedbackKind r102 = new VoiceShellFeedbackKind("SUCCESS", 2);
        SUCCESS = r102;
        VoiceShellFeedbackKind r103 = new VoiceShellFeedbackKind("SHOW", 3);
        SHOW = r103;
        VoiceShellFeedbackKind[] r104 = {r100, r101, r102, r103};
        f352109a = r104;
        f352110b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceShellFeedbackKind[] values() {
        return (VoiceShellFeedbackKind[]) f352109a.clone();
    }

    public static VoiceShellFeedbackKind valueOf(String r100) {
        return (VoiceShellFeedbackKind) r27.a.a(VoiceShellFeedbackKind.class, r100);
    }

    public VoiceShellFeedbackKind(String r100, int r101) {
        super(r100, r101);
    }
}
