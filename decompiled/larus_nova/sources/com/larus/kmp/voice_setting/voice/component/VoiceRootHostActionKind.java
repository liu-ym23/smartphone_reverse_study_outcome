package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceRootHostActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "BACK", "FINISH", "PAUSE", "ROUTE_REQUESTED", "ROUTE_CHANGED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRootHostActionKind extends Enum<VoiceRootHostActionKind> {
    public static final VoiceRootHostActionKind BACK = null;
    public static final VoiceRootHostActionKind FINISH = null;
    public static final VoiceRootHostActionKind NONE = null;
    public static final VoiceRootHostActionKind PAUSE = null;
    public static final VoiceRootHostActionKind ROUTE_CHANGED = null;
    public static final VoiceRootHostActionKind ROUTE_REQUESTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRootHostActionKind[] f352101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352102b = null;

    public static EnumEntries<VoiceRootHostActionKind> getEntries() {
        return f352102b;
    }

    static {
        VoiceRootHostActionKind r100 = new VoiceRootHostActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceRootHostActionKind r101 = new VoiceRootHostActionKind("BACK", 1);
        BACK = r101;
        VoiceRootHostActionKind r102 = new VoiceRootHostActionKind("FINISH", 2);
        FINISH = r102;
        VoiceRootHostActionKind r103 = new VoiceRootHostActionKind("PAUSE", 3);
        PAUSE = r103;
        VoiceRootHostActionKind r104 = new VoiceRootHostActionKind("ROUTE_REQUESTED", 4);
        ROUTE_REQUESTED = r104;
        VoiceRootHostActionKind r105 = new VoiceRootHostActionKind("ROUTE_CHANGED", 5);
        ROUTE_CHANGED = r105;
        VoiceRootHostActionKind[] r110 = {r100, r101, r102, r103, r104, r105};
        f352101a = r110;
        f352102b = EnumEntriesKt.enumEntries(r110);
    }

    public static VoiceRootHostActionKind[] values() {
        return (VoiceRootHostActionKind[]) f352101a.clone();
    }

    public static VoiceRootHostActionKind valueOf(String r100) {
        return (VoiceRootHostActionKind) r27.a.a(VoiceRootHostActionKind.class, r100);
    }

    public VoiceRootHostActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
