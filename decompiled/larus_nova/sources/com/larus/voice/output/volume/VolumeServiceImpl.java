package com.larus.voice.output.volume;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/voice/output/volume/VolumeServiceImpl;", "Lcom/larus/voice/output/volume/IVolumeService;", "<init>", "()V", "init", "", "onPlayTriggered", "scene", "", "extra", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VolumeServiceImpl implements IVolumeService {
    public VolumeServiceImpl() {
    }

    @Override // com.larus.voice.output.volume.IVolumeService
    public final void init() {
        d r100 = d.f376040a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[init]...");
        d.f(new b());
        d.f(new i());
        d.f(new m());
        GlobalAudioObserver.f289772a.b(r100);
    }

    @Override // com.larus.voice.output.volume.IVolumeService
    public final void a(Map r100) {
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.TTS_REAL_TIME_CALL, "scene");
        d r101 = d.f376040a;
        d.e(GlobalAudioSceneEnum.TTS_REAL_TIME_CALL, r100);
    }
}
