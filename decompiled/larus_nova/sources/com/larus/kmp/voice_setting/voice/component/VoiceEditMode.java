package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceEditMode;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SINGLE", "MULTI", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceEditMode extends Enum<VoiceEditMode> {
    public static final VoiceEditMode MULTI = null;
    public static final VoiceEditMode NONE = null;
    public static final VoiceEditMode SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceEditMode[] f352076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352077b = null;

    public static EnumEntries<VoiceEditMode> getEntries() {
        return f352077b;
    }

    static {
        VoiceEditMode r100 = new VoiceEditMode(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceEditMode r101 = new VoiceEditMode("SINGLE", 1);
        SINGLE = r101;
        VoiceEditMode r102 = new VoiceEditMode("MULTI", 2);
        MULTI = r102;
        VoiceEditMode[] r103 = {r100, r101, r102};
        f352076a = r103;
        f352077b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceEditMode[] values() {
        return (VoiceEditMode[]) f352076a.clone();
    }

    public static VoiceEditMode valueOf(String r100) {
        return (VoiceEditMode) r27.a.a(VoiceEditMode.class, r100);
    }

    public VoiceEditMode(String r100, int r101) {
        super(r100, r101);
    }
}
