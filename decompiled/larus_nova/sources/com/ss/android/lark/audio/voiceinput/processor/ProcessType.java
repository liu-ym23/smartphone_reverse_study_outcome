package com.ss.android.lark.audio.voiceinput.processor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/processor/ProcessType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "VoiceWithAsr", "OnlyVoice", "OnlyAsr", "Extend", "toString", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProcessType extends Enum<ProcessType> {
    public static final ProcessType Extend = null;
    public static final ProcessType OnlyAsr = null;
    public static final ProcessType OnlyVoice = null;
    public static final ProcessType VoiceWithAsr = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProcessType[] f409334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409335b = null;
    private final int type;

    public static EnumEntries<ProcessType> getEntries() {
        return f409335b;
    }

    static {
        ProcessType r100 = new ProcessType("VoiceWithAsr", 0, 0);
        VoiceWithAsr = r100;
        ProcessType r101 = new ProcessType("OnlyVoice", 1, 1);
        OnlyVoice = r101;
        ProcessType r102 = new ProcessType("OnlyAsr", 2, 2);
        OnlyAsr = r102;
        ProcessType r103 = new ProcessType("Extend", 3, 3);
        Extend = r103;
        ProcessType[] r104 = {r100, r101, r102, r103};
        f409334a = r104;
        f409335b = EnumEntriesKt.enumEntries(r104);
    }

    public static ProcessType[] values() {
        return (ProcessType[]) f409334a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.type;
        if (r100 != 0) goto L5;
        return "VoiceWithAsr";
    L5:
        if (r100 != 1) goto L7;
        return "OnlyVoice";
    L7:
        if (r100 != 2) goto L9;
        return "OnlyAsr";
    L9:
        if (r100 != 3) goto L18;
        return "Extend";
    L18:
        return "OnlyVoice";
    }

    public static ProcessType valueOf(String r100) {
        return (ProcessType) r27.a.a(ProcessType.class, r100);
    }

    public ProcessType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
