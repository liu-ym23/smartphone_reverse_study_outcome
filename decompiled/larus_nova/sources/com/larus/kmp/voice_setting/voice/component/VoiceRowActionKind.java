package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceRowActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "CREATE", "CLICK", "MORE", "ADD", "DELETE", "LOAD_MORE", "ROW_FULLY_VISIBLE", "SCROLLABILITY_CHANGED", "SCROLL_IN_PROGRESS_CHANGED", "SCROLL_UP", "DROPDOWN_DISMISS", "DROPDOWN_ITEM_CLICK", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceRowActionKind extends Enum<VoiceRowActionKind> {
    public static final VoiceRowActionKind ADD = null;
    public static final VoiceRowActionKind CLICK = null;
    public static final VoiceRowActionKind CREATE = null;
    public static final VoiceRowActionKind DELETE = null;
    public static final VoiceRowActionKind DROPDOWN_DISMISS = null;
    public static final VoiceRowActionKind DROPDOWN_ITEM_CLICK = null;
    public static final VoiceRowActionKind LOAD_MORE = null;
    public static final VoiceRowActionKind MORE = null;
    public static final VoiceRowActionKind NONE = null;
    public static final VoiceRowActionKind ROW_FULLY_VISIBLE = null;
    public static final VoiceRowActionKind SCROLLABILITY_CHANGED = null;
    public static final VoiceRowActionKind SCROLL_IN_PROGRESS_CHANGED = null;
    public static final VoiceRowActionKind SCROLL_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceRowActionKind[] f352105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352106b = null;

    public static EnumEntries<VoiceRowActionKind> getEntries() {
        return f352106b;
    }

    static {
        VoiceRowActionKind r100 = new VoiceRowActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceRowActionKind r101 = new VoiceRowActionKind("CREATE", 1);
        CREATE = r101;
        VoiceRowActionKind r102 = new VoiceRowActionKind("CLICK", 2);
        CLICK = r102;
        VoiceRowActionKind r103 = new VoiceRowActionKind("MORE", 3);
        MORE = r103;
        VoiceRowActionKind r104 = new VoiceRowActionKind("ADD", 4);
        ADD = r104;
        VoiceRowActionKind r105 = new VoiceRowActionKind("DELETE", 5);
        DELETE = r105;
        VoiceRowActionKind r110 = new VoiceRowActionKind("LOAD_MORE", 6);
        LOAD_MORE = r110;
        VoiceRowActionKind r111 = new VoiceRowActionKind("ROW_FULLY_VISIBLE", 7);
        ROW_FULLY_VISIBLE = r111;
        VoiceRowActionKind r112 = new VoiceRowActionKind("SCROLLABILITY_CHANGED", 8);
        SCROLLABILITY_CHANGED = r112;
        VoiceRowActionKind r113 = new VoiceRowActionKind("SCROLL_IN_PROGRESS_CHANGED", 9);
        SCROLL_IN_PROGRESS_CHANGED = r113;
        VoiceRowActionKind r114 = new VoiceRowActionKind("SCROLL_UP", 10);
        SCROLL_UP = r114;
        VoiceRowActionKind r115 = new VoiceRowActionKind("DROPDOWN_DISMISS", 11);
        DROPDOWN_DISMISS = r115;
        VoiceRowActionKind r106 = new VoiceRowActionKind("DROPDOWN_ITEM_CLICK", 12);
        DROPDOWN_ITEM_CLICK = r106;
        VoiceRowActionKind[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f352105a = r107;
        f352106b = EnumEntriesKt.enumEntries(r107);
    }

    public static VoiceRowActionKind[] values() {
        return (VoiceRowActionKind[]) f352105a.clone();
    }

    public static VoiceRowActionKind valueOf(String r100) {
        return (VoiceRowActionKind) r27.a.a(VoiceRowActionKind.class, r100);
    }

    public VoiceRowActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
