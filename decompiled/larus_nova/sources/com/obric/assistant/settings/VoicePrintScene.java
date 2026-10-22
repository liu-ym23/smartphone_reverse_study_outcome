package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/settings/VoicePrintScene;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKE_UP", "VOICE_AUTHENTICATE_ON_LOCKED", "NOISE_REDUCTION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoicePrintScene extends Enum<VoicePrintScene> {
    public static final VoicePrintScene NOISE_REDUCTION = null;
    public static final VoicePrintScene VOICE_AUTHENTICATE_ON_LOCKED = null;
    public static final VoicePrintScene VOICE_WAKE_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoicePrintScene[] f391769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391770b = null;

    public static EnumEntries<VoicePrintScene> getEntries() {
        return f391770b;
    }

    static {
        VoicePrintScene r100 = new VoicePrintScene("VOICE_WAKE_UP", 0);
        VOICE_WAKE_UP = r100;
        VoicePrintScene r101 = new VoicePrintScene("VOICE_AUTHENTICATE_ON_LOCKED", 1);
        VOICE_AUTHENTICATE_ON_LOCKED = r101;
        VoicePrintScene r102 = new VoicePrintScene("NOISE_REDUCTION", 2);
        NOISE_REDUCTION = r102;
        VoicePrintScene[] r103 = {r100, r101, r102};
        f391769a = r103;
        f391770b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoicePrintScene[] values() {
        return (VoicePrintScene[]) f391769a.clone();
    }

    public static VoicePrintScene valueOf(String r100) {
        return (VoicePrintScene) r27.a.a(VoicePrintScene.class, r100);
    }

    public VoicePrintScene(String r100, int r101) {
        super(r100, r101);
    }
}
