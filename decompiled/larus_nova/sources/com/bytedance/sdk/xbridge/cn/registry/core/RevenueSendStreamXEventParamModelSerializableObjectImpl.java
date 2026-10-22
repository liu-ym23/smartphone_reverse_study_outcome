package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import me7.m;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/RevenueSendStreamXEventParamModelSerializableObjectImpl;", "Lme7/m;", "", "event", "Ljava/lang/Integer;", "getEvent", "()Ljava/lang/Integer;", "setEvent", "(Ljava/lang/Integer;)V", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "", "rtcKey", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "setRtcKey", "(Ljava/lang/String;)V", "layoutKey", "c", "setLayoutKey", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueSendStreamXEventParamModelSerializableObjectImpl implements m {

    @SerializedName("event")
    private Integer event;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("layoutKey")
    private String layoutKey;

    @SerializedName("rtcKey")
    private String rtcKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/RevenueSendStreamXEventParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueSendStreamXEventParamModelSerializableObjectImpl.class);
        }
    }

    public RevenueSendStreamXEventParamModelSerializableObjectImpl() {
    }

    @Override // me7.m
    public final String G() {
        return this.rtcKey;
    }

    @Override // me7.m
    public final String c() {
        return this.layoutKey;
    }

    @Override // me7.m
    public final Integer getEvent() {
        return this.event;
    }

    @Override // me7.m
    public final JsonObject getExtra() {
        return this.extra;
    }
}
