package com.larus.kmp.voice_setting.voice.dialog;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/dialog/UgcVoiceInfoOptimizeBannerMode;", "", "<init>", "(Ljava/lang/String;I)V", "PROGRESS", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "ERROR", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceInfoOptimizeBannerMode extends Enum<UgcVoiceInfoOptimizeBannerMode> {
    public static final UgcVoiceInfoOptimizeBannerMode ERROR = null;
    public static final UgcVoiceInfoOptimizeBannerMode PLAY = null;
    public static final UgcVoiceInfoOptimizeBannerMode PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceInfoOptimizeBannerMode[] f352691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f352692b = null;

    public static EnumEntries<UgcVoiceInfoOptimizeBannerMode> getEntries() {
        return f352692b;
    }

    static {
        UgcVoiceInfoOptimizeBannerMode r100 = new UgcVoiceInfoOptimizeBannerMode("PROGRESS", 0);
        PROGRESS = r100;
        UgcVoiceInfoOptimizeBannerMode r101 = new UgcVoiceInfoOptimizeBannerMode(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1);
        PLAY = r101;
        UgcVoiceInfoOptimizeBannerMode r102 = new UgcVoiceInfoOptimizeBannerMode("ERROR", 2);
        ERROR = r102;
        UgcVoiceInfoOptimizeBannerMode[] r103 = {r100, r101, r102};
        f352691a = r103;
        f352692b = EnumEntriesKt.enumEntries(r103);
    }

    public static UgcVoiceInfoOptimizeBannerMode[] values() {
        return (UgcVoiceInfoOptimizeBannerMode[]) f352691a.clone();
    }

    public static UgcVoiceInfoOptimizeBannerMode valueOf(String r100) {
        return (UgcVoiceInfoOptimizeBannerMode) r27.a.a(UgcVoiceInfoOptimizeBannerMode.class, r100);
    }

    public UgcVoiceInfoOptimizeBannerMode(String r100, int r101) {
        super(r100, r101);
    }
}
