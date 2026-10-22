package com.bytedance.live.livelink.kmp.impl.base.params.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import gj6.g;
import gj6.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/RtcPerformanceProfilesSerializableObjectImpl;", "Lgj6/g;", "Lgj6/i;", "rtcPerformanceLow", "Lgj6/i;", "getRtcPerformanceLow", "()Lgj6/i;", "<init>", "()V", "Adapter", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RtcPerformanceProfilesSerializableObjectImpl implements g {

    @SerializedName("rtc_performance_low")
    private final i rtcPerformanceLow;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/params/model/RtcPerformanceProfilesSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RtcPerformanceProfilesSerializableObjectImpl.class);
        }
    }

    public RtcPerformanceProfilesSerializableObjectImpl() {
        this.rtcPerformanceLow = (i) d.c(i.class);
    }
}
