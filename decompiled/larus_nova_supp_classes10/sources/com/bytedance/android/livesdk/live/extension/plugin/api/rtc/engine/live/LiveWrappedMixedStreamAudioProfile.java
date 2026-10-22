package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamAudioProfile;", "", "", "<set-?>", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MIXED_STREAM_AUDIO_PROFILE_LC", "MIXED_STREAM_AUDIO_PROFILE_HEV1", "MIXED_STREAM_AUDIO_PROFILE_HEV2", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamAudioProfile extends Enum<LiveWrappedMixedStreamAudioProfile> {
    public static final LiveWrappedMixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_HEV1 = null;
    public static final LiveWrappedMixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_HEV2 = null;
    public static final LiveWrappedMixedStreamAudioProfile MIXED_STREAM_AUDIO_PROFILE_LC = null;
    public static final /* synthetic */ LiveWrappedMixedStreamAudioProfile[] a = null;
    private String value;

    static {
        LiveWrappedMixedStreamAudioProfile r1 = new LiveWrappedMixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_LC", 0, "LC");
        MIXED_STREAM_AUDIO_PROFILE_LC = r1;
        LiveWrappedMixedStreamAudioProfile r2 = new LiveWrappedMixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_HEV1", 1, "HEv1");
        MIXED_STREAM_AUDIO_PROFILE_HEV1 = r2;
        LiveWrappedMixedStreamAudioProfile r3 = new LiveWrappedMixedStreamAudioProfile("MIXED_STREAM_AUDIO_PROFILE_HEV2", 2, "HEv2");
        MIXED_STREAM_AUDIO_PROFILE_HEV2 = r3;
        a = new LiveWrappedMixedStreamAudioProfile[]{r1, r2, r3};
    }

    public static LiveWrappedMixedStreamAudioProfile valueOf(String r1) {
        return (LiveWrappedMixedStreamAudioProfile) a.a(LiveWrappedMixedStreamAudioProfile.class, r1);
    }

    public static LiveWrappedMixedStreamAudioProfile[] values() {
        return (LiveWrappedMixedStreamAudioProfile[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamAudioProfile(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
