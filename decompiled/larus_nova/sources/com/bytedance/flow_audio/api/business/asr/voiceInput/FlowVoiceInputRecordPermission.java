package com.bytedance.flow_audio.api.business.asr.voiceInput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/voiceInput/FlowVoiceInputRecordPermission;", "", "<init>", "(Ljava/lang/String;I)V", "Denied", "Undetermined", "Granted", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowVoiceInputRecordPermission extends Enum<FlowVoiceInputRecordPermission> {
    public static final FlowVoiceInputRecordPermission Denied = null;
    public static final FlowVoiceInputRecordPermission Granted = null;
    public static final FlowVoiceInputRecordPermission Undetermined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowVoiceInputRecordPermission[] f243683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243684b = null;

    public static EnumEntries<FlowVoiceInputRecordPermission> getEntries() {
        return f243684b;
    }

    static {
        FlowVoiceInputRecordPermission r100 = new FlowVoiceInputRecordPermission("Denied", 0);
        Denied = r100;
        FlowVoiceInputRecordPermission r101 = new FlowVoiceInputRecordPermission("Undetermined", 1);
        Undetermined = r101;
        FlowVoiceInputRecordPermission r102 = new FlowVoiceInputRecordPermission("Granted", 2);
        Granted = r102;
        FlowVoiceInputRecordPermission[] r103 = {r100, r101, r102};
        f243683a = r103;
        f243684b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowVoiceInputRecordPermission[] values() {
        return (FlowVoiceInputRecordPermission[]) f243683a.clone();
    }

    public static FlowVoiceInputRecordPermission valueOf(String r100) {
        return (FlowVoiceInputRecordPermission) a.a(FlowVoiceInputRecordPermission.class, r100);
    }

    public FlowVoiceInputRecordPermission(String r100, int r101) {
        super(r100, r101);
    }
}
