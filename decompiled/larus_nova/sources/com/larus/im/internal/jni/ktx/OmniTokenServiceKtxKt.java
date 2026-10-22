package com.larus.im.internal.jni.ktx;

import com.larus.im.internal.delegate.b;
import com.larus.im.internal.jni.NativeAVSDK;
import com.larus.im.internal.jni.service.NativeAudioPlatformSettings;
import com.larus.im.internal.jni.service.OmniMediaService;
import com.larus.im.internal.jni.service.OmniRtcEnginePoolService;
import com.larus.im.internal.jni.service.OmniTokenService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"omniAVSDK", "Lcom/larus/im/internal/jni/NativeAVSDK;", "getOmniAVSDK", "()Lcom/larus/im/internal/jni/NativeAVSDK;", "omniMediaService", "Lcom/larus/im/internal/jni/service/OmniMediaService;", "getOmniMediaService", "()Lcom/larus/im/internal/jni/service/OmniMediaService;", "omniTokenService", "Lcom/larus/im/internal/jni/service/OmniTokenService;", "getOmniTokenService", "()Lcom/larus/im/internal/jni/service/OmniTokenService;", "omniEngineService", "Lcom/larus/im/internal/jni/service/OmniRtcEnginePoolService;", "getOmniEngineService", "()Lcom/larus/im/internal/jni/service/OmniRtcEnginePoolService;", "omniPlatformSettings", "Lcom/larus/im/internal/jni/service/NativeAudioPlatformSettings;", "getOmniPlatformSettings", "()Lcom/larus/im/internal/jni/service/NativeAudioPlatformSettings;", "omnisdk-av_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniTokenServiceKtxKt {
    private static final NativeAVSDK getOmniAVSDK() {
        return NativeAVSDK.Companion.getOrCreateAVSDK(b.f348193b.getUserId());
    }

    public static final OmniRtcEnginePoolService getOmniEngineService() {
        return getOmniAVSDK().getRtcEnginePoolService();
    }

    public static final OmniMediaService getOmniMediaService() {
        return getOmniAVSDK().getMediaService();
    }

    public static final NativeAudioPlatformSettings getOmniPlatformSettings() {
        return getOmniAVSDK().getPlatformSettings();
    }

    public static final OmniTokenService getOmniTokenService() {
        return getOmniAVSDK().getOmniTokenService();
    }
}
