package com.larus.kmp.voice_setting.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/platform/VoiceImageUploadBiz;", "", "<init>", "(Ljava/lang/String;I)V", "BOT_ICON", "VOICE_ICON", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceImageUploadBiz extends Enum<VoiceImageUploadBiz> {
    public static final VoiceImageUploadBiz BOT_ICON = null;
    public static final VoiceImageUploadBiz VOICE_ICON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceImageUploadBiz[] f351664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351665b = null;

    public static EnumEntries<VoiceImageUploadBiz> getEntries() {
        return f351665b;
    }

    static {
        VoiceImageUploadBiz r100 = new VoiceImageUploadBiz("BOT_ICON", 0);
        BOT_ICON = r100;
        VoiceImageUploadBiz r101 = new VoiceImageUploadBiz("VOICE_ICON", 1);
        VOICE_ICON = r101;
        VoiceImageUploadBiz[] r102 = {r100, r101};
        f351664a = r102;
        f351665b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceImageUploadBiz[] values() {
        return (VoiceImageUploadBiz[]) f351664a.clone();
    }

    public static VoiceImageUploadBiz valueOf(String r100) {
        return (VoiceImageUploadBiz) r27.a.a(VoiceImageUploadBiz.class, r100);
    }

    public VoiceImageUploadBiz(String r100, int r101) {
        super(r100, r101);
    }
}
