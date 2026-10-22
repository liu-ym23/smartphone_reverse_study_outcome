package com.ss.android.lark.voiceinput.api.data.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/model/VoiceRecordFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA_RESOURCE_UNAVAILABLE", "MICROPHONE_INTERRUPTED", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRecordFailureReason extends Enum<VoiceRecordFailureReason> {
    public static final VoiceRecordFailureReason MEDIA_RESOURCE_UNAVAILABLE = null;
    public static final VoiceRecordFailureReason MICROPHONE_INTERRUPTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRecordFailureReason[] f445032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445033b = null;

    public static EnumEntries<VoiceRecordFailureReason> getEntries() {
        return f445033b;
    }

    static {
        VoiceRecordFailureReason r100 = new VoiceRecordFailureReason("MEDIA_RESOURCE_UNAVAILABLE", 0);
        MEDIA_RESOURCE_UNAVAILABLE = r100;
        VoiceRecordFailureReason r101 = new VoiceRecordFailureReason("MICROPHONE_INTERRUPTED", 1);
        MICROPHONE_INTERRUPTED = r101;
        VoiceRecordFailureReason[] r102 = {r100, r101};
        f445032a = r102;
        f445033b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceRecordFailureReason[] values() {
        return (VoiceRecordFailureReason[]) f445032a.clone();
    }

    public static VoiceRecordFailureReason valueOf(String r100) {
        return (VoiceRecordFailureReason) a.a(VoiceRecordFailureReason.class, r100);
    }

    public VoiceRecordFailureReason(String r100, int r101) {
        super(r100, r101);
    }
}
