package com.bytedance.live.livelink.kmp.impl.base.params.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import gj6.a;
import gj6.b;
import gj6.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/RtcExtInfoRootSerializableObjectImpl;", "Lgj6/e;", "", "rtcBusinessId", "Ljava/lang/String;", "getRtcBusinessId", "()Ljava/lang/String;", "Lgj6/a;", "liveRtcEngineConfig", "Lgj6/a;", "getLiveRtcEngineConfig", "()Lgj6/a;", "Lgj6/b;", "liveRtcVideoParam", "Lgj6/b;", "getLiveRtcVideoParam", "()Lgj6/b;", "<init>", "()V", "Adapter", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RtcExtInfoRootSerializableObjectImpl implements e {

    @SerializedName("live_rtc_engine_config")
    private final a liveRtcEngineConfig;

    @SerializedName("live_rtc_video_param")
    private final b liveRtcVideoParam;

    @SerializedName("rtc_business_id")
    private final String rtcBusinessId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/RtcExtInfoRootSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RtcExtInfoRootSerializableObjectImpl.class);
        }
    }

    public RtcExtInfoRootSerializableObjectImpl() {
        this.rtcBusinessId = "";
        this.liveRtcEngineConfig = (a) d.c(a.class);
        this.liveRtcVideoParam = (b) d.c(b.class);
    }
}
