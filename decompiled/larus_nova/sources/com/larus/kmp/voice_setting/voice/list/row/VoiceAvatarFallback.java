package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/row/VoiceAvatarFallback;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MUTED", "UPLOADING", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceAvatarFallback extends Enum<VoiceAvatarFallback> {
    public static final VoiceAvatarFallback DEFAULT = null;
    public static final VoiceAvatarFallback MUTED = null;
    public static final VoiceAvatarFallback UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceAvatarFallback[] f353599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353600b = null;

    public static EnumEntries<VoiceAvatarFallback> getEntries() {
        return f353600b;
    }

    static {
        VoiceAvatarFallback r100 = new VoiceAvatarFallback("DEFAULT", 0);
        DEFAULT = r100;
        VoiceAvatarFallback r101 = new VoiceAvatarFallback("MUTED", 1);
        MUTED = r101;
        VoiceAvatarFallback r102 = new VoiceAvatarFallback("UPLOADING", 2);
        UPLOADING = r102;
        VoiceAvatarFallback[] r103 = {r100, r101, r102};
        f353599a = r103;
        f353600b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceAvatarFallback[] values() {
        return (VoiceAvatarFallback[]) f353599a.clone();
    }

    public static VoiceAvatarFallback valueOf(String r100) {
        return (VoiceAvatarFallback) r27.a.a(VoiceAvatarFallback.class, r100);
    }

    public VoiceAvatarFallback(String r100, int r101) {
        super(r100, r101);
    }
}
