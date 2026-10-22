package com.larus.kmp.voice_setting.voice.dialog.v2;

import com.byted.cast.common.bean.State;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/v2/UgcVoiceCreateVisualState;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, State.RECORDING, "VERIFYING", "FAILURE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceCreateVisualState extends Enum<UgcVoiceCreateVisualState> {
    public static final UgcVoiceCreateVisualState FAILURE = null;
    public static final UgcVoiceCreateVisualState NORMAL = null;
    public static final UgcVoiceCreateVisualState RECORDING = null;
    public static final UgcVoiceCreateVisualState VERIFYING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceCreateVisualState[] f353001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353002b = null;

    public static EnumEntries<UgcVoiceCreateVisualState> getEntries() {
        return f353002b;
    }

    static {
        UgcVoiceCreateVisualState r100 = new UgcVoiceCreateVisualState(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        UgcVoiceCreateVisualState r101 = new UgcVoiceCreateVisualState(State.RECORDING, 1);
        RECORDING = r101;
        UgcVoiceCreateVisualState r102 = new UgcVoiceCreateVisualState("VERIFYING", 2);
        VERIFYING = r102;
        UgcVoiceCreateVisualState r103 = new UgcVoiceCreateVisualState("FAILURE", 3);
        FAILURE = r103;
        UgcVoiceCreateVisualState[] r104 = {r100, r101, r102, r103};
        f353001a = r104;
        f353002b = EnumEntriesKt.enumEntries(r104);
    }

    public static UgcVoiceCreateVisualState[] values() {
        return (UgcVoiceCreateVisualState[]) f353001a.clone();
    }

    public static UgcVoiceCreateVisualState valueOf(String r100) {
        return (UgcVoiceCreateVisualState) r27.a.a(UgcVoiceCreateVisualState.class, r100);
    }

    public UgcVoiceCreateVisualState(String r100, int r101) {
        super(r100, r101);
    }
}
