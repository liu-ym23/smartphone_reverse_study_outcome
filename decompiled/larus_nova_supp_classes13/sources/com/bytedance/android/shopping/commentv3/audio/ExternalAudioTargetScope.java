package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/ExternalAudioTargetScope;", "", "CURRENT_PAGE_AND_FLOATING_AUDIO", "FLOATING_AUDIO_ONLY", "CURRENT_PAGE_ONLY", "NONE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalAudioTargetScope extends Enum<ExternalAudioTargetScope> {
    public static final ExternalAudioTargetScope CURRENT_PAGE_AND_FLOATING_AUDIO = null;
    public static final ExternalAudioTargetScope CURRENT_PAGE_ONLY = null;
    public static final ExternalAudioTargetScope FLOATING_AUDIO_ONLY = null;
    public static final ExternalAudioTargetScope NONE = null;
    public static final /* synthetic */ ExternalAudioTargetScope[] a = null;

    static {
        ExternalAudioTargetScope r1 = new ExternalAudioTargetScope("CURRENT_PAGE_AND_FLOATING_AUDIO", 0);
        CURRENT_PAGE_AND_FLOATING_AUDIO = r1;
        ExternalAudioTargetScope r2 = new ExternalAudioTargetScope("FLOATING_AUDIO_ONLY", 1);
        FLOATING_AUDIO_ONLY = r2;
        ExternalAudioTargetScope r3 = new ExternalAudioTargetScope("CURRENT_PAGE_ONLY", 2);
        CURRENT_PAGE_ONLY = r3;
        ExternalAudioTargetScope r4 = new ExternalAudioTargetScope("NONE", 3);
        NONE = r4;
        a = new ExternalAudioTargetScope[]{r1, r2, r3, r4};
    }

    public static ExternalAudioTargetScope valueOf(String r1) {
        return (ExternalAudioTargetScope) r27.a.a(ExternalAudioTargetScope.class, r1);
    }

    public static ExternalAudioTargetScope[] values() {
        return (ExternalAudioTargetScope[]) a.clone();
    }

    public ExternalAudioTargetScope(String r1, int r2) {
        super(r1, r2);
    }
}
