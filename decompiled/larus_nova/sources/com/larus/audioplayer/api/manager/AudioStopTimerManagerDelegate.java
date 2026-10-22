package com.larus.audioplayer.api.manager;

import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J#\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/audioplayer/api/manager/AudioStopTimerManagerDelegate;", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "<init>", "()V", "disablerStopTimer", "", "scene", "", "enableStopTimer", "", "duration", "", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "getStopTime", "(Ljava/lang/String;)Ljava/lang/Long;", "getSupportedSceneList", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioStopTimerManagerDelegate implements IAudioStopTimerManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AudioStopTimerManagerDelegate f290173b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAudioStopTimerManager f290174a;

    static {
        f290173b = new AudioStopTimerManagerDelegate();
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final List<String> a() {
        return this.f290174a.a();
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final Long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return this.f290174a.b(r100);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return this.f290174a.c(r100);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final void d(String r100, long r101, SetAudioStopTimerMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f290174a.d(r100, r101, r102);
    }

    private AudioStopTimerManagerDelegate() {
        IAudioStopTimerManager r100 = (IAudioStopTimerManager) ServiceManager.get().getService(IAudioStopTimerManager.class);
        if (r100 != null) goto L5;
        r100 = NoopAudioStopTimerManager.f290175a;
    L5:
        this.f290174a = r100;
    }
}
