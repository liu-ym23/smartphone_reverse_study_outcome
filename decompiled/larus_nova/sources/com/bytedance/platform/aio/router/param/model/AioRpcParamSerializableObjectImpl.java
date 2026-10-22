package com.bytedance.platform.aio.router.param.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import k57.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioRpcParamSerializableObjectImpl;", "Lk57/f;", "", "rpcName", "Ljava/lang/String;", "o0", "()Ljava/lang/String;", "setRpcName", "(Ljava/lang/String;)V", "source", "getSource", "valueFrom", "P6", "type", "getType", "<init>", "()V", "Adapter", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioRpcParamSerializableObjectImpl implements f {

    @SerializedName("rpc_name")
    private String rpcName;

    @SerializedName("source")
    private final String source;

    @SerializedName("type")
    private final String type;

    @SerializedName("value_from")
    private final String valueFrom;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioRpcParamSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioRpcParamSerializableObjectImpl.class);
        }
    }

    public AioRpcParamSerializableObjectImpl() {
        this.rpcName = "";
        this.source = "";
        this.valueFrom = "";
        this.type = "";
    }

    @Override // k57.e
    public final String P6() {
        return this.valueFrom;
    }

    @Override // k57.f
    public final String getSource() {
        return this.source;
    }

    @Override // k57.f, k57.e
    public final String getType() {
        return this.type;
    }

    @Override // k57.f
    public final String o0() {
        return this.rpcName;
    }
}
