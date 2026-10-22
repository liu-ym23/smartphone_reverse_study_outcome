package com.larus.kmp.voice_setting.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/platform/VoiceImageLoadKey;", "", "<init>", "(Ljava/lang/String;I)V", "SETTINGS_EDIT_AVATAR_DEFAULT", "VOICE_ITEM_AVATAR", "VOICE_ITEM_PUBLIC_PRIMARY_AVATAR", "VOICE_ITEM_PUBLIC_FALLBACK_AVATAR", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceImageLoadKey extends Enum<VoiceImageLoadKey> {
    public static final VoiceImageLoadKey SETTINGS_EDIT_AVATAR_DEFAULT = null;
    public static final VoiceImageLoadKey VOICE_ITEM_AVATAR = null;
    public static final VoiceImageLoadKey VOICE_ITEM_PUBLIC_FALLBACK_AVATAR = null;
    public static final VoiceImageLoadKey VOICE_ITEM_PUBLIC_PRIMARY_AVATAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceImageLoadKey[] f351662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351663b = null;

    public static EnumEntries<VoiceImageLoadKey> getEntries() {
        return f351663b;
    }

    static {
        VoiceImageLoadKey r100 = new VoiceImageLoadKey("SETTINGS_EDIT_AVATAR_DEFAULT", 0);
        SETTINGS_EDIT_AVATAR_DEFAULT = r100;
        VoiceImageLoadKey r101 = new VoiceImageLoadKey("VOICE_ITEM_AVATAR", 1);
        VOICE_ITEM_AVATAR = r101;
        VoiceImageLoadKey r102 = new VoiceImageLoadKey("VOICE_ITEM_PUBLIC_PRIMARY_AVATAR", 2);
        VOICE_ITEM_PUBLIC_PRIMARY_AVATAR = r102;
        VoiceImageLoadKey r103 = new VoiceImageLoadKey("VOICE_ITEM_PUBLIC_FALLBACK_AVATAR", 3);
        VOICE_ITEM_PUBLIC_FALLBACK_AVATAR = r103;
        VoiceImageLoadKey[] r104 = {r100, r101, r102, r103};
        f351662a = r104;
        f351663b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceImageLoadKey[] values() {
        return (VoiceImageLoadKey[]) f351662a.clone();
    }

    public static VoiceImageLoadKey valueOf(String r100) {
        return (VoiceImageLoadKey) r27.a.a(VoiceImageLoadKey.class, r100);
    }

    public VoiceImageLoadKey(String r100, int r101) {
        super(r100, r101);
    }
}
