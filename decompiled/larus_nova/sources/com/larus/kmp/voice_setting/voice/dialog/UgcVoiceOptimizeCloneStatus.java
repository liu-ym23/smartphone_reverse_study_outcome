package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/UgcVoiceOptimizeCloneStatus;", "", "<init>", "(Ljava/lang/String;I)V", "IN_PROGRESS", "AVAILABLE", "FAILED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceOptimizeCloneStatus extends Enum<UgcVoiceOptimizeCloneStatus> {
    public static final UgcVoiceOptimizeCloneStatus AVAILABLE = null;
    public static final UgcVoiceOptimizeCloneStatus FAILED = null;
    public static final UgcVoiceOptimizeCloneStatus IN_PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceOptimizeCloneStatus[] f352695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352696b = null;

    public static EnumEntries<UgcVoiceOptimizeCloneStatus> getEntries() {
        return f352696b;
    }

    static {
        UgcVoiceOptimizeCloneStatus r100 = new UgcVoiceOptimizeCloneStatus("IN_PROGRESS", 0);
        IN_PROGRESS = r100;
        UgcVoiceOptimizeCloneStatus r101 = new UgcVoiceOptimizeCloneStatus("AVAILABLE", 1);
        AVAILABLE = r101;
        UgcVoiceOptimizeCloneStatus r102 = new UgcVoiceOptimizeCloneStatus("FAILED", 2);
        FAILED = r102;
        UgcVoiceOptimizeCloneStatus[] r103 = {r100, r101, r102};
        f352695a = r103;
        f352696b = EnumEntriesKt.enumEntries(r103);
    }

    public static UgcVoiceOptimizeCloneStatus[] values() {
        return (UgcVoiceOptimizeCloneStatus[]) f352695a.clone();
    }

    public static UgcVoiceOptimizeCloneStatus valueOf(String r100) {
        return (UgcVoiceOptimizeCloneStatus) r27.a.a(UgcVoiceOptimizeCloneStatus.class, r100);
    }

    public UgcVoiceOptimizeCloneStatus(String r100, int r101) {
        super(r100, r101);
    }
}
