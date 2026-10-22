package com.bytedance.platform.aio.router.param.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import k57.c;
import k57.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioInitialRpcInfoSerializableObjectImpl;", "Lk57/c;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "Lk57/f;", "paramNames", "Ljava/util/List;", "P3", "()Ljava/util/List;", "<init>", "()V", "Adapter", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioInitialRpcInfoSerializableObjectImpl implements c {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f266608id;

    @SerializedName("param_names")
    private final List<f> paramNames;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/platform/aio/router/param/model/AioInitialRpcInfoSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioInitialRpcInfoSerializableObjectImpl.class);
        }
    }

    public AioInitialRpcInfoSerializableObjectImpl() {
        this.f266608id = "";
        this.paramNames = d.a();
    }

    @Override // k57.c
    public final List<f> P3() {
        return this.paramNames;
    }

    @Override // k57.c
    public final String getId() {
        return this.f266608id;
    }
}
