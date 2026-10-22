package com.larus.kmp.voice_setting.voice.list.row;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoicePlayIndicatorPlacement;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TRAILING", "INLINE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoicePlayIndicatorPlacement extends Enum<VoicePlayIndicatorPlacement> {
    public static final VoicePlayIndicatorPlacement INLINE = null;
    public static final VoicePlayIndicatorPlacement NONE = null;
    public static final VoicePlayIndicatorPlacement TRAILING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoicePlayIndicatorPlacement[] f353603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353604b = null;

    public static EnumEntries<VoicePlayIndicatorPlacement> getEntries() {
        return f353604b;
    }

    static {
        VoicePlayIndicatorPlacement r100 = new VoicePlayIndicatorPlacement(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoicePlayIndicatorPlacement r101 = new VoicePlayIndicatorPlacement("TRAILING", 1);
        TRAILING = r101;
        VoicePlayIndicatorPlacement r102 = new VoicePlayIndicatorPlacement("INLINE", 2);
        INLINE = r102;
        VoicePlayIndicatorPlacement[] r103 = {r100, r101, r102};
        f353603a = r103;
        f353604b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoicePlayIndicatorPlacement[] values() {
        return (VoicePlayIndicatorPlacement[]) f353603a.clone();
    }

    public static VoicePlayIndicatorPlacement valueOf(String r100) {
        return (VoicePlayIndicatorPlacement) r27.a.a(VoicePlayIndicatorPlacement.class, r100);
    }

    public VoicePlayIndicatorPlacement(String r100, int r101) {
        super(r100, r101);
    }
}
