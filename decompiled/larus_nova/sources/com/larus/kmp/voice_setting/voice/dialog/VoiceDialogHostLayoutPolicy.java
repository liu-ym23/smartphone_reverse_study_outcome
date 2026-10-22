package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/VoiceDialogHostLayoutPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY_FULL_HEIGHT_SHEET", "LEGACY_WRAP_BOTTOM_SHEET", "LEGACY_CENTER_DIALOG", "LEGACY_FULLSCREEN_PREVIEW", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum VoiceDialogHostLayoutPolicy extends Enum<VoiceDialogHostLayoutPolicy> {
    public static final VoiceDialogHostLayoutPolicy LEGACY_CENTER_DIALOG = null;
    public static final VoiceDialogHostLayoutPolicy LEGACY_FULLSCREEN_PREVIEW = null;
    public static final VoiceDialogHostLayoutPolicy LEGACY_FULL_HEIGHT_SHEET = null;
    public static final VoiceDialogHostLayoutPolicy LEGACY_WRAP_BOTTOM_SHEET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDialogHostLayoutPolicy[] f352697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352698b = null;

    public static EnumEntries<VoiceDialogHostLayoutPolicy> getEntries() {
        return f352698b;
    }

    static {
        VoiceDialogHostLayoutPolicy r100 = new VoiceDialogHostLayoutPolicy("LEGACY_FULL_HEIGHT_SHEET", 0);
        LEGACY_FULL_HEIGHT_SHEET = r100;
        VoiceDialogHostLayoutPolicy r101 = new VoiceDialogHostLayoutPolicy("LEGACY_WRAP_BOTTOM_SHEET", 1);
        LEGACY_WRAP_BOTTOM_SHEET = r101;
        VoiceDialogHostLayoutPolicy r102 = new VoiceDialogHostLayoutPolicy("LEGACY_CENTER_DIALOG", 2);
        LEGACY_CENTER_DIALOG = r102;
        VoiceDialogHostLayoutPolicy r103 = new VoiceDialogHostLayoutPolicy("LEGACY_FULLSCREEN_PREVIEW", 3);
        LEGACY_FULLSCREEN_PREVIEW = r103;
        VoiceDialogHostLayoutPolicy[] r104 = {r100, r101, r102, r103};
        f352697a = r104;
        f352698b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceDialogHostLayoutPolicy[] values() {
        return (VoiceDialogHostLayoutPolicy[]) f352697a.clone();
    }

    public static VoiceDialogHostLayoutPolicy valueOf(String r100) {
        return (VoiceDialogHostLayoutPolicy) r27.a.a(VoiceDialogHostLayoutPolicy.class, r100);
    }

    public VoiceDialogHostLayoutPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
