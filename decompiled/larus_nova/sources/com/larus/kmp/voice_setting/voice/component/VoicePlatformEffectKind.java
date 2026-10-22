package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoicePlatformEffectKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "OPEN_PAGE", "FINISH_WITH_RESULT", "DISMISS_DIALOG", "PICK_IMAGE", "CROP_IMAGE", "UPLOAD_IMAGE", "CREATE_VOICE_PREFLIGHT", "REQUEST_RECORD_PERMISSION", "REQUEST_RECORD_MEDIA", "START_RECORD_QUALITY_CHECK", "STOP_RECORD_QUALITY_CHECK", "CANCEL_RECORD_QUALITY_CHECK", "SHOW_SHELL_FEEDBACK", "PLAY_PREVIEW", "LOAD_MIX_PREVIEW", "STOP_PREVIEW", "RELEASE_MEDIA", "VIBRATE", "REPORT_EDIT_RESULT", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoicePlatformEffectKind extends Enum<VoicePlatformEffectKind> {
    public static final VoicePlatformEffectKind CANCEL_RECORD_QUALITY_CHECK = null;
    public static final VoicePlatformEffectKind CREATE_VOICE_PREFLIGHT = null;
    public static final VoicePlatformEffectKind CROP_IMAGE = null;
    public static final VoicePlatformEffectKind DISMISS_DIALOG = null;
    public static final VoicePlatformEffectKind FINISH_WITH_RESULT = null;
    public static final VoicePlatformEffectKind LOAD_MIX_PREVIEW = null;
    public static final VoicePlatformEffectKind NONE = null;
    public static final VoicePlatformEffectKind OPEN_PAGE = null;
    public static final VoicePlatformEffectKind PICK_IMAGE = null;
    public static final VoicePlatformEffectKind PLAY_PREVIEW = null;
    public static final VoicePlatformEffectKind RELEASE_MEDIA = null;
    public static final VoicePlatformEffectKind REPORT_EDIT_RESULT = null;
    public static final VoicePlatformEffectKind REQUEST_RECORD_MEDIA = null;
    public static final VoicePlatformEffectKind REQUEST_RECORD_PERMISSION = null;
    public static final VoicePlatformEffectKind SHOW_SHELL_FEEDBACK = null;
    public static final VoicePlatformEffectKind START_RECORD_QUALITY_CHECK = null;
    public static final VoicePlatformEffectKind STOP_PREVIEW = null;
    public static final VoicePlatformEffectKind STOP_RECORD_QUALITY_CHECK = null;
    public static final VoicePlatformEffectKind UPLOAD_IMAGE = null;
    public static final VoicePlatformEffectKind VIBRATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoicePlatformEffectKind[] f352098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352099b = null;

    public static EnumEntries<VoicePlatformEffectKind> getEntries() {
        return f352099b;
    }

    static {
        VoicePlatformEffectKind r100 = new VoicePlatformEffectKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoicePlatformEffectKind r101 = new VoicePlatformEffectKind("OPEN_PAGE", 1);
        OPEN_PAGE = r101;
        VoicePlatformEffectKind r102 = new VoicePlatformEffectKind("FINISH_WITH_RESULT", 2);
        FINISH_WITH_RESULT = r102;
        VoicePlatformEffectKind r103 = new VoicePlatformEffectKind("DISMISS_DIALOG", 3);
        DISMISS_DIALOG = r103;
        VoicePlatformEffectKind r104 = new VoicePlatformEffectKind("PICK_IMAGE", 4);
        PICK_IMAGE = r104;
        VoicePlatformEffectKind r105 = new VoicePlatformEffectKind("CROP_IMAGE", 5);
        CROP_IMAGE = r105;
        VoicePlatformEffectKind r110 = new VoicePlatformEffectKind("UPLOAD_IMAGE", 6);
        UPLOAD_IMAGE = r110;
        VoicePlatformEffectKind r111 = new VoicePlatformEffectKind("CREATE_VOICE_PREFLIGHT", 7);
        CREATE_VOICE_PREFLIGHT = r111;
        VoicePlatformEffectKind r112 = new VoicePlatformEffectKind("REQUEST_RECORD_PERMISSION", 8);
        REQUEST_RECORD_PERMISSION = r112;
        VoicePlatformEffectKind r113 = new VoicePlatformEffectKind("REQUEST_RECORD_MEDIA", 9);
        REQUEST_RECORD_MEDIA = r113;
        VoicePlatformEffectKind r114 = new VoicePlatformEffectKind("START_RECORD_QUALITY_CHECK", 10);
        START_RECORD_QUALITY_CHECK = r114;
        VoicePlatformEffectKind r115 = new VoicePlatformEffectKind("STOP_RECORD_QUALITY_CHECK", 11);
        STOP_RECORD_QUALITY_CHECK = r115;
        VoicePlatformEffectKind r106 = new VoicePlatformEffectKind("CANCEL_RECORD_QUALITY_CHECK", 12);
        CANCEL_RECORD_QUALITY_CHECK = r106;
        VoicePlatformEffectKind r107 = new VoicePlatformEffectKind("SHOW_SHELL_FEEDBACK", 13);
        SHOW_SHELL_FEEDBACK = r107;
        VoicePlatformEffectKind r108 = new VoicePlatformEffectKind("PLAY_PREVIEW", 14);
        PLAY_PREVIEW = r108;
        VoicePlatformEffectKind r109 = new VoicePlatformEffectKind("LOAD_MIX_PREVIEW", 15);
        LOAD_MIX_PREVIEW = r109;
        VoicePlatformEffectKind r116 = new VoicePlatformEffectKind("STOP_PREVIEW", 16);
        STOP_PREVIEW = r116;
        VoicePlatformEffectKind r117 = new VoicePlatformEffectKind("RELEASE_MEDIA", 17);
        RELEASE_MEDIA = r117;
        VoicePlatformEffectKind r118 = new VoicePlatformEffectKind("VIBRATE", 18);
        VIBRATE = r118;
        VoicePlatformEffectKind r119 = new VoicePlatformEffectKind("REPORT_EDIT_RESULT", 19);
        REPORT_EDIT_RESULT = r119;
        VoicePlatformEffectKind[] r120 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        f352098a = r120;
        f352099b = EnumEntriesKt.enumEntries(r120);
    }

    public static VoicePlatformEffectKind[] values() {
        return (VoicePlatformEffectKind[]) f352098a.clone();
    }

    public static VoicePlatformEffectKind valueOf(String r100) {
        return (VoicePlatformEffectKind) r27.a.a(VoicePlatformEffectKind.class, r100);
    }

    public VoicePlatformEffectKind(String r100, int r101) {
        super(r100, r101);
    }
}
