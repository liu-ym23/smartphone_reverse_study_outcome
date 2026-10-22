package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/component/VoiceDropdownMenuItemKind;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", "DELETE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDropdownMenuItemKind extends Enum<VoiceDropdownMenuItemKind> {
    public static final VoiceDropdownMenuItemKind DELETE = null;
    public static final VoiceDropdownMenuItemKind EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDropdownMenuItemKind[] f352067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352068b = null;

    public static EnumEntries<VoiceDropdownMenuItemKind> getEntries() {
        return f352068b;
    }

    static {
        VoiceDropdownMenuItemKind r100 = new VoiceDropdownMenuItemKind("EDIT", 0);
        EDIT = r100;
        VoiceDropdownMenuItemKind r101 = new VoiceDropdownMenuItemKind("DELETE", 1);
        DELETE = r101;
        VoiceDropdownMenuItemKind[] r102 = {r100, r101};
        f352067a = r102;
        f352068b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceDropdownMenuItemKind[] values() {
        return (VoiceDropdownMenuItemKind[]) f352067a.clone();
    }

    public static VoiceDropdownMenuItemKind valueOf(String r100) {
        return (VoiceDropdownMenuItemKind) r27.a.a(VoiceDropdownMenuItemKind.class, r100);
    }

    public VoiceDropdownMenuItemKind(String r100, int r101) {
        super(r100, r101);
    }
}
