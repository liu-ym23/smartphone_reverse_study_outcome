package com.larus.audio.flow.client.kmp_com.service;

import com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider;
import kotlin.Metadata;
import m58.b;
import m58.h;
import m58.o;
import m58.t;
import m58.w;
import x58.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\r\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/service/FlowAudioKmpAppInfoProvider;", "Lcom/bytedance/flow_audio/api/service/common/IKMPAppInfoProvider;", "<init>", "()V", "currentActivity", "", "enableTtsWhenAppPaused", "", "isAppBackground", "isAppPaused", "getCurrentNetworkStatusValue", "", "()Ljava/lang/Integer;", "enableAudioPlayerFlushWithSilence", "enableAudioPlayerTimeoutCheck", "useSafeAudioTrackEnable", "isDebugOrTestChannel", "isObricFeatureEnable", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAudioKmpAppInfoProvider implements IKMPAppInfoProvider {
    public FlowAudioKmpAppInfoProvider() {
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean a() {
        a r100 = h.f512130a;
        b r101 = h.f512140k;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final Object currentActivity() {
        a r100 = h.f512130a;
        b r101 = h.f512140k;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.currentActivity();
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean e() {
        a r100 = h.f512130a;
        o r101 = h.f512143n;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.e() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean enableAudioPlayerFlushWithSilence() {
        a r100 = h.f512130a;
        t r101 = h.f512142m;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.enableAudioPlayerFlushWithSilence() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean enableAudioPlayerTimeoutCheck() {
        a r100 = h.f512130a;
        t r101 = h.f512142m;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.enableAudioPlayerTimeoutCheck() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean g() {
        a r100 = h.f512130a;
        b r101 = h.f512140k;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.g() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean isAppBackground() {
        a r100 = h.f512130a;
        b r101 = h.f512140k;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isAppBackground() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean isAppPaused() {
        a r100 = h.f512130a;
        b r101 = h.f512140k;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isAppPaused() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final Integer o() {
        a r100 = h.f512130a;
        w r101 = h.f512135f;
        if (r101 == null) goto L5;
        int r102 = r101.o();
    L7:
        return Integer.valueOf(r102);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider
    public final boolean useSafeAudioTrackEnable() {
        a r100 = h.f512130a;
        t r101 = h.f512142m;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.useSafeAudioTrackEnable() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
