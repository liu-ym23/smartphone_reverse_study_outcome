package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceDoubleTabChromeActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "BACK", "SAVE", "CREATE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDoubleTabChromeActionKind extends Enum<VoiceDoubleTabChromeActionKind> {
    public static final VoiceDoubleTabChromeActionKind BACK = null;
    public static final VoiceDoubleTabChromeActionKind CREATE = null;
    public static final VoiceDoubleTabChromeActionKind NONE = null;
    public static final VoiceDoubleTabChromeActionKind SAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDoubleTabChromeActionKind[] f352005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352006b = null;

    public static EnumEntries<VoiceDoubleTabChromeActionKind> getEntries() {
        return f352006b;
    }

    static {
        VoiceDoubleTabChromeActionKind r100 = new VoiceDoubleTabChromeActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceDoubleTabChromeActionKind r101 = new VoiceDoubleTabChromeActionKind("BACK", 1);
        BACK = r101;
        VoiceDoubleTabChromeActionKind r102 = new VoiceDoubleTabChromeActionKind("SAVE", 2);
        SAVE = r102;
        VoiceDoubleTabChromeActionKind r103 = new VoiceDoubleTabChromeActionKind("CREATE", 3);
        CREATE = r103;
        VoiceDoubleTabChromeActionKind[] r104 = {r100, r101, r102, r103};
        f352005a = r104;
        f352006b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceDoubleTabChromeActionKind[] values() {
        return (VoiceDoubleTabChromeActionKind[]) f352005a.clone();
    }

    public static VoiceDoubleTabChromeActionKind valueOf(String r100) {
        return (VoiceDoubleTabChromeActionKind) r27.a.a(VoiceDoubleTabChromeActionKind.class, r100);
    }

    public VoiceDoubleTabChromeActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
