package com.bytedance.live.livelink.kmp.impl.base.params.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import gj6.b;
import gj6.f;
import gj6.g;
import gj6.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/LiveRtcVideoParamSerializableObjectImpl;", "Lgj6/b;", "", "rtcVideoParamMode", "I", "getRtcVideoParamMode", "()I", "Lgj6/i;", "rtcVideoParamServerDefine", "Lgj6/i;", "getRtcVideoParamServerDefine", "()Lgj6/i;", "rtcVideoParam1v1Client", "getRtcVideoParam1v1Client", "rtcVideoParam1v1Server", "getRtcVideoParam1v1Server", "Lgj6/f;", "rtcMixParam", "Lgj6/f;", "getRtcMixParam", "()Lgj6/f;", "Lgj6/g;", "rtcPerformanceProfiles", "Lgj6/g;", "getRtcPerformanceProfiles", "()Lgj6/g;", "<init>", "()V", "Adapter", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRtcVideoParamSerializableObjectImpl implements b {

    @SerializedName("rtc_mix_param")
    private final f rtcMixParam;

    @SerializedName("rtc_performance_profiles")
    private final g rtcPerformanceProfiles;

    @SerializedName("rtc_video_param_1v1_client")
    private final i rtcVideoParam1v1Client;

    @SerializedName("rtc_video_param_1v1_server")
    private final i rtcVideoParam1v1Server;

    @SerializedName("rtc_video_param_mode")
    private final int rtcVideoParamMode;

    @SerializedName("rtc_video_param_server_define")
    private final i rtcVideoParamServerDefine;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/LiveRtcVideoParamSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveRtcVideoParamSerializableObjectImpl.class);
        }
    }

    public LiveRtcVideoParamSerializableObjectImpl() {
        this.rtcVideoParamServerDefine = (i) d.c(i.class);
        this.rtcVideoParam1v1Client = (i) d.c(i.class);
        this.rtcVideoParam1v1Server = (i) d.c(i.class);
        this.rtcMixParam = (f) d.c(f.class);
        this.rtcPerformanceProfiles = (g) d.c(g.class);
    }
}
