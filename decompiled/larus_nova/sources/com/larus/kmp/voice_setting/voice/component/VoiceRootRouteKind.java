package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceRootRouteKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SINGLE_SCREEN", "DOUBLE_TAB_SHELL", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRootRouteKind extends Enum<VoiceRootRouteKind> {
    public static final VoiceRootRouteKind DOUBLE_TAB_SHELL = null;
    public static final VoiceRootRouteKind NONE = null;
    public static final VoiceRootRouteKind SINGLE_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRootRouteKind[] f352103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352104b = null;

    public static EnumEntries<VoiceRootRouteKind> getEntries() {
        return f352104b;
    }

    static {
        VoiceRootRouteKind r100 = new VoiceRootRouteKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceRootRouteKind r101 = new VoiceRootRouteKind("SINGLE_SCREEN", 1);
        SINGLE_SCREEN = r101;
        VoiceRootRouteKind r102 = new VoiceRootRouteKind("DOUBLE_TAB_SHELL", 2);
        DOUBLE_TAB_SHELL = r102;
        VoiceRootRouteKind[] r103 = {r100, r101, r102};
        f352103a = r103;
        f352104b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceRootRouteKind[] values() {
        return (VoiceRootRouteKind[]) f352103a.clone();
    }

    public static VoiceRootRouteKind valueOf(String r100) {
        return (VoiceRootRouteKind) r27.a.a(VoiceRootRouteKind.class, r100);
    }

    public VoiceRootRouteKind(String r100, int r101) {
        super(r100, r101);
    }
}
