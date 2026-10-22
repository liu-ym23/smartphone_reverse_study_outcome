package com.larus.kmp.voice_setting.voice.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/image/VoiceImageScaleType;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER_CROP", "FIT_CENTER", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceImageScaleType extends Enum<VoiceImageScaleType> {
    public static final VoiceImageScaleType CENTER_CROP = null;
    public static final VoiceImageScaleType FIT_CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceImageScaleType[] f353399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353400b = null;

    public static EnumEntries<VoiceImageScaleType> getEntries() {
        return f353400b;
    }

    static {
        VoiceImageScaleType r100 = new VoiceImageScaleType("CENTER_CROP", 0);
        CENTER_CROP = r100;
        VoiceImageScaleType r101 = new VoiceImageScaleType("FIT_CENTER", 1);
        FIT_CENTER = r101;
        VoiceImageScaleType[] r102 = {r100, r101};
        f353399a = r102;
        f353400b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceImageScaleType[] values() {
        return (VoiceImageScaleType[]) f353399a.clone();
    }

    public static VoiceImageScaleType valueOf(String r100) {
        return (VoiceImageScaleType) a.a(VoiceImageScaleType.class, r100);
    }

    public VoiceImageScaleType(String r100, int r101) {
        super(r100, r101);
    }
}
