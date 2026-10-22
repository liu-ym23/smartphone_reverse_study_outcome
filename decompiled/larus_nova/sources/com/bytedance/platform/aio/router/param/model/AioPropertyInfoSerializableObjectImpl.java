package com.bytedance.platform.aio.router.param.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import k57.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioPropertyInfoSerializableObjectImpl;", "Lk57/d;", "", "valueFrom", "Ljava/lang/String;", "P6", "()Ljava/lang/String;", "type", "getType", "<init>", "()V", "Adapter", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioPropertyInfoSerializableObjectImpl implements d {

    @SerializedName("type")
    private final String type;

    @SerializedName("value_from")
    private final String valueFrom;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioPropertyInfoSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioPropertyInfoSerializableObjectImpl.class);
        }
    }

    public AioPropertyInfoSerializableObjectImpl() {
        this.valueFrom = "";
        this.type = "";
    }

    @Override // k57.e
    public final String P6() {
        return this.valueFrom;
    }

    @Override // k57.d, k57.e
    public final String getType() {
        return this.type;
    }
}
