package com.ss.bytedance.ies.audiorecord.api;

import com.ss.android.ugc.aweme.framework.services.dyext.annotation.DouyinImpl;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/IAudioEffectService;", "", "processAudioPCM", "Ljava/nio/ByteBuffer;", "buffer", "sampleRate", "", "channel", "samplesPerChannel", "release", "", "setTuningEffect", "effectFile", "", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
@DouyinImpl(plugin = "com.ss.android.ugc.aweme.iesvideoclip")
public interface IAudioEffectService {
    ByteBuffer processAudioPCM(ByteBuffer r100, int r101, int r102, int r103);

    void release();

    void setTuningEffect(String r100);
}
