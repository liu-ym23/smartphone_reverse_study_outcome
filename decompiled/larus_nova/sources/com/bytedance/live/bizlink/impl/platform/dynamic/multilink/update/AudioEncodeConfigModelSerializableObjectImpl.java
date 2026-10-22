package com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/multilink/update/AudioEncodeConfigModelSerializableObjectImpl;", "Lcom/bytedance/live/bizlink/impl/platform/dynamic/multilink/update/a;", "", "encPacketSize", "I", "i0", "()I", "encBitrate", "r4", "encChannel", "N0", "useInbandFec", "z4", "useDtx", "H1", "codecType", "S3", "encMode", "I3", "sampleRate", "getSampleRate", "<init>", "()V", "Adapter", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioEncodeConfigModelSerializableObjectImpl implements a {

    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_CODEC)
    private final int codecType;

    @SerializedName("enc_bitrate")
    private final int encBitrate;

    @SerializedName("enc_channel")
    private final int encChannel;

    @SerializedName("enc_mode")
    private final int encMode;

    @SerializedName("enc_packet_size")
    private final int encPacketSize;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
    private final int sampleRate;

    @SerializedName("use_dtx")
    private final int useDtx;

    @SerializedName("use_inband_fec")
    private final int useInbandFec;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/multilink/update/AudioEncodeConfigModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AudioEncodeConfigModelSerializableObjectImpl.class);
        }
    }

    public AudioEncodeConfigModelSerializableObjectImpl() {
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int H1() {
        return this.useDtx;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int I3() {
        return this.encMode;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int N0() {
        return this.encChannel;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int S3() {
        return this.codecType;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int i0() {
        return this.encPacketSize;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int r4() {
        return this.encBitrate;
    }

    @Override // com.bytedance.live.bizlink.impl.platform.dynamic.multilink.update.a
    public final int z4() {
        return this.useInbandFec;
    }
}
