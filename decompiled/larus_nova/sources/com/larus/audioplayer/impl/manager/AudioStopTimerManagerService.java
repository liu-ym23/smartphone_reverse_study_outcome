package com.larus.audioplayer.impl.manager;

import android.os.Handler;
import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.api.manager.IAudioStopTimerManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/audioplayer/impl/manager/AudioStopTimerManagerService;", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "<init>", "()V", "getSupportedSceneList", "", "", "getStopTime", "", "scene", "(Ljava/lang/String;)Ljava/lang/Long;", "enableStopTimer", "", "duration", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "disablerStopTimer", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioStopTimerManagerService implements IAudioStopTimerManager {
    public AudioStopTimerManagerService() {
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final List<String> a() {
        Handler r100 = a.f290210a;
        return CollectionsKt.listOf(new String[]{GlobalAudioSceneEnum.PLUGIN_MUSIC, "plugin_background_audio", GlobalAudioSceneEnum.PODCAST, "news", GlobalAudioSceneEnum.QQ_MUSIC});
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final Long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Handler r101 = a.f290210a;
        Intrinsics.checkNotNullParameter(r100, "scene");
        a.RunnableC3971a r102 = a.f290211b.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f290214c;
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return a.a(r100);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final void d(String r100, long r101, SetAudioStopTimerMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Handler r103 = a.f290210a;
        Intrinsics.checkNotNullParameter(r100, "scene");
        a.a(r100);
        a.RunnableC3971a r104 = new a.RunnableC3971a(r100, r102);
        a.f290211b.put(r100, r104);
        r104.f290214c = Long.valueOf(System.currentTimeMillis() + r101);
        a.f290210a.postDelayed(r104, r101);
    }
}
