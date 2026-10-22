package com.larus.kmp.voice_setting.voice.dialog.v2.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/v2/api/VoiceMaterialSelectionSource;", "", "<init>", "(Ljava/lang/String;I)V", "CACHED", "AUDIO_CONFIG", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceMaterialSelectionSource extends Enum<VoiceMaterialSelectionSource> {
    public static final VoiceMaterialSelectionSource AUDIO_CONFIG = null;
    public static final VoiceMaterialSelectionSource CACHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceMaterialSelectionSource[] f353042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353043b = null;

    public static EnumEntries<VoiceMaterialSelectionSource> getEntries() {
        return f353043b;
    }

    static {
        VoiceMaterialSelectionSource r100 = new VoiceMaterialSelectionSource("CACHED", 0);
        CACHED = r100;
        VoiceMaterialSelectionSource r101 = new VoiceMaterialSelectionSource("AUDIO_CONFIG", 1);
        AUDIO_CONFIG = r101;
        VoiceMaterialSelectionSource[] r102 = {r100, r101};
        f353042a = r102;
        f353043b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceMaterialSelectionSource[] values() {
        return (VoiceMaterialSelectionSource[]) f353042a.clone();
    }

    public static VoiceMaterialSelectionSource valueOf(String r100) {
        return (VoiceMaterialSelectionSource) r27.a.a(VoiceMaterialSelectionSource.class, r100);
    }

    public VoiceMaterialSelectionSource(String r100, int r101) {
        super(r100, r101);
    }
}
