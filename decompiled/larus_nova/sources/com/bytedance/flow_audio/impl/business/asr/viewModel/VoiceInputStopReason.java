package com.bytedance.flow_audio.impl.business.asr.viewModel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/asr/viewModel/VoiceInputStopReason;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Cancel", "Interrupt", "FailToStartRecorder", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum VoiceInputStopReason extends Enum<VoiceInputStopReason> {
    public static final VoiceInputStopReason Cancel = null;
    public static final VoiceInputStopReason FailToStartRecorder = null;
    public static final VoiceInputStopReason Interrupt = null;
    public static final VoiceInputStopReason Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceInputStopReason[] f244023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f244024b = null;

    public static EnumEntries<VoiceInputStopReason> getEntries() {
        return f244024b;
    }

    static {
        VoiceInputStopReason r100 = new VoiceInputStopReason("Normal", 0);
        Normal = r100;
        VoiceInputStopReason r101 = new VoiceInputStopReason("Cancel", 1);
        Cancel = r101;
        VoiceInputStopReason r102 = new VoiceInputStopReason("Interrupt", 2);
        Interrupt = r102;
        VoiceInputStopReason r103 = new VoiceInputStopReason("FailToStartRecorder", 3);
        FailToStartRecorder = r103;
        VoiceInputStopReason[] r104 = {r100, r101, r102, r103};
        f244023a = r104;
        f244024b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceInputStopReason[] values() {
        return (VoiceInputStopReason[]) f244023a.clone();
    }

    public static VoiceInputStopReason valueOf(String r100) {
        return (VoiceInputStopReason) r27.a.a(VoiceInputStopReason.class, r100);
    }

    public VoiceInputStopReason(String r100, int r101) {
        super(r100, r101);
    }
}
