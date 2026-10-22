package com.bytedance.flow_audio.api.service.common;

import com.bytedance.flow_audio.impl.business.asr.viewModel.g;
import kotlin.Metadata;
import pd6.a;
import xw5.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000  2\u00020\u0001:\u0001 J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH&J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH&R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneService;", "Lcom/bytedance/kmp/spi/IKmpService;", "activate", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneActivationResult;", "scene", "", "options", "", "listener", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneListener;", "activateAsync", "", "completion", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneActivationCallback;", "update", "type", "deactivate", "addBroadcastListener", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneBroadcastListener;", "removeBroadcastListener", "broadcast", "event", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneBroadcastEvent;", "getResource", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneResource;", "activeScenes", "", "validActiveScenes", "activeExternalScenes", "isOtherAudioPlaying", "", "()Z", "Companion", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKMPFlowAudioSceneService extends a {
    void L2(String r100, int r101, g r102);

    f m0(String r100);

    void s(xw5.g r100);

    void update(String r100, String r101, int r102);
}
