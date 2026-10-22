package com.bytedance.flow_audio.api.business.asr.voiceInput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/voiceInput/FlowVoiceInputStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Prepare", "Starting", "Started", "Idle", "isRecording", "", "()Z", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowVoiceInputStatus extends Enum<FlowVoiceInputStatus> {
    public static final FlowVoiceInputStatus Idle = null;
    public static final FlowVoiceInputStatus Prepare = null;
    public static final FlowVoiceInputStatus Started = null;
    public static final FlowVoiceInputStatus Starting = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowVoiceInputStatus[] f243685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243686b = null;

    public static EnumEntries<FlowVoiceInputStatus> getEntries() {
        return f243686b;
    }

    static {
        FlowVoiceInputStatus r100 = new FlowVoiceInputStatus("Prepare", 0);
        Prepare = r100;
        FlowVoiceInputStatus r101 = new FlowVoiceInputStatus("Starting", 1);
        Starting = r101;
        FlowVoiceInputStatus r102 = new FlowVoiceInputStatus("Started", 2);
        Started = r102;
        FlowVoiceInputStatus r103 = new FlowVoiceInputStatus("Idle", 3);
        Idle = r103;
        FlowVoiceInputStatus[] r104 = {r100, r101, r102, r103};
        f243685a = r104;
        f243686b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlowVoiceInputStatus[] values() {
        return (FlowVoiceInputStatus[]) f243685a.clone();
    }

    public final boolean isRecording() {
        if (this != Starting) goto L5;
    L8:
        return true;
    L5:
        if (this == Started) goto L8;
        return false;
    }

    public static FlowVoiceInputStatus valueOf(String r100) {
        return (FlowVoiceInputStatus) a.a(FlowVoiceInputStatus.class, r100);
    }

    public FlowVoiceInputStatus(String r100, int r101) {
        super(r100, r101);
    }
}
