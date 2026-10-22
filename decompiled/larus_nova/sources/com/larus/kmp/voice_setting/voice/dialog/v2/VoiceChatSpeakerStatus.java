package com.larus.kmp.voice_setting.voice.dialog.v2;

import com.byted.cast.common.bean.State;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/v2/VoiceChatSpeakerStatus;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, State.RECORDING, "CANCEL", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceChatSpeakerStatus extends Enum<VoiceChatSpeakerStatus> {
    public static final VoiceChatSpeakerStatus CANCEL = null;
    public static final VoiceChatSpeakerStatus NORMAL = null;
    public static final VoiceChatSpeakerStatus RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceChatSpeakerStatus[] f353003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353004b = null;

    public static EnumEntries<VoiceChatSpeakerStatus> getEntries() {
        return f353004b;
    }

    static {
        VoiceChatSpeakerStatus r100 = new VoiceChatSpeakerStatus(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        VoiceChatSpeakerStatus r101 = new VoiceChatSpeakerStatus(State.RECORDING, 1);
        RECORDING = r101;
        VoiceChatSpeakerStatus r102 = new VoiceChatSpeakerStatus("CANCEL", 2);
        CANCEL = r102;
        VoiceChatSpeakerStatus[] r103 = {r100, r101, r102};
        f353003a = r103;
        f353004b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceChatSpeakerStatus[] values() {
        return (VoiceChatSpeakerStatus[]) f353003a.clone();
    }

    public static VoiceChatSpeakerStatus valueOf(String r100) {
        return (VoiceChatSpeakerStatus) r27.a.a(VoiceChatSpeakerStatus.class, r100);
    }

    public VoiceChatSpeakerStatus(String r100, int r101) {
        super(r100, r101);
    }
}
