package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamAudioProfile extends Enum<MixedStreamAudioProfile> {
    private static final /* synthetic */ MixedStreamAudioProfile[] $VALUES = null;
    public static final MixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_HEV1 = null;
    public static final MixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_HEV2 = null;
    public static final MixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_LC = null;
    private String aacProfile;

    static {
        MixedStreamAudioProfile r100 = new MixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_LC", 0, "LC");
        MIXED_STREAM_AUDIO_PROFILE_LC = r100;
        MixedStreamAudioProfile r101 = new MixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_HEV1", 1, "HEv1");
        MIXED_STREAM_AUDIO_PROFILE_HEV1 = r101;
        MixedStreamAudioProfile r102 = new MixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_HEV2", 2, "HEv2");
        MIXED_STREAM_AUDIO_PROFILE_HEV2 = r102;
        $VALUES = new MixedStreamAudioProfile[]{r100, r101, r102};
    }

    public static MixedStreamAudioProfile[] values() {
        return (MixedStreamAudioProfile[]) $VALUES.clone();
    }

    public String getValue() {
        return this.aacProfile;
    }

    public static MixedStreamAudioProfile valueOf(String r100) {
        return (MixedStreamAudioProfile) a.a(MixedStreamAudioProfile.class, r100);
    }

    private MixedStreamAudioProfile(String r100, int r101, String r102) {
        super(r100, r101);
        this.aacProfile = r102;
    }
}
