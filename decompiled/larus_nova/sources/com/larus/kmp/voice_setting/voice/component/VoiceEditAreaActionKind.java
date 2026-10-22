package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceEditAreaActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PITCH_CHANGED", "RATE_CHANGED", "PITCH_COMMITTED", "RATE_COMMITTED", "MIXED_PLAY_CLICK", "VIBRATE", "REPORT_EDIT_RESULT", "APP_BAR_COLLAPSED", "MIX_BAR_EXPAND_CLICK", "REMOVE_SELECTED_VOICE", "MIX_VOICE_PROGRESS_CHANGED", "MIX_VOICE_ITEM_AUDITION", "MIX_CLEAR_CONFIRMED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceEditAreaActionKind extends Enum<VoiceEditAreaActionKind> {
    public static final VoiceEditAreaActionKind APP_BAR_COLLAPSED = null;
    public static final VoiceEditAreaActionKind MIXED_PLAY_CLICK = null;
    public static final VoiceEditAreaActionKind MIX_BAR_EXPAND_CLICK = null;
    public static final VoiceEditAreaActionKind MIX_CLEAR_CONFIRMED = null;
    public static final VoiceEditAreaActionKind MIX_VOICE_ITEM_AUDITION = null;
    public static final VoiceEditAreaActionKind MIX_VOICE_PROGRESS_CHANGED = null;
    public static final VoiceEditAreaActionKind NONE = null;
    public static final VoiceEditAreaActionKind PITCH_CHANGED = null;
    public static final VoiceEditAreaActionKind PITCH_COMMITTED = null;
    public static final VoiceEditAreaActionKind RATE_CHANGED = null;
    public static final VoiceEditAreaActionKind RATE_COMMITTED = null;
    public static final VoiceEditAreaActionKind REMOVE_SELECTED_VOICE = null;
    public static final VoiceEditAreaActionKind REPORT_EDIT_RESULT = null;
    public static final VoiceEditAreaActionKind VIBRATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceEditAreaActionKind[] f352069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352070b = null;

    public static EnumEntries<VoiceEditAreaActionKind> getEntries() {
        return f352070b;
    }

    static {
        VoiceEditAreaActionKind r100 = new VoiceEditAreaActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceEditAreaActionKind r101 = new VoiceEditAreaActionKind("PITCH_CHANGED", 1);
        PITCH_CHANGED = r101;
        VoiceEditAreaActionKind r102 = new VoiceEditAreaActionKind("RATE_CHANGED", 2);
        RATE_CHANGED = r102;
        VoiceEditAreaActionKind r103 = new VoiceEditAreaActionKind("PITCH_COMMITTED", 3);
        PITCH_COMMITTED = r103;
        VoiceEditAreaActionKind r104 = new VoiceEditAreaActionKind("RATE_COMMITTED", 4);
        RATE_COMMITTED = r104;
        VoiceEditAreaActionKind r105 = new VoiceEditAreaActionKind("MIXED_PLAY_CLICK", 5);
        MIXED_PLAY_CLICK = r105;
        VoiceEditAreaActionKind r110 = new VoiceEditAreaActionKind("VIBRATE", 6);
        VIBRATE = r110;
        VoiceEditAreaActionKind r111 = new VoiceEditAreaActionKind("REPORT_EDIT_RESULT", 7);
        REPORT_EDIT_RESULT = r111;
        VoiceEditAreaActionKind r112 = new VoiceEditAreaActionKind("APP_BAR_COLLAPSED", 8);
        APP_BAR_COLLAPSED = r112;
        VoiceEditAreaActionKind r113 = new VoiceEditAreaActionKind("MIX_BAR_EXPAND_CLICK", 9);
        MIX_BAR_EXPAND_CLICK = r113;
        VoiceEditAreaActionKind r114 = new VoiceEditAreaActionKind("REMOVE_SELECTED_VOICE", 10);
        REMOVE_SELECTED_VOICE = r114;
        VoiceEditAreaActionKind r115 = new VoiceEditAreaActionKind("MIX_VOICE_PROGRESS_CHANGED", 11);
        MIX_VOICE_PROGRESS_CHANGED = r115;
        VoiceEditAreaActionKind r106 = new VoiceEditAreaActionKind("MIX_VOICE_ITEM_AUDITION", 12);
        MIX_VOICE_ITEM_AUDITION = r106;
        VoiceEditAreaActionKind r107 = new VoiceEditAreaActionKind("MIX_CLEAR_CONFIRMED", 13);
        MIX_CLEAR_CONFIRMED = r107;
        VoiceEditAreaActionKind[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f352069a = r108;
        f352070b = EnumEntriesKt.enumEntries(r108);
    }

    public static VoiceEditAreaActionKind[] values() {
        return (VoiceEditAreaActionKind[]) f352069a.clone();
    }

    public static VoiceEditAreaActionKind valueOf(String r100) {
        return (VoiceEditAreaActionKind) r27.a.a(VoiceEditAreaActionKind.class, r100);
    }

    public VoiceEditAreaActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
