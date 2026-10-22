package com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(AudioEncodeConfigModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/multilink/update/a;", "Lvh7/j;", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a$a, reason: collision with other inner class name */
    @JsonAdapter(AudioEncodeConfigModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C3626a {
    }

    @FieldName(name = "use_dtx")
    int H1();

    @FieldName(name = "enc_mode")
    int I3();

    @FieldName(name = "enc_channel")
    int N0();

    @FieldName(name = TTVideoEngineInterface.PLAY_API_KEY_CODEC)
    int S3();

    @FieldName(name = SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
    int getSampleRate();

    @FieldName(name = "enc_packet_size")
    int i0();

    @FieldName(name = "enc_bitrate")
    int r4();

    @FieldName(name = "use_inband_fec")
    int z4();
}
