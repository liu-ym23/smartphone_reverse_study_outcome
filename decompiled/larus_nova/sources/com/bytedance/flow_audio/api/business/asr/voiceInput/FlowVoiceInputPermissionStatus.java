package com.bytedance.flow_audio.api.business.asr.voiceInput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/voiceInput/FlowVoiceInputPermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Denied", "Undetermined", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowVoiceInputPermissionStatus extends Enum<FlowVoiceInputPermissionStatus> {
    public static final FlowVoiceInputPermissionStatus Denied = null;
    public static final FlowVoiceInputPermissionStatus Undetermined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowVoiceInputPermissionStatus[] f243681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243682b = null;

    public static EnumEntries<FlowVoiceInputPermissionStatus> getEntries() {
        return f243682b;
    }

    static {
        FlowVoiceInputPermissionStatus r100 = new FlowVoiceInputPermissionStatus("Denied", 0);
        Denied = r100;
        FlowVoiceInputPermissionStatus r101 = new FlowVoiceInputPermissionStatus("Undetermined", 1);
        Undetermined = r101;
        FlowVoiceInputPermissionStatus[] r102 = {r100, r101};
        f243681a = r102;
        f243682b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowVoiceInputPermissionStatus[] values() {
        return (FlowVoiceInputPermissionStatus[]) f243681a.clone();
    }

    public static FlowVoiceInputPermissionStatus valueOf(String r100) {
        return (FlowVoiceInputPermissionStatus) a.a(FlowVoiceInputPermissionStatus.class, r100);
    }

    public FlowVoiceInputPermissionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
