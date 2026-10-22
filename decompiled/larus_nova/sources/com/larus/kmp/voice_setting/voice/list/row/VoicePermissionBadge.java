package com.larus.kmp.voice_setting.voice.list.row;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoicePermissionBadge;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PRIVATE", "HOT", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoicePermissionBadge extends Enum<VoicePermissionBadge> {
    public static final VoicePermissionBadge HOT = null;
    public static final VoicePermissionBadge NONE = null;
    public static final VoicePermissionBadge PRIVATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoicePermissionBadge[] f353601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353602b = null;

    public static EnumEntries<VoicePermissionBadge> getEntries() {
        return f353602b;
    }

    static {
        VoicePermissionBadge r100 = new VoicePermissionBadge(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoicePermissionBadge r101 = new VoicePermissionBadge("PRIVATE", 1);
        PRIVATE = r101;
        VoicePermissionBadge r102 = new VoicePermissionBadge("HOT", 2);
        HOT = r102;
        VoicePermissionBadge[] r103 = {r100, r101, r102};
        f353601a = r103;
        f353602b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoicePermissionBadge[] values() {
        return (VoicePermissionBadge[]) f353601a.clone();
    }

    public static VoicePermissionBadge valueOf(String r100) {
        return (VoicePermissionBadge) r27.a.a(VoicePermissionBadge.class, r100);
    }

    public VoicePermissionBadge(String r100, int r101) {
        super(r100, r101);
    }
}
