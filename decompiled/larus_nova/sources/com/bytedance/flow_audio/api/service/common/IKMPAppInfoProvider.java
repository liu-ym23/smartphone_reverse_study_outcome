package com.bytedance.flow_audio.api.service.common;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/IKMPAppInfoProvider;", "Lcom/bytedance/kmp/spi/IKmpService;", "isAppBackground", "", "isAppPaused", "enableTtsWhenAppPaused", "currentActivity", "", "getCurrentNetworkStatusValue", "", "()Ljava/lang/Integer;", "enableAudioPlayerFlushWithSilence", "enableAudioPlayerTimeoutCheck", "useSafeAudioTrackEnable", "isDebugOrTestChannel", "isObricFeatureEnable", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKMPAppInfoProvider extends a {
    boolean a();

    Object currentActivity();

    boolean e();

    boolean enableAudioPlayerFlushWithSilence();

    boolean enableAudioPlayerTimeoutCheck();

    boolean g();

    boolean isAppBackground();

    boolean isAppPaused();

    Integer o();

    boolean useSafeAudioTrackEnable();
}
