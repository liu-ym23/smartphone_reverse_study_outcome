package com.larus.kmp.voice_setting.voice.list;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceRowInteractionAction;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "ADD", "REMOVE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowInteractionAction extends Enum<VoiceRowInteractionAction> {
    public static final VoiceRowInteractionAction ADD = null;
    public static final VoiceRowInteractionAction NONE = null;
    public static final VoiceRowInteractionAction REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowInteractionAction[] f353409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353410b = null;

    public static EnumEntries<VoiceRowInteractionAction> getEntries() {
        return f353410b;
    }

    static {
        VoiceRowInteractionAction r100 = new VoiceRowInteractionAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceRowInteractionAction r101 = new VoiceRowInteractionAction("ADD", 1);
        ADD = r101;
        VoiceRowInteractionAction r102 = new VoiceRowInteractionAction("REMOVE", 2);
        REMOVE = r102;
        VoiceRowInteractionAction[] r103 = {r100, r101, r102};
        f353409a = r103;
        f353410b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceRowInteractionAction[] values() {
        return (VoiceRowInteractionAction[]) f353409a.clone();
    }

    public static VoiceRowInteractionAction valueOf(String r100) {
        return (VoiceRowInteractionAction) a.a(VoiceRowInteractionAction.class, r100);
    }

    public VoiceRowInteractionAction(String r100, int r101) {
        super(r100, r101);
    }
}
