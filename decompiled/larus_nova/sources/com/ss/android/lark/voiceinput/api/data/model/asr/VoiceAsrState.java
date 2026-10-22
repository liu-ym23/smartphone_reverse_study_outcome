package com.ss.android.lark.voiceinput.api.data.model.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/model/asr/VoiceAsrState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Preparing", "Prepared", "Streaming", "Finishing", "Finished", "TimedOut", "SwitchLanguage", "Canceled", "Failed", "Destroy", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceAsrState extends Enum<VoiceAsrState> {
    public static final VoiceAsrState Canceled = null;
    public static final VoiceAsrState Destroy = null;
    public static final VoiceAsrState Failed = null;
    public static final VoiceAsrState Finished = null;
    public static final VoiceAsrState Finishing = null;
    public static final VoiceAsrState Idle = null;
    public static final VoiceAsrState Prepared = null;
    public static final VoiceAsrState Preparing = null;
    public static final VoiceAsrState Streaming = null;
    public static final VoiceAsrState SwitchLanguage = null;
    public static final VoiceAsrState TimedOut = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceAsrState[] f445034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445035b = null;

    public static EnumEntries<VoiceAsrState> getEntries() {
        return f445035b;
    }

    static {
        VoiceAsrState r100 = new VoiceAsrState("Idle", 0);
        Idle = r100;
        VoiceAsrState r101 = new VoiceAsrState("Preparing", 1);
        Preparing = r101;
        VoiceAsrState r102 = new VoiceAsrState("Prepared", 2);
        Prepared = r102;
        VoiceAsrState r103 = new VoiceAsrState("Streaming", 3);
        Streaming = r103;
        VoiceAsrState r104 = new VoiceAsrState("Finishing", 4);
        Finishing = r104;
        VoiceAsrState r105 = new VoiceAsrState("Finished", 5);
        Finished = r105;
        VoiceAsrState r110 = new VoiceAsrState("TimedOut", 6);
        TimedOut = r110;
        VoiceAsrState r111 = new VoiceAsrState("SwitchLanguage", 7);
        SwitchLanguage = r111;
        VoiceAsrState r112 = new VoiceAsrState("Canceled", 8);
        Canceled = r112;
        VoiceAsrState r113 = new VoiceAsrState("Failed", 9);
        Failed = r113;
        VoiceAsrState r114 = new VoiceAsrState("Destroy", 10);
        Destroy = r114;
        VoiceAsrState[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f445034a = r115;
        f445035b = EnumEntriesKt.enumEntries(r115);
    }

    public static VoiceAsrState[] values() {
        return (VoiceAsrState[]) f445034a.clone();
    }

    public static VoiceAsrState valueOf(String r100) {
        return (VoiceAsrState) a.a(VoiceAsrState.class, r100);
    }

    public VoiceAsrState(String r100, int r101) {
        super(r100, r101);
    }
}
