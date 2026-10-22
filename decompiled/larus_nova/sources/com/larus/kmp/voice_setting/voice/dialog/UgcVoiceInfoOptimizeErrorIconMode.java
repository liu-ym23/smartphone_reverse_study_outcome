package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/UgcVoiceInfoOptimizeErrorIconMode;", "", "<init>", "(Ljava/lang/String;I)V", "PROGRESS", "CHECK", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceInfoOptimizeErrorIconMode extends Enum<UgcVoiceInfoOptimizeErrorIconMode> {
    public static final UgcVoiceInfoOptimizeErrorIconMode CHECK = null;
    public static final UgcVoiceInfoOptimizeErrorIconMode PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceInfoOptimizeErrorIconMode[] f352693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352694b = null;

    public static EnumEntries<UgcVoiceInfoOptimizeErrorIconMode> getEntries() {
        return f352694b;
    }

    static {
        UgcVoiceInfoOptimizeErrorIconMode r100 = new UgcVoiceInfoOptimizeErrorIconMode("PROGRESS", 0);
        PROGRESS = r100;
        UgcVoiceInfoOptimizeErrorIconMode r101 = new UgcVoiceInfoOptimizeErrorIconMode("CHECK", 1);
        CHECK = r101;
        UgcVoiceInfoOptimizeErrorIconMode[] r102 = {r100, r101};
        f352693a = r102;
        f352694b = EnumEntriesKt.enumEntries(r102);
    }

    public static UgcVoiceInfoOptimizeErrorIconMode[] values() {
        return (UgcVoiceInfoOptimizeErrorIconMode[]) f352693a.clone();
    }

    public static UgcVoiceInfoOptimizeErrorIconMode valueOf(String r100) {
        return (UgcVoiceInfoOptimizeErrorIconMode) r27.a.a(UgcVoiceInfoOptimizeErrorIconMode.class, r100);
    }

    public UgcVoiceInfoOptimizeErrorIconMode(String r100, int r101) {
        super(r100, r101);
    }
}
