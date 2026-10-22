package com.bytedance.live.livelink.kmp.api.core.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/AudioProfile;", "", "LC", "HE", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioProfile extends Enum<AudioProfile> {
    public static final AudioProfile HE = null;
    public static final AudioProfile LC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioProfile[] f255231a = null;

    static {
        AudioProfile r100 = new AudioProfile("LC", 0);
        LC = r100;
        AudioProfile r101 = new AudioProfile("HE", 1);
        HE = r101;
        f255231a = new AudioProfile[]{r100, r101};
    }

    public static AudioProfile valueOf(String r100) {
        return (AudioProfile) a.a(AudioProfile.class, r100);
    }

    public static AudioProfile[] values() {
        return (AudioProfile[]) f255231a.clone();
    }

    public AudioProfile(String r100, int r101) {
        super(r100, r101);
    }
}
