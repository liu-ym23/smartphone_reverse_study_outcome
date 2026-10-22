package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b,\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceDialogActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "DISMISS", "AUTHORIZE_CANCEL", "AUTHORIZE_CONFIRM", "CREATE_CLOSE", "RECORD_PRESS", "RECORD_DRAG_CHANGED", "RECORD_RELEASE", "RECORD_CANCEL", "RECORD_PERMISSION_RESULT", "RECORD_PERMISSION_REQUEST_RESULT", "RECORD_MEDIA_RESULT", "RECORD_QUALITY_RESULT", "RECORD_FILE_READY", "RECORD_TIMEOUT_SUBMIT", "IMAGE_PICK_REQUEST", "IMAGE_PICK_RESULT", "IMAGE_CROP_REQUEST", "IMAGE_CROP_RESULT", "IMAGE_UPLOAD_REQUEST", "IMAGE_UPLOAD_RESULT", "EDIT_NAME_CLICK", "EDIT_VISIBILITY_CHANGED", "EDIT_SUBMIT", "OPTIMIZE_NAME_CLICK", "OPTIMIZE_VISIBILITY_CHANGED", "OPTIMIZE_SUBMIT", "OPTIMIZE_BACK_TO_RECORD", "OPTIMIZE_RETRY_RECORD", "PREVIEW_TOGGLE", "PREVIEW_PLAYBACK_ENDED", "INFO_CONFIRM", "DELETE_CONFIRM", "DELETE_CANCEL", "CLEAR_CONFIRM", "CLEAR_CANCEL", "NAME_INPUT_CONFIRM", "NAME_INPUT_TEXT_CHANGED", "NAME_INPUT_CANCEL", "PHOTO_PREVIEW_OPEN", "PHOTO_PREVIEW_CLOSE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDialogActionKind extends Enum<VoiceDialogActionKind> {
    public static final VoiceDialogActionKind AUTHORIZE_CANCEL = null;
    public static final VoiceDialogActionKind AUTHORIZE_CONFIRM = null;
    public static final VoiceDialogActionKind CLEAR_CANCEL = null;
    public static final VoiceDialogActionKind CLEAR_CONFIRM = null;
    public static final VoiceDialogActionKind CREATE_CLOSE = null;
    public static final VoiceDialogActionKind DELETE_CANCEL = null;
    public static final VoiceDialogActionKind DELETE_CONFIRM = null;
    public static final VoiceDialogActionKind DISMISS = null;
    public static final VoiceDialogActionKind EDIT_NAME_CLICK = null;
    public static final VoiceDialogActionKind EDIT_SUBMIT = null;
    public static final VoiceDialogActionKind EDIT_VISIBILITY_CHANGED = null;
    public static final VoiceDialogActionKind IMAGE_CROP_REQUEST = null;
    public static final VoiceDialogActionKind IMAGE_CROP_RESULT = null;
    public static final VoiceDialogActionKind IMAGE_PICK_REQUEST = null;
    public static final VoiceDialogActionKind IMAGE_PICK_RESULT = null;
    public static final VoiceDialogActionKind IMAGE_UPLOAD_REQUEST = null;
    public static final VoiceDialogActionKind IMAGE_UPLOAD_RESULT = null;
    public static final VoiceDialogActionKind INFO_CONFIRM = null;
    public static final VoiceDialogActionKind NAME_INPUT_CANCEL = null;
    public static final VoiceDialogActionKind NAME_INPUT_CONFIRM = null;
    public static final VoiceDialogActionKind NAME_INPUT_TEXT_CHANGED = null;
    public static final VoiceDialogActionKind NONE = null;
    public static final VoiceDialogActionKind OPTIMIZE_BACK_TO_RECORD = null;
    public static final VoiceDialogActionKind OPTIMIZE_NAME_CLICK = null;
    public static final VoiceDialogActionKind OPTIMIZE_RETRY_RECORD = null;
    public static final VoiceDialogActionKind OPTIMIZE_SUBMIT = null;
    public static final VoiceDialogActionKind OPTIMIZE_VISIBILITY_CHANGED = null;
    public static final VoiceDialogActionKind PHOTO_PREVIEW_CLOSE = null;
    public static final VoiceDialogActionKind PHOTO_PREVIEW_OPEN = null;
    public static final VoiceDialogActionKind PREVIEW_PLAYBACK_ENDED = null;
    public static final VoiceDialogActionKind PREVIEW_TOGGLE = null;
    public static final VoiceDialogActionKind RECORD_CANCEL = null;
    public static final VoiceDialogActionKind RECORD_DRAG_CHANGED = null;
    public static final VoiceDialogActionKind RECORD_FILE_READY = null;
    public static final VoiceDialogActionKind RECORD_MEDIA_RESULT = null;
    public static final VoiceDialogActionKind RECORD_PERMISSION_REQUEST_RESULT = null;
    public static final VoiceDialogActionKind RECORD_PERMISSION_RESULT = null;
    public static final VoiceDialogActionKind RECORD_PRESS = null;
    public static final VoiceDialogActionKind RECORD_QUALITY_RESULT = null;
    public static final VoiceDialogActionKind RECORD_RELEASE = null;
    public static final VoiceDialogActionKind RECORD_TIMEOUT_SUBMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDialogActionKind[] f351936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351937b = null;

    public static EnumEntries<VoiceDialogActionKind> getEntries() {
        return f351937b;
    }

    static {
        VoiceDialogActionKind r100 = new VoiceDialogActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceDialogActionKind r101 = new VoiceDialogActionKind("DISMISS", 1);
        DISMISS = r101;
        VoiceDialogActionKind r102 = new VoiceDialogActionKind("AUTHORIZE_CANCEL", 2);
        AUTHORIZE_CANCEL = r102;
        VoiceDialogActionKind r103 = new VoiceDialogActionKind("AUTHORIZE_CONFIRM", 3);
        AUTHORIZE_CONFIRM = r103;
        VoiceDialogActionKind r104 = new VoiceDialogActionKind("CREATE_CLOSE", 4);
        CREATE_CLOSE = r104;
        VoiceDialogActionKind r105 = new VoiceDialogActionKind("RECORD_PRESS", 5);
        RECORD_PRESS = r105;
        VoiceDialogActionKind r110 = new VoiceDialogActionKind("RECORD_DRAG_CHANGED", 6);
        RECORD_DRAG_CHANGED = r110;
        VoiceDialogActionKind r111 = new VoiceDialogActionKind("RECORD_RELEASE", 7);
        RECORD_RELEASE = r111;
        VoiceDialogActionKind r112 = new VoiceDialogActionKind("RECORD_CANCEL", 8);
        RECORD_CANCEL = r112;
        VoiceDialogActionKind r113 = new VoiceDialogActionKind("RECORD_PERMISSION_RESULT", 9);
        RECORD_PERMISSION_RESULT = r113;
        VoiceDialogActionKind r114 = new VoiceDialogActionKind("RECORD_PERMISSION_REQUEST_RESULT", 10);
        RECORD_PERMISSION_REQUEST_RESULT = r114;
        VoiceDialogActionKind r115 = new VoiceDialogActionKind("RECORD_MEDIA_RESULT", 11);
        RECORD_MEDIA_RESULT = r115;
        VoiceDialogActionKind r106 = new VoiceDialogActionKind("RECORD_QUALITY_RESULT", 12);
        RECORD_QUALITY_RESULT = r106;
        VoiceDialogActionKind r107 = new VoiceDialogActionKind("RECORD_FILE_READY", 13);
        RECORD_FILE_READY = r107;
        VoiceDialogActionKind r108 = new VoiceDialogActionKind("RECORD_TIMEOUT_SUBMIT", 14);
        RECORD_TIMEOUT_SUBMIT = r108;
        VoiceDialogActionKind r109 = new VoiceDialogActionKind("IMAGE_PICK_REQUEST", 15);
        IMAGE_PICK_REQUEST = r109;
        VoiceDialogActionKind r116 = new VoiceDialogActionKind("IMAGE_PICK_RESULT", 16);
        IMAGE_PICK_RESULT = r116;
        VoiceDialogActionKind r117 = new VoiceDialogActionKind("IMAGE_CROP_REQUEST", 17);
        IMAGE_CROP_REQUEST = r117;
        VoiceDialogActionKind r118 = new VoiceDialogActionKind("IMAGE_CROP_RESULT", 18);
        IMAGE_CROP_RESULT = r118;
        VoiceDialogActionKind r119 = new VoiceDialogActionKind("IMAGE_UPLOAD_REQUEST", 19);
        IMAGE_UPLOAD_REQUEST = r119;
        VoiceDialogActionKind r120 = new VoiceDialogActionKind("IMAGE_UPLOAD_RESULT", 20);
        IMAGE_UPLOAD_RESULT = r120;
        VoiceDialogActionKind r121 = new VoiceDialogActionKind("EDIT_NAME_CLICK", 21);
        EDIT_NAME_CLICK = r121;
        VoiceDialogActionKind r122 = new VoiceDialogActionKind("EDIT_VISIBILITY_CHANGED", 22);
        EDIT_VISIBILITY_CHANGED = r122;
        VoiceDialogActionKind r123 = new VoiceDialogActionKind("EDIT_SUBMIT", 23);
        EDIT_SUBMIT = r123;
        VoiceDialogActionKind r124 = new VoiceDialogActionKind("OPTIMIZE_NAME_CLICK", 24);
        OPTIMIZE_NAME_CLICK = r124;
        VoiceDialogActionKind r125 = new VoiceDialogActionKind("OPTIMIZE_VISIBILITY_CHANGED", 25);
        OPTIMIZE_VISIBILITY_CHANGED = r125;
        VoiceDialogActionKind r126 = new VoiceDialogActionKind("OPTIMIZE_SUBMIT", 26);
        OPTIMIZE_SUBMIT = r126;
        VoiceDialogActionKind r127 = new VoiceDialogActionKind("OPTIMIZE_BACK_TO_RECORD", 27);
        OPTIMIZE_BACK_TO_RECORD = r127;
        VoiceDialogActionKind r128 = new VoiceDialogActionKind("OPTIMIZE_RETRY_RECORD", 28);
        OPTIMIZE_RETRY_RECORD = r128;
        VoiceDialogActionKind r129 = new VoiceDialogActionKind("PREVIEW_TOGGLE", 29);
        PREVIEW_TOGGLE = r129;
        VoiceDialogActionKind r130 = new VoiceDialogActionKind("PREVIEW_PLAYBACK_ENDED", 30);
        PREVIEW_PLAYBACK_ENDED = r130;
        VoiceDialogActionKind r131 = new VoiceDialogActionKind("INFO_CONFIRM", 31);
        INFO_CONFIRM = r131;
        VoiceDialogActionKind r132 = new VoiceDialogActionKind("DELETE_CONFIRM", 32);
        DELETE_CONFIRM = r132;
        VoiceDialogActionKind r133 = new VoiceDialogActionKind("DELETE_CANCEL", 33);
        DELETE_CANCEL = r133;
        VoiceDialogActionKind r134 = new VoiceDialogActionKind("CLEAR_CONFIRM", 34);
        CLEAR_CONFIRM = r134;
        VoiceDialogActionKind r135 = new VoiceDialogActionKind("CLEAR_CANCEL", 35);
        CLEAR_CANCEL = r135;
        VoiceDialogActionKind r136 = new VoiceDialogActionKind("NAME_INPUT_CONFIRM", 36);
        NAME_INPUT_CONFIRM = r136;
        VoiceDialogActionKind r137 = new VoiceDialogActionKind("NAME_INPUT_TEXT_CHANGED", 37);
        NAME_INPUT_TEXT_CHANGED = r137;
        VoiceDialogActionKind r138 = new VoiceDialogActionKind("NAME_INPUT_CANCEL", 38);
        NAME_INPUT_CANCEL = r138;
        VoiceDialogActionKind r139 = new VoiceDialogActionKind("PHOTO_PREVIEW_OPEN", 39);
        PHOTO_PREVIEW_OPEN = r139;
        VoiceDialogActionKind r140 = new VoiceDialogActionKind("PHOTO_PREVIEW_CLOSE", 40);
        PHOTO_PREVIEW_CLOSE = r140;
        VoiceDialogActionKind[] r141 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140};
        f351936a = r141;
        f351937b = EnumEntriesKt.enumEntries(r141);
    }

    public static VoiceDialogActionKind[] values() {
        return (VoiceDialogActionKind[]) f351936a.clone();
    }

    public static VoiceDialogActionKind valueOf(String r100) {
        return (VoiceDialogActionKind) r27.a.a(VoiceDialogActionKind.class, r100);
    }

    public VoiceDialogActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
