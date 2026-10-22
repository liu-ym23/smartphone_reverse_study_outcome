package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/screen/doubletab/VoiceDoubleTabPreviewIndicatorScope;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TOP_SINGLE", "LIST_AND_MIX_ITEM", "MIXED_PREVIEW", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDoubleTabPreviewIndicatorScope extends Enum<VoiceDoubleTabPreviewIndicatorScope> {
    public static final VoiceDoubleTabPreviewIndicatorScope LIST_AND_MIX_ITEM = null;
    public static final VoiceDoubleTabPreviewIndicatorScope MIXED_PREVIEW = null;
    public static final VoiceDoubleTabPreviewIndicatorScope NONE = null;
    public static final VoiceDoubleTabPreviewIndicatorScope TOP_SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDoubleTabPreviewIndicatorScope[] f354121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354122b = null;

    public static EnumEntries<VoiceDoubleTabPreviewIndicatorScope> getEntries() {
        return f354122b;
    }

    static {
        VoiceDoubleTabPreviewIndicatorScope r100 = new VoiceDoubleTabPreviewIndicatorScope(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        VoiceDoubleTabPreviewIndicatorScope r101 = new VoiceDoubleTabPreviewIndicatorScope("TOP_SINGLE", 1);
        TOP_SINGLE = r101;
        VoiceDoubleTabPreviewIndicatorScope r102 = new VoiceDoubleTabPreviewIndicatorScope("LIST_AND_MIX_ITEM", 2);
        LIST_AND_MIX_ITEM = r102;
        VoiceDoubleTabPreviewIndicatorScope r103 = new VoiceDoubleTabPreviewIndicatorScope("MIXED_PREVIEW", 3);
        MIXED_PREVIEW = r103;
        VoiceDoubleTabPreviewIndicatorScope[] r104 = {r100, r101, r102, r103};
        f354121a = r104;
        f354122b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceDoubleTabPreviewIndicatorScope[] values() {
        return (VoiceDoubleTabPreviewIndicatorScope[]) f354121a.clone();
    }

    public static VoiceDoubleTabPreviewIndicatorScope valueOf(String r100) {
        return (VoiceDoubleTabPreviewIndicatorScope) r27.a.a(VoiceDoubleTabPreviewIndicatorScope.class, r100);
    }

    public VoiceDoubleTabPreviewIndicatorScope(String r100, int r101) {
        super(r100, r101);
    }
}
