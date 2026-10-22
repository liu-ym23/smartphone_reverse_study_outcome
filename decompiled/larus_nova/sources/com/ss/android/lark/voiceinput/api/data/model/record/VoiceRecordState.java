package com.ss.android.lark.voiceinput.api.data.model.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/model/record/VoiceRecordState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Preparing", "Prepared", "Recording", "Stopped", "Canceled", "Failed", "Destroy", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRecordState extends Enum<VoiceRecordState> {
    public static final VoiceRecordState Canceled = null;
    public static final VoiceRecordState Destroy = null;
    public static final VoiceRecordState Failed = null;
    public static final VoiceRecordState Idle = null;
    public static final VoiceRecordState Prepared = null;
    public static final VoiceRecordState Preparing = null;
    public static final VoiceRecordState Recording = null;
    public static final VoiceRecordState Stopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRecordState[] f445036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445037b = null;

    public static EnumEntries<VoiceRecordState> getEntries() {
        return f445037b;
    }

    static {
        VoiceRecordState r100 = new VoiceRecordState("Idle", 0);
        Idle = r100;
        VoiceRecordState r101 = new VoiceRecordState("Preparing", 1);
        Preparing = r101;
        VoiceRecordState r102 = new VoiceRecordState("Prepared", 2);
        Prepared = r102;
        VoiceRecordState r103 = new VoiceRecordState("Recording", 3);
        Recording = r103;
        VoiceRecordState r104 = new VoiceRecordState("Stopped", 4);
        Stopped = r104;
        VoiceRecordState r105 = new VoiceRecordState("Canceled", 5);
        Canceled = r105;
        VoiceRecordState r110 = new VoiceRecordState("Failed", 6);
        Failed = r110;
        VoiceRecordState r111 = new VoiceRecordState("Destroy", 7);
        Destroy = r111;
        VoiceRecordState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f445036a = r112;
        f445037b = EnumEntriesKt.enumEntries(r112);
    }

    public static VoiceRecordState[] values() {
        return (VoiceRecordState[]) f445036a.clone();
    }

    public static VoiceRecordState valueOf(String r100) {
        return (VoiceRecordState) a.a(VoiceRecordState.class, r100);
    }

    public VoiceRecordState(String r100, int r101) {
        super(r100, r101);
    }
}
