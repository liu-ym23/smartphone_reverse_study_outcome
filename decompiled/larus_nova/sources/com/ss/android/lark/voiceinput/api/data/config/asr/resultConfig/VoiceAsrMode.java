package com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/config/asr/resultConfig/VoiceAsrMode;", "", "<init>", "(Ljava/lang/String;I)V", "FinalOnly", "Streaming", "TwoPass", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceAsrMode extends Enum<VoiceAsrMode> {
    public static final VoiceAsrMode FinalOnly = null;
    public static final VoiceAsrMode Streaming = null;
    public static final VoiceAsrMode TwoPass = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceAsrMode[] f445022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445023b = null;

    public static EnumEntries<VoiceAsrMode> getEntries() {
        return f445023b;
    }

    static {
        VoiceAsrMode r100 = new VoiceAsrMode("FinalOnly", 0);
        FinalOnly = r100;
        VoiceAsrMode r101 = new VoiceAsrMode("Streaming", 1);
        Streaming = r101;
        VoiceAsrMode r102 = new VoiceAsrMode("TwoPass", 2);
        TwoPass = r102;
        VoiceAsrMode[] r103 = {r100, r101, r102};
        f445022a = r103;
        f445023b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceAsrMode[] values() {
        return (VoiceAsrMode[]) f445022a.clone();
    }

    public static VoiceAsrMode valueOf(String r100) {
        return (VoiceAsrMode) a.a(VoiceAsrMode.class, r100);
    }

    public VoiceAsrMode(String r100, int r101) {
        super(r100, r101);
    }
}
