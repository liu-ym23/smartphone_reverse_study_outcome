package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceDialogKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "AUTHORIZE", "CREATE", "EDIT", "OPTIMIZE", "DELETE_CONFIRM", "CLEAR_CONFIRM", "INFO_CONFIRM", "NAME_INPUT", "PHOTO_PREVIEW", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDialogKind extends Enum<VoiceDialogKind> {
    public static final VoiceDialogKind AUTHORIZE = null;
    public static final VoiceDialogKind CLEAR_CONFIRM = null;
    public static final VoiceDialogKind CREATE = null;
    public static final VoiceDialogKind DELETE_CONFIRM = null;
    public static final VoiceDialogKind EDIT = null;
    public static final VoiceDialogKind INFO_CONFIRM = null;
    public static final VoiceDialogKind NAME_INPUT = null;
    public static final VoiceDialogKind NONE = null;
    public static final VoiceDialogKind OPTIMIZE = null;
    public static final VoiceDialogKind PHOTO_PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDialogKind[] f351948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351949b = null;

    public static EnumEntries<VoiceDialogKind> getEntries() {
        return f351949b;
    }

    static {
        VoiceDialogKind r100 = new VoiceDialogKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceDialogKind r101 = new VoiceDialogKind("AUTHORIZE", 1);
        AUTHORIZE = r101;
        VoiceDialogKind r102 = new VoiceDialogKind("CREATE", 2);
        CREATE = r102;
        VoiceDialogKind r103 = new VoiceDialogKind("EDIT", 3);
        EDIT = r103;
        VoiceDialogKind r104 = new VoiceDialogKind("OPTIMIZE", 4);
        OPTIMIZE = r104;
        VoiceDialogKind r105 = new VoiceDialogKind("DELETE_CONFIRM", 5);
        DELETE_CONFIRM = r105;
        VoiceDialogKind r110 = new VoiceDialogKind("CLEAR_CONFIRM", 6);
        CLEAR_CONFIRM = r110;
        VoiceDialogKind r111 = new VoiceDialogKind("INFO_CONFIRM", 7);
        INFO_CONFIRM = r111;
        VoiceDialogKind r112 = new VoiceDialogKind("NAME_INPUT", 8);
        NAME_INPUT = r112;
        VoiceDialogKind r113 = new VoiceDialogKind("PHOTO_PREVIEW", 9);
        PHOTO_PREVIEW = r113;
        VoiceDialogKind[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f351948a = r114;
        f351949b = EnumEntriesKt.enumEntries(r114);
    }

    public static VoiceDialogKind[] values() {
        return (VoiceDialogKind[]) f351948a.clone();
    }

    public static VoiceDialogKind valueOf(String r100) {
        return (VoiceDialogKind) r27.a.a(VoiceDialogKind.class, r100);
    }

    public VoiceDialogKind(String r100, int r101) {
        super(r100, r101);
    }
}
