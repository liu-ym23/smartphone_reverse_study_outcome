package com.larus.kmp.voice_setting.voice.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceMixPreviewActionKind;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PLAY_TOGGLE", "RELEASE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceMixPreviewActionKind extends Enum<VoiceMixPreviewActionKind> {
    public static final VoiceMixPreviewActionKind NONE = null;
    public static final VoiceMixPreviewActionKind PLAY_TOGGLE = null;
    public static final VoiceMixPreviewActionKind RELEASE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceMixPreviewActionKind[] f352087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352088b = null;

    public static EnumEntries<VoiceMixPreviewActionKind> getEntries() {
        return f352088b;
    }

    static {
        VoiceMixPreviewActionKind r100 = new VoiceMixPreviewActionKind(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceMixPreviewActionKind r101 = new VoiceMixPreviewActionKind("PLAY_TOGGLE", 1);
        PLAY_TOGGLE = r101;
        VoiceMixPreviewActionKind r102 = new VoiceMixPreviewActionKind("RELEASE", 2);
        RELEASE = r102;
        VoiceMixPreviewActionKind[] r103 = {r100, r101, r102};
        f352087a = r103;
        f352088b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceMixPreviewActionKind[] values() {
        return (VoiceMixPreviewActionKind[]) f352087a.clone();
    }

    public static VoiceMixPreviewActionKind valueOf(String r100) {
        return (VoiceMixPreviewActionKind) r27.a.a(VoiceMixPreviewActionKind.class, r100);
    }

    public VoiceMixPreviewActionKind(String r100, int r101) {
        super(r100, r101);
    }
}
