package com.ss.android.lark.audio.voiceinput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/VoiceInputMode;", "", "inputMode", "", "<init>", "(Ljava/lang/String;II)V", "getInputMode", "()I", "VoiceAndAsr", "OnlyVoice", "OnlyAsr", "SecondVoice", "info", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceInputMode extends Enum<VoiceInputMode> {
    public static final VoiceInputMode OnlyAsr = null;
    public static final VoiceInputMode OnlyVoice = null;
    public static final VoiceInputMode SecondVoice = null;
    public static final VoiceInputMode VoiceAndAsr = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceInputMode[] f409176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409177b = null;
    private final int inputMode;

    public static EnumEntries<VoiceInputMode> getEntries() {
        return f409177b;
    }

    static {
        VoiceInputMode r100 = new VoiceInputMode("VoiceAndAsr", 0, 0);
        VoiceAndAsr = r100;
        VoiceInputMode r101 = new VoiceInputMode("OnlyVoice", 1, 1);
        OnlyVoice = r101;
        VoiceInputMode r102 = new VoiceInputMode("OnlyAsr", 2, 2);
        OnlyAsr = r102;
        VoiceInputMode r103 = new VoiceInputMode("SecondVoice", 3, 3);
        SecondVoice = r103;
        VoiceInputMode[] r104 = {r100, r101, r102, r103};
        f409176a = r104;
        f409177b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceInputMode[] values() {
        return (VoiceInputMode[]) f409176a.clone();
    }

    public final String info() {
        int r100 = this.inputMode;
        if (r100 != 0) goto L5;
        return "VoiceAndAsr";
    L5:
        if (r100 != 1) goto L7;
        return "OnlyVoice";
    L7:
        if (r100 != 2) goto L9;
        return "OnlyAsr";
    L9:
        if (r100 != 3) goto L18;
        return "SecondVoice";
    L18:
        return "VoiceAndAsr";
    }

    public final int getInputMode() {
        return this.inputMode;
    }

    public static VoiceInputMode valueOf(String r100) {
        return (VoiceInputMode) r27.a.a(VoiceInputMode.class, r100);
    }

    public VoiceInputMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.inputMode = r102;
    }
}
